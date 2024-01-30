package com.crud.crud.servicio;

import com.crud.crud.entidad.Estudiante;

import java.util.List;

public interface EstudianteServicio {

    public List <Estudiante> listarEstudiantes();

    public Estudiante guardarEstudiante(Estudiante estudiante);

    public Estudiante mostrarPorId(Long id);

    public Estudiante editarEstudiante (Estudiante estudiante);
    public void eliminarEstudiante(Long id);
}
