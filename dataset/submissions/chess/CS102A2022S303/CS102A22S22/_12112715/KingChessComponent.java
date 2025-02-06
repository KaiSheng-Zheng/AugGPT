import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source) {
        this.chessComponents = chessComponents;
        setSource(source);
        if (name == 'K') {
            this.name = 'K';
            setChessColor(ChessColor.BLACK);
        } else if (name == 'k') {
            this.name = 'k';
            setChessColor(ChessColor.WHITE);
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> output = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                ChessComponent chess = chessComponents[i][j];
                //if two chess components have the same color, refuse to move
                if (getChessColor() == chess.getChessColor()) {
                    continue;
                }
                ChessboardPoint destination = new ChessboardPoint(i, j);
                if (Math.abs(source.getX() - destination.getX()) == 1 && source.getY() == destination.getY()) {
                    output.add(new ChessboardPoint(i, j));
                } else if (Math.abs(source.getY() - destination.getY()) == 1 && source.getX() == destination.getX()) {
                    output.add(new ChessboardPoint(i, j));
                } else if (Math.abs(source.getX() - destination.getX()) == 1 && Math.abs(source.getY() - destination.getY()) == 1) {
                    output.add(new ChessboardPoint(i, j));
                }
            }
        }
        return output;
    }
}
