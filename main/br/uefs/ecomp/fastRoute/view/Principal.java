package br.uefs.ecomp.fastRoute.view;

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
		
		PontoPassagem p1 = new PontoPassagem("UM");
		PontoPassagem p2 = new PontoPassagem("DOIS");
		PontoPassagem p3 = new PontoPassagem("TRES");
		
		grafo.addVertice(p1);
		grafo.addVertice(p2);
		grafo.addVertice(p3);
		grafo.addAresta(p1, p2, 4);
		grafo.addAresta(p2, p3, 5);
		
		System.out.println("" +p3.getId());
		int[][] matriz = grafo.paraMatriz();
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
