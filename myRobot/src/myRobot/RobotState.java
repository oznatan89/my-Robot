package myRobot;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public interface RobotState {
	
	void goLeft(JProgressBar progressBar, JLabel labeSidelIcon, JLabel labeRobotlIcon );
	void goRight(JProgressBar progressBar, JLabel labeSidelIcon, JLabel labeRobotlIcon );
	void goStraight(JProgressBar progressBar, JLabel labeSidelIcon, JLabel labeRobotlIcon );
	
	void charge(JProgressBar progressBar, JLabel labeSidelIcon, JFrame frame);
}