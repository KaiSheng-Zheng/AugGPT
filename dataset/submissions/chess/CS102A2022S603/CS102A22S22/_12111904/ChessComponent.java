import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    static ChessComponent[][] chessComponents;

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    //should design
    public ChessComponent(){}

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

}

 class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>chess=new ArrayList<>();
        if (getChessColor()==ChessColor.WHITE){
            for (int i=-1;i<=1;i++){
                for (int j = -1;j<=1;j++){
            ChessboardPoint chessboardPoint=getSource().offset(i,j);
            if(!(chessboardPoint==null)){
            if (!(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() == ChessColor.WHITE)){
                chess.add(chessboardPoint);
            }
            }
            }
            }return chess;
        }else if (getChessColor()==ChessColor.BLACK){
            for (int i=-1;i<=1;i++){
                for (int j = -1;j<=1;j++){
                    ChessboardPoint chessboardPoint=getSource().offset(i,j);
                    if (!(chessboardPoint==null)){
                    if (!(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK)){
                        chess.add(chessboardPoint);
                    }}
                }
            }return chess;
        }else {
            return chess;
        }

    }
     public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
         super(source,chessColor,name);
     }
 }

 class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>chess=new ArrayList<>();
        if (getChessColor()==ChessColor.WHITE){
            ChessboardPoint chessboardPoint;
            for (int i = 1;i<8;i++){
                 chessboardPoint=getSource().offset(i,i);
                if (!(chessboardPoint==null)){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                    chess.add(chessboardPoint);
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                    break;
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                    chess.add(chessboardPoint);
                    break;
                }}
            }for (int i = -1;i>-8;i--){
                 chessboardPoint=getSource().offset(i,i);
                if (!(chessboardPoint==null)){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                    chess.add(chessboardPoint);
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                    break;
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                    chess.add(chessboardPoint);

                    break;
                }}
            }for (int i = 1;i<8;i++){

                 chessboardPoint=getSource().offset(i,-i);
                if (!(chessboardPoint==null)){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                    chess.add(chessboardPoint);
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                    break;
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                    chess.add(chessboardPoint);
                    break;
                }}
            }for (int i = 1;i<8;i++){
                 chessboardPoint=getSource().offset(-i,i);
                if (!(chessboardPoint==null)){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                    chess.add(chessboardPoint);
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                    break;
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                    chess.add(chessboardPoint);
                    break;
                }}
            }for (int i = 1;i<8;i++){
                 chessboardPoint=getSource().offset(i,0);
                if (!(chessboardPoint==null)){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                    chess.add(chessboardPoint);
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                    break;
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                    chess.add(chessboardPoint);
                    break;
                }}
            }for (int i = 1;i<8;i++){
                 chessboardPoint=getSource().offset(0,i);
                if (!(chessboardPoint==null)){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                    chess.add(chessboardPoint);
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                    break;
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                    chess.add(chessboardPoint);
                    break;
                }}
            }for (int i = 1;i<8;i++){
                 chessboardPoint=getSource().offset(-i,0);
                if (!(chessboardPoint==null)){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                    chess.add(chessboardPoint);
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                    break;
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                    chess.add(chessboardPoint);
                    break;
                }}
            }for (int i = 1;i<8;i++){
                 chessboardPoint=getSource().offset(0,-i);
                if (!(chessboardPoint==null)){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                    chess.add(chessboardPoint);
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                    break;
                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                    chess.add(chessboardPoint);
                    break;
                }}
            }//return chess;
        }else if (getChessColor()==ChessColor.BLACK){
            ChessboardPoint chessboardPoint;
            for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(i,i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){

                        chess.add(chessboardPoint);

                        break;
                    }}
            }for (int i = -1;i>-8;i--){
                chessboardPoint=getSource().offset(i,i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        chess.add(chessboardPoint);

                        break;
                    }}
            }for (int i = 1;i<8;i++){

                chessboardPoint=getSource().offset(i,-i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(-i,i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(i,0);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(0,i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(-i,0);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(0,-i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }//return chess;
        }return chess;
    }
     public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
         super(source,chessColor,name);
     }
}

 class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chess=new ArrayList<>();
        ChessboardPoint chessboardPoint;
        if (getChessColor()==ChessColor.WHITE){
            for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(i,0);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(0,i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(-i,0);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(0,-i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }
        }else if (getChessColor()==ChessColor.BLACK){
            for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(i,0);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(0,i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(-i,0);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(0,-i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }
        }
        return chess;
    }
     public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
         super(source,chessColor,name);
     }
}

 class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>chess=new ArrayList<>();
        ChessboardPoint chessboardPoint;
        if (getChessColor()==ChessColor.WHITE) {
            for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(i,i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        chess.add(chessboardPoint);

                        break;
                    }}
            }for (int i = -1;i>-8;i--){
                chessboardPoint=getSource().offset(i,i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        chess.add(chessboardPoint);

                        break;
                    }}
            }for (int i = 1;i<8;i++){

                chessboardPoint=getSource().offset(i,-i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(-i,i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }
        }else if (getChessColor()==ChessColor.BLACK){
            for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(i,i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){

                        chess.add(chessboardPoint);

                        break;
                    }}
            }for (int i = -1;i>-8;i--){
                chessboardPoint=getSource().offset(i,i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        chess.add(chessboardPoint);

                        break;
                    }}
            }for (int i = 1;i<8;i++){

                chessboardPoint=getSource().offset(i,-i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }for (int i = 1;i<8;i++){
                chessboardPoint=getSource().offset(-i,i);
                if (!(chessboardPoint==null)){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){
                        chess.add(chessboardPoint);
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                        break;
                    }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                        chess.add(chessboardPoint);
                        break;
                    }}
            }
        }
        return chess;
    }
     public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
         super(source,chessColor,name);
     }
}

 class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int[]dx={1,2,-1,-2,1,2,-1,-2};
        int[]dy={2,1,-2,-1,-2,-1,2,1};
        ChessboardPoint chessboardPoint;
        List<ChessboardPoint>chess=new ArrayList<>();
        if (getChessColor()==ChessColor.WHITE){
            for (int i = 0;i<8;i++){
                if (getSource().getX()+dx[i]<=7&&getSource().getX()+dx[i]>=0&&
                getSource().getY()+dy[i]<=7&&getSource().getY()+dy[i]>=0){
                    chessboardPoint=new ChessboardPoint(getSource().getX()+dx[i], getSource().getY()+dy[i] );
                }else continue;

                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){

                        chess.add(chessboardPoint);

                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){

                        chess.add(chessboardPoint);


                }
            }
        }
        if (getChessColor()==ChessColor.BLACK){
            for (int i = 0;i<8;i++){
                if (getSource().getX()+dx[i]<=7&&getSource().getX()+dx[i]>=0&&
                        getSource().getY()+dy[i]<=7&&getSource().getY()+dy[i]>=0){
                    chessboardPoint=new ChessboardPoint(getSource().getX()+dx[i], getSource().getY()+dy[i] );
                }else continue;
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.NONE){

                        chess.add(chessboardPoint);

                }else if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){

                        chess.add(chessboardPoint);


                }
            }
        }
        return chess;
    }
     public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
         super(source,chessColor,name);
     }
}

 class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>chess=new ArrayList<>();
        if (getChessColor()==ChessColor.WHITE){
            if (getSource().getX()==6&&chessComponents[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE&&chessComponents[getSource().getX()-2][getSource().getY()].getChessColor()==ChessColor.NONE){
                ChessboardPoint chessboardPoint2=getSource().offset(-2,0);
                if (!(chessboardPoint2 == null)){
                    chess.add(chessboardPoint2);
                }
            } if (getSource().getX()>0&&chessComponents[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE){
                ChessboardPoint chessboardPoint=getSource().offset(-1,0);
                if (!(chessboardPoint == null)){
                    chess.add(chessboardPoint);
                }
            }if (getSource().getX()>0&&getSource().getY()<7&&chessComponents[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK){
                ChessboardPoint chessboardPoint=getSource().offset(1,-1);
                if (!(chessboardPoint == null)){
                    chess.add(chessboardPoint);
                }
            }if (getSource().getX()>0&&getSource().getY()>0&&chessComponents[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                ChessboardPoint chessboardPoint=getSource().offset(-1,-1);
                if (!(chessboardPoint == null)){
                    chess.add(chessboardPoint);
                }
            }
        }else if (getChessColor()==ChessColor.BLACK){
            if (getSource().getX()==1&&chessComponents[getSource().getX()+1][getSource().getY()].getChessColor()==ChessColor.NONE&&chessComponents[getSource().getX()+2][getSource().getY()].getChessColor()==ChessColor.NONE){
                ChessboardPoint chessboardPoint2=getSource().offset(2,0);
                if (!(chessboardPoint2 == null)){
                    chess.add(chessboardPoint2);
                }
            } if (getSource().getX()<8&&chessComponents[getSource().getX()+1][getSource().getY()].getChessColor()==ChessColor.NONE){
                ChessboardPoint chessboardPoint=getSource().offset(1,0);
                if (!(chessboardPoint == null)){
                    chess.add(chessboardPoint);
                }
            }if (getSource().getX()<8&&getSource().getY()>0&&chessComponents[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                ChessboardPoint chessboardPoint=getSource().offset(1,-1);
                if (!(chessboardPoint == null)){
                    chess.add(chessboardPoint);
                }
            }if (getSource().getX()<8&&getSource().getY()<7&&chessComponents[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                ChessboardPoint chessboardPoint=getSource().offset(1,1);
                if (!(chessboardPoint == null)){
                    chess.add(chessboardPoint);
                }
            }
        }return chess;
    }
     public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
         super(source,chessColor,name);
     }
}

 class EmptySlotComponent extends ChessComponent{
     @Override
     public List<ChessboardPoint> canMoveTo() {

         return null;
     }
     public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor,char name){
         super(source,chessColor,name);
     }
 }