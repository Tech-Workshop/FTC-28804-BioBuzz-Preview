package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

@TeleOp(group = "UTILITY",name="Utility: Servo Reset/Tuning")
public class UtilityServo extends LinearOpMode {
	private Servo turretNectar,turretPollen;

	double turretPos=0.50;

	@Override
	public void runOpMode() throws InterruptedException {
		turretNectar=hardwareMap.get(Servo.class, Constants.Shooter.SHOOTER_NECTAR_ID);
		turretPollen=hardwareMap.get(Servo.class, Constants.Shooter.SHOOTER_POLLEN_ID);

		waitForStart();

		while (opModeIsActive() && !isStopRequested()) {

			//Turret - Reset to 50%
			if(gamepad1.a) {
				turretNectar.setPosition(0.50);
				turretPollen.setPosition(0.50);
			}

			//Turret - Tuning
			if (gamepad1.dpad_right) {
				if (turretPos < 1.0) {
					turretPos+=0.001;
					turretNectar.setPosition(turretPos);
					turretPollen.setPosition(turretPos);
				}
			} else if (gamepad1.dpad_left) {
				if (turretPos > 0.0) {
					turretPos-=0.001;
					turretNectar.setPosition(turretPos);
					turretPollen.setPosition(turretPos);
				}
			}

			telemetry.addLine("Turrets (Reset 50%) - Press A");
			telemetry.addLine("Turrets (Tuning) - D-Pad Right/Left");
			telemetry.addData("Turrets (Pos):",turretNectar.getPosition());

			telemetry.update();
		}
	}
}