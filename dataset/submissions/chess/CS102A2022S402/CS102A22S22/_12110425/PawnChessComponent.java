import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    int times = 0;
    public PawnChessComponent(char a,ChessColor chessColor,int x,int y,ChessComponent[][] chessComponents){
        super(x, y);
        this.chessComponents = chessComponents;
        this.name = a;
        setChessColor(chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> New = new ArrayList<>();
        ChessboardPoint Test = new ChessboardPoint(this.getSource().getX(),this.getSource().getY());
        if (this.getChessColor()==ChessColor.WHITE){
        if (getSource().getX()==6){
            if (test(-1,0)&&this.chessComponents[this.getSource().getX()-1][this.getSource().getY()].getChessColor()==ChessColor.NONE)
            {New.add(Test.offset(-1,0));
            if (test(-2,0)&&this.chessComponents[this.getSource().getX()-2][this.getSource().getY()].getChessColor()==ChessColor.NONE)
            {New.add(Test.offset(-2,0));}
            }
        }
        else {
            if (test(-1,0)&&this.chessComponents[this.getSource().getX()-1][this.getSource().getY()].getChessColor()==ChessColor.NONE)
            {New.add(Test.offset(-1,0));}
        }
            if (test(-1,1)&&this.chessComponents[this.getSource().getX()-1][this.getSource().getY()+1].getChessColor()==ChessColor.BLACK){
                New.add(Test.offset(-1,1));
            }if (test(-1,-1)&&this.chessComponents[this.getSource().getX()-1][this.getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                New.add(Test.offset(-1,-1));
            }
        }
        else {
            if (getSource().getX()==1){
                if (test(1,0)&&this.chessComponents[this.getSource().getX()+1][this.getSource().getY()].getChessColor()==ChessColor.NONE)
                {New.add(Test.offset(1,0));
                if (test(2,0)&&this.chessComponents[this.getSource().getX()+2][this.getSource().getY()].getChessColor()==ChessColor.NONE)
                New.add(Test.offset(2,0));
                for (ChessboardPoint a : New){
                    System.out.println(a);
                }
                }
            }
            else {
                if (test(1,0)&&this.chessComponents[this.getSource().getX()+1][this.getSource().getY()].getChessColor()==ChessColor.NONE)
                New.add(Test.offset(1,0));
            }
            if (test(1,1)&&this.chessComponents[this.getSource().getX()+1][this.getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                New.add(Test.offset(1,1));
            }
            if (test(1,-1)&&this.chessComponents[this.getSource().getX()+1][this.getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                New.add(Test.offset(1,-1));
            }
        }
        System.out.println(this.name);
        return New;
    }
}
