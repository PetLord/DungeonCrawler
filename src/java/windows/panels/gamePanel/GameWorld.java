package windows.panels.gamePanel;

import windows.panels.gamePanel.characterProfessions.CharacterProfession;
import windows.panels.gamePanel.characterProfessions.playableCharacters.Fighter;
import windows.panels.gamePanel.components.MovementComponent;
import windows.panels.gamePanel.factories.PlayerFactory;
import windows.panels.gamePanel.factories.RoomFactory;
import windows.panels.gamePanel.factories.StatFactory;
import windows.panels.gamePanel.objects.characters.Player;
import windows.panels.gamePanel.objects.structures.Room;
import windows.panels.gamePanel.objects.structures.Tile;
import windows.panels.gamePanel.stats.CharacterStat;

import java.util.ArrayList;

public class GameWorld {
    private final int worldHeight;
    private final int worldWidth;
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

        CharacterStat baseStats = StatFactory.getDefaultCharacterStat();
        CharacterProfession f = new Fighter(baseStats);
        player = PlayerFactory.createDefaultPlayer(f, gamePanel, this);
        currentRoom.addEntity(player);
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
        player.moveTo(currentRoom.getStartPoints().getFirst());

        if(player.hasComponent(MovementComponent.class)){
            player.getComponent(MovementComponent.class).setTileSizeMultiplier(currentRoom.getTileWidth(), currentRoom.getTileHeight());
        }
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
}
