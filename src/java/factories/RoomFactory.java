package factories;
import windows.panels.gamePanel.entities.structures.Floor;
import windows.panels.gamePanel.entities.structures.MobSpawnLocation;
import windows.panels.gamePanel.entities.structures.Room;
import windows.panels.gamePanel.entities.structures.WallDirection;
import windows.panels.gamePanel.entities.structures.worldMap.WorldMap;

import java.awt.*;
import java.util.Random;

public abstract class RoomFactory {

    public static Room starterRoom(WorldMap worldMap, int mapX, int mapY, int playableAreaWidth, int playableAreaHeight) {
        int numRows = 16;
        int numCols = 16;
        int tileWidth = Math.max(1, playableAreaWidth / numCols);
        int tileHeight = Math.max(1, playableAreaHeight / numRows);

        Point northDoorLocation = new Point(0, numCols / 2);
        Point southDoorLocation = new Point(numRows - 1, numCols / 2);
        Point westDoorLocation = new Point(numRows / 2, 0);
        Point eastDoorLocation = new Point(numRows / 2, numCols - 1);


        Room defaultRoom = new Room(worldMap, mapX, mapY, numRows, numCols, tileWidth, tileHeight, northDoorLocation, southDoorLocation, eastDoorLocation, westDoorLocation);
        Floor defaultFloor = FloorFactory.getDefaultFloor1(0, 0, numRows, numCols, tileWidth, tileHeight);
        defaultRoom.addObject(defaultFloor);
        defaultRoom.addObject(WallFactory.getWall(defaultFloor, WallDirection.NORTH));
        defaultRoom.addObject(WallFactory.getWall(defaultFloor, WallDirection.SOUTH));
        defaultRoom.addObject(WallFactory.getWall(defaultFloor, WallDirection.EAST));
        defaultRoom.addObject(WallFactory.getWall(defaultFloor, WallDirection.WEST));

        defaultRoom.setPlayerSpawnLocation(StartPointFactory.getDefaultStartPoint(numRows/2, numCols/2, tileWidth, tileHeight));

        return defaultRoom;
    }

    public static Room LRoom(WorldMap worldMap, int mapX, int mapY, int playableAreaWidth, int playableAreaHeight) {
        int numRows = 24;
        int numCols = 24;
        int tileWidth = Math.max(1, playableAreaWidth / numCols);
        int tileHeight = Math.max(1, playableAreaHeight / numRows);

        // add door based on floor location
        Point northDoorLocation = new Point(0, 6);
        Point southDoorLocation = new Point(23, 6);
        Point eastDoorLocation = new Point(18, 23);
        Point westDoorLocation = new Point(18, 0);

        Room defaultRoom = new Room(worldMap, mapX, mapY, numRows, numCols, tileWidth, tileHeight, northDoorLocation, southDoorLocation, eastDoorLocation, westDoorLocation);
        Floor floor1 = FloorFactory.getDefaultFloor1(0, 0, 24, 12, tileWidth, tileHeight);
        Floor floor2 = FloorFactory.getDefaultFloor1(12, 12, 12, 12, tileWidth, tileHeight);
        Floor voidFloor = FloorFactory.getVoidFloor(0, 12, 12, 12, tileWidth, tileHeight);

        defaultRoom.addObject(floor1);
        defaultRoom.addObject(floor2);
        defaultRoom.addObject(voidFloor);
        defaultRoom.addObject(WallFactory.getWall(floor1, WallDirection.NORTH));
        defaultRoom.addObject(WallFactory.getWall(floor1, WallDirection.WEST));
        defaultRoom.addObject(WallFactory.getWall(floor1, WallDirection.SOUTH));

        defaultRoom.addObject(WallFactory.getWall(floor2, WallDirection.SOUTH));
        defaultRoom.addObject(WallFactory.getWall(floor2, WallDirection.EAST));

        defaultRoom.addObject(WallFactory.getWall(voidFloor, WallDirection.WEST));
        defaultRoom.addObject(WallFactory.getWall(voidFloor, WallDirection.SOUTH));

        defaultRoom.setPlayerSpawnLocation(StartPointFactory.getDefaultStartPoint(3, 3, tileWidth, tileHeight));
        defaultRoom.addMobSpawnLocation(new MobSpawnLocation(defaultRoom, 3, 3));
        defaultRoom.addMobSpawnLocation(new MobSpawnLocation(defaultRoom, 3, 4));
        defaultRoom.addMobSpawnLocation(new MobSpawnLocation(defaultRoom,numRows - 2, numCols - 2));
        defaultRoom.addMobSpawnLocation(new MobSpawnLocation(defaultRoom,numRows - 3, numCols - 3));
        return defaultRoom;
    }

