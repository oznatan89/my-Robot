package myRobot;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class ChargeState implements RobotState{
	RobotMachine robotMachine;		
	public ChargeState (RobotMachine newRobotMachine){		
		robotMachine = newRobotMachine;		
	}
	@Override
	public void goLeft(JProgressBar progressBar, JLabel labeSidelIcon, JLabel labeRobotlIcon ) {
		JOptionPane.showMessageDialog( null,"You can not move left in this state" , "Error", JOptionPane.INFORMATION_MESSAGE );	
	}
	@Override
	public void goRight(JProgressBar progressBar, JLabel labeSidelIcon, JLabel labeRobotlIcon ) {
		JOptionPane.showMessageDialog( null,"You can not move right in this state" , "Error", JOptionPane.INFORMATION_MESSAGE );
	}
	@Override
	public void goStraight(JProgressBar progressBar, JLabel labeSidelIcon, JLabel labeRobotlIcon ) {
		JOptionPane.showMessageDialog( null,"you can't go on in this state" , "Error", JOptionPane.INFORMATION_MESSAGE );
	}
	@Override
	public void charge(JProgressBar progressBar, JLabel labeSidelIcon, JFrame frame)
	{
		labeSidelIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/sideCharge.png")));

		while (robotMachine.restMove < 100)
		{
			try {
				Thread.sleep(20);
			}
			catch (Exception e) {

			}
			progressBar.setValue(++robotMachine.restMove);	
			progressBar.repaint();
			//progressBar.update(null);
			progressBar.updateUI();
		}
	}	
}
