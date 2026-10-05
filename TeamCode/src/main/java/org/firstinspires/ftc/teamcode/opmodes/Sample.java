package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class Sample extends LinearOpMode {
	//Variables defined here
	DcMotor shooterMotor;
	Servo testServo;

	@Override
	public void runOpMode() throws InterruptedException {
		//Initialize sensors and actuators here
		shooterMotor=hardwareMap.get(DcMotorEx.class, "shooter");
		testServo=hardwareMap.get(Servo.class, "test");

		waitForStart();

		//Main loop
		while (opModeIsActive() && !isStopRequested()) {


		}
	}
}