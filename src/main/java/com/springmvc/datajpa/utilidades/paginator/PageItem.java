package com.springmvc.datajpa.utilidades.paginator;

/**
 * @author María José
 *
 */
public class PageItem {
	
	private int numero;
	
	private boolean actual;
	
	/**
	 * @param numero
	 * @param actual
	 */
	public PageItem(int numero, boolean actual) {
		this.numero = numero;
		this.actual = actual;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public boolean isActual() {
		return actual;
	}
	
}