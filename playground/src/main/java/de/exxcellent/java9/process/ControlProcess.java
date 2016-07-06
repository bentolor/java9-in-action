package de.exxcellent.java9.process;

import java.io.IOException;
import static java.lang.System.out;

public class ControlProcess {

    /**
     * Start a process, listen to process termination, retrieve process details, kill processes.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Process sleeper = Runtime.getRuntime().exec("sleep 1h");

        // Get PIDs of own or started processes
        out.println("Your pid is " + ProcessHandle.current().getPid());
        out.println("Started process is " + sleeper.getPid());

        ProcessHandle sleeperHandle = ProcessHandle.of(sleeper.getPid())   // Optional
                .orElseThrow(IllegalStateException::new);

        // Do things on exiting process
        sleeperHandle.onExit().thenRun(                                    // CompletableFuture
                () -> out.println("Sleeper exited")
        );

        // Get info on process
        out.printf("[%d] %s - %s\n",
                   sleeperHandle.getPid(),
                   sleeperHandle.info().user().orElse("unknown"),
                   sleeperHandle.info().commandLine().orElse("none"));

        // Kill a process
        sleeperHandle.destroy();

        // Give exit handler a chance to see the sleeper onExit()
        Thread.sleep(99);
    }
}



