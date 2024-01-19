package com.example.textadventuregame.model.items;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

public abstract class Item {
    @JacksonXmlProperty
    private String name;
    @JacksonXmlProperty
    private String imageFileName;
    static int ID = 0;
    final int id;

    protected Item() {
        this.id = ++ID;
    }

    public String getName() {
        return name;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public abstract String getBonusesDesc();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        return id == other.getId();
    }
    public int getId() {
        return id;
    }
}
