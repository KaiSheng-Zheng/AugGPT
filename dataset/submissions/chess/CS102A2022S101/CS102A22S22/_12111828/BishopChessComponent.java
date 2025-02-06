import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {


    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setChessColor(chessColor);setSource(source);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move=new ArrayList<>();
        for (int i=1;i<=7;i++){
            if(getSource().getX()+i<8&&getSource().getY()+i<8){
                if(isSameColor(getSource(),getSource().offset(i,i))){break;}
                move.add(getSource().offset(i,i));
                if (isOppositeColor(getSource(),getSource().offset(i,i))){break;}
            }else {break;}
        }
        for (int i=1;i<=7;i++){
            if(getSource().getX()-i>=0&&getSource().getY()+i<8){
                if(isSameColor(getSource(),getSource().offset(-i,i))){break;}
                move.add(getSource().offset(-i,i));
                if (isOppositeColor(getSource(),getSource().offset(-i,i))){break;}
            }else {break;}
        }
        for (int i=1;i<=7;i++){
            if(getSource().getY()-i>=0&&getSource().getX()+i<8){
                if(isSameColor(getSource(),getSource().offset(i,-i))){break;}
                move.add(getSource().offset(i,-i));
                if (isOppositeColor(getSource(),getSource().offset(i,-i))){break;}
            }else {break;}
        }
        for (int i=1;i<=7;i++){
            if(getSource().getY()-i>=0&&getSource().getX()-i>=0){
                if(isSameColor(getSource(),getSource().offset(-i,-i))){break;}
                move.add(getSource().offset(-i,-i));
                if (isOppositeColor(getSource(),getSource().offset(-i,-i))){break;}
            }else {break;}
        }
        return move;
    }

}
