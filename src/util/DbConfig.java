package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public final class DbConfig {
    private DbConfig() {
    }

    public static Connection getConnection(String envFilePath)
            throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = getSetting("DB_URL", envFilePath);
        String user = getSetting("DB_USER", envFilePath);
        String password = getSetting("DB_PASSWORD", envFilePath);

        return DriverManager.getConnection(url, user, password);
    }

    private static String getSetting(String key, String envFilePath) throws IOException {
        String value = System.getenv(key);
        if (value != null && !value.trim().isEmpty()) {
            return value.trim();
        }

        value = System.getProperty(key);
        if (value != null && !value.trim().isEmpty()) {
            return value.trim();
        }

        Map<String, String> envValues = loadEnvFile(envFilePath);
        value = envValues.get(key);
        if (value != null && !value.trim().isEmpty()) {
            return value.trim();
        }

        throw new IllegalStateException("Missing required setting: " + key);
    }

    private static Map<String, String> loadEnvFile(String envFilePath) throws IOException {
        Map<String, String> values = new HashMap<String, String>();
        if (envFilePath == null) {
            return values;
        }

        File envFile = new File(envFilePath);
        if (!envFile.isFile()) {
            return values;
        }

        BufferedReader reader = new BufferedReader(new FileReader(envFile));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                int separatorIndex = line.indexOf('=');
                if (separatorIndex <= 0) {
                    continue;
                }

                String key = line.substring(0, separatorIndex).trim();
                String value = line.substring(separatorIndex + 1).trim();
                values.put(key, value);
            }
        } finally {
            reader.close();
        }

        return values;
    }
}
