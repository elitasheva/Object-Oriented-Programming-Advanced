package problem6.factories;

import problem6.interfaces.Wizard;
import problem6.models.WizardImpl;

public class WizardFactory {
    public static Wizard createReflection(String name, int power){
        return new WizardImpl(IdProvider.next(), name, power);
    }
}
