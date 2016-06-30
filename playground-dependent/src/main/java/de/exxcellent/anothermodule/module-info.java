module anothermodule {
    exports de.exxcellent.anothermodule;
    requires de.exxcellent.java9;

    // Provide Service instance (SPI with Jigsaw modules)
    provides de.exxcellent.java9.jigsaw.spi.BillingServiceProvider
    with de.exxcellent.anothermodule.spi.MastercardBillingServiceProvider;
}