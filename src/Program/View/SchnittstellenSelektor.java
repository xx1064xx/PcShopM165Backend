package Program.View;

import javax.swing.*;
import java.awt.*;

public class SchnittstellenSelektor extends JDialog {

    private ComputerUi computerUi;

    public SchnittstellenSelektor (ComputerUi computerUi) {

        super(computerUi, "kundenView", true);

        this.computerUi = computerUi;

        init();

    }

    public void init() {
        setTitle("Option Selection");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(400, 500));
        setLayout(new BorderLayout());

        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

}
