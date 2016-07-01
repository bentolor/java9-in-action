package de.exxcellent.java9.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.lang.System.*;

public class ImmutableCollections {

    /**
     * Create immutable collections on the fly.
     * <b>Note:</b> They do not accept {@code null} or duplicate entries (Set/Map)
     */
    public static void main(String args[]) {
        List<Integer> listOfNumbers = List.of(1, 2, 3, 4, 5/*, null*/);
        out.println(listOfNumbers);

        Set<Integer> setOfNumbers = Set.of(1, 2, 3, 4, 5/*, 1*/);
        out.println(setOfNumbers);

        Map<String, String> mapOfString = Map.of("key1", "value1", "key2", "value2");
        out.println(mapOfString);

        Map<String, String> moreMapOfString = Map.ofEntries(
                Map.entry("key1", "value1"),
                Map.entry("key2", "value2")/*,
                Map.entry("key1", "value3")*/
        );
        out.println(moreMapOfString);
    }
}