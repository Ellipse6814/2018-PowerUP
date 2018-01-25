package org.usfirst.frc.team6814.robot.commands;


import org.usfirst.frc.team6814.robot.subsystems.Motor;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;



public class LowerElevator extends Command {
	
	Motor m = new Motor();
	
	public void initialize() {
	
	}
	
	public void execute()
	{
		m.setSpeed(-0.5);
		System.out.println("LowerElevator");
	}
	@Override
	protected boolean isFinished() {
		//make an encoder object
		Encoder e = new Encoder(0, 1, false, Encoder.EncodingType.k4X); e.setMaxPeriod(1);
		
		//is the elevator at the lowest point?
		if (e.get() == -1) {
			return true;		
		}		
		return false;
	}
	
	
}
