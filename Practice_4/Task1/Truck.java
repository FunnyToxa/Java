// Класс грузовой авто
public class Truck extends Car{

    @Override
    public String toString() {
        return getTypeName() + ", " + super.toString();
    }

    @Override
    public String getTypeName() {
        return "Грузовой авто";
    }

    public Truck(DTOCarParams dtoCarParams) {
        super(dtoCarParams);
    }
}
