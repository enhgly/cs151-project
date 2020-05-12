package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.util.Arrays;


public class Controller implements ActionListener {
	private Integer current;
	private Model model;
	private View view;
	private int undoHelper = 0;
	private int undoCount = 3;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		actionListeners();
	}

	private void actionListeners(){
		for (JButton s : view.square) {
			s.addActionListener(this);
		}
		view.reset.addActionListener(this);
		view.undo.addActionListener(this);
		view.std.addActionListener(this);
		view.kobe.addActionListener(this);
		view.sjsu.addActionListener(this);
	}

	private boolean addToBoard(Integer field, NoughtCross noughtCross) {
		model.setBoard(field, noughtCross);
		if(Model.totalMoves >= 5) {
			if(model.winCheck()) {
				view.gameWon();
				view.reset();
				return true;
			}
			if(Model.totalMoves == 9) {
				view.gameDraw();
				view.reset();
				return true;
			}
		}
		return false;
	}

	private boolean undoFromBoard(Integer field, NoughtCross noughtCross) {
		model.removeFromBoard(field, noughtCross);
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		NoughtCross currentPlayer = view.getCurrentEnum();

		if(e.getSource().equals(view.undo)) {
			undoHelper = 0;
			undoCount--;
			if (undoFromBoard(current, currentPlayer)) {
				view.changePlayer();
			}
			view.square[current].setText("");
			view.undoRemaining.setText(String.valueOf(undoCount));
			view.square[current].setEnabled(true);
			view.undo.setEnabled(false);
		}
		else if (Arrays.asList(view.square).contains((JButton) e.getSource()) && currentPlayer != null) {
			undoHelper++;
			current = Arrays.asList(view.square).indexOf((JButton)e.getSource());
			((JButton) e.getSource()).setText(view.getCurrentString());
			((JButton) e.getSource()).setEnabled(false);
			if(!addToBoard(current, currentPlayer)) {
				view.changePlayer();
				if(undoHelper >= 2) {
					undoHelper = 0;
					undoCount = 3;
					view.undoRemaining.setText(String.valueOf(undoCount));
				}
			}
			if(undoCount > 0 && !model.winCheck() && Model.totalMoves < 9) {
				view.undo.setEnabled(true);
			}
		} else if(e.getSource().equals(view.kobe)) {
			KobeTribute kb = new KobeTribute();
			kb.changeButton(view.square);
			kb.changeFrameBackground(this.view);
		}else if(e.getSource().equals(view.sjsu)) {
			SJSUPride sp = new SJSUPride();
			sp.changeButton(view.square);
			sp.changeFrameBackground(this.view);
		}
		else if(e.getSource().equals(view.std)) {
			this.view.getContentPane().setBackground(null);
			for (JButton s : view.square) {
			s.setBackground(null);
			s.setOpaque(true);
			s.setBorderPainted(true);
			s.setForeground(null);
			}
		}
		else if(e.getSource().equals(view.reset)) {
			Model.totalMoves = 0;
			this.view.dispose();
			this.view = new View();
			actionListeners();
			this.model = new Model();
		}
	}
}


