package com.bbuallbest.stim.listener;

import com.bbuallbest.stim.service.util.CommandExecutor;
import com.bbuallbest.stim.util.Command;
import com.bbuallbest.stim.util.Path;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebListener
public class KernelModuleLoader implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            loadModules();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}

    private void loadModules() throws IOException {
        Properties properties = getPropertiesByFileName(Path.COMMAND_PROPERTIES.getPath());

        CommandExecutor executor = new CommandExecutor();

        executor.execute(properties.getProperty(Command.MODPROBE_GPIO.getProperty()));
        executor.execute(properties.getProperty(Command.MODPROBE_THERM.getProperty()));
    }

    private Properties getPropertiesByFileName(String fileName) throws IOException {
        Properties properties = new Properties();
        InputStream fileStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(fileName);
//        properties.load(new FileInputStream(fileName));
        properties.load(fileStream);
        return properties;
    }
}
