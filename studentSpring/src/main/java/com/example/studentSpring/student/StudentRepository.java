package com.example.studentSpring.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // for data access
public interface StudentRepository extends JpaRepository<Student,Long> {

    //to find student by their id
    //this "findStudentByEmail" is converted to sql query to retrive student by email  or
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}