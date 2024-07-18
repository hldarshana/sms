package com.example.sms.service;

import com.example.sms.shared.dto.StudentDto;
import com.example.sms.shared.model.PagedRequest;
import com.example.sms.validation.OnCreate;
import com.example.sms.validation.OnUpdate;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;

@Validated
public interface StudentsService {

    Page<StudentDto> getPage(PagedRequest request);

    StudentDto get(String recordId);

    @Validated(OnCreate.class)
    StudentDto create(@Valid StudentDto dto);

    @Validated(OnUpdate.class)
    StudentDto update(String recordId, @Valid StudentDto dto);

    void delete(String recordId);
}
