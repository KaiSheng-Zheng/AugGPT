import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    //should design
    public ChessComponent(){
    }

    public ChessComponent(ChessboardPoint source){
        this.source = source;
    }
    public ChessComponent(ChessboardPoint source, ChessColor chessColor,ChessComponent[][] chessComponents) {
        this.source = source;
        this.chessColor = chessColor;
        this.chessboard = new ChessComponent[8][8];
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

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

    public ChessComponent[][] getChessComponents() {
        return chessboard;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessboard = chessComponents;
    }

    public List<ChessboardPoint> Sort(List<ChessboardPoint> chess){
        for (int i = 0; i < chess.size(); i++) {
            for (int j = i; j < chess.size(); j++) {
                if (chess.get(i).getX()>chess.get(j).getX()){
                    ChessboardPoint a = chess.get(i);
                    ChessboardPoint b = chess.get(j);
                    chess.set(i,b);
                    chess.set(j,a);
                }
                else {
                    if (chess.get(i).getX() == chess.get(j).getX()){
                        if (chess.get(i).getY() > chess.get(j).getY()){
                            ChessboardPoint a = chess.get(i);
                            ChessboardPoint b = chess.get(j);
                            chess.set(i,b);
                            chess.set(j,a);
                        }
                    }
                }
            }
        }
        return chess;
    }

}
