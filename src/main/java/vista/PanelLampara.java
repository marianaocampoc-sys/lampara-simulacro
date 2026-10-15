package vista;

import excepciones.LamparaApagadaException;
import excepciones.LamparaEncendidaException;
import modelo.Lampara;

import javax.swing.*;
import java.awt.*;

/**
 * Lienzo que dibuja la lámpara y tiene los botones para controlarla.
 */
public class PanelLampara extends JPanel {

    private Lampara lampara;
    private JLabel lblMensaje;

    /**
     * Crea el panel con la lámpara, los botones y el mensaje.
     */
    public PanelLampara() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.WHITE);
        lampara = new Lampara();

        JButton btnEncender = new JButton("Encender");
        JButton btnApagar = new JButton("Apagar ya");
        JButton btnSubir = new JButton("Subir brillo");
        lblMensaje = new JLabel("La lámpara está apagada.");

        add(btnEncender);
        add(btnApagar);
        add(btnSubir);
        add(lblMensaje);

        btnEncender.addActionListener(e -> {
            lampara.encender();
            mostrar("Lámpara encendida.");
        });

        btnApagar.addActionListener(e -> {
            lampara.apagar();
            mostrar("Lámpara apagada.");
        });

        btnSubir.addActionListener(e -> {
            try {
                lampara.subirBrillo();
                mostrar("Brillo: " + lampara.getBrillo() + " %");
            } catch (LamparaEncendidaException ex) {
                mostrar(ex.getMessage());
            }
        });
    }

    /**
     * Muestra un mensaje y vuelve a dibujar la lámpara.
     *
     * @param texto mensaje para el usuario
     */
    private void mostrar(String texto) {
        lblMensaje.setText(texto);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Bombillo: más amarillo cuanto más brillo
        int intensidad = lampara.getBrillo() * 255 / Lampara.BRILLO_MAXIMO;
        g.setColor(new Color(255, 230, 0, Math.max(intensidad, 30)));
        g.fillOval(250, 120, 100, 100);

        // Base
        g.setColor(Color.DARK_GRAY);
        g.fillRect(280, 220, 40, 60);
    }
}
