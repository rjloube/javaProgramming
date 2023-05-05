/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author rjloube
 */
public class TemperatureSensor implements Sensor {

    private boolean status;

    public TemperatureSensor() {
    }

    @Override
    public boolean isOn() {
        return this.status;
    }

    @Override
    public void setOn() {
        this.status = true;
    }

    @Override
    public void setOff() {
        this.status = false;
    }

    @Override
    public int read() {
        if (this.status) {
            return new Random().nextInt(61) - 30;
        } else {
            throw new IllegalArgumentException("The sensor is currently off.");
        }
    }

}
