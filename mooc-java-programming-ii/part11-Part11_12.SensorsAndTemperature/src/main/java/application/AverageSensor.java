/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author rjloube
 */
public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();

    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : this.sensors) {
            if (!(sensor.isOn())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void setOn() {
        this.sensors.stream()
                .forEach(sensor -> sensor.setOn());
    }

    @Override
    public void setOff() {
        this.sensors.stream()
                .forEach(sensor -> sensor.setOff());
    }

    @Override
    public int read() {
        if (this.isOn() == false || this.sensors.isEmpty()) {
            throw new IllegalArgumentException("The sensor(s) in the average sensor are turned off, or there are no sensors included currently.");
        }

        /* int sum = 0;
        int count = 0;

        for (Sensor sensor : this.sensors) {
            this.readings.add(sensor.read());
            sum += sensor.read();
            count++;
        }

        return sum / count; */

        double average = this.sensors.stream()
                .mapToInt(s -> s.read())
                .average()
                .getAsDouble();
        
        this.readings.add( (int) (average));

        return (int) average;
    }

    public List<Integer> readings() {
        return this.readings;
    }

}
