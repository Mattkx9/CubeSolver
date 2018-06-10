package com.mattkx4.cubesolver.main;

import com.mattkx4.cubesolver.cube.Cube;
import com.mattkx4.cubesolver.cube.Rotation;

public class CubeSolver {


    /* Start Program */
    public static void main(String[] args) {
        System.out.println("[System] Starting CubeSolver...");

        Cube cube = new Cube();
        System.out.println();
        System.out.println(Rotation.parseScramble(Rotation.scramble));
        cube.rotate(Rotation.scramble);
        cube.print();
    }
}
