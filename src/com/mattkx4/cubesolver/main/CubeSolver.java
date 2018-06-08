package com.mattkx4.cubesolver.main;

import com.mattkx4.cubesolver.cube.Cube;
import com.mattkx4.cubesolver.cube.Rotation;

public class CubeSolver {


    /* Start Program */
    public static void main(String[] args) {
        System.out.println("[System] Starting CubeSolver...");

        Cube cube = new Cube();
        cube.rotate(Rotation.genScramble(20));
        cube.print();
    }
}
