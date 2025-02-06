import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor){
        setSource(source);
        setChessColor(chessColor);
        if (chessColor.equals(ChessColor.BLACK)){
            setName((char)81);
            setSort(-5);
        }else if (chessColor.equals(ChessColor.WHITE)){
            setName((char)113);
            setSort(5);
        }

    }

    public List<ChessboardPoint> canMoveTo() {
        ArrayList<Integer> dx=new ArrayList<>();
        ArrayList<Integer> dy=new ArrayList<>();
        int counterX =-1;
        for (int x=getSource().getX()-1;x>=0;x--){
            if (chessComponents[x][getSource().getY()].getName()==(char) 95){
                dx.add(counterX);
                counterX--;
                dy.add(0);
            }else {
                dx.add(counterX);
                dy.add(0);
                break;
            }
        }
        counterX=1;
        for (int x=getSource().getX()+1;x<=7;x++){
            if (chessComponents[x][getSource().getY()].getName()==(char) 95){
                dx.add(counterX);
                dy.add(0);
                counterX++;
            }else {
                dx.add(counterX);
                dy.add(0);
                break;}
        }
        int counterY =-1;
        for (int y=getSource().getY()-1;y>=0;y--){
            if (chessComponents[getSource().getX()][y].getName()==(char) 95){
                dx.add(0);
                dy.add(counterY);
                counterY--;
            }else {
                dx.add(0);
                dy.add(counterY);
                break;}
        }
        counterY=1;
        for (int y=getSource().getY()+1;y<=7;y++){
            if (chessComponents[getSource().getX()][y].getName()==(char) 95){
                dx.add(0);
                dy.add(counterY);
                counterY++;
            }else {
                dx.add(0);
                dy.add(counterY);break;}
        }
        counterX=-1;
        counterY=-1;
        for (int a=Math.min(getSource().getX(),getSource().getY())-1;a>=0;a--){
            if (chessComponents[getSource().getX()+counterX][getSource().getY()+counterY].getName()==(char) 95){
                dx.add(counterX);
                dy.add(counterY);
                counterX--;
                counterY--;
            }else {
                dx.add(counterX);
                dy.add(counterY);
                   break;}
        }
        counterX=1;
        counterY=1;
        for (int a=Math.max(getSource().getX(),getSource().getY())+1;a<=7;a++){
            if (chessComponents[getSource().getX()+counterX][getSource().getY()+counterY].getName()==(char) 95){
                dx.add(counterX);
                dy.add(counterY);
                counterX++;
                counterY++;
            }else {
                dx.add(counterX);
                dy.add(counterY);
               break;}
        }
        counterX=-1;
        counterY=1;
        while (getSource().getX()+counterX>=0&&getSource().getY()+counterY<=7){
            if (chessComponents[getSource().getX()+counterX][getSource().getY()+counterY].getName()==(char) 95){
                dx.add(counterX);
                dy.add(counterY);
                counterX--;
                counterY++;
            }else {dx.add(counterX);
                dy.add(counterY);
               break;}
        }
        counterX=1;
        counterY=-1;
        while (getSource().getX()+counterX<=7&&getSource().getY()+counterY>=0){
            if (chessComponents[getSource().getX()+counterX][getSource().getY()+counterY].getName()==(char) 95){
                dx.add(counterX);
                dy.add(counterY);
                counterX++;
                counterY--;
            }else {
                dx.add(counterX);
                dy.add(counterY);
                break;}
        }
        ChessboardPoint[] array=new ChessboardPoint[dx.size()];
        for (int a = 0;a<dx.size();a++){
            if (getSource().offset(dx.get(a), dy.get(a))!=null){
                array[a]=getSource().offset(dx.get(a), dy.get(a));
            }
        }
        if (array.length!=0){
            Arrays.sort(array,new sort());
        }
        List<ChessboardPoint> list=new ArrayList<>();
        for (int a=0;a<array.length;a++){
            list.add(array[a]);
        }
        ArrayList<Integer> counter=new ArrayList<>();
        for (int a=0;a<list.size();a++){
            int x =list.get(a).getX();
            int y =list.get(a).getY();
            if (chessComponents[x][y].getChessColor().equals(chessComponents[getSource().getX()][getSource().getY()].getChessColor())){
                counter.add(a);
            }
        }
        int count = 0;
        for (Integer a:counter){
            list.remove(a-count);
            count++;
        }
        return list;
    }


}
