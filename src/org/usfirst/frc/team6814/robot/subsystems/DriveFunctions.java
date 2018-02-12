package org.usfirst.frc.team6814.robot.subsystems;

import org.usfirst.frc.team6814.robot.RobotMap;
import org.usfirst.frc.team6814.robot.commands.EncoderBackward;
import org.usfirst.frc.team6814.robot.commands.EncoderForward;
import org.usfirst.frc.team6814.robot.commands.EncoderLeft;
import org.usfirst.frc.team6814.robot.commands.EncoderRight;

public class DriveFunctions {
	
	int feetDist; // how many feet the bot should drive
	int inchDist; // how many inches the bot should drive
	static double driveDist; // how far the bot should drive
	static double stopDist; // the distance at which it should stop
	static double botSpeed; // the speed the bot is going
	static double leftSpeed; // turning left speed
	static double rightSpeed; // turning right speed
	
	public static void driveForward(double speed, double feet, double inches) {
		
		EncoderForward encForward = new EncoderForward(speed, feet, inches);
		
	}
	
	public static void driveBackward(double speed, double feet, double inches) {
		
		driveDist = (inches + (12 * feet)); // adds the feet and inches by converting the feet to inches and adding
		botSpeed = speed;
		leftSpeed = botSpeed*1; // setting turning speeds
		rightSpeed = botSpeed*-1; // setting turning speeds
		stopDist = RobotMap.rightEnc.getDistance() - driveDist;
		
		while(RobotMap.rightEnc.getDistance() <= stopDist ) {
			
			RobotMap.driveBot.tankDrive(leftSpeed, rightSpeed);
			
		}
		
		RobotMap.driveBot.stopMotor();
	}
	
	public static void driveLeft(double speed, double feet, double inches) {
		
		EncoderLeft encleft = new EncoderLeft(speed, feet, inches);
		
	}
	
	public static void driveRight(double speed, double feet, double inches) {
	
		driveDist = (inches + (12 * feet)); // adds the feet and inches by converting the feet to inches and adding
		botSpeed = speed;
		leftSpeed = botSpeed*-1; // setting turning speeds
		rightSpeed = botSpeed*-1; // setting turning speeds
		stopDist = RobotMap.rightEnc.getDistance() - driveDist;
		
		while(RobotMap.rightEnc.getDistance() <= stopDist ) {
			
			RobotMap.driveBot.tankDrive(leftSpeed, rightSpeed);
			
		}
		
		RobotMap.driveBot.stopMotor();
			
	}
	
}
