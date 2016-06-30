package de.exxcellent.java9.jigsaw;

import java.util.Iterator;
import java.util.ServiceLoader;
import de.exxcellent.java9.jigsaw.spi.BillingServiceProvider;

public abstract class BillingService {

    protected BillingService() {
    }

    public static BillingService getInstance() {
        // Java SPI to find the instance
        ServiceLoader<BillingServiceProvider> sl = ServiceLoader.load(BillingServiceProvider.class);

        // Fetch first provider implementation
        Iterator<BillingServiceProvider> providerIterator = sl.iterator();
        if (!providerIterator.hasNext()) {
            throw new RuntimeException("No service providers found!");
        }

        BillingServiceProvider provider = providerIterator.next();

        return provider.buildBillingService();
    }

    public abstract String takeMoney();
}
