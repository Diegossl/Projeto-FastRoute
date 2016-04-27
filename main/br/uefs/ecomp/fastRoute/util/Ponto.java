package br.uefs.ecomp.fastRoute.util;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Ponto {
	
	protected String nome;
	protected ArrayList<Aresta> listaArestas;
	
	public Ponto(String nome, ArrayList<Aresta> listaArestas){
		
	}
	
	public Ponto(){
		
	}
	
	public abstract void addAresta(Aresta aresta);
	
	public abstract boolean removerAresta(Aresta aresta);
	
	public abstract Iterator<Aresta> iterator();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public int[][] gerarMatriz(ArrayList<Ponto> pontos) {
		
	}
}
