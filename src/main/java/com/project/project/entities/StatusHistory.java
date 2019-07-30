package com.project.project.entities;

import org.hibernate.exception.DataException;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StatusHistory {
    @Id
    @GeneratedValue
    private int id ;
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusDate;
    @Column(name = "history_status")
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
