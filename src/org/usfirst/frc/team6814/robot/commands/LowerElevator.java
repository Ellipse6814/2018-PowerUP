package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;



public class LowerElevator extends Command {
	
	@Override
	protected void execute() {
		RobotMap.elevator.setSpeed(-0.5);
		System.out.println("LowerElevator");
	}
	@Override
	protected boolean isFinished() {
		
		//is the elevator at the lowest point?
		if (RobotMap.elevatorEnc.get() == -2) {
			return true;		
		}else {
			return false;
		}
	}
	
	
}