package audio;

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
}
