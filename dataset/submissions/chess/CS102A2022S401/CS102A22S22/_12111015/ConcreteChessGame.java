import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard) {
        this.chessComponents = new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(i, j, chessComponents);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(i, j, chessComponents);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(i, j, chessComponents);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(i, j, chessComponents);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(i, j, chessComponents);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(i, j, chessComponents);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(i, j, chessComponents);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(i, j, chessComponents);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(i, j, chessComponents);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(i, j, chessComponents);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(i, j, chessComponents);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(i, j, chessComponents);
                    chessComponents[i][j].name = chessboard.get(i).charAt(j);
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            setCurrentPlayer(ChessColor.WHITE);
        }
        else {
            setCurrentPlayer(ChessColor.BLACK);
        }
    }



    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public String getChessboardGraph() {
        String zero = null, first = null, second = null, third = null, fourth = null, fifth = null, sixth = null, seventh = null, haha;
        StringBuffer h0, h1, h2, h3, h4, h5, h6, h7;
        h0 = new StringBuffer();
        h1 = new StringBuffer();
        h2 = new StringBuffer();
        h3 = new StringBuffer();
        h4 = new StringBuffer();
        h5 = new StringBuffer();
        h6 = new StringBuffer();
        h7 = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            h0.append(chessComponents[0][i].name);
            h1.append(chessComponents[1][i].name);
            h2.append(chessComponents[2][i].name);
            h3.append(chessComponents[3][i].name);
            h4.append(chessComponents[4][i].name);
            h5.append(chessComponents[5][i].name);
            h6.append(chessComponents[6][i].name);
            h7.append(chessComponents[7][i].name);
        }
        zero = h0.toString();
        first = h1.toString();
        second = h2.toString();
        third = h3.toString();
        fourth = h4.toString();
        fifth = h5.toString();
        sixth = h6.toString();
        seventh = h7.toString();
        haha = zero + "\n" + first + "\n" + second + "\n" + third + "\n" + fourth + "\n" + fifth + "\n" + sixth + "\n" + seventh;
        return haha;
    }


    public String getCapturedChess(ChessColor player) {
        int king, queen, rook, bishop, knight, pawn;
        king = 0;
        queen = 0;
        rook = 0;
        bishop = 0;
        knight = 0;
        pawn = 0;
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < getChessboardGraph().length(); i++) {
                if (getChessboardGraph().charAt(i) == 'K') {
                    king++;
                }
                if (getChessboardGraph().charAt(i) == 'Q') {
                    queen++;
                }
                if (getChessboardGraph().charAt(i) == 'R') {
                    rook++;
                }
                if (getChessboardGraph().charAt(i) == 'B') {
                    bishop++;
                }
                if (getChessboardGraph().charAt(i) == 'N') {
                    knight++;
                }
                if (getChessboardGraph().charAt(i) == 'P') {
                    pawn++;
                }
            }
            int king1 = 1 - king;
            int queen1 = 1- queen;
            int rook1 = 2 - rook;
            int bishop1 = 2- bishop;
            int knight1 = 2 - knight;
            int pawn1 = 8 - pawn;
            String result1;
            StringBuffer result = new StringBuffer();
            if (king1 != 0) {
                result.append("K " + king1 + "\n");
            }
            if (queen1 != 0) {
                result.append("Q " + queen1 + "\n");
            }
            if (rook1 != 0) {
                result.append("R " + rook1 + "\n");
            }
            if (bishop1 != 0) {
                result.append("B " + bishop1 + "\n");
            }
            if (knight1 != 0) {
                result.append("N " + knight1 + "\n");
            }
            if (pawn1 != 0) {
                result.append("P " + pawn1 + "\n");
            }
            result1 = result.toString();
            return result1;
        }
        else  {
            for (int i = 0; i < getChessboardGraph().length(); i++) {
                if (getChessboardGraph().charAt(i) == 'k') {
                    king++;
                }
                if (getChessboardGraph().charAt(i) == 'q') {
                    queen++;
                }
                if (getChessboardGraph().charAt(i) == 'r') {
                    rook++;
                }
                if (getChessboardGraph().charAt(i) == 'b') {
                    bishop++;
                }
                if (getChessboardGraph().charAt(i) == 'n') {
                    knight++;
                }
                if (getChessboardGraph().charAt(i) == 'p') {
                    pawn++;
                }
            }
            int king1 = 1 - king;
            int queen1 = 1- queen;
            int rook1 = 2 - rook;
            int bishop1 = 2- bishop;
            int knight1 = 2 - knight;
            int pawn1 = 8 - pawn;
            String result1;
            StringBuffer result = new StringBuffer();
            if (king1 != 0) {
                result.append("k " + king1 + "\n");
            }
            if (queen1 != 0) {
                result.append("q " + queen1 + "\n");
            }
            if (rook1 != 0) {
                result.append("r " + rook1 + "\n");
            }
            if (bishop1 != 0) {
                result.append("b " + bishop1 + "\n");
            }
            if (knight1 != 0) {
                result.append("n " + knight1 + "\n");
            }
            if (pawn1 != 0) {
                result.append("p " + pawn1 + "\n");
            }
            result1 = result.toString();
            return result1;
        }
    }


    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }



    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints1 = chess.canMoveTo();
        LinkedHashSet<ChessboardPoint> hashSet = new LinkedHashSet<ChessboardPoint>(canMovePoints1);
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>(hashSet);
        if ((canMovePoints.size() != 0)) {
            for (int i = 0; i < canMovePoints.size(); i++) {
                canMovePoints.sort(Comparator.comparing(ChessboardPoint::getX));
            }
            for (int i = 0; i < canMovePoints.size(); i++) {
                for (int j = i; j < canMovePoints.size(); j++) {
                if (canMovePoints.get(i).getX() == canMovePoints.get(j).getX()) {
                    if (canMovePoints.get(j).getY() < canMovePoints.get(i).getY()) {
                        Collections.swap(canMovePoints, i, j);
                    }
                    }
                }
            }
            return canMovePoints;
        }
        else {
            return new ArrayList<>();
        }
    }

        @Override
        public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
            if (chessComponents[sourceX][sourceY].getChessColor() != getCurrentPlayer()) {
                return false;
            }
            else {
                ChessComponent chess = chessComponents[sourceX][sourceY];
                ChessboardPoint hehe = new ChessboardPoint(targetX, targetY);
                if (chess.canMoveTo().contains(hehe)) {
                    chessComponents[targetX][targetY] = chess;
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    chessComponents[sourceX][sourceY].name = '_';
                    chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                    }
                if (getCurrentPlayer() == ChessColor.BLACK) {
                    setCurrentPlayer(ChessColor.WHITE);
                }
                else if(getCurrentPlayer() == ChessColor.WHITE) {
                    setCurrentPlayer(ChessColor.BLACK);
                }
                return true;
            }
        }


    @Override
    public boolean equals(Object o){
        if(o==null){
            return false; }
        if(o.getClass()!=this.getClass()){
            return false; }
        ChessboardPoint p=(ChessboardPoint)o;
        return p.getX()==p.getX()&& p.getY()==p.getY(); }

}
