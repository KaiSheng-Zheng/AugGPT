import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessColor chessColor, char name, int x, int y, ChessComponent[][] chessComponents) {
        super(chessColor, name, x, y, chessComponents);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        //xiang
        ArrayList<ChessboardPoint> temp=new ArrayList<>();
        //you,shang
        int a=Math.min(7- getSource().getX(),getSource().getY());
        if (a!=0){
        for (int i=1;i<=a;i++){
            if (!array[getSource().getX()+i][getSource().getY()-i].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()-i ));
            }else{break;}
        }}
        //zuo,xia
        int b=Math.min(getSource().getX(), 7-getSource().getY());
        if (b!=0){
        for (int i=1;i<=b;i++){
            if (!array[getSource().getX()-i][getSource().getY()+i].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()+i ));
            }else{break;}
        }}
        //you,xia
        int c=Math.min(7- getSource().getX(), 7-getSource().getY());
        if (c!=0){
        for (int i=1;i<=c;i++){
            if (!array[getSource().getX()+i][getSource().getY()+i].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()+i ));
            }else{break;}
        }}
        //zuo,shang
        int d= Math.min(getSource().getX(),getSource().getY());
        if (d!=0){
        for (int i=1;i<=d;i++){
            if (!array[getSource().getX()-i][getSource().getY()-i].getChessColor().equals(getChessColor())){
                temp.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()-i ));
            }else{break;}
        }}
        return temp;
    }
}
