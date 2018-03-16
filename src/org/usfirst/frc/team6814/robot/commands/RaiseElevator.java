package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseElevator extends Command {
	
	@Override
	protected void execute() {
		//make the motor go 'clockwise' at half speed
		RobotMap.elevator.setSpeed(0.5);
		System.out.println("RaiseElevator");
	}
	
	@Override
	protected boolean isFinished() {

		//is it the elevator at max height?
		if (RobotMap.elevatorEnc.get() == 2) {
			//if so return
			return true;
		}else {
			return false;
		}
	}
}