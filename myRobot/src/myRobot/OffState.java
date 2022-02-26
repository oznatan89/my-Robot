package myRobot;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class OffState implements RobotState
{
	RobotMachine robotMachine;		
	public OffState (RobotMachine newRobotMachine){		
		robotMachine = newRobotMachine;
	}
	@Override
	public void goLeft(JProgressBar progressBar, JLabel labeSidelIcon,
			JLabel labeRobotlIcon) {
		JOptionPane.showMessageDialog( null,"You can not move left in this state" , "Error", JOptionPane.INFORMATION_MESSAGE );	
	}

	@Override
	public void goRight(JProgressBar progressBar, JLabel labeSidelIcon,
			JLabel labeRobotlIcon) {
		JOptionPane.showMessageDialog( null,"You can not move Right in this state" , "Error", JOptionPane.INFORMATION_MESSAGE );	
	}

	@Override
	public void goStraight(JProgressBar progressBar, JLabel labeSidelIcon,
			JLabel labeRobotlIcon) {
		JOptionPane.showMessageDialog( null,"You can not go on in this state" , "Error", JOptionPane.INFORMATION_MESSAGE );	
	}

	@Override
	public void charge(JProgressBar progressBar, JLabel labeSidelIcon,JFrame frame) {
		
	}

}
