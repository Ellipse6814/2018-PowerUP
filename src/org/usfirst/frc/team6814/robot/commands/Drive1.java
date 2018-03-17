package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class Drive1 extends Command {
	private Joystick leftController;
	private Joystick rightController;


	public Drive1(Joystick leftController, Joystick rightController, AHRS ahrs) {//
		this.leftController = leftController;
		this.rightController = rightController;
		RobotMap.leftBackMotor.setExpiration(0.1);
		RobotMap.leftFrontMotor.setExpiration(0.1);
		RobotMap.rightBackMotor.setExpiration(0.1);
		RobotMap.rightFrontMotor.setExpiration(0.1);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void execute() {
		double l = leftController.getRawAxis(1);
		double r = leftController.getRawAxis(3);
		double p = (l + r) / 2;
		double t = l - r;
		if (leftController.getRawButton(5)) { // slow down to 60%
			p *= .6;
			t *= .3;
		}
		if (leftController.getRawButton(6)) { // go straight
			t = 0;
		}
		arcadeDrive(p, t);
	}

	private void arcadeDrive(double power, double turn) {
		double leftPower = power + turn;
		double rightPower = power - turn;
		ctrlMotors(leftPower, rightPower);
	}

	private void ctrlMotors(double l, double r) {
		RobotMap.driveFrontBot.tankDrive(-l, -r);
		RobotMap.driveBackBot.tankDrive(-l, -r);
	}

	@Override
	protected void end() {

	}

}
