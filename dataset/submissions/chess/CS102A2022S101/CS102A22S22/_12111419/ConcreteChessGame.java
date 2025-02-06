import java.util.ArrayList;
import java.util.List;

public class
ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ConcreteChessGame() {
        this.currentPlayer = ChessColor.WHITE;
        ChessComponent.colorOfPlayer = ChessColor.WHITE;
        this.chessComponents = new ChessComponent[8][8];
        for (int i=0;i<8;i++) {
            this.chessComponents[1][i] = new PawnChessComponent(new ChessboardPoint(1,i),ChessColor.BLACK,'P');
            this.chessComponents[6][i] = new PawnChessComponent(new ChessboardPoint(6,i),ChessColor.WHITE,'p');
            this.chessComponents[2][i] = new EmptySlotComponent(new ChessboardPoint(2,i),ChessColor.NONE,'_');
            this.chessComponents[3][i] = new EmptySlotComponent(new ChessboardPoint(3,i),ChessColor.NONE,'_');
            this.chessComponents[4][i] = new EmptySlotComponent(new ChessboardPoint(4,i),ChessColor.NONE,'_');
            this.chessComponents[5][i] = new EmptySlotComponent(new ChessboardPoint(5,i),ChessColor.NONE,'_');
        }
        for (int i=0;i<8;i++) {
            if (i == 0 || i == 7) {
                this.chessComponents[0][i] = new RookChessComponent(new ChessboardPoint(0,i),ChessColor.BLACK,'R');
            } else if (i == 1 || i == 6) {
                this.chessComponents[0][i] = new KnightChessComponent(new ChessboardPoint(0,i),ChessColor.BLACK,'N');
            } else if (i == 2 || i == 5) {
                this.chessComponents[0][i] = new BishopChessComponent(new ChessboardPoint(0,i),ChessColor.BLACK,'B');
            } else if (i == 3) {
                this.chessComponents[0][i] = new QueenChessComponent(new ChessboardPoint(0,i),ChessColor.BLACK,'Q');
            } else {
                this.chessComponents[0][i] = new KingChessComponent(new ChessboardPoint(0,i),ChessColor.BLACK,'K');
            }
        }

        for (int i=0;i<8;i++) {
            if (i == 0 || i == 7) {
                this.chessComponents[7][i] = new RookChessComponent(new ChessboardPoint(7,i),ChessColor.WHITE,'r');
            } else if (i == 1 || i == 6) {
                this.chessComponents[7][i] = new KnightChessComponent(new ChessboardPoint(7,i),ChessColor.WHITE,'n');
            } else if (i == 2 || i == 5) {
                this.chessComponents[7][i] = new BishopChessComponent(new ChessboardPoint(7,i),ChessColor.WHITE,'b');
            } else if (i == 3) {
                this.chessComponents[7][i] = new QueenChessComponent(new ChessboardPoint(7,i),ChessColor.WHITE,'q');
            } else {
                this.chessComponents[7][i] = new KingChessComponent(new ChessboardPoint(7,i),ChessColor.WHITE,'k');
            }
        }

        ChessComponent.chessComponent = chessComponents.clone();
    }



    public ConcreteChessGame(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
        ChessComponent.colorOfPlayer = currentPlayer;
        this.chessComponents = new ChessComponent[8][8];

        if (currentPlayer == ChessColor.WHITE) {
            for (int i=0;i<8;i++) {
                this.chessComponents[1][i] = new PawnChessComponent(new ChessboardPoint(1,i),ChessColor.BLACK,'P');
                this.chessComponents[6][i] = new PawnChessComponent(new ChessboardPoint(6,i),ChessColor.WHITE,'p');
                this.chessComponents[2][i] = new EmptySlotComponent(new ChessboardPoint(2,i),ChessColor.NONE,'_');
                this.chessComponents[3][i] = new EmptySlotComponent(new ChessboardPoint(3,i),ChessColor.NONE,'_');
                this.chessComponents[4][i] = new EmptySlotComponent(new ChessboardPoint(4,i),ChessColor.NONE,'_');
                this.chessComponents[5][i] = new EmptySlotComponent(new ChessboardPoint(5,i),ChessColor.NONE,'_');
            }
            for (int i=0;i<8;i++) {
                if (i == 0 || i == 7) {
                    this.chessComponents[0][i] = new RookChessComponent(new ChessboardPoint(0,i),ChessColor.BLACK,'R');
                } else if (i == 1 || i == 6) {
                    this.chessComponents[0][i] = new KnightChessComponent(new ChessboardPoint(0,i),ChessColor.BLACK,'N');
                } else if (i == 2 || i == 5) {
                    this.chessComponents[0][i] = new BishopChessComponent(new ChessboardPoint(0,i),ChessColor.BLACK,'B');
                } else if (i == 3) {
                    this.chessComponents[0][i] = new QueenChessComponent(new ChessboardPoint(0,i),ChessColor.BLACK,'Q');
                } else {
                    this.chessComponents[0][i] = new KingChessComponent(new ChessboardPoint(0,i),ChessColor.BLACK,'K');
                }
            }

            for (int i=0;i<8;i++) {
                if (i == 0 || i == 7) {
                    this.chessComponents[7][i] = new RookChessComponent(new ChessboardPoint(7,i),ChessColor.WHITE,'r');
                } else if (i == 1 || i == 6) {
                    this.chessComponents[7][i] = new KnightChessComponent(new ChessboardPoint(7,i),ChessColor.WHITE,'n');
                } else if (i == 2 || i == 5) {
                    this.chessComponents[7][i] = new BishopChessComponent(new ChessboardPoint(7,i),ChessColor.WHITE,'b');
                } else if (i == 3) {
                    this.chessComponents[7][i] = new QueenChessComponent(new ChessboardPoint(7,i),ChessColor.WHITE,'q');
                } else {
                    this.chessComponents[7][i] = new KingChessComponent(new ChessboardPoint(7,i),ChessColor.WHITE,'k');
                }
            }
        } else {
            for (int i=0;i<8;i++) {
                this.chessComponents[6][i] = new PawnChessComponent(new ChessboardPoint(6,i),ChessColor.BLACK,'P');
                this.chessComponents[1][i] = new PawnChessComponent(new ChessboardPoint(1,i),ChessColor.WHITE,'p');
                this.chessComponents[2][i] = new EmptySlotComponent(new ChessboardPoint(2,i),ChessColor.NONE,'_');
                this.chessComponents[3][i] = new EmptySlotComponent(new ChessboardPoint(3,i),ChessColor.NONE,'_');
                this.chessComponents[4][i] = new EmptySlotComponent(new ChessboardPoint(4,i),ChessColor.NONE,'_');
                this.chessComponents[5][i] = new EmptySlotComponent(new ChessboardPoint(5,i),ChessColor.NONE,'_');
            }
            for (int i=0;i<8;i++) {
                if (i == 0 || i == 7) {
                    this.chessComponents[7][i] = new RookChessComponent(new ChessboardPoint(7,i),ChessColor.BLACK,'R');
                } else if (i == 1 || i == 6) {
                    this.chessComponents[7][i] = new KnightChessComponent(new ChessboardPoint(7,i),ChessColor.BLACK,'N');
                } else if (i == 2 || i == 5) {
                    this.chessComponents[7][i] = new BishopChessComponent(new ChessboardPoint(7,i),ChessColor.BLACK,'B');
                } else if (i == 3) {
                    this.chessComponents[7][i] = new QueenChessComponent(new ChessboardPoint(7,i),ChessColor.BLACK,'Q');
                } else {
                    this.chessComponents[7][i] = new KingChessComponent(new ChessboardPoint(7,i),ChessColor.BLACK,'K');
                }
            }

            for (int i=0;i<8;i++) {
                if (i == 0 || i == 7) {
                    this.chessComponents[0][i] = new RookChessComponent(new ChessboardPoint(0,i),ChessColor.WHITE,'r');
                } else if (i == 1 || i == 6) {
                    this.chessComponents[0][i] = new KnightChessComponent(new ChessboardPoint(0,i),ChessColor.WHITE,'n');
                } else if (i == 2 || i == 5) {
                    this.chessComponents[0][i] = new BishopChessComponent(new ChessboardPoint(0,i),ChessColor.WHITE,'b');
                } else if (i == 3) {
                    this.chessComponents[0][i] = new QueenChessComponent(new ChessboardPoint(0,i),ChessColor.WHITE,'q');
                } else {
                    this.chessComponents[0][i] = new KingChessComponent(new ChessboardPoint(0,i),ChessColor.WHITE,'k');
                }
            }
        }
        ChessComponent.chessComponent = chessComponents.clone();

    }


    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                int chess = chessboard.get(i).charAt(j);
                if (chess == '_') {
                    this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                } else if (chess == 'r') {
                    this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                } else if (chess == 'R') {
                    this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                } else if (chess == 'n') {
                    this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                } else if (chess == 'N'){
                    this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                } else if (chess == 'b') {
                    this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                } else if (chess == 'B') {
                    this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                } else if (chess == 'p') {
                    this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                } else if (chess == 'P') {
                    this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                } else if (chess == 'q') {
                    this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                } else if (chess == 'Q') {
                    this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                } else if (chess == 'k') {
                    this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                } else {
                    this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                }
            }
        }
        ChessComponent.chessComponent = chessComponents.clone();

        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
            ChessComponent.colorOfPlayer = ChessColor.WHITE;
        } else {
            this.currentPlayer = ChessColor.BLACK;
            ChessComponent.colorOfPlayer = ChessColor.BLACK;
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
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                sb.append(this.chessComponents[i][j].name);
                if (j == 7) {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int countOfk = 1;
        int countOfq = 1;
        int countOfr = 2;
        int countOfn = 2;
        int countOfb = 2;
        int countOfp = 8;

        int countOfK = 1;
        int countOfQ = 1;
        int countOfR = 2;
        int countOfN = 2;
        int countOfB = 2;
        int countOfP = 8;

        String str1 = "";
        String str2 = "";
        String result = "";

        if (player == ChessColor.WHITE) {
            for (int i=0;i<8;i++) {
                for (int j=0;j<8;j++) {
                    if (chessComponents[i][j].name == 'k') {
                        countOfk--;
                    } else if (chessComponents[i][j].name == 'q') {
                        countOfq--;
                    } else if (chessComponents[i][j].name == 'r') {
                        countOfr--;
                    } else if (chessComponents[i][j].name == 'n') {
                        countOfn--;
                    } else if (chessComponents[i][j].name == 'b') {
                        countOfb--;
                    } else if (chessComponents[i][j].name == 'p') {
                        countOfp--;
                    }
                }
            }


            if (countOfk != 0) {
                str1 = "k " + countOfk + "\n";
            }
            if (countOfq != 0) {
                str1 = str1 + "q " + countOfq + "\n";
            }
            if (countOfr != 0) {
                str1 = str1 + "r " + countOfr + "\n";
            }
            if (countOfb != 0) {
                str1 = str1 + "b " + countOfb + "\n";
            }
            if (countOfn != 0) {
                str1= str1 + "n " + countOfn + "\n";
            }
            if (countOfp != 0) {
                str1 = str1 + "p " + countOfp + "\n";
            }

            result = str1;

        } else if (player == ChessColor.BLACK){
            for (int i=0;i<8;i++) {
                for (int j=0;j<8;j++) {
                    if (chessComponents[i][j].name == 'K') {
                        countOfK--;
                    } else if (chessComponents[i][j].name == 'Q') {
                        countOfQ--;
                    } else if (chessComponents[i][j].name == 'R') {
                        countOfR--;
                    } else if (chessComponents[i][j].name == 'N') {
                        countOfN--;
                    } else if (chessComponents[i][j].name == 'B') {
                        countOfB--;
                    } else if (chessComponents[i][j].name == 'P') {
                        countOfP--;
                    }
                }
            }

            if (countOfK != 0) {
                str2 = "K " + countOfK + "\n";
            }
            if (countOfQ != 0) {
                str2 = str2 + "Q " + countOfQ + "\n";
            }
            if (countOfR != 0) {
                str2 = str2 + "R " + countOfR + "\n";
            }
            if (countOfB != 0) {
                str2 = str2 + "B " + countOfB + "\n";
            }
            if (countOfN != 0) {
                str2 = str2 + "N " + countOfN + "\n";
            }
            if (countOfP != 0) {
                str2 = str2 + "P " + countOfP + "\n";
            }
            result = str2;
        }

        return result;
    }



    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess = chessComponents[sourceX][sourceY];

        ChessboardPoint chessboardPoint = new ChessboardPoint(targetX,targetY);

        List<ChessboardPoint> list = new ArrayList<>(this.getCanMovePoints(chess.getSource()));

        if (chess.getChessColor() == currentPlayer) {
            for (int i=0;i<list.size();i++) {
                if (chessboardPoint.getX() == list.get(i).getX() && chessboardPoint.getY() == list.get(i).getY()) {

                    this.chessComponents[targetX][targetY] = getChess(sourceX, sourceY);
                    this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                    this.chessComponents[sourceX][sourceY] = new EmptySlotComponent(chessboardPoint,ChessColor.NONE,'_');

                    if (this.currentPlayer == ChessColor.WHITE) {
                        this.currentPlayer = ChessColor.BLACK;
                    } else {
                        this.currentPlayer = ChessColor.WHITE;
                    }
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        ChessComponent chess = this.getChess(x,y);

        List<ChessboardPoint> canMovePoints = new ArrayList<>(chess.canMoveTo());
        List<ChessboardPoint> resultOfCanMovePoints = new ArrayList<>();

        int minOfX = 8;
        int minOfY = 8;
        int mark = -1;

        ArrayList<Integer> markOfI = new ArrayList<>();

        while (resultOfCanMovePoints.size() < canMovePoints.size()) {
            for (int i = 0; i < canMovePoints.size(); i++) {
                boolean flag = true;
                for (int j=0;j<markOfI.size();j++) {
                    if (markOfI.get(j) == i) {
                        flag = false;
                        break;
                    }
                }
                if (canMovePoints.get(i).getX() <= minOfX && flag) {
                    if (canMovePoints.get(i).getX() < minOfX) {
                        minOfX = canMovePoints.get(i).getX();
                        minOfY = canMovePoints.get(i).getY();
                        mark = i;
                    } else if (canMovePoints.get(i).getX() == minOfX && canMovePoints.get(i).getY() < minOfY){
                        minOfX = canMovePoints.get(i).getX();
                        minOfY = canMovePoints.get(i).getY();
                        mark = i;
                    }
                }
            }
            resultOfCanMovePoints.add(canMovePoints.get(mark));
            markOfI.add(mark);
            mark = -1;
            minOfX = 8;
            minOfY = 8;

        }

        return resultOfCanMovePoints;
    }

}


