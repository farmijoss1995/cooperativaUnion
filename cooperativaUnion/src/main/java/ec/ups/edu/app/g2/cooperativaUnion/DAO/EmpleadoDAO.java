package ec.ups.edu.app.g2.cooperativaUnion.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Empleado;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Sesion;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Usuario;



@Stateless
public class EmpleadoDAO {
	@PersistenceContext 
	private EntityManager em;
	
	public void insertEmpleado(Empleado empleado) {
		em.persist(empleado);
	}
	
	public List<Empleado> listarEmpleados() {

		String jqpl = "SELECT e FROM Empleado e";
		Query query = em.createQuery(jqpl, Empleado.class);
		List<Empleado> lista = query.getResultList();
		return lista;
	}
	public void remove(String cedula) throws Exception {
		em.remove(this.buscarEmpleado(cedula));
	}
	
	public void update(Empleado emp) throws Exception {
		em.merge(emp);
	}

	public Empleado buscarEmpleado(String cedula) {
		Empleado emp = em.find(Empleado.class, cedula);
		return emp;
	}

	
	public Empleado getUserbyEmailAndPassword(Sesion sesion){
		
		Empleado cl;
		try {
			String jpql = "SELECT u FROM Empleado u WHERE u.correo LIKE :correo AND u.password LIKE :password";
			
			Query q = em.createQuery(jpql, Empleado.class);

			q.setParameter("correo", sesion.getCorreo());
			q.setParameter("password", sesion.getPassword());
			cl = (Empleado) q.getSingleResult();
			System.out.println("usuaaurioo"+cl.toString());
			
		} catch (Exception e) {
			System.out.println("empleado vacio");
			cl = null;
		}
		return cl;
	}
	public Empleado getEmpleado(){
		String jpql = "SELECT e FROM Empleado e";
		Query query = em.createQuery(jpql,Empleado.class);
		Empleado cuent =  (Empleado) query.getSingleResult();	
		return cuent;
	}


}
