package de.exxcellent.anothermodule;

import java.io.IOException;
import java.io.InputStream;
import java.lang.module.ModuleDescriptor;
import static java.lang.System.out;

public class RetrieveModuleInfo {

    /**
     * Show module infos
     */
    public static void main(String[] args) throws IOException {
        ModuleDescriptor descriptor = RetrieveModuleInfo.class.getModule().getDescriptor();

        if (descriptor == null) {
            out.println("JVM started without '-mp' option. Trying to load module-info manually...");
            descriptor = readModuleDescriptorFromBytecode();
        }

        printModule(descriptor);
    }

    static void printModule(ModuleDescriptor descriptor) {
        out.println("Module " + descriptor.name());
        descriptor.exports().forEach(
                export -> out.println("\texports " + export.source())
        );
        descriptor.requires().forEach(
                requires -> out.println("\trequires " + requires.name() + " " + requires.modifiers())
        );
    }

    static ModuleDescriptor readModuleDescriptorFromBytecode() throws IOException {
        InputStream moduleInfo = RetrieveModuleInfo.class.getClassLoader().getResourceAsStream("module-info.class");
        return ModuleDescriptor.read(moduleInfo);
    }


}