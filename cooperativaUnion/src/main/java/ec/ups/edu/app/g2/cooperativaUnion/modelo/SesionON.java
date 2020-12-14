package ec.ups.edu.app.g2.cooperativaUnion.modelo;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.DAO.EmpleadoDAO;
import ec.edu.ups.DAO.SesionDAO;
import ec.edu.ups.DAO.UsuarioDAO;
import ec.edu.ups.EN.CuentaAhorro;
import ec.edu.ups.EN.Empleado;
import ec.edu.ups.EN.Sesion;
import ec.edu.ups.EN.Usuario;

@Stateless
public class SesionON {
	
	@Inject
	private SesionDAO sDAO;
	
	@Inject
	private EmpleadoDAO eDAO;
	
	@Inject
	private UsuarioDAO uDAO;
	

	public void guardarSesion(Sesion sesion) throws Exception {
	
		sDAO.insertSesion(sesion);
		System.out.println("sessioonnnnnnnn"+sesion.toString());
		
	}
	public List<Sesion> listarSesion(String cedula) {
		return sDAO.getSesiones(cedula);
	}
	
	public Empleado consultarEmpleado(String cedula) {
		Empleado p = eDAO.buscarEmpleado(cedula);
		
		return p;
		
	}
	
	public Usuario consultarUsuario(String cedula) {
		Usuario u = uDAO.buscarUsuario(cedula);
		return u;	
	}

	public void nuevaSesion(Sesion sesion, Empleado empleado) throws Exception {
		
		sDAO.insertSesion(sesion);
		
	}
	public void nuevaSesionUsuario(Sesion sesion, Usuario usuario) throws Exception {
		
		sDAO.insertSesion(sesion);
		
	}


}
