import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ConcreteChessGame(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame(){this.chessComponents =null;
        this.currentPlayer = ChessColor.WHITE;};

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(),source.getY());
        // 1. find chess according to source
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        for (int i = 0; i < canMovePoints.size() - 1 ; i ++){
            for (int j = i +1; j < canMovePoints.size() ; j++){
                if (canMovePoints.get(i).getX() > canMovePoints.get(j).getX()){
                    Collections.swap(canMovePoints,i,j);
                }
                else {if (canMovePoints.get(i).getX() == canMovePoints.get(j).getX()){
                    if (canMovePoints.get(i).getY() > canMovePoints.get(j).getY()){
                        Collections.swap(canMovePoints,i,j);
                    }
                }}
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (currentPlayer == chessComponents[sourceX][sourceY].getChessColor()){
            for (int i =0; i < getCanMovePoints(chessComponents[sourceX][sourceY].getSource()).size();i++){
                if (targetX == getCanMovePoints(chessComponents[sourceX][sourceY].getSource()).get(i).getX() &&
                        targetY == getCanMovePoints(chessComponents[sourceX][sourceY].getSource()).get(i).getY()){
                    ChessComponent source = getChess(sourceX,sourceY);
                    ChessComponent target = getChess(targetX,targetY);
                    source.setSource(new ChessboardPoint(targetX,targetY));
                    this.chessComponents[targetX][targetY] = source;
                    target = new EmptySlotComponent();
                    target.setSource(new ChessboardPoint(sourceX,sourceY));
                    this.chessComponents[sourceX][sourceY] = target;
                    
                    if (currentPlayer == ChessColor.BLACK) currentPlayer = ChessColor.WHITE;
                    else currentPlayer = ChessColor.BLACK;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer; }

    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(chessboard.size()-1).equals("w")){
            this.currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(chessboard.size()-1).equals("b")){
            this.currentPlayer = ChessColor.BLACK;
        }
        this.chessComponents = new ChessComponent[chessboard.size()-1][chessboard.get(0).length()];
        for (int i = 0; i < chessboard.size()-1; i++){
            for (int j = 0 ; j < chessboard.get(i).length() ; j++){
                if (chessboard.get(i).charAt(j) == 'r') {
                    this.chessComponents[i][j] =
                            new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);}
                if (chessboard.get(i).charAt(j) == 'R') {
                    this.chessComponents[i][j] =
                            new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);}
                if (chessboard.get(i).charAt(j) == 'N'){
                    this.chessComponents[i][j] =
                            new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);}
                if (chessboard.get(i).charAt(j) == 'n'){
                    this.chessComponents[i][j] =
                            new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);}
                if (chessboard.get(i).charAt(j) == 'B'){
                    this.chessComponents[i][j] =
                            new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);}
                if (chessboard.get(i).charAt(j) == 'b'){
                    this.chessComponents[i][j] =
                            new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);}
                if (chessboard.get(i).charAt(j) == 'Q') {
                    this.chessComponents[i][j] =
                            new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);}
                if (chessboard.get(i).charAt(j) == 'q'){
                    this.chessComponents[i][j] =
                            new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);}
                if (chessboard.get(i).charAt(j) == 'K'){
                    this.chessComponents[i][j] =
                            new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);}
                if (chessboard.get(i).charAt(j) == 'k'){
                    this.chessComponents[i][j] =
                            new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);}
                if (chessboard.get(i).charAt(j) == 'P'){
                    this.chessComponents[i][j] =
                            new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);}
                if (chessboard.get(i).charAt(j) == 'p'){
                    this.chessComponents[i][j] =
                            new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);}
                if (chessboard.get(i).charAt(j) == '_'){
                    this.chessComponents[i][j] =
                            new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);}
            }
        }
    }
    public String getChessboardGraph(){
        StringBuilder s = new StringBuilder();
        for (int j = 0 ; j < chessComponents.length; j ++){
            for (int i = 0 ; i < chessComponents[j].length; i++){
                s.append(chessComponents[j][i].toString());
            }
            s.append("\n");
        }
        return s.toString();
    }

    public String getCapturedChess(ChessColor player){
        int king = 0;
        int queen = 0;
        int rooks = 0;
        int bishops = 0;
        int knights = 0;
        int pawns = 0;
        for (int i = 0 ; i < chessComponents.length;i ++){
            for (int j = 0 ; j < chessComponents[i].length; j++) {
                if (chessComponents[i][j].getChessColor() == player){
                    if (chessComponents[i][j].getName() == 'r'||chessComponents[i][j].getName() == 'R'){
                        rooks++;
                    }
                    if (chessComponents[i][j].getName() == 'n'||chessComponents[i][j].getName() == 'N'){
                        knights++;
                    }
                    if (chessComponents[i][j].getName() == 'q'||chessComponents[i][j].getName() == 'Q'){
                        queen++;
                    }
                    if (chessComponents[i][j].getName() == 'k'||chessComponents[i][j].getName() == 'K'){
                        king++;
                    }
                    if (chessComponents[i][j].getName() == 'b'||chessComponents[i][j].getName() == 'B'){
                        bishops++;
                    }
                    if (chessComponents[i][j].getName() == 'p'||chessComponents[i][j].getName() == 'P'){
                        pawns++;
                    }
                }
            }
        }
        int king1 = 1-king;
        int queen1 = 1-queen;
        int rooks1 = 2-rooks;
        int bishops1 = 2-bishops;
        int knights1 = 2-knights;
        int pawns1 = 8-pawns;
        String str = "";
        if (player == ChessColor.BLACK){
            if (king1 > 0) str += "K " + king1 +"\n";
            if (queen1 > 0) str += "Q " + queen1 +"\n";
            if (rooks1 > 0) str += "R " + rooks1 +"\n";
            if (bishops1 > 0) str += "B " + bishops1 +"\n";
            if (knights1 > 0) str += "N " + knights1 +"\n";
            if (pawns1 > 0) str += "P " + pawns1 +"\n";
        }
        if (player == ChessColor.WHITE){
            if (king1 > 0) str += "k " + king1 +"\n";
            if (queen1 > 0) str += "q " + queen1 +"\n";
            if (rooks1 > 0) str += "r " + rooks1 +"\n";
            if (bishops1 > 0) str += "b " + bishops1 +"\n";
            if (knights1 > 0) str += "n " + knights1 +"\n";
            if (pawns1 > 0) str += "p " + pawns1 +"\n";
        }
        return str;
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
}
