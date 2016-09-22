package problem6.factories;

import problem6.enums.SpellType;
import problem6.interfaces.Spell;
import problem6.interfaces.Wizard;
import problem6.models.spells.Fireball;
import problem6.models.spells.Reflection;

public class SpellFactory {

    public static Spell createSpell(Wizard source, SpellType spellType){
        switch (spellType){
            case REFLECTION:
                return new Reflection(source, spellType);
            case FIREBALL:
                return new Fireball(source, spellType);
            default:
                throw new IllegalArgumentException("Illegal spell type");
        }
    }
}
