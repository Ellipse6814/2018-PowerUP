package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;

public class GrabbyGrabbyCtrl extends Command{
	private Joystick rightStick;
	private boolean lastAction = false; //[true:Fwd|false:Rev]every time solenoid status CHANGES, it will log the current status (it doesn't log a billion times a second)
	
	
	public GrabbyGrabbyCtrl(Joystick rightJoystick) {
		this.rightStick = rightJoystick;
	}
	
	@Override
	protected void execute() {
		if(this.rightStick.getRawButton(1)) {
			RobotMap.solenoid.set(DoubleSolenoid.Value.kForward);
		//	if (!lastAction) {lastAction = true;System.out.println("Intake: Grab");}
		}else {
			RobotMap.solenoid.set(DoubleSolenoid.Value.kReverse);
		//	if (lastAction) {lastAction = false;System.out.println("Intake: Release");}
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		RobotMap.solenoid.set(DoubleSolenoid.Value.kOff); 
		System.out.println("Intake: PROCESS TERMINATED");
	}
}
