package ec.ups.edu.app.g2.cooperativaUnion.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Empleado;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Transaccion;


@Stateless
public class CuentaAhorroDAO {
	@PersistenceContext 
	private EntityManager em;
	
	public void insertCuentaAhhorro(CuentaAhorro cuenta) {
		em.persist(cuenta);
	}

	public void update(CuentaAhorro cuenta) throws Exception {
		em.merge(cuenta);
	}
	
	public void removeCuentaAhhorro(String numeroCuenta) throws Exception {
		em.remove(this.buscarCuentaAhorro(numeroCuenta));
	}
	
	public CuentaAhorro buscarCuentaAhorro(String numeroCuenta) {
		CuentaAhorro cuenta = em.find(CuentaAhorro.class, numeroCuenta);
		return cuenta;
	}
	
	public List<CuentaAhorro> getCuentaAhorros(){
		String jpql = "SELECT ch FROM CuentaAhorro ch";
		Query query = em.createQuery(jpql,CuentaAhorro.class);
		List<CuentaAhorro> listado =  query.getResultList();	
		return listado;
	}

	public void remove(String numeroCuenta) throws Exception {
		String sql ="DELETE FROM CuentaAhorro WHERE numeroCuenta=:numeroCuenta";
		Query query = em.createNativeQuery(sql);
		query.setParameter("numeroCuenta", numeroCuenta);
		query.executeUpdate();	
	
	}
	public String ultimaTransaccion(String numeroCuenta) {
		String nativeQuery  = "SELECT MAX(fecha) FROM Transaccion WHERE cuenta_numeroCuenta=?";
		Query query = em.createNativeQuery(nativeQuery);
		query.setParameter(1, numeroCuenta);
		String t = query.getSingleResult().toString();
		return t;
		
	}
	public CuentaAhorro misCuentas(String numeroCuenta) {
		String jqpl = "SELECT c FROM CuentaAhorro c JOIN FETCH c.listaTra where c.numeroCuenta = :numeroCuenta";
		Query query = em.createQuery(jqpl, CuentaAhorro.class);
		query.setParameter("numeroCuenta", numeroCuenta);
		CuentaAhorro cuen = (CuentaAhorro) query.getSingleResult();
		List<Transaccion> trans = new ArrayList<>();
		for (Transaccion t : cuen.getListaTra()) {
			trans.add(t);
			
		}
		return cuen;
	}
	public List<CuentaAhorro> getCuentas( String cco, String ccd){
		List<CuentaAhorro> cuentas = new ArrayList<CuentaAhorro>();
		String jpqlco = "SELECT c FROM CuentaAhorro c where c.numeroCuenta =: cco ";
		String jpqlds = "SELECT c FROM CuentaAhorro c where c.numeroCuenta =: ccd ";
		Query qo = em.createQuery(jpqlco, CuentaAhorro.class);
		qo.setParameter("cco", cco);
		Query qd = em.createQuery(jpqlds, CuentaAhorro.class);
		qd.setParameter("ccd", ccd);
		CuentaAhorro cueorigen =(CuentaAhorro) qo.getSingleResult();
		CuentaAhorro cuedesti =(CuentaAhorro) qd.getSingleResult();
		cuentas.add(cueorigen);
		cuentas.add(cuedesti);
		return cuentas;
	}
}
