package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {
    public static Follower create(HardwareMap h) {
        return new Follower(
           new PinpointLocalizer(h, localizerConfig),
           new Mecanum(h, drivetrainConfig),
           new Foresight(foresightConfig)
        );
    }

    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("drive_left_front");
        c.frontRightName.set("drive_right_front");
        c.backLeftName.set("drive_left_back");
        c.backRightName.set("drive_right_back");
        c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(-3.472867349940022);
        c.yPodOffset.set(-2.091778582475317);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });

    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.23368852303455992);
                Controller secondaryTranslationalForward = Controller.proportional(0.08634166498893199);
                Controller primaryTranslationalLateral = Controller.proportional(0.32976227808634534);
                Controller secondaryTranslationalLateral = Controller.proportional(0.12183835034255205);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.009674500729267135));
                c.brake.set(Controller.proportionalFeedforward(0.008223325619877065));

                c.headingFeedback.set(Controller.proportional(4.165494158543937));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.06999855363587984, 0.004330542637118816));

                c.linearBrakeCoefficients.set(Matrix.diag(0.1305545861780827, 0.07989367092509611));
                c.quadraticBrakeCoefficients.set(Matrix.diag(0.0010080956260398878, 0.0016169847218529228));

                c.maxAchievableForwardVelocity.set(92.75650514541314);
                c.maxAchievableStrafeVelocity.set(75.89131359804999);
                c.naturalForwardDeceleration.set(21.207121813028508);
                c.naturalStrafeDeceleration.set(54.84938871422495);
            }
    );
}