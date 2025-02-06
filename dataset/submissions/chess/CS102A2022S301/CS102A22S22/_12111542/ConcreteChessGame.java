import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    private ChessColor currentPlayer = ChessColor.WHITE;


    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char element = chessboard.get(i).charAt(j);
//                chessComponents[i][j].a.chessComponents=this.chessComponents;
                if (element == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                }
                if (element == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                }
                if (element == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                }
                if (element == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                }
                if (element == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                }
                if (element == 'R') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                }
                if (element == 'r') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                }
                if (element == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                }
                if (element == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                }
                if (element == 'K') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                }
                if (element == 'k') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                }
                if (element == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                }
                if (element == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                }
                if (chessboard.get(8).equals("w")) {
                    currentPlayer = ChessColor.WHITE;
                }
                if (chessboard.get(8).equals("b")) {
                    currentPlayer = ChessColor.BLACK;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].board = chessComponents;
            }
        }

    }



    @Override
    public ChessColor getCurrentPlayer() {
//        ChessColor palyer=ChessColor.NONE;
//        if (currentPlayer==ChessColor.BLACK){
//            palyer=ChessColor.WHITE;
//        }if (currentPlayer==ChessColor.WHITE){
//            palyer=ChessColor.BLACK;
//        }
//        return palyer;
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder boardGraph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardGraph.append(chessComponents[i][j].toString());
            }
            boardGraph.append("\n");
        }
        return boardGraph.toString();
    }


    @Override
    public String getCapturedChess(ChessColor player) {
        String[][] black_lost = new String[6][2];
        String[][] white_lost = new String[6][2];
        StringBuilder print = new StringBuilder();
        black_lost[0][0] = "K";
        black_lost[1][0] = "Q";
        black_lost[2][0] = "R";
        black_lost[3][0] = "B";
        black_lost[4][0] = "N";
        black_lost[5][0] = "P";
        white_lost[0][0] = "k";
        white_lost[1][0] = "q";
        white_lost[2][0] = "r";
        white_lost[3][0] = "b";
        white_lost[4][0] = "n";
        white_lost[5][0] = "p";
        int K = 1;
        int Q = 1;
        int R = 2;
        int B = 2;
        int N = 2;
        int P = 8;
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') {
                        K--;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        Q--;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        R--;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        B--;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        N--;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        P--;
                    }
                }
            }
            black_lost[0][1] = String.valueOf(K);
            black_lost[1][1] = String.valueOf(Q);
            black_lost[2][1] = String.valueOf(R);
            black_lost[3][1] = String.valueOf(B);
            black_lost[4][1] = String.valueOf(N);
            black_lost[5][1] = String.valueOf(P);
            for (int i = 0; i < 6; i++) {
                if (!black_lost[i][1].equals("0")) {
                    print.append(black_lost[i][0]);
                    print.append(" ");
                    print.append(black_lost[i][1]);
                    print.append("\n");
                }
            }
        }
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k') {
                        K--;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        Q--;
                    }
                    if (chessComponents[i][j].name == 'r') {
                        R--;
                    }
                    if (chessComponents[i][j].name == 'b') {
                        B--;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        N--;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        P--;
                    }
                }
            }
            white_lost[0][1] = String.valueOf(K);
            white_lost[1][1] = String.valueOf(Q);
            white_lost[2][1] = String.valueOf(R);
            white_lost[3][1] = String.valueOf(B);
            white_lost[4][1] = String.valueOf(N);
            white_lost[5][1] = String.valueOf(P);
            for (int i = 0; i < 6; i++) {
                if (!white_lost[i][1].equals("0")) {
                    print.append(white_lost[i][0]);
                    print.append(" ");
                    print.append(white_lost[i][1]);
                    print.append("\n");
                }
            }
        }
        return print.toString();


    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        if (chessComponents[source.getX()][source.getY()].name == '_') {
            return canMovePoints;
        } else {
            canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
            Collections.sort(canMovePoints);
            return canMovePoints;
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> list;
        if (chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) {
            return false;
        }
        list = chessComponents[sourceX][sourceY].canMoveTo();
        boolean contain = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getX() == targetX && list.get(i).getY() == targetY) {
                contain = true;
                break;
            }
        }
        if (contain) {
//            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY].copy(targetX, targetY);
            if (chessComponents[sourceX][sourceY].name=='K'){
                chessComponents[targetX][targetY]=new KingChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'K');
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            } else if (chessComponents[sourceX][sourceY].name=='k'){
                chessComponents[targetX][targetY]=new KingChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'k');
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            }else if (chessComponents[sourceX][sourceY].name=='B'){
                chessComponents[targetX][targetY]=new BishopChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'B');
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            }else if (chessComponents[sourceX][sourceY].name=='b'){
                chessComponents[targetX][targetY]=new BishopChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'b');
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            }else if (chessComponents[sourceX][sourceY].name=='N'){
                chessComponents[targetX][targetY]=new KnightChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'N');
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            }else if (chessComponents[sourceX][sourceY].name=='n'){
                chessComponents[targetX][targetY]=new KnightChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'n');
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            }else if (chessComponents[sourceX][sourceY].name=='P'){
                chessComponents[targetX][targetY]=new PawnChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'P');
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            }else if (chessComponents[sourceX][sourceY].name=='p'){
                chessComponents[targetX][targetY]=new PawnChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'p');
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            }else if (chessComponents[sourceX][sourceY].name=='Q'){
                chessComponents[targetX][targetY]=new QueenChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'Q');
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            }else if (chessComponents[sourceX][sourceY].name=='q'){
                chessComponents[targetX][targetY]=new QueenChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'q');
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            }else if (chessComponents[sourceX][sourceY].name=='R'){
                chessComponents[targetX][targetY]=new RookChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'R');
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            }else if (chessComponents[sourceX][sourceY].name=='r'){
                chessComponents[targetX][targetY]=new RookChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'r');
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    chessComponents[i][j].board = chessComponents;
                }
            }
            if (currentPlayer==ChessColor.BLACK){
                currentPlayer=ChessColor.WHITE;
            }else if (currentPlayer==ChessColor.WHITE){
                currentPlayer=ChessColor.BLACK;
            }

            return true;
        }else {
            return false;
        }
    }

}

