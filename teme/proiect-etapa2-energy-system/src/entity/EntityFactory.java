package entity;

import consumer.Consumer;
import distributor.Distributor;
import input.ConsumerInput;
import input.DistributorInput;
import input.ProducerInput;
import producer.Producer;

/**
 * The class is used to implement the Factory pattern
 */
public final class EntityFactory {
    private static EntityFactory instance = null;

    private EntityFactory() {
    }

    /**
     * Getter for the instance of the Singleton
     * @return - the Singleton instance
     */
    public static EntityFactory getInstance() {
        if (instance == null) {
            instance = new EntityFactory();
        }
        return instance;
    }

    /**
     * Creates a new entity based on the type provided
     * @param type - the type of entity wanted (consumer or distributor)
     * @param input - the original input object based on which the new entity will be created
     * @return - the new entity
     */
    public Entity createEntity(final String type, final Object input) {
        if (type.equals("consumer")) {
            return new Consumer((ConsumerInput) input);
        } else if (type.equals("distributor")) {
            return new Distributor((DistributorInput) input);
        } else if (type.equals("producer")) {
            return new Producer((ProducerInput) input);
        }
        return null;
    }
}
