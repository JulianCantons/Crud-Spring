package com.crud.crud.controlador;


import com.crud.crud.entidad.Estudiante;
import com.crud.crud.servicio.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio servicio;

    @GetMapping({"/estudiantes","/"})
    public String listarEstudiantes(Model modelo)
    {
        modelo.addAttribute("estudiantes", servicio.listarEstudiantes());
        return "estudiantes";
    }

    @GetMapping("/estudiantes/nuevo")
    public String formularioEstudiante(Model modelo) {
        Estudiante estudiante = new Estudiante();
        modelo.addAttribute("estudiante", estudiante);
        return "crear_estudiante";
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        servicio.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("estudiantes/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo)
    {
        modelo.addAttribute("estudiante", servicio.mostrarPorId(id));
        return "editar_estudiante";
    }

    @PostMapping("estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model modelo)
    {
        Estudiante estudianteExistente = servicio.mostrarPorId(id);
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());
        estudianteExistente.setDni(estudiante.getDni());
        servicio.editarEstudiante(estudianteExistente);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/{id}")
    public String eliminarEstudiante(@PathVariable Long id)
    {
        servicio.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
