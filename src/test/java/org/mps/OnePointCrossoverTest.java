/*
 * @Author: Miguel Galdeano Rodríguez
 * @Author: Pablo León Vázquez
 */
package org.mps;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mps.selection.TournamentSelection;
import org.mps.crossover.OnePointCrossover;
import org.mps.mutation.SwapMutation;
import org.mps.EvolutionaryAlgorithm;

public class OnePointCrossoverTest {
 
    private OnePointCrossover opc;
    @BeforeEach
    public void init() {
        opc = new OnePointCrossover();
    }


    @Test
    @DisplayName("Probar la optimización con una población válida pero con poblaciones vacías en medio para probar el select del ts")
    public void crossover_parent1LongerThanParent2_throwException() {
        int[] parent1 = {1,2,4};
        int[] parent2 = {1,2,4,5};
       
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            opc.crossover(parent1, parent2);
        });
    }

    @Test
    @DisplayName("Probar la optimización con una población válida pero con poblaciones vacías en medio para probar el select del ts")
    public void crossover_parent2LongerThanParent1_throwException() {
        int[] parent1 = {1,2,4};
        int[] parent2 = {1,2,};
    
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            opc.crossover(parent1, parent2);
        });
    }

    @Test
    @DisplayName("Probar la optimización con una población válida pero con poblaciones vacías en medio para probar el select del ts")
    public void crossover_parent1Null_throwException() {
        int[] parent1 = null;
        int[] parent2 = {1,2,4,5};
    
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            opc.crossover(parent1, parent2);
        });
    }

    @Test
    @DisplayName("Probar la optimización con una población válida pero con poblaciones vacías en medio para probar el select del ts")
    public void crossover_parent2Null_throwException() {
        int[] parent1 = {1,2,4};
        int[] parent2 = null;
    
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            opc.crossover(parent1, parent2);
        });
    }

    @Test
    @DisplayName("Probar la optimización con una población válida pero con poblaciones vacías en medio para probar el select del ts")
    public void crossover_parent1Empty_throwException() {
        int[] parent1 = {};
        int[] parent2 = {1,2,4};
    
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            opc.crossover(parent1, parent2);
        });
    }

    @Test
    @DisplayName("Probar la optimización con una población válida pero con poblaciones vacías en medio para probar el select del ts")
    public void crossover_parent2Empty_throwException() {
        int[] parent1 = {1,2,3};
        int[] parent2 = {};
    
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            opc.crossover(parent1, parent2);
        });
    }
}
