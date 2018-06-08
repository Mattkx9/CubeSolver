package com.mattkx4.cubesolver.cube;

import java.util.Random;

public enum Rotation {
    U, UP, D, DP, R, RP, L, LP, F, FP, B, BP;

    /* Used to create custom scrambles */
    public static Rotation[] scramble = {U, R, FP, B, L, DP, L, BP, U, U, D, RP, LP, F, R, UP, RP};

    /* Returns the inverse rotation. (R -> RP)*/
    public static Rotation inverse(Rotation r) {
        switch (r) {
            case U:
                return UP;
            case UP:
                return U;
            case D:
                return DP;
            case DP:
                return D;
            case R:
                return RP;
            case RP:
                return R;
            case L:
                return LP;
            case LP:
                return L;
            case F:
                return FP;
            case FP:
                return F;
            case B:
                return BP;
            case BP:
                return B;
            default:
                System.out.println("[System] ERROR: invalid input in Rotation.java > inverse().");
                return U;
        }
    }

    /* Assigns integer values to the 12 rotations. */
    public static Rotation getVal(int i) {
        switch (i) {
            case 0:
                return U;
            case 1:
                return UP;
            case 2:
                return D;
            case 3:
                return DP;
            case 4:
                return R;
            case 5:
                return RP;
            case 6:
                return L;
            case 7:
                return LP;
            case 8:
                return F;
            case 9:
                return FP;
            case 10:
                return B;
            case 11:
                return BP;
            default:
                System.out.println("[System] ERROR: invalid input in Rotation.java > getVal(int i).");
                return U;
        }
    }

    /* Assigns integer values to the 12 rotations. */
    public static int getVal(Rotation r) {
        switch (r) {
            case U:
                return 0;
            case UP:
                return 1;
            case D:
                return 2;
            case DP:
                return 3;
            case R:
                return 4;
            case RP:
                return 5;
            case L:
                return 6;
            case LP:
                return 7;
            case F:
                return 8;
            case FP:
                return 9;
            case B:
                return 10;
            case BP:
                return 11;
            default:
                System.out.println("[System] ERROR: invalid input in Rotation.java > getVal(Rotation r).");
                return 0;
        }
    }

    /* Generates a random scramble of the given length. Couple
    * catches:
    * - Can't do the same move more than 2 times in a row.
    * - Can't do an inverse move immediately after doing the normal move.*/
    public static Rotation[] genScramble(int numOfMoves) {
        Rotation[] scramble = new Rotation[numOfMoves];

        for (int i = 0; i < scramble.length; i++) {
            Rotation move = U;

            /* Check to make sure the moves are legal according to the conditions stated above. */
            boolean isIllegal = true;
            while(isIllegal) {

                /* Generate a random integer from 0 to 11. */
                Random rand = new Random();
                int randomNum = rand.nextInt(12);
                // Gets the corresponding move according to the 0 to 11 integer.
                move = getVal(randomNum);

                // Check to see if this is at least the 3rd move in the sequence.
                if (i > 1) {
                    // If it is, check to see if the move is the inverse of the previous move
                    if (scramble[i - 1] == Rotation.inverse(move)) { isIllegal = true; continue; }

                    // Finally, check to see if this is the third identical consecutive move.
                    if (scramble[i - 2] == move && scramble[i - 1] == move) { isIllegal = true; continue; }
                }

                // Since it passed all the clauses, it's not illegal!
                isIllegal = false;
            }

            // Add the move to the scramble
            scramble[i] = move;
        }

        return scramble;
    }
}
