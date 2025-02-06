import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void loadChessGame(List<String> chessboard) {

        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R':chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));break;
                    case 'N':chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));break;
                    case 'B':chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));break;
                    case 'Q':chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));break;
                    case 'K':chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));break;
                    case 'P':chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));break;

                    case '_':chessComponents[i][j]=new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(i,j));break;

                    case 'r':chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));break;
                    case 'n':chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));break;
                    case 'b':chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));break;
                    case 'q':chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));break;
                    case 'k':chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE, new ChessboardPoint(i,j));break;
                    case 'p':chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));break;
                }
                chessComponents[i][j].setChessComponents(chessComponents);
            }
            if(chessboard.get(8).equals("w")){
                currentPlayer=ChessColor.WHITE;
            }else {
                currentPlayer=ChessColor.BLACK;
            }
        }
    }

    public ChessColor getCurrentPlayer() {//why here we need to override, it appears only one time
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        String result ="";
        for(int j=0;j<8;j++) {
            for (int i = 0; i < 8; i++) {
                result = result + chessComponents[j][i].name;
            }
            result = result + "\n";
        }

        return result;
    }

    public String getCapturedChess(ChessColor player) {
        int RookCounter=2;
        int KnightCounter=2;
        int BishopCounter=2;
        int QueenCounter=1;
        int KingCounter=1;
        int PawnCounter=8;
        String result="";
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'R') {
                        RookCounter--;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        KnightCounter--;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        BishopCounter--;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        QueenCounter--;
                    }
                    if (chessComponents[i][j].name == 'K') {
                        KingCounter--;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        PawnCounter--;
                    }
                }
            }


                if (KingCounter != 0) {
                    result = result + "K " + KingCounter + "\n";
                }
                if (QueenCounter != 0) {
                    result = result + "Q " + QueenCounter + "\n";
                }
                if (RookCounter != 0) {
                    result = result + "R " + RookCounter + "\n";
                }
                if (BishopCounter != 0) {
                    result = result + "B " + BishopCounter + "\n";
                }
                if (KnightCounter != 0) {
                    result = result + "N " + KnightCounter + "\n";
                }
                if (PawnCounter != 0) {
                    result = result + "P " + PawnCounter + "\n";
                }
        }
        if(player ==ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'r') {
                        RookCounter--;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        KnightCounter--;
                    }
                    if (chessComponents[i][j].name == 'b') {
                        BishopCounter--;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        QueenCounter--;
                    }
                    if (chessComponents[i][j].name == 'k') {
                        KingCounter--;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        PawnCounter--;
                    }
                }
            }
                if (KingCounter != 0) {
                    result = result + "k " + KingCounter + "\n";
                }
                if (QueenCounter != 0) {
                    result = result + "q " + QueenCounter + "\n";
                }
                if (RookCounter != 0) {
                    result = result + "r " + RookCounter + "\n";
                }
                if (BishopCounter != 0) {
                    result = result + "b " + BishopCounter + "\n";
                }
                if (KnightCounter != 0) {
                    result = result + "n " + KnightCounter + "\n";
                }
                if (PawnCounter != 0) {
                    result = result + "p " + PawnCounter + "\n";
                }
            
        }
        return result;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
//        switch (chessComponents[x][y].name) {
//            case 'K':
//                return new KingChessComponent(ChessColor.WHITE, new ChessboardPoint(x, y));
//            case 'Q':
//                return new QueenChessComponent(ChessColor.WHITE, new ChessboardPoint(x, y));
//            case 'R':
//                return new RookChessComponent(ChessColor.WHITE, new ChessboardPoint(x, y));
//            case 'B':
//                return new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(x, y));
//            case 'N':
//                return new KnightChessComponent(ChessColor.WHITE, new ChessboardPoint(x, y));
//            case 'P':
//                return new PawnChessComponent(ChessColor.WHITE, new ChessboardPoint(x, y));
//
//            case 'k':
//                return new KingChessComponent(ChessColor.BLACK, new ChessboardPoint(x, y));
//            case 'q':
//                return new QueenChessComponent(ChessColor.BLACK, new ChessboardPoint(x, y));
//            case 'r':
//                return new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(x, y));
//            case 'b':
//                return new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(x, y));
//            case 'n':
//                return new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(x, y));
//            case 'p':
//                return new PawnChessComponent(ChessColor.BLACK, new ChessboardPoint(x, y));
//
//            default:
//                return new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(x,y));
//        }
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        if (getChess(sourceX, sourceY).getChessColor() == currentPlayer) {
            ChessComponent sourceComponent = chessComponents[sourceX][sourceY];
            for (int i = 0; i < sourceComponent.canMoveTo().size(); i++) {
                if ((sourceComponent.canMoveTo().get(i).getX() == targetX) &&
                        (sourceComponent.canMoveTo().get(i).getY() == targetY)) {
                    sourceComponent.setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[targetX][targetY]=sourceComponent;
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(sourceX,sourceY));
                    if(currentPlayer==ChessColor.WHITE){
                        currentPlayer=ChessColor.BLACK;
                    }else {
                        currentPlayer=ChessColor.WHITE;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent sourceComponent = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = sourceComponent.canMoveTo();
        List<ChessboardPoint> help=new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++) {
                for (int k = 0; k < sourceComponent.canMoveTo().size(); k++) {
                    if (( j== sourceComponent.canMoveTo().get(k).getY())&&
                    i==sourceComponent.canMoveTo().get(k).getX()){
                        help.add(sourceComponent.canMoveTo().get(k));
                    }
                }
            }
        }
        canMovePoints=help;
        return canMovePoints;
    }

}


