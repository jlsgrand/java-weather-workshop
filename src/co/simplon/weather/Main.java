package co.simplon.weather;

import co.simplon.weather.measure.*;
import co.simplon.weather.service.CsvFileMeasureService;
import co.simplon.weather.service.DataBaseMeasureService;
import co.simplon.weather.service.MeasureService;
import co.simplon.weather.service.TextFileMeasureService;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        // I declare different measures
        ConvertibleMeasure temp = new Temperature("°C", 23.3, LocalDateTime.now().minusDays(1));
        ConvertibleMeasure pres = new Pressure("hPa", 1024.1, LocalDateTime.now().minusDays(2));
        Measure humidity = new Humidity("%", 50.0, LocalDateTime.now());

        System.out.println("---------- Temperatures ----------");

        // I save one temp measure in DB and try multiple conversions.
        MeasureService measureService = new DataBaseMeasureService();
        System.out.println(measureService.saveMeasure(temp));
        System.out.println(measureService.saveMeasure(temp.convertTo(Temperature.KELVIN)));
        System.out.println(measureService.saveMeasure(temp.convertTo(Temperature.FAHRENHEIT)));

        System.out.println("---------- Pressures ----------");

        // I save one pres measure in Text file and try multiple conversions.
        measureService = new TextFileMeasureService();
        System.out.println(measureService.saveMeasure(pres));
        System.out.println(measureService.saveMeasure(pres.convertTo(Pressure.ATM)));
        System.out.println(measureService.saveMeasure(pres.convertTo(Pressure.BAR)));

        System.out.println("---------- Humidity ----------");

        // I save one pres measure in Text file.
        measureService = new CsvFileMeasureService();
        System.out.println(measureService.saveMeasure(humidity));
    }
}
