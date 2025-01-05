package windows.panels.gamePanel.components;

import audio.Sound;
import audio.SoundType;
import windows.MainFrame;
import java.util.ArrayList;

public class SoundComponent {
    private final ArrayList<Sound> damageSounds = new ArrayList<>();
    private Sound deathSound;
    private final MainFrame mainframe;

    public SoundComponent(MainFrame mainframe) {
        this.mainframe = mainframe;
    }

    public void addDamageSound(Sound sound) {
        damageSounds.add(sound);
    }

    public void addDeathSound(Sound sound) {
        deathSound = sound;
    }

    public void playDamageSound() {
        if(!damageSounds.isEmpty()){
            int randomIndex = (int) (Math.random() * damageSounds.size());
            mainframe.playSound(damageSounds.get(randomIndex));
        }
    }

    public void playDeathSound(){
        mainframe.playSound(deathSound);
    }

}
