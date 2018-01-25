package org.usfirst.frc.team6814.robot.subsystems;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Spark;


public class Motor extends IterativeRobot {
	
	private static final int kMotorPort = 0;
	double speed;
	private SpeedController m_motor;
	
	
	@Override
	public void robotInit() {
		m_motor = new Spark(kMotorPort);
		
	}

	@Override
	public void teleopPeriodic() {
		//set the motor speed according to what command is being called(lowerElevator || raiseElevator
		m_motor.set(speed);
		
	}
	
	public void setSpeed(double s) {
		speed = s;
		
	}



}