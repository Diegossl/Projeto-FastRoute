package br.uefs.ecomp.fastRoute.util;

public class Aresta {
	
	private Ponto pontoAdjacente;
	private double tempo;
	
	public Aresta(Ponto adj){
		this.pontoAdjacente = adj;
	}
	
	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public Ponto getPontoAdjacente() {
		return pontoAdjacente;
	}
}
