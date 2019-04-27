package View;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.PerguntaController;

public class HomeView extends JFrame{
	private Container 			ctn;
	private JPanel 				pnl;
	private PerguntaController 	pc; 
	
	public HomeView() {
		super("Jojinho");
		
		ctn = getContentPane();
		ctn.setLayout(new BorderLayout());
		
		pnl = new JPanel();
		ctn.add(pnl);
		
		pc = new PerguntaController();
		
		pc.gerarEnunciadosPorDificuldade(1);;
		pc.gerarAlternativas(pnl);
		
		setSize(1024, 640); // Tamanho inicial
		setLocationRelativeTo(null); // Aparecer no centro da tela
		setDefaultCloseOperation(HomeView.EXIT_ON_CLOSE); // Sair ao fechar
		setVisible(true); // Visibilidade
		setResizable(false);
	}
	
	public static void main(String args[]) {
		new HomeView();
//		new EscalonamentoCurtoView();
	}
}
