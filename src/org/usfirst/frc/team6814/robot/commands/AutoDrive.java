package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command{
	private boolean currentState = false;
	private double currentSpeed = .5;
	
	@Override
	protected void execute() {
		RobotMap.driveFrontBot.tankDrive(currentSpeed, currentSpeed);
		RobotMap.driveBackBot.tankDrive(currentSpeed, currentSpeed);
		if(RobotMap.timer.get() > 3) {
			currentSpeed *= -1;
			RobotMap.timer.reset();
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
