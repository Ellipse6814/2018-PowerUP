package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;



public class LowerElevator extends Command {
	
	public void initialize() {
	
	}
	
	public void execute()
	{
		RobotMap.elevator.setSpeed(-0.5);
		System.out.println("LowerElevator");
	}
	@Override
	protected boolean isFinished() {
		
		//is the elevator at the lowest point?
		if (RobotMap.elevatorEnc.get() == -1) {
			return true;		
		}		
		return false;
	}
	
	
}