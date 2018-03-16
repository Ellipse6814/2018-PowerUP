package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class AutoDrive extends Command{
	private boolean currentState = false;
	private DifferentialDrive robot = RobotMap.driveBot;
	
	@Override
	protected void execute() {
		double currentTime = RobotMap.timer.get();
		if(currentTime < 3) {
			robot.tankDrive(1, 1);
		} else {
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
