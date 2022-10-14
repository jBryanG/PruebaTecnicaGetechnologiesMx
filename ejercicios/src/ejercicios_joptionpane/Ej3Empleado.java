package ejercicios_joptionpane;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ej3Empleado {
	String id;
	String nombre; 
	String apellido_p;
	String apellido_m;
	String fecha;

	
	public Ej3Empleado(String id,String nombre, String apellido_p, String apellido_m, String fecha) {
		this.nombre = formatoNombre(nombre);
		this.apellido_p = formatoNombre(apellido_p);
		this.apellido_m = formatoNombre(apellido_m);
		this.fecha = fecha;
        this.id = id;
	}
	
	public int getEdad() throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(getFecha());
        
        Calendar currentDate = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(date);
        
        int dif = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        if (birthDate.get(Calendar.DAY_OF_YEAR) > currentDate.get(Calendar.DAY_OF_YEAR)) {
            dif--;
        }
        return dif;
	}
	
	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getApellidoP() {
		return apellido_p;
	}

	public String getApellidoM() {
		return apellido_m;
	}
	
	public String getFecha() {
		return fecha;
	}

	
	public String formatoNombre(String val) {
		return val.substring(0,1).toUpperCase() + val.substring(1).toLowerCase();	
	}
	
	
	
	
	

}
