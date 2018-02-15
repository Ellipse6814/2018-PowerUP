package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class RaiseElevator extends Command {
	
	public void execute()
	{
		//make the motor go 'clockwise' at half speed
		RobotMap.elevator.setSpeed(0.5);
		System.out.println("RaiseElevator");
	}
	@Override
	protected boolean isFinished() {

		//is it the elevator at max height?
		if (RobotMap.elevatorEnc.get() == 1) {	
			//if so return
			return true;		
		}	
		return false;
	}
	
}