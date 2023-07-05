package com.app.web.controlador;

import com.app.web.entidad.Empleado;
import com.app.web.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EmpleadoControlador {

    @Autowired
    private EmpleadoServicio servicio;

    @GetMapping({"/empleados","/"})
    public String listarEmpleados(Model modelo){
        modelo.addAttribute("empleados",servicio.listarTodosLosEmpleados());
        return "empleados"; //nos retorna al archivo empleados
    }

    @GetMapping("/empleados/nuevo")
    public String mostrarFormularioDeRegistrarEmpleado(Model modelo){
        Empleado empleado = new Empleado();
                modelo.addAttribute("empleado",empleado);
                return "crear_empleado";
    }

    @PostMapping("/empleados")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado){
        servicio.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("empleado",servicio.obtenerEmpleadoPorId(id));
        return "editar_empleado";
    }

    @PostMapping("/empleados/{id}")
    public String actualizarEmpleado(@PathVariable Long id,@ModelAttribute("empleado")Empleado empleado, Model modelo){
        Empleado empleadoExistente=servicio.obtenerEmpleadoPorId(id);
        empleadoExistente.setId(id);
        empleadoExistente.setNombre(empleado.getNombre());
        empleadoExistente.setApellido(empleado.getApellido());
        empleadoExistente.setDni(empleado.getDni());
        empleadoExistente.setDireccion(empleado.getDireccion());

        servicio.actualizarEmpleado(empleadoExistente);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/{id}")
    public String eliminarEmpleado(@PathVariable Long id){
        servicio.eliminarEmpleado(id);
        return "redirect:/empleados";
    }
}
