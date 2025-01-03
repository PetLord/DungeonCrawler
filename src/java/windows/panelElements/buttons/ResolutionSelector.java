package windows.panelElements.buttons;

import windows.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ResolutionSelector extends JPanel {
    private final GridLayout gridLayout;
    private final MainFrame mainFrame;
    private final ResolutionBox resolutionBox;
    private final JLabel resolutionLabel;

    public ResolutionSelector(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.setOpaque(false);
        gridLayout = new GridLayout(1, 2);
        gridLayout.setHgap(10);

        resolutionLabel = new JLabel("Resolution:");
        resolutionLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        resolutionLabel.setForeground(Color.WHITE);
        resolutionBox = new ResolutionBox(mainFrame);
        this.add(resolutionLabel);
        this.add(resolutionBox);
    }

    public void setResolution(Dimension dimension){
        resolutionBox.setResolution(dimension.width, dimension.height);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        resolutionBox.setEnabled(enabled);
    }

    public Pair getResolution(){
        return resolutionBox.getResolution();
    }

    public static class ResolutionBox extends JComboBox<String> {
        private static final String[] resolutions = {
                "1920x1080",
                "1600x900",
                "1280x720",
                "1024x768"
        };
        private final Map<String, Pair> resolutionPairs;

        public ResolutionBox(MainFrame mainFrame){
            super();

            Pair[] pairs = {
                new Pair(1920, 1080),
                new Pair(1600, 900),
                new Pair(1280, 720),
                new Pair(1024, 768)
            };

            Toolkit tk = Toolkit.getDefaultToolkit();
            int width = tk.getScreenSize().width;
            int height = tk.getScreenSize().height;

            int frameWidth = mainFrame.getWidth();
            int frameHeight = mainFrame.getHeight();

            resolutionPairs = new HashMap<>();
            for(int i = 0; i < resolutions.length; i++){
                if(pairs[i].getFirst() <= width && pairs[i].getSecond() <= height) {
                    addItem(resolutions[i]);
                    resolutionPairs.put(resolutions[i], pairs[i]);
                    if (pairs[i].getFirst() == frameWidth && pairs[i].getSecond() == frameHeight) {
                        setSelectedItem(resolutions[i]);
                    }
                }
            }

        }

        public Pair getResolution(){
            return resolutionPairs.get(getSelectedItem());
        }

        public void setResolution(int width, int height){
            for(String resolution : resolutions){
                Pair pair = resolutionPairs.get(resolution);
                if(pair.getFirst() == width && pair.getSecond() == height){
                    setSelectedItem(resolution);
                    break;
                }
            }
        }

    }

    public static class Pair{
        private final int first;
        private final int second;

        public Pair(int a, int b){
            first = a;
            second = b;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }
}
