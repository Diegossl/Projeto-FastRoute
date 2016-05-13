package br.uefs.ecomp.fastRoute.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Vertice {
	
	private String nome;
	private ArrayList<Aresta> listaArestas;
	private int x;
	private int y;
	
	public Vertice(String nome) {
		this.nome = nome;
		listaArestas = new ArrayList<Aresta>();
	}
	
	public void addAresta(Aresta aresta) {
		listaArestas.add(aresta);
	}
	
	public boolean removerAresta(Aresta aresta) {
		return listaArestas.remove(aresta);
	}
	
	public Iterator<Aresta> iterator() {
		return listaArestas.iterator();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public String toString() {
		return nome;
	}
	
	public ArrayList<Aresta> getLista() {
		return listaArestas;
	}
}
