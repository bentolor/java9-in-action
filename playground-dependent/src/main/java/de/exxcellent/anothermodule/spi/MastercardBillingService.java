package de.exxcellent.anothermodule.spi;

import de.exxcellent.java9.jigsaw.BillingService;

class MastercardBillingService extends BillingService {

    @Override
    public String takeMoney() {
        return "Mastercard billed the money!";
    }
}