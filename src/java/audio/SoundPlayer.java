package audio;

import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SoundPlayer {
    private final Map<SoundType, Sound> soundCache;
    private final JSlider musicSlider;
    private final JSlider soundSlider;
    private final JSlider masterSlider;
    private float musicVolume;
    private float soundVolume;
    private float masterVolume;

    public SoundPlayer(JSlider musicSlider, JSlider soundSlider, JSlider masterSlider) {
        soundCache = new ConcurrentHashMap<>();
        this.musicSlider = musicSlider;
        this.soundSlider = soundSlider;
        this.masterSlider = masterSlider;
        musicVolume = musicSlider.getValue();
        soundVolume = soundSlider.getValue();
        masterVolume = masterSlider.getValue();
    }

    // Plays the sound, loading it if necessary
    public void playSound(Sound sound) {
        if(sound == null) {
            return;
        }

        if(soundCache.containsKey(sound.getSoundType())) {
            soundCache.get(sound.getSoundType()).stop();
            soundCache.remove(sound.getSoundType());
        }

        soundCache.put(sound.getSoundType(), sound);
        new Thread(sound::play).start();
    }

    // Stops a currently playing sound
    public void stopSound(SoundType type) {
        Sound sound = soundCache.get(type);
        if (sound != null) {
            sound.stop();
        }
    }

    // Optionally unload a sound if it's no longer needed
    public void unloadSound(SoundType type) {
        Sound sound = soundCache.remove(type);
        if (sound != null) {
            sound.stop(); // Ensure the sound is stopped before unloading
        }
    }

    public void stopAllSounds() {
        soundCache.values().forEach(Sound::stop);
    }

    public void unloadAllSounds() {
        stopAllSounds();
        soundCache.clear();
    }

    public void updateVolumes() {
        musicVolume = musicSlider.getValue() / 100f;
        soundVolume = soundSlider.getValue() / 100f;
        masterVolume = masterSlider.getValue() / 100f;

        setMusicVolume(musicVolume * masterVolume);
        setSoundVolume(soundVolume * masterVolume);
    }

    public void setMusicVolume(float volume) {
        soundCache.get(SoundType.BACKGROUND_MUSIC).setVolume(volume);
    }

    public void setSoundVolume(float volume) {
        soundCache.values().stream().
                filter(sound -> sound.getSoundType() != SoundType.BACKGROUND_MUSIC)
                .forEach(sound -> sound.setVolume(volume));
    }
}
