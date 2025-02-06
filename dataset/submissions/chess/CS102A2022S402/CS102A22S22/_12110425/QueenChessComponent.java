import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(char a,ChessColor chessColor,int x,int y,ChessComponent[][] chessComponents){
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
        int y1=1,y2=1,y3=1,y4=1;
        cas1:for (int x = 1;x<8;x++,y1++){
            if (test(x,y1)&&this.chessComponents[this.getSource().getX()+x][this.getSource().getY()+y1].getChessColor()==ChessColor.NONE){
                New.add(Test.offset(x,y1));
            }
            else if (test(x,y1)&&this.chessComponents[this.getSource().getX()+x][this.getSource().getY()+y1].getChessColor()!=this.getChessColor()){
                New.add(Test.offset(x,y1));
                break;
            }
            else break;

        }
        cas2:for (int x = 1;x<8;x++,y2++){
            if (test(x,-y2)&&this.chessComponents[this.getSource().getX()+x][this.getSource().getY()-y2].getChessColor()==ChessColor.NONE){
                New.add(Test.offset(x,-y2));
            }
            else if (test(x,-y2)&&this.chessComponents[this.getSource().getX()+x][this.getSource().getY()-y2].getChessColor()!=this.getChessColor()){
                New.add(Test.offset(x,-y2));
                break;
            }
            else break;
        }
        cas3:for (int x = 1;x<8;x++,y3++){
            if (test(-x,y3)&&this.chessComponents[this.getSource().getX()-x][this.getSource().getY()+y3].getChessColor()==ChessColor.NONE){
                New.add(Test.offset(-x,y3));
            }
            else if (test(-x,y3)&&this.chessComponents[this.getSource().getX()-x][this.getSource().getY()+y3].getChessColor()!=this.getChessColor()){
                New.add(Test.offset(-x,y3));
                break;
            }
            else break;
        }
        cas4:for (int x = 1;x<8;x++,y4++){
            if (test(-x,-y4)&&this.chessComponents[this.getSource().getX()-x][this.getSource().getY()-y4].getChessColor()==ChessColor.NONE){
                New.add(Test.offset(-x,-y4));
            }
            else if (test(-x,-y4)&&this.chessComponents[this.getSource().getX()-x][this.getSource().getY()-y4].getChessColor()!=this.getChessColor()){
                New.add(Test.offset(-x,-y4));
                break;
            }
            else break;
        }

        return New;
    }
}
