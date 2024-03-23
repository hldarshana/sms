package com.example.sms.repository;

import com.example.sms.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentsRepository extends MongoRepository<Student, String> {

    Optional<Student> findOneByRecordId(String recordId);

}
