package br.uefs.ecomp.fastRoute.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.uefs.ecomp.fastRoute.controller.Controller;
import br.uefs.ecomp.fastRoute.exceptions.ArestaInvalidaException;
import br.uefs.ecomp.fastRoute.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.fastRoute.exceptions.PontoInvalidoException;
import br.uefs.ecomp.fastRoute.exceptions.PontoNuloException;
import br.uefs.ecomp.fastRoute.model.Vertice;

import javax.swing.JList;
import java.awt.SystemColor;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Panel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import java.awt.Button;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JanelaPrincipal {

	private JFrame frame;
	private Controller controller = Controller.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
	            // Set System L&F
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {	       // handle exception
	    }

	    //new SwingApplication(); //Create and show the GUI.

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal window = new JanelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Controller controller = Controller.getInstance();
		frame = new JFrame();
		frame.setBounds(100, 100, 856, 553);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 38, 840, 476);
		frame.getContentPane().add(panel);
		
		Painel painelDesenho = new Painel();
		//JPanel painelDesenho = new JPanel();
		painelDesenho.setBackground(SystemColor.controlHighlight);
		
		GroupLayout layoutPainelCadastroPonto = new GroupLayout(panel);
		layoutPainelCadastroPonto.setHorizontalGroup(
			layoutPainelCadastroPonto.createParallelGroup(Alignment.LEADING)
				.addComponent(painelDesenho, GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
		);
		layoutPainelCadastroPonto.setVerticalGroup(
			layoutPainelCadastroPonto.createParallelGroup(Alignment.LEADING)
				.addComponent(painelDesenho, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
		);
		
		painelDesenho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String nomePontoCadastrar = JOptionPane.showInputDialog("Digite o nome do ponto que deseja criar");
				Vertice ponto = new Vertice(nomePontoCadastrar);
				
				Graphics g = painelDesenho.getGraphics();

				
				ponto.setX(arg0.getX());
				ponto.setY(arg0.getY());
				
				try {
					controller.cadastrarVertice(ponto);
					JOptionPane.showMessageDialog(null, "Ponto cadastrado com sucesso");
				} catch (PontoNuloException e) {
					JOptionPane.showMessageDialog(null, "Ponto nulo nao cadastrado");
					return;
				} catch (CampoObrigatorioInexistenteException e) {
					JOptionPane.showMessageDialog(null, "Por favor digite todos os campos necessários");
					return;
				} catch (PontoInvalidoException e) {
					JOptionPane.showMessageDialog(null, "Ponto já cadastrado, tente novamente");
					return;
				}
				
				g.setColor(Color.black);
				g.drawString(ponto.getNome(), ponto.getX() - 20, ponto.getY() - 25);
				g.setColor(new Color(170, 163, 242));
				g.fillOval(arg0.getX()-40/2, arg0.getY()-40/2, 40, 40);	
			}
		});
		
		JPopupMenu popupMenuCadastrar = new JPopupMenu();
		
		JMenuItem mntmCadastrarPonto = new JMenuItem("Cadastrar Ponto");
		mntmCadastrarPonto.setIcon(new ImageIcon("imagem\\bank.png"));
		mntmCadastrarPonto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Clique em qualquer lugar da tela abaixo para cadastrar");
			}
		});

		popupMenuCadastrar.add(mntmCadastrarPonto);
		
		JPopupMenu popupMenuRemover = new JPopupMenu();
		
		JMenuItem mntmRemoverPonto = new JMenuItem("Remover Ponto");
		mntmRemoverPonto.setIcon(new ImageIcon("imagem\\bank.png"));
		mntmRemoverPonto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox comboPonto = new JComboBox(controller.getListaPontos().toArray()); 
				int opcao = JOptionPane.showConfirmDialog(null, comboPonto, "Selecione os pontos que deseja remover", JOptionPane.OK_CANCEL_OPTION);
				if(opcao == JOptionPane.OK_OPTION) {
					Vertice pontoRemover = (Vertice) comboPonto.getSelectedItem();
					try {
						controller.removerVerticeAresta(pontoRemover);
						painelDesenho.paint(painelDesenho.getGraphics());
						painelDesenho.redesenhar();	
					} catch (PontoNuloException e1) {
						JOptionPane.showMessageDialog(null, "Por favor, escolha um ponto não nulo");
					}
				}
				
				
			}
		});
		popupMenuRemover.add(mntmRemoverPonto);
		
		JMenuItem mntmRemoverCaminho = new JMenuItem("Remover Caminho");
		mntmRemoverCaminho.setIcon(new ImageIcon("imagem\\line.png"));
		mntmRemoverCaminho.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vertice pontoUm = null, pontoDois = null;
				JComboBox comboPontoUm = new JComboBox(controller.getListaPontos().toArray()); 
				JComboBox comboPontoDois = new JComboBox(controller.getListaPontos().toArray());
				Object[] messagem = {"Selecione o ponto um", comboPontoUm, "Selecione o ponto dois", comboPontoDois};
				int opcao = JOptionPane.showConfirmDialog(null, messagem, "Selecione os pontos", JOptionPane.OK_CANCEL_OPTION);
				if(opcao == JOptionPane.OK_OPTION) {
					pontoUm = (Vertice) comboPontoUm.getSelectedItem();
					pontoDois = (Vertice) comboPontoDois.getSelectedItem();
					try {
						controller.removerAresta(pontoUm, pontoDois);
						painelDesenho.paint(painelDesenho.getGraphics());
						painelDesenho.redesenhar();	
					} catch (PontoNuloException e1) {
						JOptionPane.showMessageDialog(null, "Por favor, escolha um ponto não nulo");
					}
				}
			}
		});
		popupMenuRemover.add(mntmRemoverCaminho);
		frame.getContentPane().setLayout(null);
		
		

		
		JMenuItem mntmCadastrarCaminho = new JMenuItem("Cadastrar Caminho");
		
		mntmCadastrarCaminho.setIcon(new ImageIcon("imagem\\line.png"));
		mntmCadastrarCaminho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Graphics g = painelDesenho.getGraphics();
				Vertice pontoUm = null, pontoDois = null;
				JComboBox comboPontoUm = new JComboBox(controller.getListaPontos().toArray()); 
				JComboBox comboPontoDois = new JComboBox(controller.getListaPontos().toArray());
				JTextField pesoAresta =  new JTextField();
				Object[] messagem = {"Selecione o ponto um", comboPontoUm, "Selecione o ponto dois", comboPontoDois, "Digite o peso", pesoAresta};
				int opcao = JOptionPane.showConfirmDialog(null, messagem, "Selecione os pontos", JOptionPane.OK_CANCEL_OPTION);
				if(opcao == JOptionPane.OK_OPTION) {
					String tempo = pesoAresta.getText();
					pontoUm = (Vertice) comboPontoUm.getSelectedItem();
					pontoDois = (Vertice) comboPontoDois.getSelectedItem();
					try {
						controller.cadastrarAresta(pontoUm, pontoDois, Double.parseDouble(tempo));
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Insira um numero valido");
						return;
					} catch (PontoNuloException e) {
						JOptionPane.showMessageDialog(null, "Por favor, escolha um ponto não nulo");
						return;
					} catch (ArestaInvalidaException e) {
						JOptionPane.showMessageDialog(null, "Por favor, selecione pontos diferentes");
						return;
					}
				}
				g.setColor(Color.black);
				g.drawLine(pontoUm.getX(), pontoUm.getY(), pontoDois.getX(), pontoDois.getY());
			}
		});
		
		
		
		popupMenuCadastrar.add(mntmCadastrarCaminho);
		
		panel.setLayout(layoutPainelCadastroPonto);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 840, 514);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 840, 38);
		panel_1.add(toolBar);
		toolBar.setBackground(UIManager.getColor("Button.light"));
		JButton botaoCadastrar = new JButton("");
		botaoCadastrar.setOpaque(false);
		
		botaoCadastrar.setToolTipText("Cadastrar");
		botaoCadastrar.setIcon(new ImageIcon("imagem\\add.png"));
		
		toolBar.add(botaoCadastrar);
		addPopup(botaoCadastrar, popupMenuCadastrar);
		
		JButton botaoRemover = new JButton("");
		botaoRemover.setContentAreaFilled(false);
		botaoRemover.setOpaque(false);
		botaoRemover.setBorderPainted(false);
		botaoRemover.setToolTipText("Remover");
		botaoRemover.setIcon(new ImageIcon("imagem\\garbage.png"));
		toolBar.add(botaoRemover);
		addPopup(botaoRemover, popupMenuRemover);
		
		JButton botaoCalcularCaminho = new JButton("");
		
		botaoCalcularCaminho.setBorderPainted(false);
		botaoCalcularCaminho.setToolTipText("Calcular Menor Caminho");
		botaoCalcularCaminho.setIcon(new ImageIcon("imagem\\route.png"));
		botaoCalcularCaminho.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox comboPontoUm = new JComboBox(controller.getListaPontos().toArray()); 
				JComboBox comboPontoDois = new JComboBox(controller.getListaPontos().toArray());
				JComboBox comboPontoTres = new JComboBox(controller.getListaPontos().toArray());
				Object[] messagem = {"Selecione o estacionamento", comboPontoUm, "Selecione o ponto de coleta", comboPontoDois, "Selecione o ponto de destino", comboPontoTres};
				Vertice garagem = null, pontoColeta = null, pontoDestino = null;
				int opcao = JOptionPane.showConfirmDialog(null, messagem, "Selecione os pontos", JOptionPane.OK_CANCEL_OPTION);
				if(opcao == JOptionPane.OK_OPTION) {
					garagem = (Vertice) comboPontoUm.getSelectedItem();
					pontoColeta = (Vertice) comboPontoDois.getSelectedItem();
					pontoDestino = (Vertice) comboPontoTres.getSelectedItem();
					ArrayList<Vertice> caminhoUm = controller.calcularMenorRota(garagem, pontoColeta);
					ArrayList<Vertice> caminhoDois = controller.calcularMenorRota(pontoColeta, pontoDestino);
					caminhoUm.addAll(caminhoDois);
					painelDesenho.paint(painelDesenho.getGraphics());
					painelDesenho.desenharCaminho(caminhoUm);	
				}
				
			}
		});
		toolBar.add(botaoCalcularCaminho);
		
		
		
	}
	private static void addPopup(JButton button, final JPopupMenu popup) {
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
					button.setPressedIcon(button.getIcon());
					showMenu(e);
			}
			public void mouseReleased(MouseEvent e) {
					showMenu(e);
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	public void cadastroVisivel() {
		
	}
}
