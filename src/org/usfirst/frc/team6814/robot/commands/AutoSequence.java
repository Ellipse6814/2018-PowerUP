package org.usfirst.frc.team6814.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6814.robot.subsystems.DriveFunctions;

public class AutoSequence extends Command{
	double speed;
	double inches_perTurn = Math.PI * 6;
	boolean finished = false;
	
	public AutoSequence() {
	}
	
	@Override
	protected void execute() {
		DriveFunctions.driveForward(1,6);
		finished = true;
	}
	
	@Override
	protected boolean isFinished() {
		return finished;
	}
	
	@Override
	protected void end() {
		
	}
}