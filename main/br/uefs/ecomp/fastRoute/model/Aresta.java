package br.uefs.ecomp.fastRoute.model;

public class Aresta {
	
	private Vertice pontoAdjacente;
	private double tempo;
	
	public Aresta(Vertice adj){
		this.pontoAdjacente = adj;
	}
	
	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public Vertice getPontoAdjacente() {
		return pontoAdjacente;
	}
	
	public void setPontoAdjacente(Vertice pontoAdjacente) {
		this.pontoAdjacente = pontoAdjacente;
	}
}
