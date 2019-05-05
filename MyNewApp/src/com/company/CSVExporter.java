package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CSVExporter {

    public void exportToCsv(ArrayList<Status> statuses, String path){

        File csvFile = new File(path);

        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile))){

            csvWriter.print(StatusHeaders.KONTAKT_ID + ";");
            csvWriter.print(StatusHeaders.KLIENT_ID  + ";");
            csvWriter.print(StatusHeaders.PRACOWNIK_ID + ";");
            csvWriter.print(StatusHeaders.STATUS + ";");
            csvWriter.print(StatusHeaders.KONTAKT_TS + ";");
            csvWriter.println();

            for(Status status : statuses){
                csvWriter.print(status.getContact_id() + ";");
                csvWriter.print(status.getClient_id() + ";");
                csvWriter.print(status.getEmployee_id() + ";");
                csvWriter.print(status.getStatus() + ";");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formatDateTime = status.getDateTime().format(formatter);
                csvWriter.print(formatDateTime + ";");

                csvWriter.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
