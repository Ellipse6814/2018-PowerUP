package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;

public class AutoDrive extends Command{
	private boolean currentState = false;
	private DifferentialDrive robot = RobotMap.driveBot;
	private Encoder enc = RobotMap.rightEnc;
	//distance in inches = 132; in feet: 11
	private double distance = 132;
	private double wheelCircumference = Math.PI * 6;
	
	@Override
	protected void execute() {
		double rotations = enc.get()/128;
		double distTraveled = rotations * wheelCircumference;
		if(distTraveled < distance) {
			robot.tankDrive(1, 1);
		} else {
			robot.tankDrive(0,0);
			currentState = true;
		}
	}
	
	@Override
	protected boolean isFinished() {
		return currentState;
	}
	
	@Override
	protected void end() {
		RobotMap.timer.reset();
	}
	
}
