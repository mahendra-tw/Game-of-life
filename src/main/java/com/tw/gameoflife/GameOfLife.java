package com.tw.gameoflife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameOfLife {
    private int[][] life;
    private final int sizeOfLife;

    public GameOfLife(int sizeOfLife) {
        this.sizeOfLife = sizeOfLife;
        this.life = new int[sizeOfLife][sizeOfLife];
        for (int[] row : life
        ) {
            for (int cell : row
            ) {
                cell = 0;
            }
        }
    }


    public void addAliveCell(int rowNumber, int columnNumber) {
        life[rowNumber][columnNumber] = 1;
    }

    public int[][] copyArray(int[][] original) {
        if (original == null) {
            return null;
        }

        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

    public void generateNextGeneration() {
        int[][] temporaryLife = copyArray(life);
        int aliveCellCount = 0;
        for (int rowNumber = 0; rowNumber < sizeOfLife; rowNumber++) {
            for (int columnNumber = 0; columnNumber < sizeOfLife; columnNumber++) {
                if (rowNumber == columnNumber && rowNumber == 0) {
                    if (life[0][1] == 1)
                        aliveCellCount += 1;
                    if (life[1][0] == 1)
                        aliveCellCount += 1;
                    if (life[1][1] == 1)
                        aliveCellCount += 1;
                } else if (rowNumber == 0 && columnNumber == sizeOfLife - 1) {
                    if (life[0][columnNumber - 1] == 1)
                        aliveCellCount += 1;
                    if (life[1][columnNumber - 1] == 1)
                        aliveCellCount += 1;
                    if (life[1][columnNumber] == 1)
                        aliveCellCount += 1;
                } else if (rowNumber == sizeOfLife - 1 && columnNumber == 0) {
                    if (life[rowNumber - 1][0] == 1)
                        aliveCellCount += 1;
                    if (life[rowNumber - 1][1] == 1)
                        aliveCellCount += 1;
                    if (life[rowNumber][1] == 1)
                        aliveCellCount += 1;
                } else if (rowNumber == sizeOfLife - 1 && rowNumber == columnNumber) {
                    if (life[sizeOfLife - 2][sizeOfLife - 1] == 1)
                        aliveCellCount += 1;
                    if (life[sizeOfLife - 2][sizeOfLife - 2] == 1)
                        aliveCellCount += 1;
                    if (life[sizeOfLife - 1][sizeOfLife - 2] == 1)
                        aliveCellCount += 1;
                } else if (rowNumber == 0) {
                    for (int subRow = rowNumber; subRow <= rowNumber + 1; subRow++) {
                        for (int subColumn = columnNumber - 1; subColumn <= columnNumber + 1; subColumn++) {
                            if (!(subRow == rowNumber && subColumn == columnNumber)) {
                                if (life[subRow][subColumn] == 1)
                                    aliveCellCount += 1;
                            }
                        }
                    }
                } else if (columnNumber == 0) {
                    for (int subRow = rowNumber - 1; subRow <= rowNumber + 1; subRow++) {
                        for (int subColumn = columnNumber; subColumn <= columnNumber + 1; subColumn++) {
                            if (!(subRow == rowNumber && subColumn == columnNumber)) {
                                if (life[subRow][subColumn] == 1)
                                    aliveCellCount += 1;
                            }
                        }
                    }
                } else if (rowNumber == sizeOfLife - 1) {
                    for (int subRow = rowNumber - 1; subRow <= rowNumber; subRow++) {
                        for (int subColumn = columnNumber - 1; subColumn <= columnNumber + 1; subColumn++) {
                            if (!(subRow == rowNumber && subColumn == columnNumber)) {
                                if (life[subRow][subColumn] == 1)
                                    aliveCellCount += 1;
                            }
                        }
                    }

                } else if (columnNumber == sizeOfLife - 1) {
                    for (int subRow = rowNumber - 1; subRow <= rowNumber + 1; subRow++) {
                        for (int subColumn = columnNumber - 1; subColumn <= columnNumber; subColumn++) {
                            if (!(subRow == rowNumber && subColumn == columnNumber)) {
                                if (life[subRow][subColumn] == 1)
                                    aliveCellCount += 1;
                            }
                        }
                    }

                } else {
                    for (int subRow = rowNumber - 1; subRow <= rowNumber + 1; subRow++) {
                        for (int subColumn = columnNumber - 1; subColumn <= columnNumber + 1; subColumn++) {
                            if (!(subRow == rowNumber && subColumn == columnNumber)) {
                                if (life[subRow][subColumn] == 1)
                                    aliveCellCount += 1;
                            }
                        }
                    }
                }
                if (aliveCellCount < 2 && life[rowNumber][columnNumber] == 1)
                    temporaryLife[rowNumber][columnNumber] = 0;
                else if (aliveCellCount == 3 && life[rowNumber][columnNumber] == 0)
                    temporaryLife[rowNumber][columnNumber] = 1;
                else if (aliveCellCount > 3 && life[rowNumber][columnNumber] == 1)
                    temporaryLife[rowNumber][columnNumber] = 0;
                aliveCellCount = 0;
            }
        }
        life = copyArray(temporaryLife);
    }

    public Set<Pair> getAliveCellCoordinates() {
        Set<Pair> aliveCellCoordinates = new HashSet<>();
        for (int rowNumber = 0; rowNumber < this.sizeOfLife; rowNumber++) {
            for (int columnNumber = 0; columnNumber < this.sizeOfLife; columnNumber++) {
                if (life[rowNumber][columnNumber] == 1) {
                    aliveCellCoordinates.add(new Pair(rowNumber, columnNumber));
                }
            }
        }
        return aliveCellCoordinates;
    }

    public void printLife() {
        for (int[] row : life
        ) {
            for (int cell : row
            ) {
                System.out.print(cell + " ");
            }
            System.out.print("\n");
        }
    }
}
