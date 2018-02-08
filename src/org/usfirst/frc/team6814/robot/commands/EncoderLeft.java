package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class EncoderLeft extends Command{

	int feetDist; // how many feet the bot should drive
	int inchDist; // how many inches the bot should drive
	double driveDist; // how far the bot should drive
	double stopDist; // the distance at which it should stop
	double botSpeed; // the speed the bot is going
	double leftSpeed; // turning left speed
	double rightSpeed; // turning right speed
	
	//Takes the speed; Takes the amount of feet and inches(ex. 12ft, 3in);
	public EncoderLeft(double speed, double feet, double inches) {
				
		driveDist = (inches + (12 * feet)); // adds the feet and inches by converting the feet to inches and adding
		botSpeed = speed;
		leftSpeed = botSpeed; // setting turning speeds
		rightSpeed = botSpeed; // setting turning speeds
		
	}
	
	protected void initialize() {
		
		// sets the stop distance to the distance traveled since last reset added to the distance to be traveled.
		stopDist = RobotMap.rightEnc.getDistance() + driveDist;
		
	}
	
	// this function starts the DifferentialDrive
	protected void execute() {
		
		RobotMap.driveBot.tankDrive(leftSpeed, rightSpeed);
		
	}
	
	//determines when its time to stop
	@Override
	protected boolean isFinished() {
		
		//this needs to return either true or false, using the distanceChecking method and comparing it to the stopDist
		return (RobotMap.rightEnc.getDistance() >= stopDist);
	}

	//this function is supposed to stop the DifferentialDrive
	protected void end() {
		
		RobotMap.driveBot.stopMotor();
		
	}
	
}