    public static Room IRoom(WorldMap worldMap, int mapX, int mapY, int playableAreaWidth, int playableAreaHeight) {
        int numRows = 18;
        int numCols = 36;
        int tileWidth = Math.max(1, playableAreaWidth / numCols);
        int tileHeight = Math.max(1, playableAreaHeight / numRows);

        Floor fillFloor = FloorFactory.getVoidFloor(0, 0, 18, 36, tileWidth, tileHeight);
        Floor floor1 = FloorFactory.getDefaultFloor1(0, 0, 18, 12, tileWidth, tileHeight);
        Floor floor2 = FloorFactory.getDefaultFloor1(6, 12, 6, 12, tileWidth, tileHeight);
        Floor floor3 = FloorFactory.getDefaultFloor1(0, 24, 18, 12, tileWidth, tileHeight);
        Floor topVoid = FloorFactory.getVoidFloor(0, 12, 6, 12, tileWidth, tileHeight);
        Floor botVoid = FloorFactory.getVoidFloor(12, 12, 6, 12, tileWidth, tileHeight);

        Point northDoorLocation = new Point(0, 6);
        Point southDoorLocation = new Point(17, 33);
        Point eastDoorLocation = new Point(9, 35);
        Point westDoorLocation = new Point(9, 0);

        Room defaultRoom = new Room(worldMap, mapX, mapY, numRows, numCols, tileWidth, tileHeight, northDoorLocation, southDoorLocation, eastDoorLocation, westDoorLocation);
        defaultRoom.addObject(fillFloor);
        defaultRoom.addObject(floor1);
        defaultRoom.addObject(floor2);
        defaultRoom.addObject(floor3);
        defaultRoom.addObject(topVoid);
        defaultRoom.addObject(botVoid);

        defaultRoom.addObject(WallFactory.getWall(floor1, WallDirection.NORTH));
        defaultRoom.addObject(WallFactory.getWall(floor1, WallDirection.WEST));
        defaultRoom.addObject(WallFactory.getWall(floor1, WallDirection.SOUTH));

        defaultRoom.addObject(WallFactory.getWall(floor3, WallDirection.NORTH));
        defaultRoom.addObject(WallFactory.getWall(floor3, WallDirection.EAST));
        defaultRoom.addObject(WallFactory.getWall(floor3, WallDirection.SOUTH));

        defaultRoom.addObject(WallFactory.getWall(topVoid, WallDirection.SOUTH));
        defaultRoom.addObject(WallFactory.getWall(topVoid, WallDirection.EAST));
        defaultRoom.addObject(WallFactory.getWall(topVoid, WallDirection.WEST));

        defaultRoom.addObject(WallFactory.getWall(botVoid, WallDirection.NORTH));
        defaultRoom.addObject(WallFactory.getWall(botVoid, WallDirection.EAST));
        defaultRoom.addObject(WallFactory.getWall(botVoid, WallDirection.WEST));

        defaultRoom.setPlayerSpawnLocation(StartPointFactory.getDefaultStartPoint(18, 9, tileWidth, tileHeight));
        defaultRoom.addMobSpawnLocation(new MobSpawnLocation(defaultRoom, 3, 3));
        defaultRoom.addMobSpawnLocation(new MobSpawnLocation(defaultRoom, 3, 15));
        defaultRoom.addMobSpawnLocation(new MobSpawnLocation(defaultRoom, 32, 3));
        defaultRoom.addMobSpawnLocation(new MobSpawnLocation(defaultRoom, 33, 15));

        return defaultRoom;
    }

