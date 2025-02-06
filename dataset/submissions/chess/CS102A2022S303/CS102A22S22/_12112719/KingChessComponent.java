import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
//        chessPos.add(this);
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

//    private ArrayList<ChessboardPoint> canmoveto = new ArrayList<>();
public String toString() {
    if (getChessColor()==ChessColor.WHITE){
        return "k";
    }else return "K";
}
public void setSource(ChessboardPoint source) {
        this.source.setX(source.getX());
        this.source.setY(source.getY());
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
  
        ArrayList<ChessboardPoint> canmoveto = new ArrayList<>();
        ChessComponent[][] Board =new ChessComponent[8][8];
        int x = getSource().getX();
        int y = getSource().getY();
        Board =currentgame.getChessComponents();
        ChessboardPoint destination=new ChessboardPoint(0,0);
        int xf, yf;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                destination.setX(i);
                destination.setY(j);
                xf =destination.getX();
                yf =destination.getY();
            
                if (Math.abs(x- xf)<=1
                        && Math.abs(y- yf)<=1){
                    if (Board[i][j] instanceof EmptySlotComponent){
                        canmoveto.add(new ChessboardPoint(xf, yf));
                    }

                }
            }
        }
         return canmoveto;
//        if (chessx - 1 >= 0) {
//            if (getChess(chessx - 1, chessy) == null) {
//                canmoveto.add(new ChessboardPoint(chessx - 1, chessy));
//            }
//            if (chessy - 1 >= 0 && getChess(chessx - 1, chessy - 1) == null) {
//                canmoveto.add(new ChessboardPoint(chessx - 1, chessy - 1));
//            }
//        }
//        if (chessy - 1 >= 0) {
//            if (getChess(chessx, chessy - 1) == null) {
//                canmoveto.add(new ChessboardPoint(chessx, chessy - 1));
//            }
//            if (chessx + 1 <= 7 && getChess(chessx + 1, chessy - 1) == null) {
//                canmoveto.add(new ChessboardPoint(chessx + 1, chessy - 1));
//            }
//        }
//        if (chessx + 1 <= 7) {
//            if (getChess(chessx + 1, chessy) == null) {
//                canmoveto.add(new ChessboardPoint(chessx + 1, chessy));
//            }
//            if (chessy - 1 >= 0 && getChess(chessx + 1, chessy - 1) == null) {
//                canmoveto.add(new ChessboardPoint(chessx + 1, chessy - 1));
//            }
//        }
//        if (chessy + 1 <= 7) {
//            if (getChess(chessx, chessy + 1) == null) {
//                canmoveto.add(new ChessboardPoint(chessx, chessy + 1));
//            }
//            if (chessx + 1 <= 7 && getChess(chessx - 1, chessy + 1) == null) {
//                canmoveto.add(new ChessboardPoint(chessx - 1, chessy + 1));
//            }
//        }
//        return canmoveto;
//        for (int x = 0; x < 8; x++) {
//            for (int y = 0; y < 8; y++) {
//                if ()
//            }
//        }
//        return null;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public char getName() {
        return name;
    }
//    void loadChessGame(List<String> chessboard) {
//    }
//
//    ChessColor getCurrentPlayer() {
//        return getChessColor();
//    }
//
//    ChessComponent getChess(int x, int y) {
//        for (int i = 0; i < getChessPos().size(); i++) {
//            if (getChessPos().get(i).getSource().getX() == x && getChessPos().get(i).getSource().getY() == y) {
//                return getChessPos().get(i);
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public ChessboardPoint getSource() {
//        return source;
//    }
//
//    @Override
//    public ChessColor getChessColor() {
//        return chessColor;
//    }
//
//    @Override
//    public char getName() {
//        return name;
//    }
//
//    public ArrayList<ChessboardPoint> getCanmoveto() {
//        return canmoveto;
//    }
//
//
    //    public ChessboardPoint offset(int dx,int dy){
//        if (getSource().getX()+dx>7||getSource().getX()+dx<0||getSource().getY()+dy>7||getSource().getY()+dy<0){
//            return null;
//        }else{
//            return new ChessboardPoint(dx+getSource().getX(),dy+getSource().getY());
//        }
//    }
}
