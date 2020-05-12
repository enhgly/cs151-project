package tictactoe;

import javax.swing.*;

/**
 * This class declares methods for designing board of tic tac toe.
 */

public interface GameDesigner {

	// this method changes the color of the background of the frame.
	public void changeFrameBackground(JFrame frame);

	// this method changes the color of buttons.
	public void changeButton(JButton[] button);

}
