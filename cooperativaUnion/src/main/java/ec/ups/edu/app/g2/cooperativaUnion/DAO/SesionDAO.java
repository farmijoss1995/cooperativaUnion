package ec.ups.edu.app.g2.cooperativaUnion.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Sesion;


@Stateless
public class SesionDAO {
	@PersistenceContext 
	private EntityManager em;
	
	public void insertSesion(Sesion sesion) {
		em.persist(sesion);
	}

	public void removeSesion(int id) throws Exception {
		em.remove(this.buscarSesion(id));
	}
	
	public void update(int id) throws Exception {
		em.merge(id);
	}

	public Sesion buscarSesion(int id) {
		Sesion sesion = em.find(Sesion.class,id);
		return sesion;
	}
	public List<Sesion> getSesiones(String cedula){
		String jpql = "SELECT u FROM Sesion u WHERE usuario_cedula like:cedula";
		System.out.println("sesionsssssssssss"+jpql);
		Query query = em.createQuery(jpql,Sesion.class);
		List<Sesion> listado =  query.getResultList();	
		return listado;
	}
	

}
