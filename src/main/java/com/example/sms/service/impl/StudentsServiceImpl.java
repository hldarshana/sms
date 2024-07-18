package com.example.sms.service.impl;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentsRepository;
import com.example.sms.service.StudentsService;
import com.example.sms.shared.dto.StudentDto;
import com.example.sms.shared.model.PagedRequest;
import com.example.sms.shared.util.RandomUtils;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentsServiceImpl implements StudentsService {

    private final StudentsRepository studentsRepository;
    private final ModelMapper modelMapper;
    private final RandomUtils randomUtils;

    public StudentsServiceImpl(StudentsRepository studentsRepository, ModelMapper modelMapper, RandomUtils randomUtils){
        this.studentsRepository = studentsRepository;
        this.modelMapper = modelMapper;
        this.randomUtils = randomUtils;
    }

    /**
     * Get all student documents with server side pagination
     */
    @Override
    public Page<StudentDto> getPage(PagedRequest request) {

        Sort sort = Sort.by(request.getSortDirection(), request.getSortBy()).and(Sort.by(Sort.Direction.ASC, "recordId"));

        Pageable pageable = PageRequest.of(request.getPage(), request.getPageSize(), sort);

        Page<Student> resultPage = studentsRepository.findAll(pageable);

        return resultPage.map(entity -> modelMapper.map(entity,
                StudentDto.class));
    }

    /**
     * Get a single student document using recordId
     */
    @Override
    public StudentDto get(String recordId) {
        Student student = validateAndGetStudent(recordId);
        return modelMapper.map(student, StudentDto.class);
    }

    /**
     * Create the Student document
     */
    @Override
    public StudentDto create(StudentDto dto) {
        Student student = modelMapper.map(dto, Student.class);
        student.setRecordId(randomUtils.generateRandomId());
        student = studentsRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    /**
     * Updating the details coming from request and some field level validations are done in dto level.
     */
    @Override
    public StudentDto update(String recordId, StudentDto dto) {
        Student student = validateAndGetStudent(recordId);

        Student updatedStudent = modelMapper.map(dto, Student.class);
        updatedStudent.setId(student.getId());
        updatedStudent  = studentsRepository.save(updatedStudent);
        return modelMapper.map(updatedStudent, StudentDto.class);
    }

    /**
     * Currently just deleting the record from db. Can be enhanced to archive the record to different collection or
     * change an active status within document.
     */
    @Override
    public void delete(String recordId) {
        Student student = validateAndGetStudent(recordId);
        studentsRepository.deleteById(student.getId());
    }

    /**
     * Get the entity
     * @param recordId
     * @return
     */
    private Student validateAndGetStudent(String recordId){
        return studentsRepository.findOneByRecordId(recordId).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Student not found with id'" + recordId + "'"));
    }
}
