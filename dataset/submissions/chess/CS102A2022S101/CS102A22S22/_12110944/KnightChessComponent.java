import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name
    private ChessComponent[][] chesscomponents;
    public KnightChessComponent(char name, ChessColor chessColor,ChessComponent[][] chesscomponents, ChessboardPoint source) {
        super(name, chessColor, chesscomponents,source);
        this.name=name;
        this.source=source;
        this.chessColor = chessColor;
        this.chesscomponents=chesscomponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result= new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(canMoveChess(getChessboardPoint().getX(),getChessboardPoint().getY(),i,j)){
                    result.add(new ChessboardPoint(i,j));
                }
            }
        }return result;
    }

    public boolean canMoveChess(int sourceX, int sourceY, int targetX, int targetY) {
        Boolean B = false;
        if(Math.abs(sourceX-targetX)==1&&Math.abs(sourceY-targetY)==2){
            B = true;
        }
        if(Math.abs(sourceX-targetX)==2&Math.abs(sourceY-targetY)==1){
            B = true;
        }
        if(!B){
            return false;}
        return chesscomponents[targetX][targetY].getChessColor() != chesscomponents[sourceX][sourceY].getChessColor();
    }
}
