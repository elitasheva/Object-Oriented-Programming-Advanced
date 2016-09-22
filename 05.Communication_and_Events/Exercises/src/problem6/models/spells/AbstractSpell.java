package problem6.models.spells;

import problem6.enums.SpellType;
import problem6.interfaces.Event;
import problem6.interfaces.Spell;
import problem6.interfaces.Wizard;

public abstract class AbstractSpell implements Spell, Event {

    private Wizard source;
    private SpellType spellType;

    public AbstractSpell(Wizard source, SpellType spellType) {
        this.source = source;
        this.spellType = spellType;
    }

    @Override
    public SpellType getSpellType() {
        return this.spellType;
    }

    @Override
    public Wizard getSource() {
        return this.source;
    }

    @Override
    public abstract void cast();
}
