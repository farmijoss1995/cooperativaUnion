package ec.ups.edu.app.g2.cooperativaUnion.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.EN.CuentaAhorro;
import ec.edu.ups.EN.Pago;
import ec.edu.ups.EN.Sesion;
import ec.edu.ups.EN.Transaccion;
import ec.edu.ups.EN.Usuario;
import ec.edu.ups.utils.TransformarFecha;


@Stateless
public class TransaccionDAO {
	@PersistenceContext 
	private EntityManager em;
	
	
	
	
	public void nuevaTransaccion(Transaccion transaccion) {
		em.persist(transaccion);
	}

	public Transaccion buscarTransaccion(int id) {
		Transaccion transaccion = em.find(Transaccion.class,id);
		return transaccion;
	}
	public List<Transaccion> getTransacciones(){
		String jpql = "SELECT t FROM Transaccion t";
		Query query = em.createQuery(jpql, Transaccion.class);
		List<Transaccion> listado =  query.getResultList();	
		return listado;
	}
	
	public List<Transaccion> listaTransaciones(String numeroCuenta) {
		String jqpl = "SELECT c FROM CuentaAhorro c JOIN FETCH c.listaTra where c.numeroCuenta = :numeroCuenta";
		Query query = em.createQuery(jqpl, CuentaAhorro.class);
		query.setParameter("numeroCuenta", numeroCuenta);
		 CuentaAhorro cuenta = (CuentaAhorro) query.getSingleResult();
		List<Transaccion> trans = new ArrayList<>();
		for (Transaccion t : cuenta.getListaTra()) {
			trans.add(t);	
		}
		return trans;
		}
		
	public List<Transaccion> porFechasTra(String tipoTransaccion,String cuenta_numeroCuenta, Date minFecha, Date maxFecha){
		String nativeQuery= "SELECT t FROM Transaccion t WHERE cuenta_numeroCuenta like :? and fecha >= ? and fecha <=? or tipoTransaccion like :? ";
		Query query = em.createNativeQuery(nativeQuery);
		query.setParameter(1, cuenta_numeroCuenta);
		query.setParameter(2, minFecha);
		query.setParameter(2, maxFecha);
		query.setParameter(4, tipoTransaccion);
		CuentaAhorro cuen = (CuentaAhorro) query.getSingleResult();
		List<Transaccion> trans = new ArrayList<>();
		for (Transaccion t : cuen.getListaTra()) {
			trans.add(t);
		}
		System.out.println("traaaanannanannannanannannana"+trans.toString());
		return trans;
	}
	
	
	
	public List<Object[]> vencimientoCreditos() {
		TransformarFecha tr= new TransformarFecha();
		String fechaPago = tr.transformatFecha();
		
		String nativeQuery="SELECT * FROM Pago p WHERE  p.fechaPago like :fechaPago";
		Query query = em.createNativeQuery(nativeQuery);
		query.setParameter("fechaPago", fechaPago);
		List<Object[]>  pagos = query.getResultList();
		return pagos;
	}

}