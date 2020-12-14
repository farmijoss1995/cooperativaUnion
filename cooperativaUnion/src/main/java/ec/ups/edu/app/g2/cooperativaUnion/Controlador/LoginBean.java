package ec.ups.edu.app.g2.cooperativaUnion.Controlador;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;



import ec.ups.edu.app.g2.cooperativaUnion.EN.CreditoPres;
import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Empleado;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Pago;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Sesion;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Usuario;
import ec.ups.edu.app.g2.cooperativaUnion.modelo.CreditoPresON;
import ec.ups.edu.app.g2.cooperativaUnion.modelo.CuentaAhorroON;
import ec.ups.edu.app.g2.cooperativaUnion.modelo.EmpleadoON;
import ec.ups.edu.app.g2.cooperativaUnion.modelo.SesionON;
import ec.ups.edu.app.g2.cooperativaUnion.modelo.TransaccionON;
import ec.ups.edu.app.g2.cooperativaUnion.modelo.UsuarioON;
import ec.ups.edu.app.g2.cooperativaUnion.utils.Mail;
import ec.ups.edu.app.g2.cooperativaUnion.utils.SessionUtils;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioBean usuarioBean;
	
	@Inject
	private EmpleadoBean empleadoBean;

	@Inject
	private CuentaAhorroBean cuentaBean;
	
	@Inject
	private SesionON son;

	@Inject
	private EmpleadoON on;

	@Inject
	private UsuarioON uon;

	@Inject
	private CuentaAhorroON con;
	
	@Inject
	private CreditoPresON cpon;
	
	private String numc;
	@Inject
	private TransaccionON ton;
	

	

	private Sesion sesion;
	private Usuario usuario;
	private Empleado empleado;
	private String temporal;
	private String aux;
	private String ncuenta;
	private CuentaAhorro cuenta;
	private String cedula;
	private CreditoPres prestamo; 
	private List<Sesion> sesiones;
	private List<CreditoPres> prestamos;
	private List<Pago> pagos;
	

	@PostConstruct
	public void init() {
		sesion = new Sesion();
		usuario = new Usuario();
		empleado = new Empleado();
		prestamo = new CreditoPres();
	
		
	}

	/**
	 * Verifica que el Usuario Cliente que desea ingresar este registrado en el
	 * sistema y crea una sesion para el mismo
	 * 
	 * @return
	 */

	public String loginUsuario() {
		usuario = usuarioBean.login(sesion);
		System.out.println("usuario" + usuario.toString());
		if (usuario != null) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", usuario);
			aux = "usuario";
		} else {
			aux = null;
		}
		return aux;

	}

	public String login() {
		empleado = empleadoBean.login(sesion);
		usuario = usuarioBean.login(sesion);
		if (empleado != null || usuario != null) {
			if (empleado != null) {
				if (empleado.getCargo().equals("Cajero")) {
					System.out.println("empleado" + empleado.toString());
					HttpSession session = SessionUtils.getSession();
					session.setAttribute("username", empleado);
					sendEmpleado();
					guardaSession(empleado.getCedula());
					ton.vencimientoPagos();
					aux = "Transacciones?faces-redirect=true";
					return aux;
				} else if (empleado.getCargo().equals("admin")) {
					System.out.println("empleado" + empleado.toString());
					HttpSession session = SessionUtils.getSession();
					session.setAttribute("username", empleado);
					sendEmpleado();
					guardaSession(empleado.getCedula());
					aux = "AdministradorUsuario?faces-redirect=true";
					return aux;

				} else if (empleado.getCargo().equals("JefeCredito")) {
					System.out.println("empleado" + empleado.toString());
					HttpSession session = SessionUtils.getSession();
					session.setAttribute("username", empleado);
					sendEmpleado();
					guardaSession(empleado.getCedula());

					aux = "VistaJefeCredito?faces-redirect=true";
					return aux;
				}

			} else if (usuario != null) {
				HttpSession session = SessionUtils.getSession();
				session.setAttribute("username", usuario);
				sendUsuario();
				guardaSessionUsuario(usuario.getCedula());
				ncuenta = usuario.getCuenta().getNumeroCuenta();
				temporal = con.ultimaTransacion(usuario.getCuenta().getNumeroCuenta());		
				//lista

				 sesiones = uon.listaSesiones(usuario.getCedula());

				
				cedula = usuario.getCedula();
				aux = "formulariocliente2?faces-redirect=true&ncuenta="+ncuenta+"&temporal="+temporal+"&cedula="+cedula;
				
				return aux;
			}


		}else {

			System.out.println("fallido");
			aux = null;
		}
		return aux;
	}

	public String guardaSession(String cedula) {
		empleado = son.consultarEmpleado(cedula);
		sesion.setFecha(new Date());
		sesion.setEstado("exitoso");
		sesion.setEmpleado(empleado);
		try {
			son.nuevaSesion(sesion, empleado);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String guardaSessionUsuario(String cedula) {
		usuario = son.consultarUsuario(cedula);
		sesion.setFecha(new Date());
		sesion.setEstado("exitoso");
		sesion.setUsuario(usuario);
		try {
			son.nuevaSesionUsuario(sesion, usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void sendEmpleado() {
		try {

			Mail mail = new Mail();

			mail.enviarMail(empleado.getCorreo(), "Ha iniciado sesion", "DATOS>>>>>>>" + empleado.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void sendUsuario() {
		try {

			Mail mail = new Mail();

			mail.enviarMail(usuario.getCorreo(), "Ha iniciado sesion", "DATOS>>>>>>>" + usuario.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}

	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}

	public String getTemporal() {
		return temporal;
	}

	public void setTemporal(String temporal) {
		this.temporal = temporal;
	}

	public String getNcuenta() {
		return ncuenta;
	}

	public void setNcuenta(String ncuenta) {
		this.ncuenta = ncuenta;
	}

	public CuentaAhorro getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaAhorro cuenta) {
		this.cuenta = cuenta;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public CreditoPres getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(CreditoPres prestamo) {
		this.prestamo = prestamo;
	}

	public List<Sesion> loadDataSesion(String cedula) {
		sesiones = uon.listaSesiones(cedula);
		return sesiones;
	}
	public List<CreditoPres> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<CreditoPres> prestamos) {
		this.prestamos = prestamos;
	}
	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}
	
	
	public String getNumc() {
		return numc;
	}

	public void setNumc(String numc) {
		this.numc = numc;
	}

	public List<CreditoPres> loadDataPrestamos(String cuentaAhorro) {
		prestamos= cpon.listarCredito(cuentaAhorro);
		return prestamos;
	}

	public List<Pago> loadDataPagos(int codigo_pre) {
		pagos= cpon.listarPagos(codigo_pre);
		return pagos;
	}
	
	public List<Pago> loadDataPagosCajero(int codigo_pre) {
		pagos= cpon.listarPagosCajero(codigo_pre);
		return pagos;
	}



}
