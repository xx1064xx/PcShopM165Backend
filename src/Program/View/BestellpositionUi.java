package Program.View;

import javax.swing.*;

public class BestellpositionUi extends JDialog {

    private BestellungsUi bestellungsUi;

    public BestellpositionUi (BestellungsUi bestellungsUi) {

        super(bestellungsUi, "kundenView", true);

        this.bestellungsUi = bestellungsUi;

        init();

    }

    public void init(){

    }
}
