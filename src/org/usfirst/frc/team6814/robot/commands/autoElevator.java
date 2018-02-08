/* ==============================
 * ==============================
 * |||||||||||||||||||||||||||||||
 * FOR USE ONLY IN AUTON
 * |||||||||||||||||||||||||||||||
 * ==============================
 *=============================== */

package org.usfirst.frc.team6814.robot.commands;


import org.usfirst.frc.team6814.robot.subsystems.Motor;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class autoElevator extends Command {
	Motor m = new Motor();
	float extAmt;
	float mtrSpd;
	//set motor speed to either -.5 or .5 depending on whether or not 
	autoElevator(float extendAmt,float motorSpd)
	{
		//ATTENCION!! please be xrtra careful when putting in these values ^^, if they do not relate properly the robot will most likely explode.
		extAmt = extendAmt;
		mtrSpd = motorSpd;
	}
	
	public void execute()
	{
		//make the motor go 'clockwise' at half speed
		m.setSpeed(mtrSpd);
		System.out.println("raising elevator. . .");
	}
	@Override
	protected boolean isFinished() {
		Encoder e = new Encoder(0, 1, false, Encoder.EncodingType.k4X); e.setMaxPeriod(1);
		

		//is it the elevator at max height?
		if (e.get() == extAmt) {	
			//if so return
			return true;		
		}	
		return false;
	}
	
}
