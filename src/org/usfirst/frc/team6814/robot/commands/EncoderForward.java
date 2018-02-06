package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class EncoderForward extends Command{

	int feetDist; // how many feet the bot should drive
	int inchDist; // how many inches the bot should drive
	int driveDist; // how far the bot should drive
	double stopDist; // the distance at which it should stop
	double botSpeed; // the speed the bot is going
	double leftSpeed; // turning left speed
	double rightSpeed; // turning right speed
	
	//Takes the speed; Takes the amount of feet and inches(ex. 12ft, 3in);
	public EncoderForward(double speed, int feet, int inches) {
		
		driveDist = (inches + (12 * feet)); // adds the feet and inches by converting the feet to inches and adding
		botSpeed = speed;
		leftSpeed = botSpeed*-1.075; // setting turning speeds
		rightSpeed = botSpeed*1.0; // setting turning speeds
		
	}
	
	protected void initialize() {
		
	// sets the ending distance equal to the distance traveled since the last encoder reset added to the distance given to be traveled.
		stopDist = RobotMap.rightEnc.getDistance() + driveDist;
		
	}
	
	// this function starts the DifferentialDrive
	protected void execute() {
		
		RobotMap.driveFrontBot.tankDrive(leftSpeed, rightSpeed);
		
	}
	
	//determines when its time to stop
	@Override
	protected boolean isFinished() {
		
		// returns true when the distance traveled is no longer less than or equal to the stopping distance. returns false when its not.
		return (RobotMap.rightEnc.getDistance() >= stopDist);
	}

	//this function is supposed to stop the DifferentialDrive
	protected void end() {
		
		RobotMap.driveFrontBot.stopMotor();
		
	}
	
}