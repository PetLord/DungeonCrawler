package windows.panels.gamePanel;

import windows.panels.HUD.HUDPanel;
import windows.panels.gamePanel.components.GraphicsComponent;
import windows.panels.gamePanel.entities.Entity;
import windows.panels.gamePanel.entities.characters.Character;
import factories.PlayerFactory;
import windows.panels.gamePanel.entities.characters.Player;
import windows.panels.gamePanel.entities.structures.Room;
import windows.panels.gamePanel.entities.structures.Tile;
import windows.panels.gamePanel.entities.structures.worldMap.ProceduralMazeStrategy;
import windows.panels.gamePanel.entities.structures.worldMap.WorldMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GameWorld {
    private int worldHeight;
    private int worldWidth;
    private final GamePanel gamePanel;
    private final WorldMap worldMap;
    private final Player player;
    private final HUDPanel hudPanel = new HUDPanel();

    public GameWorld(GamePanel gamepanel, int width, int height) {
        this.gamePanel = gamepanel;
        this.worldWidth = width;
        this.worldHeight = height;

        worldMap = new WorldMap(this, 3, 3, new ProceduralMazeStrategy());
        player = PlayerFactory.createDefaultPlayer(gamePanel, this, this.getCurrentRoom());

        getCurrentRoom().addCharacter(player);
        gamepanel.startGameThread();
    }

    public void render(Graphics2D g2){
        if(getCurrentRoom() == null){
            System.out.println("Current room is null");
            return;
        }
        getCurrentRoom().render(g2);

        ArrayList<Character> characters = new ArrayList<>(getCurrentRoom().getAllCharacters());
        characters.sort(Comparator.comparingInt(Entity::getY));

        for (Character character :characters) {
            if (character.hasComponent(GraphicsComponent.class)) {
                character.render(g2);
            }
        }

        hudPanel.updateHealth(getPlayer().getCurrentHealth(), getPlayer().getStats().getMaxHealth());
        hudPanel.render(g2);
    }


    public Room getCurrentRoom() {
        return worldMap.getCurrentRoom();
    }

    public double getCurrentWidthScale() {
        return (double) getCurrentRoom().getTileWidth() / Tile.getDefaultTileWidth();
    }

    public double getCurrentHeightScale() {
        return (double) getCurrentRoom().getTileHeight() / Tile.getDefaultTileHeight();
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public Player getPlayer() {
        return player;
    }

    public void setDimensions(int width, int height) {
        worldWidth = width;
        worldHeight = height;
        Room[][] roomGrid = worldMap.getRoomGrid();
        Arrays.stream(roomGrid).flatMap(Arrays::stream).forEach(room -> {
            room.setWidth(width);
            room.setHeight(height);
        });
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public int getOffsetX() {
        return gamePanel.getOffsetX();
    }

    public int getOffsetY() {
        return gamePanel.getOffsetY();
    }
}
