package org.usfirst.frc.team6814.robot.commands;

//FRC imports
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Joystick;
//Our imports
import org.usfirst.frc.team6814.robot.RobotMap;

public class Drive2 extends Command{
	private Joystick leftStick;
	//use rightStick lower trigger to control the pneumatics system I think you can get it with rightStick.getButton(0);
	private Joystick rightStick;
	public Drive2(Joystick leftStick, Joystick rightStick) {
		this.leftStick = leftStick;
		this.rightStick = rightStick;
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		RobotMap.driveBot.tankDrive(leftStick.getY() * -1, rightStick.getY() * -1);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override 
	protected void end() {
		
	}
}