package factories;
import gameWindow.GameWorld;
import objects.structures.Floor;
import objects.structures.Room;
import objects.structures.Wall;
import objects.structures.WallDirection;

public class RoomFactory {

    public static Room starterRoom(GameWorld gameWorld, int playableAreaWidth, int playableAreaHeight) {
        int numRows = 30;
        int numCols = 30;
        int tileWidth = Math.max(1, playableAreaWidth / numCols);
        int tileHeight = Math.max(1, playableAreaHeight / numRows);
        Room defaultRoom = new Room(numRows, numCols, tileWidth, tileHeight);
        Floor defaultFloor = FloorFactory.getDefaultFloor1(0, 0, numRows, numCols, tileWidth, tileHeight);
        defaultRoom.addObject(defaultFloor);
        defaultRoom.addObject(WallFactory.getWall(defaultFloor, WallDirection.NORTH));
        defaultRoom.addObject(WallFactory.getWall(defaultFloor, WallDirection.SOUTH));
        defaultRoom.addObject(WallFactory.getWall(defaultFloor, WallDirection.EAST));
        defaultRoom.addObject(WallFactory.getWall(defaultFloor, WallDirection.WEST));

        defaultRoom.addObject(StartPointFactory.getDefaultStartPoint(numRows/2, numCols/2, tileWidth, tileHeight));

        return defaultRoom;
    }

    public static Room LRoom(GameWorld gameWorld, int playableAreaWidth, int playableAreaHeight) {
        int numRows = 24;
        int numCols = 24;
        int tileWidth = Math.max(1, playableAreaWidth / numCols);
        int tileHeight = Math.max(1, playableAreaHeight / numRows);

        Room defaultRoom = new Room(numRows, numCols, tileWidth, tileHeight);
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

        defaultRoom.addObject(StartPointFactory.getDefaultStartPoint(3, 3, tileWidth, tileHeight));

        return defaultRoom;
    }

    public static Room IRoom(GameWorld gameWorld, int playableAreaWidth, int playableAreaHeight) {
        int numRows = 18;
        int numCols = 36;
        int tileWidth = Math.max(1, playableAreaWidth / numCols);
        int tileHeight = Math.max(1, playableAreaHeight / numRows);

        Floor fillFloor = FloorFactory.getVoidFloor(0, 0, numRows, numCols, tileWidth, tileHeight);
        Floor floor1 = FloorFactory.getDefaultFloor1(0, 0, 18, 12, tileWidth, tileHeight);
        Floor floor2 = FloorFactory.getDefaultFloor1(6, 12, 6, 12, tileWidth, tileHeight);
        Floor floor3 = FloorFactory.getDefaultFloor1(0, 24, 18, 12, tileWidth, tileHeight);
        Floor topVoid = FloorFactory.getVoidFloor(0, 12, 6, 12, tileWidth, tileHeight);
        Floor botVoid = FloorFactory.getVoidFloor(12, 12, 6, 12, tileWidth, tileHeight);
        Room defaultRoom = new Room(numRows, numCols, tileWidth, tileHeight);
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

        defaultRoom.addObject(StartPointFactory.getDefaultStartPoint(3, 3, tileWidth, tileHeight));

        return defaultRoom;
    }

}
