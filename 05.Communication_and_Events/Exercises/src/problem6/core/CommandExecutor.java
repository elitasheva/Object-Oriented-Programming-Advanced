package problem6.core;


import problem6.enums.SpellType;
import problem6.factories.SpellFactory;
import problem6.interfaces.Executable;
import problem6.interfaces.Spell;
import problem6.interfaces.Wizard;
import problem6.interfaces.Writer;

public class CommandExecutor implements Executable {

    private Writer writer;

    public CommandExecutor(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void execute(String[] params) {

        int wizardId = Integer.parseInt(params[0]);
        SpellType spellType = SpellType.valueOf(params[1]);

        Wizard wizard = WizardData.getInstance().getWizard(wizardId);
        Spell spellToCast = SpellFactory.createSpell(wizard,spellType);

        wizard.cast(spellToCast);

    }
}
