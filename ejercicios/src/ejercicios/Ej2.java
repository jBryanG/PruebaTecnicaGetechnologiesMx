package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej2 {
	
	
	public static int countDigits(String data) {
		int digits = 0;
		
		for(int i = 0; i < data.length(); i++) {
			char tmp = data.charAt(i);
			if(Character.isDigit(tmp)) digits++;
		}
		return digits;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean cont = true;
		
		System.out.println("Escriba una cadena para contar caracteres y presione enter\n"
				+ "Pulse ENTER para salir");
		do {
			String data = br.readLine().strip();
			if(data.isBlank()){
				cont = false;
			} else {
				System.out.println(countDigits(data));
			}

		}while(cont);
		
		br.close();

	}

}
