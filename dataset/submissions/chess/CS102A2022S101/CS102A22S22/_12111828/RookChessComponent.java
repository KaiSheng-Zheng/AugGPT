import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setChessColor(chessColor);setSource(source);
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move=new ArrayList<>();
        for (int i=1;i<=7;i++){
            if(getSource().getX()+i<8){
                if(isSameColor(getSource(),getSource().offset(i,0))){break;}
                move.add(getSource().offset(i,0));
                if (isOppositeColor(getSource(),getSource().offset(i,0))){break;}
            }else {break;}
        }
        for (int i=1;i<=7;i++){
            if(getSource().getX()-i>=0){
                if(isSameColor(getSource(),getSource().offset(-i,0))){break;}
                move.add(getSource().offset(-i,0));
                if (isOppositeColor(getSource(),getSource().offset(-i,0))){break;}
            }else {break;}
        }
        for (int i=1;i<=7;i++){
            if(getSource().getY()+i<8){
                if(isSameColor(getSource(),getSource().offset(0,i))){break;}
                move.add(getSource().offset(0,i));
                if (isOppositeColor(getSource(),getSource().offset(0,i))){break;}
            }else {break;}
        }
        for (int i=1;i<=7;i++){
            if(getSource().getY()-i>=0){
                if(isSameColor(getSource(),getSource().offset(0,-i))){break;}
                move.add(getSource().offset(0,-i));
                if (isOppositeColor(getSource(),getSource().offset(0,-i))){break;}
            }else {break;}
        }
        return move;
    }
}

