package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring
	// simultaneously with the other 4 robots.

	public static void main(String[] args) {

		Robot r1 = new Robot(300, 400);
		Robot r2 = new Robot(600, 400);
		Robot r3 = new Robot(900, 400);
		Robot r4 = new Robot(450, 550);
		Robot r5 = new Robot(750, 550);

		Thread t1 = new Thread(() -> drawCircle(r1, Color.blue));
		Thread t2 = new Thread(() -> drawCircle(r2, Color.black));
		Thread t3 = new Thread(() -> drawCircle(r3, Color.red));
		Thread t4 = new Thread(() -> drawCircle(r4, Color.yellow));
		Thread t5 = new Thread(() -> drawCircle(r5, Color.green));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}

	static void drawCircle(Robot r, Color c) {

		r.setSpeed(100);
		r.setPenColor(c);
		r.setPenWidth(1);

		for (int i = 0; i < 360; i++) {

			r.penDown();
			r.move(5);
			r.turn(1);
			r.move(300);
			r.turn(100);
		}

	}

}
