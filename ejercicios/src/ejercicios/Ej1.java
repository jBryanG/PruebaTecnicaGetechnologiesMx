package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean cont = true;
		
		System.out.println("Escriba fecha en formato dd/MM/yyyy para validar \n pulse ENTER para salir");
		do {
			String date = br.readLine().strip();
			if(date.isBlank()){
				cont = false;
			} else {
				System.out.println(isValidDate(date));
			}

		}while(cont);
		
		br.close();

	}

}
