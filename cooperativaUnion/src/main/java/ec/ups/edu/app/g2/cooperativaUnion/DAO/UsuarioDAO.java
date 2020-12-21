package ec.ups.edu.app.g2.cooperativaUnion.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Sesion;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Transaccion;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Usuario;
import ec.ups.edu.app.g2.cooperativaUnion.utils.UsuarioTemp;

@Stateless
public class UsuarioDAO {
	
	@PersistenceContext 
	private EntityManager em;
	
	public void insertUsuario(Usuario usuario) {
		em.persist(usuario);
	}

	public void removeUsuario(String cedula) throws Exception {
		em.remove(this.buscarUsuario(cedula));
	}
	
	public void update(Usuario usuario) throws Exception {
		em.merge(usuario);
	}

	public Usuario buscarUsuario(String cedula) {
		Usuario usuario = em.find(Usuario.class, cedula);
		return usuario;
	}
	public List<Usuario> getUsuarios(){
		String jpql = "SELECT u FROM Usuario u";
		Query query = em.createQuery(jpql, Usuario.class);
		List<Usuario> listado =  query.getResultList();	
		return listado;
	}
	//select login
	public Usuario getUserbyEmailAndPassword(Sesion sesion) {
		Usuario cl;
		try {
			String jpql = "SELECT u FROM Usuario u WHERE u.correo LIKE :correo AND u.password LIKE :password";
			System.out.println("jpqlllll"+jpql);
			Query q = em.createQuery(jpql, Usuario.class);
			q.setParameter("correo", sesion.getCorreo());
			q.setParameter("password", sesion.getPassword());
			cl = (Usuario) q.getSingleResult();
			System.out.println("usuaaurioo"+cl.toString());
			
		} catch (Exception e) {
			System.out.println("usuaaurioo no entrooooooo");
			cl = null;
		}
		return cl;
	}
	
	public Usuario getUserbyEmailAndPassword2(UsuarioTemp sesion) {
		Usuario cl;
		try {
			String jpql = "SELECT u FROM Usuario u WHERE u.correo LIKE :correo AND u.password LIKE :password";
			System.out.println("jpqlllll"+jpql);
			Query q = em.createQuery(jpql, Usuario.class);
			q.setParameter("correo", sesion.getEmail());
			q.setParameter("password", sesion.getClave());
			cl = (Usuario) q.getSingleResult();
			System.out.println("usuaaurioo"+cl.toString());
			
		} catch (Exception e) {
			System.out.println("usuaaurioo no entrooooooo");
			cl = null;
		}
		return cl;
	}
	
	public Usuario cambioContrasenia(UsuarioTemp sesion) {
		Usuario cl;
		try {
			String jpql = "UPDATE proyecto.Usuario u SET u.password =:nuevapass WHERE u.correo LIKE :correo AND u.password LIKE :password";
			System.out.println("jpqlllll"+jpql);
			Query q = em.createQuery(jpql, Usuario.class);
			q.setParameter("correo", sesion.getEmail());
			q.setParameter("password", sesion.getClave());
			q.setParameter("nuevapass", sesion.getNuevaClave());
			cl = (Usuario) q.getSingleResult();
			System.out.println("usuaaurioo"+cl.toString());
			
		} catch (Exception e) {
			System.out.println("usuaaurioo no entrooooooo");
			cl = null;
		}
		return cl;
	}
	

	
		public List<Sesion> usuarioSesiones(String cedula) {
		String jqpl = "SELECT u FROM Usuario u JOIN FETCH u.listaSesiones where u.cedula = :cedula";
		Query query = em.createQuery(jqpl, Usuario.class);
		query.setParameter("cedula", cedula);
		 Usuario cuen = (Usuario) query.getSingleResult();
		List<Sesion> trans = new ArrayList<>();
		for (Sesion t : cuen.getListaSesiones()) {
			trans.add(t);	
		}
		System.out.println("tttttttttttttttttttttttttttttttttttttttttt"+trans.toString());
		return trans;
		}
		


}
