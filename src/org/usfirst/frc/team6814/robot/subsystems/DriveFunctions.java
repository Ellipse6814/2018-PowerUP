package org.usfirst.frc.team6814.robot.subsystems;

import org.usfirst.frc.team6814.robot.commands.EncoderBackward;
import org.usfirst.frc.team6814.robot.commands.EncoderForward;
import org.usfirst.frc.team6814.robot.commands.EncoderLeft;
import org.usfirst.frc.team6814.robot.commands.EncoderRight;

public class DriveFunctions {
	public static void driveForward(double speed, double feet, double inches) {
		
		EncoderForward encForward = new EncoderForward(speed, feet, inches);
		
		
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
	
}
