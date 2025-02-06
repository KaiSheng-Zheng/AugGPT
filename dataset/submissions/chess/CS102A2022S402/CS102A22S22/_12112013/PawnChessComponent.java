
import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public PawnChessComponent(ChessboardPoint source,ChessColor color,char name){
        this.source=source;
        this.chessColor=color;
        this.name=name;
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<ChessboardPoint>();
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                if (this.getChessColor()==ChessColor.BLACK){
                    int o=1;
                    if (j==source.getY() &&i-source.getX()==1 &&(chessComponents[i][j].toString().equals("_"))){
                        o=0;
                    }else if (j==source.getY() &&i==3 &&source.getX()==1){
                        int oo=0;
                        for (int x=2;x<=i;x++){
                            if (!(chessComponents[x][source.getY()].toString().equals("_"))) {
                                oo=1;
                            }
                        }
                        if (oo==0){o=0;}
                    }else if (Math.abs(j-source.getY())==1 && i-source.getX()==1
                            &&!(chessComponents[i][j].toString().equals("_"))){
                        o=0;
                    }
                    if (o==0 &&chessComponents[i][j].getChessColor()!=this.getChessColor()){
                        chessboardPoints.add(new ChessboardPoint(i,j));
                    }
                }
                else if (this.getChessColor()==ChessColor.WHITE){
                    int o=1;
                    if (j==source.getY() &&i-source.getX()==-1
                            &&(chessComponents[i][j].toString().equals("_"))){
                        o=0;
                    }else if (j==source.getY() &&i==4 &&source.getX()== 6){
                        int oo=0;
                        for (int x=5;x>=i;x--){
                            if (!(chessComponents[x][source.getY()].toString().equals("_"))) {
                                oo=1;
                            }
                        }
                        if (oo==0){o=0;}
                    }else if (Math.abs(j-source.getY())==1 && i-source.getX()==-1
                            &&!(chessComponents[i][j].toString().equals("_"))){
                        o=0;
                    }
                    if (o==0 &&chessComponents[i][j].getChessColor()!=this.getChessColor()){
                        chessboardPoints.add(new ChessboardPoint(i,j));
                    }
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
