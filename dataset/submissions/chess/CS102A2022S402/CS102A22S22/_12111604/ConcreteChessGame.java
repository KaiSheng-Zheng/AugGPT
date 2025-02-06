import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame  implements ChessGame{
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }


    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0) == 'w')  currentPlayer = ChessColor.WHITE;
        else if (chessboard.get(8).charAt(0) == 'b') currentPlayer = ChessColor.BLACK;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                }
                if (chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                }
                if (chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                }
                if (chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                }
                if (chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                }
                if (chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                }
                if (chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                }
                if (chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                }
                if (chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                }
                if (chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                }
                if (chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                }
                if (chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                }
                if (chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].load(chessComponents,currentPlayer);
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
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph.append(chessComponents[i][j].name);
            }
            graph.append("\n");
        }
        return graph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {

        int R = 0;
        int r = 0;
        int N = 0;
        int n = 0;
        int B = 0;
        int b = 0;
        int Q = 0;
        int q = 0;
        int K = 0;
        int k = 0;
        int P = 0;
        int p = 0;

        StringBuilder white = new StringBuilder();
        StringBuilder black = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (chessComponents[i][j]instanceof RookChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                    R++;
                }else if (chessComponents[i][j]instanceof RookChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                    r++;
                    System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQ");
                }else if (chessComponents[i][j]instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                    N++;
                }else if (chessComponents[i][j]instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                    n++;
                }else if (chessComponents[i][j]instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                    B++;
                }else if (chessComponents[i][j]instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                    b++;
                }else if (chessComponents[i][j]instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                    Q++;
                }else if (chessComponents[i][j]instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                    q++;
                }else if (chessComponents[i][j]instanceof KingChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                    K++;
                }else if (chessComponents[i][j]instanceof KingChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                    k++;
                }else if (chessComponents[i][j]instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                    P++;
                }else if (chessComponents[i][j]instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                    p++;
                }
            }
        }
        if (K < 1){
            black.append("K 1\n");
        }
        if (Q < 1){
            black.append("Q ").append(1 - Q).append("\n");
        }
        if (R < 2){
            black.append("R ").append(2 - R).append("\n");
        }
        if (B < 2){
            black.append("B ").append(2 - B).append("\n");
        }
        if (N < 2){
            black.append("N ").append(2 - N).append("\n");
        }
        if (P < 8){
            black.append("P ").append(8 - P).append("\n");
        }
        if (k < 1){
            white.append("k 1\n");
        }
        if (q < 1){
            white.append("q ").append(1 - q).append("\n");
        }
        if (r < 2){
            white.append("r ").append(2 - r).append("\n");
        }
        if (b < 2){
            white.append("b ").append(2 - b).append("\n");
        }
        if (n < 2){
            white.append("n ").append(2 - n).append("\n");
        }
        if (p < 8){
            white.append("p ").append(8 - p).append("\n");
        }

        if (player == ChessColor.BLACK){
            return black.toString();
        }else {
            return white.toString();
        }





    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int kk = 0;
        for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
            if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX() == targetX && chessComponents[sourceX][sourceY].canMoveTo().get(i).getY() == targetY){
                kk = 1;
            }

        }
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer && kk == 1 && chessComponents[sourceX][sourceY].getChessColor() != chessComponents[targetX][targetY].getChessColor()){
            if (chessComponents[sourceX][sourceY].name == 'R'){
                chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'R');
            }
            if (chessComponents[sourceX][sourceY].name == 'r'){
                chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'r');
            }
            if (chessComponents[sourceX][sourceY].name == 'Q'){
                chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'Q');
            }
            if (chessComponents[sourceX][sourceY].name == 'r'){
                chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'r');
            }
            if (chessComponents[sourceX][sourceY].name == 'P'){
                chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'P');
            }
            if (chessComponents[sourceX][sourceY].name == 'p'){
                chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'p');
            }
            if (chessComponents[sourceX][sourceY].name == 'N'){
                chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'N');
            }
            if (chessComponents[sourceX][sourceY].name == 'n'){
                chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'n');
            }
            if (chessComponents[sourceX][sourceY].name == 'K'){
                chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'K');
            }
            if (chessComponents[sourceX][sourceY].name == 'k'){
                chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'k');
            }
            if (chessComponents[sourceX][sourceY].name == 'B'){
                chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'B');
            }
            if (chessComponents[sourceX][sourceY].name == 'b'){
                chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'b');
            }
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            if (currentPlayer == ChessColor.BLACK) {
                setCurrentPlayer(ChessColor.WHITE);
            }else {
                setCurrentPlayer(ChessColor.BLACK);
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    getChessComponents()[i][j].load(getChessComponents(),getCurrentPlayer());
                }
            }
            return true;
        }else {
            return false;
        }
    }


}
