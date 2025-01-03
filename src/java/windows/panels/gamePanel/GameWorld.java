package windows.panels.gamePanel;

import windows.panels.gamePanel.components.GraphicsComponent;
import windows.panels.gamePanel.entities.Entity;
import windows.panels.gamePanel.entities.characters.Character;
import windows.panels.gamePanel.entities.characters.enemies.Slime;
import windows.panels.gamePanel.entities.structures.MobSpawnLocation;
import windows.panels.gamePanel.factories.EnemyFactory;
import windows.panels.gamePanel.factories.PlayerFactory;
import windows.panels.gamePanel.factories.RoomFactory;
import windows.panels.gamePanel.entities.characters.Player;
import windows.panels.gamePanel.entities.structures.Room;
import windows.panels.gamePanel.entities.structures.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class GameWorld {
    private int worldHeight;
    private int worldWidth;
    private final GamePanel gamePanel;
    private final ArrayList<Room> rooms;
    private Room currentRoom;
    private final Player player;

    public GameWorld(GamePanel gamepanel, int width, int height) {
        this.gamePanel = gamepanel;
        this.worldWidth = width;
        this.worldHeight = height;

        rooms = new ArrayList<>();
        Room starterRoom = RoomFactory.starterRoom(this, worldWidth, worldHeight);
        rooms.add(starterRoom);
        currentRoom = starterRoom;

        player = PlayerFactory.createDefaultPlayer(gamePanel, this, starterRoom);
        Slime slime = EnemyFactory.createSlime(gamePanel, this, currentRoom, currentRoom.getMobSpawnLocations().getFirst());

        currentRoom.addCharacter(slime);
        currentRoom.addCharacter(player);

        gamepanel.startGameThread();
    }

    public void render(Graphics2D g2){
        if(getCurrentRoom() == null){
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
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
        player.moveTo(currentRoom.getPlayerEntrances().getFirst());

    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public double getCurrentWidthScale() {
        return (double) currentRoom.getTileWidth() / Tile.getDefaultTileWidth();
    }

    public double getCurrentHeightScale() {
        return (double) currentRoom.getTileHeight() / Tile.getDefaultTileHeight();
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Player getPlayer() {
        return player;
    }

    public void setDimensions(int width, int height) {
        worldWidth = width;
        worldHeight = height;
        currentRoom.setWidth(width);
        currentRoom.setHeight(height);
    }

    public ArrayList<MobSpawnLocation> getMobSpawnLocation(){
        return currentRoom.getMobSpawnLocations();
    }
}
