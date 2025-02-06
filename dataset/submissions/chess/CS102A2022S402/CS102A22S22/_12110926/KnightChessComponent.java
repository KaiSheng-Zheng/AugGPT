import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public KnightChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source) {
        super(name, chessComponents, source);
        this.name = name;
        this.source = source;
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        int flag1 = 90;
        int flag2 = 96;

        if (name == 'N') {
            int flag = 0;
            while (flag < 8) {
                for (int i = 0; i < 8; i++) {
                    if (((x - i) == 2 || (x - i) == -2) && ((y - flag == 1) || (y - flag == -1))) {
                        if (chessComponents[i][flag].name > flag1) {
                            move.add(new ChessboardPoint(i, flag));
                        }
                    }
                    if (((x - i) == 1 || (x - i) == -1) && ((y - flag == 2) || (y - flag == -2))) {
                        if (chessComponents[i][flag].name > flag1) {
                            move.add(new ChessboardPoint(i, flag));
                        }
                    }
                }
                flag++;
            }
        }
        if (name == 'n') {
            int flag = 0;
            while (flag < 8) {
                for (int i = 0; i < 8; i++) {
                    if (((x - i) == 2 || (x - i) == -2) && ((y - flag == 1) || (y - flag == -1))) {
                        if (chessComponents[i][flag].name < flag2) {
                            move.add(new ChessboardPoint(i, flag));
                        }
                    }
                    if (((x - i) == 1 || (x - i) == -1) && ((y - flag == 2) || (y - flag == -2))) {
                        if (chessComponents[i][flag].name < flag2) {
                            move.add(new ChessboardPoint(i, flag));
                        }
                    }
                }
                flag++;
            }
        }
        return move;
    }
}