
package br.uefs.ecomp.fastRoute.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.fastRoute.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.fastRoute.exceptions.PontoNuloException;
import br.uefs.ecomp.fastRoute.model.PontoColeta;
import br.uefs.ecomp.fastRoute.model.PontoPartida;
import br.uefs.ecomp.fastRoute.model.PontoPassagem;
import br.uefs.ecomp.fastRoute.util.AlgoritmoDijkstra;
import br.uefs.ecomp.fastRoute.util.Aresta;
import br.uefs.ecomp.fastRoute.util.Grafo;
import br.uefs.ecomp.fastRoute.util.Ponto;

public class ControllerTest {
	
	private Controller controller;

	@Before
	public void setUp() throws Exception {
		Controller.zerarSingleton();
		controller = Controller.getInstance();
	}
	
	@Test
	public void testCadastrarPontoSucesso(){
		Ponto novoPonto = new PontoPartida("A");
		
		Ponto ponto = null;
		try {
			ponto = controller.cadastrarPonto(novoPonto);
		} catch (PontoNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		assertEquals(novoPonto, ponto);
	}
	
	@Test
	public void testCadastrarPontoNulo(){
		Ponto novoPonto = new PontoPartida("A");
		novoPonto = null;

		try {
			controller.cadastrarPonto(novoPonto);
			fail();
		} catch (PontoNuloException e) {
			assertTrue(true);
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
	}
	
	@Test
	public void testCadastrarPontoSemNome(){
		Ponto novoPonto = new PontoPartida("A");
		novoPonto.setNome("");
		
		try {
			controller.cadastrarPonto(novoPonto);
			fail();
		} catch (PontoNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testCadastrarArestaSucesso(){
		Ponto b = new PontoColeta("B");
		Ponto c = new PontoColeta("C");
		
		Ponto pontoB = null;
		Ponto pontoC = null;
		try {
			pontoB = controller.cadastrarPonto(b);
			pontoC = controller.cadastrarPonto(c);
		} catch (PontoNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controller.cadastrarAresta(pontoB, pontoC, 2);
		} catch (PontoNuloException e) {
			fail();
		}
		
		Aresta aresta = null;
		
		Iterator<Aresta> i = pontoB.iterator();
		aresta = i.next();
		
		assertEquals(pontoC, aresta.getPontoAdjacente());
		
		aresta = null;
		Iterator<Aresta> i2 = pontoC.iterator();
		aresta = i2.next();
		
		assertEquals(pontoB, aresta.getPontoAdjacente());
	}
	
	@Test
	public void testCadastrarArestaComPontoNulo(){
		Ponto p1 = new PontoColeta("B");
		Ponto p2 = new PontoColeta("C");
	
		p1 = null;
		p2 = null;
		try {
			controller.cadastrarAresta(p1, p2, 2);
			fail();
		} catch (PontoNuloException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testRemoverArestaSucesso(){
		Ponto b = new PontoColeta("B");
		Ponto c = new PontoColeta("C");
		
		Ponto pontoB = null;
		Ponto pontoC = null;
		try {
			pontoB = controller.cadastrarPonto(b);
			pontoC = controller.cadastrarPonto(c);
		} catch (PontoNuloException e) {
			fail();
		} catch (CampoObrigatorioInexistenteException e) {
			fail();
		}
		
		try {
			controller.cadastrarAresta(pontoB, pontoC, 2);
		} catch (PontoNuloException e) {
			fail();
		}
		
		boolean resposta = false;
		try {
			resposta = controller.removerAresta(pontoB, pontoC);
		} catch (PontoNuloException e) {
			fail();
		}
		int chave = 0;
		if(resposta == true)
			chave = 1;
		
		assertEquals(1, chave);
	}
	@Test 
	public void testMenorCaminho() {
		
		Grafo grafo = Grafo.getInstance();
		
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
		
		AlgoritmoDijkstra alg = new AlgoritmoDijkstra(matriz);
		
		ArrayList<Integer> caminho = alg.menorCaminho();
		
		if(caminho == null) {
			fail();
		}
		assertEquals(4, caminho.size());
		
		assertEquals(Integer.valueOf(1), caminho.get(0));
		assertEquals(Integer.valueOf(0), caminho.get(1));
		assertEquals(Integer.valueOf(2), caminho.get(2));
		assertEquals(Integer.valueOf(4), caminho.get(3));
		
	}
}
