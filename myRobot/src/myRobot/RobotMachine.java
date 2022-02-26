package myRobot;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class RobotMachine {

	RobotState onState;
	RobotState offState;
	RobotState chargeState;
	RobotState faceState;
	
	int x = 130 ;
	int y = 80 ;
	EnumSide face = null;
	int restMove;

	public RobotMachine()
	{
		Random rand = new Random(); 
		restMove = rand.nextInt(86)+10;

		onState = new OnState(this);
		offState = new OffState(this);
		chargeState = new ChargeState(this);	
		
		faceState = onState;
		face = EnumSide.Up;
	}	
	void setRobotMachine(RobotState newRobotState){		
		faceState = newRobotState;
	}	
	public void goLeft(JProgressBar progressBar, JLabel labeSidelIcon, JLabel labeRobotlIcon ) {
		faceState.goLeft(progressBar, labeSidelIcon, labeRobotlIcon );
	}
	public void goRight(JProgressBar progressBar, JLabel labeSidelIcon, JLabel labeRobotlIcon ) {
		faceState.goRight(progressBar, labeSidelIcon, labeRobotlIcon );	
	}
	public void goStraight(JProgressBar progressBar, JLabel labeSidelIcon, JLabel labeRobotlIcon ){
		faceState.goStraight(progressBar, labeSidelIcon, labeRobotlIcon );
	}
	
	public void charge(JProgressBar progressBar, JLabel labeSidelIcon, JFrame frame){
		faceState.charge(progressBar, labeSidelIcon, frame);
	}
	
	public RobotState getOnState() {
		return onState;
	}
	public RobotState getChargeState() {
		return chargeState; 
	}
	public RobotState getOffState() {
		return offState; 
	}
}
