
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    public List<String> Chessboard;

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R')
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                if (chessboard.get(i).charAt(j) == 'r')
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                if (chessboard.get(i).charAt(j) == 'B')
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                if (chessboard.get(i).charAt(j) == 'b')
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                if (chessboard.get(i).charAt(j) == 'N')
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessComponents);
                if (chessboard.get(i).charAt(j) == 'n')
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessComponents);
                if (chessboard.get(i).charAt(j) == 'Q')
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                if (chessboard.get(i).charAt(j) == 'q')
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                if (chessboard.get(i).charAt(j) == 'K')
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, chessComponents);
                if (chessboard.get(i).charAt(j) == 'k')
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, chessComponents);
                if (chessboard.get(i).charAt(j) == 'P')
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                if (chessboard.get(i).charAt(j) == 'p')
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                if (chessboard.get(i).charAt(j) == '_')
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE);
            }
        }
        if (chessboard.get(8).equals("b"))
            currentPlayer = ChessColor.BLACK;
        if (chessboard.get(8).equals("w"))
            currentPlayer = ChessColor.WHITE;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder outPut = new StringBuilder("");

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                outPut.append(chessComponents[i][j].toString()).toString();
            }
            outPut.append("\n");
        }
        return outPut.toString();
    }


    @Override
    public String getCapturedChess(ChessColor player) {
        int KingNum = 1;
        int QueenNum = 1;
        int RookNum = 2;
        int BishopNum = 2;
        int KnightNum = 2;
        int PawnNum = 8;
        StringBuilder outPut = new StringBuilder("");
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().equals("K"))
                        KingNum--;
                    if (chessComponents[i][j].toString().equals("Q"))
                        QueenNum--;
                    if (chessComponents[i][j].toString().equals("R"))
                        RookNum--;
                    if (chessComponents[i][j].toString().equals("B"))
                        BishopNum--;
                    if (chessComponents[i][j].toString().equals("N"))
                        KnightNum--;
                    if (chessComponents[i][j].toString().equals("P"))
                        PawnNum--;
                }
            }
            if (KingNum != 0)
                outPut.append("K " + KingNum + "\n");
            if (QueenNum != 0)
                outPut.append("Q " + QueenNum + "\n");
            if (RookNum != 0)
                outPut.append("R " + RookNum + "\n");
            if (BishopNum != 0)
                outPut.append("B " + BishopNum + "\n");
            if (KnightNum != 0)
                outPut.append("N " + KnightNum + "\n");
            if (PawnNum != 0)
                outPut.append("P " + PawnNum + "\n");
            return outPut.toString();
        }
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().equals("k"))
                        KingNum--;
                    if (chessComponents[i][j].toString().equals("q"))
                        QueenNum--;
                    if (chessComponents[i][j].toString().equals("r"))
                        RookNum--;
                    if (chessComponents[i][j].toString().equals("b"))
                        BishopNum--;
                    if (chessComponents[i][j].toString().equals("n"))
                        KnightNum--;
                    if (chessComponents[i][j].toString().equals("p"))
                        PawnNum--;
                }
            }
            if (KingNum != 0)
                outPut.append("k " + KingNum + "\n");
            if (QueenNum != 0)
                outPut.append("q " + QueenNum + "\n");
            if (RookNum != 0)
                outPut.append("r " + RookNum + "\n");
            if (BishopNum != 0)
                outPut.append("b " + BishopNum + "\n");
            if (KnightNum != 0)
                outPut.append("n " + KnightNum + "\n");
            if (PawnNum != 0)
                outPut.append("p " + PawnNum + "\n");
            return outPut.toString();
        } else return null;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessboard(chessComponents);
        List<ChessboardPoint> result = chessComponents[source.getX()][source.getY()].canMoveTo();
        result.sort((chess1, chess2) -> {
            if (chess1.getX() != chess2.getX()) return chess1.getX() - chess2.getX();
            return chess1.getY() - chess2.getY();
        });
        return result;
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].setChessboard(chessComponents);
        if (currentPlayer==chessComponents[sourceX][sourceY].chessColor){
            List<ChessboardPoint> canMoveTo=chessComponents[sourceX][sourceY].canMoveTo();
            for (ChessboardPoint chessboardPoint :canMoveTo){
                if (chessboardPoint.getX()==targetX&&chessboardPoint.getY()==targetY){
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].source=new ChessboardPoint(targetX,targetY);
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
                    if (currentPlayer.getName().equals("Black")){
                        currentPlayer = ChessColor.WHITE;}
                    else if (currentPlayer.getName().equals("White")){
                        currentPlayer = ChessColor.BLACK;}
                    return true;
                }
            }
        }
        return false;
    }

}
