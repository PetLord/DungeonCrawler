package windows.panels.gamePanel.entities.structures.worldMap;

import factories.EnemyFactory;
import factories.RoomFactory;
import windows.panels.gamePanel.GameWorld;
import windows.panels.gamePanel.entities.structures.Room;
import windows.panels.gamePanel.entities.structures.WallDirection;

import java.awt.*;

public class TesterStrategy implements WorldMapGenerationStrategy {
    @Override
    public void generateWorldMap(GameWorld gameWorld, WorldMap worldMap, int n, int m) {
        // create a 2D array of rooms
        Room[][] roomGrid = worldMap.getRoomGrid();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    roomGrid[i][j] = RoomFactory.starterRoom(worldMap, i, j, gameWorld.getWorldWidth(), gameWorld.getWorldHeight());
                    continue;
                }

                roomGrid[i][j] = RoomFactory.IRoom(worldMap, i, j, gameWorld.getWorldWidth(), gameWorld.getWorldHeight());
                int finalI = i;
                int finalJ = j;
                roomGrid[i][j].getMobSpawnLocations().forEach((location) -> {
                    if (spawnMonster()){
                        roomGrid[finalI][finalJ].addCharacter(EnemyFactory.createSlime(gameWorld.getGamePanel(), gameWorld, roomGrid[finalI][finalJ], location));
                    }
                });
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                addDoors(roomGrid[i][j], roomGrid, n, m);
            }
        }

    }

    @Override
    public Dimension getStarterRoomPosition() {
        return new Dimension(1, 1);
    }

    private boolean spawnMonster(){
        return Math.random() < 0.5;
    }

    private void addDoors(Room room, Room[][] roomGrid, int n, int m){
        int roomX = room.getMapX();
        int roomY = room.getMapY();

        if ((room instanceof EmptyRoomBlock)){
            return;
        }

        if (roomY > 0 && !(roomGrid[roomX][roomY - 1] instanceof EmptyRoomBlock)){
            room.addDoor(WallDirection.NORTH);
        }

        if (roomY < m - 1 && !(roomGrid[roomX][roomY + 1] instanceof EmptyRoomBlock)){
            room.addDoor(WallDirection.SOUTH);
        }

        // check if neighbouring rooms exist and they are not EmptyRoomBlocks and add doors
        if (roomX > 0 && !(roomGrid[roomX - 1][roomY] instanceof EmptyRoomBlock)){
            room.addDoor(WallDirection.WEST);
        }

        if (roomX < n - 1 && !(roomGrid[roomX + 1][roomY] instanceof EmptyRoomBlock)){
            room.addDoor(WallDirection.EAST);
        }
    }
}
