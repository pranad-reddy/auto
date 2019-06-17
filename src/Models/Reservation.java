package Models;

public class Reservation {
    private Car car;
    private Square square;
    private int timeStep;

    public Reservation(Car car, Square square, int timeStep) {
        this.car = car;
        this.square = square;
        this.timeStep = timeStep;
    }

    Car getCar() {
        return car;
    }

    Square getSquare() {
        return square;
    }

    int getTimeStep() {
        return timeStep;
    }
}
