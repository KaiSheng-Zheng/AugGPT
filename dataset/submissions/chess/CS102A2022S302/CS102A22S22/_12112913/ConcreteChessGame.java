import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }


    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }
    public ConcreteChessGame() {
    }

    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent chessComponent;
                ChessboardPoint chessboardPoint = new ChessboardPoint(i,j);
                switch (chessboard.get(i).charAt(j)){
                    case 'P':
                        chessComponent = new PawnChessComponent(chessboardPoint,ChessColor.BLACK,'P');
                        chessComponents[i][j] = chessComponent;
                        break;
                    case 'p':
                        chessComponent = new PawnChessComponent(chessboardPoint,ChessColor.WHITE,'p');
                        chessComponents[i][j] = chessComponent;
                        break;
                    case 'R':
                        chessComponent = new RookChessComponent(chessboardPoint,ChessColor.BLACK,'R');
                        chessComponents[i][j] = chessComponent;
                        break;
                    case 'r':
                        chessComponent = new RookChessComponent(chessboardPoint,ChessColor.WHITE,'r');
                        chessComponents[i][j] = chessComponent;
                        break;
                    case 'N':
                        chessComponent = new KnightChessComponent(chessboardPoint,ChessColor.BLACK,'N');
                        chessComponents[i][j] = chessComponent;
                        break;
                    case 'n':
                        chessComponent = new KnightChessComponent(chessboardPoint,ChessColor.WHITE,'n');
                        chessComponents[i][j] = chessComponent;
                        break;
                    case 'B':
                        chessComponent = new BishopChessComponent(chessboardPoint,ChessColor.BLACK,'B');
                        chessComponents[i][j] = chessComponent;
                        break;
                    case 'b':
                        chessComponent = new BishopChessComponent(chessboardPoint,ChessColor.WHITE,'b');
                        chessComponents[i][j] = chessComponent;
                        break;
                    case 'Q':
                        chessComponent = new QueenChessComponent(chessboardPoint,ChessColor.BLACK,'Q');
                        chessComponents[i][j] = chessComponent;
                        break;
                    case 'q':
                        chessComponent = new QueenChessComponent(chessboardPoint,ChessColor.WHITE,'q');
                        chessComponents[i][j] = chessComponent;
                        break;
                    case 'K':
                        chessComponent = new KingChessComponent(chessboardPoint,ChessColor.BLACK,'K');
                        chessComponents[i][j] = chessComponent;
                        break;
                    case 'k':
                        chessComponent = new KingChessComponent(chessboardPoint,ChessColor.WHITE,'k');
                        chessComponents[i][j] = chessComponent;
                        break;
                    default:
                        chessComponent = new EmptySlotComponent(chessboardPoint,ChessColor.NONE,'_');
                        chessComponents[i][j] = chessComponent;
                        break;
                }
            }
        }
        if (chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }else{
            currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    public ChessComponent getChess(int x, int y){
        return this.chessComponents[x][y];
    }

    public String getChessboardGraph(){
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            char[] name = new char[8];
            for (int j = 0; j < 8; j++) {
                name[j] = this.chessComponents[i][j].name;
            }
            arrayList.add(String.valueOf(name));
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n",arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5),arrayList.get(6),arrayList.get(7));
    }

    public String getCapturedChess(ChessColor player){
        String chessboard = this.getChessboardGraph();
        int[] chessNum = new int[6];
        if (player.equals(ChessColor.BLACK)){
            for (int i = 0; i < 72; i++) {
                switch (chessboard.charAt(i)){
                    case 'P':
                        chessNum[0]++;
                        break;
                    case 'R':
                        chessNum[1]++;
                        break;
                    case 'N':
                        chessNum[2]++;
                        break;
                    case 'B':
                        chessNum[3]++;
                        break;
                    case 'Q':
                        chessNum[4]++;
                        break;
                    case 'K':
                        chessNum[5]++;
                        break;
                }
            }
            String result = "";
            if (chessNum[5] != 1){
                result += "K 1\n";
            }
            if (chessNum[4] != 1){
                result += "Q 1\n";
            }
            if (chessNum[1] != 2){
                result += String.format("R %d\n",2-chessNum[1]);
            }
            if (chessNum[3] != 2){
                result += String.format("B %d\n",2-chessNum[3]);
            }
            if (chessNum[2] != 2){
                result += String.format("N %d\n",2-chessNum[2]);
            }
            if (chessNum[0] != 8){
                result += String.format("P %d\n",8-chessNum[0]);
            }
            return result;
        }else{
            for (int i = 0; i < 72; i++) {
                switch (chessboard.charAt(i)){
                    case 'p':
                        chessNum[0]++;
                        break;
                    case 'r':
                        chessNum[1]++;
                        break;
                    case 'n':
                        chessNum[2]++;
                        break;
                    case 'b':
                        chessNum[3]++;
                        break;
                    case 'q':
                        chessNum[4]++;
                        break;
                    case 'k':
                        chessNum[5]++;
                        break;
                }
            }
            String result = "";
            if (chessNum[5] != 1){
                result += "k 1\n";
            }
            if (chessNum[4] != 1){
                result += "q 1\n";
            }
            if (chessNum[1] != 2){
                result += String.format("r %d\n",2-chessNum[1]);
            }
            if (chessNum[3] != 2){
                result += String.format("b %d\n",2-chessNum[3]);
            }
            if (chessNum[2] != 2){
                result += String.format("n %d\n",2-chessNum[2]);
            }
            if (chessNum[0] != 8){
                result += String.format("p %d\n",8-chessNum[0]);
            }
            return result;
        }
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessComponent chessComponent = chessComponents[sourceX][sourceY];
        List<ChessboardPoint> canMoveTo = chessComponent.canMoveTo();
        for (int i = 0; i < canMoveTo.size(); i++) {
            if ((canMoveTo.get(i).getX() == targetX) && (canMoveTo.get(i).getY() == targetY)){
                return true;
            }
        }
        return false;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent chessComponent = chessComponents[source.getX()][source.getY()];
        return chessComponent.canMoveTo();
    }
}
