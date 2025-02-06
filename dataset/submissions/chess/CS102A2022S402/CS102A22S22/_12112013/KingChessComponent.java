import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public KingChessComponent(ChessboardPoint source,ChessColor color,char name){
        this.source=source;
        this.chessColor=color;
        this.name=name;
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<ChessboardPoint>();
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                int o=0;
                if (Math.abs(i-source.getX())>1 ||Math.abs(j-source.getY())>1){
                    o=1;
                }
                if (i==source.getX() && j==source.getY()){o=1;}
                if (o==0 &&chessComponents[i][j].getChessColor()!=this.getChessColor()){
                    chessboardPoints.add(new ChessboardPoint(i,j));
                }
            }
        }
        return chessboardPoints;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessColor getChessColor(){return this.chessColor;}

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
