package br.uefs.ecomp.fastRoute.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.uefs.ecomp.fastRoute.controller.Controller;
import br.uefs.ecomp.fastRoute.exceptions.PontoNuloException;
import br.uefs.ecomp.fastRoute.util.Ponto;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCaminho extends JFrame {

	private JPanel contentPane;
	private JTextField peso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCaminho frame = new CadastroCaminho();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroCaminho() {
		
		Controller controller = Controller.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelecioneOs = new JLabel("Selecione os pontos que deseja conectar abaixo:");
		lblSelecioneOs.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneOs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSelecioneOs.setBounds(10, 38, 414, 21);
		contentPane.add(lblSelecioneOs);
		
		JComboBox pontoUm = new JComboBox(controller.getLista().toArray());
		pontoUm.setBounds(10, 87, 160, 20);
		contentPane.add(pontoUm);
		
		JComboBox pontoDois = new JComboBox(controller.getLista().toArray());
		pontoDois.setBounds(264, 87, 160, 20);
		contentPane.add(pontoDois);
		
		peso = new JTextField();
		peso.setBounds(189, 160, 55, 28);
		contentPane.add(peso);
		peso.setColumns(10);
		
		JLabel lblDigiteOTempo = new JLabel("Digite o tempo entre os dois pontos abaixo");
		lblDigiteOTempo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDigiteOTempo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDigiteOTempo.setBounds(10, 135, 414, 14);
		contentPane.add(lblDigiteOTempo);
		
		JLabel label = new JLabel("---------");
		label.setBounds(194, 90, 46, 14);
		contentPane.add(label);
		
		JButton btnCriarCaminho = new JButton("Criar Caminho!");
		btnCriarCaminho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controller.cadastrarAresta((Ponto) pontoUm.getSelectedItem(),(Ponto) pontoDois.getSelectedItem(), Double.valueOf(peso.getText()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PontoNuloException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCriarCaminho.setBounds(161, 215, 111, 23);
		contentPane.add(btnCriarCaminho);
	}

}
