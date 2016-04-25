package br.uefs.ecomp.fastRoute.util;

import java.util.Iterator;

public interface IGrafo {
	
	public int obterTamanho();
	
	public Iterator<?> iterator();
	
	public void addVertice(Object o);
	
	public void addAresta(Object origem, Object destino, double peso);
	
	public Object buscarAresta(Object origem, Object destino);
	
	public boolean removerAresta(Object origem, Object destino);
	
	public boolean removerVerticeAresta(Object o);

}
