package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;

    public void init(HardwareMap hm) {
        frontRight = hm.get(DcMotor.class, "rightFront");
        frontLeft = hm.get(DcMotor.class, "leftFront");
        backRight = hm.get(DcMotor.class, "rightRear");
        backLeft = hm.get(DcMotor.class, "leftRear");
    }

    public void loop(Gamepad gp1) {
        double y = gp1.left_stick_y; // Remember, Y stick value is reversed
        double x = gp1.left_stick_x * -1.1; // Counteract imperfect strafing
        double rx = gp1.right_stick_x * -1;

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        frontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        frontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);
    }
}
