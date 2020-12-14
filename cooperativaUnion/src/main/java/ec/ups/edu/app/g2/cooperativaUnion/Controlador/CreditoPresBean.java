package ec.ups.edu.app.g2.cooperativaUnion.Controlador;

import java.io.Serializable;

import javax.ejb.Init;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.ups.edu.app.g2.cooperativaUnion.EN.CuentaAhorro;
import ec.ups.edu.app.g2.cooperativaUnion.modelo.CreditoPresON;

@Named
@ConversationScoped
public class CreditoPresBean implements Serializable {

	@Inject
	private CreditoPresON creon;
	
	CuentaAhorro cue;
	
	
	public void Init(){
		
	}
}
