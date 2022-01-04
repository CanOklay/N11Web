package com.n11.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private final Properties properties;

    public ConfigFileReader(){
        BufferedReader reader;
        String propertyFilePath = "src/main/configuration/configs.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configs.properties not found at " + propertyFilePath);
        }
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if(browser != null) return browser;
        else throw new RuntimeException("Browser not specified in the configs.properties file.");
    }

    public long getImplicityWait() {
        String implicityWait = properties.getProperty("implicityWait");
        if(implicityWait != null) return Long.parseLong(implicityWait);
        else throw new RuntimeException("ImplicitlyWait not specified in the configs.properties file.");
    }

    public long getPageLoadTimeout() {
        String pageLoadTimeout = properties.getProperty("pageLoadTimeout");
        if(pageLoadTimeout != null) return Long.parseLong(pageLoadTimeout);
        else throw new RuntimeException("PageLoadTimeout not specified in the configs.properties file.");
    }

    public String getBaseUrl() {
        String url = properties.getProperty("baseUrl");
        if(url != null) return url;
        else throw new RuntimeException("Url not specified in the configs.properties file.");
    }

    public String getRemoteUrl() {
        String remoteUrl = properties.getProperty("remoteUrl");
        if(remoteUrl != null) return remoteUrl;
        else throw new RuntimeException("Url not specified in the configs.properties file.");
    }

    public String getEnv() {
        String environment = properties.getProperty("environment");
        if(environment != null) return environment;
        else throw new RuntimeException("Url not specified in the configs.properties file.");
    }
}
