package de.exxcellent.java9.util;

import java.util.List;
import java.util.stream.Collectors;
import static java.lang.System.out;

public class StackWalkerExample {

    public static void main(String[] args) {
        walkAndFilterStackframe().forEach(out::println);
    }

    private static List<String> walkAndFilterStackframe() {
        return StackWalker.getInstance().walk(s ->
                s.map( frame -> frame.getClassName()+"/"+frame.getMethodName() )
                        .filter(name -> name.startsWith("de.exxcellent"))
                        .limit(10)
                        .collect(Collectors.toList())
            );
    }

}