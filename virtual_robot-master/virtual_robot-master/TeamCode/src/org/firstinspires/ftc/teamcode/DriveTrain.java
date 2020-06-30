package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Disabled
public class DriveTrain<Drivetrain> extends LinearOpMode {
    private DcMotor m1;
    private DcMotor m2;
    private DcMotor m3;
    private DcMotor m4;

    private double gearRatio = 1.046;
    //^ a variable used in both functions and can be changed from robot to robot
    private double TPR = 1120;
    //^ a variable used in both functions Ticks per revolution
    private double WheelWidth = 3.1;
    //^ a variable used in both functions this is the diameter of the wheel
    private double Circumfrence = Math.PI * WheelWidth;
    //^ a variable used in both functions this is the circumfrence of the wheel


    public void runOpMode() {
        motorConfig();
        waitForStart();
    }

    private void motorConfig() {
        // this is a function used to intialize the motors
        DcMotor m1 = hardwareMap.get(DcMotor.class, "back_left_motor");
        DcMotor m2 = hardwareMap.get(DcMotor.class, "front_left_motor");
        DcMotor m3 = hardwareMap.get(DcMotor.class, "front_right_motor");
        DcMotor m4 = hardwareMap.get(DcMotor.class, "back_right_motor");
        m1.setDirection(DcMotor.Direction.FORWARD);
        m2.setDirection(DcMotor.Direction.FORWARD);
        m3.setDirection(DcMotor.Direction.REVERSE);
        m4.setDirection(DcMotor.Direction.REVERSE);
    }

    public void Straight(int inches) {

        DcMotor m1 = hardwareMap.get(DcMotor.class, "back_left_motor");
        telemetry.addData("Debug", 4);
        telemetry.update();
        DcMotor m2 = hardwareMap.get(DcMotor.class, "front_left_motor");
        DcMotor m3 = hardwareMap.get(DcMotor.class, "front_right_motor");
        DcMotor m4 = hardwareMap.get(DcMotor.class, "back_right_motor");
        m1.setDirection(DcMotor.Direction.REVERSE);
        m2.setDirection(DcMotor.Direction.REVERSE);


        double revolutions = (inches / Circumfrence); //revolutions needed to go
        int dist = (int) (revolutions * TPR * gearRatio); //  the ticks needed to go

        //to go that number of ticks as specified in the variable above

        m1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        m1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        m1.setTargetPosition(dist);
        m2.setTargetPosition(dist);
        m3.setTargetPosition(dist);
        m4.setTargetPosition(dist);

    m1.setPower(0.5);
    m2.setPower(0.5);
    m3.setPower(0.5);
    m4.setPower(0.5);

        while (m1.isBusy()) {
            telemetry.update();
            telemetry.addData("Motor 1 is Busy:", m1.isBusy());
        }
    }

    void Turn(int angle) {
        DcMotor m1 = hardwareMap.get(DcMotor.class, "back_left_motor");
        DcMotor m2 = hardwareMap.get(DcMotor.class, "front_left_motor");
        DcMotor m3 = hardwareMap.get(DcMotor.class, "front_right_motor");
        DcMotor m4 = hardwareMap.get(DcMotor.class, "back_right_motor");
        m1.setDirection(DcMotor.Direction.REVERSE);
        m2.setDirection(DcMotor.Direction.REVERSE);

        double revolutions = (angle / Circumfrence); //revolutions needed to go
        int dist = (int) (revolutions * TPR * gearRatio); //the ticks needed to go
        double turn = 5.1; //the number needed to change from a straight to a turn
        int distance = (int) (dist / turn);
        telemetry.addData("Debug", 7);
        m1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        m1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        m1.setTargetPosition(distance);
        m2.setTargetPosition(distance);
        m3.setTargetPosition(-distance);
        m4.setTargetPosition(-distance);

        m1.setPower(0.5);
        m2.setPower(0.5);
        m3.setPower(0.5);
        m4.setPower(0.5);
        telemetry.addData("Debug", 8);

        while (m1.isBusy()) {
            telemetry.update();
        }
    }

    public void Left_Strafe(int inches) {

        DcMotor m1 = hardwareMap.get(DcMotor.class, "back_left_motor");
        DcMotor m2 = hardwareMap.get(DcMotor.class, "front_left_motor");
        DcMotor m3 = hardwareMap.get(DcMotor.class, "front_right_motor");
        DcMotor m4 = hardwareMap.get(DcMotor.class, "back_right_motor");
        m1.setDirection(DcMotor.Direction.REVERSE);
        m2.setDirection(DcMotor.Direction.REVERSE);


        double revolutions = (inches / Circumfrence); //revolutions needed to go
        int dist = (int) (revolutions * TPR * gearRatio); //  the ticks needed to go

        //to go that number of ticks as specified in the variable above

        m1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        m1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        m1.setTargetPosition(dist);
        m2.setTargetPosition(-dist);
        m3.setTargetPosition(dist);
        m4.setTargetPosition(-dist);

        m1.setPower(0.5);
        m2.setPower(0.5);
        m3.setPower(0.5);
        m4.setPower(0.5);

        while (m1.isBusy()) {
            telemetry.update();
            telemetry.addData("Motor 1 is Busy:", m1.isBusy());
        }
    }

