package com.crud.crud.servicio;

import com.crud.crud.entidad.Estudiante;
import com.crud.crud.repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EstudianteServicioImplement implements EstudianteServicio{

    @Autowired
    private EstudianteRepositorio repositorio;

    @Override
    public List<Estudiante> listarEstudiantes() {
        return repositorio.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }

    @Override
    public Estudiante mostrarPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró un estudiante con el ID: " + id));
    }


    @Override
    public Estudiante editarEstudiante(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        repositorio.deleteById(id);
    }
}
