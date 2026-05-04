package com.example.restapi.Service;

import com.example.restapi.Entity.Teacher;

import java.util.List;

public interface TeacherServiceInterface {

    List<Teacher> findAll();
    Teacher findById(int id);
    Teacher update(Teacher teacher);
    void deleteById(int id);
}
