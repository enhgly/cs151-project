package tictactoe;

import javax.swing.*;
import java.awt.*;

public class SJSUPride extends JFrame implements GameDesigner {
	@Override
	public void changeFrameBackground(JFrame frame) {
		frame.getContentPane().setBackground(Color.BLUE);
	}

	@Override
	public void changeButton(JButton[] button) {
		for (JButton jButton : button) {
			jButton.setBackground(Color.YELLOW);
			jButton.setOpaque(true);
			jButton.setBorderPainted(false);
			jButton.setForeground(Color.red);
		}
	}
}
