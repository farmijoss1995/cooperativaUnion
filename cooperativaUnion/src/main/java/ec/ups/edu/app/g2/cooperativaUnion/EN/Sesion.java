package ec.ups.edu.app.g2.cooperativaUnion.EN;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Sesion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date fecha;
	
	@Transient
	private String correo;
	@Transient
	private String password;
	
	private String estado;

    
	@OneToOne
	private Empleado empleado;
	
	@OneToOne
	private Usuario usuario;
	
	@Transient
	private String adminEmpleadoTemp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminEmpleadoTemp() {
		return adminEmpleadoTemp;
	}
	public void setAdminEmpleadoTemp(String adminEmpleadoTemp) {
		this.adminEmpleadoTemp = adminEmpleadoTemp;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Sesion [id=" + id + ", fecha=" + fecha + ", correo=" + correo + ", password=" + password + ", estado="
				+ estado + ", empleado=" + empleado + ", usuario=" + usuario + ", adminEmpleadoTemp="
				+ adminEmpleadoTemp + "]";
	}
	
	
	
}
