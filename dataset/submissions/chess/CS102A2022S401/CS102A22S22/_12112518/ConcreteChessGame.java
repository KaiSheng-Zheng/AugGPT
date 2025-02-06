import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents ;
    private ChessColor currentPlayer ;

    public ConcreteChessGame(){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (chessboard.get(i).charAt(j) == 'K'){
                    this.chessComponents[i][j] = new KingChessComponent('K', new ChessboardPoint(i, j), ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'Q'){
                    this.chessComponents[i][j] = new QueenChessComponent('Q', new ChessboardPoint(i, j), ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'R'){
                    this.chessComponents[i][j] = new RookChessComponent('R', new ChessboardPoint(i, j), ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'B'){
                    this.chessComponents[i][j] = new BishopChessComponent('B', new ChessboardPoint(i, j), ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'N'){
                    this.chessComponents[i][j] = new KnightChessComponent('N', new ChessboardPoint(i, j), ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'P'){
                    this.chessComponents[i][j] = new PawnChessComponent('P', new ChessboardPoint(i, j), ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) == 'k'){
                    this.chessComponents[i][j] = new KingChessComponent('k', new ChessboardPoint(i, j), ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'q'){
                    this.chessComponents[i][j] = new QueenChessComponent('q', new ChessboardPoint(i, j), ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'r'){
                    this.chessComponents[i][j] = new RookChessComponent('r', new ChessboardPoint(i, j), ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'b'){
                    this.chessComponents[i][j] = new BishopChessComponent('b', new ChessboardPoint(i, j), ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'n'){
                    this.chessComponents[i][j] = new KnightChessComponent('n', new ChessboardPoint(i, j), ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == 'p'){
                    this.chessComponents[i][j] = new PawnChessComponent('p', new ChessboardPoint(i, j), ChessColor.WHITE);
                }
                if (chessboard.get(i).charAt(j) == '_'){
                    this.chessComponents[i][j] = new EmptySlotComponent('_', new ChessboardPoint(i, j), ChessColor.NONE);
                }
            }

        }
        if (chessboard.get(8).equals("w")){
            this.currentPlayer = ChessColor.WHITE;
        }else {
            this.currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                this.chessComponents[i][j].setChessboard(this.chessComponents);
            }
        }

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                a.append(chessComponents[i][j].name);
            }
        if (i < 7){
            a.append("\n");
            }
        }
        return a.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int wkc = 0;
        int wqc = 0;
        int wrc = 0;
        int wbc = 0;
        int wnc = 0;
        int wpc = 0;
        int bkc = 0;
        int bqc = 0;
        int brc = 0;
        int bbc = 0;
        int bnc = 0;
        int bpc = 0;
        if (player == ChessColor.BLACK){
            StringBuilder a = new StringBuilder();
            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
                    if (this.chessComponents[i][j].name == 'K'){
                        bkc++;
                    }else if (this.chessComponents[i][j].name == 'Q'){
                        bqc++;
                    }else if (this.chessComponents[i][j].name == 'R'){
                        brc++;
                    }else if (this.chessComponents[i][j].name == 'B'){
                        bbc++;
                    }else if (this.chessComponents[i][j].name == 'N'){
                        bnc++;
                    }else if (this.chessComponents[i][j].name == 'P'){
                        bpc++;
                    }
                }
            }
            if (bkc == 0){
                a.append("K " + 1 + "\n");
            }if (bqc == 0){
                a.append("Q " + 1 + "\n");
            }if (brc != 2){
                a.append("R " + (2 - brc) + "\n");
            }if (bbc != 2){
                a.append("B " + (2 - bbc) + "\n");
            }if (bnc != 2){
                a.append("N " + (2 - bnc) + "\n");
            }if (bpc != 8){
                a.append("P " + (8 - bpc) + "\n");
            }
            return a.toString();
        }else {
            StringBuilder a = new StringBuilder();
            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
                    if (this.chessComponents[i][j].name == 'k'){
                        wkc++;
                    }else if (this.chessComponents[i][j].name == 'q'){
                        wqc++;
                    }else if (this.chessComponents[i][j].name == 'r'){
                        wrc++;
                    }else if (this.chessComponents[i][j].name == 'b'){
                        wbc++;
                    }else if (this.chessComponents[i][j].name == 'n'){
                        wnc++;
                    }else if (this.chessComponents[i][j].name == 'p'){
                        wpc++;
                    }
                }
            }
            if (wkc != 1){
                a.append("k " + 1 + "\n");
            }if (wqc != 1){
                a.append("q " + 1 + "\n");
            }if (wrc != 2){
                a.append("r " + (2 - wrc) + "\n");
            }if (wbc != 2){
                a.append("b " + (2 - wbc) + "\n");
            }if (wnc != 2){
                a.append("n " + (2 - wnc) + "\n");
            }if (wpc != 8){
                a.append("p " + (8 - wpc) + "\n");
            }
            return a.toString();
        }

    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        // 1. find chess according to source
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        List<ChessboardPoint> b = new ArrayList<>();
        for (int i = 0; i <= 7 ; i++) {
            for (int j = 0; j <= 7; j++) {
                ChessboardPoint a = new ChessboardPoint(i, j);
                if (canMovePoints.contains(a)){
                    b.add(a);
                }
            }
        }
        return b;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX < 0 || sourceX > 7 || sourceY < 0 || sourceY > 7 || targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7){
            return false;
        }
        if (this.chessComponents[sourceX][sourceY].getChessColor() == this.currentPlayer &&
                this.chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY))){
            this.chessComponents[targetX][targetY] = this.chessComponents[sourceX][sourceY];
            this.chessComponents[sourceX][sourceY] = new EmptySlotComponent('_', new ChessboardPoint(sourceX, sourceY), ChessColor.NONE);
            this.chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
            this.chessComponents[targetX][targetY].setChessboard(this.chessComponents);
            this.chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
            this.changePlayer();
            return true;
        }else {
            return false;
        }
    }
    public void changePlayer(){
        if (this.currentPlayer == ChessColor.BLACK){
            this.currentPlayer = ChessColor.WHITE;
        }else {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

}