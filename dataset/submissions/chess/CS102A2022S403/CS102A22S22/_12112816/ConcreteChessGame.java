import java.util.*;

public class ConcreteChessGame  implements ChessGame{
    private ChessComponent[][] chessComponents;

    private ChessColor currentPlayer;



    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char component = chessboard.get(i).charAt(j);
                if (component == 'K') chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j),ChessColor.BLACK);
                if (component == 'k') chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j),ChessColor.WHITE);

                if (component == 'Q') chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                if (component == 'q') chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                if (component == 'R') chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                if (component == 'r') chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                if (component == 'B') chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                if (component == 'b') chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                if (component == 'N') chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                if (component == 'n') chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                if (component == 'P') chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                if (component == 'p') chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);

                if (component == '_') chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j));
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') currentPlayer = ChessColor.WHITE;
        else currentPlayer = ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph.append(chessComponents[i][j].name);
            }
            graph.append('\n');
        }
        return graph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] notBeCaptured = new int[6];
        int[] beCaptured = new int[6];
        StringBuilder result = new StringBuilder();
        if (player == ChessColor.BLACK){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') notBeCaptured[0]++;
                    if (chessComponents[i][j].name == 'Q') notBeCaptured[1]++;
                    if (chessComponents[i][j].name == 'R') notBeCaptured[2]++;
                    if (chessComponents[i][j].name == 'B') notBeCaptured[3]++;
                    if (chessComponents[i][j].name == 'N') notBeCaptured[4]++;
                    if (chessComponents[i][j].name == 'P') notBeCaptured[5]++;
                }
            }
            beCaptured[0] = 1 - notBeCaptured[0];
            beCaptured[1] = 1 - notBeCaptured[1];
            for (int i = 2; i < 5; i++) {
                beCaptured[i] = 2 - notBeCaptured[i];
            }
            beCaptured[5] = 8 - notBeCaptured[5];
            if (beCaptured[0] > 0) result.append('K').append(' ').append(beCaptured[0]).append('\n');
            if (beCaptured[1] > 0) result.append('Q').append(' ').append(beCaptured[1]).append('\n');
            if (beCaptured[2] > 0) result.append('R').append(' ').append(beCaptured[2]).append('\n');
            if (beCaptured[3] > 0) result.append('B').append(' ').append(beCaptured[3]).append('\n');
            if (beCaptured[4] > 0) result.append('N').append(' ').append(beCaptured[4]).append('\n');
            if (beCaptured[5] > 0) result.append('P').append(' ').append(beCaptured[5]).append('\n');
        }
        if (player == ChessColor.WHITE){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k') notBeCaptured[0]++;
                    if (chessComponents[i][j].name == 'q') notBeCaptured[1]++;
                    if (chessComponents[i][j].name == 'r') notBeCaptured[2]++;
                    if (chessComponents[i][j].name == 'b') notBeCaptured[3]++;
                    if (chessComponents[i][j].name == 'n') notBeCaptured[4]++;
                    if (chessComponents[i][j].name == 'p') notBeCaptured[5]++;
                }
            }
            beCaptured[0] = 1 - notBeCaptured[0];
            beCaptured[1] = 1 - notBeCaptured[1];
            for (int i = 2; i < 5; i++) {
                beCaptured[i] = 2 - notBeCaptured[i];
            }
            beCaptured[5] = 8 - notBeCaptured[5];
            if (beCaptured[0] > 0) result.append('k').append(' ').append(beCaptured[0]).append('\n');
            if (beCaptured[1] > 0) result.append('q').append(' ').append(beCaptured[1]).append('\n');
            if (beCaptured[2] > 0) result.append('r').append(' ').append(beCaptured[2]).append('\n');
            if (beCaptured[3] > 0) result.append('b').append(' ').append(beCaptured[3]).append('\n');
            if (beCaptured[4] > 0) result.append('n').append(' ').append(beCaptured[4]).append('\n');
            if (beCaptured[5] > 0) result.append('p').append(' ').append(beCaptured[5]).append('\n');
        }
        return String.valueOf(result);
    }

     @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = getChess(source.getX(),source.getY());
        chessComponents[source.getX()][source.getY()].loadChessboard(chessComponents);
        ArrayList<ChessboardPoint> can = new ArrayList<>(chess.canMoveTo());
        can.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() > o2.getX()) return 1;
                if (o1.getX() < o2.getX()) return -1;
                if (o1.getY() > o2.getY()) return 1;
                if (o1.getY() < o2.getY()) return -1;
                return 0;
            }
        });
        return can;
    }

@Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].loadChessboard(chessComponents);
        if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) return false;
        if (chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
            
            chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            
//            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
            currentPlayer=(currentPlayer==ChessColor.WHITE?ChessColor.BLACK:ChessColor.WHITE);
            return true;
        }
        return false;
    }

    

}
