import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(char a,ChessColor chessColor,int x,int y,ChessComponent[][] chessComponents){
        super(x,y);
        this.chessComponents = chessComponents;
        this.name = a;
        setChessColor(chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> New = new ArrayList<>();
        ChessboardPoint Test = new ChessboardPoint(this.getSource().getX(),this.getSource().getY());
        System.out.println(this.name);
        if (test(2,1)&&this.chessComponents[this.getSource().getX()+2][this.getSource().getY()+1].getChessColor()!=this.getChessColor())
        New.add(Test.offset(2,1));
        if (test(2,-1)&&this.chessComponents[this.getSource().getX()+2][this.getSource().getY()-1].getChessColor()!=this.getChessColor())
        New.add(Test.offset(2,-1));
        if (test(-2,1)&&this.chessComponents[this.getSource().getX()-2][this.getSource().getY()+1].getChessColor()!=this.getChessColor())
        New.add(Test.offset(-2,1));
        if (test(-2,-1)&&this.chessComponents[this.getSource().getX()-2][this.getSource().getY()-1].getChessColor()!=this.getChessColor())
        New.add(Test.offset(-2,-1));
        if (test(1,2)&&this.chessComponents[this.getSource().getX()+1][this.getSource().getY()+2].getChessColor()!=this.getChessColor())
        New.add(Test.offset(1,2));
        if (test(1,-2)&&this.chessComponents[this.getSource().getX()+1][this.getSource().getY()-2].getChessColor()!=this.getChessColor())
        New.add(Test.offset(1,-2));
        if (test(-1,2)&&this.chessComponents[this.getSource().getX()-1][this.getSource().getY()+2].getChessColor()!=this.getChessColor())
        New.add(Test.offset(-1,2));
        if (test(-1,-2)&&this.chessComponents[this.getSource().getX()-1][this.getSource().getY()-2].getChessColor()!=this.getChessColor())
        New.add(Test.offset(-1,-2));
        return New;
    }

}
