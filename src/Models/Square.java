package Models;


import Main.Simulation;

/**
 * This class represents a Square in a Grid object. It holds information about when it is available to be reserved.
 */
public class Square {
    private boolean[] availableTimes;
    int x, y;

    public Square(int x, int y) {
        availableTimes = new boolean[Simulation.TOTAL_TIMESTEPS];
        this.x = x;
        this.y = y;
        for (int i = 0; i < availableTimes.length; i++) availableTimes[i] = true;
    }

    /**
     * Returns boolean list of available times to reserve this square
     * @return availableTimes
     */
    boolean[] getAvailableTimes(){
        return availableTimes;
    }

    @Override
    public String toString() {
        return "Square {" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
