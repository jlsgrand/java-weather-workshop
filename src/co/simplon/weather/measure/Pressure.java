package co.simplon.weather.measure;

import java.time.LocalDateTime;

/**
 * Class representing Pressure values. This class handles value conversion.
 */
public class Pressure extends ConvertibleMeasure {

    public final static String HPA = "hPa";

    public final static String BAR = "bar";
    public final static String PA = "Pa";
    public final static String ATM = "atm";

    private final Double siValue;

    public Pressure(String unit, Double value, LocalDateTime date) {
        super(unit, value, date);
        if (unit.equalsIgnoreCase(HPA)) {
            siValue = value;
        } else {
            siValue = convertToValueSiUnit(unit);
        }
    }

    @Override
    public ConvertibleMeasure convertTo(String toUnit) {
        Double convertedValue = siValue;
        switch (toUnit) {
            case HPA:
                convertedValue = siValue;
                break;
            case BAR:
                convertedValue = siValue / 1000;
                break;
            case PA:
                convertedValue = siValue * 100;
                break;
            case ATM:
                convertedValue = siValue / 1013.25;
                break;
            default:
                break;
        }
        return new Pressure(toUnit, convertedValue, getDate());
    }

    private Double convertToValueSiUnit(String fromUnit) {
        Double convertedValue = getValue();
        switch (fromUnit) {
            case BAR:
                convertedValue = getValue() * 1000;
                break;
            case PA:
                convertedValue = getValue() / 100;
                break;
            case ATM:
                convertedValue = getValue() * 1013.25;
                break;
            default:
                break;
        }
        return convertedValue;
    }
}
