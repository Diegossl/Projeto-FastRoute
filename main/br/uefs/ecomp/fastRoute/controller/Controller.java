package br.uefs.ecomp.fastRoute.controller;

import java.util.ArrayList;
import java.util.Iterator;

import br.uefs.ecomp.fastRoute.exceptions.ArestaInvalidaException;
import br.uefs.ecomp.fastRoute.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.fastRoute.exceptions.PontoInvalidoException;
import br.uefs.ecomp.fastRoute.exceptions.PontoNuloException;
import br.uefs.ecomp.fastRoute.model.Aresta;
import br.uefs.ecomp.fastRoute.model.Vertice;
import br.uefs.ecomp.fastRoute.util.AlgoritmoDijkstra;
import br.uefs.ecomp.fastRoute.util.Grafo;

public class Controller {

	private static Controller instanciaController;
	private ArrayList<Vertice> listaPontos;

	private Controller(){
		listaPontos = new ArrayList<Vertice>();
	}

	public static Controller getInstance(){
		if(instanciaController == null)
			instanciaController = new Controller();
		return instanciaController;
	}

	public static void zerarSingleton() {
		instanciaController = null;
	}

	public ArrayList<Vertice> getListaPontos(){
		return listaPontos;
	}

	public Vertice cadastrarVertice(Vertice ponto) throws PontoNuloException, CampoObrigatorioInexistenteException, PontoInvalidoException{
		if(ponto == null)
			throw new PontoNuloException();
		else if(ponto.getNome().trim().isEmpty())
			throw new CampoObrigatorioInexistenteException();
		else if(buscarVertice(ponto.getNome()) != null)
			throw new PontoInvalidoException();
		else{
			listaPontos.add(ponto);
			return ponto;
		}
	}

	public void cadastrarAresta(Vertice origem, Vertice destino, double tempo) throws PontoNuloException, ArestaInvalidaException{
		if(origem == null || destino == null)
			throw new PontoNuloException();
		else if(origem.equals(destino))
			throw new ArestaInvalidaException();
		else{
			Vertice p1 = (Vertice) origem;
			Vertice p2 = (Vertice) destino;
			Aresta arestaDestino = new Aresta(p2);//Crio aresta com ponto p2
			arestaDestino.setTempo(tempo);
			Aresta arestaOrigem = new Aresta(p1);//Crio aresta com ponto p1
			arestaOrigem.setTempo(tempo);
			p1.addAresta(arestaDestino);//Adiciono ao ponto p1 a aresta que liga origem ao destino
			p2.addAresta(arestaOrigem);//Adiciono ao ponto p2 a aresta que liga destino a origem
		}
	}

	private Vertice buscarVertice(String nome){
		Iterator<Vertice> i = listaPontos.iterator();
		Vertice atual = null;
		while(i.hasNext()){
			atual = i.next();
			if(atual.getNome().equals(nome))
				return atual;
		}
		return null;
	}

	public Aresta buscarAresta(Object origem, Object destino) {
		/*Procuro pela aresta que contem o ponto destino dentro da lista de arestas de do ponto origem*/
		Vertice pontoInicial = (Vertice) origem;
		Vertice pontoFinal = (Vertice) destino;
		Iterator<Aresta> i = pontoInicial.iterator();
		Aresta aresta = null;
		while(i.hasNext()){
			aresta = i.next();
			if(aresta.getPontoAdjacente().equals(pontoFinal))
				return aresta;
		}
		return null;
	}

	public boolean removerAresta(Vertice origem, Vertice destino) throws PontoNuloException{
		if(origem == null || destino == null)
			throw new PontoNuloException();
		else{
			/*Removo as arestas: origem-destino e destino-origem*/
			Aresta arestaDestino = buscarAresta(origem, destino);
			Aresta arestaOrigem = buscarAresta(destino, origem);
			if(arestaDestino != null && arestaOrigem != null){
				origem.removerAresta(arestaDestino);
				destino.removerAresta(arestaOrigem);

				return true;
			}
			return false;
		}
	}

	public boolean removerVerticeAresta(Vertice ponto) throws PontoNuloException{
		if(ponto == null)
			throw new PontoNuloException();
		else{
			/*Removo o ponto e as arestas adjacentes a ele.
			 * Obs: ainda vou revisar esse c�digo*/
			Iterator<Aresta> i = ponto.iterator();
			Aresta arestaAtual = null;
			Aresta achou = null;
			Vertice destino = null;
			while(i.hasNext()){
				arestaAtual = i.next();
				destino = arestaAtual.getPontoAdjacente();
				achou = buscarAresta(destino, ponto);
				if(achou != null){
					destino.removerAresta(achou);
					i.remove();
				}
			}
			return listaPontos.remove(ponto);
		}
	}

	private Grafo criarGrafo() {
		Grafo grafo = new Grafo(listaPontos.size());
		Iterator<Vertice> itPonto = listaPontos.iterator();
		Vertice pontoAtual = null;
		Aresta arestaAtual = null;
		int i = 0;
		while(itPonto.hasNext()){
			pontoAtual = itPonto.next();
			Iterator<Aresta> itAresta = pontoAtual.iterator();
			while(itAresta.hasNext()){
				arestaAtual = itAresta.next();
				Vertice p = arestaAtual.getPontoAdjacente();
				grafo.addAresta(i, listaPontos.indexOf(p), (int) arestaAtual.getTempo());
			}
			i++;
		}
		return grafo;
	}

	public ArrayList<Vertice> calcularMenorRota(Vertice origem, Vertice destino){
		Grafo grafo = criarGrafo();

		int inicio = listaPontos.indexOf(origem);
		int fim = listaPontos.indexOf(destino);

		AlgoritmoDijkstra alg = new AlgoritmoDijkstra(grafo);

		ArrayList<Integer> listaIndices = alg.caminho(inicio, fim);

		ArrayList<Vertice> listaPontosMenorCaminho = new ArrayList<Vertice>();

		for(int i = 0; i < listaIndices.size(); i++){
			listaPontosMenorCaminho.add(listaPontos.get(listaIndices.get(i).intValue()));
		}
		return listaPontosMenorCaminho;
	}
	public ArrayList<Aresta> pegarArestasMenorRota(ArrayList<Vertice> caminho) {
		
		ArrayList<Aresta> arestasCaminho = new ArrayList<>();
		Iterator<Vertice> i = caminho.iterator();
		while(i.hasNext()) {
			Vertice ponto = i.next();
			Vertice proxPonto = i.next();
			Iterator<Aresta> iAresta = ponto.iterator();
			while(iAresta.hasNext()) {
				Aresta arestaAux = iAresta.next();
				if(arestaAux.getPontoAdjacente().equals(proxPonto))
					arestasCaminho.add(arestaAux);						
			}
		}
		return arestasCaminho;
	}
}
