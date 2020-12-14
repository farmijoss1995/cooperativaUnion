package ec.ups.edu.app.g2.cooperativaUnion.Controlador;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.EN.Empleado;
import ec.ups.edu.app.g2.cooperativaUnion.modelo.CuentaAhorroON;
import java.io.Serializable;

@Named
@ConversationScoped
public class CuentaAhorroBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CuentaAhorroON on;
	
	private CuentaAhorro cuenta;
	
	@PostConstruct
	public void init() {
	   cuenta = new CuentaAhorro();
	}
	
	public CuentaAhorro loadDataCuentaAhorro(String cuentaAhorro) {
		cuenta = on.verCuentaAhorro(cuentaAhorro);
		return cuenta;
	}

	public CuentaAhorro getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaAhorro cuenta) {
		this.cuenta = cuenta;
	}
	
	

}
