package settings;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SettingsManager {
    private static final String SETTINGS_FILE = "settings.properties";
    private static SettingsManager instance;
    private final Properties properties;

    public static synchronized SettingsManager getInstance() {
        if (instance == null) {
            instance = new SettingsManager();
        }
        return instance;
    }

    private SettingsManager(){
        properties = new Properties();
    }

    public void saveResolution(int width, int height) {
        properties.setProperty("width", String.valueOf(width));
        properties.setProperty("height", String.valueOf(height));
        try {
            properties.store(new FileOutputStream(SETTINGS_FILE), null);
        } catch (IOException e) {
            System.err.println("Failed to save settings: " + e.getMessage());
        }
    }

    public Dimension getSavedResolution() {
        try (FileInputStream fis = new FileInputStream(SETTINGS_FILE)) {
            properties.load(fis);
            int width = Integer.parseInt(properties.getProperty("width", "1280")); // Default width
            int height = Integer.parseInt(properties.getProperty("height", "720")); // Default height
            return new Dimension(width, height);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Failed to load settings: " + e.getMessage());
            return new Dimension(1280, 720); // default
        }
    }

    public void saveFullScreen(boolean isFullScreen) {
        properties.setProperty("fullscreen", String.valueOf(isFullScreen));
        try {
            properties.store(new FileOutputStream(SETTINGS_FILE), null);
        } catch (IOException e) {
            System.err.println("Failed to save settings: " + e.getMessage());
        }
    }

    public boolean getSavedFullScreen() {
        try (FileInputStream fis = new FileInputStream(SETTINGS_FILE)) {
            properties.load(fis);
            return Boolean.parseBoolean(properties.getProperty("fullscreen", "false")); // Default false
        } catch (IOException e) {
            System.err.println("Failed to load settings: " + e.getMessage());
            return false; // default
        }
    }

    public void saveMasterVolume(int volume){
        properties.setProperty("masterVolume", String.valueOf(volume));
        try {
            properties.store(new FileOutputStream(SETTINGS_FILE), null);
        } catch (IOException e) {
            System.err.println("Failed to save settings: " + e.getMessage());
        }
    }

    public int getSavedMasterVolume(){
        try (FileInputStream fis = new FileInputStream(SETTINGS_FILE)) {
            properties.load(fis);
            return Integer.parseInt(properties.getProperty("masterVolume", "50")); // Default 100
        } catch (IOException | NumberFormatException e) {
            System.err.println("Failed to load settings: " + e.getMessage());
            return 50; // default
        }
    }

    public void saveMusicVolume(int volume){
        properties.setProperty("musicVolume", String.valueOf(volume));
        try {
            properties.store(new FileOutputStream(SETTINGS_FILE), null);
        } catch (IOException e) {
            System.err.println("Failed to save settings: " + e.getMessage());
        }
    }

    public int getSavedMusicVolume(){
        try (FileInputStream fis = new FileInputStream(SETTINGS_FILE)) {
            properties.load(fis);
            return Integer.parseInt(properties.getProperty("musicVolume", "50")); // Default 100
        } catch (IOException | NumberFormatException e) {
            System.err.println("Failed to load settings: " + e.getMessage());
            return 50; // default
        }
    }

    public void saveEffectVolume(int volume){
        properties.setProperty("soundVolume", String.valueOf(volume));
        try {
            properties.store(new FileOutputStream(SETTINGS_FILE), null);
        } catch (IOException e) {
            System.err.println("Failed to save settings: " + e.getMessage());
        }
    }

    public int getSavedEffectVolume(){
        try (FileInputStream fis = new FileInputStream(SETTINGS_FILE)) {
            properties.load(fis);
            return Integer.parseInt(properties.getProperty("soundVolume", "50")); // Default 100
        } catch (IOException | NumberFormatException e) {
            System.err.println("Failed to load settings: " + e.getMessage());
            return 50; // default
        }
    }

}
