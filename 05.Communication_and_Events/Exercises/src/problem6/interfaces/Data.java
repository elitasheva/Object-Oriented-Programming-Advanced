package problem6.interfaces;

public interface Data {
    Wizard getWizard(int id);
    void addWizard(Wizard wizard);
    void removeWizard(Wizard wizard);
}
