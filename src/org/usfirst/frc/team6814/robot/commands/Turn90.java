package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class Turn90 extends Command{
	private boolean exit = false;
	private double wantedAngle;
	private AHRS ahrs;

	public Turn90(AHRS ahrs, boolean left90) {//
		this.ahrs = ahrs;
		resetGYRO();
	}
	
	@Override
	protected void execute() {
		if (wantedAngle<-2) {
			ctrlMotors(-.5);
		}else if (wantedAngle>2){
			ctrlMotors(.5);
		}else {
			exit = true;
		}
	}
	
	private void ctrlMotors(double turn) { //-:left; +:right
		RobotMap.driveFrontBot.tankDrive((-turn) * -1, (turn) * -1);
		RobotMap.driveBackBot.tankDrive((-turn) * -1, (turn) * -1);
	}
	
	@Override
	protected boolean isFinished() {
		return exit;
	}
	
	@Override
	protected void end() {

	}
	
	private void resetGYRO() {
		wantedAngle = ahrs.getAngle()+90;
//		System.out.println(wangt);
	}
	
}
