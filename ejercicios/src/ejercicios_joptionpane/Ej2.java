package ejercicios_joptionpane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

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
		int cont = 0;
		
		String text  = "Escriba una cadena para contar caracteres y presione enter";
		
		do {
			String data =  JOptionPane.showInputDialog(text);
			if(data != null) {
				int chars = countDigits(data.strip());
				cont = JOptionPane.showConfirmDialog(null, "La cadena tiene "+ 
				String.valueOf(chars) + " dígitos\nIngresar otro texto?" 
					, "Contiuar", JOptionPane.YES_NO_OPTION);
			} else {
				cont = JOptionPane.showConfirmDialog(null, "Intentar ingresar texto de nuevo?" 
						, "Contiuar", JOptionPane.YES_NO_OPTION);
			}

		}while(cont == JOptionPane.YES_OPTION);
		
		

		
		br.close();

	}

}