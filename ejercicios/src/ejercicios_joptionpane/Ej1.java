package ejercicios_joptionpane;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Ej1 {
	
	public static boolean isValidDate(String date){
	    String[] dateF = date.split("/");
		//Validar formato
		if(dateF.length != 3) return false;
		
		
		//Validar año
		if(dateF[2].length() != 4) return false;
		int year = Integer.parseInt(dateF[2]);
		if(year<0 || year > 2022) return false;
		
		
		//Validar mes
		if(dateF[1].length() != 2) return false;
		int month = Integer.parseInt(dateF[1]);
		if(month < 1 || month > 12) return false;
		
		//Validar dia
		if(dateF[0].length() != 2) return false;
		int day = Integer.parseInt(dateF[0]);
		if(day< 1 || day > 31) return false;
		
		//Validar meses con 30 dias
		if(month == 4 || month == 6 || month == 9 || month == 11) {
			if(day > 30) return false;
		}
		//Validar febrero y bisiestos
		if (month == 2) {
			if((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)) {
				if (day > 29 )return false;
			}else {
				if (day > 28 )return false;
			}
			
		}
		
	      
	    return true;
	 }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int cont = 0;
		String text = "Escriba fecha en formato dd/MM/yyyy para validar";
		do {
			String date =  JOptionPane.showInputDialog(text);
			if(date != null) {
				String resp = isValidDate(date.strip()) ? "La fecha es valida" : "La fecha es inválida";
				cont = JOptionPane.showConfirmDialog(null, resp + "\nIngresar otra fecha?" 
					, "Contiuar", JOptionPane.YES_NO_OPTION);
			} else {
				cont = JOptionPane.showConfirmDialog(null, "Intentar ingresar una fecha de nuevo?" 
						, "Contiuar", JOptionPane.YES_NO_OPTION);
			}
			
			

		}while(cont == JOptionPane.YES_OPTION);
		

	}

}
