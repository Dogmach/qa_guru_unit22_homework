package config;

import org.aeonbits.owner.ConfigFactory;

public class Credentials {
    public static BrowserstackConfig configBro = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    public static EmuConfig configEmu = ConfigFactory.create(EmuConfig.class, System.getProperties());
}