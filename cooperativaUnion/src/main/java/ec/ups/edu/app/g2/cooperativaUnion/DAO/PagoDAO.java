package ec.ups.edu.app.g2.cooperativaUnion.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.EN.CreditoPres;
import ec.edu.ups.EN.Empleado;
import ec.edu.ups.EN.Pago;
import ec.edu.ups.EN.Pago;

@Stateless
public class PagoDAO {
	
	@PersistenceContext 
	private EntityManager em;

	public void nuevaTransaccion(Pago p) {
		em.persist(p);
	}
	
	public void update(Pago p) {
		em.merge(p);
	}
	
	public Pago buscarPago(int codigo) {
		String jpql= "SELECT p FROM Pago p where p.codigo = :codigo";
		Query query = em.createQuery(jpql,Pago.class);
		query.setParameter("codigo", codigo);
		Pago pago = (Pago) query.getSingleResult();
		
		return pago;
	}
	
	public List<Pago> listaPagosCajero(int codigo_pre){
		String nativeQuery = "SELECT * FROM Pago p WHERE p.estado like 'Pendiente' and p.credito_pre =:codigo_pre ORDER BY p.numeroPago DESC";
		Query query = em.createNativeQuery(nativeQuery);
		query.setParameter("codigo_pre", codigo_pre);
		List<Pago> pres = new ArrayList<Pago>();
		List<Object[]> listado = query.getResultList();
		for (Object item[] : listado) {
			Pago ct = new Pago();
			
			ct.setCodigo(Integer.valueOf(item[0].toString()));
			ct.setCuenta(item[1].toString());
			ct.setEstado(item[2].toString());
			ct.setFechaPago(item[3].toString());
			ct.setNumeroPago(Integer.valueOf(item[4].toString()));
			ct.setSaldo(Double.valueOf(item[5].toString()));
			ct.setValor(Double.valueOf(item[6].toString()));
			pres.add(ct);
			
		}
		return pres;
			
	}
	
	public List<Pago> listaPagosMovil(String cuenta){
		String nativeQuery = "SELECT * FROM Pago p WHERE p.estado like 'Vencido' and p.cuenta =:cuenta ORDER BY p.numeroPago DESC";
		Query query = em.createNativeQuery(nativeQuery);
		query.setParameter("cuenta", cuenta);
		List<Pago> pres = new ArrayList<Pago>();
		List<Object[]> listado = query.getResultList();
		for (Object item[] : listado) {
			Pago ct = new Pago();
			
			ct.setCodigo(Integer.valueOf(item[0].toString()));
			ct.setCuenta(item[1].toString());
			ct.setEstado(item[2].toString());
			ct.setFechaPago(item[3].toString());
			ct.setNumeroPago(Integer.valueOf(item[4].toString()));
			ct.setSaldo(Double.valueOf(item[5].toString()));
			ct.setValor(Double.valueOf(item[6].toString()));
			pres.add(ct);
			
		}
		return pres;
			
	}
	
	public List<Pago> listaPagos(int codigo_pre){
		String nativeQuery = "SELECT * FROM pago p WHERE p.credito_pre =:codigo_pre";
		Query query = em.createNativeQuery(nativeQuery);
		query.setParameter("codigo_pre", codigo_pre);
		List<Pago> pres = new ArrayList<Pago>();
		List<Object[]> listado = query.getResultList();
		for (Object item[] : listado) {
			Pago ct = new Pago();
			
			ct.setCodigo(Integer.valueOf(item[0].toString()));
			ct.setCuenta(item[1].toString());
			ct.setEstado(item[2].toString());
			ct.setFechaPago(item[3].toString());
			ct.setNumeroPago(Integer.valueOf(item[4].toString()));
			ct.setSaldo(Double.valueOf(item[5].toString()));
			ct.setValor(Double.valueOf(item[6].toString()));
			pres.add(ct);
			
		}
		return pres;
			
	}
}
