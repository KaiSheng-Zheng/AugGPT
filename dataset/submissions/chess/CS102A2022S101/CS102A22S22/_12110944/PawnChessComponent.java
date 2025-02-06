import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name
    private ChessComponent[][] chesscomponents;
    public PawnChessComponent(char name, ChessColor chessColor,ChessComponent[][] chesscomponents, ChessboardPoint source) {
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
     if(chesscomponents[sourceX][sourceY].getChessColor()==ChessColor.WHITE){
         if((sourceX-targetX)==1&&Math.abs(sourceY-targetY)==1&&chesscomponents[targetX][targetY].getChessColor()==ChessColor.BLACK){
             return true;
         }
     }
     if(chesscomponents[sourceX][sourceY].getChessColor()==ChessColor.BLACK){
         if((targetX-sourceX)==1&&Math.abs(sourceY-targetY)==1&&chesscomponents[targetX][targetY].getChessColor()==ChessColor.WHITE){
             return true;
         }
     }
     if(chesscomponents[sourceX][sourceY].getChessColor()==ChessColor.WHITE&&sourceX==6){
         if(sourceY==targetY&&targetX==5){
             if(chesscomponents[5][sourceY].getChessColor()==ChessColor.NONE){
                 return true;
             }
         }else if(sourceY==targetY&&targetX==4){
             if(chesscomponents[5][sourceY].getChessColor()==ChessColor.NONE&&chesscomponents[4][sourceY].getChessColor()==ChessColor.NONE){
                 return true;
             }
         }
     }
        else if(chesscomponents[sourceX][sourceY].getChessColor()==ChessColor.BLACK&&sourceX==1){
         if(sourceY==targetY&&targetX==2){
             if(chesscomponents[2][sourceY].getChessColor()==ChessColor.NONE){
                 return true;
             }
         }else if(sourceY==targetY&&targetX==3){
             if(chesscomponents[2][sourceY].getChessColor()==ChessColor.NONE&&chesscomponents[3][sourceY].getChessColor()==ChessColor.NONE){
                 return true;
             }
         }
        }
        else if(chesscomponents[sourceX][sourceY].getChessColor()==ChessColor.WHITE&&((sourceX-targetX)==1)&&sourceY==targetY){
         return chesscomponents[targetX][targetY].getChessColor() == ChessColor.NONE;
            }
        else if(chesscomponents[sourceX][sourceY].getChessColor()==ChessColor.BLACK&&((targetX-sourceX)==1)&&sourceY==targetY){
         return chesscomponents[targetX][targetY].getChessColor() == ChessColor.NONE;
     }
        return false;
    }}