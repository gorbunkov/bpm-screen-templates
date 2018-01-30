package com.company.bpmscreen.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|number")
@Table(name = "BPMSCREEN_CONTRACT")
@Entity(name = "bpmscreen$Contract")
public class Contract extends StandardEntity {
    private static final long serialVersionUID = -7203027629148034744L;

    @Column(name = "NUMBER_")
    protected String number;

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }


}