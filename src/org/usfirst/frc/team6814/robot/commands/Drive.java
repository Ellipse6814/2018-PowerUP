package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
	private Joystick leftController;
	private Joystick rightController;
	private double fAngle;
	private boolean straight = false;
	private boolean forwards = true;
	private AHRS ahrs;

	private boolean lastStatus = false; // false:turning | true:straight

	public Drive(Joystick leftController, Joystick rightController, AHRS ahrs) {//
		this.leftController = leftController;
		this.rightController = rightController;
		this.ahrs = ahrs;
		resetGYRO();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void execute() {
		double l = leftController.getRawAxis(1);
		double r = leftController.getRawAxis(0);
		checkStraight(l, r, false);
		// ellipseDrive(leftController.getRawAxis(1),leftController.getRawAxis(5));
		arcadeDrive(l, r);
		// System.out.println(ahrs.getAngle());
	}

	private void checkStraight(double l, double r, boolean doubleJoystick) {
		double straightAngle = 0.4;
		if (doubleJoystick) {
			if (Math.abs(l - r) <= straightAngle && straight == false) { // start going straight
				resetGYRO();
				straight = true;
				System.out.println("straight");
			} else if (Math.abs(l - r) > straightAngle && straight == true) { // ended going straight
				straight = false;
				System.out.println("turning");
			}
			if (l >= 0 && r >= 0 && forwards == false) {
				forwards = true;
				resetGYRO();
				System.out.println("Forwards");
			} else if (l < 0 && r < 0 && forwards == true) {
				forwards = false;
				resetGYRO();
				System.out.println("Backwards");
			}
		} else {
			if (Math.abs(r) <= straightAngle && straight == false) { // start going straight
				resetGYRO();
				straight = true;
				System.out.println("straight");
			} else if (Math.abs(r) > straightAngle && straight == true) { // ended going straight
				straight = false;
				System.out.println("turning");
			}
			if (l >= 0 && forwards == false) {
				forwards = true;
				resetGYRO();
				System.out.println("Forwards");
			} else if (l < 0 && forwards == true) {
				forwards = false;
				resetGYRO();
				System.out.println("Backwards");
			}
		}

	}

	private void cheesyDrive(double power, double turn) {
		double leftPower = power - turn;
		double rightPower = power + turn;
		ctrlMotors(leftPower, rightPower);
	}

	private void arcadeDrive(double power, double turn) {
		double leftPower = power + power * turn;
		double rightPower = power - power * turn;
		ctrlMotors(leftPower, rightPower);
	}

	private void EllipseDrive(double left, double right) {
		double power = (left + right) / 2;
		double turn = left - right;
		double leftPower = power + power * turn;
		double rightPower = power - power * turn;
		ctrlMotors(leftPower, rightPower);
	}

	private void eDrive(double leftStick, double rightStick) {
		double leftPower = 0;
		double rightPower = 0;
		if (Math.abs(rightStick - leftStick) < 0.35) {
			if (!lastStatus) {
				lastStatus = true;
				// ahrs.reset();
			}

			double averagePower = (leftStick + rightStick) / 2;
			leftPower = averagePower;
			rightPower = averagePower;

		} else {
			lastStatus = false;
			leftPower = leftStick;// *.6;
			rightPower = rightStick;// *0.6;
		}
		if (leftController.getRawButton(6)) {
			leftPower *= 0.6;
			rightPower *= 0.6;
		}
		ctrlMotors(leftPower, rightPower);

	}

	private void ctrlMotors(double l, double r) {
		RobotMap.driveFrontBot.tankDrive((l + GYROl(l, r)) * -1, (r + GYROr(l, r)) * -1);
		RobotMap.driveBackBot.tankDrive((l + GYROl(l, r)) * -1, (r + GYROr(l, r)) * -1);
	}

	private double GYROl(double l, double r) {
		if (ahrs.getAngle() - fAngle > 2 && straight) {
			return -0.1;
		}
		return 0.0;
	}

	private double GYROr(double l, double r) {
		if (ahrs.getAngle() - fAngle < -2 && straight) {
			return 0.1;
		}
		return 0.0;
	}

	private void resetGYRO() {
		fAngle = ahrs.getAngle();
		System.out.println(fAngle);
	}

	@Override
	protected void end() {

	}

}
