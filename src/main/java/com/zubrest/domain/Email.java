package com.zubrest.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Created by student on 2016/04/04.
 */
@Entity
@NamedQuery(name="Email.findByAddress",query="select address,description,date from Email b where b.address=?1")
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    long id;
    @Column(name="address")
    String address;
    @Column(name="description")
    String description;
    @Column(name="date")
    Date date;

    public Email() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
