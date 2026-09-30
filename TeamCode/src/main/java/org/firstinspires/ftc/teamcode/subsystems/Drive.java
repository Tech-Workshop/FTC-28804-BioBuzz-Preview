package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.ManualDrive;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.pedro.Constants;

public class Drive {
	public Follower follower; //Pedropathing follower
	private final Telemetry telemetry;

	public double cacheX,cacheY,cacheHeading,cacheSpeed,cacheT;

	public Drive(HardwareMap hardwareMap, Telemetry telemetry, Pose startPose) {
		this.follower= Constants.create(hardwareMap);
		follower.setPose(startPose);
		follower.update();

		this.telemetry = telemetry;
	}

	/**
	 * Save location information to cache
	 */
	public void setCache() {
		this.cacheX=follower.pose().x();
		this.cacheY=follower.pose().y();
		this.cacheHeading=follower.pose().heading();
	}

	/**
	 * Teleop drive method
	 *
	 * @param gamepad1 Driver gamepad
	 */
	public void drive(Gamepad gamepad1) {
		//Check for low-speed mode
		double SPEED_MULTIPLIER = 1.0;
		if (gamepad1.left_bumper) {
			SPEED_MULTIPLIER = 0.3;
		}

		DrivePowers powers = ManualDrive.fieldCentric(
			gamepad1.left_stick_y* org.firstinspires.ftc.teamcode.Constants.General.CONTROLLER_DRIVE_MULTIPLIER*SPEED_MULTIPLIER, //Default is (-)
			gamepad1.left_stick_x* org.firstinspires.ftc.teamcode.Constants.General.CONTROLLER_DRIVE_MULTIPLIER*SPEED_MULTIPLIER,
			-gamepad1.right_stick_x* org.firstinspires.ftc.teamcode.Constants.General.CONTROLLER_TURN_MULTIPLIER,	//Default is (+)
			follower.pose().heading()
		);

		follower.manual(powers);
		follower.update();
	}


}
