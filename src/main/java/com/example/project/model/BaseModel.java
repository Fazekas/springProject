package com.example.project.model;

import java.io.Serializable;

public class BaseModel implements Serializable {

    private Integer id;

    private boolean active;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
