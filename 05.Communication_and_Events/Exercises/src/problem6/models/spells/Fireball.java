package problem6.models.spells;

import problem6.enums.SpellType;
import problem6.interfaces.Wizard;

public class Fireball extends AbstractSpell {

    public Fireball(Wizard source, SpellType spellType) {
        super(source, spellType);
    }

    @Override
    public void cast() {
        String sourceWizard = this.getSource().toString();
        int spellDamage = this.getSource().getPower();
        System.out.println(String.format("%s casts Fireball for %s damage", sourceWizard, spellDamage));
    }
}
