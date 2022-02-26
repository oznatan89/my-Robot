package myRobot;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class RoboTest extends JFrame implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static RobotMachine robotMachine= new RobotMachine();
	private JLabel labeRobotlIcon, labeSidelIcon;
	private JProgressBar progressBar;
	private JButton btnCharge, btnOnState, btnReset, btnOffState ;
	
	public static void main(String[] args)
	{		
		new RoboTest();		
	}
	
	public RoboTest ()
	{
		JFrame frame = new JFrame("Rob");
		JPanel panel = new JPanel();     

		labeRobotlIcon = new JLabel("");
		labeRobotlIcon.setToolTipText("robot");
		labeRobotlIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/robotUp.JPG")));
		labeRobotlIcon.setBounds( robotMachine.x , robotMachine.y , 80, 80);
		frame.getContentPane().add(labeRobotlIcon);

		progressBar = new JProgressBar();
		progressBar.setToolTipText("Rest Move");
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(Color.RED);
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		progressBar.setOrientation(SwingConstants.VERTICAL);
		progressBar.setValue(robotMachine.restMove);
		progressBar.setBounds(10, 10, 30, 440);
		frame.getContentPane().add(progressBar);

		JButton btnbackground = new JButton();
		btnbackground.setEnabled(false);
		btnbackground.setToolTipText("Movement");
		btnbackground.setBounds(50, 10, 400, 250);
		frame.getContentPane().add(btnbackground);

		panel.addKeyListener(this);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		//onStateButton
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnReset);
		btnReset.setToolTipText("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				robotMachine.setRobotMachine(robotMachine.getOnState());
				btnOffState.setBackground(new Color(238,238,238));
				Random rand = new Random(); 
				robotMachine.restMove = rand.nextInt(86)+10;

				robotMachine.x=rand.nextInt(320)+50;
				robotMachine.y=rand.nextInt(170)+10;

				labeRobotlIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/robotUp.JPG")));
				labeRobotlIcon.setBounds( robotMachine.x , robotMachine.y , 80, 80);				
				labeSidelIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/sideUp.png")));								
				progressBar.setValue(robotMachine.restMove);
				robotMachine.face = EnumSide.Up;
				panel.requestFocusInWindow();
			}
		});
		btnReset.setBounds(368, 303, 100, 50);

		//onStateButton
		btnOnState = new JButton("On State");
		btnOnState.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnOnState);
		btnOnState.setToolTipText("moveState");
		btnOnState.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{				
				robotMachine.setRobotMachine(robotMachine.getOnState());
				btnOffState.setBackground(new Color(238,238,238));
				panel.requestFocusInWindow();
			}
		});
		btnOnState.setBounds(246, 303, 112, 50);


		//Charge Button
		btnCharge = new JButton("Charge");
		panel.add(btnCharge);
		btnCharge.setEnabled(true);
		btnCharge.setToolTipText("Charge");
		btnCharge.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/charge.jpg")));
		btnCharge.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (robotMachine.faceState == robotMachine.offState)
				{
					JOptionPane.showMessageDialog( null,"can't charged this state" , "Error", JOptionPane.INFORMATION_MESSAGE );
					return;
				}
				robotMachine.setRobotMachine(robotMachine.getChargeState());
				robotMachine.charge(progressBar, labeSidelIcon, frame);
				robotMachine.setRobotMachine(robotMachine.getOnState());

				panel.requestFocusInWindow();
			}
		});
		btnCharge.setBounds(368, 364, 100, 50);

		labeSidelIcon = new JLabel("");
		panel.add(labeSidelIcon);
		labeSidelIcon.setToolTipText("side");
		labeSidelIcon.setIcon(new ImageIcon(RoboTest.class.getResource("/myRobot/sideUp.png")));
		labeSidelIcon.setBounds(51, 266, 185, 184);

		btnOffState = new JButton("Off State");
		btnOffState.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				robotMachine.setRobotMachine(robotMachine.getOffState());
				panel.requestFocusInWindow();
				btnOffState.setBackground(Color.RED);
			}
		});
		btnOffState.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOffState.setToolTipText("stop Move");
		btnOffState.setBounds(246, 362, 112, 50);

		panel.add(btnOffState);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		panel.requestFocusInWindow();
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (KeyEvent.getKeyText(e.getKeyCode()).equals("Up"))
			robotMachine.goStraight(progressBar, labeSidelIcon, labeRobotlIcon);

		if (KeyEvent.getKeyText(e.getKeyCode()).equals("Left"))
			robotMachine.goLeft(progressBar, labeSidelIcon,labeRobotlIcon);

		if (KeyEvent.getKeyText(e.getKeyCode()).equals("Right"))
			robotMachine.goRight(progressBar, labeSidelIcon,labeRobotlIcon);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}	
}