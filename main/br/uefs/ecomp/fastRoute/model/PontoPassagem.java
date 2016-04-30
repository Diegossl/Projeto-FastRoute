package br.uefs.ecomp.fastRoute.model;

import java.util.ArrayList;
import java.util.Iterator;

import br.uefs.ecomp.fastRoute.util.Aresta;
import br.uefs.ecomp.fastRoute.util.Ponto;

public class PontoPassagem extends Ponto {
	
	private static int idClasse = -1;
	

	public PontoPassagem(String nome, ArrayList<Aresta> listaArestas) {
		super(nome, listaArestas);
		idClasse++;
		this.id = idClasse;
	}
	
	public PontoPassagem(String nome) {
		this.nome = nome;
		listaArestas = new ArrayList<Aresta>();
		idClasse++;
		this.id = idClasse;
	}
	
	@Override
	public void addAresta(Aresta aresta) {
		listaArestas.add(aresta);
	}

	@Override
	public boolean removerAresta(Aresta aresta) {
		return listaArestas.remove(aresta);
	}

	@Override
	public Iterator<Aresta> iterator() {
		return listaArestas.iterator();
	}
}
