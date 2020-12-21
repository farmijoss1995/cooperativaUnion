package ec.ups.edu.app.g2.cooperativaUnion.DAO;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.convert.ByteConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mysql.jdbc.Blob;

import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.SolicitudCredito;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Transaccion;

import ec.ups.edu.app.g2.cooperativaUnion.utils.SolicitudTemporal;
import ec.ups.edu.app.g2.cooperativaUnion.EN.SolicitudCredito;


@Stateless
public class SolicitudCreditoDAO {
	@PersistenceContext 
	private EntityManager em;

	public void insertSolicitudCredito(SolicitudCredito solicitud) {
		em.persist(solicitud);
	}

	public SolicitudCredito buscarSolicitudCredito(int id) {
		SolicitudCredito solicitudCredito = em.find(SolicitudCredito.class,id);
		return solicitudCredito;
		
	}
	
	public void update (SolicitudCredito solicitud) {
		
		em.merge(solicitud);
	}
	
	public void  actualizar2(int id ,String estado) {
		String jqpl = "Update SolicitudCredito s SET s.estado = :estado where s.id = :id";
		Query query = em.createNativeQuery(jqpl, SolicitudCredito.class);
		query.setParameter("id", id);
		query.setParameter("estado", estado);
		int r= query.executeUpdate();
		System.out.println(r);
		
	}
	public List<SolicitudCredito> getSolicitudCreditoes(){
		String jpql = "SELECT t FROM SolicitudCredito t";
		Query query = em.createQuery(jpql, SolicitudCredito.class);
		List<SolicitudCredito> listado =  query.getResultList();	
		return listado;
	}
	
	public List<SolicitudCredito> listaTransaciones(String numeroCuenta) {
		String jqpl = "SELECT c FROM CuentaAhorro c JOIN FETCH c.listaSolicitud where c.numeroCuenta = :numeroCuenta";
		Query query = em.createQuery(jqpl, CuentaAhorro.class);
		query.setParameter("numeroCuenta", numeroCuenta);
		 CuentaAhorro cuenta = (CuentaAhorro) query.getSingleResult();
		List<SolicitudCredito> trans = new ArrayList<>();
		for (SolicitudCredito t : cuenta.getListaSolicitud()) {
			trans.add(t);	
		}
		return trans;
		}
	public List<SolicitudTemporal> listaSolictudesEmpleado() {
		String nativeQuery = "SELECT u.nombre,u.apellido,u.cedula,c.numeroCuenta,s.id,s.montoCredito,s.plazoCredito,s.cedulaImagen,s.planillaImagen,s.rolPagosImagen "
				+ "FROM SolicitudCredito s, CuentaAhorro c,Usuario u "
				+ "WHERE  c.cedula_usuario like u.cedula and c.numeroCuenta like s.cuenta_ahorro and s.estado like 'Pendiente'";
		Query query = em.createNativeQuery(nativeQuery);
		List<SolicitudTemporal> ingresos = new ArrayList<>();
		List<Object[]> listado = query.getResultList();
		for (Object item[] : listado) {
			SolicitudTemporal ct = new SolicitudTemporal();
			
			ct.setNombre(item[0].toString());
			ct.setApellido(item[1].toString());
			ct.setCedula(item[2].toString());
			ct.setNumeroCuenta(item[3].toString());
			ct.setId(Integer.valueOf(item[4].toString()));
			ct.setMontoCredito(Double.valueOf(item[5].toString()));
			ct.setPlazoCredito(Integer.valueOf(item[6].toString()));
			ingresos.add(ct);
			
		}
			return ingresos;
		}
	
	
		
}
