import java.util.*;


public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
    public List<String> chessboard;

    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
            this.chessboard.set(8,"b");
        } else if (chessboard.get(8).equals("b")) {
            this.currentPlayer = ChessColor.BLACK;
            this.chessboard.set(8,"w");
        }
        for (int i = 0; i<8; i++){
            for (int j = 0; j<8; j++){
                if (chessboard.get(i).charAt(j)=='B'|chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j] = new BishopChessComponent(i,j,chessboard.get(i).charAt(j),this.chessboard);
                }else  if (chessboard.get(i).charAt(j)=='K'|chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j] = new KingChessComponent(i,j,chessboard.get(i).charAt(j),this.chessboard);
                }else  if (chessboard.get(i).charAt(j)=='Q'|chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j] = new QueenChessComponent(i,j,chessboard.get(i).charAt(j),this.chessboard);
                }else  if (chessboard.get(i).charAt(j)=='N'|chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j] = new KnightChessComponent(i,j,chessboard.get(i).charAt(j),this.chessboard);
                }else  if (chessboard.get(i).charAt(j)=='p'|chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j] = new PawnChessComponent(i,j,chessboard.get(i).charAt(j),this.chessboard);
                }else  if (chessboard.get(i).charAt(j)=='R'|chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j] = new RookChessComponent(i,j,chessboard.get(i).charAt(j),this.chessboard);
                }else {
                    chessComponents[i][j] = new EmptySlotComponent(i,j,'_',this.chessboard);
                }
            }
        }
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }


    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        return chessboard.get(0) + "\n" + chessboard.get(1) + "\n" + chessboard.get(2) + "\n" + chessboard.get(3) +
                "\n" + chessboard.get(4) + "\n" + chessboard.get(5) + "\n" + chessboard.get(6) + "\n" + chessboard.get(7);
    }


    public String getCapturedChess(ChessColor player) {
        StringBuilder sb = new StringBuilder();
        int total;
        if (player==ChessColor.WHITE) {
            for (LossWhite c : LossWhite.values()) {
                String s1 = getChessboardGraph();
                String s2 = c.getName();
                int oldCount = s1.length();
                int newCount = s1.replace(s2, "").length();
                total = 0;
                if (s2.equals("k") | s2.equals("q")) {
                    total = 1 - oldCount + newCount;
                }
                if (s2.equals("b") | s2.equals("n") | s2.equals("r")) {
                    total = 2 - oldCount + newCount;
                }
                if (s2.equals("p")) {
                    total = 8 - oldCount + newCount;
                }

                if (total != 0) {
                    sb.append(s2);
                    sb.append(" ");
                    sb.append(total);
                    sb.append("\n");
                }
            }
        } else if (player==ChessColor.BLACK) {
            for (LossBlack c : LossBlack.values()) {
                String s1 = getChessboardGraph();
                String s2 = c.getName();
                int oldCount = s1.length();
                int newCount = s1.replace(s2,"").length();
                total = 0;
                if (s2.equals("K") | s2.equals("Q")) {
                    total = 1 - oldCount + newCount;
                }
                if (s2.equals("B") | s2.equals("N") | s2.equals("R")) {
                    total = 2 - oldCount + newCount;
                }
                if (s2.equals("P")) {
                    total = 8 - oldCount + newCount;
                }

                if (total != 0) {
                    sb.append(s2);
                    sb.append(" ");
                    sb.append(total);
                    sb.append("\n");
                }

            }

        }
        return sb.toString();
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = getChess(source.getX(),source.getY()).canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        Collections.sort(canMovePoints);
        return canMovePoints;
    }



    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        boolean have = false;
        List<ChessboardPoint> points = getCanMovePoints(source);
        List<String> chessBoard = new ArrayList<>();
        if (((getCurrentPlayer()==ChessColor.BLACK)&&chessboard.get(sourceX).charAt(sourceY)<'Z')|
                (getCurrentPlayer()==ChessColor.WHITE&&chessboard.get(sourceX).charAt(sourceY)>'a')) {
            for (ChessboardPoint point : points) {
                if (point.getX() == targetX && point.getY() == targetY) {
                    have = true;
                    break;
                }
            }
        }
        if (have) {
            String[] tcp = chessboard.get(targetX).split("");
            tcp[targetY] = String.valueOf(chessboard.get(sourceX).charAt(sourceY));
            String[] scp = chessboard.get(sourceX).split("");
            scp[sourceY] = "_";
            StringBuilder sb1 = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                sb1.append(tcp[i]);
            }
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                sb2.append(scp[i]);
            }
            for (int i = 0; i < chessboard.size(); i++) {
                if (i != targetX && i != sourceX) {
                    chessBoard.add(chessboard.get(i));
                } else if (i == targetX) {
                    chessBoard.add(sb1.toString());
                } else {
                    chessBoard.add(sb2.toString());
                }
            }
            loadChessGame(chessBoard);

            return true;
        } else {
            return false;
        }
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }



}
