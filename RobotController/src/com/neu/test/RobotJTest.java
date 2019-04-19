package src.com.neu.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import src.com.neu.edu.GeneticAlgorithm;
import src.com.neu.edu.Individual;
import src.com.neu.edu.Maze;
import src.com.neu.edu.Population;
import src.com.neu.edu.Robot;



public class RobotJTest {
	
	
	@Test
	public void Robot() {
		GeneticAlgorithm ga = new GeneticAlgorithm(200, 0.01, 0.9, 2, 10);
		Maze maze = new Maze(new int[][] { { 0, 0, 0, 0, 1, 0, 1, 3, 4 }, 
			{ 1, 0, 1, 1, 1, 0, 1, 3, 1 },
				{ 1, 0, 0, 1, 3, 3, 3, 3, 1 },
				{ 3, 3, 3, 1, 3, 1, 1, 0, 1 }, 
				{ 3, 1, 3, 3, 3, 1, 1, 0, 0 },
				{ 3, 3, 1, 1, 1, 1, 0, 1, 1 }, 
				{ 1, 3, 0, 1, 3, 3, 3, 3, 3 }, 
				{ 0, 3, 1, 1, 3, 1, 0, 1, 3 },
				{ 1, 3, 3, 3, 3, 1, 1, 1, 2 } 
				});
		Population population = ga.initPopulation(128);
		int generation = 1;
		while (ga.isTerminationConditionMet(generation, 500) == false) {
			population = ga.crossoverPopulation(population);
			population = ga.mutatePopulation(population);
			ga.evalPopulation(population, maze);
			generation++;
		}
		
		Maze newmaze1 = new Maze(new int[][] {   { 1, 0, 1, 0, 2 }, 
												 { 1, 1, 1, 1, 3 },
												 { 1, 1, 3, 3, 3 }, 
												 { 4, 3, 3, 1, 1 }, 
												 { 1, 1, 1, 1, 1 } });
		
		int[] chromosome =  population.getFittest(0).getChromosome();
		Robot robot = new Robot(chromosome, newmaze1, 100);
		robot.run();
		System.out.println(robot.printRoute());
		System.out.println("x is "+ robot.getxPosition());
		System.out.println("y is "+ robot.getyPosition());
		assertNotEquals(1,newmaze1.getPositionValue(robot.getxPosition(), robot.getyPosition()));
	}
	
	
	
	@Test
	public void PopulationFitnessTest() {
		GeneticAlgorithm test = new GeneticAlgorithm(200, 0.01, 0.9, 2, 10);
		Individual individual = new Individual(128);
		Maze maze = new Maze(new int[][] { { 0, 0, 0, 0, 1, 0, 1, 3, 4 }, { 1, 0, 1, 1, 1, 0, 1, 3, 1 },
				{ 1, 0, 0, 1, 3, 3, 3, 3, 1 }, { 3, 3, 3, 1, 3, 1, 1, 0, 1 }, { 3, 1, 3, 3, 3, 1, 1, 0, 0 },
				{ 3, 3, 1, 1, 1, 1, 0, 1, 1 }, { 1, 3, 0, 1, 3, 3, 3, 3, 3 }, { 0, 3, 1, 1, 3, 1, 0, 1, 3 },
				{ 1, 3, 3, 3, 3, 1, 1, 1, 2 } });
		double fitness = test.calcFitness(individual, maze);

		assertNotEquals(-1, fitness);

	}
	
	@Test
	public void setGeneTest()
	{
		int arr[] = new int[128];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=1;
		}
		Individual indi = new Individual(128);
		int chromozomeArray[] = indi.getChromosome();
		for(int gene=0;gene<chromozomeArray.length;gene++)
		indi.setGene(gene, 1);
		
		Assert.assertArrayEquals(chromozomeArray,arr);
	}
	
	@Test
	public void MutationFunctionTest() {
		GeneticAlgorithm ga = new GeneticAlgorithm(200, 0.01, 0.9, 2, 10);
		Population population = ga.initPopulation(128);
		Population mutatedpopulation = ga.mutatePopulation(population);
		assertNotEquals(population, mutatedpopulation);
	}
	
	@Test
	public void populationsFitness() {
		GeneticAlgorithm ga = new GeneticAlgorithm(200, 0.01, 0.9, 2, 10);
		Maze maze = new Maze(new int[][] { 
				{ 0, 0, 0, 0, 1, 0, 1, 3, 1 }, 
				{ 1, 0, 1, 1, 1, 0, 1, 3, 1 },
				{ 1, 0, 0, 1, 3, 3, 3, 3, 1 }, 
				{ 3, 3, 3, 1, 4, 1, 1, 0, 1 }, 
				{ 3, 1, 3, 3, 3, 1, 1, 0, 0 },
				{ 3, 3, 1, 1, 1, 1, 0, 1, 1 }, 
				{ 1, 3, 0, 1, 3, 3, 3, 3, 3 }, 
				{ 0, 3, 1, 1, 3, 1, 0, 1, 3 },
				{ 1, 3, 3, 3, 3, 1, 1, 1, 2 } });
		Population population = ga.initPopulation(128);
		int generation = 1;
		while (ga.isTerminationConditionMet(generation, 500) == false) {
			population = ga.crossoverPopulation(population);
			population = ga.mutatePopulation(population);
			ga.evalPopulation(population, maze);
			generation++;
		}
		assertEquals(22, population.getFittest(0).getFitness());

	}

	@Test
	public void CrossOverFunctionTest() {
		GeneticAlgorithm ga = new GeneticAlgorithm(200, 0.01, 0.9, 2, 10);
		Population population = ga.initPopulation(128);
		Population crossoverpopulation = ga.crossoverPopulation(population);
		assertNotEquals(population, crossoverpopulation);
	}
	
	
	@Test
	public void scoreRouteTest() {
		Maze newmaze1 = new Maze(new int[][] {   { 1, 0, 1, 0, 2 }, 
												 { 1, 1, 1, 1, 3 },
												 { 1, 1, 3, 3, 3 }, 
												 { 3, 3, 3, 1, 1 }, 
												 { 3, 3, 3, 3, 4 } });
		 ArrayList<int[]> route = new ArrayList<int[]>();
		 int[] a = {4,0};  
		 route.add(a);
		 int[] a1 = {4,1}; 
		 route.add(a1);
		 int[] a2 = {4,2}; 
		 route.add(a2);
		 int[] a3 = {3,2};
		 route.add(a3);
		 int[] a4 = {2,2};
		 route.add(a4);
		 int[] a5 = {2,3};
		 route.add(a5);
		 int[] a6 = {1,3};
		 route.add(a6);
		 int[] a7 = {0,3};
		 route.add(a7);
		 int[] a8 = {0,4};
		 route.add(a8);
		 int[] a9 = {1,4};
		 route.add(a9);
		 int[] a10  = {2,4};
		 route.add(a10);
		 int[] a11 = {3,4};
		 route.add(a11);
		 int[] a12= {4,4};
		 route.add(a12);
		 int fitness = newmaze1.scoreRoute(route);
		assertEquals(11, fitness);

	}
}
