package co.simplon.weather.measure;

import java.time.LocalDateTime;

/**
 * Class representing Temperature values. This class handles value conversion.
 */
public class Temperature extends ConvertibleMeasure {

    public final static String KELVIN = "°K";

    public final static String CELSIUS = "°C";
    public final static String FAHRENHEIT = "°F";

    private final Double siValue;

    public Temperature(String unit, Double value, LocalDateTime date) {
        super(unit, value, date);
        if (unit.equalsIgnoreCase(KELVIN)) {
            siValue = value;
        } else {
            siValue = convertToValueSiUnit(unit);
        }
    }

    @Override
    public ConvertibleMeasure convertTo(String toUnit) {
        Double convertedValue = getValue();
        switch (toUnit) {
            case KELVIN:
                convertedValue = siValue;
                break;
            case CELSIUS:
                convertedValue = siValue - 273.15;
                break;
            case FAHRENHEIT:
                convertedValue = (siValue - 273.15) * (9.0 / 5.0) + 32;
                break;
            default:
                break;
        }
        return new Temperature(toUnit, convertedValue, getDate());
    }

    private Double convertToValueSiUnit(String fromUnit) {
        Double convertedValue = getValue();
        switch (fromUnit) {
            case CELSIUS:
                convertedValue = getValue() + 273.15;
                break;
            case FAHRENHEIT:
                convertedValue = (getValue() - 32) * (5.0 / 9.0) + 273.15;
                break;
            default:
                break;
        }
        return convertedValue;
    }
}
