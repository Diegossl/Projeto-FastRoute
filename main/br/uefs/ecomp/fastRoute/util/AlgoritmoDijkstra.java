package br.uefs.ecomp.fastRoute.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AlgoritmoDijkstra {
	
	private static final int INDEFINIDO = -1;
	private Grafo grafo;
	
	public AlgoritmoDijkstra(Grafo grafo){
		this.grafo = grafo;
	}
	
	public ArrayList<Integer> caminho(int inicio, int fim){
		int custo[] = new int[grafo.getMatrizAdj().length];
		int antecessores[] = new int[grafo.getMatrizAdj().length];
		Set<Integer> naoVisitados = new HashSet<>();

		custo[inicio] = 0;
		for (int v = 0; v < grafo.getMatrizAdj().length; v++) {
			if (v != inicio) {
				custo[v] = Integer.MAX_VALUE;
			}
			antecessores[v] = INDEFINIDO;
			naoVisitados.add(v);
		}

		while(!naoVisitados.isEmpty()){
			int menorDistancia =  menorDistancia(custo, naoVisitados);
			naoVisitados.remove(menorDistancia);

			for (Integer vizinho : getVizinhos(menorDistancia)) {
				int custoTotal = custo[menorDistancia] + getCusto(menorDistancia, vizinho);
				if (custoTotal < custo[vizinho]) {
					custo[vizinho] = custoTotal;
					antecessores[vizinho] = menorDistancia;
				}
				if (menorDistancia == fim) {
					return listaCaminhos(antecessores, menorDistancia);
				}
			}
		}
		return null;
	}

	public ArrayList<Integer> listaCaminhos(int[] antecessores, int u) {
		ArrayList<Integer> caminho = new ArrayList<Integer>();
		caminho.add(u);
		while(antecessores[u] != INDEFINIDO) {
			caminho.add(antecessores[u]);
			u = antecessores[u];
		}
		Collections.reverse(caminho);
		return caminho;
	}

	public int getCusto(int vertice1, int vertice2) {
		return grafo.getMatrizAdj()[vertice1][vertice2];
	}

	public ArrayList<Integer> getVizinhos(int vertice) {
		ArrayList<Integer> vizinhos = new ArrayList<Integer>();
		for (int i = 0; i < grafo.getMatrizAdj()[vertice].length; i++)
			if (grafo.getMatrizAdj()[vertice][i] > 0) {
				vizinhos.add(i);
			}
		return vizinhos;
	}

	public int menorDistancia(int[] dist, Set<Integer> naoVisitados) {
		double minDist = Integer.MAX_VALUE;
		int minIndex = 0;
		for (Integer i : naoVisitados) {
			if (dist[i] < minDist) {
				minDist = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

}
