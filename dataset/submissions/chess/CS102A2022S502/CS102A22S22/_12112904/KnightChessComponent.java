import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a=new ArrayList<>();
        ChessComponent[][] c=super.getChessComponents();
        if(getChessColor()==ChessColor.WHITE){
            if(getSource().getX()+2<=7&&getSource().getY()+1<=7&&!(Character.isLowerCase(c[getSource().getX()+2][getSource().getY()+1].getName()))){
                a.add(super.getSource().offset(2,1));
            }
            if(getSource().getX()+2<=7&&getSource().getY()-1>=0&&(!Character.isLowerCase(c[getSource().getX()+2][getSource().getY()-1].getName()))){
                a.add(super.getSource().offset(2,-1));
            }
            if(getSource().getX()+1<=7&&getSource().getY()+2<=7&&!(Character.isLowerCase(c[getSource().getX()+1][getSource().getY()+2].getName()))){
                a.add(super.getSource().offset(1,2));
            }
            if(getSource().getX()+2<=7&&getSource().getY()-2>=0&&!Character.isLowerCase(c[getSource().getX()+1][getSource().getY()-2].getName())){
                a.add(super.getSource().offset(1,-2));
            }
            if(getSource().getX()-1>=0&&getSource().getY()+2<=7&&!Character.isLowerCase(c[getSource().getX()-1][getSource().getY()+2].getName())){
                a.add(super.getSource().offset(-1,2));
            }
            if(getSource().getX()-1>=0&&getSource().getY()-2>=0&&!Character.isLowerCase(c[getSource().getX()-1][getSource().getY()-2].getName())){
                a.add(super.getSource().offset(-1,-2));
            }
            if(getSource().getX()-2>=0&&getSource().getY()+1<=7&&!Character.isLowerCase(c[getSource().getX()-2][getSource().getY()+1].getName())){
                a.add(super.getSource().offset(-2,1));
            }
            if(getSource().getX()-2>=0&&getSource().getY()-1>=0&&!Character.isLowerCase(c[getSource().getX()-2][getSource().getY()-1].getName())){
                a.add(super.getSource().offset(-2,-1));
            }
        }else {
            if(getSource().getX()+2<=7&&getSource().getY()+1<=7&&!(Character.isUpperCase(c[getSource().getX()+2][getSource().getY()+1].getName()))){
                a.add(super.getSource().offset(2,1));
            }
            if(getSource().getX()+2<=7&&getSource().getY()-1>=0&&(!Character.isUpperCase(c[getSource().getX()+2][getSource().getY()-1].getName()))){
                a.add(super.getSource().offset(2,-1));
            }
            if(getSource().getX()+1<=7&&getSource().getY()+2<=7&&!(Character.isUpperCase(c[getSource().getX()+1][getSource().getY()+2].getName()))){
                a.add(super.getSource().offset(1,2));
            }
            if(getSource().getX()+2<=7&&getSource().getY()-2>=0&&!Character.isUpperCase(c[getSource().getX()+1][getSource().getY()-2].getName())){
                a.add(super.getSource().offset(1,-2));
            }
            if(getSource().getX()-1>=0&&getSource().getY()+2<=7&&!Character.isUpperCase(c[getSource().getX()-1][getSource().getY()+2].getName())){
                a.add(super.getSource().offset(-1,2));
            }
            if(getSource().getX()-1>=0&&getSource().getY()-2>=0&&!Character.isUpperCase(c[getSource().getX()-1][getSource().getY()-2].getName())){
                a.add(super.getSource().offset(-1,-2));
            }
            if(getSource().getX()-2>=0&&getSource().getY()+1<=7&&!Character.isUpperCase(c[getSource().getX()-2][getSource().getY()+1].getName())){
                a.add(super.getSource().offset(-2,1));
            }
            if(getSource().getX()-2>=0&&getSource().getY()-1>=0&&!Character.isUpperCase(c[getSource().getX()-2][getSource().getY()-1].getName())){
                a.add(super.getSource().offset(-2,-1));
            }
        }
        return a;
    }
}