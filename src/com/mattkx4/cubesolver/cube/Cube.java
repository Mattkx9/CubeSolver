package com.mattkx4.cubesolver.cube;

public class Cube {
    public Color[][] map;

    public Cube() {
        map = new Color[6][9];
        reset();
    }

    public Cube(Color[][] map) {
        this.map = map;
    }

    /* Sets the cube to a fully solved state. */
    public void reset() {
        for (int i = 0; i < 6; i++) {
            Color c = Color.getVal(i);
            for (int j = 0; j < 9; j++) {
                map[i][j] = c;
            }
        }
    }

    /* Prints the cube map (2d model) to the console */
    public void print() {
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

    /* Rotates the virtual cube given a Rotation
    * SEE THE GOOGLE SHEET FOR INFO ON HOW THE MAPS WORK:
    * https://goo.gl/pJAHqU */
    public void rotate(Rotation r) {

        /* Create a proxy cube that's identical to the
        * pre-rotated cube BUT IT'S NOT LINKED!! Totally
        * different object! */
        Cube proxyCube = new Cube();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                int val = Color.getVal(map[i][j]);
                proxyCube.map[i][j] = Color.getVal(val);
            }
        }

        switch (r) {
            case U1:
                map[3][8] = proxyCube.map[1][3];map[3][5] = proxyCube.map[1][2];map[3][3] = proxyCube.map[1][1];
                map[2][6] = proxyCube.map[3][8];map[2][7] = proxyCube.map[3][5];map[2][8] = proxyCube.map[3][3];
                map[4][1] = proxyCube.map[2][6];map[4][4] = proxyCube.map[2][7];map[4][6] = proxyCube.map[2][8];
                map[1][3] = proxyCube.map[4][1];map[1][2] = proxyCube.map[4][4];map[1][1] = proxyCube.map[4][6];
                map[0][1] = proxyCube.map[0][6];map[0][3] = proxyCube.map[0][1];map[0][8] = proxyCube.map[0][3];map[0][6] = proxyCube.map[0][8];
                map[0][2] = proxyCube.map[0][4];map[0][5] = proxyCube.map[0][2];map[0][7] = proxyCube.map[0][5];map[0][4] = proxyCube.map[0][7];
                break;
            case U2:
                for (int i = 0; i < 2; i++) {
                    rotate(Rotation.U1);
                }
                break;
            case U3:
                for (int i = 0; i < 3; i++) {
                    rotate(Rotation.U1);
                }
                break;
            case D1:
                map[4][8] = proxyCube.map[1][6];map[4][5] = proxyCube.map[1][7];map[4][3] = proxyCube.map[1][8];
                map[2][3] = proxyCube.map[4][8];map[2][2] = proxyCube.map[4][5];map[2][1] = proxyCube.map[4][3];
                map[3][1] = proxyCube.map[2][3];map[3][4] = proxyCube.map[2][2];map[3][6] = proxyCube.map[2][1];
                map[1][6] = proxyCube.map[3][1];map[1][7] = proxyCube.map[3][4];map[1][8] = proxyCube.map[3][6];
                map[5][1] = proxyCube.map[5][6];map[5][3] = proxyCube.map[5][1];map[5][8] = proxyCube.map[5][3];map[5][6] = proxyCube.map[5][8];
                map[5][2] = proxyCube.map[5][4];map[5][5] = proxyCube.map[5][2];map[5][7] = proxyCube.map[5][5];map[5][4] = proxyCube.map[5][7];
                break;
            case D2:
                for (int i = 0; i < 2; i++) {
                    rotate(Rotation.D1);
                }
                break;
            case D3:
                for (int i = 0; i < 3; i++) {
                    rotate(Rotation.D1);
                }
                break;
            case R1:
                map[0][8] = proxyCube.map[1][8];map[0][5] = proxyCube.map[1][5];map[0][3] = proxyCube.map[1][3];
                map[2][8] = proxyCube.map[0][8];map[2][5] = proxyCube.map[0][5];map[2][3] = proxyCube.map[0][3];
                map[5][1] = proxyCube.map[2][8];map[5][4] = proxyCube.map[2][5];map[5][6] = proxyCube.map[2][3];
                map[1][8] = proxyCube.map[5][1];map[1][5] = proxyCube.map[5][4];map[1][3] = proxyCube.map[5][6];
                map[4][1] = proxyCube.map[4][6];map[4][3] = proxyCube.map[4][1];map[4][8] = proxyCube.map[4][3];map[4][6] = proxyCube.map[4][8];
                map[4][2] = proxyCube.map[4][4];map[4][5] = proxyCube.map[4][2];map[4][7] = proxyCube.map[4][5];map[4][4] = proxyCube.map[4][7];
                break;
            case R2:
                for (int i = 0; i < 2; i++) {
                    rotate(Rotation.R1);
                }
                break;
            case R3:
                for (int i = 0; i < 3; i++) {
                    rotate(Rotation.R1);
                }
                break;
            case L1:
                map[0][1] = proxyCube.map[2][1];map[0][4] = proxyCube.map[2][4];map[0][6] = proxyCube.map[2][6];
                map[1][1] = proxyCube.map[0][1];map[1][4] = proxyCube.map[0][4];map[1][6] = proxyCube.map[0][6];
                map[5][8] = proxyCube.map[1][1];map[5][5] = proxyCube.map[1][4];map[5][3] = proxyCube.map[1][6];
                map[2][1] = proxyCube.map[5][8];map[2][4] = proxyCube.map[5][5];map[2][6] = proxyCube.map[5][3];
                map[3][1] = proxyCube.map[3][6];map[3][3] = proxyCube.map[3][1];map[3][8] = proxyCube.map[3][3];map[3][6] = proxyCube.map[3][8];
                map[3][2] = proxyCube.map[3][4];map[3][5] = proxyCube.map[3][2];map[3][7] = proxyCube.map[3][5];map[3][4] = proxyCube.map[3][7];
                break;
            case L2:
                for (int i = 0; i < 2; i++) {
                    rotate(Rotation.L1);
                }
                break;
            case L3:
                for (int i = 0; i < 3; i++) {
                    rotate(Rotation.L1);
                }
                break;
            case F1:
                map[0][6] = proxyCube.map[3][6];map[0][7] = proxyCube.map[3][7];map[0][8] = proxyCube.map[3][8];
                map[4][6] = proxyCube.map[0][6];map[4][7] = proxyCube.map[0][7];map[4][8] = proxyCube.map[0][8];
                map[5][6] = proxyCube.map[4][6];map[5][7] = proxyCube.map[4][7];map[5][8] = proxyCube.map[4][8];
                map[3][6] = proxyCube.map[5][6];map[3][7] = proxyCube.map[5][7];map[3][8] = proxyCube.map[5][8];
                map[1][1] = proxyCube.map[1][6];map[1][3] = proxyCube.map[1][1];map[1][8] = proxyCube.map[1][3];map[1][6] = proxyCube.map[1][8];
                map[1][2] = proxyCube.map[1][4];map[1][5] = proxyCube.map[1][2];map[1][7] = proxyCube.map[1][5];map[1][4] = proxyCube.map[1][7];
                break;
            case F2:
                for (int i = 0; i < 2; i++) {
                    rotate(Rotation.F1);
                }
                break;
            case F3:
                for (int i = 0; i < 3; i++) {
                    rotate(Rotation.F1);
                }
                break;
            case B1:
                map[0][3] = proxyCube.map[4][3];map[0][2] = proxyCube.map[4][2];map[0][1] = proxyCube.map[4][1];
                map[3][3] = proxyCube.map[0][3];map[3][2] = proxyCube.map[0][2];map[3][1] = proxyCube.map[0][1];
                map[5][3] = proxyCube.map[3][3];map[5][2] = proxyCube.map[3][2];map[5][1] = proxyCube.map[3][1];
                map[4][3] = proxyCube.map[5][3];map[4][2] = proxyCube.map[5][2];map[4][1] = proxyCube.map[5][1];
                map[2][1] = proxyCube.map[2][6];map[2][3] = proxyCube.map[2][1];map[2][8] = proxyCube.map[2][3];map[2][6] = proxyCube.map[2][8];
                map[2][2] = proxyCube.map[2][4];map[2][5] = proxyCube.map[2][2];map[2][7] = proxyCube.map[2][5];map[2][4] = proxyCube.map[2][7];
                break;
            case B2:
                for (int i = 0; i < 2; i++) {
                    rotate(Rotation.B1);
                }
                break;
            case B3:
                for (int i = 0; i < 3; i++) {
                    rotate(Rotation.B1);
                }
                break;
//            default:
//                /* This clause is for "prime" rotations.
//                * It basically does the inverse rotation 3 times.
//                * So if you're trying to rotate the cube with a UP rotation,
//                * it does 3 U rotations instead. Just saved myself a
//                * lot of typing tedious code haha! */
//                for (int i = 0; i < 3; i++) {
//                    rotate(Rotation.inverse(r));
//                }
        }
    }

    /* Instead of one rotation, takes an array of rotations. */
    public void rotate(Rotation[] rotations) {
        for (Rotation r : rotations) {
            rotate(r);
        }
    }
}
