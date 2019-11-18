package co.simplon.weather.measure;

import java.time.LocalDateTime;

/**
 * Abstract class that describes a convertible Measure (temperature, pressure, ...)
 */
public abstract class ConvertibleMeasure extends Measure {

    public ConvertibleMeasure(String unit, Double value, LocalDateTime date) {
        super(unit, value, date);
    }

    /**
     * Functions that converts a Measure from its unit to the specified unit.
     *
     * @param toUnit the unit to convert to
     * @return the ConvertedMeasure
     */
    public abstract Measure convertTo(String toUnit);
}
