package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/emu.properties"})
public interface EmuConfig extends Config {

    @Config.Key("appPackage")
    String appPackage();

    @Config.Key("appActivity")
    String appActivity();

    @Config.Key("serverUrl")
    String serverUrl();

    @Config.Key("appUrl")
    String appUrl();

    @Config.Key("appPath")
    String appPath();

}