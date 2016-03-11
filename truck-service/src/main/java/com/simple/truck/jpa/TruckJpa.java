package com.simple.truck.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="trucks")
public class TruckJpa {

    @Id
    @GeneratedValue
    @Column(name="id", nullable = false, insertable = false)
    private Long id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="price")
    private Double price;

    @CreationTimestamp
    @Column(name="created")
    private Date created;

    @UpdateTimestamp
    @Column(name="updated")
    private Date updated;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
    
}
