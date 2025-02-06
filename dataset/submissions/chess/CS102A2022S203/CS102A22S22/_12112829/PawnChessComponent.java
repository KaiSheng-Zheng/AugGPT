import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor){
        setSource(source);
        setChessColor(chessColor);
        if (chessColor.equals(ChessColor.BLACK)){
            setName((char)80);
            setSort(-1);
        }else if (chessColor.equals(ChessColor.WHITE)){
            setName((char)112);
            setSort(1);
        }

    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessBoardPointList=new ArrayList<>();

        if (getChessColor().equals(ChessColor.WHITE)){
            if (getSource().getX()==6&&chessComponents[getSource().getX()-2][getSource().getY()].getName()==(char) 95&&chessComponents[getSource().getX()-1][getSource().getY()].getName()==(char) 95){
                chessBoardPointList.add(getSource().offset(-2,0));
            }
            if (getSource().getX()-1>=0&&chessComponents[getSource().getX()-1][getSource().getY()].getName()==(char) 95){
                chessBoardPointList.add(getSource().offset(-1,0));
            }
            if (getSource().getX()-1>=0&&getSource().getY()-1>=0&&chessComponents[getSource().getX()-1][getSource().getY()-1].getChessColor().equals(ChessColor.BLACK)){
                chessBoardPointList.add(getSource().offset(-1,-1));
            }
            if (getSource().getX()-1>=0&&getSource().getY()+1<=7&&chessComponents[getSource().getX()-1][getSource().getY()+1].getChessColor().equals(ChessColor.BLACK)){
                chessBoardPointList.add(getSource().offset(-1,1));
            }
        }else if (getChessColor().equals(ChessColor.BLACK)){
            if (getSource().getX()==1&&chessComponents[getSource().getX()+2][getSource().getY()].getName()==(char) 95&&chessComponents[getSource().getX()+1][getSource().getY()].getName()==(char) 95){
                chessBoardPointList.add(getSource().offset(2,0));
            }
            if (getSource().getX()+1<=7&&chessComponents[getSource().getX()+1][getSource().getY()].getName()==(char) 95){
                chessBoardPointList.add(getSource().offset(1,0));
            }
            if (getSource().getX()+1<=7&&getSource().getY()-1>=0&&chessComponents[getSource().getX()+1][getSource().getY()-1].getChessColor().equals(ChessColor.WHITE)){
                chessBoardPointList.add(getSource().offset(1,-1));
            }
            if (getSource().getX()+1<=7&&getSource().getY()+1<=7&&chessComponents[getSource().getX()+1][getSource().getY()+1].getChessColor().equals(ChessColor.WHITE)){
                chessBoardPointList.add(getSource().offset(1,1));
            }
        }
        Collections.sort(chessBoardPointList,new sort());
        return chessBoardPointList;

    }

}

