package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class JsonParser {

    public ArrayList<Status> parseJson(String path) {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Status> statuses = new ArrayList<Status>();
        try (FileReader reader = new FileReader(path)) {
            Object recObj = jsonParser.parse(reader);
            org.json.simple.JSONObject recJson = (org.json.simple.JSONObject) recObj;
            org.json.simple.JSONArray records = (org.json.simple.JSONArray) recJson.get("records");
            records.toJSONString();

            //Iterate over objects array
            records.forEach(stat -> parseStatusObject((JSONObject) stat, statuses));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return statuses;
    }

        private void parseStatusObject (JSONObject statusObject, ArrayList<Status> statuses){
            Status contact = new Status();

            //Get object contact id
            Long contact_id = (Long) statusObject.get(StatusHeaders.KONTAKT_ID);
            contact.setContact_id(contact_id);
            System.out.println(contact_id);

            //Get object client id
            Long client_id = (Long) statusObject.get(StatusHeaders.KLIENT_ID);
            contact.setClient_id(client_id);
            System.out.println(client_id);

            //Get object employee id
            Long employee_id = (Long) statusObject.get(StatusHeaders.PRACOWNIK_ID);
            contact.setEmployee_id(employee_id);
            System.out.println(employee_id);

            //Get Status
            String status = (String) statusObject.get(StatusHeaders.STATUS);
            contact.setStatus(status);
            System.out.println(status);

            //Get object contact ts
            String contact_ts = (String) statusObject.get(StatusHeaders.KONTAKT_TS);
            DateTimeFormatter f = DateTimeFormatter.ofPattern(Config.DATE_TIME_PATTERN);
            LocalDateTime localDateTime = LocalDateTime.from(f.parse(contact_ts));
            Date dateTime = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
            contact.setDateTime(localDateTime);
            System.out.println(contact_ts);

            LocalDateTime thresholdLocalDate = LocalDateTime.from(f.parse(Config.THRESHOLD_DATE));
            Date thresholdDate = Date.from(thresholdLocalDate.atZone(ZoneId.systemDefault()).toInstant());

            if(dateTime.after(thresholdDate) ){
                statuses.add(contact);
            }
        }
    }
