
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rjloube
 */
public class StorageFacility {

    private HashMap<String, ArrayList<String>> facility;

    public StorageFacility() {
        this.facility = new HashMap<>();
    }

    public void add(String unit, String item) {
        this.facility.putIfAbsent(unit, new ArrayList<>());
        this.facility.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        this.facility.putIfAbsent(storageUnit, new ArrayList<>());
        return this.facility.get(storageUnit);
    }

    public void remove(String storageUnit, String item) {
        this.facility.get(storageUnit).remove(item);
        if (this.facility.get(storageUnit).isEmpty()) {
            this.facility.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> storageUnits = new ArrayList<>();

        for (String storageUnit : this.facility.keySet()) {
            if (!(storageUnit.isEmpty())) {
                storageUnits.add(storageUnit);
            }
        }

        return storageUnits;

    }
}
