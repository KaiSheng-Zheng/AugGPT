import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    protected ChessComponent[][] chessboard;

//    protected ConcreteChessGame game;

    //should design
    public ChessComponent(){
    }
    public ChessComponent(ChessComponent[][] chessboard,ChessboardPoint source,char name) {
        this.chessboard=chessboard;
        this.source=source;
        this.name=name;
        if(name>='a'&name<='z'){
            chessColor=ChessColor.WHITE;
        }else if(name>='A'&name<='Z'){
            chessColor=ChessColor.BLACK;
        }
    }
    public boolean checkColor(ChessColor destinationColor){
        return chessColor.equals(destinationColor);
    }
    public boolean checkPosition(int x,int y){
        return x<8&x>=0&y>=0&y<8;
    }
    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();
    //If no ChessboardPoint can be moved to, return an reference of empty List instead of null

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
