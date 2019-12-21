package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot piko = new Robot("mini");
		Robot nana = new Robot("mini");
		Robot seeU = new Robot("mini");
		Robot miki = new Robot("mini");
		Robot lily = new Robot("mini");
		
		Thread a = new Thread(() -> circle(piko, 200, 400, 0, 133, 199));
		Thread b = new Thread(() -> circle(nana, 325, 525, 244, 195, 0));
		Thread c = new Thread(() -> circle(seeU, 450, 400, 0, 0, 0));
		Thread d = new Thread(() -> circle(miki, 575, 525, 0, 159, 61));
		Thread e = new Thread(() -> circle(lily, 700, 400, 223, 0, 37));
		
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}
	
	static void circle(Robot robot, int x, int y, int r, int g, int b) {
		robot.moveTo(x, y);
		robot.setSpeed(100);
		robot.penDown();
		robot.setPenWidth(10);
		robot.setPenColor(new Color(r, g, b));
		for (int i = 0; i < 360; i++) {
			robot.move(2);
			robot.turn(1);
		}
	}
}

