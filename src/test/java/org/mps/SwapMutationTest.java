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

public class SwapMutationTest {
 
    private SwapMutation sm;
    @BeforeEach
    public void init() {
        sm = new SwapMutation();
    }


    @Test
    @DisplayName("Probar la mutación con un individuo nulo. ")
    public void mutation_individualNull_throwException() {
        int[] individual = null;
       
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            sm.mutate(individual);
        });
    }

    @Test
    @DisplayName("Probar la mutación con un individuo vacío. ")
    public void mutation_individualEmpty_throwException() {
        int[] individual = {};
       
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            sm.mutate(individual);
        });
    }   

    @Test
    @DisplayName("Probar la mutacion con un individuo válido.")
    public void mutation_individualBiggerThanZero_returnTrue() throws EvolutionaryAlgorithmException{
        int[] individual = {1,2,3};
        int[] mutated = sm.mutate(individual);
        assertEquals(individual.length,mutated.length);
    } 
}
