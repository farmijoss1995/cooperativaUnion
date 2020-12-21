package ec.ups.edu.app.g2.cooperativaUnion.Controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Empleado;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Sesion;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Usuario;
import ec.ups.edu.app.g2.cooperativaUnion.modelo.CuentaAhorroON;
import ec.ups.edu.app.g2.cooperativaUnion.modelo.SesionON;
import ec.ups.edu.app.g2.cooperativaUnion.modelo.UsuarioON;
import ec.ups.edu.app.g2.cooperativaUnion.utils.Mail;
import ec.ups.edu.app.g2.cooperativaUnion.utils.PasswordAleatoreo;

@Named
@ConversationScoped
public class UsuarioBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioON onU;
	private Usuario usuario;
	private CuentaAhorro cuenta;
	
	@Inject
	private SesionON son;

	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private String cedula;

	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
		cuenta = new CuentaAhorro();
		String contrasena = "";
		contrasena = UUID.randomUUID().toString().toLowerCase().substring(0,11);
		usuario.setPassword(contrasena);
		cuenta.setSaldoCuenta(0.0);
		loadDataUsuarios();
		
		
	}
	public void loadDataUsuarios() {
		usuarios = onU.listarUsuario();
		
		
	}

	
	public String guardarDatosUsuario() {
		try {
			cuenta.setUsuario(usuario);
			onU.guardarUsuario(usuario,cuenta);
			
			send();	
			init();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "AdministradorClientes?faces-redirect=true";
		
	}
	public String editar(String cedula) {
		System.out.println(cedula);
		 return "AdministradorClientesCrear?faces-redirect=true&cedula="+cedula;
	}
	public void eliminar(String cedula) {
		onU.eliminarUsuarioCuenta(cedula);
		loadDataUsuarios();	
	}
	
	public Usuario login(Sesion sesion) {
		try {
			usuario = onU.login(sesion);
		} catch (Exception e) {
			usuario = null;
		}
		
		return usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public CuentaAhorro getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaAhorro cuenta) {
		this.cuenta = cuenta;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
		if(cedula != null) {
			usuario = onU.getUsuario(cedula);
			
		}
	}

	public void send() {
		try {
			
			Mail mail = new Mail();
			
			mail.enviarMail(usuario.getCorreo(), "Creacion de Cuenta","DATOS>>>>>>>"+usuario.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
