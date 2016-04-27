package br.uefs.ecomp.fastRoute.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlgoritmoDijkstra {
	
	private Grafo grafo;
	private final int INFINITO = 1000000;
	private ArrayList<Ponto> menorCaminho;
	private int[][] matAdj;
	private int[] custos;
	private int[] anteriores;
	private ArrayList<Integer> naoVisitados;
	
	private int comeco;
	private int fim;
	
	
	public AlgoritmoDijkstra(Grafo grafo){
		this.grafo = grafo;
		menorCaminho = new ArrayList<Ponto>();
	}
	
//	public ArrayList<Ponto> menorCaminho(){
//		return null;
//	}
	public void inicializarCustos() {
		custos[0] = 0;
		for(int i = 1; i < matAdj.length; i++) {
			custos[i] = INFINITO;
		}
	}
//	public Ponto menorAresta(Ponto ponto){
//		Iterator<Aresta> i = ponto.iterator();
//		Aresta atual = null;
//		Aresta menor = i.next();
//		while(i.hasNext()){
//			atual = i.next();
//			if(atual.getTempo() < menor.getTempo())
//				menor = atual;
//		}
//		return menor.getPontoAdjacente();
//	}
	public void menorCaminho(){
		inicializarCustos();
		
		int atual = menorProximo();
		naoVisitados.remove(atual);
		 for(Integer vizinho : pegarVizinhos(atual)) {
			 int custoTotal = custos[atual] + pegaCusto(atual, vizinho);
			 if(custoTotal < custos[vizinho]) {
				 custos[vizinho] = custoTotal;
				 anteriores[vizinho] = atual;
			 }
		 }
	}
	public int menorProximo() {
		int minimo = INFINITO;
		for(int i = 0; i < matAdj[0].length; i++) {
			if(custos[i] < minimo && naoVisitados.get(i) == -1) {
				minimo = i;
			}
		}
		return minimo;
	}
	public ArrayList<Integer> pegarVizinhos(int ponto) {
		ArrayList<Integer> vizinhos = new ArrayList<>();
		for(int i = 0; i < matAdj[ponto].length; i++) {
			if(matAdj[ponto][i] > 0) {
				vizinhos.add(i);
			}
		}
		return vizinhos;
	} 
	private Integer pegaCusto(Integer atual, Integer vizinho) {
		return matAdj[atual][vizinho];
	}
}
