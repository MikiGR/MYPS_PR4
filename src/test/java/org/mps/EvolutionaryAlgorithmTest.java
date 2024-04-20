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

public class EvolutionaryAlgorithmTest {
    
    private EvolutionaryAlgorithm evolutionaryAlgorithm;
    private TournamentSelection ts;
    private SwapMutation sm;
    private OnePointCrossover opc;
    @BeforeEach
    public void init() {
        try {
            ts = new TournamentSelection(3);
            sm = new SwapMutation();
            opc = new OnePointCrossover();
            evolutionaryAlgorithm = new EvolutionaryAlgorithm(ts, sm, opc);
        } catch (EvolutionaryAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    @DisplayName("Al crear el algoritmo de evolucion con el operador de seleccion nulo retorna excepción")
    public void EvolutionaryAlgorithm_SelectionOperatorIsNull_throwException() {
        ts = null;
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            evolutionaryAlgorithm = new EvolutionaryAlgorithm(ts, sm, opc);
        });
    }
    
    @Test
    @DisplayName("Al crear el algoritmo de evolucion con el operador de mutación nulo retorna excepción")
    public void EvolutionaryAlgorithm_SwapMutationIsNull_throwException() {
        sm = null;
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            evolutionaryAlgorithm = new EvolutionaryAlgorithm(ts, sm, opc);
        });
    }

    @Test
    @DisplayName("Al crear el algoritmo de evolucion con el operador de reemplazo nulo retorna excepción")
    public void EvolutionaryAlgorithm_CrossoverOperatorIsNull_throwException() {
        opc = null;
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            evolutionaryAlgorithm = new EvolutionaryAlgorithm(ts, sm, opc);
        });
    }


    @Test
    @DisplayName("Probar la optimización válida de una población")
    public void optimize_WithValidPoblation_returnTrue() throws EvolutionaryAlgorithmException {
        int[][] population = {
                                {1, 2, 3, 4, 5},
                                {6, 7, 8, 9, 10},
                                {11, 12, 13, 14, 15}
                            };
        int originalLength = population.length;
        
        int[][] result = evolutionaryAlgorithm.optimize(population);
        assertEquals(originalLength, result.length);
    }
    
    @Test
    @DisplayName("Probar la optimización con una población nula")
    public void optimize_WithNullPoblation_throwException() {
        int[][] population = null;
        
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            evolutionaryAlgorithm.optimize(population);
        });
    }
    
    @Test
    @DisplayName("Probar la optimización con una población vacía")
    public void optimize_WithAnEmptyPoblation_throwException() {
        int[][] population = {};
        
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            evolutionaryAlgorithm.optimize(population);
        });
    }

    @Test
    @DisplayName("Probar la optimización con una población válida pero con algunos vacíos")
    public void optimize_WithValidPoblationExceptSomeEmpty_throwException() {
        int[][] population = {
            {},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15}
        };
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            evolutionaryAlgorithm.optimize(population);
        });
    }

    @Test
    @DisplayName("Probar la optimización con una población válida pero con algunos nulos")
    public void optimize_WithValidPoblationExceptSomeNull_throwException() {
        int[][] population = {
            null,
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15}
        };
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            evolutionaryAlgorithm.optimize(population);
        });
    }

    @Test
    @DisplayName("Vamos a probar a poner como operador de selección con un valor negativo")
    public void EvolutionaryAlgorithm_TournamentSelectionIsNull_throwException() {
        assertThrows(EvolutionaryAlgorithmException.class, ()-> {
            ts = new TournamentSelection(-1);
            evolutionaryAlgorithm = new EvolutionaryAlgorithm(ts, sm, opc);
        });
    }

    @Test
    @DisplayName("Probar la optimización con una población válida pero con poblaciones nulas en medio para probar el select del ts")
    public void optimize_WithValidPoblationExceptSomeNullForSelectInTS_throwException() {
        int[][] population = {
            {1, 2, 3, 4, 5},
            null, 
            {11, 12, 13, 14, 15}
        };
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            evolutionaryAlgorithm.optimize(population);
        });
    }

    @Test
    @DisplayName("Probar la optimización con una población válida pero con poblaciones vacías en medio para probar el select del ts")
    public void optimize_WithValidPoblationExceptSomeEmptyForSelectInTS_throwException() {
        int[][] population = {
            {1, 2, 3, 4, 5},
            {}, 
            {11, 12, 13, 14, 15}
        };
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            evolutionaryAlgorithm.optimize(population);
        });
    }
}