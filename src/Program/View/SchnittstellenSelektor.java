package Program.View;

import javax.swing.*;
import java.awt.*;

public class SchnittstellenSelektor extends JDialog {

    private ComputerUi computerUi;

    // UI

    // buttons
    private JButton addButton;
    private JButton abbrechenButton;


    // combobox
    private JComboBox<String> comboBox;

    // panels
    private JPanel panel;

    public SchnittstellenSelektor (ComputerUi computerUi) {

        super(computerUi, "kundenView", true);

        this.computerUi = computerUi;

        init();

    }

    public void init() {
        setTitle("Option Selection");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(200, 100));
        setLayout(new BorderLayout());

        panel = new JPanel();

        addButton = new JButton("abbrechen");
        abbrechenButton = new JButton("neu");

        panel.add(addButton);
        panel.add(abbrechenButton);

        String[] computerschnittstellen = {
                "USB", "HDMI", "Ethernet", "Wi-Fi", "Bluetooth", "Thunderbolt", "VGA", "DVI", "DisplayPort", "Serial ATA (SATA)",
                "PCI Express (PCIe)", "FireWire (IEEE 1394)", "Serial Port (RS-232)", "Parallel Port (Centronics)", "Universal Audio Jack",
                "PS/2", "ExpressCard", "SCSI", "MIDI", "Fibre Channel", "IrDA (Infrared Data Association)", "NFC (Near Field Communication)",
                "SPI (Serial Peripheral Interface)", "I2C (Inter-Integrated Circuit)", "UART (Universal Asynchronous Receiver-Transmitter)"
        };

        comboBox = new JComboBox<>(computerschnittstellen);

        add(comboBox, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

}
