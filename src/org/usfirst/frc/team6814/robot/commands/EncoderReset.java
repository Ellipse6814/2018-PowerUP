package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderReset extends Command{

	public void execute() {
		
		RobotMap.encoder.reset();
		
	}
	
	@Override
	protected boolean isFinished() {
		
		return false;
	}
	
}
