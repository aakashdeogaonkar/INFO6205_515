package src.com.neu.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import src.com.neu.edu.GeneticAlgorithm;
import src.com.neu.edu.Individual;
import src.com.neu.edu.Maze;



public class RobotJTest {
	
	
	@Test
	public void Fitnesstest() {
		GeneticAlgorithm test = new GeneticAlgorithm(200, 0.01, 0.9, 2, 10);
		Individual individual = new Individual(128);
		Maze maze = new Maze(new int[][] { { 0, 0, 0, 0, 1, 0, 1, 3, 4 }, { 1, 0, 1, 1, 1, 0, 1, 3, 1 },
				{ 1, 0, 0, 1, 3, 3, 3, 3, 1 }, { 3, 3, 3, 1, 3, 1, 1, 0, 1 }, { 3, 1, 3, 3, 3, 1, 1, 0, 0 },
				{ 3, 3, 1, 1, 1, 1, 0, 1, 1 }, { 1, 3, 0, 1, 3, 3, 3, 3, 3 }, { 0, 3, 1, 1, 3, 1, 0, 1, 3 },
				{ 1, 3, 3, 3, 3, 1, 1, 1, 2 } });
//		System.out.println(individual.getFitness());
		double fitness = test.calcFitness(individual, maze);

		assertNotEquals(-1, fitness);

	}

}
