package com.company;

import java.util.ArrayList;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JsonParser jsonParser = new JsonParser();
        CSVExporter csv = new CSVExporter();
        ArrayList<Status> statuses = new ArrayList<Status>();
        statuses = jsonParser.parseJson(Config.JSON_PATH);
        statuses.sort(new DateSorter());
        csv.exportToCsv(statuses, Config.CSV_PATH);
    }
}