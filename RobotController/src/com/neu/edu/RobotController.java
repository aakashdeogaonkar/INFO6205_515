
package com.neu.edu;

import com.neu.edu.Maze;

public class RobotController 
{
	public static int maximumGen = 500;
	public static void main(String[] args)
	{
		
		System.out.print("fsdfd");
		
		Maze maze = new Maze(new int[][] { 
			{ 0, 0, 0, 0, 1, 0, 1, 3, 2 }, 
			{ 1, 0, 1, 1, 1, 0, 1, 3, 1 },
			{ 1, 0, 0, 1, 3, 3, 3, 3, 1 }, 
			{ 3, 3, 3, 1, 3, 1, 1, 0, 1 }, 
			{ 3, 1, 3, 3, 3, 1, 1, 0, 0 },
			{ 3, 3, 1, 1, 1, 1, 0, 1, 1 }, 
			{ 1, 3, 0, 1, 3, 3, 3, 3, 3 }, 
			{ 0, 3, 1, 1, 3, 1, 0, 1, 3 },
			{ 1, 3, 3, 3, 3, 1, 1, 1, 4 } 
		});
		
		System.out.println("after maaze");
	}
}
