package com.mattkx4.cubesolver.cube;

public class Cube {
    public Color[][] map;

    public Cube() {
        map = new Color[6][9];
        resetCube();
    }

    /* Sets the cube to a fully solved state. */
    public void resetCube() {
        for (int i = 0; i < 6; i++) {
            Color c = Color.getVal(i);
            for (int j = 0; j < 9; j++) {
                map[i][j] = c;
            }
        }
    }

    /* Prints the cube map (2d model) to the console */
    public void printCube() {
        System.out.println(); // Buffer
        // Print Blue Face
        System.out.println("       " + map[2][1] + " " + map[2][2] + " " + map[2][3]);
        System.out.println("       " + map[2][4] + " " + map[2][0] + " " + map[2][5]);
        System.out.println("       " + map[2][6] + " " + map[2][7] + " " + map[2][8]);
        System.out.println(); // Buffer
        // Print Red, White, Orange, and Yellow Face
        System.out.println(map[3][1] + " " + map[3][2] + " " + map[3][3] + "  " +
                map[0][1] + " " + map[0][2] + " " + map[0][3] + "  " +
                map[4][1] + " " + map[4][2] + " " + map[4][3] + "  " +
                map[5][1] + " " + map[5][2] + " " + map[5][3]);
        System.out.println(map[3][4] + " " + map[3][0] + " " + map[3][5] + "  " +
                map[0][4] + " " + map[0][0] + " " + map[0][5] + "  " +
                map[4][4] + " " + map[4][0] + " " + map[4][5] + "  " +
                map[5][4] + " " + map[5][0] + " " + map[5][5]);
        System.out.println(map[3][6] + " " + map[3][7] + " " + map[3][8] + "  " +
                map[0][6] + " " + map[0][7] + " " + map[0][8] + "  " +
                map[4][6] + " " + map[4][7] + " " + map[4][8] + "  " +
                map[5][6] + " " + map[5][7] + " " + map[5][8]);
        System.out.println(); // Buffer
        // Print Green Face
        System.out.println("       " + map[1][1] + " " + map[1][2] + " " + map[1][3]);
        System.out.println("       " + map[1][4] + " " + map[1][0] + " " + map[1][5]);
        System.out.println("       " + map[1][6] + " " + map[1][7] + " " + map[1][8]);
        System.out.println(); // Buffer
    }
}
