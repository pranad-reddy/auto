package Models;

import java.util.List;
import java.util.ArrayList;

public class Grid {
    public List<Car> cars;
    public Square[][] squareArr;

    public Grid(int size) {
        cars = new ArrayList<>();
        squareArr = new Square[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                squareArr[i][j] = new Square(j, i);
    }

    public void addCar(Car c) {
        cars.add(c);
    }


}
