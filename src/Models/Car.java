package Models;

public class Car {
    private double acc, dec; //acceleration and deceleration speeds
//    private Square loc; //Square on grid that car is currently on
//    private List<Square> reserved; //list of Squares on grid reserved for Car

    public Car(double acc, double dec/* Square loc*/) {
        this.acc = acc;
        this.dec = dec;
//        this.loc = loc;
//        reserved = null;
    }

    public double getAcc() {
        return acc;
    }

    public void setAcc(double acc) {
        this.acc = acc;
    }

    public double getDec() {
        return dec;
    }

    public void setDec(double dec) {
        this.dec = dec;
    }
//
//    public Square getLoc() {
//        return loc;
//    }
//
//    public void setLoc(Square loc) {
//        this.loc = loc;
//    }

}
