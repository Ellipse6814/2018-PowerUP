package org.usfirst.frc.team6814.robot.commands;

import org.usfirst.frc.team6814.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
	private Joystick leftController;
	private Joystick rightController;

	private static final double kP = 0.03;
	private static final double kToleranceDegrees = 2.0f;
	// private AHRS ahrs;
	private boolean lastStatus = false; // false:turning | true:straight

	public Drive(Joystick leftController, Joystick rightController) {//
		this.leftController = leftController;
		this.rightController = rightController;
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void execute() {
//		ellipseDrive(leftController.getRawAxis(1),leftController.getRawAxis(5));
		
	}
	
	private void cheesyDrive(double power, double turn) {
		double leftPower = power-turn;
		double rightPower = power+turn;
		ctrlMotors(leftPower, rightPower);
	}
	
	private void arcadeDrive(double power, double turn) {
		double leftPower = power-power*turn;
		double rightPower = power+power*turn;
		ctrlMotors(leftPower, rightPower);
	}

	private void ellipseDrive(double leftStick, double rightStick) {
		double leftPower = 0;
		double rightPower = 0;
		if (Math.abs(rightStick - leftStick) < 0.35) {
			if (!lastStatus) {
				lastStatus = true;
				// ahrs.reset();
			}

			double averagePower = (leftStick + rightStick) / 2;
			leftPower = averagePower;
			rightPower = averagePower;


		} else {
			lastStatus = false;
			leftPower = leftStick;// *.6;
			rightPower = rightStick;// *0.6;
		}
		if (leftController.getRawButton(6)) {
			leftPower *= 0.6;
			rightPower *= 0.6;
		}
		ctrlMotors(leftPower,rightPower);
		
	}
	
	private void ctrlMotors(double l,double r) {
		RobotMap.driveFrontBot.tankDrive(l * -1, r * -1);
		RobotMap.driveBackBot.tankDrive(l * -1, r * -1);
	}

	@Override
	protected void end() {

	}

}

