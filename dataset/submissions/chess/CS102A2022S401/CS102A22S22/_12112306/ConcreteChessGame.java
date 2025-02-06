    import java.util.*;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }
@Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
    public boolean equal(ChessboardPoint chess1,ChessboardPoint chess2){
        if(Objects.equals(null,chess1)){
            return false;
        }
       else if(chess1.getX() == chess2.getX()&&chess1.getY() == chess2.getY()){
            return true;
        }else {
            return false;
        }
    }
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char chess = chessboard.get(i).charAt(j);
                if (chessboard.get(i).charAt(j) == 'R')
                    chessComponents[i][j] = new RookChessComponent(chess, new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'N')
                    chessComponents[i][j] = new KnightChessComponent(chess, new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'B')
                    chessComponents[i][j] = new BishopChessComponent(chess, new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'Q')
                    chessComponents[i][j] = new QueenChessComponent(chess, new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j) == 'K')
                   chessComponents[i][j] = new KingChessComponent(chess, new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j)== 'P')
                    chessComponents[i][j] = new PawnChessComponent(chess, new ChessboardPoint(i, j), ChessColor.BLACK);
                else if (chessboard.get(i).charAt(j)== 'r')
                    chessComponents[i][j] = new RookChessComponent(chess, new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'n')
                    chessComponents[i][j] = new KnightChessComponent(chess, new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'b')
                    chessComponents[i][j] = new BishopChessComponent(chess, new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'q')
                    chessComponents[i][j] = new QueenChessComponent(chess, new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'k')
                    chessComponents[i][j] = new KingChessComponent(chess, new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j) == 'p')
                    chessComponents[i][j] = new PawnChessComponent(chess, new ChessboardPoint(i, j), ChessColor.WHITE);
                else if (chessboard.get(i).charAt(j)== '_')
                    chessComponents[i][j] = new EmptySlotComponent(chess, new ChessboardPoint(i, j), ChessColor.NONE);
                chessComponents[i][j].setChessboard(chessComponents);
            }

        }
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
    }


    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        String str = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                str += chessComponents[i][j].toString();
            }
            str += String.valueOf('\n');
        }
        return str;
    }

    public int totalNumber(String str, char number) {
        int i1 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == number) {
                i1++;
            }
        }
        return i1;
    }


   @Override
    public String getCapturedChess(ChessColor player) {//King>Queen>Rooks>Bishops>Knights(N)>Pawns 112228
        String sum = "";
        StringBuilder a1 = new StringBuilder();
        StringBuilder a2 = new StringBuilder();
        StringBuilder a3 = new StringBuilder();
        StringBuilder a4 = new StringBuilder();
        StringBuilder a5 = new StringBuilder();
        StringBuilder a6 = new StringBuilder();

        switch (player) {
            case BLACK -> {
                if (totalNumber(getChessboardGraph(), 'K') != 1) {
                    a1.append("K ");
                    a1.append(1 - totalNumber(getChessboardGraph(), 'K'));
                    sum = sum + String.format("%s\n", a1);
                }
                if (totalNumber(getChessboardGraph(), 'Q') != 1) {
                    a2.append("Q ");
                    a2.append(1 - totalNumber(getChessboardGraph(), 'Q'));
                    sum = sum + String.format("%s\n", a2);
                }
                if (totalNumber(getChessboardGraph(), 'R') != 2) {
                    a3.append("R ");
                    a3.append(2 - totalNumber(getChessboardGraph(), 'R'));
                    sum = sum + String.format("%s\n", a3);
                }
                if (totalNumber(getChessboardGraph(), 'B') != 2) {
                    a4.append("B ");
                    a4.append(2 - totalNumber(getChessboardGraph(), 'B'));
                    sum = sum + String.format("%s\n", a4);
                }
                if (totalNumber(getChessboardGraph(), 'N') != 2) {
                    a5.append("N ");
                    a5.append(2 - totalNumber(getChessboardGraph(), 'N'));
                    sum = sum + String.format("%s\n", a5);
                }
                if (totalNumber(getChessboardGraph(), 'P') != 8) {
                    a6.append("P ");
                    a6.append(8 - totalNumber(getChessboardGraph(), 'P'));
                    sum = sum + String.format("%s\n", a6);
                }
            }
            case WHITE -> {
                if (totalNumber(getChessboardGraph(), 'k') != 1) {
                    a1.append("k ");
                    a1.append(1 - totalNumber(getChessboardGraph(), 'k'));
                    sum = sum + String.format("%s\n", a1);
                }
                if (totalNumber(getChessboardGraph(), 'q') != 1) {
                    a2.append("q ");
                    a2.append(1 - totalNumber(getChessboardGraph(), 'q'));
                    sum = sum + String.format("%s\n", a2);
                }
                if (totalNumber(getChessboardGraph(), 'r') != 2) {
                    a3.append("r ");
                    a3.append(2 - totalNumber(getChessboardGraph(), 'r'));
                    sum = sum + String.format("%s\n", a3);
                }
                if (totalNumber(getChessboardGraph(), 'b') != 2) {
                    a4.append("b ");
                    a4.append(2 - totalNumber(getChessboardGraph(), 'b'));
                    sum = sum + String.format("%s\n", a4);
                }
                if (totalNumber(getChessboardGraph(), 'n') != 2) {
                    a5.append("n ");
                    a5.append(2 - totalNumber(getChessboardGraph(), 'n'));
                    sum = sum + String.format("%s\n", a5);
                }
                if (totalNumber(getChessboardGraph(), 'p') != 8) {
                    a6.append("p ");
                    a6.append(8 - totalNumber(getChessboardGraph(), 'p'));
                    sum = sum + String.format("%s\n", a6);
                }
            }
        }
        return sum;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoint1 = new ArrayList<>();
        ChessComponent chess = getChess(source.getX(), source.getY());
        List<ChessboardPoint> steps = chess.canMoveTo();

        int[][] arr= new int[steps.size()][2];
        for(int i = 0 ;i < steps.size();i++){
            for(int j = 0;j < 2;j++){
                if(j == 0){
                    arr[i][0] = steps.get(i).getX();
                }else{
                    arr[i][1] = steps.get(i).getY();
                }
            }
        }
        Arrays.sort(arr, (e1, e2) -> {
            if (e1[0]==e2[0]) return e1[1]-e2[1];
            return e1[0]-e2[0];
        });
        for(int i = 0 ;i < steps.size();i++){
            canMovePoint1.add(new ChessboardPoint(arr[i][0],arr[i][1]));
        }
        // steps.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return canMovePoint1;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
 
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess = getChess(sourceX, sourceY);
        if(chess.getChessColor() != getCurrentPlayer()){
            return false;
        }if(chess.name == '_'){
            return false;
        } boolean flag = false;
        ChessComponent component = chessComponents[sourceX][sourceY];
//            int a = component.canMoveTo().indexOf(new ChessboardPoint(targetX, targetY));
//            if (component.canMoveTo().indexOf(new ChessboardPoint(targetX, targetY)) != -1) {//include target
            boolean a =  Contain(component.canMoveTo(),new ChessboardPoint(targetX,targetY));
            if(Contain(component.canMoveTo(),new ChessboardPoint(targetX,targetY))){ 
                flag = true;
                 ChessboardPoint newPos = new ChessboardPoint(targetX, targetY);
                chess.setSource(newPos);
                chessComponents[targetX][targetY] = chess;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',new ChessboardPoint(sourceX,sourceY), ChessColor.NONE);
                exchangeColor(getCurrentPlayer());
            }
       
        
        return flag;
    }
    public void exchangeColor(ChessColor color){
       if(getCurrentPlayer() == ChessColor.WHITE){
                    setCurrentPlayer(ChessColor.BLACK);
                }else{
                    setCurrentPlayer(ChessColor.WHITE);
                }
    }
    public ChessComponent[][] exchangeChessComponents(int x1, int y1, int x2, int y2) {
                if (Objects.equals(chessComponents[x1][y1].toString(), "K") || Objects.equals(chessComponents[x2][y2].toString(), "k")) {
            chessComponents[x2][y2] = new KingChessComponent(chessComponents[x1][y1].name,new ChessboardPoint(x2, y2), chessComponents[x2][y2].getChessColor());
        }
        if (Objects.equals(chessComponents[x1][y1].toString(), "Q") || Objects.equals(chessComponents[x2][y2].toString(), "q")) {
            chessComponents[x2][y2] = new QueenChessComponent(chessComponents[x1][y1].name,new ChessboardPoint(x2, y2), chessComponents[x2][y2].getChessColor());
        }
        if (Objects.equals(chessComponents[x1][y1].toString(), "N") || Objects.equals(chessComponents[x2][y2].toString(), "n")) {
            chessComponents[x2][y2] = new KnightChessComponent(chessComponents[x1][y1].name,new ChessboardPoint(x2, y2), chessComponents[x2][y2].getChessColor());
        }
        if (Objects.equals(chessComponents[x1][y1].toString(), "B") || Objects.equals(chessComponents[x2][y2].toString(), "b")) {
            chessComponents[x2][y2] = new BishopChessComponent(chessComponents[x1][y1].name,new ChessboardPoint(x2, y2), chessComponents[x2][y2].getChessColor());
        }
        if (Objects.equals(chessComponents[x1][y1].toString(), "R") || Objects.equals(chessComponents[x2][y2].toString(), "r")) {
            chessComponents[x2][y2] = new RookChessComponent(chessComponents[x1][y1].name,new ChessboardPoint(x2, y2), chessComponents[x2][y2].getChessColor());
        }
        if (Objects.equals(chessComponents[x1][y1].toString(), "P") || Objects.equals(chessComponents[x2][y2].toString(), "p")) {
            chessComponents[x2][y2] = new PawnChessComponent(chessComponents[x1][y1].name,new ChessboardPoint(x2, y2), chessComponents[x2][y2].getChessColor());
        }
        if (Objects.equals(chessComponents[x1][y1].toString(), "_")) {
            chessComponents[x2][y2] = new EmptySlotComponent(chessComponents[x1][y1].name,new ChessboardPoint(x2, y2), chessComponents[x2][y2].getChessColor());
        }chessComponents[x1][y1] =  new EmptySlotComponent('_', new ChessboardPoint(x1, y1), ChessColor.NONE);
        return chessComponents;
    }
    public boolean Contain(List<ChessboardPoint> arr1,ChessboardPoint source1){
        boolean result = false;
        for(int i = 0;i < arr1.size();i++){
          if(equal(arr1.get(i),source1)){
              result = true;
              break;
          }
        }return result;
    }

}

