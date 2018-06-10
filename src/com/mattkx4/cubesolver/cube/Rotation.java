package com.mattkx4.cubesolver.cube;

import java.util.Random;

public enum Rotation {
    U1, U2, U3, D1, D2, D3, R1, R2, R3, L1, L2, L3, F1, F2, F3, B1, B2, B3;

    /* Used to create custom scrambles */
    public static Rotation[] scramble = {U2, L3, F1, U1, B3, D1, R2, L1, F2, U2, R3, U3, B1};

    /* Returns the inverse rotation. (R -> RP)*/
    public static Rotation inverse(Rotation r) {
        switch (r) {
            case U1:
                return U3;
            case U3:
                return U1;
            case D1:
                return D3;
            case D3:
                return D1;
            case R1:
                return R3;
            case R3:
                return R1;
            case L1:
                return L3;
            case L3:
                return L1;
            case F1:
                return F3;
            case F3:
                return F1;
            case B1:
                return B3;
            case B3:
                return B1;
            default:
                System.out.println("[System] ERROR: invalid input in Rotation.java > inverse().");
                return U1;
        }
    }

    /* Assigns integer values to the 18 rotations. */
    public static Rotation getVal(int i) {
        switch (i) {
            case 0:
                return U1;
            case 1:
                return U2;
            case 2:
                return U3;
            case 3:
                return D1;
            case 4:
                return D2;
            case 5:
                return D3;
            case 6:
                return R1;
            case 7:
                return R2;
            case 8:
                return R3;
            case 9:
                return L1;
            case 10:
                return L2;
            case 11:
                return L3;
            case 12:
                return F1;
            case 13:
                return F2;
            case 14:
                return F3;
            case 15:
                return B1;
            case 16:
                return B2;
            case 17:
                return B3;
            default:
                System.out.println("[System] ERROR: invalid input in Rotation.java > getVal(int i).");
                return U1;
        }
    }

    /* Assigns integer values to the 12 rotations. */
    public static int getVal(Rotation r) {
        switch (r) {
            case U1:
                return 0;
            case U2:
                return 1;
            case U3:
                return 2;
            case D1:
                return 3;
            case D2:
                return 4;
            case D3:
                return 5;
            case R1:
                return 6;
            case R2:
                return 7;
            case R3:
                return 8;
            case L1:
                return 9;
            case L2:
                return 10;
            case L3:
                return 11;
            case F1:
                return 12;
            case F2:
                return 13;
            case F3:
                return 14;
            case B1:
                return 15;
            case B2:
                return 16;
            case B3:
                return 17;
            default:
                System.out.println("[System] ERROR: invalid input in Rotation.java > getVal(Rotation r).");
                return 0;
        }
    }

    /* Parses a rotation from U1, U2, U3 form to normal quarter-turn
    notation. eg. U, U2, U'.
     */
    public static String parseRotation(Rotation r) {
        switch (r) {
            case U1:
                return "U";
            case U2:
                return "U2";
            case U3:
                return "U'";
            case D1:
                return "D";
            case D2:
                return "D2";
            case D3:
                return "D'";
            case R1:
                return "R";
            case R2:
                return "R2";
            case R3:
                return "R'";
            case L1:
                return "L";
            case L2:
                return "L2";
            case L3:
                return "L'";
            case F1:
                return "F";
            case F2:
                return "F2";
            case F3:
                return "F'";
            case B1:
                return "B";
            case B2:
                return "B2";
            case B3:
                return "B'";
        }
        return "";
    }

    /* Parses an entire scramble into proper quarter-turn notation. */
    public static String parseScramble(Rotation[] rotations) {
        StringBuilder sb = new StringBuilder();
        for (Rotation r : rotations) {
            sb.append(parseRotation(r));
            sb.append(" ");
        }
        return sb.toString();
    }

    /* Generates a random scramble of the given length. Couple
    * catches:
    * - Can't do the same move more than 2 times in a row.
    * - Can't do an inverse move immediately after doing the normal move.*/
//    public static Rotation[] genScramble(int numOfMoves) {
//        Rotation[] scramble = new Rotation[numOfMoves];
//
//        for (int i = 0; i < scramble.length; i++) {
//            Rotation move = U;
//
//            /* Check to make sure the moves are legal according to the conditions stated above. */
//            boolean isIllegal = true;
//            while(isIllegal) {
//
//                /* Generate a random integer from 0 to 11. */
//                Random rand = new Random();
//                int randomNum = rand.nextInt(12);
//                // Gets the corresponding move according to the 0 to 11 integer.
//                move = getVal(randomNum);
//
//                // Check to see if this is at least the 3rd move in the sequence.
//                if (i > 1) {
//                    // If it is, check to see if the move is the inverse of the previous move
//                    if (scramble[i - 1] == Rotation.inverse(move)) { continue; }
//
//                    // Finally, check to see if this is the third identical consecutive move.
//                    if (scramble[i - 2] == move && scramble[i - 1] == move) { continue; }
//                }
//
//                // Since it passed all the clauses, it's not illegal!
//                isIllegal = false;
//            }
//
//            System.out.print(move + " ");
//
//            // Add the move to the scramble
//            scramble[i] = move;
//        }
//
//        return scramble;
//    }
}
