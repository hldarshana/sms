package com.example.sms.shared.dto;

import com.example.sms.validation.OnCreate;
import com.example.sms.validation.OnUpdate;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class StudentDto {

    @NotNull(groups = OnUpdate.class, message = "Field 'recordId' cannot be null")
    @NotEmpty(groups = OnUpdate.class, message = "Field 'recordId' cannot be empty")
    private String recordId;

    @NotNull(groups = {OnCreate.class, OnUpdate.class}, message = "First Name cannot be null")
    @NotEmpty(groups = {OnCreate.class, OnUpdate.class}, message = "First Name name cannot be empty")
    private String firstName;

    private String lastName;

    private String address;

    /**
     * For this field, a custom annotation can be introduced with a validator to validate phone numbers.
     */
    private String telephone;

    @Min(value = 5, message = "Student age should be greater than 5")
    @Max(value = 18, message = "Student age should be greater than 18")
    private short age;

    @Min(value = 5, message = "Grade should be greater than 0")
    @Max(value = 13, message = "Grade should be lower than 13")
    private short grade;

    private LocalDate birthday;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public short getGrade() {
        return grade;
    }

    public void setGrade(short grade) {
        this.grade = grade;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
