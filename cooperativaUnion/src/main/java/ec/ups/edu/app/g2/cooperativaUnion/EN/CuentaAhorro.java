package ec.ups.edu.app.g2.cooperativaUnion.EN;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CuentaAhorro{
	
	@Id
	private String numeroCuenta;
	private Double saldoCuenta;
	

    @OneToOne
    @JoinColumn(name = "cedula_usuario", referencedColumnName = "cedula")
    private Usuario usuario;
	
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_numeroCuenta")
    private List<Transaccion> listaTra;
	
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_ahorro")
	 private List<SolicitudCredito> listaSolicitud;
	
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "cuenta_ahorroPres")
	private List<CreditoPres>creditos;
	
	public void agregarCredito(CreditoPres cred) {
	if (creditos == null) {
		creditos = new ArrayList<CreditoPres>();
	}
	creditos.add(cred);
	}
	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Double getSaldoCuenta() {
		return saldoCuenta;
	}

	public void setSaldoCuenta(Double saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Transaccion> getListaTra() {
		return listaTra;
	}

	public void setListaTra(List<Transaccion> listaTra) {
		this.listaTra = listaTra;
	}
	public void addTransaccion(Transaccion t) {
		if(listaTra==null) {
			listaTra= new ArrayList<>();
	}
		this.listaTra.add(t);
	}
	
	
	public List<SolicitudCredito> getListaSolicitud() {
		return listaSolicitud;
	}

	public void setListaSolicitud(List<SolicitudCredito> listaSolicitud) {
		this.listaSolicitud = listaSolicitud;
	}

	public void addSolicitud(SolicitudCredito sc) {
		if(listaSolicitud==null) {
			listaSolicitud= new ArrayList<>();
	}
		this.listaSolicitud.add(sc);
	}

	public List<CreditoPres> getCreditos() {
		return creditos;
	}

	public void setCreditos(List<CreditoPres> creditos) {
		this.creditos = creditos;
	}
	
	
	
	
	
}
