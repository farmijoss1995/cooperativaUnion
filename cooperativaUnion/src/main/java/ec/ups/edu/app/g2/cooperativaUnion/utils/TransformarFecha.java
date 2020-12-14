package ec.ups.edu.app.g2.cooperativaUnion.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransformarFecha {
	
	
	public String transformatFecha() {
		
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

		String fecha = formateador.format(new Date());
		int dia = Integer.parseInt(fecha.substring(0, 2));
		int mes = Integer.parseInt(fecha.substring(4, 5));
		int anio = Integer.parseInt(fecha.substring(6, 10));
		
		String fech = ""+dia+"/"+mes+"/"+anio;
		
		return fech;
		
	}
	
	

}
