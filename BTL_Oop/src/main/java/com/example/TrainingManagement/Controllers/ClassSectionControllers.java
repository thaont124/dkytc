package com.example.TrainingManagement.Controllers;

import com.example.TrainingManagement.Models.*;
import com.example.TrainingManagement.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassSectionControllers {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TermRepository termRepository;
    @Autowired
    private ClasssectionStudentRepository classsectionStudentRepository;
    @Autowired
    private SubjectMajorRepository subjectMajorRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private ClasssectionRepository classsectionRepository;

    public ClassSectionControllers( ClasssectionRepository classsectionRepository, TeacherRepository teacherRepository, TermRepository termRepository, ClasssectionStudentRepository classsectionStudentRepository, SubjectMajorRepository subjectMajorRepository, ScheduleRepository scheduleRepository) {
        this.classsectionRepository = classsectionRepository;
        this.teacherRepository = teacherRepository;
        this.termRepository = termRepository;
        this.classsectionStudentRepository = classsectionStudentRepository;
        this.subjectMajorRepository = subjectMajorRepository;
        this.scheduleRepository = scheduleRepository;
    }

    //public Classsection getSectionClassDetail(){    }
}
