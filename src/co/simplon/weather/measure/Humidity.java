package co.simplon.weather.measure;

import java.time.LocalDateTime;

/**
 * Class representing Humidity values. This class does not handle value conversion.
 */
public class Humidity extends Measure {

    public Humidity(String unit, Double value, LocalDateTime date) {
        super(unit, value, date);
    }
}
