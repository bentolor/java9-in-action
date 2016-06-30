package de.exxcellent.anothermodule.spi;

import de.exxcellent.java9.jigsaw.BillingService;
import de.exxcellent.java9.jigsaw.spi.BillingServiceProvider;

public class MastercardBillingServiceProvider extends BillingServiceProvider {

    @Override
    public BillingService buildBillingService() {
        return new MastercardBillingService();
    }
}