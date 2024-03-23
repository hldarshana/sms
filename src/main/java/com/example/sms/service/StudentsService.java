package com.example.sms.service;

import com.example.sms.shared.dto.StudentDto;
import com.example.sms.shared.model.PagedRequest;
import com.example.sms.validation.OnCreate;
import com.example.sms.validation.OnUpdate;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;

/**
 * This interface provides crud operations for Student collection. These operations can be added to a generic
 * interface and extend that interface here would be another option.
 */
public interface StudentsService {

    Page<StudentDto> getPage(PagedRequest request);

    StudentDto get(String recordId);

    @Validated(OnCreate.class)
    StudentDto create(StudentDto dto);

    @Validated(OnUpdate.class)
    StudentDto update(StudentDto dto);

    void delete(String recordId);
}