    public void Right_Strafe(int inches) {

        DcMotor m1 = hardwareMap.get(DcMotor.class, "back_left_motor");
        DcMotor m2 = hardwareMap.get(DcMotor.class, "front_left_motor");
        DcMotor m3 = hardwareMap.get(DcMotor.class, "front_right_motor");
        DcMotor m4 = hardwareMap.get(DcMotor.class, "back_right_motor");
        m1.setDirection(DcMotor.Direction.REVERSE);
        m2.setDirection(DcMotor.Direction.REVERSE);


        double revolutions = (inches / Circumfrence); //revolutions needed to go
        int dist = (int) (revolutions * TPR * gearRatio); //  the ticks needed to go

        //to go that number of ticks as specified in the variable above

        m1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        m1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        m1.setTargetPosition(-dist);
        m2.setTargetPosition(dist);
        m3.setTargetPosition(-dist);
        m4.setTargetPosition(dist);

        m1.setPower(0.5);
        m2.setPower(0.5);
        m3.setPower(0.5);
        m4.setPower(0.5);

        while (m1.isBusy()) {
            telemetry.update();
            telemetry.addData("Motor 1 is Busy:", m1.isBusy());
        }
    }

   /* public void Grad_Turn(int angle) {
        DcMotor m1 = hardwareMap.get(DcMotor.class, "back_left_motor");
        DcMotor m2 = hardwareMap.get(DcMotor.class, "front_left_motor");
        DcMotor m3 = hardwareMap.get(DcMotor.class, "front_right_motor");
        DcMotor m4 = hardwareMap.get(DcMotor.class, "back_right_motor");
        m1.setDirection(DcMotor.Direction.REVERSE);
        m2.setDirection(DcMotor.Direction.REVERSE);

        double robot_width = 18; //used in order to calculate the distance the outer wheel will go
        double radius = 1.8;

        //the circumference of the circle the inner and outer wheels will make (in inches)
        double inner_C = 2 * Math.PI * radius;
        double outer_C = 2 * Math.PI * radius + robot_width;

        //the distance travelled by the inner and outer wheels (in inches).
        double inner_dist = inner_C * (angle / 360);
        double outer_dist = outer_C * (angle / 360);

        //revolutions needed to go for the inner and outer sides
        double revolutions_I = (inner_dist / Circumfrence);
        double revolutions_O = (outer_dist / Circumfrence);

        //the ticks needed to go for the inner  and outer sides
        int dist_I = (int) (revolutions_I * TPR * gearRatio);
        int dist_O = (int) (revolutions_O * TPR * gearRatio);

        int ratio = 100 / (dist_I + dist_O); // the ratio that is used later to determine the power for each motor

        double power_I = (dist_I * ratio) / 100;
        double power_O = (dist_O * ratio) / 100;

        m1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        m1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        m4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (direction == 'R') { // if the turn is to the right

            m1.setTargetPosition(dist_I);
            m2.setTargetPosition(dist_I);
            m3.setTargetPosition(dist_O);
            m4.setTargetPosition(dist_O);

            m1.setPower(power_I);
            m2.setPower(power_I);
            m3.setPower(power_O);
            m4.setPower(power_O);


            while (m1.isBusy() && m2.isBusy() && m3.isBusy() && m4.isBusy() && opModeIsActive()) telemetry.update();
            m1.setPower(0);
            m2.setPower(0);
            m3.setPower(0);
            m4.setPower(0);

        } else if (direction == 'L') { // if the turn is to the left

            m1.setTargetPosition(dist_O);
            m2.setTargetPosition(dist_O);
            m3.setTargetPosition(dist_I);
            m4.setTargetPosition(dist_I);

            m1.setPower(power_O);
            m2.setPower(power_O);
            m3.setPower(power_I);
            m4.setPower(power_I);


            while (m1.isBusy() && m2.isBusy() && m3.isBusy() && m4.isBusy() && opModeIsActive()) {
                telemetry.update();
            }
            m1.setPower(0);
            m2.setPower(0);
            m3.setPower(0);
            m4.setPower(0);

        } else {
            telemetry.addData("Incorrect directional value: ", direction);
        }
    }*/
}
