package de.exxcellent.java9.process;

import java.io.IOException;
import static java.lang.System.out;

public class ControlProcess {

    public static void main(String[] args) throws IOException, InterruptedException {
        Process sleeper = Runtime.getRuntime().exec("sleep 1h");

        // Get PIDs of own or started processes
        out.println("Your pid is " + ProcessHandle.current().getPid());
        out.println("Started process is " + sleeper.getPid());

        ProcessHandle handle = ProcessHandle.of(sleeper.getPid()).orElseThrow(IllegalStateException::new);

        // Do things on exiting process
        handle.onExit().thenRun( // CompletableFuture
                () -> out.println("Sleeper exited")
        );

        // Get info on process
        out.printf("[%d] %s - %s\n",
                   handle.getPid(),
                   handle.info().user().orElse("unknown"),
                   handle.info().commandLine().orElse("none"));

        // Wait for process termination
        ProcessHandle.of(sleeper.getPid()).ifPresent(
                process -> process.onExit().thenRun(
                        () -> out.println("Sleeper exited")
                )
        );

        // Kill a process
        ProcessHandle.of(sleeper.getPid()).ifPresent(ProcessHandle::destroy);

        // Give exit handler a chance to see the sleeper onExit()
        Thread.sleep(99);
    }
}



