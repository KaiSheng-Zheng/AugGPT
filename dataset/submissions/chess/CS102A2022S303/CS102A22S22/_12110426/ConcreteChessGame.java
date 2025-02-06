import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents =new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.BLACK;
    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (String.valueOf(chessboard.get(i).charAt(j)).equals("K")) {
                    ChessboardPoint a2 = new ChessboardPoint(i, j);
                    KingChessComponent a1 = new KingChessComponent(a2, ChessColor.BLACK, 'K');
                    chessComponents[i][j] = a1;
                } else if (String.valueOf(chessboard.get(i).charAt(j)).equals("k")) {
                    ChessboardPoint a2 = new ChessboardPoint(i, j);
                    KingChessComponent a1 = new KingChessComponent(a2, ChessColor.WHITE, 'k');
                    chessComponents[i][j] = a1;
                } else if (String.valueOf(chessboard.get(i).charAt(j)).equals("R")) {
                    ChessboardPoint a2 = new ChessboardPoint(i, j);
                    RookChessComponent a1 = new RookChessComponent(a2, ChessColor.BLACK, 'R');
                    chessComponents[i][j] = a1;
                } else if (String.valueOf(chessboard.get(i).charAt(j)).equals("r")) {
                    ChessboardPoint a2 = new ChessboardPoint(i, j);
                    RookChessComponent a1 = new RookChessComponent(a2, ChessColor.WHITE, 'r');
                    chessComponents[i][j] = a1;
                } else if (String.valueOf(chessboard.get(i).charAt(j)).equals("N")) {
                    ChessboardPoint a2 = new ChessboardPoint(i, j);
                    KnightChessComponent a1 = new KnightChessComponent(a2, ChessColor.BLACK, 'N');
                    chessComponents[i][j] = a1;
                }else if (String.valueOf(chessboard.get(i).charAt(j)).equals("n")) {
                    ChessboardPoint a2 = new ChessboardPoint(i, j);
                    KnightChessComponent a1 = new KnightChessComponent(a2, ChessColor.WHITE, 'n');
                    chessComponents[i][j] = a1;
                }else if (String.valueOf(chessboard.get(i).charAt(j)).equals("B")) {
                    ChessboardPoint a2 = new ChessboardPoint(i, j);
                    BishopChessComponent a1 = new BishopChessComponent(a2, ChessColor.BLACK, 'B');
                    chessComponents[i][j] = a1;
                }else if (String.valueOf(chessboard.get(i).charAt(j)).equals("b")) {
                    ChessboardPoint a2 = new ChessboardPoint(i, j);
                    BishopChessComponent a1 = new BishopChessComponent(a2, ChessColor.WHITE, 'b');
                    chessComponents[i][j] = a1;
                }else if (String.valueOf(chessboard.get(i).charAt(j)).equals("Q")) {
                    ChessboardPoint a2 = new ChessboardPoint(i, j);
                    QueenChessComponent a1 = new QueenChessComponent(a2, ChessColor.BLACK, 'Q');
                    chessComponents[i][j] = a1;
                }else if (String.valueOf(chessboard.get(i).charAt(j)).equals("q")) {
                    ChessboardPoint a2 = new ChessboardPoint(i, j);
                    QueenChessComponent a1 = new QueenChessComponent(a2, ChessColor.WHITE, 'q');
                    chessComponents[i][j] = a1;
                }else if (String.valueOf(chessboard.get(i).charAt(j)).equals("P")) {
                    ChessboardPoint a2 = new ChessboardPoint(i, j);
                    PawnChessComponent a1 = new PawnChessComponent(a2, ChessColor.BLACK, 'P');
                    chessComponents[i][j] = a1;
                }else if (String.valueOf(chessboard.get(i).charAt(j)).equals("p")) {
                    ChessboardPoint a2 = new ChessboardPoint(i, j);
                    PawnChessComponent a1 = new PawnChessComponent(a2, ChessColor.WHITE, 'p');
                    chessComponents[i][j] = a1;
                }else if (String.valueOf(chessboard.get(i).charAt(j)).equals("_")) {
                    ChessboardPoint a2 = new ChessboardPoint(i, j);
                    EmptySlotComponent a1 = new EmptySlotComponent(a2, ChessColor.NONE, '_');
                    chessComponents[i][j] = a1;
                }
            }
        }
        if (chessboard.get(8).equals("w")){
            this.currentPlayer=ChessColor.WHITE;
        }else {
            this.currentPlayer=ChessColor.BLACK;
        }
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                ChessComponent component =chessComponents[i][j];
                component.setChessComponents(getChessComponents());

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
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                str.append(chessComponents[i][j].name);
            }
            str.append("\n");
        }
        for (int i = 0; i < 8; i++) {
            str.append(chessComponents[7][i]);
        }
        return String.valueOf(str);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int k=1,q=1,r=2,b=2,n=2,p=8;
        StringBuilder str1 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor()==player){
                    if (chessComponents[i][j] instanceof KingChessComponent){
                        k--;
                    }else if (chessComponents[i][j] instanceof QueenChessComponent){
                        q--;
                    }else if (chessComponents[i][j] instanceof RookChessComponent){
                        r--;
                    }else if (chessComponents[i][j] instanceof BishopChessComponent){
                        b--;
                    }else if (chessComponents[i][j] instanceof KnightChessComponent){
                        n--;
                    }else if (chessComponents[i][j] instanceof PawnChessComponent){
                        p--;
                    }
                }
            }
        }
        if (player==ChessColor.BLACK){
            if (k!=0){
                str1.append("K ").append(k).append("\n");
            }
            if (q!=0){
                str1.append("Q ").append(q).append("\n");
            }
            if (r!=0){
                str1.append("R ").append(r).append("\n"); }
            if (b!=0){
                str1.append("B ").append(b).append("\n");    }
            if (n!=0){
                str1.append("N ").append(n).append("\n");    }
            if (p!=0){
                str1.append("P ").append(p).append("\n");    }
        }else if (player==ChessColor.WHITE){          if (k!=0){
            str1.append("k ").append(k).append("\n");
        }
        if (q!=0){
            str1.append("q ").append(q).append("\n");
        }
        if (r!=0){
            str1.append("r ").append(r).append("\n"); }
        if (b!=0){
            str1.append("b ").append(b).append("\n");    }
        if (n!=0){
            str1.append("n ").append(n).append("\n");    }
        if (p!=0){
            str1.append("p ").append(p).append("\n");    }

        }
        return String.valueOf(str1);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        int row = source.getX();int col = source.getY();
        canMovePoints = chessComponents[row][col].canMoveTo();
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int ab=0;
        if (sourceX>=8||sourceY>=8||targetX>=8||targetY>=8){return false;}
        else if (chessComponents[sourceX][sourceY].getChessColor()!=getCurrentPlayer()){return false;}
        else {
            for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
                if (chessComponents[sourceX][sourceY].canMoveTo().get(i) == chessComponents[targetX][targetY].getSource()) {
                    ab++;
                    break;
                }
            }
            if (ab==0){
                return false;
            }else {
                if (getChess(sourceX,sourceY).getChessColor()==ChessColor.BLACK){
                    this.currentPlayer=ChessColor.WHITE;
                }else {
                this.currentPlayer=ChessColor.BLACK;}
                ChessboardPoint a2 = new ChessboardPoint(sourceX, sourceY);
                EmptySlotComponent a1 = new EmptySlotComponent(a2, ChessColor.NONE, '_');
                ChessComponent a4 =chessComponents[sourceX][sourceY];
                a4.getSource().setX(targetX);a4.getSource().setY(targetY);
                chessComponents[sourceX][sourceY]=a1;chessComponents[targetX][targetY]=a4;
                for (int i = 0; i < chessComponents.length; i++) {
                    for (int j = 0; j < chessComponents[i].length; j++) {
                        chessComponents[i][j].setChessComponents(chessComponents);
                    }
                }
                return true;
            }
        }
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

}