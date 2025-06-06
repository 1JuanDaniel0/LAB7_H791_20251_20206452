package com.example.lab7.controller;

import com.example.lab7.entity.Alumno;
import com.example.lab7.repository.AlumnoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PrincipalController {
    final AlumnoRepository alumnoRepository;

    public PrincipalController(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    // Para listar
    @GetMapping(value = {"/lista", ""})
    public List<Alumno> listaAlumnos(){
        return alumnoRepository.findAll();
    }

    // Obtener
    @GetMapping(value = "/{id}")
    public ResponseEntity<HashMap<String, Object>> buscarAlumno(@PathVariable("id") String idStr){
        try {
            Long id = idStr.isEmpty() ? 0 : Long.parseLong(idStr);
            Optional<Alumno> byId = alumnoRepository.findById(id);

            HashMap<String, Object> respuesta = new HashMap<>();

            if (byId.isPresent()) {
                respuesta.put("result", "ok");
                respuesta.put("producto", byId.get());
            } else {
                respuesta.put("result", "no existe");
            }
            return ResponseEntity.ok(respuesta);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Crear un Alumno
    @PostMapping(value = "/alumno", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, Object>> crearAlumno(@RequestBody Alumno alumno){
        try {
            alumnoRepository.save(alumno);
            HashMap<String, Object> respuesta = new HashMap<>();
            respuesta.put("result", "ok");
            respuesta.put("producto", alumno);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Modificar un Alumno
    @PutMapping(value = {"", "/"}, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<HashMap<String, Object>> modificarAlumno(@RequestParam("id") String idStr,
                                                                   @RequestParam("nombres") String nombres,
                                                                   @RequestParam("apellidos") String apellidos,
                                                                   @RequestParam("dni") Integer dni,
                                                                   @RequestParam("codigo") Integer codigo,
                                                                   @RequestParam("fechaNacimiento") String fechaNacimiento,
                                                                   @RequestParam("sexo") Byte sexo,
                                                                   @RequestParam("correoInstitucional") String correoInstitucional,
                                                                   @RequestParam("correoPersonal") String correoPersonal,
                                                                   @RequestParam("telefono") String telefono,
                                                                   @RequestParam("direccion") String direccion,
                                                                   @RequestParam("departamento") String departamento,
                                                                   @RequestParam("provincia") String provincia,
                                                                   @RequestParam("carrera") String carrera){
        try {
            Long id = idStr.isEmpty() ? 0 : Long.parseLong(idStr);
            Alumno alumno = new Alumno();
            alumno.setId(id);
            alumno.setNombres(nombres);
            alumno.setApellidos(apellidos);
            alumno.setDni(dni);
            alumno.setCodigo(codigo);
            alumno.setDepartamento(departamento);
            alumno.setProvincia(provincia);
            alumno.setCarrera(carrera);
            alumno.setFechaNacimiento(Date.from(Instant.parse(fechaNacimiento)));
            alumno.setSexo(sexo);
            alumno.setCorreoInstitucional(correoInstitucional);
            alumno.setCorreoPersonal(correoPersonal);
            alumno.setTelefono(telefono);
            alumno.setDireccion(direccion);

            alumnoRepository.save(alumno);
            HashMap<String, Object> respuesta = new HashMap<>();
            respuesta.put("result", "ok");
            respuesta.put("producto", alumno);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
