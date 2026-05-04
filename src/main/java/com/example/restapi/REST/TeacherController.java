package com.example.restapi.REST;

import com.example.restapi.DAO.TeacherDAOInterface;
import com.example.restapi.Entity.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {

    private TeacherDAOInterface teacherDAO;

    public TeacherController(TeacherDAOInterface tDAO){
        teacherDAO = tDAO;
    }

    @GetMapping("/teachers")
    public List<Teacher> findAll(){
        return teacherDAO.findAll();
    }

}
