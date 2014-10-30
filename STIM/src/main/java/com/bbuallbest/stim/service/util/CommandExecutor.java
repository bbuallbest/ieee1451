package com.bbuallbest.stim.service.util;

import java.io.IOException;

/**
 * Created by happy on 22/10/2014.
 */
public class CommandExecutor {

    private Runtime runtime = Runtime.getRuntime();

    public void execute(String command) throws IOException {
        runtime.exec(command);
    }
}
