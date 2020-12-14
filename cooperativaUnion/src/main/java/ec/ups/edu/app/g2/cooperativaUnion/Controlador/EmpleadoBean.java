package ec.ups.edu.app.g2.cooperativaUnion.Controlador;

import java.io.Serializable;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.ups.edu.app.g2.cooperativaUnion.DAO.TransaccionDAO;
import ec.ups.edu.app.g2.cooperativaUnion.DAO.UsuarioDAO;
import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Empleado;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Sesion;
import ec.ups.edu.app.g2.cooperativaUnion.EN.SolicitudCredito;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Usuario;
import ec.ups.edu.app.g2.cooperativaUnion.modelo.EmpleadoON;
import ec.ups.edu.app.g2.cooperativaUnion.utils.Mail;

@Named
@ConversationScoped
public class EmpleadoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject 
	private EmpleadoON on;
	private Empleado empleado;
	private String cedula;
	

	
	@Inject
	private TransaccionDAO t;
	
	private List<Empleado> empleados = new ArrayList<Empleado>();
	
	@PostConstruct
	public void init() {
		empleado = new Empleado();
		String contrasena = "";
		contrasena = UUID.randomUUID().toString().toLowerCase().substring(0,11);
		empleado.setPassword(contrasena);
		loadDataEmpleados();
	}
	public void loadDataEmpleados() {
		try {
			empleados = on.listarEmpleado();
		} catch (Exception e) {
			// TODO: handle exception
			
		}	
		
	}
	

	public String guardarDatosEmpleado() {
		try {
			on.guardarEmpleado(empleado);
			send();
			init();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "AdministradorUsuario?faces-redirect=true";
	}
	public String editar(String cedula) {
		System.out.println(cedula);
		
		 return "AdministradorUsuarioCrear?faces-redirect=true&cedula="+cedula;
	}
	


	public void eliminar(String cedula) {
		on.eliminarEmpleado(cedula);
		loadDataEmpleados();	
	}
	
	public Empleado login(Sesion sesion) {
		try {
			empleado = on.login(sesion);
		} catch (Exception e) {
			empleado = null;
		}
		
		return empleado;
	}


	public EmpleadoON getOn() {
		return on;
	}

	public void setOn(EmpleadoON on) {
		this.on = on;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	public String getCedula() {
		return cedula;
	}
	
	

	public void setCedula(String cedula) {
		System.out.println("cedula parametro"+cedula);
		this.cedula = cedula;
		
		if(cedula != null) {
			empleado = on.getEmpleado(cedula);
			
		}
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void send() {
		try {
			
			Mail mail = new Mail();
			
			mail.enviarMail(empleado.getCorreo(), "Creacion de Cuenta","DATOS>>>>>>>"+empleado.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
