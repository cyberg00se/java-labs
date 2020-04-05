import java.util.ArrayList;
import java.util.List;

class Road<T extends Vehicle> {
    public List<T> carsInRoad = new ArrayList<>();

    public void addCarToRoad(T car) {
        carsInRoad.add(car);
    }

    public int getCountOfHumans() {
        int countOfHumans = 0;
        for (T car: carsInRoad) {
            countOfHumans += car.getOccupiedSeats();
        }
        return countOfHumans;
    }
}
