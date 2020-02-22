package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.

//	static Robot[] array = new Robot[5];

	static boolean raceOver = false;

	public static void main(String[] args) {

//		for (int i = 0; i < 5; i++) {
//			array[i] = new Robot(300 + 300 * i, 800);
//		}

		Random rand = new Random();

		Thread[] threads = new Thread[5];

		for (int i = 0; i < 5; i++) {
			final int x = i;

			threads[i] = new Thread(() -> {
				Robot robot = new Robot(300 + 200 * x, 800);

				while (!raceOver) {
					if (robot.getY() < 100) {
						System.out.println("Robot " + (x + 1) + " won the race!");
						raceOver = true;
						break;
					}
					robot.move(rand.nextInt(2));

				}
			});
		}

		for (int i = 0; i < 5; i++) {
			threads[i].start();
		}

//		while (1 > 0) {
//
//			for (int i = 0; i < 5; i++) {
//				if (threads[i].robot.getY() < 100) {
//					break;
//				}
//			}
//		}
	}
}
