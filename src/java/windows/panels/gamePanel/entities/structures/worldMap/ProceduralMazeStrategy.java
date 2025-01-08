package windows.panels.gamePanel.entities.structures.worldMap;

import factories.EnemyFactory;
import factories.RoomFactory;
import windows.panels.gamePanel.GameWorld;
import windows.panels.gamePanel.entities.structures.Room;
import windows.panels.gamePanel.entities.structures.WallDirection;

import java.awt.*;

import java.util.ArrayList;
import java.util.Random;

public class ProceduralMazeStrategy implements WorldMapGenerationStrategy {
    private final Random random = new Random();

    // logic: always move to down or right while we reach the boss room
    // Look at the current room's neighbors
    // choose a random number k, between 1 and 2. If 1 then choose between right or down, if 2 then both
    // Crate a random room from the chosen direction
    // choose between the created rooms to continue the path with
    @Override
    public void generateWorldMap(GameWorld gameWorld, WorldMap worldMap, int n, int m) {
        // Define starter and boss room positions directly
        int starterX = 0, starterY = 0;
        int bossX = n - 1, bossY = m - 1;

        Room[][] roomGrid = worldMap.getRoomGrid();
        roomGrid[starterX][starterY] = RoomFactory.starterRoom(worldMap, starterX, starterY, gameWorld.getWorldWidth(), gameWorld.getWorldHeight());
        roomGrid[bossX][bossY] = RoomFactory.bossRoom(worldMap, bossX, bossY, gameWorld.getWorldWidth(), gameWorld.getWorldHeight());
        roomGrid[bossX][bossY].addCharacter(EnemyFactory.getBoss(gameWorld.getGamePanel(), gameWorld, roomGrid[bossX][bossY], roomGrid[bossX][bossY].getMobSpawnLocations().getFirst()));
        int currentX = starterX;
        int currentY = starterY;

        // Mark the starting room as visited
        ArrayList<Point> visitedRooms = new ArrayList<>();
        visitedRooms.add(new Point(currentX, currentY));

        // Start pathfinding loop
        while (currentX != bossX || currentY != bossY) {
            ArrayList<Point> possibleDirections = new ArrayList<>();

            // Check for possible directions (down and right)
            if (currentX + 1 < n && !visitedRooms.contains(new Point(currentX + 1, currentY))) {
                possibleDirections.add(new Point(currentX + 1, currentY)); // right
            }
            if (currentY + 1 < m && !visitedRooms.contains(new Point(currentX, currentY + 1))) {
                possibleDirections.add(new Point(currentX, currentY + 1)); // down
            }

            // If no possible directions, break (this should be handled by a better pathfinding algorithm)
            if (possibleDirections.isEmpty()) {
                System.out.println("No possible directions. This should not happen");
                break;
            }

            int roomsToCreate = random.nextInt(possibleDirections.size()) + 1;

            Point moveDirection = possibleDirections.get(random.nextInt(possibleDirections.size()));
            currentX = moveDirection.x;
            currentY = moveDirection.y;

            for(int i = 0; i < roomsToCreate; i++) {
                int randomIndex = random.nextInt(possibleDirections.size());
                Point chosenDirection = possibleDirections.get(randomIndex);

                if(chosenDirection.x == bossX && chosenDirection.y == bossY) {
                    break;
                }
                roomGrid[chosenDirection.x][chosenDirection.y] = RoomFactory.randomRoom(worldMap, chosenDirection.x, chosenDirection.y, gameWorld.getWorldWidth(), gameWorld.getWorldHeight());
                addMonsters(gameWorld, roomGrid[chosenDirection.x][chosenDirection.y]);
                visitedRooms.add(chosenDirection);
                possibleDirections.remove(randomIndex);
            }

            // Move to the new room
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (roomGrid[i][j] == null) {
                    roomGrid[i][j] = new EmptyRoomBlock(worldMap, i, j);
                }
            }
        }

        // Add doors to the rooms
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                addDoors(roomGrid[i][j], roomGrid, n, m);
            }
        }

    }


    @Override
    public Dimension getStarterRoomPosition() {
        return new Dimension(0, 0);
    }

    private void addMonsters(GameWorld gameWorld, Room room){
        room.getMobSpawnLocations().forEach((location) -> {
            if (spawnMonster()){
                room.addCharacter(EnemyFactory.createRandomEnemy(gameWorld.getGamePanel(), gameWorld, room, location));
                //room.addCharacter(EnemyFactory.createRandomEnemy(gameWorld.getGamePanel(), gameWorld, room, location));
            }
        });
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

    private boolean spawnMonster(){
        return Math.random() < 0.66; // 75% chance to spawn a monster
    }
}

