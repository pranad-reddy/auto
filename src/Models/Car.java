package Models;
import java.util.ArrayList;
import java.util.List;

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
    //https://www.drivingtestsuccess.com/blog/safe-separation-distance
    private int getNumSquaresToReserve() {
        //TODO change to be more readable
        //mph to m/s
        //double speed_metric = speed / 2.237;
        //4.572 is meters to 15 feet
        //return 1 + (int)Math.ceil(speed_metric * speed_metric / (2 * .7 * 9.8) / 4.572);
        return 1 + (int)Math.ceil(speed / 2.237 / 3);

    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }

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
        //algorithm using Square.getAvailableTimes to create reserved path
    }

    public boolean updateCarLocation(Grid grid, int timeStep) {
        int squaresMoved = (int)Math.ceil(speed / 2.237 / 3);
        while (squaresMoved > 0) {
            if (reservations.size() == 0) {
                //TODO this is a crash or something bad
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
            //TODO this is a crash or something bad
            grid.cars.remove(this);
            return false;
        }
        setLocation(reservations.get(0).getSquare());
        System.out.println("Location: " + location);
        return true;
    }

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
