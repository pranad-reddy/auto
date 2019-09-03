package Models;

import Main.Simulation;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a car and holds the logic for reserving paths through the intersection.
 */
public class Car {

    private double acc, dec; //safe acceleration and deceleration
    double speed;
    Direction direction;
    private Square location; //Square on grid that car is currently on
    public List<Reservation> reservations; //list of reservations
    private Grid grid;
    private static int carCount = 0;
    public int id;

    public Car(double acc, double dec, double speed, Square location, Direction direction, Grid grid) {
        this.acc = acc;
        this.dec = dec;
        this.speed = speed;
        this.location = location;
        this.direction = direction;
        this.grid = grid;
        this.reservations = new ArrayList<>();
        this.id = ++carCount;
    }

    /**
     * Calculate and return num squares to reserve, including current location, based on speed and timesteps per sec
     * @return int Number of squares to reserve
     */
    private int getNumSquaresToReserve() {
        double mphToMetric = 1 / 2.237;
        //account 1 for location of car
        return 1 + (int)Math.ceil(speed * mphToMetric / Simulation.TIMESTEPSPERSEC);

    }

    /**
     * Return current location square
     * @return Square location
     */
    public Square getLocation() {
        return location;
    }

    /**
     * Sets current location to Square passed as parameter
     * @param location
     */
    public void setLocation(Square location) {
        this.location = location;
    }

    /**
     * Reserves path for car based on direction, speed and availability
     * @param timeStep Current timestep to reserve path for
     */
    public void reservePath(int timeStep) {
        int pathLength = getNumSquaresToReserve();
        System.out.println("Car Id: " + this.id);
        System.out.println("timestep: " + timeStep);
        boolean added = false;
        switch (direction)
        {
            case SOUTH:
                for (int y = location.y; y < grid.squareArr.length && y < location.y + pathLength; y++) {
                    Square square = grid.squareArr[y][location.x];
                    added = addReservation(square, timeStep);
                }
                break;
            case NORTH:
                for (int y = location.y; y >= 0 && y > location.y - pathLength; y--) {
                    Square square = grid.squareArr[y][location.x];
                    added = addReservation(square, timeStep);
                }
                break;
            case EAST:
                for (int x = location.x; x < grid.squareArr.length && x < location.x + pathLength; x++) {
                    Square square = grid.squareArr[location.y][x];
                    added = addReservation(square, timeStep);
                }
                break; 
            case WEST:
                for (int x = location.x; x >= 0 && x > location.x - pathLength; x--) {
                    Square square = grid.squareArr[location.y][x];
                    added = addReservation(square, timeStep);
                }
                break; 
        }
    }

    /**
     * Iterates through reservations and updates car location based on current speed, removing old reservations
     * @param timeStep Current timestep
     * @return boolean Whether the car is still on the grid or not
     */
    public boolean updateCarLocation(int timeStep) {
        int squaresMoved = (int)Math.ceil(speed / 2.237 / 3);
        while (squaresMoved > 0) {
            if (reservations.size() == 0) {
                //TODO handle crashes
                grid.cars.remove(this);
                return false;
            }
            //Reservation r = reservations.remove(0);
            //System.out.println("Timestep: " + r.timeStep + " | " + r.getSquare());
            int currTimeStep = reservations.remove(0).getTimeStep();
            if (currTimeStep == timeStep)
                squaresMoved--;
        }
        if (reservations.size() == 0) {
            //TODO handle crashes
            grid.cars.remove(this);
            return false;
        }
        setLocation(reservations.get(0).getSquare());
        System.out.println("Location: " + location);
        return true;
    }

    /**
     * Creates reservation if given Square is available for given timestep. Returns result boolean
     * @param square Square to attempt to make reservation for
     * @param timeStep Current timestep
     * @return boolean Whether the reservation could be made or not
     */
    private boolean addReservation(Square square, int timeStep) {
       if (square.getAvailableTimes()[timeStep]) {
            reservations.add(new Reservation(this, square, timeStep));
            System.out.println(square);
            square.getAvailableTimes()[timeStep] = false;
            return true;
        }
        else {
           System.out.println(square + String.valueOf(timeStep) + this);
           return false;
       }
    }
}
