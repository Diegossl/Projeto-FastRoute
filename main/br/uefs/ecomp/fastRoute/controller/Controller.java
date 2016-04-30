package br.uefs.ecomp.fastRoute.controller;

import br.uefs.ecomp.fastRoute.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.fastRoute.exceptions.PontoNuloException;
import br.uefs.ecomp.fastRoute.util.Grafo;
import br.uefs.ecomp.fastRoute.util.Ponto;

public class Controller {
	
	private static Controller instanciaController;
	private static Grafo grafo;
	
	private Controller(){
		Grafo.zerarSingleton();
		grafo = Grafo.getInstance();
	}
	
	public static Controller getInstance(){
		if(instanciaController == null)
			instanciaController = new Controller();
		return instanciaController;
	}
	
	public static void zerarSingleton() {
		instanciaController = null;
	}
	
	public Ponto cadastrarPonto(Ponto ponto) throws PontoNuloException, CampoObrigatorioInexistenteException{
		if(ponto == null)
			throw new PontoNuloException();
		if(ponto.getNome().trim().isEmpty())
			throw new CampoObrigatorioInexistenteException();
		grafo.addVertice(ponto);
		return ponto;
	}
	
	public void cadastrarAresta(Ponto origem, Ponto destino, double tempo) throws PontoNuloException{
		if(origem == null || destino == null)
			throw new PontoNuloException();
		grafo.addAresta(origem, destino, tempo);
	}
	
	public boolean removerAresta(Ponto origem, Ponto destino) throws PontoNuloException{
		if(origem == null || destino == null)
			throw new PontoNuloException();
		return grafo.removerAresta(origem, destino);
	}

	public boolean removerPontoAresta(Ponto ponto) throws PontoNuloException{
		if(ponto == null)
			throw new PontoNuloException();
		return grafo.removerVerticeAresta(ponto);
	}
	
	public void calcularMenorRota(){
		
	}
	
	
}
