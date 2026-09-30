package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Constants.General.Ball;

public class Turret {
	private final Servo turretServo;
	private final Telemetry telemetry;

	public Turret(HardwareMap hardwareMap, Telemetry telemetry, Ball ballType) {
		//Nectar
		if(ballType==Ball.NECTAR) {
			this.turretServo=hardwareMap.get(Servo.class, Constants.Turret.TURRET_NECTAR_ID);

		//Pollen
		} else {
			this.turretServo=hardwareMap.get(Servo.class, Constants.Turret.TURRET_POLLEN_ID);
		}

		this.telemetry=telemetry;
	}




}
