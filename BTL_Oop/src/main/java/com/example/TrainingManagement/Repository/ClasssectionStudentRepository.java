package com.example.TrainingManagement.Repository;


import com.example.TrainingManagement.Models.ClasssectionStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClasssectionStudentRepository extends JpaRepository<ClasssectionStudent, Long> {
}