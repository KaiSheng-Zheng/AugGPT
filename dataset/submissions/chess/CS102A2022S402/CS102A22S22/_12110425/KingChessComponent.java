import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(char a,ChessColor chessColor,int x,int y,ChessComponent[][] chessComponents){
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
        if (test(1,0)&&this.chessComponents[this.getSource().getX()+1][this.getSource().getY()].getChessColor()!=this.getChessColor())
        New.add(Test.offset(1,0));
        if (test(1,1)&&this.chessComponents[this.getSource().getX()+1][this.getSource().getY()+1].getChessColor()!=this.getChessColor())
        New.add(Test.offset(1,1));
        if (test(0,1)&&this.chessComponents[this.getSource().getX()][this.getSource().getY()+1].getChessColor()!=this.getChessColor())
        New.add(Test.offset(0,1));
        if (test(-1,0)&&this.chessComponents[this.getSource().getX()-1][this.getSource().getY()].getChessColor()!=this.getChessColor())
        New.add(Test.offset(-1,0));
        if (test(-1,1)&&this.chessComponents[this.getSource().getX()-1][this.getSource().getY()+1].getChessColor()!=this.getChessColor())
        New.add(Test.offset(-1,1));
        if (test(-1,-1)&&this.chessComponents[this.getSource().getX()-1][this.getSource().getY()-1].getChessColor()!=this.getChessColor())
        New.add(Test.offset(-1,-1));
        if (test(1,-1)&&this.chessComponents[this.getSource().getX()+1][this.getSource().getY()-1].getChessColor()!=this.getChessColor())
        New.add(Test.offset(1,-1));
        if (test(0,-1)&&this.chessComponents[this.getSource().getX()][this.getSource().getY()-1].getChessColor()!=this.getChessColor())
        New.add(Test.offset(0,-1));
        return New;
    }

}
