package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Constants.General.Ball;

public class Shooter {
	private final DcMotorEx shooterMotor;
	private final Telemetry telemetry;

	public Shooter(HardwareMap hardwareMap, Telemetry telemetry, Ball ballType) {
		//Nectar
		if(ballType==Ball.NECTAR) {
			this.shooterMotor = hardwareMap.get(DcMotorEx.class, Constants.Shooter.SHOOTER_NECTAR_ID);
			shooterMotor.setDirection(Constants.Shooter.SHOOTER_NECTAR_DIRECTION);

		//Pollen
		} else {
			this.shooterMotor = hardwareMap.get(DcMotorEx.class, Constants.Shooter.SHOOTER_POLLEN_ID);
			shooterMotor.setDirection(Constants.Shooter.SHOOTER_POLLEN_DIRECTION);
		}

		this.telemetry=telemetry;
	}




}
