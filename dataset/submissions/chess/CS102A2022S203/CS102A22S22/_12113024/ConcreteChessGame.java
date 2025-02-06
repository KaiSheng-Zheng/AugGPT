import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i = 0 ; i < 8; i++) {
            for(int j = 0 ; j < 8; j++)
                chessComponents[i][j] = new EmptySlotComponent();
        }
        for(int i = 0 ; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                setChessboard(i,j,chessboard.get(i).charAt(j));
            }
        }

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++)
                chessComponents[i][j].setChessComponents(chessComponents);
        }

        if(chessboard.size() == 9) setCurrentPlayer(chessboard.get(8));
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(String s) {
        if(s.equals("w")) currentPlayer = ChessColor.WHITE;
        else currentPlayer = ChessColor.BLACK;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++) {
                char c = getChessboard(i,j);
                ret.append(c);
            }
            ret.append('\n');
        }

        return String.valueOf(ret);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder ret = new StringBuilder();
        int num;

        if(player == ChessColor.WHITE) {
            num = numOfLostChess("k");
            if(num != 0) {
                ret.append('k'); ret.append(' '); ret.append((char)(num+'0')); ret.append('\n');
            }

            num = numOfLostChess("q");
            if(num != 0) {
                ret.append('q'); ret.append(' '); ret.append((char)(num+'0')); ret.append('\n');
            }

            num = numOfLostChess("r");
            if(num != 0) {
                ret.append('r'); ret.append(' '); ret.append((char)(num+'0')); ret.append('\n');
            }

            num = numOfLostChess("b");
            if(num != 0) {
                ret.append('b'); ret.append(' '); ret.append((char)(num+'0')); ret.append('\n');
            }

            num = numOfLostChess("n");
            if(num != 0) {
                ret.append('n'); ret.append(' '); ret.append((char)(num+'0')); ret.append('\n');
            }

            num = numOfLostChess("p");
            if(num != 0) {
                ret.append('p'); ret.append(' '); ret.append((char)(num+'0')); ret.append('\n');
            }
        }
        else if(player == ChessColor.BLACK) {
            num = numOfLostChess("K");
            if(num != 0) {
                ret.append('K'); ret.append(' '); ret.append((char)(num+'0')); ret.append('\n');
            }

            num = numOfLostChess("Q");
            if(num != 0) {
                ret.append('Q'); ret.append(' '); ret.append((char)(num+'0')); ret.append('\n');
            }

            num = numOfLostChess("R");
            if(num != 0) {
                ret.append('R'); ret.append(' '); ret.append((char)(num+'0')); ret.append('\n');
            }

            num = numOfLostChess("B");
            if(num != 0) {
                ret.append('B'); ret.append(' '); ret.append((char)(num+'0')); ret.append('\n');
            }

            num = numOfLostChess("N");
            if(num != 0) {
                ret.append('N'); ret.append(' '); ret.append((char)(num+'0')); ret.append('\n');
            }

            num = numOfLostChess("P");
            if(num != 0) {
                ret.append('P'); ret.append(' '); ret.append((char)(num+'0')); ret.append('\n');
            }
        }

        return String.valueOf(ret);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(chessComponents[sourceX][sourceY] instanceof EmptySlotComponent) return false;
        if(!belongTo(sourceX,sourceY)) return false;

        List<ChessboardPoint> list = chessComponents[sourceX][sourceY].canMoveTo();

        boolean flag = false;
        for(ChessboardPoint chessboardPoint : list) {
            if(chessboardPoint.getY() == targetY && chessboardPoint.getX() == targetX) {
                flag = true;
                break;
            }
        }
        if(flag) {
            setChessboard(targetX,targetY,chessComponents[sourceX][sourceY].name);
            setChessboard(sourceX,sourceY,'_');
            swapPlayer();

            for(int i = 0; i < 8; i++)
                for(int j = 0; j < 8; j++) {
                    chessComponents[i][j].setChessComponents(chessComponents);
                }

            return true;
        }

        return false;
    }

    private void setChessboard(int x, int y, char c) {

        switch (c) {
            case 'R': chessComponents[x][y] = new RookChessComponent(); chessComponents[x][y].setChessColor(ChessColor.BLACK); break;
            case 'N': chessComponents[x][y] = new KnightChessComponent(); chessComponents[x][y].setChessColor(ChessColor.BLACK); break;
            case 'B': chessComponents[x][y] = new BishopChessComponent(); chessComponents[x][y].setChessColor(ChessColor.BLACK); break;
            case 'Q': chessComponents[x][y] = new QueenChessComponent(); chessComponents[x][y].setChessColor(ChessColor.BLACK); break;
            case 'K': chessComponents[x][y] = new KingChessComponent(); chessComponents[x][y].setChessColor(ChessColor.BLACK); break;
            case 'P': chessComponents[x][y] = new PawnChessComponent(); chessComponents[x][y].setChessColor(ChessColor.BLACK); break;
            case 'r': chessComponents[x][y] = new RookChessComponent(); chessComponents[x][y].setChessColor(ChessColor.WHITE); break;
            case 'n': chessComponents[x][y] = new KnightChessComponent(); chessComponents[x][y].setChessColor(ChessColor.WHITE); break;
            case 'b': chessComponents[x][y] = new BishopChessComponent(); chessComponents[x][y].setChessColor(ChessColor.WHITE); break;
            case 'q': chessComponents[x][y] = new QueenChessComponent(); chessComponents[x][y].setChessColor(ChessColor.WHITE); break;
            case 'k': chessComponents[x][y] = new KingChessComponent(); chessComponents[x][y].setChessColor(ChessColor.WHITE); break;
            case 'p': chessComponents[x][y] = new PawnChessComponent(); chessComponents[x][y].setChessColor(ChessColor.WHITE); break;
            default: chessComponents[x][y] = new EmptySlotComponent(); chessComponents[x][y].setChessColor(ChessColor.NONE); break;
        }
        chessComponents[x][y].name = c; chessComponents[x][y].setSource(new ChessboardPoint(x,y));
    }

    private char getChessboard(int x, int y) {
        return chessComponents[x][y].name;
    }


    private int numOfLostChess(String c) {
        int num = 0,totNum = 0;

        if(c.equals("K") || c.equals("k")) totNum = 1;
        if(c.equals("Q") || c.equals("q")) totNum = 1;
        if(c.equals("R") || c.equals("r")) totNum = 2;
        if(c.equals("B") || c.equals("b")) totNum = 2;
        if(c.equals("N") || c.equals("n")) totNum = 2;
        if(c.equals("P") || c.equals("p")) totNum = 8;

        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++) {
                if(chessComponents[i][j].toString().equals(c)) num++;
            }

        return totNum - num;
    }

    private void swapPlayer() {
        currentPlayer = (currentPlayer == ChessColor.BLACK) ? ChessColor.WHITE:ChessColor.BLACK;
    }

    private boolean belongTo(int x, int y) {
        char c = chessComponents[x][y].toString().charAt(0);
        if(c >= 'a' && c <= 'z' && currentPlayer == ChessColor.WHITE) return true;
        if(c >= 'A' && c <= 'Z' && currentPlayer == ChessColor.BLACK) return true;

        return false;
    }

}
