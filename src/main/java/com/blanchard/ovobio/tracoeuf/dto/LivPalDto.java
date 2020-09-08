package com.blanchard.ovobio.tracoeuf.dto;

public class LivPalDto {
    private int id;
    private String date;
    private String prefix;

    public LivPalDto(){}

    public LivPalDto(int id, String date, String prefix) {
        this.id = id;
        this.date = date;
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return "LivPalDto{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", prefix='" + prefix + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
