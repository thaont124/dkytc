package com.example.TrainingManagement.Controllers;

import com.example.TrainingManagement.Models.*;
import com.example.TrainingManagement.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.lang.Long;

@RestController
@RequestMapping(path = "/Subject", produces = "application/json")

public class SubjectsControllers {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectMajorRepository subjectMajorRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MajorRepository majorRepository;

    public SubjectsControllers(SubjectRepository subjectRepository, SubjectMajorRepository subjectMajorRepository, StudentRepository studentRepository, MajorRepository majorRepository) {
        this.subjectRepository = subjectRepository;
        this.subjectMajorRepository = subjectMajorRepository;
        this.studentRepository = studentRepository;
        this.majorRepository = majorRepository;
    }



//    @GetMapping("/SubjectByTermNow")
//    public Student GetAllStudentByTermNow(){
//        Student student = studentRepository.findAll().get(0);
//        String majorCode = student.getStudentCode().substring(5,7);
//        Major major = majorRepository.findBymajorCode(majorCode);
//        int year =5;
//        SubjectMajor subjectMajor= subjectMajorRepository.findByStartTermAndMajor(year, major);
//        return student;
//    }
    @GetMapping("/SubjectByTermNow")
    public List<Subject> GetAllSubjectByTermNow(){
        Student student = studentRepository.findAll().get(0);
        String studentCode = student.getStudentCode();
        String major_code = studentCode.substring(5,7);

        Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR)-2000- Integer.parseInt(studentCode.substring(1,3))*2;
        if (instance.get(Calendar.MONTH) > 8)
            year+=1;
        int startTerm = year;
        Major major = majorRepository.findBymajorCode(major_code);
        SubjectMajor subjectMajor = subjectMajorRepository.findByStartTermAndMajor(startTerm,major);
        Subject subjects = subjectRepository.findAll().get(0);
        return subjectRepository.findBySubjectMajor(subjectMajor);
    }
    @GetMapping("/SubjectBysubjectCode/{subjectCode}")
    public List<Subject> GetAllSubjectBySubjectCode(){

        Subject subject = subjectRepository.findAll().get(0);
        String subjectCode = subject.getSubjectCode();
        return subjectRepository.findBySubjectCode(subjectCode);
    }

}