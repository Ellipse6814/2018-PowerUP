package org.usfirst.frc.team6814.robot.commands;
import edu.wpi.first.wpilibj.command.Command;

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
		
	}
	
	@Override 
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		
	}
}
