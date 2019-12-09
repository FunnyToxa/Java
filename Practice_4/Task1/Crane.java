// Класс тяжелая техника(краны)
public class Crane extends Car{
    @Override
    public String toString() {
        return getTypeName() + ", " + super.toString();
    }

    @Override
    public String getTypeName() {
        return  "тяжелая техника(краны)";
    }

    public Crane(DTOCarParams dtoCarParams) {
        super(dtoCarParams);
    }
}