    public static Room bossRoom(WorldMap worldMap, int mapX, int mapY, int playableAreaWidth, int playableAreaHeight) {
        int numRows = 48;
        int numCols = 48;
        int tileWidth = Math.max(1, playableAreaWidth / numCols);
        int tileHeight = Math.max(1, playableAreaHeight / numRows);

        // Doors at the center of each wall
        Point northDoorLocation = new Point(0, numCols / 2);
        Point southDoorLocation = new Point(numRows - 1, numCols / 2);
        Point westDoorLocation = new Point(numRows / 2, 0);
        Point eastDoorLocation = new Point(numRows / 2, numCols - 1);

        Room bossRoom = new Room(worldMap, mapX, mapY, numRows, numCols, tileWidth, tileHeight, northDoorLocation, southDoorLocation, eastDoorLocation, westDoorLocation);

        // Floor setup
        Floor voidFloor = FloorFactory.getVoidFloor(0, 0, numRows, numCols, tileWidth, tileHeight);
        Floor centralCross = FloorFactory.getDefaultFloor1(16, 16, 16, 16, tileWidth, tileHeight);
        Floor northExtension = FloorFactory.getDefaultFloor1(0, 16, 16, 16, tileWidth, tileHeight);
        Floor southExtension = FloorFactory.getDefaultFloor1(32, 16, 16, 16, tileWidth, tileHeight);
        Floor eastExtension = FloorFactory.getDefaultFloor1(16, 32, 16, 16, tileWidth, tileHeight);
        Floor westExtension = FloorFactory.getDefaultFloor1(16, 0, 16, 16, tileWidth, tileHeight);

        bossRoom.addObject(voidFloor);
        bossRoom.addObject(centralCross);
        bossRoom.addObject(northExtension);
        bossRoom.addObject(southExtension);
        bossRoom.addObject(eastExtension);
        bossRoom.addObject(westExtension);

        // Walls
        bossRoom.addObject(WallFactory.getBossWall(northExtension, WallDirection.NORTH));
        bossRoom.addObject(WallFactory.getBossWall(northExtension, WallDirection.EAST));
        bossRoom.addObject(WallFactory.getBossWall(northExtension, WallDirection.WEST));
        bossRoom.addObject(WallFactory.getBossWall(southExtension, WallDirection.SOUTH));
        bossRoom.addObject(WallFactory.getBossWall(southExtension, WallDirection.EAST));
        bossRoom.addObject(WallFactory.getBossWall(southExtension, WallDirection.WEST));
        bossRoom.addObject(WallFactory.getBossWall(eastExtension, WallDirection.EAST));
        bossRoom.addObject(WallFactory.getBossWall(eastExtension, WallDirection.NORTH));
        bossRoom.addObject(WallFactory.getBossWall(eastExtension, WallDirection.SOUTH));
        bossRoom.addObject(WallFactory.getBossWall(westExtension, WallDirection.WEST));
        bossRoom.addObject(WallFactory.getBossWall(westExtension, WallDirection.NORTH));
        bossRoom.addObject(WallFactory.getBossWall(westExtension, WallDirection.SOUTH));

        // Player Spawn
        bossRoom.setPlayerSpawnLocation(StartPointFactory.getDefaultStartPoint(16, 10, tileWidth, tileHeight));

        // Boss Spawn
        MobSpawnLocation bossSpawn = new MobSpawnLocation(bossRoom, numRows / 2, numCols / 2);
        bossRoom.addMobSpawnLocation(bossSpawn);

        return bossRoom;
    }

    public static Room randomRoom(WorldMap worldMap, int x, int y, int worldWidth, int worldHeight) {
        Random random = new Random();
        int roomType = random.nextInt(2);
        return switch (roomType) {
            case 1 -> IRoom(worldMap, x, y, worldWidth, worldHeight);
            default -> LRoom(worldMap, x, y, worldWidth, worldHeight);
        };
    }
}
