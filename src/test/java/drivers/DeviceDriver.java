package drivers;

public class DeviceDriver {
    public static String getDeviceDriver(String device) {

        switch (device) {
            case "browserstack":
                return BrowserstackMobileDriver.class.getName();

            case "real":
            case "emulator":
                return EmulatorMobileDriver.class.getName();

            default:
                throw new RuntimeException("Select device: browserstack / emulator / real");
        }
    }
}