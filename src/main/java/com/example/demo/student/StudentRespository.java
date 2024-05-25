package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRespository extends JpaRepository<Student, Long> {
    @Query("" +
            "SELECT CASE WHEN COUNT(s) > 0 THEN " +
            "TRUE ELSE FALSE END" + "FROM Student s " +
            "WHERE s.email = ?1")
    boolean selectExistsEmail(String email);

    Optional<Student> findStudentByEmail(String email);
}
