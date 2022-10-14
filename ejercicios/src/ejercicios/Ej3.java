package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;

public class Ej3 {
	
	public static String imprimirEmpleados(ArrayList<Ej3Empleado> empleados) {
		//Guardar en un string toda la info de los empleados
		String lista_empleados = "";
		for(Ej3Empleado e : empleados) {
			lista_empleados+= "Id : " + e.getId() + "\n"
					+ "Nombre : " + e.getNombre() + " " + e.getApellidoP() + " " + e.getApellidoM() 
					+ "\nFecha de nacimiento : " + e.getFecha() + "\n\n";
		}
		return lista_empleados;
	}
	
	public static Ej3Empleado empleadoPorId(String nuevaID, ArrayList<Ej3Empleado> empleados) {
		//Buscar un empleado por su id
		for(Ej3Empleado e : empleados) {
			if(e.getId().equals(nuevaID)) return e;
		}
		return null;
		
	}
	public static boolean validarID(String nuevaID, ArrayList<Ej3Empleado> empleados) {
		//Validar si la ID del empleado a crear ya existe
		if(nuevaID.isEmpty()) return false;
		for(Ej3Empleado e : empleados) {
			if(e.getId().equals(nuevaID)) return false;
		}
		return true;
	}
	
	public static boolean validarFecha(String date) {
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
	
	public static boolean validarNombre(String name) {
		//Validar que el texto solo posea letras
		for(int i = 0; i < name.length(); i++) {
			char tmp = name.charAt(i);
			if(!Character.isLetter(tmp)) return false;
		}
		return true;
	}
	
	public static ArrayList<Ej3Empleado> ordenarPorEdad(ArrayList<Ej3Empleado> empleados) throws ParseException{
		for(int i = 0; i < empleados.size() - 1; i++) {
			for(int j = i+1; j < empleados.size(); j++) {
				if(empleados.get(i).getEdad() > empleados.get(j).getEdad()) {
					Ej3Empleado tmp = empleados.get(j);
					empleados.set(j, empleados.get(i));
					empleados.set(i, tmp);
				}
			}
		}
		return empleados;
	}
	
	public static ArrayList<Ej3Empleado> ordenarPorApellido(ArrayList<Ej3Empleado> empleados){
		for(int i = 0; i < empleados.size() - 1; i++) {
			for(int j = i+1; j < empleados.size(); j++) {
				if( empleados.get(i).apellido_p.compareTo(empleados.get(j).getApellidoP()) > 0) {
					Ej3Empleado tmp = empleados.get(j);
					empleados.set(j, empleados.get(i));
					empleados.set(i, tmp);
					
				}
			}
		}
		return empleados;
	}
	
	
	
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean cont = true;
		
		ArrayList<Ej3Empleado> empleados= new ArrayList<Ej3Empleado>();
		
		while(cont) {
			System.out.println("MENU\n"
					+ "Añadir empleado ingrese 1\n"
					+ "Obtener edad de un empleado ingrese 2\n"
					+ "Lista de empleados por edad ingrese 3\n"
					+ "Lista de empleados por apellido paterno en orden alfabético ingrese 4\n"
					+ "Ingrese cualquier otro valor para salir");
			
			int op = 0;
			
			try {
				op = Integer.parseInt(br.readLine().strip());
			}
			catch (Exception e) {
				cont = false;
			}
				
			switch(op) {
			
				case 1: 
					
					System.out.println("Para añadir un nuevo empleado ingrese una ID\n"
							+ "Pulse ENTER para salir");
					String id = br.readLine().strip();
		
					if(id.isBlank()) break;
					
					System.out.println("Nombre(s)\n");
					String nombre = br.readLine().strip();
					
					System.out.println("Apellido paterno\n");
					String apellido_p = br.readLine().strip();
					
					System.out.println("Apellido materno\n");
					String apellido_m = br.readLine().strip();
					
					System.out.println("Fecha de nacimiento en formato dd/MM/yyyy\n");
					String fecha = br.readLine().strip();
					
					if(!validarID(id, empleados)) {
						System.out.println("La ID del empleado ya existe\n");
					}
					else if(!validarFecha(fecha)) {
						System.out.println("La fecha de nacimiento es inválida\n");
					}
					else if(!validarNombre(nombre) || !validarNombre(apellido_p) || !validarNombre(apellido_m)) {
						System.out.println("Nombre/Apellido inválidos, deben ser solo letras\n");
					} else {
						Ej3Empleado nuevo = new Ej3Empleado(id, nombre, apellido_p, apellido_m, fecha);
						empleados.add(nuevo);		
					}
					
					break;
				
				case 2: 
					System.out.println("Ingrese una ID");
					String id_emp = br.readLine().strip();
					Ej3Empleado tmp = empleadoPorId(id_emp, empleados);
					if(tmp == null) {
						System.out.println("El empleado no existe");
					} 
					else {
						System.out.println("La edad del empleado es "
								+ String.valueOf(tmp.getEdad()));
					}
					break;
				
				case 3 : 
					empleados = ordenarPorEdad(empleados);
					System.out.println(imprimirEmpleados(empleados));	
					break;
				
				case 4: 
					empleados = ordenarPorApellido(empleados);
					System.out.println(imprimirEmpleados(empleados));
					break;
				
				default: 
					cont = false;
				
		
			}
				
				
			
		}
		
		System.out.println("Saliendo del programa");
		

		
		br.close();
		
		
	}

}
