package br.uefs.ecomp.fastRoute.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.uefs.ecomp.fastRoute.controller.Controller;
import br.uefs.ecomp.fastRoute.model.Aresta;
import br.uefs.ecomp.fastRoute.model.Vertice;


@SuppressWarnings("serial")
public class Painel extends JPanel {
	
	
	public void redesenhar() {
		
		Graphics g = getGraphics();
		

		Controller controller = Controller.getInstance();
		ArrayList<Vertice> pontos = controller.getListaPontos();
		Iterator<Vertice> i = pontos.iterator();
		while(i.hasNext()) {
			Vertice ponto = (Vertice) i.next();
			g.setColor(Color.black);
			//g.drawString(ponto.getNome(), ponto.getX() - 20, ponto.getY() - 25);
			g.setColor(new Color(170, 163, 242));
			g.fillOval(ponto.getX()-40/2, ponto.getY()-40/2, 40, 40);	
			Iterator<Aresta> iteradorArestas = ponto.iterator();
			while(iteradorArestas.hasNext()) {
				Aresta aresta = iteradorArestas.next();
				Vertice pontoAdj = (Vertice) aresta.getPontoAdjacente();
				g.setColor(Color.black);
				g.drawLine(ponto.getX(), ponto.getY(), pontoAdj.getX() , pontoAdj.getY());
			}
		}
	}
	public void desenharCaminho(ArrayList<Vertice> caminho) {
		Graphics g = getGraphics();
		

		Controller controller = Controller.getInstance();
		ArrayList<Vertice> pontos = controller.getListaPontos();
		Iterator<Vertice> i = pontos.iterator();
		while(i.hasNext()) {
			Vertice ponto = (Vertice) i.next();
			if(caminho.contains(ponto)) 
				g.setColor(Color.green);
			else 
				g.setColor(new Color(170, 163, 242));
			g.fillOval(ponto.getX()-40/2, ponto.getY()-40/2, 40, 40);	
			g.setColor(Color.black);
			g.drawString(ponto.getNome(), ponto.getX() - 20, ponto.getY() - 25);
				
			Iterator<Aresta> iteradorArestas = ponto.iterator();
			while(iteradorArestas.hasNext()) {
				Aresta aresta = iteradorArestas.next();
				Vertice pontoAdj = (Vertice) aresta.getPontoAdjacente();
				g.setColor(Color.black);
//				if(caminho.contains(pontoAdj))
//					g.setColor(Color.green);
				g.drawLine(ponto.getX(), ponto.getY(), pontoAdj.getX() , pontoAdj.getY());
			}
		}
	}
//	public Dimension getPreferredSize() {
//	    return new Dimension(400,280);
//	}
//	public static void main(String[] args) {
//	    Runnable r = new Runnable() {
//	        public void run() {
//	            Painel p = new Painel();
//	            JOptionPane.showMessageDialog(null, p);
//	        }
//	    };
//	    SwingUtilities.invokeLater(r);
//	}


}
