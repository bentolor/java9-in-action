package de.exxcellent.java9.jigsaw.spi;

import de.exxcellent.java9.jigsaw.BillingService;

public abstract class BillingServiceProvider {

    public abstract BillingService buildBillingService();
}