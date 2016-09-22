package problem6.models.spells;

import problem6.core.WizardData;
import problem6.enums.SpellType;
import problem6.factories.WizardFactory;
import problem6.interfaces.Data;
import problem6.interfaces.Wizard;

public class Reflection extends AbstractSpell {

    private static final int REFLECTION_POWER_DIVIDER = 2;

    public Reflection(Wizard source, SpellType spellType) {
        super(source, spellType);
    }

    @Override
    public void cast() {

        Wizard source = this.getSource();
        int power = this.getSource().getPower();

        for (int i = 0; i < 2; i++) {
            if (this.getSource().getReflectionsCount() < 2) {
                Wizard reflection = WizardFactory.createReflection(source.getName(), power / REFLECTION_POWER_DIVIDER);

                this.addReflectionToData(reflection);
                this.getSource().addListener(reflection);
            }

        }
        System.out.println(String.format("%s casts Reflection", source.toString()));
    }

    public void addReflectionToData(Wizard reflection) {
        Data data = WizardData.getInstance();
        data.addWizard(reflection);
    }
}
