package com.zecovery.android.mascotas.pet;

/**
 * Created by fran on 24-08-16.
 */

public class Pet {

    private String name;
    private String address;
    private String rut;
    private int photo;
    private int id;
    private int ship;

    public Pet() {
    }

    public Pet(String name, String address, int photo) {
        this.name = name;
        this.address = address;
        this.photo = photo;
    }

    public Pet(String name, String address, String rut, int id, int ship) {
        this.name = name;
        this.address = address;
        this.rut = rut;
        this.id = id;
        this.ship = ship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShip() {
        return ship;
    }

    public void setShip(int ship) {
        this.ship = ship;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
