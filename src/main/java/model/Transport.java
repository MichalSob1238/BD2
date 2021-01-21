package model;

import java.util.Date;

public class Transport {
    int id;
    Date transportDate;
    int employeeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTransportDate() {
        return transportDate;
    }

    public void setTransportDate(Date transportDate) {
        this.transportDate = transportDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Transport(int id, Date transportDate, int employeeId) {
        this.id = id;
        this.transportDate = transportDate;
        this.employeeId = employeeId;
    }
}
