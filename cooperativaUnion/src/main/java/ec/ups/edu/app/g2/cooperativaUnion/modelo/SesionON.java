package ec.ups.edu.app.g2.cooperativaUnion.modelo;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.app.g2.cooperativaUnion.DAO.EmpleadoDAO;
import ec.ups.edu.app.g2.cooperativaUnion.DAO.SesionDAO;
import ec.ups.edu.app.g2.cooperativaUnion.DAO.UsuarioDAO;
import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Empleado;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Sesion;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Usuario;

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
