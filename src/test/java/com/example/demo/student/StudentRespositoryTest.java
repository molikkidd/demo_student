package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static java.time.Month.NOVEMBER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentRespositoryTest {
    @Autowired
    private StudentRespository underTest;

    @Test
    void itShouldCheckStudentExistsByEmail() {
//    given
        String email = "jammy@gmails.com";
        Student student = new Student(
                "Jammy",
                email,
                LocalDate.of(1999, NOVEMBER, 11)
        );
        underTest.save(student);
//    when
        boolean expected = underTest.selectExistsEmail(email);
//    then
        assertThat(expected).isTrue();
    }
}