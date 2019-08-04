package Models;

public class Reservation {
    Car car;
    Square square;
    int timeStep;

    public Reservation(Car car, Square square, int timeStep) {
        this.car = car;
        this.square = square;
        this.timeStep = timeStep;
    }

    public Car getCar() {
        return car;
    }

    public Square getSquare() {
        return square;
    }

    public int getTimeStep() {
        return timeStep;
    }
}
