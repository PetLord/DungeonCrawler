package windows.panels.gamePanel.entities.structures.worldMap;

import windows.panels.gamePanel.GameWorld;

import java.awt.*;

public interface WorldMapGenerationStrategy {
    void generateWorldMap(GameWorld gameWorld, WorldMap worldMap, int n, int m);
    Dimension getStarterRoomPosition ();
}
