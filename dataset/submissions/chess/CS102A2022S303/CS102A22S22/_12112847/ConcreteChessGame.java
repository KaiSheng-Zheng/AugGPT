import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        BishopChessComponent.Bremain=0;
        BishopChessComponent.Wremain=0;
        KingChessComponent.Bremain=0;
        KingChessComponent.Wremain=0;
        KnightChessComponent.Bremain=0;
        KnightChessComponent.Wremain=0;
        PawnChessComponent.Bremain=0;
        PawnChessComponent.Wremain=0;
        QueenChessComponent.Bremain=0;
        QueenChessComponent.Wremain=0;
        RookChessComponent.Bremain=0;
        RookChessComponent.Wremain=0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j]=new BishopChessComponent('B', this, new ChessboardPoint(i, j));
                    BishopChessComponent.Bremain++;
                }else if(chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j]=new BishopChessComponent('b', this, new ChessboardPoint(i, j));
                    BishopChessComponent.Wremain++;
                }
                if(chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j]=new KingChessComponent('K', this, new ChessboardPoint(i, j));
                    KingChessComponent.Bremain++;
                }else if(chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j]=new KingChessComponent('k', this, new ChessboardPoint(i, j));
                    KingChessComponent.Wremain++;
                }
                if(chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j]=new KnightChessComponent('N', this, new ChessboardPoint(i, j));
                    KnightChessComponent.Bremain++;
                }else if(chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j]=new KnightChessComponent('n', this, new ChessboardPoint(i, j));
                    KnightChessComponent.Wremain++;
                }
                if(chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j]=new PawnChessComponent('P', this, new ChessboardPoint(i, j));
                    PawnChessComponent.Bremain++;
                }else if(chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j]=new PawnChessComponent('p', this, new ChessboardPoint(i, j));
                     PawnChessComponent.Wremain++;
                }
                if(chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j]=new QueenChessComponent('Q', this, new ChessboardPoint(i, j));
                    QueenChessComponent.Bremain++;
                }else if(chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j]=new QueenChessComponent('q', this, new ChessboardPoint(i, j));
                    QueenChessComponent.Wremain++;
                }
                if(chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j]=new RookChessComponent ('R', this, new ChessboardPoint(i, j));
                    RookChessComponent.Bremain++;
                }else if(chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j]=new RookChessComponent ('r', this, new ChessboardPoint(i, j));
                    RookChessComponent.Wremain++;
                }
                if(chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j]=new EmptySlotComponent ('_', this, new ChessboardPoint(i, j));
                }
            }
        }
        currentPlayer=chessboard.get(8).charAt(0)=='w'?ChessColor.WHITE:ChessColor.BLACK;
    }


    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder s=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                s.append(chessComponents[i][j].name);
            }
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder s=new StringBuilder();
        if(player==ChessColor.BLACK){
            if(KingChessComponent.Bremain!=1){s.append("K 1\n");}
            if(QueenChessComponent.Bremain!=1){s.append("Q 1\n");}
            if(RookChessComponent.Bremain!=2){s.append(String.format("R %d\n",RookChessComponent.date-RookChessComponent.Bremain));}
            if(BishopChessComponent.Bremain!=2){s.append(String.format("B %d\n",BishopChessComponent.date-BishopChessComponent.Bremain));}
            if(KnightChessComponent.Bremain!=2){s.append(String.format("N %d\n",KnightChessComponent.date-KnightChessComponent.Bremain));}
            if(PawnChessComponent.Bremain!=8){s.append(String.format("P %d\n",PawnChessComponent.date-PawnChessComponent.Bremain));}
            return s.toString();
        }else{
            if(KingChessComponent.Wremain!=1){s.append("k 1\n");}
            if(QueenChessComponent.Wremain!=1){s.append("q 1\n");}
            if(RookChessComponent.Wremain!=2){s.append(String.format("r %d\n",RookChessComponent.date-RookChessComponent.Wremain));}
            if(BishopChessComponent.Wremain!=2){s.append(String.format("b %d\n",BishopChessComponent.date-BishopChessComponent.Wremain));}
            if(KnightChessComponent.Wremain!=2){s.append(String.format("n %d\n",KnightChessComponent.date-KnightChessComponent.Wremain));}
            if(PawnChessComponent.Wremain!=8){s.append(String.format("p %d\n",PawnChessComponent.date-PawnChessComponent.Wremain));}
            return s.toString();
        }
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
//        if(chessComponents[source.getX()][source.getY()].name=='K') {
//            return  new KingChessComponent('K').re;
//        }
//        if(chessComponents[source.getX()][source.getY()].name=='k') {
//            return  new KingChessComponent('k').re;
//        }
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }



    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(chessComponents[sourceX][sourceY].name=='K'&&
                this.getChessComponents()[targetX][targetY].getChessColor() != currentPlayer&&
                this.getChessComponents()[sourceX][sourceY].getChessColor() == currentPlayer) {
            boolean r=KingChessComponent.can(sourceX, sourceY, targetX, targetY);
            if(r){
                if(currentPlayer==ChessColor.BLACK){
                    currentPlayer=ChessColor.WHITE;
                } else{
                    currentPlayer=ChessColor.BLACK;
                }
            }
            return r;
        }
        if(chessComponents[sourceX][sourceY].name=='k'&&
                this.getChessComponents()[targetX][targetY].getChessColor() != currentPlayer&&
                this.getChessComponents()[sourceX][sourceY].getChessColor() == currentPlayer) {
            boolean r=KingChessComponent.can(sourceX, sourceY, targetX, targetY);
            if(r){
                if(currentPlayer==ChessColor.BLACK){
                    currentPlayer=ChessColor.WHITE;
                } else{
                    currentPlayer=ChessColor.BLACK;
                }
            }
            return r;
        }
        if(chessComponents[sourceX][sourceY].name=='N'&&
                this.getChessComponents()[targetX][targetY].getChessColor() != currentPlayer
        && KnightChessComponent.can(sourceX, sourceY, targetX, targetY)&&
                this.getChessComponents()[sourceX][sourceY].getChessColor() == currentPlayer) {
            //boolean r=;
//            if(r){
                if(currentPlayer==ChessColor.BLACK){
                    currentPlayer=ChessColor.WHITE;
                } else{
                    currentPlayer=ChessColor.BLACK;
//                }
            }
            return true;
        }
        if(chessComponents[sourceX][sourceY].name=='n'&&
                this.getChessComponents()[targetX][targetY].getChessColor() != currentPlayer
        &&KnightChessComponent.can(sourceX, sourceY, targetX, targetY)&&
                this.getChessComponents()[sourceX][sourceY].getChessColor() == currentPlayer) {
            //boolean r=;
            //if(r){
                if(currentPlayer==ChessColor.BLACK){
                    currentPlayer=ChessColor.WHITE;
                } else{
                    currentPlayer=ChessColor.BLACK;
                }
            //}
            return true;
        }
        return false;
    }
}
