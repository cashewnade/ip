public class AeromonException extends Exception {
    /**
     * Public constructor, which only takes in the message.
     * @param message the message to be printed
     */
    public AeromonException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Ohnoz! " + getMessage();
    }
}
