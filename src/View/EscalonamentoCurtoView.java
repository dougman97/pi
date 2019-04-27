package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Cpu;
import Model.Memoria;
import Model.Processo;

public class EscalonamentoCurtoView extends JFrame implements ActionListener {
	private Container	ctn;
	private JPanel 		pnlA, pnlB, pnlC, pnlD;
	
	private JTextField 	txtA, txtB, txtC, txtD;
	private JLabel		lblA, lblB, lblC, lblD;
	private JButton		btnA;
	
	private JTextArea	taA;
	
	private JTextArea	taB;
	private JButton		btnB, btnC;
	
	private Memoria 	memoria;
	private Cpu 		cpu;
	
	public EscalonamentoCurtoView() {
		super("Escalonamento");
		
		memoria = new Memoria();
		cpu 	= new Cpu();
		
		ctn = getContentPane();
		ctn.setLayout(new GridLayout(1,3));
		
		pnlA = new JPanel();
		pnlB = new JPanel();
		pnlC = new JPanel();
		pnlD = new JPanel();
		
		lblA = new JLabel("Duração:"	);
		lblB = new JLabel("Prioridade:"	);
		lblC = new JLabel("Descrição:"	);
		lblD = new JLabel("Estado:"		);
		
		txtA = new JTextField();
		txtB = new JTextField();
		txtC = new JTextField();
		txtD = new JTextField();
		
		btnA = new JButton("Criar Processo");
		
		pnlA.setLayout(new GridLayout(9,1));
		
		taA = new JTextArea();
		taA.setLineWrap(true);
		
		pnlB.setLayout(new GridLayout(1,1));
		
		taB = new JTextArea();
		taB.setLineWrap(true);
		
		btnB = new JButton("Executar Processo");
		btnC = new JButton("Selecionar Escalonador Randomicamente");
		
		pnlC.setLayout(new BorderLayout());
		
		pnlA.add(lblA);
		pnlA.add(txtA);
		pnlA.add(lblB);
		pnlA.add(txtB);
		pnlA.add(lblC);
		pnlA.add(txtC);
		pnlA.add(lblD);
		pnlA.add(txtD);
		pnlA.add(btnA);
		
		pnlB.add(taA);
		
		pnlC.add(BorderLayout.NORTH, taB);
		pnlC.add(BorderLayout.SOUTH, pnlD);
		
		pnlD.setLayout(new GridLayout(2,1));
		
		pnlD.add(btnC);
		pnlD.add(btnB);
		
		ctn.add(pnlA);
		ctn.add(pnlB);
		ctn.add(pnlC);
		
		btnA.addActionListener(this);
		btnB.addActionListener(this);
		btnC.addActionListener(this);
		
		setSize(1024, 640); // Tamanho inicial
		setLocationRelativeTo(null); // Aparecer no centro da tela
		setDefaultCloseOperation(HomeView.EXIT_ON_CLOSE); // Sair ao fechar
		setVisible(true); // Visibilidade
		setResizable(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnA) {
			memoria.addProcesso(
					new Processo(
							Integer.parseInt(txtA.getText()),
							Integer.parseInt(txtB.getText()),
							txtC.getText(),
							txtD.getText().charAt(0) 
						)
				);
			taA.setText(memoria.toString());
		}
		else if(e.getSource() == btnB) {
			try {
				cpu.executaProcesso(memoria);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			taB.setText(cpu.getProcesso().toString());
			taA.setText(memoria.toString());
		}
		else if(e.getSource() == btnC) {
			cpu.selectEscalonador(memoria);
			taA.setText(memoria.toString());
		}
	}
}
