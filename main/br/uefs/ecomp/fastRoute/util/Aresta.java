package br.uefs.ecomp.fastRoute.util;

public class Aresta {
	
	private Ponto adjacencia;
	private double tempo;
	
	public Aresta(Ponto adj){
		this.adjacencia = adj;
	}
	
	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public Ponto getAdjacencia() {
		return adjacencia;
	}
}
