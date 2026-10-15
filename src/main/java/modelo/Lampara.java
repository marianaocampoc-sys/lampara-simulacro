package modelo;

import excepciones.LamparaEncendidaException;

/**
 * Representa una lámpara que se puede encender, apagar y a la que se le
 * puede subir el brillo.
 */
public class Lampara {

    /** Brillo máximo que puede tener la lámpara. */
    public static final int BRILLO_MAXIMO = 100;

    /** Cuánto sube el brillo cada vez que se presiona el botón. */

    public static final int PASO_BRILLO = 25;


    private boolean encendida;
    private int brillo;

    /**
     * Crea una lámpara apagada y con brillo 0.
     */
    public Lampara() {
        encendida = false;
        brillo = 0;
    }

    /**
     * Enciende la lámpara con el brillo mínimo de un paso.
     */
    public void encender() {
        encendida = true;
        brillo = PASO_BRILLO;
    }

    /**
     * Apaga la lámpara y deja el brillo en 0.
     */
    public void apagar() {
        encendida = false;
        brillo = 0;
    }

    /**
     * Sube el brillo un paso, sin pasarse del máximo.
     *
     * @throws LamparaEncendidaException si la lámpara está encendida
     */
    public void subirBrillo() throws LamparaEncendidaException {
        if (!encendida) {
            throw new LamparaEncendidaException("No se puede subir el brillo: la lámpara está apagada.");
        }
        brillo = Math.min(brillo + PASO_BRILLO, BRILLO_MAXIMO);
    }

    /**
     * @return true si la lámpara está encendida
     */
    public boolean isEncendida() {
        return encendida;
    }

    /**
     * @return el brillo actual, de 0 a 100
     */
    public int getBrillo() {
        return brillo;
    }
}
