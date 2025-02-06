import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private List<String> chessboard;
    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
//        this.chessComponents = chessComponents;
//        if(currentPlayer != null) {
//            this.currentPlayer = currentPlayer;
//        }else{
//            this.currentPlayer = ChessColor.WHITE;
//        }
    }
    @Override
    public void loadChessGame(List<String> chessboard){
        this.chessboard = new ArrayList<String>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char component = chessboard.get(i).charAt(j);
                switch (component){
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessComponents);
                        break;
                    case 'N' :
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessComponents);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessComponents);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessComponents);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessComponents);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,chessComponents);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessComponents);
                        break;
                    case 'n' :
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessComponents);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessComponents);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessComponents);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessComponents);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,chessComponents);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,chessComponents);
                        break;
                }
            }

        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].updateBoard(chessComponents);
            }
        }
        for (int i = 0; i < 9; i++) {
            this.chessboard.add(i,chessboard.get(i));
        }
        if(chessboard.get(8).equals("b")){
            currentPlayer = ChessColor.BLACK;
        }
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                chessComponents[j][k].updateBoard(chessComponents);
            }
        }
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                buffer.append(chessComponents[i][j].getName());
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        if(String.valueOf(source.getX()).length()==0||String.valueOf(source.getY()).length()==0){
            return new ArrayList<>();
        }
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
//        if(currentPlayer!=chess.getChessColor()){
//            return new ArrayList<>();
//        }
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        if(canMovePoints.size()==0){
            return canMovePoints;
        }
        ChessboardPoint[] canMove = new ChessboardPoint[canMovePoints.size()];
        canMove[0] = new ChessboardPoint(0,0);
        canMove[0].setX(canMovePoints.get(0).getX());
        canMove[0].setY(canMovePoints.get(0).getY());
        for (int i = 1; i < canMovePoints.size(); i++) {
            if(canMove[0].getX()<canMovePoints.get(i).getX()){
                canMove[0].setX(canMovePoints.get(i).getX());
                canMove[0].setY(canMovePoints.get(i).getY());
            }
            if(canMove[0].getX()<=canMovePoints.get(i).getX()&&canMove[0].getY()<canMovePoints.get(i).getY()){
                canMove[0].setY(canMovePoints.get(i).getY());
//                canMovePoints.set(0,canMovePoints.get(i));
            }
        }
        for (int i = 1; i < canMovePoints.size(); i++) {
            canMove[i] = new ChessboardPoint(0,0);
        }
        ChessboardPoint[] canMovePoint2 = new ChessboardPoint[canMovePoints.size()];
        for (int i = 0; i < canMovePoints.size(); i++) {
            canMovePoint2[i] = new ChessboardPoint(0,0);
        }
        for (int i = 1; i < canMovePoints.size(); i++) {
            canMove[i].setX(canMove[0].getX());
            canMove[i].setY(canMove[0].getY());
            canMovePoint2[i].setX(canMovePoints.get(i).getX());
            canMovePoint2[i].setY(canMovePoints.get(i).getY());
            canMovePoint2[0].setX(canMovePoints.get(0).getX());
            canMovePoint2[0].setY(canMovePoints.get(0).getY());
        }
        for (int i = 0; i < canMovePoints.size(); i++) {
            for (int j = 0; j < canMovePoints.size(); j++) {
                if(canMove[i].getX()>canMovePoint2[j].getX()){
                    canMove[i].setX(canMovePoints.get(j).getX());
                    canMove[i].setY(canMovePoints.get(j).getY());
                }
            }
            for (int j = 0; j < canMovePoints.size(); j++) {
                if(canMove[i].getX()==canMovePoint2[j].getX()&&canMove[i].getY()>canMovePoint2[j].getY()){
                    canMove[i].setY(canMovePoints.get(j).getY());
                }
            }
            for (int j = 0; j < canMovePoints.size(); j++) {
                if(canMove[i].getX() == canMovePoint2[j].getX()&&canMove[i].getY() == canMovePoint2[j].getY()){
                    canMovePoint2[j].setX(9);
                    canMovePoint2[j].setY(9);
                    break;
                }
            }

        }
//        for (int i = 0; i < canMovePoints.size(); i++) {
//            for (int j = 0; j < canMovePoints.size(); j++) {
//                if(canMove[i].getY()>canMovePoints.get(j).getY()){
//                    canMove[i] = canMovePoints.get(j);
//                    canMovePoints.get(j).setY(9);
//                }
//            }
//        }
        for (int i = 0; i < canMovePoints.size(); i++) {
            canMovePoints.set(i,canMove[i]);
        }
        return canMovePoints;
    }
