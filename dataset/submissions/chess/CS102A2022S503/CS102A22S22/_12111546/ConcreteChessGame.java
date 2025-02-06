import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].game = this;
            }
        }
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }


    @Override
    public void loadChessGame(List<String> chessboard) {

        if (chessboard.get(8).equals("b")) {
            setCurrentPlayer(ChessColor.BLACK);
        } else {
            setCurrentPlayer(ChessColor.WHITE);
        }

        for (int i = 0; i < 8; i++) {
            for (int p = 0; p < 8; p++) {
                char chess = chessboard.get(i).charAt(p);
                if (chess == 'R') {
                    chessComponents[i][p] = new RookChessComponent(new ChessboardPoint(i, p), ChessColor.BLACK, 'R');
                    setChessComponents(chessComponents);
                }
                if (chess == 'N') {
                    chessComponents[i][p] = new KnightChessComponent(new ChessboardPoint(i, p), ChessColor.BLACK, 'N');
                    setChessComponents(chessComponents);
                }
                if (chess == 'B') {
                    chessComponents[i][p] = new BishopChessComponent(new ChessboardPoint(i, p), ChessColor.BLACK, 'B');
                    setChessComponents(chessComponents);
                }
                if (chess == 'Q') {
                    chessComponents[i][p] = new QueenChessComponent(new ChessboardPoint(i, p), ChessColor.BLACK, 'Q');
                    setChessComponents(chessComponents);
                }
                if (chess == 'K') {
                    chessComponents[i][p] = new KingChessComponent(new ChessboardPoint(i, p), ChessColor.BLACK, 'K');
                    setChessComponents(chessComponents);
                }
                if (chess == 'P') {
                    chessComponents[i][p] = new PawnChessComponent(new ChessboardPoint(i, p), ChessColor.BLACK, 'P');
                    setChessComponents(chessComponents);
                }

                if (chess == 'r') {
                    chessComponents[i][p] = new RookChessComponent(new ChessboardPoint(i, p), ChessColor.WHITE, 'r');
                    setChessComponents(chessComponents);
                }
                if (chess == 'n') {
                    chessComponents[i][p] = new KnightChessComponent(new ChessboardPoint(i, p), ChessColor.WHITE, 'n');
                    setChessComponents(chessComponents);
                }
                if (chess == 'b') {
                    chessComponents[i][p] = new BishopChessComponent(new ChessboardPoint(i, p), ChessColor.WHITE, 'b');
                    setChessComponents(chessComponents);
                }
                if (chess == 'q') {
                    chessComponents[i][p] = new QueenChessComponent(new ChessboardPoint(i, p), ChessColor.WHITE, 'q');
                    setChessComponents(chessComponents);
                }
                if (chess == 'k') {
                    chessComponents[i][p] = new KingChessComponent(new ChessboardPoint(i, p), ChessColor.WHITE, 'k');
                    setChessComponents(chessComponents);
                }
                if (chess == 'p') {
                    chessComponents[i][p] = new PawnChessComponent(new ChessboardPoint(i, p), ChessColor.WHITE, 'p');
                    setChessComponents(chessComponents);
                }
                if (chess == '_') {
                    chessComponents[i][p] = new EmptySlotComponent(new ChessboardPoint(i, p), ChessColor.NONE, '_');
                    setChessComponents(chessComponents);
                }
            }
        }
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            this.currentPlayer = ChessColor.BLACK;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].game = this;
            }
        }
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
        StringBuilder chessBoard = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (int p = 0; p < 8; p++) {
                chessBoard.append(String.valueOf(this.chessComponents[i][p].getName()));
            }
            chessBoard.append("\n");

        }
        for (int i = 0; i < 8; i++) {
            chessBoard.append(String.valueOf(this.chessComponents[7][i].getName()));
        }
        return chessBoard.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] count = new int[6];
        int[] origin = new int[6];
        origin[0] = 1;
        origin[1] = 1;
        origin[2] = 2;
        origin[3] = 2;
        origin[4] = 2;
        origin[5] = 8;
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k') {
                        count[0]++;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        count[1]++;
                    }
                    if (chessComponents[i][j].name == 'r') {
                        count[2]++;
                    }
                    if (chessComponents[i][j].name == 'b') {
                        count[3]++;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        count[4]++;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        count[5]++;
                    }
                }
            }


        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') {
                        count[0]++;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        count[1]++;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        count[2]++;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        count[3]++;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        count[4]++;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        count[5]++;
                    }
                }
            }
        }
        int[] difference = new int[6];
        for (int i = 0; i < 6; i++) {
            difference[i] = origin[i] - count[i];
        }

        StringBuilder Captured = new StringBuilder();

        if (player == ChessColor.WHITE) {
            if (!(difference[0] == 0)) {
                Captured.append("k 1\n");
            }
            if (!(difference[1] == 0)) {
                Captured.append("q 1\n");
            }
            if (!(difference[2] == 0)) {
                Captured.append(String.format("r %d\n", difference[2]));
            }
            if (!(difference[3] == 0)) {
                Captured.append(String.format("b %d\n", difference[3]));
            }
            if (!(difference[4] == 0)) {
                Captured.append(String.format("n %d\n", difference[4]));
            }
            if (!(difference[5] == 0)) {
                Captured.append(String.format("p %d\n", difference[5]));
            }
        } else {
            if (!(difference[0] == 0)) {
                Captured.append("K 1\n");
            }
            if (!(difference[1] == 0)) {
                Captured.append("Q 1\n");
            }
            if (!(difference[2] == 0)) {
                Captured.append(String.format("R %d\n", difference[2]));
            }
            if (!(difference[3] == 0)) {
                Captured.append(String.format("B %d\n", difference[3]));
            }
            if (!(difference[4] == 0)) {
                Captured.append(String.format("N %d\n", difference[4]));
            }
            if (!(difference[5] == 0)) {
                Captured.append(String.format("P %d\n", difference[5]));
            }

        }
        return Captured.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source=new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint target=new ChessboardPoint(targetX,targetY);

        if (chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer)return false;

//        List<ChessboardPoint> canMove = getCanMovePoints(source);
//        boolean judge =false;
//        for (int i = 0; i < canMove.size(); i++) {
//            if (canMove.get(i).getX()==targetX && canMove.get(i).getY()==targetY){
//                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
//                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
//
//                if (currentPlayer==ChessColor.BLACK) currentPlayer=ChessColor.WHITE;
//                else currentPlayer=ChessColor.BLACK;
//
//                judge=true;
//            }
//        }
//        return judge;
        boolean contain = false;
        List<ChessboardPoint> canMove = getCanMovePoints(source);
        for (ChessboardPoint chessboardPoint : canMove) {
            if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                contain = true;
                break;
            }
        }
        if (contain) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');

            if (currentPlayer==ChessColor.BLACK) currentPlayer = ChessColor.WHITE;
             else currentPlayer = ChessColor.BLACK;

            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
            for (ChessComponent[] chessComponent : chessComponents) {
                for (ChessComponent component : chessComponent) {
                    component.game = this;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

}