import java.util.List;

/**
 * All concrete chess component that inherit the super class ChessComponent
 * including:
 * KingChessComponent
 * QueenChessComponent
 * RookChessComponent
 * BishopChessComponent
 * KnightChessComponent
 * PawnChessComponent
 * EmptySlotComponent
 */
public abstract class ChessComponent {
    /**
     * source: where the chess is
     * chessColor: what's the color
     * name: what's the name
     */
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    /** add my method*/
    public ChessColor getColor(){
        return chessColor;
    }

    public ChessboardPoint getBoardPoint(){return source; }

    /** An none parameter constructor should be defined, even though we do not care whether there is any
     statement in it. */
    public ChessComponent(){}

    /** add my method */
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    /**
     * This abstract method tells where this chess piece can move to.
     * @return If no ChessboardPoint can be moved to, return an reference of empty List instead of null.
     * (return new List<ChessboardPoint>;)
     */
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * @return char to String -- valueOf
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
