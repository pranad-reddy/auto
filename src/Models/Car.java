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

    public Car(double acc, double dec, double speed, Square location, Direction direction, Grid grid) {
        this.acc = acc;
        this.dec = dec;
        this.speed = speed;
        this.location = location;
        this.direction = direction;
        this.grid = grid;
        this.reservations = new ArrayList<>();
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }

    public void reservePath() {
        switch (direction)
        {
            case SOUTH:
                for (int y = location.y + 1; y < grid.squareArr.length; y++) {
                    Square square = grid.squareArr[y][location.x];
                    addReservation(square);
                }
            case NORTH:
                for (int y = location.y - 1; y >= 0; y--) {
                    Square square = grid.squareArr[y][location.x];
                    addReservation(square);
                }
            case EAST:
                for (int x = location.x + 1; x < grid.squareArr.length; x++) {
                    Square square = grid.squareArr[location.y][x];
                    addReservation(square);
                }
            case WEST:
                for (int x = location.x - 1; x >= 0; x--) {
                    Square square = grid.squareArr[location.y][x];
                    addReservation(square);
                }
        }
        //algorithm using Square.getAvailableTimes to create reserved path
    }

    private void addReservation(Square square) {
        int count = 0;
        while (count < square.getAvailableTimes().length)
        {
            if (square.getAvailableTimes()[count])
                reservations.add(new Reservation(this, square, count));
            count++;
        }
    }
}
