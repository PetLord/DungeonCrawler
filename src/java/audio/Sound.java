package audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    private final SoundType soundType;
    private FloatControl volumeControl;
    private final String name;
    private final boolean loop;
    private Clip clip;

    public Sound(SoundType soundType, String name, String path, boolean loop) {
        this.soundType = soundType;
        this.name = name;
        this.loop = loop;
        loadClip(path);
    }

    private void loadClip(String path) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(20 * (float) Math.log10(0.25));
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            System.err.println("Failed to load sound: " + soundType.toString() + " " + name);
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip == null) {return;}

        clip.setFramePosition(0);
        clip.start();
        if (loop) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public SoundType getSoundType() {
        return soundType;
    }

    public String getName() {
        return name;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setVolume(float volume) {
        if (volumeControl == null) {
            System.err.println("Volume control not supported for sound: " + name);
            return;
        }

        volume = Math.max(0.0f, Math.min(1.0f, volume));

        float dB;
        if (volume <= 0) {
            dB = volumeControl.getMinimum();
        }
        else {
            dB = 20 * (float) Math.log10(volume);
            dB = Math.max(volumeControl.getMinimum(), Math.min(volumeControl.getMaximum(), dB));
        }

        volumeControl.setValue(dB);
    }


}

