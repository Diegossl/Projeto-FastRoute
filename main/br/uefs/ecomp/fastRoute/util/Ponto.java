package br.uefs.ecomp.fastRoute.util;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Ponto {
	
	protected String nome;
	protected int id;
	

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
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the listaArestas
	 */
	public ArrayList<Aresta> getListaArestas() {
		return listaArestas;
	}

	/**
	 * @param listaArestas the listaArestas to set
	 */
	public void setListaArestas(ArrayList<Aresta> listaArestas) {
		this.listaArestas = listaArestas;
	}
}
