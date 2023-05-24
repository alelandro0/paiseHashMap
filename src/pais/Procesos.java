package pais;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

public class Procesos {
	private String pais;
	private String ciudad;
	ArrayList<String> NCiudad;
	HashMap<String, ArrayList<String>> map;

	public Procesos() {
		NCiudad = new ArrayList<>();
		map = new HashMap<>();
		iniciar();
	}

	public void iniciar() {
		String msg = "***MENU**\n\n";
		msg += "1) Registrar Pais\n";
		msg += "2) Registrar Ciudades\n";
		msg += "3) Consultar Ciudades por pais\n";
		msg += "4) Consultar Pais por ciudad\n";
		msg += "5) Salir\n\n ";
		int opt = 0;
		do {
			String input=JOptionPane.showInputDialog(msg);
			if (input.isEmpty()) {
				JOptionPane.showMessageDialog(null, "opcion invalida");
				continue;
			}
			opt = Integer.parseInt(input);
		
			menu(opt);
		} while (opt != 5);


	}

	private void menu(int opt) {
		switch (opt) {
		case 1:
			registrarPais();
			break;
		case 2:
			if (pais==null) {
				JOptionPane.showMessageDialog(null, "Registra pais");
			}else {
				registrarCiuda();
			}
			break;
		case 3:
			ConsultarPaisPorCiudades();
			break;
		case 4:
			ConsultarCiudadesPorPais();
			break;

		default:
			break;
		}
	}

	private void ConsultarPaisPorCiudades() {
	    String resul = JOptionPane.showInputDialog("Ingrese la ciudad para buscar el país:");
	    if (resul == null) {
	        return; 
	    }

	    String paisEncontrado = null;
	    for (Map.Entry<String, ArrayList<String>> entry :map.entrySet()) {
	        String pais = entry.getKey();
	        ArrayList<String> ciudades = entry.getValue();
	        if (ciudades.contains(resul)) {
	            if (paisEncontrado == null) {
	                paisEncontrado = pais;
	            } else {
	                JOptionPane.showMessageDialog(null, "Hay varios países que contienen la ciudad especificada.");
	                return;
	            }
	        }
	    }

	    if (paisEncontrado == null) {
	        JOptionPane.showMessageDialog(null, "No se encontró ningún país que contenga la ciudad especificada.");
	    } else {
	        JOptionPane.showMessageDialog(null, "El país que contiene la ciudad especificada es: " + paisEncontrado);
	    }
	}

	private void ConsultarCiudadesPorPais() {
		String conPais= JOptionPane.showInputDialog("buscar pais para listar ciudades");
		if (conPais==null) {
			return;
		}
		int contador=0;
		String acuCiudad=null;
		String country=null;
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			String listaPais = entry.getKey();
			ArrayList<String> listaCiudad = entry.getValue();
			if (listaPais.contains(conPais)) {
				contador++;
				country=listaPais;
				for (int i = 0; i < listaCiudad.size(); i++) {
					JOptionPane.showMessageDialog(null, listaCiudad.get(i));
				}	
			}	
		}if (contador==0) {
			JOptionPane.showMessageDialog(null, "No se encuentra registro");
		}
	}

	private void registrarCiuda() {
		NCiudad = new ArrayList<>();
		String validar = "";
		do {
			ciudad = JOptionPane.showInputDialog("registar ciudad");
			NCiudad.add(ciudad);
			validar = JOptionPane.showInputDialog("Si para salir");
		} while (!validar.equalsIgnoreCase("si"));
		map.put(pais, NCiudad);
		System.out.println(map);

	}

	private void registrarPais() {
		pais = JOptionPane.showInputDialog("Nombre del pais");

	}

}
