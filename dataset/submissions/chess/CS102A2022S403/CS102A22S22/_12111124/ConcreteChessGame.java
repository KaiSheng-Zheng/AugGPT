import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
//        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
        chessComponents = new ChessComponent[8][8];
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                chessComponents[i][j] = new ChessComponent() {
                    @Override
                    public List<ChessboardPoint> canMoveTo() {
                        return null;
                    }
                };
            }
        }
    }

    public void loadChessGame(List<String> chessboard) {
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                if(chessboard.get(i).charAt(j) == 'K' | chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent();
                }
                else if (chessboard.get(i).charAt(j) == 'Q' | chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent();
                }
                else if(chessboard.get(i).charAt(j) == 'P' | chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent();
                }
                else if(chessboard.get(i).charAt(j) == 'N' | chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent();
                }
                else if(chessboard.get(i).charAt(j) == 'B' | chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent();
                }
                else if(chessboard.get(i).charAt(j) == 'R' | chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent();
                }
                else if(chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j] = new EmptySlotComponent();
                }

                chessComponents[i][j].setChessComponents(chessComponents);

                chessComponents[i][j].setSource(i,j);
                chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                if(chessboard.get(i).charAt(j) <='Z' &&chessboard.get(i).charAt(j) >='A'){
                chessComponents[i][j].setChessColor(ChessColor.BLACK);}
                else if (chessboard.get(i).charAt(j) <='z' &&chessboard.get(i).charAt(j) >='a'){
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);}
                else chessComponents[i][j].setChessColor(ChessColor.NONE);
            }
        }
        if(chessboard.get(8).charAt(0) == 'b'){
            this.currentPlayer = ChessColor.BLACK;
        }
        else this.currentPlayer = ChessColor.WHITE;
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    public String getChessboardGraph(){
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                str.append(chessComponents[i][j].getName());
            }
            if(i != 7)
                str.append("\n");
        }
        return str.toString();
    }

    public String getCapturedChess(ChessColor player){
        StringBuilder str = new StringBuilder();
        int countK = 0;
        int countQ = 0;
        int countR = 0;
        int countB = 0;
        int countN = 0;
        int countP = 0;
        for(int i = 0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j].getChessColor() == player){
                    if(chessComponents[i][j].getName() == 'K' |chessComponents[i][j].getName() == 'k'){
                        countK++;
                    }
                    else if(chessComponents[i][j].getName() == 'Q' |chessComponents[i][j].getName() == 'q'){
                        countQ++;
                    }
                    else if(chessComponents[i][j].getName() == 'R' |chessComponents[i][j].getName() == 'r'){
                        countR++;
                    }
                    else if(chessComponents[i][j].getName() == 'B' |chessComponents[i][j].getName() == 'b'){
                        countB++;
                    }
                    else if(chessComponents[i][j].getName() == 'N' |chessComponents[i][j].getName() == 'n'){
                        countN++;
                    }
                    else if(chessComponents[i][j].getName() == 'P' |chessComponents[i][j].getName() == 'p'){
                        countP++;
                    }
                }
            }
        }
        if(player == ChessColor.BLACK){
            if(countK == 0){
                str.append("K 1\n");
            }
            if(countQ == 0){
                str.append("Q 1\n");
            }
            if(countR != 2){
                str.append("R ");
                str.append(2-countR);
                str.append("\n");
            }
            if(countB != 2){
                str.append("B ");
                str.append(2-countB);
                str.append("\n");
            }
            if(countN != 2){
                str.append("N ");
                str.append(2-countN);
                str.append("\n");
            }
            if(countP != 8){
                str.append("P ");
                str.append(8-countP);
                str.append("\n");
            }
        }
        else if(player == ChessColor.WHITE){
            if(countK == 0){
                str.append("k 1\n");
            }
            if(countQ == 0){
                str.append("q 1\n");
            }
            if(countR != 2){
                str.append("r ");
                str.append(2-countR);
                str.append("\n");
            }
            if(countB != 2){
                str.append("b ");
                str.append(2-countB);
                str.append("\n");
            }
            if(countN != 2){
                str.append("n ");
                str.append(2-countN);
                str.append("\n");
            }
            if(countP != 8){
                str.append("p ");
                str.append(8-countP);
                str.append("\n");
            }
        }
        else return null;
        if(str.length() != 0){
        return str.toString();}
        else return "";
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        int n = canMovePoints.size();
        for(int i = 0;i<n-1;i++){
            for(int j = 0;j<n-1;j++){
                if(canMovePoints.get(j).getX() > canMovePoints.get(j+1).getX()){
                    ChessboardPoint a = canMovePoints.get(j);
                    canMovePoints.set(j,canMovePoints.get(j+1));
                    canMovePoints.set(j+1,a);
                }
                if(canMovePoints.get(j).getX() == canMovePoints.get(j+1).getX() && canMovePoints.get(j).getY() > canMovePoints.get(j+1).getY()){
                    ChessboardPoint a = canMovePoints.get(j);
                    canMovePoints.set(j,canMovePoints.get(j+1));
                    canMovePoints.set(j+1,a);
                }
            }
        }
        if(n != 0){
        return canMovePoints;}
        else return new ArrayList<>();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int count = 0;
        if(getChess(sourceX,sourceY).getChessColor() == currentPlayer){
            ChessComponent source;
            source = chessComponents[sourceX][sourceY];
            source.setSource(sourceX,sourceY);
            source.setChessComponents(chessComponents);
            source.setName(source.getName());
            if(chessComponents[sourceX][sourceY].getName() <='Z' && chessComponents[sourceX][sourceY].getName() >='A'){
                source.setChessColor(ChessColor.BLACK);
            }
            else if(chessComponents[sourceX][sourceY].getName() <='z' && chessComponents[sourceX][sourceY].getName() >='a'){
                source.setChessColor(ChessColor.WHITE);
            }
            int n = source.canMoveTo().size();
            for(int i = 0;i<n;i++){
                if(source.canMoveTo().get(i).getX() == targetX && source.canMoveTo().get(i).getY() == targetY){
                    count++;
                }
            }
            if(count != 0){
//                source.setSource(targetX,targetY);
                chessComponents[targetX][targetY].setSource(targetX,targetY);
                chessComponents[targetX][targetY].setName(getChess(sourceX,sourceY).getName());
                chessComponents[targetX][targetY].setChessColor(getChess(sourceX,sourceY).getChessColor());
//                chessComponents[targetX][targetY].setChessComponents(source.getChessComponents());
//                chessComponents[targetX][targetY].setChessComponents(chessComponents);
//                chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
//                chessComponents[sourceX][sourceY].setSource(sourceX,sourceY);
//                chessComponents[sourceX][sourceY].setName('_');
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                chessComponents[sourceX][sourceY].setSource(sourceX,sourceY);
                chessComponents[sourceX][sourceY].setName('_');

                if(currentPlayer == ChessColor.WHITE){
                    currentPlayer = ChessColor.BLACK;
                }
                else currentPlayer = ChessColor.WHITE;

                return true;
            }
            else return false;
        }
        else {
            return false;
        }

    }

    public ChessComponent getChess(int x, int y){
       return chessComponents[x][y];
    }


}
