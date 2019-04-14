package com.neu.edu;

import com.neu.edu.Population;

import com.neu.edu.Individual;
import com.neu.edu.Maze;
import com.neu.edu.Robot;

public class GeneticAlgorithm {
	private int populationSize;
	private double mutationRate;
	private double crossoverRate;
	private int elitismCount;
	protected int tournamentSize;

		public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount,
				int tournamentSize) {

			this.populationSize = populationSize;
			this.mutationRate = mutationRate;
			this.crossoverRate = crossoverRate;
			this.elitismCount = elitismCount;
			this.tournamentSize = tournamentSize;
			
		}
		public Population initPopulation(int chromosomeLength) {
			Population population = new Population(this.populationSize, chromosomeLength);
			return population;
		}
		
		public double calcFitness(Individual individual, Maze maze) {
			// Get individual's chromosome
			int[] chromosome = individual.getChromosome();

			// Get fitness
			Robot robot = new Robot(chromosome, maze, 100);
			robot.run();
			int fitness = maze.scoreRoute(robot.getRoute());

			// Store fitness
			individual.setFitness(fitness);

			return fitness;
		}
		
		public void evalPopulation(Population population, Maze maze) {
			double populationFitness = 0;

			// Loop over population evaluating individuals and suming population
			// fitness
			for (Individual individual : population.getIndividuals()) {
				populationFitness += this.calcFitness(individual, maze);
			}

			population.setPopulationFitness(populationFitness);
		}

}
