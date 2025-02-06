import java.util.*;

public  class ConcreteChessGame  implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    public List<String> chessboard2 = new ArrayList<>();



    public ConcreteChessGame() {
    }

    public ConcreteChessGame(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }


    public ConcreteChessGame(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void loadChessGame(List<String> chessboard) {
        this.chessboard2 = chessboard;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.chessComponents[i][j] = toChess(new ChessboardPoint(i,j),chessboard.get(i).charAt(j));
                this.chessComponents[i][j].setChessBoard(chessComponents);
            }
        }

        if (chessboard.get(8).equals("w")||chessboard.get(8).equals("W")) {
            setCurrentPlayer(ChessColor.WHITE);
        } else {
            setCurrentPlayer(ChessColor.BLACK);
        }

//        setChessBoard(chessComponents);
        System.out.println(getChessboardGraph());
    }


    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder g = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                g.append(chessComponents[i][j].name);
            }
        }
        String a = g.substring(0, 8);
        String b = g.substring(8, 16);
        String c = g.substring(16, 24);
        String d = g.substring(24, 32);
        String e = g.substring(32, 40);
        String f = g.substring(40, 48);
        String i = g.substring(48, 56);
        String h = g.substring(56, 64);


        return a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + i + "\n" + h;
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder list = new StringBuilder();

        int kn = 0;
        int Kn = 0;
        int qn = 0;
        int Qn = 0;
        int rn = 0;
        int Rn = 0;
        int bn = 0;
        int Bn = 0;
        int nn = 0;
        int Nn = 0;
        int pn = 0;
        int Pn = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'k') {
                    kn++;
                }
                if (chessComponents[i][j].name == 'q') {
                    qn++;
                }
                if (chessComponents[i][j].name == 'r') {
                    rn++;
                }
                if (chessComponents[i][j].name == 'b') {
                    bn++;
                }
                if (chessComponents[i][j].name == 'n') {
                    nn++;
                }
                if (chessComponents[i][j].name == 'p') {
                    pn++;
                }
                if (chessComponents[i][j].name == 'K') {
                    Kn++;
                }
                if (chessComponents[i][j].name == 'Q') {
                    Qn++;
                }
                if (chessComponents[i][j].name == 'R') {
                    Rn++;
                }
                if (chessComponents[i][j].name == 'B') {
                    Bn++;
                }
                if (chessComponents[i][j].name == 'N') {
                    Nn++;
                }
                if (chessComponents[i][j].name == 'P') {
                    Pn++;
                }
            }
        }
        if (player == ChessColor.WHITE) {
            if (kn == 0) {
                list.append("k ").append(1).append("\n");
            }
            if (qn == 0) {
                list.append("q ").append(1).append("\n");
            }
            if (rn < 2) {
                list.append("r ").append(2 - rn).append("\n");
            }
            if (bn < 2) {
                list.append("b ").append(2 - bn).append("\n");
            }
            if (nn < 2) {
                list.append("n ").append(2 - nn).append("\n");
            }
            if (pn < 8) {
                list.append("p ").append(8 - pn);
            }

        } else {
            if (Kn == 0) {
                list.append("K ").append(1).append("\n");
            }
            if (Qn == 0) {
                list.append("Q ").append(1).append("\n");
            }
            if (Rn < 2) {
                list.append("R ").append(2 - Rn).append("\n");
            }
            if (Bn < 2) {
                list.append("B ").append(2 - Bn).append("\n");
            }
            if (Nn < 2) {
                list.append("N ").append(2 - Nn).append("\n");
            }
            if (Pn < 8) {
                list.append("P ").append(8 - Pn);
            }

        }
        if (list.length() == 0) {
            return "";
        } else {
            return list.toString();
        }
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent g = getChess(source.getX(),source.getY());
        List<ChessboardPoint> a = new ArrayList<>(g.canMoveTo());

        a.sort(new c());
        Collections.reverse(a);
        System.out.println(a);

         return a;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessColor player = getCurrentPlayer();
        ChessComponent chess = this.getChess(sourceX,sourceY);
        char name =chess.name;
        ChessComponent target = toChess(new ChessboardPoint(targetX,targetY),name);
        if(chess.getChessColor() == player) {
            for (ChessboardPoint point: getCanMovePoints(new ChessboardPoint(sourceX,sourceY))) {
                if(point.getX() ==targetX && point.getY() == targetY){
                    currentPlayer = currentPlayer == ChessColor.WHITE?ChessColor.BLACK:ChessColor.WHITE;
                    this.chessComponents[targetX][targetY] = target;
                    this.chessComponents[targetX][targetY].setChessBoard(this.chessComponents);
                    this.chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
                    return true;
                }
            }
        }
        return  false;
    }

    static class c implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint ch1, ChessboardPoint ch2) {
            if (ch2.getX() != ch1.getX()) {
                return ch2.getX() - ch1.getX();
            } else return ch2.getY() - ch1.getY();
        }
    }

    public ChessComponent toChess(ChessboardPoint point, Character f ){
        return switch (f) {
            case 'K' -> new KingChessComponent(point, ChessColor.BLACK);
            case 'k' -> new KingChessComponent(point, ChessColor.WHITE);
            case 'B' -> new BishopChessComponent(point, ChessColor.BLACK);
            case 'b' -> new BishopChessComponent(point, ChessColor.WHITE);
            case 'Q' -> new QueenChessComponent(point, ChessColor.BLACK);
            case 'q' -> new QueenChessComponent(point, ChessColor.WHITE);
            case 'R' -> new RookChessComponent(point, ChessColor.BLACK);
            case 'r' -> new RookChessComponent(point, ChessColor.WHITE);
            case 'P' -> new PawnChessComponent(point, ChessColor.BLACK);
            case 'p' -> new PawnChessComponent(point, ChessColor.WHITE);
            case 'n' -> new KnightChessComponent(point, ChessColor.WHITE);
            case 'N' -> new KnightChessComponent(point, ChessColor.BLACK);
            case '_' -> new EmptySlotComponent(point, ChessColor.NONE);
            default -> null;
        };
    }
}