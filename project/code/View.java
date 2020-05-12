package tictactoe;

import java.awt.*;

import javax.swing.*;

public class View extends JFrame{
	JButton[] square;
	JButton reset;
	JButton undo;
	JButton std;
	JButton kobe;
	JButton sjsu;
	private JLabel player;
	JLabel undoRemaining;

	public View(){
		this.square = new JButton[9];
		initComponents();
		setLayout();
		setVisible(true);
		setTitle("Tic Tac Toe");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}


	public void initComponents() {
		this.setPreferredSize(new Dimension(200, 220));
		this.player = new JLabel("X");
		this.reset = new JButton("Reset");
		this.reset.setEnabled(false);
		this.undo = new JButton("Undo");
		this.undo.setEnabled(false);
		this.std = new JButton("Standard");
		this.kobe = new JButton("Kobe");
		this.kobe.setEnabled(true);
		this.sjsu  = new JButton("SJSU");
		this.undoRemaining = new JLabel("3");
	}


	public void setLayout(){
		GridLayout grid = new GridLayout(3, 3, 10, 10);
		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		panel1.setOpaque(false);
		panel1.setLayout(grid);
		for (int i = 0; i<this.square.length; i++) {
			this.square[i] = new JButton("");
			panel1.add(square[i]);
		}
		content.add(panel1, BorderLayout.CENTER);
		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setLayout(new FlowLayout());
		panel2.add(std);
		panel2.add(kobe);
		panel2.add(sjsu);
		content.add(panel2, BorderLayout.NORTH);
		JPanel panel3 = new JPanel();
		panel3.setOpaque(false);
		panel3.setLayout(new FlowLayout());
		panel3.add(reset);
		panel3.add(player);
		panel3.add(undoRemaining);
		panel3.add(undo);
		content.add(panel3, BorderLayout.SOUTH);
		setSize(500, 500);
	}

	public String reverseValue(String value) {
		if("X".equals(value)) {
			return "O";
		} else if("O".equals(value)) {
			return "X";
		}
		return null;
	}

	public NoughtCross getCurrentEnum() {
		if("O".equals(this.player.getText())) {
			return NoughtCross.O;
		}
		else if("X".equals(this.player.getText())) {
			return NoughtCross.X;
		}
		return null;
	}

	public String getCurrentString() {
		if("O".equals(this.player.getText())) {
			return "O";
		}
		else if("X".equals(this.player.getText())) {
			return "X";
		}
		return null;
	}

	public void changePlayer() {
		String newPlayer = reverseValue(getCurrentString());
		this.player.setText(newPlayer);
	}

	public void gameWon() {
		this.player.setText(getCurrentString() + " wins!");
		for(JButton s : this.square) {
			s.setEnabled(false);
		}
		this.reset.setEnabled(true);
		this.undo.setEnabled(false);
		reset();
	}

	void gameDraw() {
		this.player.setText("Draw");
		this.reset.setVisible(true);
		this.undo.setEnabled(false);
	}
	void reset() {
		this.reset.setEnabled(true);
	}

}