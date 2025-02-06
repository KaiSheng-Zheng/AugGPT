/**
 * This class helps to maintain chess locations in the game.
 */
public class ChessboardPoint {


    // Attributes
    private int x;
    private int y;


    // Constructor

    /**
     * should design
     *
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }


    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    // Methods

    /**
     * should design @Override toString
     *
     * @return null
     */
    @Override
    public String toString() {

        // Attributes
        String result;

        // Operation
        result = String.format("(%d,%d)", getX(), getY());

        // Return
        return result;

    }

    /**
     * should design offset
     *
     * @param dx
     * @param dy
     * @return ChessboardPoint offset
     */
    public ChessboardPoint offset(int dx, int dy) {

        // Attributes
        ChessboardPoint result = null;

        // Operation
        if (x >= 0 && y >= 0 && x + dx >= 0 && y + dy >= 0 && x <= 7 && y <= 7 && x + dx <= 7 && y + dy <= 7) {
            result = new ChessboardPoint(x + dx, y + dy);
        }

        // Result
        return result;

    }


}