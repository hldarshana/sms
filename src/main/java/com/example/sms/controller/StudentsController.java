package com.example.sms.controller;

import com.example.sms.service.StudentsService;
import com.example.sms.shared.dto.StudentDto;
import com.example.sms.shared.model.ApiResponse;
import com.example.sms.shared.model.PagedRequest;
import com.example.sms.shared.model.PagedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/students")
public class StudentsController {

    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService){
        this.studentsService = studentsService;
    }

    @GetMapping()
    public ApiResponse<?> getAll(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "24") int pageSize,
                                 @RequestParam(defaultValue = "firstName") String sortBy,
                                 @RequestParam(defaultValue = "ASC") Sort.Direction sortDirection){
        Page<StudentDto> result = studentsService.getPage(new PagedRequest(page, pageSize, sortBy, sortDirection));
        PagedResponse<StudentDto> pagedResponse = new PagedResponse<>(result, sortBy, sortDirection.toString());
        return new ApiResponse<>(pagedResponse).success();
    }

    @GetMapping(value = "/{id}")
    public ApiResponse<StudentDto> get(@PathVariable String id){
        StudentDto studentDto = studentsService.get(id);
        return new ApiResponse<>(studentDto).success();
    }

    @PostMapping()
    public ApiResponse<StudentDto> create(@RequestBody StudentDto dto){
        StudentDto studentDto = studentsService.create(dto);
        return new ApiResponse<>(studentDto).success();
    }

    @PutMapping(value = "/{id}")
    public ApiResponse<StudentDto> update(@PathVariable String id, @RequestBody StudentDto dto){
        StudentDto studentDto = studentsService.update(id, dto);
        return new ApiResponse<>(studentDto).success();
    }

    @DeleteMapping(value = "/{id}")
    public ApiResponse<String> delete(@PathVariable String id){
        studentsService.delete(id);
        return new ApiResponse<>("SUCCESS").success();
    }
}
