package Main;
import Models.Direction;
import Models.Grid;
import Models.Car;

/**
 * This class starts the simulation and simulates time, updating each car every time step.
 */
public class Simulation {
    public static final int TOTAL_TIMESTEPS = 30;
    public static final int TIMESTEPSPERSEC = 3;
    private Grid grid;

    public Simulation() {
        grid = new Grid(TOTAL_TIMESTEPS);

    }

    /**
     * Iterates through time steps and updates car each time step.
     */
    private void runSimulation() {
        int timeStep = 0;
        addNewCars();
        while (timeStep < TOTAL_TIMESTEPS) {
            System.out.println("Num cars: " + grid.cars.size());
            if (grid.cars.size() == 0)
                break;
            for (int j = 0; j < grid.cars.size(); j++){
                Car car = grid.cars.get(j);
                car.reservePath(timeStep);
                boolean onGrid = car.updateCarLocation(timeStep);
                if (!onGrid) {
                    j--;
                }
                System.out.println();
            }
            timeStep++;
        }
    }


    /**
     * Add cars manually for simulation
     */
    private void addNewCars() {
        Car car1 = new Car(12, 11, 30, grid.squareArr[TOTAL_TIMESTEPS - 1][TOTAL_TIMESTEPS / 2 + 1], Direction.NORTH, grid);
        Car car2 = new Car(12, 11, 30, grid.squareArr[TOTAL_TIMESTEPS - 1][TOTAL_TIMESTEPS / 2 + 2], Direction.NORTH, grid);
        Car car3 = new Car(12, 11, 30, grid.squareArr[TOTAL_TIMESTEPS / 2 - 2][TOTAL_TIMESTEPS - 1], Direction.WEST, grid);
        Car car4 = new Car(12, 11, 30, grid.squareArr[TOTAL_TIMESTEPS / 2 - 3][TOTAL_TIMESTEPS - 1], Direction.WEST, grid);
        Car car5 = new Car(12, 11, 30, grid.squareArr[TOTAL_TIMESTEPS / 2 + 1][0], Direction.EAST, grid);
        Car car6 = new Car(12, 11, 30, grid.squareArr[TOTAL_TIMESTEPS / 2 + 2][0], Direction.EAST, grid);
        Car car7 = new Car(12, 11, 30, grid.squareArr[0][TOTAL_TIMESTEPS / 2 - 2], Direction.SOUTH, grid);
        Car car8 = new Car(12, 11, 30, grid.squareArr[0][TOTAL_TIMESTEPS / 2 - 3], Direction.SOUTH, grid);
        grid.addCar(car1);
        grid.addCar(car2);
//        grid.addCar(car3);
//        grid.addCar(car4);
//        grid.addCar(car5);
//        grid.addCar(car6);
        grid.addCar(car7);
        grid.addCar(car8);
    }

    public static void main(String[] args) {
        Simulation first = new Simulation();
        first.runSimulation();
    }
}
