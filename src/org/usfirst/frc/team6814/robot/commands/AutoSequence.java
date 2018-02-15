package org.usfirst.frc.team6814.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6814.robot.subsystems.DriveFunctions;

public class AutoSequence extends Command{
	double speed;
	double inches_perTurn = Math.PI * 6;
	public AutoSequence(double _speed) {
		this.speed = _speed;
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		DriveFunctions.driveForward(2,6);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		
	}
}