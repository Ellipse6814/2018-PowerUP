package org.usfirst.frc.team6814.robot.subsystems;

import org.usfirst.frc.team6814.robot.commands.EncoderBackward;
import org.usfirst.frc.team6814.robot.commands.EncoderLeft;
import org.usfirst.frc.team6814.robot.commands.EncoderRight;
import org.usfirst.frc.team6814.robot.RobotMap;

public class DriveFunctions {
	public static void driveForward(double _speed, double feet, double inches) {
		double distance = (feet * 12) + inches;
		double speed = _speed;
		//We're only going to run one of these functions at a time so using a while loop is not an issue
		while(RobotMap.rightEnc.getDistance() < distance) {
			//this function makes sure the robot's speed changes over time as opposed to sudden stops and starts
			double driveSpeed = smoothSpeed(distance, RobotMap.rightEnc.getDistance());
			//send em forward!
			RobotMap.driveBot.tankDrive(driveSpeed, driveSpeed);
		}
		//each autonomous command assumes the encoder starts at zero
		RobotMap.rightEnc.reset();
	}
	
	public static void driveBackward(double speed, double feet, double inches) {
		
		EncoderBackward encBackward = new EncoderBackward(speed, feet, inches);
		
	}
	
	public static void driveLeft(double speed, double feet, double inches) {
		
		EncoderLeft encleft = new EncoderLeft(speed, feet, inches);
		
	}
	
	public static void driveRight(double speed, double feet, double inches) {
	
		EncoderRight encRight = new EncoderRight(speed, feet, inches);
			
	}
	//uses a function to make the robot accelerate and brake gradually as opposed to just jolting forward and stopping at the last second.
	public static double smoothSpeed(double totalDistance, double currentDistance) {
		double smoothSpeed;
		//the length of the parabola scales based on how far the robot needs to go
		double stretch = 1/totalDistance;
		//calculates an appropriate speed based on a reading from the encoder
		smoothSpeed = Math.pow(stretch * currentDistance - 1, 2) * -1 + 1;
		return smoothSpeed;
		//all done!
	}
}
