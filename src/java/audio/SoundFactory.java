package audio;

public abstract class SoundFactory {
    //Bitbasic - Please Mind the Dubstep.mp3
    //Bitbasic - Some sort of thrive.mp3
    //Brylie Christopher Oxley - Ethereal Cafe.mp3
    //HoliznaCC0 - Pixel Party.mp3

    public static Sound getMenuSound1() {
        return new Sound( SoundType.BACKGROUND_MUSIC, "Bitbasic - Please Mind the Dubstep.wav",
                "resources/sounds/Bitbasic - Please Mind the Dubstep.wav", true);
    }

    public static Sound getMenuSound2() {
        return new Sound( SoundType.BACKGROUND_MUSIC,"Bitbasic - Some sort of thrive.wav",
                "resources/sounds/Bitbasic - Some sort of thrive.wav", true);
    }

    public static Sound getMenuSound3() {
        return new Sound( SoundType.BACKGROUND_MUSIC, "Brylie Christopher Oxley - Ethereal Cafe.wav",
                "resources/sounds/Brylie Christopher Oxley - Ethereal Cafe.wav", true);
    }

    public static Sound getMenuSound4() {
        return new Sound( SoundType.BACKGROUND_MUSIC, "HoliznaCC0 - Pixel Party.wav",
                "resources/sounds/HoliznaCC0 - Pixel Party.wav", true);
    }
}
