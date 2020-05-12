package tictactoe;

import javax.swing.*;
import java.awt.*;

public class KobeTribute extends JFrame implements GameDesigner {
	@Override
	public void changeFrameBackground(JFrame frame) {
		frame.getContentPane().setBackground(LAKER_YELLOW);
	}

	@Override
	public void changeButton(JButton[] button) {
		for (JButton jButton : button) {
			jButton.setBackground(LAKER_PURPLE);
			jButton.setOpaque(true);
			jButton.setBorderPainted(false);
			jButton.setForeground(Color.red);
		}
	}
	private static final Color LAKER_YELLOW = new Color(253, 185, 39);
	private static final Color LAKER_PURPLE = new Color(85, 37, 130);
}