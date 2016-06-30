package de.exxcellent.anothermodule;

import de.exxcellent.java9.collections.ImmutableCollections;

/**
 * Test module encapsulation
 */
public class TestModuleEncapuslation {

    public static void main(String[] args) {
        ImmutableCollections.main(args);

        // Would break, as it is not exported. Though it's public!
        // de.exxcellent.java9.util.InputStreamExample.main(args);
    }

}
