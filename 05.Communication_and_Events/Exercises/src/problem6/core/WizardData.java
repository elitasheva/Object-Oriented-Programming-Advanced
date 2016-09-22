package problem6.core;


import problem6.interfaces.Data;
import problem6.interfaces.Wizard;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class WizardData implements Data {

    private static WizardData instance = new WizardData();
    private static HashMap<Integer, Wizard> wizardData = new LinkedHashMap<>();

    public static Data getInstance() {
        return instance;
    }

    @Override
    public Wizard getWizard(int id) {
        return wizardData.get(id);
    }

    @Override
    public void addWizard(Wizard wizard) {
        wizardData.put(wizard.getId(), wizard);
    }

    @Override
    public void removeWizard(Wizard wizard) {
        wizardData.remove(wizard.getId());
    }
}
