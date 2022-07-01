package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/browserstack.properties"})
public interface BrowserstackConfig extends Config {

    @Config.Key("user")
    String user();

    @Config.Key("key")
    String key();

    @Config.Key("app")
    String app();

    @Config.Key("url")
    String url();
}