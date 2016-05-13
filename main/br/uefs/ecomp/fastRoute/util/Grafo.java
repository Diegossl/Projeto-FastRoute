package br.uefs.ecomp.fastRoute.util;

public class Grafo {

	private int[][] matrizAdjacente;

	public Grafo(int numVertice){
		matrizAdjacente = new int[numVertice][numVertice];
	}
	
	public int[][] getMatrizAdj(){
		return matrizAdjacente;
	}

	public void addAresta(int vertice1, int vertice2, int peso) {
		matrizAdjacente[vertice1][vertice2] = peso;
		matrizAdjacente[vertice2][vertice1] = peso;
	}
	
	public void removerAresta(int vertice1, int vertice2) {
		matrizAdjacente[vertice1][vertice2] = 0;
		matrizAdjacente[vertice2][vertice1] = 0;
	}
	
	public int recuperarAresta(int vertice1, int vertice2){
		return matrizAdjacente[vertice1][vertice2];
	}

}
