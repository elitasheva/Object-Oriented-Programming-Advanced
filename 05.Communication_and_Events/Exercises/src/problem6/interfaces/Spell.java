package problem6.interfaces;

import problem6.enums.SpellType;

public interface Spell extends Event{
    void cast();
    SpellType getSpellType();
}
