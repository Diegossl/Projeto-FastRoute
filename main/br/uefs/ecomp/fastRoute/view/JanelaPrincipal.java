package br.uefs.ecomp.fastRoute.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
import br.uefs.ecomp.fastRoute.model.PontoPassagem;
import br.uefs.ecomp.fastRoute.util.Ponto;

import javax.swing.JList;
import java.awt.SystemColor;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Panel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import java.awt.Button;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseMotionAdapter;
import java.util.Iterator;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;
import java.awt.Component;
import java.awt.event.MouseAdapter;

public class JanelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		 try {
//	            // Set System L&F
//	        UIManager.setLookAndFeel(
//	            UIManager.getSystemLookAndFeelClassName());
//	    } 
//	    catch (UnsupportedLookAndFeelException e) {
//	       // handle exception
//	    }
//	    catch (ClassNotFoundException e) {
//	       // handle exception
//	    }
//	    catch (InstantiationException e) {
//	       // handle exception
//	    }
//	    catch (IllegalAccessException e) {
//	       // handle exception
//	    }

	   // new SwingApplication(); //Create and show the GUI.

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
		
		JPopupMenu popupMenu = new JPopupMenu();
		
		JMenuItem mntmCadastrarPonto = new JMenuItem("Cadastrar Ponto");
		mntmCadastrarPonto.setIcon(new ImageIcon("imagem\\bank.png"));
		popupMenu.add(mntmCadastrarPonto);
		
		JMenuItem mntmCadastrarCaminho = new JMenuItem("Cadastrar Caminho");
		mntmCadastrarCaminho.setIcon(new ImageIcon("imagem\\line.png"));
		mntmCadastrarCaminho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroAresta cadastroAresta = new CadastroAresta();
				cadastroAresta.setVisible(true);
			}
		});
		popupMenu.add(mntmCadastrarCaminho);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		
		JMenuItem mntmRemoverPonto = new JMenuItem("Remover Ponto");
		mntmRemoverPonto.setIcon(new ImageIcon("imagem\\bank.png"));
		popupMenu_1.add(mntmRemoverPonto);
		
		JMenuItem mntmRemoverCaminho = new JMenuItem("Remover Caminho");
		mntmRemoverCaminho.setIcon(new ImageIcon("imagem\\line.png"));
		popupMenu_1.add(mntmRemoverCaminho);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 38, 840, 476);
		frame.getContentPane().add(panel);
		
		Painel painel = new Painel();
		painel.setBackground(SystemColor.controlHighlight);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(painel, GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(painel, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
		);
		painel.addMouseListener(new MouseAdapter() {
			//@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Graphics g = painel.getGraphics();
				CadastroPonto cadastroPonto = new CadastroPonto(arg0.getX(), arg0.getY());
				cadastroPonto.setVisible(true);
				g.setColor(Color.blue);
				g.fillOval(arg0.getX()-30/2, arg0.getY()-30/2, 30, 30);	
//				if(cadastroPonto.foiSucesso() ) {
//					g.setColor(Color.blue);
//					g.fillOval(arg0.getX()-30/2, arg0.getY()-30/2, 30, 30);	
//				} else {
//					System.out.println("Nao foi sucesso");
//				}
			}
		});
		
		
		
		
		panel.setLayout(gl_panel);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 840, 39);
		frame.getContentPane().add(toolBar);
		JButton btnButton = new JButton("");
		btnButton.setOpaque(false);
		
		btnButton.setToolTipText("Cadastrar");
		btnButton.setIcon(new ImageIcon("imagem\\add.png"));
		
		toolBar.add(btnButton);
		addPopup(btnButton, popupMenu);
		
		JButton button = new JButton("");
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.setToolTipText("Remover");
		button.setIcon(new ImageIcon("imagem\\garbage.png"));
		toolBar.add(button);
		addPopup(button, popupMenu_1);
		
		JButton button_1 = new JButton("");
		
		button_1.setBorderPainted(false);
		button_1.setToolTipText("Calcular Menor Caminho");
		button_1.setIcon(new ImageIcon("imagem\\route.png"));
		toolBar.add(button_1);
		
		
		
//		JMenuBar menuBar = new JMenuBar();
//		menuBar.setBounds(29, 216, 695, 21);
//		frame.getContentPane().add(menuBar);
//		
//		JMenu mnCadastrar = new JMenu("Cadastrar");
//		mnCadastrar.setIcon(new ImageIcon("imagem\\add.png"));
//		menuBar.add(mnCadastrar);
//		
//		JMenuItem mntmCadastrarPonto = new JMenuItem("Cadastrar Ponto");
//		mntmCadastrarPonto.setIcon(new ImageIcon("imagem\\bank.png"));
//		mnCadastrar.add(mntmCadastrarPonto);
//		
//		JMenuItem mntmCadastrarCaminho = new JMenuItem("Cadastrar Caminho");
//		mntmCadastrarCaminho.setIcon(new ImageIcon("imagem\\line.png"));
//		mnCadastrar.add(mntmCadastrarCaminho);
//		
//		JMenu mnRemover = new JMenu("Remover");
//		mnRemover.setIcon(new ImageIcon("imagem\\garbage.png"));
//		menuBar.add(mnRemover);
//		
//		JMenuItem mntmRemoverPonto = new JMenuItem("Remover Ponto");
//		mntmRemoverPonto.setIcon(new ImageIcon("imagem\\bank.png"));
//		mnRemover.add(mntmRemoverPonto);
//		
//		JMenuItem mntmRemoverCaminho = new JMenuItem("Remover Caminho");
//		mntmRemoverCaminho.setIcon(new ImageIcon("imagem\\line.png"));
//		mnRemover.add(mntmRemoverCaminho);
//		
//		JMenu mnExecutar = new JMenu("Executar");
//		mnExecutar.setIcon(new ImageIcon("imagem\\route.png"));
//		menuBar.add(mnExecutar);
		
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
}
