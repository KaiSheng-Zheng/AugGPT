import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source) {
        this.chessComponents = chessComponents;
        setSource(source);
        if (name == 'N') {
            this.name = 'N';
            setChessColor(ChessColor.BLACK);
        } else if (name == 'n') {
            this.name = 'n';
            setChessColor(ChessColor.WHITE);
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> output = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                ChessComponent chess = chessComponents[i][j];
                //if two chess components have the same color, refuse to move
                if (getChessColor() == chess.getChessColor()) {
                    continue;
                }
                ChessboardPoint destination = new ChessboardPoint(i, j);
                if (Math.abs(source.getX() - destination.getX()) == 2 && Math.abs(source.getY() - destination.getY()) == 1) {
                    output.add(new ChessboardPoint(i, j));
                }
                if (Math.abs(source.getX() - destination.getX()) == 1 && Math.abs(source.getY() - destination.getY()) == 2) {
                    output.add(new ChessboardPoint(i, j));
                }
            }
        }
        return output;
    }
}
