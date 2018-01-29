package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
	private Joystick leftController;
	private Joystick rightController;
	
	private static final double kP = 0.03;
	private static final double kToleranceDegrees = 2.0f;
	private AHRS ahrs;
	private boolean lastStatus = false; //false:turning | true:straight

	public Drive(Joystick leftController, Joystick rightController) {
		this.leftController = leftController;
		this.rightController = rightController;
		ahrs = new AHRS(SPI.Port.kMXP);
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
			if (!lastStatus) {
				lastStatus = true;
				ahrs.reset();
			}
			double averagePower = (leftStick + rightStick) / 2;
			leftPower = averagePower;
			rightPower = averagePower;
			if (ahrs.getAngle()>180 && ahrs.getAngle()<358) {
				rightPower -= 0.1;
			}else if (ahrs.getAngle()<180 && ahrs.getAngle()>2) {
				leftPower -= 0.1;
			}
		}else {
				lastStatus = false;
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