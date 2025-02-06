import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

//    public ChessComponent[][] getChessComponents() {
//        return chessComponents;
//    }

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(i, j));
                        break;
                }
                chessComponents[i][j].setChessComponents(chessComponents);
            }

        }
        currentPlayer = chessboard.get(8).charAt(0) == 'w' ? ChessColor.WHITE : ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        String Final = "";
        StringBuffer sb = new StringBuffer(Final);
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                sb.append(chessComponents[i][k].name);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int king = 1, queen = 1, rook = 2, bishop = 2, knight = 2, pawn = 8;
        String Final = "";
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int k = 0; k < 8; k++) {
                    if (chessComponents[k][i].name == 'K') {
                        king--;
                    }
                    if (chessComponents[k][i].name == 'Q') {
                        queen--;
                    }
                    if (chessComponents[k][i].name == 'R') {
                        rook--;
                    }
                    if (chessComponents[k][i].name == 'B') {
                        bishop--;
                    }
                    if (chessComponents[k][i].name == 'N') {
                        knight--;
                    }
                    if (chessComponents[k][i].name == 'P') {
                        pawn--;
                    }
                }
            }
            if(king!=0){
                Final = Final + "K " + king + "\n";
            }
            if(queen!=0){
                Final = Final + "Q " + queen + "\n";
            }
            if(rook!=0){
                Final = Final + "R " + rook + "\n";
            }
            if(bishop!=0){
                Final = Final + "B " + bishop + "\n";
            }
            if(knight!=0){
                Final = Final + "N " + knight + "\n";
            }
            if(pawn!=0){
                Final = Final + "P " + pawn + "\n";
            }

        } else if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int k = 0; k < 8; k++) {
                    if (chessComponents[k][i].name == 'k') {
                        king--;
                    }
                    if (chessComponents[k][i].name == 'q') {
                        queen--;
                    }
                    if (chessComponents[k][i].name == 'r') {
                        rook--;
                    }
                    if (chessComponents[k][i].name == 'b') {
                        bishop--;
                    }
                    if (chessComponents[k][i].name == 'n') {
                        knight--;
                    }
                    if (chessComponents[k][i].name == 'p') {
                        pawn--;
                    }
                }
            }
            if(king!=0){
                Final = Final + "k " + king + "\n";
            }
            if(queen!=0){
                Final = Final + "q " + queen + "\n";
            }
            if(rook!=0){
                Final = Final + "r " + rook + "\n";
            }
            if(bishop!=0){
                Final = Final + "b " + bishop + "\n";
            }
            if(knight!=0){
                Final = Final + "n " + knight + "\n";
            }
            if(pawn!=0){
                Final = Final + "p " + pawn + "\n";
            }

        }
        return Final;
    }


    @Override
    public ChessComponent getChess(int x,int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent chess=chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> result=new ArrayList<>();
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < chess.canMoveTo().size(); k++) {
                    if ((j == chess.canMoveTo().get(k).getY()) &&
                            i == chess.canMoveTo().get(k).getX()) {
                        result.add(chess.canMoveTo().get(k));
                    }
                }
            }
        }
        return result;
//        return chess.canMoveTo();
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
//        ChessComponent sourceComponent = chessComponents[sourceX][sourceY];
//        List<ChessboardPoint> CanMoveTo = getCanMovePoints(source);
//        if (getCurrentPlayer() == sourceComponent.getChessColor()) {
//            if (CanMoveTo.contains(target)) {
//                sourceComponent.setSource(target);
//            }
        ChessComponent sourceC = chessComponents[sourceX][sourceY];
       // ChessComponent targetC = chessComponents[targetX][targetY];
       // ChessColor T = targetC.getChessColor();
//        List<ChessboardPoint> CanMoveTo = getCanMovePoints(source);
        if (getCurrentPlayer() == sourceC.getChessColor()) {
            for (int i = 0; i < sourceC.canMoveTo().size(); i++) {
                if (sourceC.canMoveTo().get(i).getX() == targetX &&
                        sourceC.canMoveTo().get(i).getY() == targetY) {
//               sourceC.setSource(target);
//               targetC.setSource(source);
//               swap(chessComponents,sourceX,sourceY,targetX,targetY);
                    sourceC.setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY] = sourceC;
                  //  chessComponents[targetX][targetY].setSource(target);
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE, source);
break;

                }
            }
                currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
                return true;

        }
        return false;
    }

//    public static void swap(ChessComponent[][]a,int sourceX, int sourceY, int targetX, int targetY) {
//        ChessComponent t = a[sourceX][sourceY];
//        a[sourceX][sourceY]=a[targetX][targetY];
//        a[targetX][targetY] = t;
//    }
//you are a dog!!!!!!!!!!
    //what are you barking for?
    //Who thinks of this assignment?

}


