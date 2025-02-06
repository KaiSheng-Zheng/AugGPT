import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name
    private ChessComponent[][] chesscomponents;
    public RookChessComponent(char name, ChessColor chessColor,ChessComponent[][] chesscomponents, ChessboardPoint source) {
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
        int x1 = Math.min(sourceX,targetX);
        int x2 = Math.max(sourceX,targetX);
        int y1 = Math.min(sourceY,targetY);
        int y2 = Math.max(sourceY,targetY);
        if((sourceX==targetX)&&(sourceY==targetY)){
            return false;
        }
        if((sourceX!=targetX)&&(sourceY!=targetY)){
                return false;
        }
        if(sourceY==targetY){
            for (int i = x1; i <=x2 ; i++) {
                if(i!=sourceX){
                    if(i ==targetX&&chesscomponents[targetX][targetY].getChessColor()!=ChessColor.NONE){
                        if(chesscomponents[targetX][targetY].getChessColor()==chesscomponents[sourceX][sourceY].getChessColor()){
                            return false;
                        }
                    }else if(chesscomponents[i][sourceY].getChessColor()!=ChessColor.NONE){
                        return false;
                    }
                }
            }return true;
        }
            for (int i = y1; i <=y2 ; i++) {
                if(i!=sourceY){
                    if(i ==targetY&&chesscomponents[targetX][targetY].getChessColor()!=ChessColor.NONE){
                        if(chesscomponents[targetX][targetY].getChessColor()==chesscomponents[sourceX][sourceY].getChessColor()){
                            return false;
                        }
                    }else if(chesscomponents[sourceX][i].getChessColor()!=ChessColor.NONE){
                        return false;
                    }
                }
            }return true;
    }
}