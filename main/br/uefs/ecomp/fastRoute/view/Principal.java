package br.uefs.ecomp.fastRoute.view;

import java.util.ArrayList;
import java.util.Iterator;

import br.uefs.ecomp.fastRoute.model.PontoColeta;
import br.uefs.ecomp.fastRoute.model.PontoDestino;
import br.uefs.ecomp.fastRoute.model.PontoPartida;
import br.uefs.ecomp.fastRoute.model.PontoPassagem;
import br.uefs.ecomp.fastRoute.util.AlgoritmoDijkstra;
import br.uefs.ecomp.fastRoute.util.Aresta;
import br.uefs.ecomp.fastRoute.util.Grafo;
import br.uefs.ecomp.fastRoute.util.Ponto;

public class Principal {
	
	private static Grafo grafo;
	
	public static void main(String [] args){
		
		grafo = Grafo.getInstance();
		
//		PontoPassagem a = new PontoPassagem("A");
//		PontoPassagem b = new PontoPassagem("B");
//		PontoPassagem s = new PontoPassagem("S");
//		PontoPassagem d = new PontoPassagem("D");
//		PontoPassagem t = new PontoPassagem("E");
//		
//		grafo.addVertice(a);
//		grafo.addVertice(b);
//		grafo.addVertice(s);
//		grafo.addVertice(d);
//		grafo.addVertice(t);
//		
//		grafo.addAresta(s, a, 10);
//		grafo.addAresta(s, b, 3);
//		grafo.addAresta(a, t, 2);
//		grafo.addAresta(a, b, 5);
//		grafo.addAresta(b, t, 7);
//		grafo.addAresta(b, d, 2);
//		grafo.addAresta(t, d, 3);
		PontoPassagem a = new PontoPassagem("A");
		PontoPassagem b = new PontoPassagem("B");
		PontoPassagem c = new PontoPassagem("C");
		PontoPassagem d = new PontoPassagem("D");
		PontoPassagem e = new PontoPassagem("E");
		
		grafo.addVertice(a);
		grafo.addVertice(b);
		grafo.addVertice(d);
		grafo.addVertice(e);
		grafo.addVertice(c);
		
		grafo.addAresta(a, b, 50);
		grafo.addAresta(a, d, 80);
		grafo.addAresta(b, c, 60);
		grafo.addAresta(b, d, 90);
		grafo.addAresta(d, c, 20);
		grafo.addAresta(d, e, 70);
		grafo.addAresta(c, e, 40);
		
		int[][] matriz = grafo.paraMatriz();
		System.out.println("" +matriz.length);
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		AlgoritmoDijkstra alg = new AlgoritmoDijkstra(matriz);
		int[] caminho = alg.menorCaminho();
//		Iterator<Integer> iterador = caminho.iterator();
//		while(iterador.hasNext()) {
//			System.out.println(iterador.next() + "->");
//		}
		for(int i = 0; i < caminho.length; i++) {
			System.out.print(caminho[i] + " ");
		}
		
	}

}
//TESTE 1
//grafo = Grafo.getInstance();
//
//PontoPassagem p1 = new PontoPassagem("UM");
//PontoPassagem p2 = new PontoPassagem("DOIS");
//PontoPassagem p3 = new PontoPassagem("TRES");
//
//grafo.addVertice(p1);
//grafo.addVertice(p2);
//grafo.addVertice(p3);
//grafo.addAresta(p1, p2, 4);
//grafo.addAresta(p2, p3, 5);
//
//
//int[][] matriz = grafo.paraMatriz();
//for(int i = 0; i < matriz.length; i++) {
//	for(int j = 0; j < matriz.length; j++) {
//		System.out.print(matriz[i][j] + " ");
//	}
//	System.out.println();
//}
//
//}