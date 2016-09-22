package problem8.models;

import problem8.interaces.ISpecialisedSoldier;

public abstract class SpecialisedSoldier extends Private implements ISpecialisedSoldier{

    private String corps;

    protected SpecialisedSoldier(String id,
                                 String firstName,
                                 String lastName,
                                 double salary,
                                 String corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + String.format("Corps: %s",this.corps);
    }
}
