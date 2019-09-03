package Models;

/**
 * This class holds information about which car reserved a given square in a given time step.
 */
public class Reservation {
    Car car;
    Square square;
    int timeStep;

    public Reservation(Car car, Square square, int timeStep) {
        this.car = car;
        this.square = square;
        this.timeStep = timeStep;
    }

    /**
     * Returns car for this reservation
     * @return Car
     */
    public Car getCar() {
        return car;
    }

    /**
     * Returns square for this reservation
     * @return Square
     */
    public Square getSquare() {
        return square;
    }

    /**
     * Returns time step for this reservation
     * @return int timeStep
     */
    public int getTimeStep() {
        return timeStep;
    }

    @Override
    public String toString() {
        return getSquare().toString() + " : Timestep{" + timeStep + "}";
    }
}
