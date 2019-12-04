// Класс тяжелая техника(краны)
public class Crane extends Car{
    @Override
    public String toString() {
        return getTypeName() + ", " + super.toString();
    }

    public Crane(TempCarParams tempCarParams) {
        super(tempCarParams);
    }

    @Override
    public String getTypeName() {
        return  "тяжелая техника(краны)";
    }
}
