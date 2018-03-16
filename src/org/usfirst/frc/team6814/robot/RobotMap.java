<<<<<<< HEAD
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6814.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogGyro;
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
	
	//TIMERS --------------------------------------------------------------------
	
	public static Timer timer = new Timer();
	
	//MOTORS --------------------------------------------------------------------
	
	public static Spark elevator = new Spark(4);
	//left motors
	public static Spark leftFrontMotor = new Spark(0);
	public static Spark leftBackMotor = new Spark(1);
	//right motors
	public static Spark rightFrontMotor = new Spark(2);
	public static Spark rightBackMotor = new Spark(3);
	//setup left motor group
	public static SpeedControllerGroup leftSide = new SpeedControllerGroup(leftFrontMotor, leftBackMotor);
	//setup right motor group
	public static SpeedControllerGroup rightSide = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);
	//I'll leave these in here for now but I recommend not using them
	public static DifferentialDrive driveFrontBot = new DifferentialDrive(leftFrontMotor,rightFrontMotor);
	public static DifferentialDrive driveBackBot = new DifferentialDrive(leftBackMotor,rightBackMotor);
	//Setup differential drive
	public static DifferentialDrive driveBot = new DifferentialDrive(leftSide,rightSide);
	
	//PNEUMATICS ------------------------------------------------------------------
	
	//setup compressor
	public static Compressor compressor = new Compressor(0);
	//setup DoubleSolenoid
	public static DoubleSolenoid solenoid = new DoubleSolenoid(0,1);
	
	//MOVEMENT TRACKING(KIND OF) -----------------------------------------------------------------------
	
	//left Gyros
	public static AnalogGyro leftGyro1 = new AnalogGyro(0);
	public static AnalogGyro leftGyro2 = new AnalogGyro(1);
	//right Gyros
	public static AnalogGyro rightGyro1 = new AnalogGyro(2);
	public static AnalogGyro rightGyro2 = new AnalogGyro(3);
	public static Encoder elevatorEnc;
	public static Encoder rightEnc;
	
	public static void init() {
// 0, 1 are ports for digital display. false tells encoder not to invert. k4x is a more accurate because it counts 4 edges on 2 channels
		  rightEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		// a pulse is the light that gets cut of when the device rotates. this sets the travel distance for every pulse.
	      rightEnc.setDistancePerPulse(1.0);
	      // sets the distance on the encoder back to 0.
	      rightEnc.reset();
		
	      elevatorEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	      elevatorEnc.setDistancePerPulse(1.0);
	      elevatorEnc.reset();
	      
	}
	
	public static void resetEnc() {
		
		RobotMap.elevatorEnc.reset();
		RobotMap.rightEnc.reset();
		
	}
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
=======
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6814.robot;

//FRC imports.
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static Timer timer = new Timer();
	//left motors
	public static Spark leftFrontMotor = new Spark(0);
	public static Spark leftBackMotor = new Spark(1);
	//right motors
	public static Spark rightFrontMotor = new Spark(2);
	public static Spark rightBackMotor = new Spark(3);
	//setup left motor group
	public static SpeedControllerGroup leftSide = new SpeedControllerGroup(leftFrontMotor, leftBackMotor);
	//setup right motor group
	public static SpeedControllerGroup rightSide = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);
	//I'll leave these in here for now but I recommend not using them
	public static DifferentialDrive driveFrontBot = new DifferentialDrive(leftFrontMotor,rightFrontMotor);
	public static DifferentialDrive driveBackBot = new DifferentialDrive(leftBackMotor,rightBackMotor);
	//Setup differential drive
	public static DifferentialDrive driveBot = new DifferentialDrive(leftSide,rightSide);
	//setup compressor
	public static Compressor compressor = new Compressor(0);
	//setup DoubleSolenoid
	public static DoubleSolenoid solenoid = new DoubleSolenoid(0,1);
	//left Gyros
	public static AnalogGyro leftGyro1 = new AnalogGyro(0);
	public static AnalogGyro leftGyro2 = new AnalogGyro(1);
	//right Gyros
	public static AnalogGyro rightGyro1 = new AnalogGyro(2);
	public static AnalogGyro rightGyro2 = new AnalogGyro(3);
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
>>>>>>> master
