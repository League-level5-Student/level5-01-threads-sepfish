package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	static void race(Robot r) {
		Random rand = new Random();
		int random = rand.nextInt(10);
		r.turn(random);
		r.move(random + 6);
	}
	
	public static void main(String[] args) {
		Robot aoyama = new Robot("mini");
		aoyama.setSpeed(10000);
		aoyama.sparkle();
		aoyama.setRandomPenColor();
		aoyama.moveTo(40, 500);
		aoyama.penDown();
		for (int a = 0; a < 360; a++) {
			aoyama.move(5);
			aoyama.turn(1);
		}
		aoyama.hide();
		aoyama.unSparkle();
	
		Robot[] r2 = new Robot[5];
		for(int i = 0; i < r2.length; i++) {
			r2[i] = new Robot("mini");
			r2[i].setY(500);
			r2[i].setX(50*i + 50);
			r2[i].setSpeed(1000000);
		}
		
		boolean noCircleWinner = true;
		int timesCrossed = 0;
		
		int circleWinner = 0;
		
		Thread a = new Thread(() -> race(r2[1]));
		Thread b = new Thread(() -> race(r2[0]));
		Thread c = new Thread(() -> race(r2[2]));
		Thread d = new Thread(() -> race(r2[3]));
		Thread e = new Thread(() -> race(r2[4]));
		
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
		
		while (noCircleWinner) {
			System.out.println(timesCrossed);
			for (int i = 0; i < r2.length; i++) {
				if (494 <= r2[i].getY() && r2[i].getY() <= 506 && timesCrossed == 6) {
					noCircleWinner = false;
					circleWinner = i;
				} else if (495 <= r2[i].getY() && r2[i].getY() <= 505) {
					timesCrossed++;
				}
			}
		}
		
		for (int i = 0; i < r2.length; i++) {
			if (i == circleWinner) {
				r2[i].moveTo(450, 300);
			} else {
				r2[i].moveTo(50*i + 60, 500);
			}
		}
			r2[circleWinner].sparkle();
			for (int j = 0; j < 300; j++) {
				r2[circleWinner].turn(j*3);
			}
	}
}