//    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
//        return chessComponents[source.getX()][source.getY()].canMoveTo();
//    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(String.valueOf(sourceX).length()==0||String.valueOf(sourceY).length()==0){
            return false;
        }
        if(sourceX < 0 || sourceX > 7 || sourceY < 0 || sourceY > 7 ){
            return false;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].updateBoard(chessComponents);
            }
        }
        List<ChessboardPoint> canMoveTo = chessComponents[sourceX][sourceY].canMoveTo();
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        for (int i = 0; i < canMoveTo.size(); i++) {
            if(target.toString().equals(canMoveTo.get(i).toString())&&chessComponents[sourceX][sourceY].getChessColor()==currentPlayer){
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,getChessComponents());
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 8; k++) {
                        chessComponents[j][k].updateBoard(chessComponents);
                    }
                }
                if(currentPlayer == ChessColor.WHITE){
                    currentPlayer = ChessColor.BLACK;
                }else {
                    currentPlayer = ChessColor.WHITE;
                }
                return true;
            }
        }
        return false;
    }
    public String getCapturedChess(ChessColor player){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].updateBoard(chessComponents);
            }

        }
        if(player == ChessColor.BLACK){
//            int King = 1;
//            int Queen = 1;
//            int Bishop = 2;
//            int Knight = 2;
//            int Rook = 2;
//            int Pawn = 8;
            int[] number = new int[]{1,1,2,2,2,8};
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].getName()){
                        case 'K':
                            number[0]--;
                            break;
                        case 'Q':
                            number[1]--;
                            break;
                        case 'R':
                            number[2]--;
                            break;
                        case 'B':
                            number[3]--;
                            break;
                        case 'N' :
                            number[4]--;
                            break;
                        case 'P' :
                            number[5]--;
                            break;
                    }
                }
            }
            StringBuilder buffer = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                if(number[i] != 0){
                    switch (i){
                        case 0:
                            buffer.append("K ");
                            buffer.append(number[i]);
                            buffer.append("\n");
                            break;
                        case 1:
                            buffer.append("Q ");
                            buffer.append(number[i]);
                            buffer.append("\n");
                            break;
                        case 2:
                            buffer.append("R ");
                            buffer.append(number[i]);
                            buffer.append("\n");
                            break;
                        case 3:
                            buffer.append("B ");
                            buffer.append(number[i]);
                            buffer.append("\n");
                            break;
                        case 4:
                            buffer.append("N ");
                            buffer.append(number[i]);
                            buffer.append("\n");
                            break;
                        case 5:
                            buffer.append("P ");
                            buffer.append(number[i]);
                            buffer.append("\n");
                            break;
                    }
                }
            }
            return buffer.toString();
        }else {
            int[] number = new int[]{1,1,2,2,2,8};
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].getName()){
                        case 'k':
                            number[0]--;
                            break;
                        case 'q':
                            number[1]--;
                            break;
                        case 'r':
                            number[2]--;
                            break;
                        case 'b':
                            number[3]--;
                            break;
                        case 'n' :
                            number[4]--;
                            break;
                        case 'p' :
                            number[5]--;
                            break;
                    }
                }
            }
            StringBuilder buffer = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                if(number[i] != 0){
                    switch (i){
                        case 0:
                            buffer.append("k ");
                            buffer.append(number[i]);
                            buffer.append("\n");
                            break;
                        case 1:
                            buffer.append("q ");
                            buffer.append(number[i]);
                            buffer.append("\n");
                            break;
                        case 2:
                            buffer.append("r ");
                            buffer.append(number[i]);
                            buffer.append("\n");
                            break;
                        case 3:
                            buffer.append("b ");
                            buffer.append(number[i]);
                            buffer.append("\n");
                            break;
                        case 4:
                            buffer.append("n ");
                            buffer.append(number[i]);
                            buffer.append("\n");
                            break;
                        case 5:
                            buffer.append("p ");
                            buffer.append(number[i]);
                            buffer.append("\n");
                            break;
                    }
                }
            }
            return buffer.toString();
        }
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public void setChessboard(int x,int y,ChessComponent component){
        this.chessComponents[x][y] = component;
    }
    public ChessComponent[][] getChessComponents(){
        return chessComponents;
    }
}
