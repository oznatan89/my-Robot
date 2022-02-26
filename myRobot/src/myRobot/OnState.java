package myRobot;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class OnState  implements RobotState{
	RobotMachine robotMachine;		
	public OnState (RobotMachine newRobotMachine){		
		robotMachine = newRobotMachine;
	}
	@Override
	public void goLeft(JProgressBar progressBar, JLabel labeSidelIcon, JLabel labeRobotlIcon )
	{
		if (robotMachine.restMove >0)
		{
			if (robotMachine.face == EnumSide.Up)
			{
				labeSidelIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/sideLeft.png")));
				labeRobotlIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/robotLeft.JPG")));
				robotMachine.face = EnumSide.Left;
			}
			else if (robotMachine.face == EnumSide.Left)
			{
				labeSidelIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/sideDown.png")));
				labeRobotlIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/robotDown.JPG")));
				robotMachine.face = EnumSide.Down;
			}
			else if (robotMachine.face == EnumSide.Down)
			{
				labeSidelIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/sideRight.png")));
				labeRobotlIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/þþrobotRight.JPG")));
				robotMachine.face = EnumSide.Right;
			}
			else if (robotMachine.face == EnumSide.Right)
			{
				labeSidelIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/sideUp.png")));
				labeRobotlIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/robotUp.JPG")));
				robotMachine.face = EnumSide.Up;
			}
			progressBar.setValue(--robotMachine.restMove);

			if (robotMachine.restMove == 0)
				labeSidelIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/Can'tMove.png")));
		}
		else
			JOptionPane.showMessageDialog( null,"You need to recharge your machine" , "Error", JOptionPane.INFORMATION_MESSAGE );
	}
	@Override
	public void goRight(JProgressBar progressBar, JLabel labeSidelIcon, JLabel labeRobotlIcon)
	{

		if (robotMachine.restMove > 0)
		{
			if (robotMachine.face == EnumSide.Up)
			{
				labeSidelIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/sideRight.png")));
				labeRobotlIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/þþrobotRight.JPG")));
				robotMachine.face = EnumSide.Right;
			}
			else if (robotMachine.face == EnumSide.Right)
			{
				labeSidelIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/sideDown.png")));
				labeRobotlIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/robotDown.JPG")));
				robotMachine.face = EnumSide.Down;
			}
			else if (robotMachine.face == EnumSide.Down)
			{
				labeSidelIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/sideLeft.png")));
				labeRobotlIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/robotLeft.JPG")));
				robotMachine.face = EnumSide.Left;
			}
			else if (robotMachine.face == EnumSide.Left)
			{
				labeSidelIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/sideUp.png")));
				labeRobotlIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/robotUp.JPG")));
				robotMachine.face = EnumSide.Up;
			}
			progressBar.setValue(--robotMachine.restMove);	

			if (robotMachine.restMove == 0)
				labeSidelIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/Can'tMove.png")));
		}
		else
			JOptionPane.showMessageDialog( null,"You need to recharge your machine" , "Error", JOptionPane.INFORMATION_MESSAGE );	

	}
	@Override
	public void goStraight(JProgressBar progressBar, JLabel labeSidelIcon, JLabel labeRobotlIcon)
	{
		if (robotMachine.restMove > 0)
		{
			if (robotMachine.face == EnumSide.Up)
			{
				if (robotMachine.y < 40)
					return;
				labeRobotlIcon.setBounds( robotMachine.x , robotMachine.y-=15 , 80, 80);
			}
			else if (robotMachine.face == EnumSide.Right)
			{
				if (robotMachine.x > 350)
					return;
				labeRobotlIcon.setBounds( robotMachine.x+=15 , robotMachine.y , 80, 80);
			}
			else if (robotMachine.face == EnumSide.Down)
			{
				if (robotMachine.y > 150)
					return;
				labeRobotlIcon.setBounds( robotMachine.x , robotMachine.y+=15 , 80, 80);
			}
			else if (robotMachine.face == EnumSide.Left)
			{
				if (robotMachine.x < 70)
					return;
				labeRobotlIcon.setBounds( robotMachine.x-=15 , robotMachine.y , 80, 80);
			}

			progressBar.setValue(--robotMachine.restMove);

			if (robotMachine.restMove == 0)
				labeSidelIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/Can'tMove.png")));
		}
		else
			JOptionPane.showMessageDialog( null,"You need to recharge your machine" , "Error", JOptionPane.INFORMATION_MESSAGE );	

	}

	@Override
	public void charge(JProgressBar progressBar ,JLabel labeSidelIcon, JFrame frame) {
		
	}
}