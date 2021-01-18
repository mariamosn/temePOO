package producer;

import distributor.Distributor;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public final class Energy extends Observable {
    private int energyPerDistributor;
    private List<Distributor> distributors;

    public Energy(int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
        distributors = new ArrayList<>();
    }

    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    /**
     * Setter for the energyPerDistributor field, used to apply the monthly updates
     * provided in the input; because Energy extends Observable and the event that's
     * observed is represented by the modification of the energyPerDistributor, this
     * method is also responsible for notifying the observers.
     * @param energyPerDistributor = new value of energyPerDistributor field
     */
    public void setEnergyPerDistributor(int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
        setChanged();
        notifyObservers(energyPerDistributor);
    }

    public List<Distributor> getDistributors() {
        return distributors;
    }
}
