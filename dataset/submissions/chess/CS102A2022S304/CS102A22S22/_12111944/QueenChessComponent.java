
import java.util.ArrayList;
import java.util.List;


public class QueenChessComponent extends ChessComponent {

    protected ChessComponent[][]chessComponents;


    public QueenChessComponent(ChessColor color) {
        super();
        this.setChessColor(color);
        if (color == ChessColor.WHITE) {
            this.name = 'q';
        } else if (color == ChessColor.BLACK) {
            this.name = 'Q';
        } else {
            this.name = '_';
        }
    }



    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Move = new ArrayList<>();
        int qx=0,qy=0;
        for (int i = 0; i < this.chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                if (chessComponents[i][j].name=='q'){
                    qx=i;qy=j;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (qx==i||qy==j||(qx-i==qy-j)||(qx-i+qy-j==0)){
                    Move.add(new ChessboardPoint(i,j));
                }
            }
        }
        return Move;
    }
}
