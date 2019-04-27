package Controller;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.PerguntaModelArray;
import Service.PerguntaService;

public class PerguntaController implements ActionListener {
	private PerguntaModelArray[] 	modelArray;
	private PerguntaService 		service;
	
	public PerguntaController() {
		modelArray 	= new PerguntaModelArray[0];
		service 	= new PerguntaService();
	}
	
	public PerguntaModelArray[] getModelArray() {
		return modelArray;
	}

	public void setModelArray(PerguntaModelArray modelArray[]) {
		this.modelArray = modelArray;
	}

	public PerguntaService getService() {
		return service;
	}
	
	public void setService(PerguntaService service) {
		this.service = service;
	}
	
	public void gerarEnunciadosPorCapitulo(int capitulo) {
		this.modelArray = service.loadEnunciados(0, capitulo);
	}
	
	public void gerarEnunciadosPorDificuldade(int nivel) {
		this.modelArray = service.loadEnunciados(1, nivel);
	}
	
	public void gerarAlternativas(JPanel panel) {
		gerarAlternativas(panel, 0);
	}
	
	public void gerarAlternativas(JPanel panel, int posicaoEnunciado) {
		panel.setLayout(new GridBagLayout());
		
		JLabel lbl = new JLabel(modelArray[posicaoEnunciado].getArray().get(0).getEnunciado_text());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		panel.add(lbl, gbc);
		
		JButton[] btn = new JButton[modelArray[posicaoEnunciado].getArray().size()];
		
		for(int i = 0; i < btn.length; i++) {
			int posicao = i;
			btn[posicao] = new JButton(modelArray[posicaoEnunciado].getArray().get(i).getAlternativa_text());
			btn[posicao].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(modelArray[posicaoEnunciado].getArray().get(posicao).equals(modelArray[posicaoEnunciado].getAlternativaCorreta()))
						JOptionPane.showMessageDialog(null, "Correto!");
					else
						JOptionPane.showMessageDialog(null, "Falso!");
				}
			});
			gbc.gridy = i + 1;
			
			panel.add(btn[i], gbc);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
