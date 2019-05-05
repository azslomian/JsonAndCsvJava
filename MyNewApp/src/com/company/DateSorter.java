package com.company;

import java.util.Comparator;

public class DateSorter implements Comparator<Status>
{
    @Override
    public int compare(Status o1, Status o2) {
        if((o2.getClient_id() == o1.getClient_id())) {
            if ((o2.getContact_id() == o1.getContact_id())) {
                return o2.getDateTime().compareTo(o1.getDateTime());
            } else if ((o2.getContact_id() > o1.getContact_id())) {
                return 1;
            } else {
                return -1;
            }
        }
        else if(o2.getClient_id() > o1.getClient_id()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}