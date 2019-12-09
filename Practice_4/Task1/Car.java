public abstract class Car implements Comparable<Car>, ICar {
	//гос номер
	private int gosNumber;
	//пробег
	private int milage;
	//дополнительная информация
	private int additionalInfo;
	//стоимость расходов
//	private double cost;
	//тип авто
	private String type;

	//стоимость топлива и расход
	private double fuelPrice, fuelCons;

	//статические геттеры и сеттеры
	public double getFuelPrice() {return fuelPrice;}
	public void setFuelPrice(double fuelPrice) {this.fuelPrice = fuelPrice;}
	public double getFuelCons() {return fuelCons;}
	public void setFuelCons(double fuelCons) {this.fuelCons = fuelCons;}

	//геттеры  и сеттеры
//	public void setCost(double cost) {this.cost = cost;}
	public int getGosNumber() {return gosNumber;}
	public void setGosNumber(int gosNumber) {this.gosNumber = gosNumber;}
	public int getMilage() {return milage;}
	public void setMilage(int milage) {this.milage = milage;}
	public int getAdditionalInfo() {return additionalInfo;}
	public void setAdditionalInfo(int additionalInfo) {this.additionalInfo = additionalInfo;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}

	//метод подсчета стоимости
	@Override
	public double getCost() {return milage * fuelCons * fuelPrice;}

	//TODO: надо ли выносить в интерфейс ICar?
	//добавление милей
	public void addMilage(int milage){
		this.milage += milage;
	}
	//добавление доп информации
	public void addAdditionalInfo(int additionalInfo){
		this.additionalInfo += additionalInfo;
	}

	// конструктор, принимающий временный объект со структурированной информацией о машине
	public Car (DTOCarParams dtoCarParams){
		gosNumber = dtoCarParams.getGosNumber();
		milage = dtoCarParams.getMilage();
		additionalInfo = dtoCarParams.getAdditionalInfo();
	}

	//конструктор по умолчанию
	public Car() {	}

	//Абстрактный класс получение имени типа
    public abstract String getTypeName();

	@Override
	public String toString() {
		StringBuilder tmpReturn = new StringBuilder("гос. номер:" + getGosNumber() + ", пробег:" + getMilage());
		if (getAdditionalInfo() != 0)
			tmpReturn.append(", доп. инфо: " + getAdditionalInfo());
		return  tmpReturn.toString();
	}

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Car o) {
        if (this.getTypeName().equals(o.getTypeName()))
        {
            if (this.getMilage() == o.getMilage()) {
                return Integer.compare(this.getAdditionalInfo(), o.getAdditionalInfo());
            } else {
                return Integer.compare(this.getMilage(), o.getMilage());
            }
        } else {
            return this.getTypeName().compareTo(o.getTypeName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;

        if (gosNumber != car.gosNumber) return false;
//        if (Double.compare(car.cost, cost) != 0) return false;
        return type.equals(car.type);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = gosNumber;
        result = 31 * result + milage;
        result = 31 * result + additionalInfo;
        temp = Double.doubleToLongBits(getCost());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}