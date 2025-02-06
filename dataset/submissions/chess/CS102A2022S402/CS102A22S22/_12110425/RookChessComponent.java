import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(char a,ChessColor chessColor,int x,int y,ChessComponent[][] chessComponents){
        super(x, y);
        this.name = a;
        this.chessComponents = chessComponents;
        setChessColor(chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> New = new ArrayList<>();
        ChessboardPoint Test = new ChessboardPoint(this.getSource().getX(),this.getSource().getY());
        for (int x = 1;x<8;x++){
            if (test(x,0)&&this.chessComponents[this.getSource().getX()+x][this.getSource().getY()].getChessColor()==ChessColor.NONE){
                New.add(Test.offset(x,0));
            }
            else if (test(x,0)&&this.chessComponents[this.getSource().getX()+x][this.getSource().getY()].getChessColor()!=this.getChessColor()){
                New.add(Test.offset(x,0));
                break;
            }
            else break;}
        for (int x = 1;x<8;x++){
            if (test(-x,0)&&this.chessComponents[this.getSource().getX()-x][this.getSource().getY()].getChessColor()==ChessColor.NONE){
                New.add(Test.offset(-x,0));
                System.out.println(this.chessComponents[this.getSource().getX()-x][this.getSource().getY()].getSource());
                System.out.println(this.chessComponents[this.getSource().getX()-x][this.getSource().getY()].getChessColor());
            }
            else if (test(-x,0)&&this.chessComponents[this.getSource().getX()-x][this.getSource().getY()].getChessColor()!=this.getChessColor()){
                New.add(Test.offset(-x,0));
                break;
            }
            else break;}
        for (int y = 1;y<8;y++){
            if (test(0,-y)&&this.chessComponents[this.getSource().getX()][this.getSource().getY()-y].getChessColor()==ChessColor.NONE){
                New.add(Test.offset(0,-y));
            }
            else if (test(0,-y)&&this.chessComponents[this.getSource().getX()][this.getSource().getY()-y].getChessColor()!=this.getChessColor()){
                New.add(Test.offset(0,-y));
                System.out.println(this.chessComponents[this.getSource().getX()][this.getSource().getY()-y].getChessColor());
                System.out.println(this.getChessColor());
                System.out.println(this.getSource());
                System.out.println(this.chessComponents[this.getSource().getX()][this.getSource().getY()-y].getSource());
                break;
            }
            else break;}
        for (int y = 1;y<8;y++){
            if (test(0,y)&&this.chessComponents[this.getSource().getX()][this.getSource().getY()+y].getChessColor()==ChessColor.NONE){
                New.add(Test.offset(0,y));
            }
            else if (test(0,y)&&this.chessComponents[this.getSource().getX()][this.getSource().getY()+y].getChessColor()!=this.getChessColor()){
                New.add(Test.offset(0,y));
                break;
            }
            else break;}
        return New;
    }
}
