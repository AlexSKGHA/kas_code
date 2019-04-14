//The FunctionConsoleEngine

public class Engine {

    private char [] flat;

    private int i = 0;

    private int ii = 0;

    private int x;

    private int y;

    private int xy;

    private final char DEFAULT_SYMBOL = ' ';

    private final int defaultSizeFlat = 81;

    private final int defaultX = 9;

    private final int defaultY = 9;

    public Engine() {

        x = defaultX;
        y = defaultY;
        xy = defaultSizeFlat;

        flat = new char[xy];

        for (int i = 0; i < flat.length; i++) {
            flat[i] = DEFAULT_SYMBOL;
        }
    }

    public Engine(char symbol) {

        x = defaultX;
        y = defaultY;
        xy = defaultSizeFlat;

        flat = new char[xy];

        for (int i = 0; i < flat.length; i++) {
            flat[i] = symbol;
        }
    }

    public Engine(int X, int Y) {

        if (X > 0 && Y > 0 && X <= 250 && Y <= 50) {
            x = X;
            y = Y;
            xy = X * Y;
        } else {
            x = defaultX;
            y = defaultY;
            xy = defaultSizeFlat;
        }

        flat = new char[xy];

        for (int i = 0; i < flat.length; i++) {
            flat[i] = DEFAULT_SYMBOL;
        }
    }



    public Engine(int X, int Y, char symbol) {

        if (X > 0 && Y > 0 && X <= 250 && Y <= 50) {
            x = X;
            y = Y;
            xy = X * Y;
        } else {
            System.out.println(0);
            x = defaultX;
            y = defaultY;
            xy = defaultSizeFlat;
        }

        flat = new char[xy];

        for (int i = 0; i < flat.length; i++) {
            flat[i] = symbol;
        }
    }

    public void calculateXY() {
        xy = x * y;
    }

    public void draw() {
        for (i = 0; i < xy; i++) {
            for (ii = 0; ii < x; ii++) {
                System.out.print(flat[i] + " ");
                i++;
            }
            i--;
            System.out.println();
        }
    }

    public boolean editFlat(int X, int Y, char symbol) {

        if (X >= 0 && Y >= 0 && X <= 250 && Y <= 50) {
            try {
                flat[Y * x + X] = symbol;
                return true;
            } catch (Exception ex) {
                return false;
            }
        } else {
            return false;
        }

    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getXY() {
        return this.xy;
    }

    public char getDefaultSymbol() {
        return this.DEFAULT_SYMBOL;
    }

    public int getDefaultX() {
        return this.defaultX;
    }

    public int getDefaultY() {
        return this.defaultY;
    }

    public char[] getFlat() {
        return this.flat;
    }

    public boolean setX(int X) {
        if (X > 0 && X <= 250) {
            this.x = X;
            calculateXY();
            return true;
        } else {
            return false;
        }

    }

    public boolean setY(int Y) {
        if (Y > 0 && Y <= 50) {
            this.y = Y;
            calculateXY();
            return true;
        } else {
            return false;
        }
    }
}
