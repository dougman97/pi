package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.PerguntaModelArray;

public class HomeViewComponents {
	public void gerarAlternativas(JPanel painel, PerguntaModelArray array) {
		painel.setLayout(new GridBagLayout());
		
		JLabel lbl = new JLabel(array.getArray().get(0).getEnunciado_text());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		painel.add(lbl, gbc);
		
		JButton[] btn = new JButton[array.getArray().size()];
		
		for(int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(array.getArray().get(i).getAlternativa_text());
			
			gbc.gridy = i + 1;
			
			painel.add(btn[i], gbc);
		}
	}
}
