package br.uefs.ecomp.fastRoute.view;

import java.awt.*;


import javax.swing.*;

import br.uefs.ecomp.fastRoute.controller.Controller;
import br.uefs.ecomp.fastRoute.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.fastRoute.exceptions.PontoNuloException;
import br.uefs.ecomp.fastRoute.model.PontoPassagem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CadastroPonto extends JFrame {
	private String nome;
	private JPanel contentPane;
	private boolean sucesso = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		PontoPassagem ponto = new PontoPassagem("Teste", null);
		System.out.println("" +ponto.getNome());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPonto frame = new CadastroPonto(0, 0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public CadastroPonto() {
		
	}
	/**
	 * Create the frame.
	 */
	public CadastroPonto(int x, int y) {
		
		Controller controller = Controller.getInstance();
		setBounds(100, 100, 337, 229);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome do novo ponto");
		lblDigiteONome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDigiteONome.setHorizontalAlignment(SwingConstants.CENTER);
		lblDigiteONome.setBounds(0, 23, 321, 20);
		getContentPane().add(lblDigiteONome);
		
		JTextField nomeEntrada = new JTextField();
		nomeEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		nomeEntrada.setBounds(30, 85, 261, 20);
		getContentPane().add(nomeEntrada);
		nomeEntrada.setColumns(10);
		
		JButton btnPrximo = new JButton("Pr\u00F3ximo");
		btnPrximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nome = nomeEntrada.getText();
				System.out.println("Nome: " +nome);
				PontoPassagem p = new PontoPassagem(nome, null);
				
				p.setX(x);
				p.setY(y);
				setVisible(false);
				try {
					controller.cadastrarPonto(p);
					sucesso = true;
				} catch (PontoNuloException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ponto nulo inserido");
				} catch (CampoObrigatorioInexistenteException e) {
					JOptionPane.showMessageDialog(null, "Por favor digite o nome");
				}

				
			}
		});
		btnPrximo.setBounds(222, 156, 89, 23);
		getContentPane().add(btnPrximo);
		
		JLabel lblParaContinuarToque = new JLabel("Toque onde deseja criar o ponto, a seguir");
		lblParaContinuarToque.setBounds(10, 152, 229, 30);
		getContentPane().add(lblParaContinuarToque);
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the foiCadastrado
	 */
	public boolean foiSucesso() {
		return sucesso;
	}



	

}
