package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

public class Indexer {
	private final DcMotorEx indexerMotor;
	private final Telemetry telemetry;

	public Indexer(HardwareMap hardwareMap, Telemetry telemetry) {
		this.indexerMotor=hardwareMap.get(DcMotorEx.class, Constants.Indexer.INDEXER_ID);
		indexerMotor.setDirection(Constants.Indexer.INDEXER_DIRECTION);
		this.telemetry=telemetry;
	}

	public void index() {
	}

	public void reverse() {

	}

	public void stop() {

	}
}
