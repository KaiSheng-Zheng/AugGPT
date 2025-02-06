import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
    public ConcreteChessGame(){
    }
    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer){
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }
    //
    public void loadChessGame(List<String> chessboard){
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if(chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j].setName('P');
                } else
                if(chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j].setName('p');
                } else
                if(chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j].setName('R');
                } else
                if(chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j].setName('r');
                } else
                if(chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j].setName('N');
                } else
                if(chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j].setName('n');
                } else
                if(chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j].setName('B');
                } else
                if(chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j].setName('b');
                } else
                if(chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j].setName('Q');
                } else
                if(chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j].setName('q');
                } else
                if(chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                    chessComponents[i][j].setName('K');
                } else
                if (chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                    chessComponents[i][j].setName('k');
                } else if(chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j));
                    chessComponents[i][j].setName('_');
                }
                chessComponents[i][j].setChessBoard(this);
            }
        }
        if (chessboard.get(8).charAt(0) == 'w'){
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
    }


    @Override
    public void setCurrentPlayer(ChessColor chessColor){
        this.currentPlayer = chessColor;
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
        StringBuilder sb = new StringBuilder();
        for (ChessComponent[] chessComponentss: chessComponents){
            for (ChessComponent chessComponent: chessComponentss){
                if (chessComponent instanceof EmptySlotComponent){
                    sb.append("_");
                } else if (chessComponent instanceof PawnChessComponent){
                    if (chessComponent.getChessColor() == ChessColor.WHITE){
                        sb.append("p");
                    } else {
                        sb.append("P");
                    }
                } else if (chessComponent instanceof RookChessComponent){
                    if (chessComponent.getChessColor() == ChessColor.WHITE){
                        sb.append("r");
                    } else {
                        sb.append("R");
                    }
                } else if (chessComponent instanceof KnightChessComponent){
                    if (chessComponent.getChessColor() == ChessColor.WHITE){
                        sb.append("n");
                    } else {
                        sb.append("N");
                    }
                } else if (chessComponent instanceof BishopChessComponent){
                    if (chessComponent.getChessColor() == ChessColor.WHITE){
                        sb.append("b");
                    } else {
                        sb.append("B");
                    }
                } else if (chessComponent instanceof QueenChessComponent){
                    if (chessComponent.getChessColor() == ChessColor.WHITE){
                        sb.append("q");
                    } else {
                        sb.append("Q");
                    }
                } else if (chessComponent instanceof KingChessComponent){
                    if (chessComponent.getChessColor() == ChessColor.WHITE){
                        sb.append("k");
                    } else {
                        sb.append("K");
                    }
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor Player) {
        //0-5 white 6-11 black
        int[] cnt = new int[12];
        cnt[0] = 1;
        cnt[1] = 1;
        cnt[2] = 2;
        cnt[3] = 2;
        cnt[4] = 2;
        cnt[5] = 8;
        cnt[6] = 1;
        cnt[7] = 1;
        cnt[8] = 2;
        cnt[9] = 2;
        cnt[10] = 2;
        cnt[11] = 8;

        for (ChessComponent[] chessComponentss: chessComponents){
            for (ChessComponent chessComponent: chessComponentss){
                if (chessComponent instanceof PawnChessComponent){
                    if (chessComponent.getChessColor() == ChessColor.WHITE){
                        cnt[5]--;
                    } else {
                        cnt[11]--;
                    }
                } else if (chessComponent instanceof RookChessComponent){
                    if (chessComponent.getChessColor() == ChessColor.WHITE){
                        cnt[2]--;
                    } else {
                        cnt[8]--;
                    }
                } else if (chessComponent instanceof KnightChessComponent){
                    if (chessComponent.getChessColor() == ChessColor.WHITE){
                        cnt[4]--;
                    } else {
                        cnt[10]--;
                    }
                } else if (chessComponent instanceof BishopChessComponent){
                    if (chessComponent.getChessColor() == ChessColor.WHITE){
                        cnt[3]--;
                    } else {
                        cnt[9]--;
                    }
                } else if (chessComponent instanceof QueenChessComponent){
                    if (chessComponent.getChessColor() == ChessColor.WHITE){
                        cnt[1]--;
                    } else {
                        cnt[7]--;
                    }
                } else if (chessComponent instanceof KingChessComponent){
                    if (chessComponent.getChessColor() == ChessColor.WHITE){
                        cnt[0]--;
                    } else {
                        cnt[6]--;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (Player == ChessColor.WHITE){
            for (int i = 0; i < 6; i++){
                if (cnt[i] != 0){
                    switch(i){
                        case 0:
                            sb.append("k ");
                            sb.append(cnt[i]);
                            sb.append("\n");
                            break;
                        case 1:
                            sb.append("q ");
                            sb.append(cnt[i]);
                            sb.append("\n");
                            break;
                        case 2:
                            sb.append("r ");
                            sb.append(cnt[i]);
                            sb.append("\n");
                            break;
                        case 3:
                            sb.append("b ");
                            sb.append(cnt[i]);
                            sb.append("\n");
                            break;
                        case 4:
                            sb.append("n ");
                            sb.append(cnt[i]);
                            sb.append("\n");
                            break;
                        case 5:
                            sb.append("p ");
                            sb.append(cnt[i]);
                            sb.append("\n");
                            break;

                    }
                }
            }
        } else {
            for (int i = 5; i < 12; i++){
                if (cnt[i] != 0){
                    switch(i){
                        case 6:
                            sb.append("K ");
                            sb.append(cnt[i]);
                            sb.append("\n");
                            break;
                        case 7:
                            sb.append("Q ");
                            sb.append(cnt[i]);
                            sb.append("\n");
                            break;
                        case 8:
                            sb.append("R ");
                            sb.append(cnt[i]);
                            sb.append("\n");
                            break;
                        case 9:
                            sb.append("B ");
                            sb.append(cnt[i]);
                            sb.append("\n");
                            break;
                        case 10:
                            sb.append("N ");
                            sb.append(cnt[i]);
                            sb.append("\n");
                            break;
                        case 11:
                            sb.append("P ");
                            sb.append(cnt[i]);
                            sb.append("\n");
                            break;
                    }
                }
            }
        }

        return sb.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY)  {
        chessComponents[targetX][targetY].setChessBoard(this);
        //judge if you can move the chess
        if (Character.isUpperCase(chessComponents[sourceX][sourceY].getName())){
            if (currentPlayer == ChessColor.WHITE){
                return false;
            }
        } else if (Character.isLowerCase(chessComponents[sourceX][sourceY].getName())){
            if (currentPlayer == ChessColor.BLACK){
                return false;
            }
        }
        ArrayList<ChessboardPoint> movePoints = (ArrayList<ChessboardPoint>) chessComponents[sourceX][sourceY].canMoveTo();
        if (!movePoints.contains(new ChessboardPoint(targetX,targetY))){
            return false;
        }
        //judge if the target chess point is empty
        chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
        chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
        if (currentPlayer == ChessColor.BLACK){
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
        return true;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        if (chessComponents[source.getX()][source.getY()].toString().equals("_")){
            return new ArrayList<>();
        }
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        return canMovePoints;
    }


}
