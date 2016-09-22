package problem6.core;

import problem6.factories.IdProvider;
import problem6.interfaces.Executable;
import problem6.interfaces.Reader;
import problem6.interfaces.Runnable;
import problem6.interfaces.Wizard;
import problem6.models.WizardImpl;


import java.io.IOException;

public class Engine implements Runnable {

    private Reader reader;
    private Executable executor;

    public Engine(Reader reader, Executable executor) {
        this.reader = reader;
        this.executor = executor;
    }

    @Override
    public void run() throws IOException {
        createRootWizard();

        String[] input = this.reader.readLine().split("[\\s]+");

        while (!input[0].equals("END")) {
            this.executor.execute(input);
            input = this.reader.readLine().split("[\\s]+");
        }
    }

    private void createRootWizard() throws IOException {
        String[] wizardParams = this.reader.readLine().split("[\\s]+");
        String wizardName = wizardParams[0];
        int wizardPower = Integer.parseInt(wizardParams[1]);

        Wizard wizard = new WizardImpl(IdProvider.next(), wizardName, wizardPower);
        WizardData.getInstance().addWizard(wizard);

    }
}
