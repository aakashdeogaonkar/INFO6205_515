package com.neu.edu;
import java.util.Arrays;
import java.util.Comparator;
import com.neu.edu.*;


	public Individual[] getIndividuals() {
		return this.population;
	}
	
	public Individual getFittest(int offset) {
		Arrays.sort(this.population, new Comparator<Individual>() {
			@Override
			public int compare(Individual o1, Individual o2) {
				if (o1.getFitness() > o2.getFitness()) {
					return -1;
				} else if (o1.getFitness() < o2.getFitness()) {
					return 1;
				}
				return 0;
			}
		});
		return this.population[offset];
	}
	
	public void setPopulationFitness(double fitness) {
		this.populationFitness = fitness;
	}
	
	public double getPopulationFitness() {
		return this.populationFitness;
	}
=======
>>>>>>> dec60efa55c3dcac6020a83aa7d7ed94cab07d93
	
	public int size() {
		return this.population.length;
	}
	
	public Individual setIndividual(int offset, Individual individual) {
		return population[offset] = individual;
	}
	
	public Individual getIndividual(int offset) {
		return population[offset];
	}
	
	public void shuffle() {
		Random rnd = new Random();
		for (int i = population.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			Individual a = population[index];
			population[index] = population[i];
			population[i] = a;
		}
	}
	
}
