package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.Student;
import com.example.TrainingManagement.Models.Studytime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}