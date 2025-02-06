import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
    private ArrayList<ChessComponent> initial = new ArrayList<>();
    public static ChessComponent[][] chessComponentsTmp = new ChessComponent[8][8];

    public static int a;
    public static int b;

    public void getInitial() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("RNBQKBNR");
        arrayList.add("PPPPPPPP");
        arrayList.add("________");
        arrayList.add("________");
        arrayList.add("________");
        arrayList.add("________");
        arrayList.add("pppppppp");
        arrayList.add("rnbqkbnr");
        arrayList.add("w");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                initial.add(letterToChess(arrayList.get(i).charAt(j)));
            }
        }
    }

    public ChessComponent letterToChess(char letter) {
        if (letter == 'p') {
            PawnChessComponent pawnChessComponent = new PawnChessComponent();
            pawnChessComponent.name = 'p';
            return pawnChessComponent;
        } else if (letter == 'P') {
            PawnChessComponent pawnChessComponent = new PawnChessComponent();
            pawnChessComponent.name = 'P';
            return pawnChessComponent;
        } else if (letter == 'r') {
            RookChessComponent rookChessComponent = new RookChessComponent();
            rookChessComponent.name = 'r';
            return rookChessComponent;
        } else if (letter == 'R') {
            RookChessComponent rookChessComponent = new RookChessComponent();
            rookChessComponent.name = 'R';
            return rookChessComponent;
        } else if (letter == 'n') {
            KnightChessComponent knightChessComponent = new KnightChessComponent();
            knightChessComponent.name = 'n';
            return knightChessComponent;
        } else if (letter == 'N') {
            KnightChessComponent knightChessComponent = new KnightChessComponent();
            knightChessComponent.name = 'N';
            return knightChessComponent;
        } else if (letter == 'b') {
            BishopChessComponent bishopChessComponent = new BishopChessComponent();
            bishopChessComponent.name = 'b';
            return bishopChessComponent;
        } else if (letter == 'B') {
            BishopChessComponent bishopChessComponent = new BishopChessComponent();
            bishopChessComponent.name = 'B';
            return bishopChessComponent;
        } else if (letter == 'q') {
            QueenChessComponent queenChessComponent = new QueenChessComponent();
            queenChessComponent.name = 'q';
            return queenChessComponent;
        } else if (letter == 'Q') {
            QueenChessComponent queenChessComponent = new QueenChessComponent();
            queenChessComponent.name = 'Q';
            return queenChessComponent;
        } else if (letter == 'k') {
            KingChessComponent kingChessComponent = new KingChessComponent();
            kingChessComponent.name = 'k';
            return kingChessComponent;
        } else if (letter == 'K') {
            KingChessComponent kingChessComponent = new KingChessComponent();
            kingChessComponent.name = 'K';
            return kingChessComponent;
        } else {
            EmptySlotComponent emptySlotComponent = new EmptySlotComponent();
            emptySlotComponent.name = '_';
            return emptySlotComponent;
        }
    }

    public char getLetter(ChessComponent chessComponent) {
        return chessComponent.name;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j] = letterToChess(chessboard.get(i).charAt(j));
            }

        }
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }
        chessComponentsTmp = chessComponents;
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        String chessBoard = new String();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tmp.append(getLetter(chessComponents[i][j]));
            }
            tmp.append("\n");
        }
        chessBoard = tmp.toString();
        return chessBoard;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        getInitial();
        int[] init = new int[12];
        int[] cnt = new int[12];
        init[0] = 1;
        init[1] = 1;
        init[2] = 2;
        init[3] = 2;
        init[4] = 2;
        init[5] = 8;
        init[6] = 1;
        init[7] = 1;
        init[8] = 2;
        init[9] = 2;
        init[10] = 2;
        init[11] = 8;
        ArrayList<ChessComponent> a1 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name != '_') {
                    a1.add(chessComponents[i][j]);
                    if (chessComponents[i][j].name == 'k') {
                        cnt[0]++;
                    } else if (chessComponents[i][j].name == 'q') {
                        cnt[1]++;
                    } else if (chessComponents[i][j].name == 'r') {
                        cnt[2]++;
                    } else if (chessComponents[i][j].name == 'b') {
                        cnt[3]++;
                    } else if (chessComponents[i][j].name == 'n') {
                        cnt[4]++;
                    } else if (chessComponents[i][j].name == 'p') {
                        cnt[5]++;
                    } else if (chessComponents[i][j].name == 'K') {
                        cnt[6]++;
                    } else if (chessComponents[i][j].name == 'Q') {
                        cnt[7]++;
                    } else if (chessComponents[i][j].name == 'R') {
                        cnt[8]++;
                    } else if (chessComponents[i][j].name == 'B') {
                        cnt[9]++;
                    } else if (chessComponents[i][j].name == 'N') {
                        cnt[10]++;
                    } else if (chessComponents[i][j].name == 'P') {
                        cnt[11]++;
                    }
                }
            }
        }
        StringBuilder tmp = new StringBuilder();
        if (player.equals(ChessColor.WHITE)) {

            if (cnt[0] != init[0]) {
                tmp.append("k " + (init[0] - cnt[0]) + "\n");
            }
            if (cnt[1] != init[1]) {
                tmp.append("q " + (init[1] - cnt[1]) + "\n");
            }
            if (cnt[2] != init[2]) {
                tmp.append("r " + (init[2] - cnt[2]) + "\n");
            }
            if (cnt[3] != init[3]) {
                tmp.append("b " + (init[3] - cnt[3]) + "\n");
            }
            if (cnt[4] != init[4]) {
                tmp.append("n " + (init[4] - cnt[4]) + "\n");
            }
            if (cnt[5] != init[5]) {
                tmp.append("p " + (init[5] - cnt[5]) + "\n");
            }
            return String.valueOf(tmp);
        } else if (player.equals(ChessColor.BLACK)) {

            if (cnt[6] != init[6]) {
                tmp.append("K " + (init[6] - cnt[6]) + "\n");
            }
            if (cnt[7] != init[7]) {
                tmp.append("Q " + (init[7] - cnt[7]) + "\n");
            }
            if (cnt[8] != init[8]) {
                tmp.append("R " + (init[8] - cnt[8]) + "\n");
            }
            if (cnt[9] != init[9]) {
                tmp.append("B " + (init[9] - cnt[9]) + "\n");
            }
            if (cnt[10] != init[10]) {
                tmp.append("N " + (init[10] - cnt[10]) + "\n");
            }
            if (cnt[11] != init[11]) {
                tmp.append("P " + (init[11] - cnt[11]) + "\n");
            }
            return String.valueOf(tmp);
        } else return null;

    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint cbp1=new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint cbp2=new ChessboardPoint(targetX, targetY);
        //System.out.println(cbp2.toString());
       if (chessComponents[sourceX][sourceY].name <= 'z' && chessComponents[sourceX][sourceY].name >= 'a' && currentPlayer == ChessColor.BLACK) {
           //System.out.println("f");
           return false;
        }
        else if (chessComponents[sourceX][sourceY].name <= 'Z' && chessComponents[sourceX][sourceY].name >= 'A' && currentPlayer == ChessColor.WHITE) {
            //System.out.println("F");
            return false;
        }
        else{
           for (int i = 0; i < getCanMovePoints(cbp1).size(); i++) {
               if (getCanMovePoints(cbp1).get(i).toString().equals(cbp2.toString())) {
                   chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                   chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                   if (currentPlayer == ChessColor.WHITE) {
                       currentPlayer = ChessColor.BLACK;
                   }
                   else
                       currentPlayer = ChessColor.WHITE;
                   //System.out.println("true");
                   return true;
               }
           }
           //System.out.println("False");
           return false;


        }
    }



    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        a=source.getX();
        b=source.getY();
        //System.out.println(chessComponents[a][b].canMoveTo());
        return chessComponents[a][b].canMoveTo();
    }


}
