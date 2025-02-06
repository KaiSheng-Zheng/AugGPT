import java.util.List;


/**
 * This class is an abstract class
 * <br>
 * This class helps to represent all the chess components on the chessboard.
 * <br>
 * This class provides a rough description for all the chess pieces.
 * Abstract methods should be left in abstract form for further implementation.
 * You don't need to write codes for them in detail.
 */
public abstract class ChessComponent {


    // Attributes
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;


    // Constructors
    public ChessComponent() {
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {

        this.source = source;
        this.chessColor = chessColor;
        this.name = name;

    }


    // Abstract Methods

    /**
     * should design: canMoveTo
     * <br>
     * Return all can move points according to the rules in concrete chess components respectively,
     * which is to make different chess pieces moves in different ways.
     * <br>
     *
     * @return List<ChessboardPoint>
     */
    public abstract List<ChessboardPoint> canMoveTo();


    // Concrete Methods

    /**
     * should design @Override toString
     *
     * @return String
     */
    @Override
    public String toString() {

        // Attributes
        String result;

        // Operations
        result = String.valueOf(name);

        // Return
        return result;

    }


    // Getters
    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessColor getChessColorInverse() {
        
        // Attributes
        ChessColor result;
        if (chessColor.equals(ChessColor.BLACK)){
            result = ChessColor.WHITE;
        } else if (chessColor.equals(ChessColor.WHITE)){
            result = ChessColor.BLACK;
        } else {
            result = ChessColor.NONE;
        }
        
        return result;
        
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }


    // Setters
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }


}
