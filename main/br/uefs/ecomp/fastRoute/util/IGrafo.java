package br.uefs.ecomp.fastRoute.util;

import java.util.Iterator;

public interface IGrafo {
	
	public int obterTamanho();
	
	public Iterator<?> imprimirGrafo();
	
	public void addVertice(Object o);
	
	public void addAresta(Object origem, Object destino);
	
	public Aresta buscarAresta(Object origem, Object destino);
	
	public boolean removerAresta(Object origem, Object destino);
	
	public boolean removerVerticeAresta(Object o);

}
