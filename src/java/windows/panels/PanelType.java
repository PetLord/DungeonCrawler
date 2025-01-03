package windows.panels;

public enum PanelType {
    MAIN_MENU,
    OPTIONS_MENU,
    GAME,
    GAME_OVER;

    @Override
    public String toString() {
        return name().toLowerCase(); // Converts to "main_menu" or "game"
    }
}
