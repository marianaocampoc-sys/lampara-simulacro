
package excepciones;

/**
 * Se lanza cuando se intenta cambiar el brillo de una lámpara apagada.
 */
public class LamparaEncendidaException extends Exception {

    /**
     * Crea la excepción con un mensaje para el usuario.
     *
     * @param mensaje explicación de lo que pasó
     */
    public LamparaEncendidaException(String mensaje) {
        super(mensaje);
    }
}
