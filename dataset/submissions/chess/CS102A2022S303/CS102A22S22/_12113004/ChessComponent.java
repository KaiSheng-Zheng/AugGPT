import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //This class is an abstract class
    //This class helps to represent all the chess components on the chessboard.
    //This class provides a rough description for all the chess pieces.
    //Abstract methods should be left in abstract form for further implementation,
    //you don't need to write codes for them in detail.

    private ChessboardPoint source;
    // Where the chess is
    private ChessColor chessColor;
    // What's the color
    protected char name;

    public static ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public static void setChessComponents(ChessComponent[][] chessComponents) {
        ChessComponent.chessComponents = chessComponents;
    }

    // What's the name
    static ChessComponent[][] chessComponents;


    /**
     * A none parameter constructor should be defined,
     * even though we do not care whether there is any statement in it.
     */
    public ChessComponent(){}

    /**
     * This abstract method tells where this chess piece can move to.
     * If no ChessboardPoint can be moved to, return a reference of empty List instead of null.
     * @return
     */
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    /**
     * Return the name of current chess piece.
     * @return the name of current chess piece
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public List<ChessboardPoint> moveAndEat(int x, int y, int dx1, int dy2){
        List<ChessboardPoint> output = new ArrayList<>();
        boolean enemy = false;
        for (int i = 1; i <= 8; i++) {
            int dx = dx1*i;
            int dy = dy2*i;
            first:{
                if (new ChessboardPoint(x,y).canMove(dx, dy)){
                    //As long as it
                    // s a different color
                    switch (getChessColor()){
                        case BLACK :
                        {
                            switch (chessComponents[x+dx][y+dy].getChessColor()){
                                case NONE :
                                    if (!enemy){
                                        output.add(new ChessboardPoint(x+dx,y+dy));
                                    }
                                    break first;
                                case WHITE:
                                    if (!enemy){
                                        enemy = true;
                                        output.add(new ChessboardPoint(x+dx,y+dy));
                                    }
                                    break first;
                                case BLACK:
                                    enemy = true;
                                    break first;
                            }
                        }
                        case WHITE:
                        {
                            switch (chessComponents[x + dx][y + dy].getChessColor()) {
                                case NONE:
                                    if (!enemy){
                                        output.add(new ChessboardPoint(x+dx,y+dy));
                                    }
                                    break first;
                                case BLACK:
                                    if (!enemy){
                                        enemy = true;
                                        output.add(new ChessboardPoint(x+dx,y+dy));
                                    }
                                    break first;
                                case WHITE:
                                    enemy = true;
                                    break first;
                            }
                        }
                        case NONE:
                            return new ArrayList<>();
                    }
                }
            }
        }
        return output;

    }

}
