package ec.ups.edu.app.g2.cooperativaUnion.modelo;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.app.g2.cooperativaUnion.DAO.CuentaAhorroDAO;
import ec.ups.edu.app.g2.cooperativaUnion.DAO.SesionDAO;
import ec.ups.edu.app.g2.cooperativaUnion.DAO.UsuarioDAO;
import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Empleado;

import ec.ups.edu.app.g2.cooperativaUnion.EN.Sesion;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Usuario;
import ec.ups.edu.app.g2.cooperativaUnion.utils.Respuesta;
import ec.ups.edu.app.g2.cooperativaUnion.utils.UsuarioTemp;

@Stateless
public class UsuarioON {
	@Inject
	private UsuarioDAO uDAO;
	@Inject
	private SesionDAO sDAO;
	@Inject
	private CuentaAhorroDAO cDAO;

	public void guardarUsuario(Usuario usuario, CuentaAhorro cuenta) throws Exception {
		// usuario.getSesiones();
		uDAO.insertUsuario(usuario);
		cDAO.insertCuentaAhhorro(cuenta);
	}

	public List<Usuario> listarUsuario() {
		return uDAO.getUsuarios();
	}

	public Usuario getUsuario(String cedula) {
		return uDAO.buscarUsuario(cedula);
	}

	public void eliminarUsuarioCuenta(String cedula) {

		try {
			uDAO.removeUsuario(cedula);
			cDAO.remove(cedula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Usuario login(Sesion sesion) throws Exception {

		return uDAO.getUserbyEmailAndPassword(sesion);
	}
	public Usuario login(UsuarioTemp sesion) throws Exception {
		return uDAO.getUserbyEmailAndPassword2(sesion);
	}

	public Respuesta cambioContrasenia(UsuarioTemp sesion) throws Exception {
		Respuesta res = null;
	    uDAO.cambioContrasenia(sesion);
	    
	    res.setMensaje("Ok");	
	    return res;
	}
	public List<Sesion> listaSesiones(String cedula) {
		return uDAO.usuarioSesiones(cedula);

	}

}
