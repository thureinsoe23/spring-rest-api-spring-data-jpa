package com.example.restapi.DAO;

import com.example.restapi.Entity.Teacher;

import java.util.List;

public interface TeacherDAOInterface {

    public List<Teacher> findAll();
    public Teacher findById(int id);
    public Teacher update(Teacher teacher);
    public void deleteById(int id);
}
