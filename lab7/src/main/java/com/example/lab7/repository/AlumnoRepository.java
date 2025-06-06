package com.example.lab7.repository;

import com.example.lab7.entity.Alumno;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
    Alumno findByDni(Integer dni);
}
