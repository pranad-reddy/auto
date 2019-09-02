package Models;


import Main.Simulation;

public class Square {
    private boolean[] availableTimes;
    int x, y;

    public Square(int x, int y) {
        availableTimes = new boolean[Simulation.TOTAL_TIMESTEPS];
        this.x = x;
        this.y = y;
        for (int i = 0; i < availableTimes.length; i++) availableTimes[i] = true;
    }

    boolean[] getAvailableTimes(){
        return availableTimes;
    }

    @Override
    public String toString() {
        return "Square{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
