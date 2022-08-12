/*
 * File: Breakout.java
 * -------------------
 * Name: Alan Wong
 * Section Leader: N/A
 * 
 * This file will eventually implement the game of Breakout. 
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 700;
	public static final int APPLICATION_HEIGHT = 700;

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 4;

	/** Width of a brick */
	private static final int BRICK_WIDTH =
		(WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private static final int NTURNS = 3;

	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {
		/* You fill this in, along with any subsidiary methods */
		gameSetup();
		gameRun();
	}
	private void gameSetup() {
		setupBricks();
		setupPaddle();
	}
	private void gameRun(){

	}
	/* setupBricks() is a method that helps set up the game by placing coloured bricks
	 * in the appropriate x and y coordinates. 
	 * Postcondition: to have 2 rows of each colour ROYGB for the appropriate bricks. 
	 */
	private void setupBricks() {

		for (int i = 0; i < NBRICK_ROWS; i++) { // cycling vertically through rows of bricks

			// Calculating the first column of bricks x coordinate

			int x1 = (APPLICATION_WIDTH - (NBRICKS_PER_ROW * BRICK_WIDTH) - (BRICK_SEP * 
					(NBRICKS_PER_ROW-1))) / 2;

			// Calculating the generalised y coordinate for bricks

			int yi = BRICK_Y_OFFSET + i * BRICK_SEP + i * BRICK_HEIGHT;

			for (int j = 0; j < NBRICKS_PER_ROW; j++) { // cycling horizontally through cols 
				// of bricks

				// Calculating x coordinate for bricks along a given row

				int xj = x1 + j * BRICK_SEP + j * BRICK_WIDTH;

				// adding bricks to the row
				GRect brick = new GRect(xj, yi, BRICK_WIDTH, BRICK_HEIGHT);
				// depending on the row number, setting the appropriate brick color.
				switch (i) {
				case 0:
				case 1:
					brick.setFilled(true);
					brick.setFillColor(Color.RED);
					brick.setColor(Color.RED);
					break;
				case 2:
				case 3:
					brick.setFilled(true);
					brick.setFillColor(Color.ORANGE);
					brick.setColor(Color.ORANGE);
					break;
				case 4:
				case 5:
					brick.setFilled(true);
					brick.setFillColor(Color.YELLOW);
					brick.setColor(Color.YELLOW);
					break;
				case 6:
				case 7:
					brick.setFilled(true);
					brick.setFillColor(Color.GREEN);
					brick.setColor(Color.GREEN);
					break;
				case 8:
				case 9:
					brick.setFilled(true);
					brick.setFillColor(Color.CYAN);
					brick.setColor(Color.CYAN);
					break;
				}
				add(brick);

			}
		}
	}
	
	/* setupPaddle() is a method that creates a paddle in the appropriate position 
	 * whilst following the mouse in the y direction without falling off the screen
	 * when the mouse leaves the screen. 
	 */
	private void setupPaddle() {
		// must call this to get mouse events
		addMouseListeners();
		// add paddle
		GRect paddle = new GRect(APPLICATION_WIDTH/2, APPLICATION_HEIGHT-
				PADDLE_Y_OFFSET-PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setFillColor(Color.BLACK);
		add(paddle);
	}
	public void mousePressd(MouseEvent e) {
		
		last = new GPoint(e.getPoint());
	}
	public void mouseDragged(MouseEvent e) {
		paddle.move(e.getX()-last.getX(),e.getY()-last.getY());
		last = new GPoint(e.getPoint());
	}
	private GObject paddle;
	private GPoint last;
	
	
	
	
	
}
