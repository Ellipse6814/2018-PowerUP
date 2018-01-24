package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
	private Joystick leftController;
	private Joystick rightController;

	public Drive(Joystick leftController, Joystick rightController) {
		this.leftController = leftController;
		this.rightController = rightController;
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void execute() {
		double leftStick = leftController.getY();
		double rightStick = rightController.getY();
		double leftPower = 0;
		double rightPower = 0;

		if (Math.abs(rightStick - leftStick) < 0.25) {
			double averagePower = (leftStick + rightStick) / 2;
			leftPower = averagePower;
			rightPower = averagePower;
		}
//		else {
//			leftPower = leftStick * .6;
//			rightPower = rightStick * .6;
//		}
		if (leftController.getRawButton(1)) {
			leftPower *= 0.6;
			rightPower *= 0.6;
		}

		RobotMap.driveFrontBot.tankDrive(leftPower * -1, rightPower * -1);
		RobotMap.driveBackBot.tankDrive(leftPower * -1, rightPower * -1);
	}

	@Override
	protected void end() {

	}

}