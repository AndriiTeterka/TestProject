package Utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();
    String URL = readConfig().getString("url");
    String USER_NAME = readConfig().getString("userCredentials.userName");
    String PASSWORD = readConfig().getString("userCredentials.password");

    static Config readConfig() {
        return ConfigFactory.load("testData.conf");
    }
}
