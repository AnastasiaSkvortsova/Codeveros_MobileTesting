package utilities;

import cucumber.runtime.java.picocontainer.PicoFactory;

public class CustomPicoFactory extends PicoFactory {
    public CustomPicoFactory() {

        if (System.getProperty("device") != null) {
            switch (System.getProperty("device").toUpperCase()) {
                case "CHROME":
                    addClass(ChromeController.class);
                    break;
                case "FIREFOX":
                    addClass(FirefoxController.class);
                    break;
                case "MOBILE":
                    addClass(AndroidController.class);
                    break;
                default:
                    addClass(ChromeController.class);
            }
        }
    }
}
