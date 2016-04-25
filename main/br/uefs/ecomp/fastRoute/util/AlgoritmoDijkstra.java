package br.uefs.ecomp.fastRoute.util;

import java.util.ArrayList;
import java.util.Iterator;

public class AlgoritmoDijkstra {
	
	private Grafo grafo;
	private ArrayList<Ponto> menorCaminho;
	
	public AlgoritmoDijkstra(Grafo grafo){
		this.grafo = grafo;
		menorCaminho = new ArrayList<Ponto>();
	}
	
	public ArrayList<Ponto> menorCaminho(){
		return null;
	}
	
	public Ponto menorAresta(Ponto ponto){
		Iterator<Aresta> i = ponto.iterator();
		Aresta atual = null;
		Aresta menor = i.next();
		while(i.hasNext()){
			atual = i.next();
			if(atual.getTempo() < menor.getTempo())
				menor = atual;
		}
		return menor.getPontoAdjacente();
	}
	
}
