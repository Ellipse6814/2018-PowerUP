package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
	private Joystick leftController;
	private Joystick rightController;
	private double fAngle;
	private boolean ForceStraight = false;
	private boolean straight = false;
	private boolean forwards = true;
	private int turn = -1;
	private int lastturn = -1;
	private boolean wantedTurn = false;
	private int lastStatus = 0; // 1:forward straught; 2:backward straight; 3: turning whatever
	private AHRS ahrs;
	// private boolean LEDWonderAround = true;
	// private PWM r;
	// private PWM g;
	// private PWM b;

	public Drive(Joystick leftController, Joystick rightController, AHRS ahrs) {//
		this.leftController = leftController;
		this.rightController = rightController;
		this.ahrs = ahrs;
		resetGYRO();
		// this.r = RobotMap.r;
		// this.g = RobotMap.g;
		// this.b = RobotMap.b;
		// this.r.setRaw(255);
		// this.g.setRaw(255);
		// this.b.setRaw(255);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void execute() {
		double l = leftController.getRawAxis(1);
		double r = leftController.getRawAxis(0);
		
		System.out.println(fAngle);
		// System.out.println(this.leftController.getPOV());
		turn90();
		Forcestriaght(l, r);
		if (!ForceStraight) {
			checkStraight(l, r);
			// ellipseDrive(leftController.getRawAxis(1),leftController.getRawAxis(5));
			if (l > -0.1 && l < 0.1 && Math.abs(r) > 0.5) {
				rotate(r);
			} else {
				arcadeDrive(l, r);
			}
			// System.out.println(ahrs.getAngle());
		} else {
			setLED(255, 0, 0);
		}

	}

	private void turn90() {
		lastturn = turn;
		turn = this.leftController.getPOV();
		if (!(turn == -1) && lastturn == -1) {
			resetGYRO();
			wantedTurn = true;
			fAngle=-(turn-180);
			System.out.println("Setting turn angle: "+fAngle);
		}
	}

	private double getBigger(double a, double b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

	private void Forcestriaght(double l, double r) {
		// System.out.println(leftController.getRawButton(1));
		if (leftController.getRawButton(1) && !(ForceStraight)) { // start going straight
			resetGYRO();
			straight = true;
			ForceStraight = true;
			// System.out.println("F straight");
		} else if (!(leftController.getRawButton(1)) && ForceStraight) { // ended going straight
			straight = false;
			ForceStraight = false;
			// System.out.println("F turning");
		}
		if (ForceStraight && !((lastStatus == 1 && (l >= 0 && r >= 0)) || (lastStatus == 2 && (l < 0 && r < 0)))) {
			resetGYRO();
			// System.out.println("F change direction -> reset");
		}

		ctrlMotors(l, l);
	}

	private void rotate(double spd) {
		ctrlMotors(-spd, spd);
	}

	private void checkStraight(double l, double r) {
		double straightAngle = 0.6;
		// if (doubleJoystick) {
		if (Math.abs(l - r) <= straightAngle && l >= 0 && r >= 0 && !(lastStatus == 1)) { // start going straight
			resetGYRO();
			lastStatus = 1;
			straight = true;
			setLED(0, 255, 0);
			// System.out.println("forwards");
		} else if (Math.abs(l - r) <= straightAngle && l < 0 && r < 0 && !(lastStatus == 2)) { // start going straight
			resetGYRO();
			lastStatus = 2;
			straight = true;
			setLED(255, 255, 0);
			// System.out.println("backwards");
		} else {
			lastStatus = 3;
			straight = false;
			setLED(0, 0, 255);
			// System.out.println("turing");
		}

		// if (Math.abs(l - r) > straightAngle && straight == true) { // ended going
		// straight
		// straight = false;
		// System.out.println("turning");
		// }
		// if (l >= 0 && r >= 0 && forwards == false) {
		// forwards = true;
		// resetGYRO();
		// System.out.println("Forwards");
		// } else if (l < 0 && r < 0 && forwards == true) {
		// forwards = false;
		// resetGYRO();
		// System.out.println("Backwards");
		// }
		// } else {
		// if (Math.abs(r) <= straightAngle && straight == false) { // start going
		// straight
		// resetGYRO();
		// straight = true;
		// System.out.println("straight");
		// } else if (Math.abs(r) > straightAngle && straight == true) { // ended going
		// straight
		// straight = false;
		// System.out.println("turning");
		// }
		// if (l >= 0 && forwards == false) {
		// forwards = true;
		// resetGYRO();
		// System.out.println("Forwards");
		// } else if (l < 0 && forwards == true) {
		// forwards = false;
		// resetGYRO();
		// System.out.println("Backwards");
		// }
		// }

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

	/*
	 * private void eDrive(double leftStick, double rightStick) { double leftPower =
	 * 0; double rightPower = 0; if (Math.abs(rightStick - leftStick) < 0.35) { if
	 * (!lastStatus) { lastStatus = true; // ahrs.reset(); }
	 * 
	 * double averagePower = (leftStick + rightStick) / 2; leftPower = averagePower;
	 * rightPower = averagePower;
	 * 
	 * } else { lastStatus = false; leftPower = leftStick;// *.6; rightPower =
	 * rightStick;// *0.6; } if (leftController.getRawButton(6)) { leftPower *= 0.6;
	 * rightPower *= 0.6; } ctrlMotors(leftPower, rightPower);
	 * 
	 * }
	 */
	private void ctrlMotors(double l, double r) {
		RobotMap.driveFrontBot.tankDrive((l + GYROl(l, r)) * -1, (r + GYROr(l, r)) * -1);
		RobotMap.driveBackBot.tankDrive((l + GYROl(l, r)) * -1, (r + GYROr(l, r)) * -1);
	}

	private double GYROl(double l, double r) {
		if (wantedTurn) {
			if (fAngle>2) {
				return 0.5;
			}else if (fAngle<-2){
				return -0.5;
			}else {
				wantedTurn = false;
				System.out.println("Turn finished.");
			}
		} else if (straight)
			if (ahrs.getAngle() - fAngle > 1) {
				return -0.1;
			}
		return 0.0;
	}

	private double GYROr(double l, double r) {
		if (wantedTurn) {
			if (fAngle<-2) {
				return 0.5;
			}else if(fAngle>2) {
				return -0.5;
			}
//			else {
//				wantedTurn = false;
//			}
		} else if (straight)
			if (ahrs.getAngle() - fAngle < -1) {
				return -0.1;
			}
		return 0.0;
	}

	private void resetGYRO() {
		fAngle = ahrs.getAngle();
		// System.out.println(fAngle);
	}

	private void setLED(int r, int g, int b) {
		// LEDWonderAround=false;
		// this.r.setRaw(r);
		// this.g.setRaw(g);
		// this.b.setRaw(b);
	}

	// private void LEDwonderAround() {
	// if (LEDWonderAround) {
	// this.r.setRaw(r);
	// this.g.setRaw(g);
	// this.b.setRaw(b);
	// }
	// }

	@Override
	protected void end() {

	}

}
