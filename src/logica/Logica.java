package logica;

import java.util.*;

import javax.swing.JOptionPane;

public class Logica {
	private HashMap<String,Integer> temperatura;
	private String[] opciones;
	private boolean modo;
	
	public Logica() {}
	
	public Logica(boolean modo) {
		this.opciones = new String[3];
		this.modo = modo;
		if(this.modo) {
			opciones[0] = "Celsius";
			opciones[1] = "Fahrenheit";
			opciones[2] = "Kelvin";
		}else {
			opciones[0] = "Dolar americano";
			opciones[1] = "Euro";
			opciones[2] = "Peso colombiano";
		}
	}
	
	public String[] mostrarOpciones(){
		return opciones;
	}
	
	public String resultado(int combo1, int combo2, String text) {
		//System.out.println(combo1+"-"+combo2+"-"+text);
		String res = text;
		Double valor = 0.00;
		if(isNumeric(res)) {
			valor = Double.parseDouble(res);
			if(this.modo) {
				valor = calcularTemperatura(combo1, combo2, valor);
			}else {
				valor = calcularMoneda(combo1, combo2, valor);
			}
			
		}
		return String.format("%.2f", valor);
	}
	public boolean isNumeric(String text) {
		try {
			Double.parseDouble(text);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
	private double calcularTemperatura(int combo1, int combo2, double valor) {
		double res = 0;
		//celsius
		if(combo1 == 1) {
			if(combo2 == 2) {
				res = (valor * 9/5) + 32;
			}else if(combo2 == 3) {
				res = valor + 273;
			}else {
				res = valor;
			}
		//Fahrenheit
		}else if(combo1 == 2) {
			if(combo2 == 1) {
				res = (valor - 32) * 5/9;
			}else if(combo2 == 3) {
				res = (valor - 32) * 5/9 + 273;
			}else {
				res = valor;
			}
		//Kelvin
		}else if(combo1 == 3) {
			if(combo2 == 1) {
				res = valor - 273;
			}else if(combo2 == 2) {
				res = (valor - 273) * 9/5 + 32;
			}else {
				res = valor;
			}
		}
		
		return res;
	}
	private double calcularMoneda(int combo1, int combo2, double valor) {
		double res = 0;
		//Dolar americano
		if(combo1 == 1) {
			if(combo2 == 2) {
				res = valor * 0.91;
			}else if(combo2 == 3) {
				res = valor * 3956;
			}else {
				res = valor;
			}
		//Euro
		}else if(combo1 == 2) {
			if(combo2 == 1) {
				res = valor*1.10;
			}else if(combo2 == 3) {
				res = valor*4342.78;
			}else {
				res = valor;
			}
		//Peso colombiano
		}else if(combo1 == 3) {
			if(combo2 == 1) {
				res = valor/3956;
			}else if(combo2 == 2) {
				res = valor/4342.78;
			}else {
				res = valor;
			}
		}
		
		return res;
	}

	
}
