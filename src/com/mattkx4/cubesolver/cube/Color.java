package com.mattkx4.cubesolver.cube;

public enum Color {
    W, G, B, R, O, Y;

    /* Assigns integer values to the 6 colors. */
    public static Color getVal(int i) {
        switch (i) {
            case 0:
                return Color.W;
            case 1:
                return Color.G;
            case 2:
                return Color.B;
            case 3:
                return Color.R;
            case 4:
                return Color.O;
            case 5:
                return Color.Y;
            default:
                System.out.println("[System] ERROR: invalid input in Color.java > getVal(int i).");
                return Color.W;
        }
    }

    /* Assigns integer values to the 6 colors. */
    public static int getVal(Color c) {
        switch (c) {
            case W:
                return 0;
            case G:
                return 1;
            case B:
                return 2;
            case R:
                return 3;
            case O:
                return 4;
            case Y:
                return 5;
            default:
                System.out.println("[System] ERROR: invalid input in Color.java > getVal(Color c).");
                return 0;
        }
    }
}
