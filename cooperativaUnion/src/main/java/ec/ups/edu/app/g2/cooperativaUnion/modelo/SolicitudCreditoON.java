package ec.ups.edu.app.g2.cooperativaUnion.modelo;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import ec.edu.ups.DAO.CuentaAhorroDAO;
import ec.edu.ups.DAO.SolicitudCreditoDAO;
import ec.edu.ups.DAO.TransaccionDAO;
import ec.edu.ups.EN.CuentaAhorro;
import ec.edu.ups.EN.SolicitudCredito;
import ec.edu.ups.EN.Transaccion;
import ec.edu.ups.utils.SolicitudTemporal;

@Stateless
public class SolicitudCreditoON {
	
	@Inject
	CuentaAhorroDAO cuentaDao;
	
	@Inject
	private SolicitudCreditoDAO sdao;
	
	public List<SolicitudCredito> listaSolicitudes(String numeroCuenta) {
	
		return sdao.listaTransaciones(numeroCuenta);
		
		}
	
	public List<SolicitudTemporal> listaSolicitudesEmpleado() {
		
		return sdao.listaSolictudesEmpleado();
		
		}
	
	public void nuevaSolicitud(SolicitudCredito solicitud, CuentaAhorro cuenta) {
		solicitud.setEstado("Pendiente");
	  sdao.insertSolicitudCredito(solicitud);
	}
	
	public CuentaAhorro getCuenta(String numeroCuenta) { 
		return cuentaDao.buscarCuentaAhorro(numeroCuenta);  		
    }
	
	public SolicitudCredito getSolicitud(int codigo) {
		return sdao.buscarSolicitudCredito(codigo);
	}
	
	
	public List<SolicitudCredito> verSolicitudCredito() {
		return sdao.getSolicitudCreditoes();
	}
	
	public void actualizarSolisitud(SolicitudCredito solicitud) {
		sdao.update(solicitud);
	}
	
	public void  actualizar2(SolicitudCredito solicitud) {
		sdao.actualizar2(solicitud.getId(),solicitud.getEstado());
	}

}
