package pr0304Barracks.core.commands;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

public class AddCommand extends Command implements Executable {

    @Inject
    private Repository unitRepository;
    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.addUnitCommand(this.getData());
    }

    private String addUnitCommand(String[] data) {
        String unitType = data[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.unitRepository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
