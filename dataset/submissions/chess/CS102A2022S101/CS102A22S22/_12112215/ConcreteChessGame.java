import java.util.*;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.BLACK;
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j));
            }
        }
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R',this);
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N',this);
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B',this);
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q',this);
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K',this);
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P',this);
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r',this);
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n',this);
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b',this);
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q',this);
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k',this);
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p',this);
                } else if (chessboard.get(i).charAt(j) =='_') {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j));
                }
            }
            if (chessboard.get(8).equals("w")) {
                this.currentPlayer = ChessColor.WHITE;
            }
            if (chessboard.get(8).equals("b")) {
                this.currentPlayer = ChessColor.BLACK;
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 8; i++) {
            StringBuilder chessStatus = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                chessStatus.append(chessComponents[i][j].name);
            }
            list.add(chessStatus.toString());
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", list.get(0), list.get(1), list.get(2), list.get(3)
                , list.get(4), list.get(5), list.get(6), list.get(7));
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder str = new StringBuilder();
        int[] chessNumber = new int[12];
        int[] chessOriginalNumber = {1, 1, 2, 2, 2, 8, 1, 1, 2, 2, 2, 8};
        Character[] chessName = {'K', 'Q', 'R', 'B', 'N', 'P', 'k', 'q', 'r', 'b', 'n', 'p'};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent chess = chessComponents[i][j];
                if (chess.name == 'K') {
                    chessNumber[0]++;
                } else if (chess.name == 'Q') {
                    chessNumber[1]++;
                } else if (chess.name == 'R') {
                    chessNumber[2]++;
                } else if (chess.name == 'B') {
                    chessNumber[3]++;
                } else if (chess.name == 'N') {
                    chessNumber[4]++;
                } else if (chess.name == 'P') {
                    chessNumber[5]++;
                } else if (chess.name == 'k') {
                    chessNumber[6]++;
                } else if (chess.name == 'q') {
                    chessNumber[7]++;
                } else if (chess.name == 'r') {
                    chessNumber[8]++;
                } else if (chess.name == 'b') {
                    chessNumber[9]++;
                } else if (chess.name == 'n') {
                    chessNumber[10]++;
                } else if (chess.name == 'p') {
                    chessNumber[11]++;
                }
            }
        }
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 6; i++) {
                if (chessOriginalNumber[i] - chessNumber[i] != 0) {
                    str.append(chessName[i]+" "+(chessOriginalNumber[i]-chessNumber[i])+"\n");
                }
            }
        } else {
            for (int i =6; i <12 ; i++) {
                if(chessOriginalNumber[i]-chessNumber[i]!=0){
                    str.append(chessName[i]+" "+(chessOriginalNumber[i]-chessNumber[i])+"\n");
                }
            }
        }
        return str.toString();
    }
    public ChessComponent getChess ( int x, int y){
            return chessComponents[x][y];
        }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int
            targetY) {
        ChessComponent chess = chessComponents[sourceX][sourceY];
        if (chess.getChessColor() == this.currentPlayer) {
            if (chess.canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY));
                if (this.currentPlayer==ChessColor.BLACK) {
                    this.currentPlayer=ChessColor.WHITE;
                } else {
                    this.currentPlayer=ChessColor.BLACK;
                }
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent chess=this.chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> list=chess.canMoveTo();
        Collections.sort(list, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX()!=o2.getX()) {
                    return o1.getX() - o2.getX();
                }else{
                    return o1.getY()-o2.getY();
                }
            }
        });
        return list;
    }
}