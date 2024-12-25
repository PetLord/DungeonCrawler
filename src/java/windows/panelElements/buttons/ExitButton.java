package windows.panelElements.buttons;

import windows.panels.CustomPanel;

public class ExitButton extends CustomButton {

    public ExitButton(CustomPanel panel) {
        super("Exit", panel);
        this.addActionListener(e -> System.exit(0));
    }
}
