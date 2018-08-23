package com.springmvc.datajpa.utilidades.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<X> {
	
	private String url;
	
	/* Listado paginable, en este caso de clientes */
	private Page<X> page;
	
	private int totalPaginas;
	
	private int nElemPorPagina;
	
	private int pagActual;
	
	private List<PageItem> paginas;
	
	/**
	 * Constructor
	 * 
	 * @param url
	 * @param page
	 */
	public PageRender(String url, Page<X> page) {
		int desde, hasta;
		
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();
		
		nElemPorPagina = page.getSize();
		totalPaginas = page.getTotalPages();
		pagActual = page.getNumber() + 1;
		
		if (totalPaginas <= nElemPorPagina) {
			desde = 1;
			hasta = totalPaginas;
		} else {
			/* Rango inicial */
			if (pagActual <= nElemPorPagina / 2) {
				desde = 1;
				hasta = nElemPorPagina;
				/* Rango final */
			} else if (pagActual >= (totalPaginas - nElemPorPagina / 2)) {
				desde = totalPaginas - nElemPorPagina + 1;
				hasta = nElemPorPagina;
				/* Rango medio */
			} else {
				desde = pagActual - nElemPorPagina / 2;
				hasta = nElemPorPagina;
			}
		}
		
		for (int i = 0; i < hasta; i++) {
			paginas.add(new PageItem(desde + i, pagActual == desde + i));
		}
	} // Fin constructor
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @return the totalPaginas
	 */
	public int getTotalPaginas() {
		return totalPaginas;
	}
	
	/**
	 * @return the pagActual
	 */
	public int getPagActual() {
		return pagActual;
	}
	
	/**
	 * @return the paginas
	 */
	public List<PageItem> getPaginas() {
		return paginas;
	}
	
	/* Devuelve si la página es la primera */
	public boolean isFirst() {
		return page.isFirst();
	}
	
	/* Devuelve si la página es la última */
	public boolean isLast() {
		return page.isLast();
	}
	
	/* Para avanzar: Devuelve si tiene página siguiente */
	public boolean isHasNext() {
		return page.hasNext();
	}
	
	/* Para retroceder: Devuelve si tiene página anterior */
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
}