//			// if (ahrs.getAngle() > 180 && ahrs.getAngle() < 358) {
// rightPower -= 0.1;
// } else if (ahrs.getAngle() < 180 && ahrs.getAngle() > 2) {
// leftPower -= 0.1;
// }
///////////////////////////////////////////////////////////////////////
//System.out.println(ahrs.getAngle());
		// System.out.println(ahrs.getQuaternionZ());
		// System.out.println(ahrs.getRawAccelZ());
		// System.out.println(ahrs.getRawGyroZ());
		// System.out.println(ahrs.getVelocityZ());
		// System.out.println(ahrs.getRawMagZ());
		// System.out.println(ahrs.get);

		// boolean zero_yaw_pressed = false; //stick.getTrigger();
		// if ( zero_yaw_pressed ) {
		// ahrs.zeroYaw();
		// }

		/* Display 6-axis Processed Angle Data */
		// SmartDashboard.putBoolean("IMU_Connected", ahrs.isConnected());
		// SmartDashboard.putBoolean("IMU_IsCalibrating", ahrs.isCalibrating());
		// SmartDashboard.putNumber("IMU_Yaw", ahrs.getYaw());
		// SmartDashboard.putNumber("IMU_Pitch", ahrs.getPitch());
		// SmartDashboard.putNumber("IMU_Roll", ahrs.getRoll());
		//
		// /* Display tilt-corrected, Magnetometer-based heading (requires */
		// /* magnetometer calibration to be useful) */
		//
		// SmartDashboard.putNumber("IMU_CompassHeading", ahrs.getCompassHeading());
		//
		// /* Display 9-axis Heading (requires magnetometer calibration to be useful) */
		// SmartDashboard.putNumber("IMU_FusedHeading", ahrs.getFusedHeading());
		//
		// /* These functions are compatible w/the WPI Gyro Class, providing a simple */
		// /* path for upgrading from the Kit-of-Parts gyro to the navx MXP */
		//
		// SmartDashboard.putNumber("IMU_TotalYaw", ahrs.getAngle());
		// SmartDashboard.putNumber("IMU_YawRateDPS", ahrs.getRate());
		//
		// /* Display Processed Acceleration Data (Linear Acceleration, Motion Detect)
		// */
		//
		// SmartDashboard.putNumber("IMU_Accel_X", ahrs.getWorldLinearAccelX());
		// SmartDashboard.putNumber("IMU_Accel_Y", ahrs.getWorldLinearAccelY());
		// SmartDashboard.putBoolean("IMU_IsMoving", ahrs.isMoving());
		// SmartDashboard.putBoolean("IMU_IsRotating", ahrs.isRotating());
		//
		// /* Display estimates of velocity/displacement. Note that these values are */
		// /* not expected to be accurate enough for estimating robot position on a */
		// /* FIRST FRC Robotics Field, due to accelerometer noise and the compounding
		// */
		// /* of these errors due to single (velocity) integration and especially */
		// /* double (displacement) integration. */
		//
		// SmartDashboard.putNumber("Velocity_X", ahrs.getVelocityX());
		// SmartDashboard.putNumber("Velocity_Y", ahrs.getVelocityY());
		// SmartDashboard.putNumber("Displacement_X", ahrs.getDisplacementX());
		// SmartDashboard.putNumber("Displacement_Y", ahrs.getDisplacementY());
		//
		// /* Display Raw Gyro/Accelerometer/Magnetometer Values */
		// /* NOTE: These values are not normally necessary, but are made available */
		// /* for advanced users. Before using this data, please consider whether */
		// /* the processed data (see above) will suit your needs. */
		//
		// SmartDashboard.putNumber("RawGyro_X", ahrs.getRawGyroX());
		// SmartDashboard.putNumber("RawGyro_Y", ahrs.getRawGyroY());
		// SmartDashboard.putNumber("RawGyro_Z", ahrs.getRawGyroZ());
		// SmartDashboard.putNumber("RawAccel_X", ahrs.getRawAccelX());
		// SmartDashboard.putNumber("RawAccel_Y", ahrs.getRawAccelY());
		// SmartDashboard.putNumber("RawAccel_Z", ahrs.getRawAccelZ());
		// SmartDashboard.putNumber("RawMag_X", ahrs.getRawMagX());
		// SmartDashboard.putNumber("RawMag_Y", ahrs.getRawMagY());
		// SmartDashboard.putNumber("RawMag_Z", ahrs.getRawMagZ());
		// SmartDashboard.putNumber("IMU_Temp_C", ahrs.getTempC());
		// SmartDashboard.putNumber("IMU_Timestamp", ahrs.getLastSensorTimestamp());
		//
		// /* Omnimount Yaw Axis Information */
		// /* For more info, see http://navx-mxp.kauailabs.com/installation/omnimount */
		// AHRS.BoardYawAxis yaw_axis = ahrs.getBoardYawAxis();
		// SmartDashboard.putString("YawAxisDirection", yaw_axis.up ? "Up" : "Down");
		// SmartDashboard.putNumber("YawAxis", yaw_axis.board_axis.getValue());
		//
		// /* Sensor Board Information */
		// SmartDashboard.putString("FirmwareVersion", ahrs.getFirmwareVersion());
		//
		// /* Quaternion Data */
		// /* Quaternions are fascinating, and are the most compact representation of */
		// /* orientation data. All of the Yaw, Pitch and Roll Values can be derived */
		// /* from the Quaternions. If interested in motion processing, knowledge of */
		// /* Quaternions is highly recommended. */
		// SmartDashboard.putNumber("QuaternionW", ahrs.getQuaternionW());
		// SmartDashboard.putNumber("QuaternionX", ahrs.getQuaternionX());
		// SmartDashboard.putNumber("QuaternionY", ahrs.getQuaternionY());
		// SmartDashboard.putNumber("QuaternionZ", ahrs.getQuaternionZ());
		//
		// /* Connectivity Debugging Support */
		// SmartDashboard.putNumber("IMU_Byte_Count", ahrs.getByteCount());
		// SmartDashboard.putNumber("IMU_Update_Count", ahrs.getUpdateCount());
		//
		////////////////////////////////////////////////////////////////////////////////
//ahrs = new AHRS(I2C.Port.kMXP);
		// try {
		// /***********************************************************************
		// * navX-MXP:
		// * - Communication via RoboRIO MXP (SPI, I2C, TTL UART) and USB.
		// * - See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface.
		// *
		// * navX-Micro:
		// * - Communication via I2C (RoboRIO MXP or Onboard) and USB.
		// * - See http://navx-micro.kauailabs.com/guidance/selecting-an-interface.
		// *
		// * Multiple navX-model devices on a single robot are supported.
		// ************************************************************************/
		// //ahrs = new AHRS(SerialPort.Port.kUSB1);
		// //ahrs = new AHRS(SerialPort.Port.kMXP, SerialDataType.kProcessedData,
		// (byte)200);
		// //ahrs = new AHRS(SPI.Port.kMXP);
		// ahrs = new AHRS(I2C.Port.kMXP);
		// ahrs.enableLogging(true);
		// } catch (RuntimeException ex ) {
		// DriverStation.reportError("Error instantiating navX MXP: " + ex.getMessage(),
		// true);
		// }