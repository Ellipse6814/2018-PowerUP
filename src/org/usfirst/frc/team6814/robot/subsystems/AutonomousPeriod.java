package org.usfirst.frc.team6814.robot.subsystems;

import org.usfirst.frc.team6814.robot.RobotMap;

import edu.wpi.first.wpilibj.TimedRobot;

public class AutonomousPeriod extends TimedRobot {
	private double currentSpeed = .5;
	
	public void leftToRight() {
		
	
			RobotMap.driveFrontBot.tankDrive(currentSpeed, currentSpeed);
			RobotMap.driveBackBot.tankDrive(currentSpeed, currentSpeed);
		
		
		
		
		
	}
	
	
	
	
}
