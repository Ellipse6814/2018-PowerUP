package org.usfirst.frc.team6814.robot.subsystems;

import org.usfirst.frc.team6814.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;

public class DriveFunctions {
	public static void drive(double _distance) {
		double distance = _distance;
		while(true) {
			if(RobotMap.rightEnc.getDistance() > distance) {
				break;
			}else {
				RobotMap.driveBot.tankDrive(.5, .5);
			}
		}
	}
}
