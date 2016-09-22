package problem10.core;

import problem10.models.Weapon;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Database {

    private HashMap<String, Weapon> weaponsByName;

    public Database() {
        this.weaponsByName = new LinkedHashMap<>();
    }

    public void addWeapon(String name, Weapon weapon){
        if (this.weaponsByName.containsKey(name)){
            throw new IllegalArgumentException();
        }
        this.weaponsByName.put(name, weapon);
    }

    public void removeWeapon(Weapon weapon){
        if (!this.weaponsByName.containsKey(weapon.getName())){
            throw new IllegalArgumentException();
        }
        this.weaponsByName.remove(weapon.getName());
    }

    public Weapon getWeaponByName(String name){
        if (!this.weaponsByName.containsKey(name)){
            throw new IllegalArgumentException();
        }
        return this.weaponsByName.get(name);
    }
}
