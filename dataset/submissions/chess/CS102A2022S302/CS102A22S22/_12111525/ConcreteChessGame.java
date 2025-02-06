import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;
    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    chessComponents[i][j].name='r';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    chessComponents[i][j].name='q';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    chessComponents[i][j].name='k';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    chessComponents[i][j].name='n';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    chessComponents[i][j].name='b';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                    chessComponents[i][j].name='p';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    chessComponents[i][j].name='R';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    chessComponents[i][j].name='Q';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    chessComponents[i][j].name='P';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    chessComponents[i][j].name='N';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    chessComponents[i][j].name='K';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                    chessComponents[i][j].name='B';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if (chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE);
                    chessComponents[i][j].name='_';
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
            }
        }
        if (chessboard.get(8).equals("w")){
            this.currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).equals("b")){
            this.currentPlayer = ChessColor.BLACK;
        }

    };

    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }
    public String getChessboardGraph() {
        String a = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i != 7) && (j == 7)) {
                    a += chessComponents[i][j].name + "\n";
                } else {
                    a += chessComponents[i][j].name;
                }
            }
        }
        return a;
    }
    public String getCapturedChess(ChessColor player){
        String str = "";
        if (player == ChessColor.BLACK){
            int king = 0;
            int queen = 0;
            int rooks = 0;
            int bishops = 0;
            int knights = 0;
            int pawns = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K'){
                        king++;
                    }
                    if (chessComponents[i][j].name == 'Q'){
                        queen++;
                    }
                    if (chessComponents[i][j].name == 'R'){
                        rooks++;
                    }
                    if (chessComponents[i][j].name == 'B'){
                        bishops++;
                    }
                    if (chessComponents[i][j].name == 'N'){
                        knights++;
                    }
                    if (chessComponents[i][j].name == 'P'){
                        pawns++;
                    }
                }
            }
            if (1-king>0){
                str += "K "+(1-king)+"\n";
            }
            if (1-queen>0){
                str += "Q "+(1-queen)+"\n";
            }
            if (2-rooks>0){
                str += "R "+(2-rooks)+"\n";
            }
            if (2-bishops>0){
                str += "B "+(2-bishops)+"\n";
            }
            if (2-knights>0){
                str += "N "+(2-knights)+"\n";
            }
            if (8-pawns>0){
                str += "P "+(8-pawns)+"\n";
            }
        }
        if (player == ChessColor.WHITE){
            int king1 = 0;
            int queen1 = 0;
            int rooks1 = 0;
            int bishops1 = 0;
            int knights1 = 0;
            int pawns1 = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k'){
                        king1++;
                    }
                    if (chessComponents[i][j].name == 'q'){
                        queen1++;
                    }
                    if (chessComponents[i][j].name == 'r'){
                        rooks1++;
                    }
                    if (chessComponents[i][j].name == 'b'){
                        bishops1++;
                    }
                    if (chessComponents[i][j].name == 'n'){
                        knights1++;
                    }
                    if (chessComponents[i][j].name == 'p'){
                        pawns1++;
                    }
                }
            }
            if (1-king1>0){
                str += "k "+(1-king1)+"\n";
            }
            if (1-queen1>0){
                str += "q "+(1-queen1)+"\n";
            }
            if (2-rooks1>0){
                str += "r "+(2-rooks1)+"\n";
            }
            if (2-bishops1>0){
                str += "b "+(2-bishops1)+"\n";
            }
            if (2-knights1>0){
                str += "n "+(2-knights1)+"\n";
            }
            if (8-pawns1>0){
                str += "p "+(8-pawns1)+"\n";
            }
        }
        return str;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];

    }


}
