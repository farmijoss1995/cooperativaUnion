package ec.ups.edu.app.g2.cooperativaUnion.modelo;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import ec.ups.edu.app.g2.cooperativaUnion.DAO.EmpleadoDAO;
import ec.ups.edu.app.g2.cooperativaUnion.DAO.SesionDAO;
import ec.ups.edu.app.g2.cooperativaUnion.DAO.UsuarioDAO;
import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Empleado;

import ec.ups.edu.app.g2.cooperativaUnion.EN.Sesion;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Usuario;

@Stateless
public class EmpleadoON {
	
	@Inject
	private EmpleadoDAO eDAO;
	@Inject
	private SesionDAO sDAO;
	
	public Empleado verEmpleado() {
		return eDAO.getEmpleado();
	}
	
	public void guardarEmpleado(Empleado empleado) throws Exception {
		Empleado aux = eDAO.buscarEmpleado(empleado.getCedula());
		if(aux != null) {
			eDAO.update(empleado);
		}else {
			eDAO.insertEmpleado(empleado);
			System.out.println(empleado.toString());
		}
	}
	public List<Empleado> listarEmpleado() {
		return eDAO.listarEmpleados();
	}

	
	public Empleado getEmpleado(String cedula) { 
        return eDAO.buscarEmpleado(cedula);  
    }

	public Empleado buscarEmpleado(String cedula) {
		EmpleadoDAO emp = new EmpleadoDAO();
		Empleado e = emp.buscarEmpleado(cedula);
		return e;
	}

	public void eliminarEmpleado(String cedula){
		
		try {
			eDAO.remove(cedula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	public Empleado login(Sesion sesion) throws Exception {

			return eDAO.getUserbyEmailAndPassword(sesion);
	

	}

}
