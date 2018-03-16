/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//
//
//

//

package org.usfirst.frc.team6814.robot;

//THIS VERSION OF ROBOT CODE IS ONLY FOR USE IF OUR MASTER BRANCH FAILS

//FRC IMPORTS ----------------------------------------------------------------
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6814.robot.commands.ExampleCommand;
import org.usfirst.frc.team6814.robot.subsystems.ExampleSubsystem;
//import org.usfirst.frc.team6814.robot.commands.Drive;
import org.usfirst.frc.team6814.robot.commands.AutoDrive;
import org.usfirst.frc.team6814.robot.commands.GrabbyGrabbyCtrl;
import org.usfirst.frc.team6814.robot.commands.AutoSequence;

//Our imports.
import org.usfirst.frc.team6814.robot.commands.ExampleCommand;
import org.usfirst.frc.team6814.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team6814.robot.commands.Drive2;
import org.usfirst.frc.team6814.robot.commands.AutoDrive;
import org.usfirst.frc.team6814.robot.commands.GrabbyGrabbyCtrl;

public class Robot extends TimedRobot {
	public static final ExampleSubsystem kExampleSubsystem = new ExampleSubsystem();
	public static OI m_oi;
	//public Drive drive;
	public AutoDrive autoDrive;
	public GrabbyGrabbyCtrl grabbygrabby;
	public Drive2 drive;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.timer.start();
		m_oi = new OI();
		grabbygrabby = new GrabbyGrabbyCtrl(m_oi.leftController);
		autoDrive = new AutoDrive();
		//drive = new Drive(m_oi.leftController, m_oi.rightController);
		grabbygrabby = new GrabbyGrabbyCtrl(m_oi.leftController);
		autoDrive = new AutoDrive();
		drive = new Drive2(m_oi.leftController, m_oi.rightController);
		m_chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		// sets encoder distance to 0.
		RobotMap.resetEnc();
		
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	
	public void getArcadeConfig() {
		String arcadeConfig = DriverStation.getInstance().getGameSpecificMessage(); 
		char usableArray[] = arcadeConfig.toCharArray();
		int arcadeLocation = DriverStation.getInstance().getLocation();
		
		// 1 left field |  2 mid | 3 right
		// Autonomous code if both switch and scale on the left
		if ((arcadeLocation == 1 &&  (usableArray[0] == 'L') ||  usableArray[0] == 'l')) {
//			
//			DriveFunctions.driveForward(1.0, 5, 9.96);
//			DriveFunctions.driveLeft(1.0, 2, 0); 
//			DriveFunctions.driveForward(1.0, 24, 11.64);
			//
			
		} 

		// Autonomous code if both switch and scale are on the right
		else if ((arcadeLocation == 1 && (usableArray[0] == 'R') || usableArray[0] == 'r')) {
//			DriveFunctions.driveForward(1.0, 5, 9.96);
//			DriveFunctions.driveRight(1.0, 0, 0); //supposed to make it turn right in place
//			DriveFunctions.driveForward(1.0, 20, 0);
//			DriveFunctions.driveLeft(1.0, 0, 0); //supposed to make it turn left in place
			
		}

	
		// Autonomous code if the home switch is on the left and the scale is on the
		// right
		else if ((arcadeLocation == 3 && (usableArray[0] == 'R') || usableArray[0] == 'r')) {
			
		}
			
//			
//			DriveFunctions.driveForward(1.0, 5, 9.96);
//			DriveFunctions.driveRight(1.0, 2, 0);
//			DriveFunctions.driveForward(1.0, 24, 11.64);
//			
		
		// Autonomous code if the home switch is on the right and the scale is on the
		// left
		else if ((arcadeLocation == 3 && (usableArray[0] == 'L') ||  usableArray[0] == 'l')) {
			
		}


//			DriveFunctions.driveForward(1.0, 5, 9.96);
//			DriveFunctions.driveLeft(1.0, 0, 0); //supposed to make it turn left in place
//			DriveFunctions.driveForward(1.0, 20, 0);
//			DriveFunctions.driveRight(1.0, 0, 0); //supposed to make it turn right in place
//			DriveFunctions.driveForward(1.0, 22, 1.68); 
//		
	

	}
	
	@Override
	public void autonomousInit() {
		//m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		
		// sets encoder distance to 0.
		
		RobotMap.resetEnc();
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
		//this code drives the robot forward...that is all
		autoDrive.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		//Scheduler.getInstance().add(drive);
		drive.start();
		grabbygrabby.start();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
