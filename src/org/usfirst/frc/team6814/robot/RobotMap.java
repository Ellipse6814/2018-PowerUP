/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6814.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Timer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static Timer timer = new Timer();
	public static Spark leftFrontMotor = new Spark(0);
	public static Spark rightFrontMotor = new Spark(1);
	public static Spark leftBackMotor = new Spark(2);
	public static Spark rightBackMotor = new Spark(3);
	public static DifferentialDrive driveFrontBot = new DifferentialDrive(leftFrontMotor,rightFrontMotor);
	public static DifferentialDrive driveBackBot = new DifferentialDrive(leftBackMotor,rightBackMotor);
	public static Compressor compressor = new Compressor(0);
	public static DoubleSolenoid solenoid = new DoubleSolenoid(0,1);
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
