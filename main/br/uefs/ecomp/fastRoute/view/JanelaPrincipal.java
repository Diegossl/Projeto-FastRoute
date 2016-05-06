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
import java.awt.event.MouseMotionAdapter;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 711, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(SystemColor.scrollbar);
		canvas.setBounds(0, 40, 695, 468);
		frame.getContentPane().add(canvas);
		
		Panel panel = new Panel();
		panel.setBounds(0, -21, 695, 529);
		frame.getContentPane().add(panel);
		
		JToolBar toolBar = new JToolBar();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(447, Short.MAX_VALUE))
		);
		
		JButton btnButton = new JButton("");
		
		btnButton.setContentAreaFilled(false);
		btnButton.setOpaque(false);
		btnButton.setBorderPainted(false);
		
		btnButton.setToolTipText("Cadastrar");
		btnButton.setIcon(new ImageIcon("imagem\\add.png"));
		
		toolBar.add(btnButton);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(btnButton, popupMenu);
		
		JMenuItem mntmCadastrarPonto = new JMenuItem("Cadastrar Ponto");
		mntmCadastrarPonto.setIcon(new ImageIcon("imagem\\bank.png"));
		popupMenu.add(mntmCadastrarPonto);
		
		JMenuItem mntmCadastrarCaminho = new JMenuItem("Cadastrar Caminho");
		mntmCadastrarCaminho.setIcon(new ImageIcon("imagem\\line.png"));
		popupMenu.add(mntmCadastrarCaminho);
		
		JButton button = new JButton("");
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.setToolTipText("Remover");
		button.setIcon(new ImageIcon("imagem\\garbage.png"));
		toolBar.add(button);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(button, popupMenu_1);
		
		JMenuItem mntmRemoverPonto = new JMenuItem("Remover Ponto");
		mntmRemoverPonto.setIcon(new ImageIcon("imagem\\bank.png"));
		popupMenu_1.add(mntmRemoverPonto);
		
		JMenuItem mntmRemoverCaminho = new JMenuItem("Remover Caminho");
		mntmRemoverCaminho.setIcon(new ImageIcon("imagem\\line.png"));
		popupMenu_1.add(mntmRemoverCaminho);
		
		JButton button_1 = new JButton("");
		
		button_1.setBorderPainted(false);
		button_1.setToolTipText("Calcular Menor Caminho");
		button_1.setIcon(new ImageIcon("imagem\\route.png"));
		toolBar.add(button_1);
		
		
		
		
		panel.setLayout(gl_panel);
		
		
		
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
