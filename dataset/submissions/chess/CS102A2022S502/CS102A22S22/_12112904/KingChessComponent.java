import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] c=super.getChessComponents();
        List<ChessboardPoint> a=new ArrayList<>();
        if(super.getChessColor()==ChessColor.WHITE){
        if((super.getSource().getX()-1)>=0&&(super.getSource().getY()-1)>=0&&!Character.isLowerCase(c[super.getSource().getX()-1][super.getSource().getY()-1].getName())){
            a.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
        }
        if((super.getSource().getX()-1)>=0&&!Character.isLowerCase(c[super.getSource().getX()-1][super.getSource().getY()].getName())){
            a.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
        }
        if((super.getSource().getX()-1)>=0&&(super.getSource().getY()+1)<=7&&!Character.isLowerCase(c[super.getSource().getX()-1][super.getSource().getY()+1].getName())){
            a.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
        }
        if((super.getSource().getY()-1)>=0&&!Character.isLowerCase(c[super.getSource().getX()][super.getSource().getY()-1].getName())){
            a.add(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
        }
        if((super.getSource().getY()+1)<=7&&!Character.isLowerCase(c[super.getSource().getX()][super.getSource().getY()+1].getName())){
            a.add(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
        }
        if((super.getSource().getX()+1)<=7&&(super.getSource().getY()-1)>=0&&!Character.isLowerCase(c[super.getSource().getX()+1][super.getSource().getY()-1].getName())){
            a.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
        }
        if((super.getSource().getX()+1)<=7&&!Character.isLowerCase(c[super.getSource().getX()+1][super.getSource().getY()].getName())){
            a.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
        }
        if((super.getSource().getX()+1)<=7&&(super.getSource().getY()+1)<=7&&!Character.isLowerCase(c[super.getSource().getX()+1][super.getSource().getY()+1].getName())){
            a.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
        }
        }else {
            if((super.getSource().getX()-1)>=0&&(super.getSource().getY()-1)>=0&&!Character.isUpperCase(c[super.getSource().getX()-1][super.getSource().getY()-1].getName())){
                a.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
            }
            if((super.getSource().getX()-1)>=0&&!Character.isUpperCase(c[super.getSource().getX()-1][super.getSource().getY()].getName())){
                a.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
            }
            if((super.getSource().getX()-1)>=0&&(super.getSource().getY()+1)<=7&&!Character.isUpperCase(c[super.getSource().getX()-1][super.getSource().getY()+1].getName())){
                a.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
            }
            if((super.getSource().getY()-1)>=0&&!Character.isUpperCase(c[super.getSource().getX()][super.getSource().getY()-1].getName())){
                a.add(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
            }
            if((super.getSource().getY()+1)<=7&&!Character.isUpperCase(c[super.getSource().getX()][super.getSource().getY()+1].getName())){
                a.add(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
            }
            if((super.getSource().getX()+1)<=7&&(super.getSource().getY()-1)>=0&&!Character.isUpperCase(c[super.getSource().getX()+1][super.getSource().getY()-1].getName())){
                a.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
            }
            if((super.getSource().getX()+1)<=7&&!Character.isUpperCase(c[super.getSource().getX()+1][super.getSource().getY()].getName())){
                a.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
            }
            if((super.getSource().getX()+1)<=7&&(super.getSource().getY()+1)<=7&&!Character.isUpperCase(c[super.getSource().getX()+1][super.getSource().getY()+1].getName())){
                a.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
            }
        }
        return a;
    }
}