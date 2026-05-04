package com.example.restapi.REST;

import com.example.restapi.DAO.TeacherDAOInterface;
import com.example.restapi.Entity.Teacher;
import com.example.restapi.Service.TeacherService;
import com.example.restapi.Service.TeacherServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {

    private TeacherServiceInterface teacherService;

    @Autowired
    public TeacherController(TeacherServiceInterface teacherServiceInterface){
        this.teacherService = teacherServiceInterface;
    }

    @GetMapping("/teachers")
    public List<Teacher> findAll(){
        return teacherService.findAll();
    }

    @GetMapping("/teacher/{teacherId}")
    public Teacher findById(@PathVariable int teacherId){
        Teacher teacher =  teacherService.findById(teacherId);
        if (teacher == null){
            throw new RuntimeException("Teacher id not found: " + teacherId);
        }
        return teacher;
    }

    @PostMapping("/teachers")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        teacher.setId(0);
        return teacherService.update(teacher);
    }

    @PutMapping("/teachers")
    public Teacher updateTeacher(@RequestBody Teacher teacher){
        Teacher teacherDB = teacherService.update(teacher);
        return teacherDB;
    }

    @DeleteMapping("/teacher/{teacherId}")
    public String deleteTeacher(@PathVariable int teacherId){
        Teacher teacherDB = teacherService.findById(teacherId);
        if (teacherDB == null){
            throw new RuntimeException("Teacher ID not found: " + teacherId);
        }
        teacherService.deleteById(teacherId);
        return "Deleted Teacher Id: "+ teacherId;
    }
}
