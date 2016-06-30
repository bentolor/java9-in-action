package de.exxcellent.anothermodule;

import de.exxcellent.java9.jigsaw.BillingService;
import static java.lang.System.out;

public class TestJigsawSPI {

    public static void main(String[] args) {
        BillingService s = BillingService.getInstance();
        out.println(s.takeMoney());
    }
}