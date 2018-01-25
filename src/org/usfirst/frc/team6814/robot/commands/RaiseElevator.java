package org.usfirst.frc.team6814.robot.commands;


import org.usfirst.frc.team6814.robot.subsystems.Motor;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class RaiseElevator extends Command
{
	
	Motor m = new Motor();
	
	public void initialize()
	{
		
	}
	
	public void execute()
	{
		//make the motor go 'clockwise' at half speed
		m.setSpeed(0.5);
		System.out.println("RaiseElevator");
	}
	@Override
	protected boolean isFinished() {
		Encoder e = new Encoder(0, 1, false, Encoder.EncodingType.k4X); e.setMaxPeriod(1);
		

		//is it the elevator at max height?
		if (e.get() == 1) {	
			//if so return
			return true;		
		}	
		return false;
	}
	
	
}
