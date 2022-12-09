package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.Major;
import com.example.TrainingManagement.Models.Subject;

import com.example.TrainingManagement.Models.SubjectMajor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    public default List<Subject> findBySubjectCode(String subjectCode){
        ArrayList<Subject> list = (ArrayList<Subject>) this.findAll();
        ArrayList<Subject> listRespon = new ArrayList<>();
        list.forEach(subject -> {
            if(subject.getSubjectCode().equals(subjectCode)){
                listRespon.add(subject);
            }
        });
        return  listRespon;
    }
    public default List<Subject> findBySubjectMajor(SubjectMajor subjectMajor){
        ArrayList<Subject> list = (ArrayList<Subject>) this.findAll();
        ArrayList<Subject> listRespon = new ArrayList<>();
        list.forEach(subject -> {
            if(subject.getSubjectMajor().equals(subjectMajor)){
                listRespon.add(subject);
            }
        });
        return listRespon;
    }
}