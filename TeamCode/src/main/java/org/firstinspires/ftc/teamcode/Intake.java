package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    DcMotor flywheel;
    Servo intakeWrist;
    public void Init(HardwareMap hm) {
        flywheel = hm.get(DcMotor.class, "intake");
        intakeWrist = hm.get(Servo.class, "intakeWrist");
    }

    public void Loop(Gamepad gp1) {
        if (gp1.y) {
            intakeWrist.setPosition(ClaireConstants.intakeDown);
            flywheel.setPower(ClaireConstants.intakeRun);
        }
        else if (gp1.x) {
            intakeWrist.setPosition(ClaireConstants.intakeUp);
            flywheel.setPower(ClaireConstants.intakeStop);
        }
    }
}
