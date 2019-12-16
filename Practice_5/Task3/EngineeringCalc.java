public class EngineeringCalc extends Calculator {
    public String toHex(Integer intValue){
        return Integer.toHexString(intValue);
    }

    public Integer toDec(String strValue){
        return Integer.parseInt(strValue, 16);
    }
}
