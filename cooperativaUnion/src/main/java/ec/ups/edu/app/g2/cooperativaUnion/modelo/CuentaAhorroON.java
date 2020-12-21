package ec.ups.edu.app.g2.cooperativaUnion.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import ec.ups.edu.app.g2.cooperativaUnion.DAO.CuentaAhorroDAO;

import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Empleado;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Transaccion;


@Stateless
public class CuentaAhorroON {
	
	@Inject
	CuentaAhorroDAO cDAO;
	
	public CuentaAhorro verCuentaAhorro(String numeroCuenta) {
		return cDAO.buscarCuentaAhorro(numeroCuenta);
	}
	
	public String ultimaTransacion(String numeroCuenta){
		String t = null;
		try {
			t = cDAO.ultimaTransaccion(numeroCuenta);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}
		
	
	public CuentaAhorro misCuentas(String numeroCuenta) {
	
		return cDAO.misCuentas(numeroCuenta);
	}
}