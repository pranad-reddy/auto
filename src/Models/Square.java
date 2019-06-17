package Models;


import Main.Simulation;

public class Square {
    private boolean[] availableTimes;

    public Square() {
        availableTimes = new boolean[Simulation.TOTAL_TIMESTEPS];
        for (int i = 0; i < availableTimes.length; i++) availableTimes[i] = true;
    }

    boolean[] getAvailableTimes(){
        return availableTimes;
    }
}
