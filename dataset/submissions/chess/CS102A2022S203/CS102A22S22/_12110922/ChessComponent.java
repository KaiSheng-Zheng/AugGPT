import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source;// Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name

    protected ChessGame game;

    // Default constructor
    public ChessComponent() {
    }

    // creates a new ChessComponent
    public ChessComponent(ChessboardPoint source, ChessColor chessColor,
            char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;

        if (chessColor == ChessColor.WHITE) {
            this.name = Character.toLowerCase(name);
        }
    }
    
    /**
     * Set the game.
     * @param game the game to set
     */
    public void setGame(ChessGame game) {
        this.game = game;
    }
    

    /**
     * Get the source.
     * 
     * @return the source
     */
    public ChessboardPoint getSource() {
        return source;
    }

    /**
     * Set the source.
     * 
     * @param source the source to set
     */
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    /**
     * Get the chessColor.
     * 
     * @return the chessColor
     */
    public ChessColor getChessColor() {
        return chessColor;
    }

    /**
     * Get the name.
     * 
     * @return the name
     */
    public char getName() {
        return name;
    }

    // tells where this chess piece can move to
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * Return the name of current chess piece
     * 
     * @return name of current chess piece
     */
    @Override
    public String toString() {
        return name + "";
    }

    protected boolean isInBoard(int x, int y) {
        return x >= 0 && y >= 0 && x < 8 && y < 8;
    }

}