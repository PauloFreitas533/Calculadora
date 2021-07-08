package br.com.cod3r.calc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.cod3r.calc.modelo.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener{

	private final Color Cor_Cinza_Escuro = new Color(68, 68, 68);
	private final Color Cor_Cinza_Claro = new Color(99, 99, 99);
	private final Color Cor_Laranja = new Color(242, 163, 60);
	
	public Teclado() {
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(new GridLayout(5, 4));
		
		adicionarBotao("AC", Cor_Cinza_Escuro, c, 0, 0);
		adicionarBotao("", Cor_Cinza_Escuro, c, 1, 0);
		adicionarBotao("±", Cor_Cinza_Escuro, c, 2, 0);
		adicionarBotao("/", Cor_Cinza_Escuro, c, 3, 0);
		
		adicionarBotao("7", Cor_Cinza_Claro, c, 0, 1);
		adicionarBotao("8", Cor_Cinza_Claro, c, 1, 1);
		adicionarBotao("9", Cor_Cinza_Claro, c, 2, 1);
		adicionarBotao("x", Cor_Laranja, c, 3, 1);
		
		adicionarBotao("4", Cor_Cinza_Claro, c, 0, 2);
		adicionarBotao("5", Cor_Cinza_Claro, c, 1, 2);
		adicionarBotao("6", Cor_Cinza_Claro, c, 2, 2);
		adicionarBotao("-", Cor_Laranja, c, 3, 2);
		
		adicionarBotao("1", Cor_Cinza_Claro, c, 0, 3);
		adicionarBotao("2", Cor_Cinza_Claro, c, 1, 3);
		adicionarBotao("3", Cor_Cinza_Claro, c, 2, 3);
		adicionarBotao("+", Cor_Laranja, c, 3, 3);
		
		adicionarBotao("0", Cor_Cinza_Claro, c, 0, 4);
		adicionarBotao("", Cor_Cinza_Claro, c, 1, 4);
		adicionarBotao(",", Cor_Cinza_Claro, c, 2, 4);
		adicionarBotao("=", Cor_Laranja, c, 3, 4);
	}
	
	private void adicionarBotao(String texto, Color cor, 
			GridBagConstraints c, int x, int y) {
		
		c.gridx = x;
		c.gridy = y;
		Botao botao = new Botao(texto, cor);
		botao.addActionListener(this);
		add(botao, c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();
			Memoria.getInstancia().processarComando(botao.getText());
			
		}
	}
	
}