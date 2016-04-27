package br.uefs.ecomp.fastRoute.util;

import java.util.ArrayList;
import java.util.Iterator;

public class Grafo implements IGrafo {

	private ArrayList<Ponto> listaPontos;
	private static Grafo instanciaGrafo;

	private Grafo(){
		listaPontos = new ArrayList<Ponto>();
	}
	
	public static Grafo getInstance(){
		if(instanciaGrafo == null)
			instanciaGrafo = new Grafo();
		return instanciaGrafo;
	}
	
	public static void zerarSingleton() {
		instanciaGrafo = null;
	}

	@Override
	public int obterTamanho() {
		return listaPontos.size();
	}

	@Override
	public Iterator<Ponto> iterator() {
		return listaPontos.iterator();
	}

	@Override
	public void addVertice(Object o) {
		listaPontos.add((Ponto) o);
	}

	@Override
	public void addAresta(Object origem, Object destino, double peso) {
		Ponto p1 = (Ponto) origem;
		Ponto p2 = (Ponto) destino;
		Aresta arestaDestino = new Aresta(p2);//Crio aresta com ponto p2
		arestaDestino.setTempo(peso);
		Aresta arestaOrigem = new Aresta(p1);//Crio aresta com ponto p1
		arestaOrigem.setTempo(peso);
		p1.addAresta(arestaDestino);//Adiciono ao ponto p1 a aresta que liga origem ao destino
		p2.addAresta(arestaOrigem);//Adiciono ao ponto p2 a aresta que liga destino a origem
	}

	@Override
	public Aresta buscarAresta(Object origem, Object destino) {
		/*Procuro pela aresta que contem o ponto destino dentro da lista de arestas de do ponto origem*/
		Ponto pontoInicial = (Ponto) origem;
		Ponto pontoFinal = (Ponto) destino;
		Iterator<Aresta> i = pontoInicial.iterator();
		Aresta aresta = null;
		while(i.hasNext()){
			aresta = i.next();
			if(aresta.getPontoAdjacente().equals(pontoFinal))
				return aresta;
		}
		return null;
	}

	@Override
	public boolean removerAresta(Object origem, Object destino) {
		/*Removo as arestas: origem-destino e destino-origem*/
		Aresta arestaDestino = buscarAresta(origem, destino);
		Aresta arestaOrigem = buscarAresta(destino, origem);
		if(arestaDestino != null && arestaOrigem != null){
			((Ponto) origem).removerAresta(arestaDestino);
			((Ponto) destino).removerAresta(arestaOrigem);
			return true;
		}
		return false;
	}

	@Override
	public boolean removerVerticeAresta(Object o) {
		/*Removo o ponto e as arestas adjacentes a ele.
		 * Obs: ainda vou revisar esse código*/
		Ponto ponto = (Ponto) o;
		Iterator<Aresta> i = ponto.iterator();
		Aresta arestaAtual = null;
		Aresta achou = null;
		Ponto destino = null;
		while(i.hasNext()){
			arestaAtual = i.next();
			destino = arestaAtual.getPontoAdjacente();
			achou = buscarAresta(destino, ponto);
			if(achou != null){
				destino.removerAresta(achou);
				ponto.removerAresta(arestaAtual);
			}
			else
				break;
		}
		if(!ponto.iterator().hasNext())
			return true;
		return false;
	}
	
}
