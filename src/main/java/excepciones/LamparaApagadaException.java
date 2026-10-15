package excepciones;

/**
 * Se lanza cuando se intenta cambiar el brillo de una lámpara apagada.
 */
public class LamparaApagadaException extends Exception {

    /**
     * Crea la excepción con un mensaje para el usuario.
     *
     * @param mensaje explicación de lo que pasó
     */
    public LamparaApagadaException(String mensaje) {
        super(mensaje);
    }
}
