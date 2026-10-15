package vista;

import javax.swing.*;

/**
 * Ventana principal del simulador de lámpara.
 */
public class VentanaLampara extends JFrame {

    /**
     * Configura la ventana y le agrega el panel.
     */
    public VentanaLampara() {
        setTitle("Una simple lampara");
        add(new PanelLampara());
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Punto de entrada del programa.
     *
     * @param args no se usan
     */
    public static void main(String[] args) {
        new VentanaLampara();
    }
}
