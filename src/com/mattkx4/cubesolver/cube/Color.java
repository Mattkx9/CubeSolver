package com.mattkx4.cubesolver.cube;

public enum Color {
    W, G, B, R, O, Y;

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
        }

        return Color.W;
    }
}
