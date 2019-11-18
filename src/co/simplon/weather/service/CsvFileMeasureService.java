package co.simplon.weather.service;

import co.simplon.weather.measure.Measure;

public class CsvFileMeasureService implements MeasureService {
    @Override
    public String saveMeasure(Measure measureToSave) {
        return "I will save your measure " + measureToSave + " to a CSV file";
    }
}
