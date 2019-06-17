package Models;
import java.util.List;

public class Car {

    private double acc, dec; //safe acceleration and deceleration
    double speed;
    Direction direction;
    private Square location; //Square on grid that car is currently on
    private List<Square> reserved; //list of Squares on grid reserved for Car

    public Car(double acc, double dec, double speed, Square location, Direction direction) {
        this.acc = acc;
        this.dec = dec;
        this.speed = speed;
        this.location = location;
        this.direction = direction;
    }

    Square getLocation() {
        return location;
    }

    void setLocation(Square location) {
        this.location = location;
    }

    void reservePath() {
        //algorithm using Square.getAvailableTimes to create reserved path
    }
}
