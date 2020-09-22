package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "RKdrive")
public class RKDrive extends LinearOpMode {
    private DcMotor motorFrontRight;
    private DcMotor motorFrontLeft;
    private DcMotor motorBackRight;
    private DcMotor motorBackLeft;
    

    @Override
    public void runOpMode() throws InterruptedException {
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
        motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");

        motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);

        motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();
        waitForStart();

        while (opModeIsActive()) {

            while (gamepad1.left_stick_y > 0.2 || gamepad1.left_stick_y < -0.2) {
                motorFrontRight.setPower(-gamepad1.left_stick_y / 2);
                motorBackRight.setPower(-gamepad1.left_stick_y / 2);
                motorFrontLeft.setPower(-gamepad1.right_stick_y / 2);
                motorBackLeft.setPower(-gamepad1.right_stick_y / 2);
            }

            while (gamepad1.right_stick_x > 0.2) {
                motorFrontRight.setPower(-gamepad1.left_stick_y / 2);
                motorBackRight.setPower(-gamepad1.left_stick_y / 2);
                motorFrontLeft.setPower(gamepad1.right_stick_y / 2);
                motorBackLeft.setPower(gamepad1.right_stick_y / 2);
            }

            while (gamepad1.right_stick_x < -0.2) {
                motorFrontRight.setPower(gamepad1.left_stick_y / 2);
                motorBackRight.setPower(gamepad1.left_stick_y / 2);
                motorFrontLeft.setPower(-gamepad1.right_stick_y / 2);
                motorBackLeft.setPower(-gamepad1.right_stick_y / 2);
            }


            while (gamepad1.y == true) {
                motorFrontRight.setPower(-0.5);
                motorBackRight.setPower(0.5);
                motorFrontLeft.setPower(0.5);
                motorBackLeft.setPower(-0.5);
            }
            while (gamepad1.x == true)
                motorFrontRight.setPower(0.5);
            motorBackRight.setPower(-0.5);
            motorFrontLeft.setPower(-0.5);
            motorBackLeft.setPower(0.5);


        }
        idle();
    }
}


