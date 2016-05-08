package br.uefs.ecomp.fastRoute.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JPanel;

import br.uefs.ecomp.fastRoute.model.PontoPassagem;

public class Painel extends JPanel {
	public void criarPonto(Graphics g, MouseEvent arg0, String nome) {
		g.setColor(Color.yellow);
		g.fillOval(arg0.getX()-50/2, arg0.getY()-50/2, 50, 50);
		PontoPassagem p = new PontoPassagem(nome, null);
		p.setX(arg0.getX());
		p.setY(arg0.getY());
	}
}
