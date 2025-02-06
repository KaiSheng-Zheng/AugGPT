import java.util.*;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        setSource(source);
        setChessColor(chessColor);
        setName(name);
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> potentialMove= new ArrayList<>();
        int x=getSource().getX();
        int y=getSource().getY();
        if (x+1<8 && y+2<8) {
            potentialMove.add(new ChessboardPoint(x + 1, y + 2));
        }
        if (x+1<8 && y-2>=0) {
            potentialMove.add(new ChessboardPoint(x + 1, y - 2));
        }
        if (x-1>=0 && y+2<8) {
            potentialMove.add(new ChessboardPoint(x - 1, y + 2));
        }
        if (x-1>=0 && y-2>=0) {
            potentialMove.add(new ChessboardPoint(x - 1, y - 2));
        }
        if (x+2<8&&y+1<8) {
            potentialMove.add(new ChessboardPoint(x + 2, y + 1));
        }
        if (x+2<8&&y-1>=0) {
            potentialMove.add(new ChessboardPoint(x + 2, y - 1));
        }
        if (x-2>=0&&y+1<8) {
            potentialMove.add(new ChessboardPoint(x - 2, y + 1));
        }
        if (x-2>=0&&y-1>=0){
            potentialMove.add(new ChessboardPoint(x - 2, y - 1));
        }
        for (int i = 0; i < potentialMove.size(); i++) {
            if (getChessComponents()[potentialMove.get(i).getX()][potentialMove.get(i).getY()].getChessColor() == this.getChessColor()){
                potentialMove.remove(potentialMove.get(i));
            }
        }

        Collections.sort(potentialMove, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() == o2.getX()){
                    return o1.getY()-o2.getY();
                }
                return o1.getX()-o2.getX();
            }
        });{
        }

        return potentialMove;
    }
}