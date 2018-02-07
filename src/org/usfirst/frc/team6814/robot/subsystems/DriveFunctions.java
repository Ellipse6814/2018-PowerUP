package org.usfirst.frc.team6814.robot.subsystems;

import org.usfirst.frc.team6814.robot.RobotMap;
import org.usfirst.frc.team6814.robot.commands.EncoderBackward;
import org.usfirst.frc.team6814.robot.commands.EncoderForward;
import org.usfirst.frc.team6814.robot.commands.EncoderLeft;
import org.usfirst.frc.team6814.robot.commands.EncoderRight;

import edu.wpi.first.wpilibj.Encoder;

public class DriveFunctions {
	public static void driveForward(double speed, int feet, int inches) {
		
		EncoderForward encForward = new EncoderForward(speed, feet, inches);
		
		
	}
	
	public static void driveBackward(double speed, int feet, int inches) {
		
		EncoderBackward encBackward = new EncoderBackward(speed, feet, inches);
		
	}
	
	public static void driveLeft(double speed, int feet, int inches) {
		
		EncoderLeft encleft = new EncoderLeft(speed, feet, inches);
		
	}
	
	public static void driveRight(double speed, int feet, int inches) {
	
		EncoderRight encRight = new EncoderRight(speed, feet, inches);
			
	}
	
}
