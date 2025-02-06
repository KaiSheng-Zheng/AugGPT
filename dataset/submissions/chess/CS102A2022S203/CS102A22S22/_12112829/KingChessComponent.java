import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor){
        setSource(source);
        setChessColor(chessColor);
        if (chessColor.equals(ChessColor.BLACK)){
            setName((char)75);
            setSort(-6);
        }else if (chessColor.equals(ChessColor.WHITE)){
            setName((char)107);
            setSort(6);
        }

    }

    @Override

    public List<ChessboardPoint> canMoveTo(){
        int[] dx={1,1,1,0,0,-1,-1,-1};
        int[] dy={0,1,-1,1,-1,0,1,-1};
        List<ChessboardPoint> chessBoardPointList=new ArrayList<>();
        for (int a = 0;a<8;a++){
            if (getSource().offset(dx[a],dy[a])!=null){
                chessBoardPointList.add(getSource().offset(dx[a],dy[a]));
            }
        }
        ChessboardPoint[] array=new ChessboardPoint[chessBoardPointList.size()];
        for (int a=0;a<chessBoardPointList.size();a++){
            array[a]=chessBoardPointList.get(a);
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
