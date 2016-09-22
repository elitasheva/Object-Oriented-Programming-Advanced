package problem6.interfaces;

public interface Wizard extends Subject, Listener, Nameable, Identifiable, Caster {
    int getReflectionsCount();
}
