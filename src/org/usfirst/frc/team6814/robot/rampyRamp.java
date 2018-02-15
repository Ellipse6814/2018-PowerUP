package org.usfirst.frc.team6814.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6814.robot.RobotMap;

public class rampyRamp extends Command{

	
//	private Joystick rightStick;
	//private Servo rampyServo = new Servo(8); //Port may be subject to change
	
	@Override
	protected void initialize() {
		RobotMap.rampyServo.set(0.0);
	}
	
	
	public rampyRamp(Joystick rightJoystick) {
		this.rightStick = rightJoystick;
	}
	
	@Override
	protected void execute() {
		if(rampyServo.get() > 1) {
			rampyServo.set(1);
		} else if(rampyServo.get() == 1) {
			RobotMap.rampyRampCtrl1.set(.5);
			RobotMap.rampyRampCtrl2.set(.5);
			}		
		
		//if(this.rightStick.getRawButton(5) && this.rightStick.getRawButton(5)) {
			//RobotMap.rampyRampCtrl1.set(.5);
		
		}
	//}
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
