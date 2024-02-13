package Program.View;

import javax.swing.*;
import java.awt.*;

public class KundenUi extends JDialog {

    private MainUi mainUi;
    private boolean isEmpty;

    // UI

    // panels

    public KundenUi (MainUi mainUi, boolean isEmpty) {

        super(mainUi, "kundenView", true);

        this.mainUi = mainUi;
        this.isEmpty = isEmpty;

        init();

    }

    public void init() {

        setTitle("Option Selection");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(350, 500));
        setLayout(new BorderLayout());

        pack();
        setLocationRelativeTo(null);

        setVisible(true);

    }

}
