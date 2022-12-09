package com.example.TrainingManagement.Repository;

import com.example.TrainingManagement.Models.Classsection;

import com.example.TrainingManagement.Models.Major;
import com.example.TrainingManagement.Models.SubjectMajor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface ClasssectionRepository extends JpaRepository<Classsection, Long> {
    public default Classsection getBySubjectMajor (SubjectMajor subjectMajor){
        ArrayList<Classsection> list = (ArrayList<Classsection>) this.findAll();
        ArrayList<Classsection> listRespon = new ArrayList<>();
        list.forEach(classsection -> {
            if(classsection.getSubjectMajor().equals(subjectMajor)){
                listRespon.add(classsection);
            }
        });
        return  listRespon.get(0);
    }
}
