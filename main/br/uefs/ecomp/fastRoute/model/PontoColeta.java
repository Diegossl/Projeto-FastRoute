package br.uefs.ecomp.fastRoute.model;

import java.util.ArrayList;

import br.uefs.ecomp.fastRoute.util.Aresta;
import br.uefs.ecomp.fastRoute.util.Ponto;

public class PontoColeta extends Ponto {
	
	public PontoColeta(String nome, ArrayList<Aresta> listaArestas) {
		super(nome, listaArestas);
	}

	public PontoColeta(String nome) {
		this.nome = nome;
		listaArestas = new ArrayList<Aresta>();
	}
	
	@Override
	public void addAresta(Aresta aresta) {
		listaArestas.add(aresta);
	}

	@Override
	public boolean removerAresta(Aresta aresta) {
		return listaArestas.remove(aresta);
	}
	
}
