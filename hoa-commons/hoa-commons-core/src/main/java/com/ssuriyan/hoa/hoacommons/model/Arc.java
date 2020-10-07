package com.ssuriyan.hoa.hoacommons.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Arc extends AbstractEntity{

    @Column(unique = true)
    private int arcNumber;

    public int getArcNumber() {
        return arcNumber;
    }

    public void setArcNumber(int arcNumber) {
        this.arcNumber = arcNumber;
    }
}
