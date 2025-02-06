import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor chessColor, char name, int x, int y, ChessComponent[][] chessComponents) {
        super(chessColor, name, x, y, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
 //che
        ArrayList<ChessboardPoint> temp=new ArrayList<>();
        //you
        int x =7- getSource().getX();
        if (x!=0){
        for (int i=1;i<=x;i++){
            if (!array[getSource().getX()+i][getSource().getY()].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()));
            }else{break;}
        }}
        //zuo
        if (getSource().getX()!=0){
        for (int i=1;i<=getSource().getX();i++){
            if (!array[getSource().getX()-i][getSource().getY()].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()));
            }else{break;}
        }}
        //shang
        if (getSource().getY()!=0){
        for (int i=1;i<=getSource().getY();i++){
            if (!array[getSource().getX()][getSource().getY()-i].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX(), getSource().getY()-i));
            }else{break;}
        }}
        //xia
        int y=7-getSource().getY();
        if (y!=0){
        for (int i=1;i<=y;i++){
            if (!array[getSource().getX()][getSource().getY()+i].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX(), getSource().getY()+i));
            }else{break;}
        }}
        return temp;
    }
}

