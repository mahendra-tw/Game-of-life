package com.tw.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeTest {
    @Test
    void shouldNotChangeTheInitialStateWhenHavingABoatPatternInStillLife() {
        GameOfLife gameOfLife = new GameOfLife(3);

        gameOfLife.addAliveCell(1, 1);
        gameOfLife.addAliveCell(1, 2);
        gameOfLife.addAliveCell(2, 1);
        gameOfLife.addAliveCell(2, 2);
        gameOfLife.printLife();
        System.out.println("");
        gameOfLife.generateNextGeneration();
        gameOfLife.printLife();

        Set<Pair> aliveCellCoordinates = gameOfLife.getAliveCellCoordinates();
        aliveCellCoordinates.forEach(Pair::printPairElements);
        boolean result1 = aliveCellCoordinates.contains(new Pair(1, 1));
        boolean result2 = aliveCellCoordinates.contains(new Pair(1, 2));
        boolean result3 = aliveCellCoordinates.contains(new Pair(2, 1));
        boolean result4 = aliveCellCoordinates.contains(new Pair(2, 2));
        assertThat(true, is(result1));
        assertThat(true, is(result2));
        assertThat(true, is(result3));
        assertThat(true, is(result4));
    }

    @Test
    void shouldNotChangeTheInitialStateWhenHavingABlockPatternInStillLife() {
        GameOfLife gameOfLife = new GameOfLife(3);

        gameOfLife.addAliveCell(0, 1);
        gameOfLife.addAliveCell(1, 0);
        gameOfLife.addAliveCell(2, 1);
        gameOfLife.addAliveCell(0, 2);
        gameOfLife.addAliveCell(1, 2);
        gameOfLife.printLife();
        System.out.println("");
        gameOfLife.generateNextGeneration();
        gameOfLife.printLife();

        Set<Pair> aliveCellCoordinates = gameOfLife.getAliveCellCoordinates();
        aliveCellCoordinates.forEach(Pair::printPairElements);
        boolean result1 = aliveCellCoordinates.contains(new Pair(0, 1));
        boolean result2 = aliveCellCoordinates.contains(new Pair(1, 0));
        boolean result3 = aliveCellCoordinates.contains(new Pair(2, 1));
        boolean result4 = aliveCellCoordinates.contains(new Pair(0, 2));
        boolean result5 = aliveCellCoordinates.contains(new Pair(1, 2));
        assertThat(true, is(result1));
        assertThat(true, is(result2));
        assertThat(true, is(result3));
        assertThat(true, is(result4));
        assertThat(true, is(result5));
    }

    @Test
    void shouldChangeTheInitialStateWhenHavingATwoPhaseOscillatorPattern() {
        GameOfLife gameOfLife = new GameOfLife(5);

        gameOfLife.addAliveCell(1, 1);
        gameOfLife.addAliveCell(1, 2);
        gameOfLife.addAliveCell(1, 3);
        gameOfLife.addAliveCell(2, 2);
        gameOfLife.addAliveCell(2, 3);
        gameOfLife.addAliveCell(2, 4);
        gameOfLife.printLife();
        System.out.println("");
        gameOfLife.generateNextGeneration();
        gameOfLife.printLife();

        Set<Pair> aliveCellCoordinates = gameOfLife.getAliveCellCoordinates();
        aliveCellCoordinates.forEach(Pair::printPairElements);
        boolean result1 = aliveCellCoordinates.contains(new Pair(0, 2));
        boolean result2 = aliveCellCoordinates.contains(new Pair(1, 1));
        boolean result3 = aliveCellCoordinates.contains(new Pair(1, 4));
        boolean result4 = aliveCellCoordinates.contains(new Pair(2, 1));
        boolean result5 = aliveCellCoordinates.contains(new Pair(2, 4));
        boolean result6 = aliveCellCoordinates.contains(new Pair(3, 3));
        assertThat(true, is(result1));
        assertThat(true, is(result2));
        assertThat(true, is(result3));
        assertThat(true, is(result4));
        assertThat(true, is(result5));
        assertThat(true, is(result6));
    }
}
