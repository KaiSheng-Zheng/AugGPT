import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }


    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'K')
                    this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'k')
                    this.chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'Q')
                    this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'q')
                    this.chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'R')
                    this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'r')
                    this.chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'B')
                    this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'b')
                    this.chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'N')
                    this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'n')
                    this.chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'P')
                    this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'p')
                    this.chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                else this.chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE);
            }
        }
        for (int i=0;i<8;i++)
            for (int j=0;j<8;j++) {
                chessComponents[i][j].setChessComponents(this.chessComponents);
            }
        switch (chessboard.get(8)) {
            case "w":
                this.currentPlayer = ChessColor.WHITE;
                break;
            case "b":
                this.currentPlayer = ChessColor.BLACK;
                break;
        }
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder Graph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Graph.append(getChess(i, j).name);
            }
            Graph.append("\n");
        }
        return new String(Graph);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder CapturedChess = new StringBuilder();
        int cntK = 0, cntQ = 0, cntR = 0, cntB = 0, cntN = 0, cntP = 0;
        if (player.equals(ChessColor.BLACK)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (getChess(i, j).name == 'K')
                        cntK++;
                    else if (getChess(i, j).name == 'Q')
                        cntQ++;
                    else if (getChess(i, j).name == 'R')
                        cntR++;
                    else if (getChess(i, j).name == 'B')
                        cntB++;
                    else if (getChess(i, j).name == 'N')
                        cntN++;
                    else if (getChess(i, j).name == 'P')
                        cntP++;
                }
            }
            if (cntK<1)
                CapturedChess.append("K "+(1-cntK)+"\n");
            if (cntQ<1)
                CapturedChess.append("Q "+(1-cntQ)+"\n");
            if (cntR<2)
                CapturedChess.append("R "+(2-cntR)+"\n");
            if (cntB<2)
                CapturedChess.append("B "+(2-cntB)+"\n");
            if (cntN<2)
                CapturedChess.append("N "+(2-cntN)+"\n");
            if (cntP<8)
                CapturedChess.append("P "+(8-cntP)+"\n");
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (getChess(i, j).name == 'k')
                        cntK++;
                    else if (getChess(i, j).name == 'q')
                        cntQ++;
                    else if (getChess(i, j).name == 'r')
                        cntR++;
                    else if (getChess(i, j).name == 'b')
                        cntB++;
                    else if (getChess(i, j).name == 'n')
                        cntN++;
                    else if (getChess(i, j).name == 'p')
                        cntP++;
                }
            }
            if (cntK<1)
                CapturedChess.append("k "+(1-cntK)+"\n");
            if (cntQ<1)
                CapturedChess.append("q "+(1-cntQ)+"\n");
            if (cntR<2)
                CapturedChess.append("r "+(2-cntR)+"\n");
            if (cntB<2)
                CapturedChess.append("b "+(2-cntB)+"\n");
            if (cntN<2)
                CapturedChess.append("n "+(2-cntN)+"\n");
            if (cntP<8)
                CapturedChess.append("p "+(8-cntP)+"\n");
        }
        return new String(CapturedChess);
    }

//    @Override
//    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
//        List<ChessboardPoint> canMovePoints = getChess(source.getX(),source.getY()).canMoveTo();
//        return canMovePoints;
//    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> newList = new ArrayList<>();
        List<ChessboardPoint> list = chessComponents[source.getX()][source.getY()].canMoveTo();
        if (list.size() == 0) {
            return newList;
        }
        int[] location = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            location[i] = 10 * list.get(i).getX() + list.get(i).getY();
        }
        Arrays.sort(location);

        for (int i = 0; i < location.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getY() + list.get(j).getX() * 10 == location[i]) {
                    newList.add(list.get(j));
                    break;
                }
            }
        }
        return newList;
    }

    
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess=chessComponents[sourceX][sourceY];
        if (getCurrentPlayer().equals(chess.getChessColor())){
            if (CanMoveTo(chessComponents[sourceX][sourceY],new ChessboardPoint(targetX,targetY))) {
                chess.setSource(new ChessboardPoint(targetX, targetY));
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);

                if (getCurrentPlayer().equals(ChessColor.WHITE)) {
                    setCurrentPlayer(ChessColor.BLACK);
                    return true;
                } else {
                    setCurrentPlayer(ChessColor.WHITE);
                    return true;
                }
            }else
                return false;
        }else
            return false;
    }
    

    public static boolean CanMoveTo(ChessComponent component,ChessboardPoint target){
        List<ChessboardPoint> chessboardPoints= component.canMoveTo();
        for (int i=0;i< chessboardPoints.size();i++){
            if (chessboardPoints.get(i).getX()== target.getX()&&chessboardPoints.get(i).getY()== target.getY())
                return true;
        }
        return false;
    }

}