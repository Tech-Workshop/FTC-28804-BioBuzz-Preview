package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

public class Intake {
	private final DcMotorEx intakeMotor;
	private final Servo leftIntakeArm,rightIntakeArm;
	private final Telemetry telemetry;

	private double armPos,armTarget;

	enum ARM_STATUS {
		IDLE,
		MOVING
	}

	private ARM_STATUS armStatus=ARM_STATUS.IDLE;

	public Intake(HardwareMap hardwareMap, Telemetry telemetry) {
		this.intakeMotor=hardwareMap.get(DcMotorEx.class, Constants.Intake.INTAKE_ID);
		intakeMotor.setDirection(Constants.Intake.INTAKE_DIRECTION);

		this.leftIntakeArm=hardwareMap.get(Servo.class, Constants.Intake.INTAKE_ARM_LEFT_ID);
		this.rightIntakeArm=hardwareMap.get(Servo.class, Constants.Intake.INTAKE_ARM_RIGHT_ID);

		//Set current arm position and target (should be retracted at start)
		this.armTarget=this.armPos=Constants.Intake.INTAKE_ARM_RETRACTED_POS;

		this.telemetry=telemetry;
	}

	public void intake() {
	}

	public void expel() {

	}

	public void stop() {

	}

	public void retractArm() {
		if(armTarget!=armPos) {
			armTarget = Constants.Intake.INTAKE_ARM_RETRACTED_POS;
			armStatus=ARM_STATUS.MOVING;
		}
	}

	public void extendArm() {
		if(armTarget!=armPos) {
			armTarget = Constants.Intake.INTAKE_ARM_EXTENDED_POS;
			armStatus=ARM_STATUS.MOVING;
		}
	}

	public void armLoop() {
		if(armTarget==armPos) {
			armStatus=ARM_STATUS.IDLE;
		} else {
			double increment = Math.signum(armTarget - armPos);
			armPos+=increment*Constants.Intake.INTAKE_ARM_INCREMENT;

			leftIntakeArm.setPosition(armPos);
			rightIntakeArm.setPosition(armPos);
		}
	}

	public double getArmPosition() {
		return armTarget;
	}

	public boolean isArmDone() {
		if(armStatus==ARM_STATUS.IDLE) {
			return true;
		} else {
			return false;
		}
	}
}
