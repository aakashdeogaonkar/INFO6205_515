package com.neu.edu;

import com.neu.edu.Maze;

public class RobotController 
{
	public static int maximumGen = 500;
	public static void main(String[] args)
	{
		
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
		
		GeneticAlgorithm ga = new GeneticAlgorithm(200, 0.05, 0.9, 2, 10);
		Population population = ga.initPopulation(128);
		ga.evalPopulation(population, maze);
		int generation = 1;
		while (ga.isTerminationConditionMet(generation, maximumGen) == false) {
			Individual fittest = population.getFittest(0);
			System.out.println(
					"G " + generation + " Best solution (" + fittest.getFitness() + "): " + fittest.toString());

			population = ga.crossoverPopulation(population);

			population = ga.mutatePopulation(population);

			ga.evalPopulation(population, maze);

			generation++;
		}

		System.out.println("Stopped after " + maximumGen + " generations.");
		Individual fittest = population.getFittest(0);
		System.out.println("Best solution (" + fittest.getFitness() + "): " + fittest.toString());
		
	}
}
