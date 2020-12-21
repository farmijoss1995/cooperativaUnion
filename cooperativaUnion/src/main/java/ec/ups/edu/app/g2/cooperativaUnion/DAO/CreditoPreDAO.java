package ec.ups.edu.app.g2.cooperativaUnion.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.app.g2.cooperativaUnion.EN.CreditoPres;
import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.SolicitudCredito;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Transaccion;
import ec.ups.edu.app.g2.cooperativaUnion.utils.SolicitudTemporal;

@Stateless
public class CreditoPreDAO {

	@PersistenceContext 
	private EntityManager em;
	public void crearCreditoPres(CreditoPres cre) {
		em.persist(cre);
	}
	
	public CreditoPres buscarCreditoPres(int numero) {
		String jpql= "select cre From CreditoPres cre where cre.codigo = :numero";
		Query query = em.createQuery(jpql,CreditoPres.class);
		query.setParameter("numero", numero);
		CreditoPres CreditoPres = (CreditoPres) query.getSingleResult();
		
		return CreditoPres;
	}
	
	public void update(CreditoPres cre) {
		em.merge(cre);
	}

	public List<CreditoPres>buscarCreditoPres2(String cuenta_ahorroPres){
	String nativeQuery = "SELECT * FROM Credito_Prestamo c WHERE c.cuenta_ahorroPres =:cuenta_ahorroPres";
	Query query = em.createNativeQuery(nativeQuery);
	query.setParameter("cuenta_ahorroPres", cuenta_ahorroPres);
	List<CreditoPres> pres = new ArrayList<CreditoPres>();
	List<Object[]> listado = query.getResultList();
	for (Object item[] : listado) {
		CreditoPres ct = new CreditoPres();
		
		ct.setCodigo(Integer.valueOf(item[0].toString()));
		ct.setSaldo(Double.valueOf(item[1].toString()));
		ct.setFecha(item[2].toString());
		ct.setFechaFin(item[3].toString());
		ct.setMonto(Double.valueOf(item[4].toString()));
		ct.setTipo(item[5].toString());
		pres.add(ct);
	
	}
	return pres;
	}

	
	public List<CreditoPres> mostrar(){
		String jpql = "select cre from CreditoPres cre";
		Query query = em.createQuery(jpql, CreditoPres.class);
		List<CreditoPres> CreditoPress = query.getResultList();
		for (CreditoPres CreditoPres : CreditoPress ) {
			CreditoPres.getPagos().size();
		}
		return CreditoPress;
	}
	public void nuevaTransaccion(CreditoPres c) {
		em.persist(c);
	}
}
