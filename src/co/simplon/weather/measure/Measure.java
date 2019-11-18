package co.simplon.weather.measure;

import java.time.LocalDateTime;

/**
 * Measure root class. It represents a Measure (temperature, pressure or humidity)
 */
public class Measure {

    private final String unit;
    private final Double value;
    private final LocalDateTime date;

    public Measure(String unit, Double value, LocalDateTime date) {
        this.unit = unit;
        this.value = value;
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%2$.1f %3$s (taken on %1$td/%1$tm/%1$tY - %1$tHh%1$tM)", date, value, unit);
    }

    public String getUnit() {
        return unit;
    }

    Double getValue() {
        return value;
    }

    LocalDateTime getDate() {
        return date;
    }
}
