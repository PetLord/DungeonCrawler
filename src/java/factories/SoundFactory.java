package factories;

import audio.Sound;
import audio.SoundType;

import java.util.Random;

public abstract class SoundFactory {
    //Bitbasic - Please Mind the Dubstep.mp3
    //Bitbasic - Some sort of thrive.mp3
    //Brylie Christopher Oxley - Ethereal Cafe.mp3
    //HoliznaCC0 - Pixel Party.mp3

    public static Sound getMenuSound1() {
        return new Sound( SoundType.BACKGROUND_MUSIC, "Bitbasic - Please Mind the Dubstep.wav",
                "resources/sounds/music/Bitbasic - Please Mind the Dubstep.wav", true);
    }

    public static Sound getMenuSound2() {
        return new Sound( SoundType.BACKGROUND_MUSIC,"Bitbasic - Some sort of thrive.wav",
                "resources/sounds/music/Bitbasic - Some sort of thrive.wav", true);
    }

    public static Sound getMenuSound3() {
        return new Sound( SoundType.BACKGROUND_MUSIC, "Brylie Christopher Oxley - Ethereal Cafe.wav",
                "resources/sounds/music/Brylie Christopher Oxley - Ethereal Cafe.wav", true);
    }

    public static Sound getMenuSound4() {
        return new Sound( SoundType.BACKGROUND_MUSIC, "HoliznaCC0 - Pixel Party.wav",
                "resources/sounds/music/HoliznaCC0 - Pixel Party.wav", true);
    }

    public static Sound getRandomMenuMusic(){
        Random random = new Random();
        return switch (random.nextInt(4)) {
            default -> getMenuSound1();
            case 1 -> getMenuSound2();
            case 2 -> getMenuSound3();
            case 3 -> getMenuSound4();
        };
    }

    public static Sound getButtonClickSound() {
        return new Sound( SoundType.BUTTON_CLICK, "button_click.wav",
                "resources/sounds/effects/buttonClick.wav", false);
    }

    public static Sound getSlimeDamage1Sound() {
        return new Sound( SoundType.SLIME_DAMAGE1, "slime_damage1.wav",
                "resources/sounds/effects/slime/slimeDamage1.wav", false);
    }

    public static Sound getSlimeDamage2Sound() {
        return new Sound( SoundType.SLIME_DAMAGE2, "slime_damage2.wav",
                "resources/sounds/effects/slime/slimeDamage2.wav", false);
    }

    public static Sound getSlimeDamage3Sound() {
        return new Sound( SoundType.SLIME_DAMAGE3, "slime_damage3.wav",
                "resources/sounds/effects/slime/slimeDamage3.wav", false);
    }

    public static Sound getSlimeDeathSound() {
        return new Sound( SoundType.SLIME_DEATH, "slime_death.wav",
                "resources/sounds/effects/slime/slimeDeath.wav", false);
    }

    public static Sound getPlayerDamageSound() {
        return new Sound( SoundType.PLAYER_DAMAGE, "player_damage.wav",
                "resources/sounds/effects/player/playerDamage.wav", false);
    }
}
