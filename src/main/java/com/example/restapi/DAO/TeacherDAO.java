package com.example.restapi.DAO;

import com.example.restapi.Entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAO implements TeacherDAOInterface{

    private EntityManager entityManager;

    @Autowired
    public TeacherDAO(EntityManager em){
        entityManager = em;
    }

    @Override
    public List<Teacher> findAll() {
        TypedQuery<Teacher> query = entityManager.createQuery("from Teacher", Teacher.class);
        List<Teacher> teachers = query.getResultList();
        return teachers;
    }
}
