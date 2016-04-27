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
		
		
	}

}
