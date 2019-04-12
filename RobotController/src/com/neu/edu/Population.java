package com.neu.edu;

import com.neu.edu.*;

public class Population {
	
	private Individual population[];
	private double populationFitness = -1;

	public Population(int populationSize) {
		// Initial population
		this.population = new Individual[populationSize];
	}
	
	public Population(int populationSize, int chromosomeLength) {
		// Initialize the population as an array of individuals
		this.population = new Individual[populationSize];

		// Create each individual in turn
		for (int individualCount = 0; individualCount < populationSize; individualCount++) {
			// Create an individual, initializing its chromosome to the given
			// length
			Individual individual = new Individual(chromosomeLength);
			// Add individual to population
			this.population[individualCount] = individual;
		}
		
	}
	
	public Individual[] getPopulation() {
		return population;
	}

	
	
}
