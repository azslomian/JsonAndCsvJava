package com.company;

import java.time.LocalDateTime;

public class Status {

    private Long contact_id;
    private Long client_id;
    private Long employee_id;
    private String status;
    private LocalDateTime dateTime;


    public Long getContact_id() { return this.contact_id; }
    public void setContact_id(Long contact_id) { this.contact_id = contact_id; }

    public Long getClient_id() { return this.client_id; }
    public void setClient_id(Long client_id) { this.client_id = client_id; }

    public Long getEmployee_id() { return this.employee_id; }
    public void setEmployee_id(Long employee_id) { this.employee_id = employee_id; }

    public String getStatus() { return this.status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDateTime() { return this.dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}
