package com.example.restapi.Service;

import com.example.restapi.DAO.TeacherDAOInterface;
import com.example.restapi.Entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements TeacherServiceInterface{

    private TeacherDAOInterface teacherDAO;

    @Autowired
    public TeacherService(TeacherDAOInterface tDAO){
        this.teacherDAO = tDAO;
    }


    @Override
    public List<Teacher> findAll() {
        return teacherDAO.findAll();
    }

    @Override
    public Teacher findById(int id) {
        return teacherDAO.findById(id);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return teacherDAO.update(teacher);
    }

    @Override
    public void deleteById(int id) {
        teacherDAO.deleteById(id);
    }
}
