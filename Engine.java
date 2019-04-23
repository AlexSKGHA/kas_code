//The FunctionConsoleEngine

public class Engine {

    private char [] flat;

    private boolean running;

    private int FPS;

    private int wrap;

    private int x;

    private int y;

    private int xy;

    private final char DEFAULT_SYMBOL = ' ';

    {
        FPS = 0;
        wrap = 30;
        x = 9;
        y = 9;
        xy = 81;

        flat = new char[xy];

        for (int i = 0; i < flat.length; i++) {
            flat[i] = DEFAULT_SYMBOL;
        }
    }

    private Engine() {}

    public static Engine getEngine() {
        return new Engine();
    }

    private void wrapping(boolean running) {
        if (running) {
            for (int i = 0; i < wrap; i++) {
                System.out.println();
            }
        }
    }

    public void formatEngine(int x, int y) {
        this.x = x;
        this.y = y;
        this.xy = x * y;

        flat = new char[xy];

        for (int i = 0; i < flat.length; i++) {
            flat[i] = DEFAULT_SYMBOL;
        }
    }

    public void draw() {
        try {
            running = true;
            while (running) {
                for (int i = 0; i < xy; i++) {
                    for (int ii = 0; ii < x; ii++) {
                        System.out.print(flat[i] + " ");
                        i++;
                    }
                    i--;
                    System.out.println();
                }
                Thread.sleep(FPS);
                wrapping(running);
            }
        } catch (Exception ex) {

        }
    }

    public void editFlat(int X, int Y, char symbol) {
        flat[Y * x + X] = symbol;
    }

    public char[] getFlat() {
        return flat;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXY() {
        return xy;
    }

    public int getFPS() {
        return FPS;
    }

    public int getWrap() {
        return wrap;
    }

    public void stopRunning() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void setFPS(int milliseconds) {
        FPS = milliseconds;
    }

    public void setWrap(int wrap) {
        this.wrap = wrap;
    }
}
