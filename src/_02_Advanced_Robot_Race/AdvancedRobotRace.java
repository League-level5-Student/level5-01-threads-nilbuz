package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	 // Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.

	static Robot[] array = new Robot[5];
	
	public static void main(String[] args) {

		

		for (int i = 0; i < 5; i++) {
			array[i] = new Robot(300 + 300 * i, 800);
		}

		Random rand = new Random();
		int randInt = rand.nextInt(50);

		//Thread r1 = new Thread(() ->  { array[0] = new Robot(300,800); array[0].move(rand.nextInt(50)) } );
		Thread r2 = new Thread(() -> array[1].move(rand.nextInt(50)));
		Thread r3 = new Thread(() -> array[2].move(rand.nextInt(50)));
		Thread r4 = new Thread(() -> array[3].move(rand.nextInt(50)));
		Thread r5 = new Thread(() -> array[4].move(rand.nextInt(50)));

		while (1 > 0) {
			r1.start();
			r2.start();
			r3.start();
			r4.start();
			r5.start();
			
//			for (int i = 0; i < 5; i++) {
//				if (array[i].getY() < 100) {
//					break;
//				}
//			}
		}
	}
}
