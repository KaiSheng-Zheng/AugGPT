import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessColor chessColor, char name, int x, int y, ChessComponent[][] chessComponents) {
        super(chessColor, name, x, y, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> temp=new ArrayList<>();
 //che
        //x
        int a =8- getSource().getX();
        for (int i=1;i<=a;i++){
            if (!array[getSource().getX()+i][getSource().getY()].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()));
            }else{break;}
        }
        for (int i=-1;i>=-getSource().getX();i--){
            if (!array[getSource().getX()+i][getSource().getY()].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()));
            }else{break;}
        }
        //y
        int b=8- getSource().getY();
        for (int i=1;i<=b;i++){
            if (!array[getSource().getX()][getSource().getY()+i].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX(), getSource().getY()+i));
            }else{break;}
        }
        for (int i=-1;i>=- getSource().getY();i--){
            if (!array[getSource().getX()][getSource().getY()+i].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX(), getSource().getY()+i));
            }else{break;}
        }
//xiang
        //++
        int x=Math.min(8- getSource().getX(),8- getSource().getY());
        for (int i=1;i<=x;i++){
            if (!array[getSource().getX()+i][getSource().getY()+i].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()+i ));
            }else{break;}
        }
        //--
        int y=Math.min(getSource().getX(), getSource().getY());
        for (int i=-1;i>=y;i--){
            if (!array[getSource().getX()+i][getSource().getY()+i].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()+i ));
            }else{break;}
        }
        //+-
        int c=Math.min(8- getSource().getX(), getSource().getY());
        for (int i=1;i<=c;i++){
            if (!array[getSource().getX()+i][getSource().getY()-i].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()-i ));
            }else{break;}
        }
        //-+
        int d= Math.min(getSource().getX(),8- getSource().getY());
        for (int i=1;i<=d;i++){
            if (!array[getSource().getX()-i][getSource().getY()+i].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()+i ));
            }else{break;}
        }
        return temp;
    }
}
