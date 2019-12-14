package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot piko = new Robot("mini");
		
		piko.moveTo(200, 400);
		piko.setSpeed(100);
		piko.penDown();
		piko.setPenWidth(10);
		
		//blue
		piko.setPenColor(new Color(0, 133, 199));
		
		for (int i = 0; i < 360; i++) {
			piko.move(2);
			piko.turn(1);
		}
		
		piko.penUp();
		piko.moveTo(325, 525);
		piko.penDown();
		
		//yellow
		piko.setPenColor(new Color(244, 195, 0));
		
		for (int i = 0; i < 360; i++) {
			piko.move(2);
			piko.turn(1);
		}
		
		piko.penUp();
		piko.moveTo(450, 400);
		piko.penDown();
		
		//black
		piko.setPenColor(new Color(0, 0, 0));
		
		for (int i = 0; i < 360; i++) {
			piko.move(2);
			piko.turn(1);
		}
		
		piko.penUp();
		piko.moveTo(575, 525);
		piko.penDown();
		
		//green
		piko.setPenColor(new Color(0, 159, 61));
		
		for (int i = 0; i < 360; i++) {
			piko.move(2);
			piko.turn(1);
		}
		
		piko.penUp();
		piko.moveTo(700, 400);
		piko.penDown();
		
		//red
		piko.setPenColor(new Color(223, 0, 37));
		
		for (int i = 0; i < 360; i++) {
			piko.move(2);
			piko.turn(1);
		}
	}
}

