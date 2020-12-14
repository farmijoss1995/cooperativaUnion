package ec.ups.edu.app.g2.cooperativaUnion.EN;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario{
	
	@Id
	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private String correo;
	private String password;
	
	@JsonIgnore
	@OneToOne( mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private CuentaAhorro cuenta;
	
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_cedula")
    private List<Sesion> listaSesiones;
	

	


	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public CuentaAhorro getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaAhorro cuenta) {
		this.cuenta = cuenta;
	}

	public List<Sesion> getListaSesiones() {
		return listaSesiones;
	}

	public void setListaSesiones(List<Sesion> listaSesiones) {
		this.listaSesiones = listaSesiones;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", password=" + password
				+ "]";
	}

	

}
