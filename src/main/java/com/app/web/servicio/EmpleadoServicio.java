package com.app.web.servicio;

import com.app.web.entidad.Empleado;

import java.util.List;

public interface EmpleadoServicio {
    public List<Empleado> listarTodosLosEmpleados();
    public Empleado guardarEmpleado(Empleado empleado);
    public Empleado obtenerEmpleadoPorId(Long id);
    public Empleado actualizarEmpleado(Empleado empleado);
    public void eliminarEmpleado(Long id);
}
