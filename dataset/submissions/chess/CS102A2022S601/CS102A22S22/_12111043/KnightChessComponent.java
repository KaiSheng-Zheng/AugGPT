import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;
    public KnightChessComponent(char name, ChessComponent[][] chessComponents,ChessboardPoint source){
        super(name, chessComponents, source);
        this.name=name;
        this.source=source;
        this.chessComponents=chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
        if(name=='N'){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if((Math.abs(i-x)==2&&Math.abs(j-y)==1)||(Math.abs(i-x)==1&&Math.abs(j-y)==2)){
                        if (chessComponents[i][j].name>90){
                            move.add(new ChessboardPoint(i,j));
                        }
                    }
                }
            }
        }else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ((Math.abs(i-x)==2&&Math.abs(j-y)==1)||(Math.abs(i-x)==1&&Math.abs(j-y)==2)) {
                        if (chessComponents[i][j].name <97) {
                            move.add(new ChessboardPoint(i, j));
                        }
                    }
                }
            }
        }
        return move;
    }
}
