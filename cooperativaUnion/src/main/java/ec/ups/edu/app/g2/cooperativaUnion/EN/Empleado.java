package ec.ups.edu.app.g2.cooperativaUnion.EN;


import java.util.ArrayList;
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

@Entity
public class Empleado {

	@Id
	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private String correo;
	private String cargo;
	private String password;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado")
    private List<Transaccion> listaTransaciones;
	
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "empleado_cedula")
    private List<Sesion> listaSesiones;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_Soli")
    private List<SolicitudCredito> listaSolicitudes;
	
	
	
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Transaccion> getListaTransaciones() {
		return listaTransaciones;
	}

	public void setListaTransaciones(List<Transaccion> listaTransaciones) {
		this.listaTransaciones = listaTransaciones;
	}
	
	
	public List<Sesion> getListaSesiones() {
		return listaSesiones;
	}

	public void setListaSesiones(List<Sesion> listaSesiones) {
		this.listaSesiones = listaSesiones;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", password=" + password
				+ "]";
	}

	public void addSesiones(Sesion e) {
		if(this.listaSesiones==null)
			this.listaSesiones = new ArrayList<>();
		this.listaSesiones.add(e);
	}
	

}
