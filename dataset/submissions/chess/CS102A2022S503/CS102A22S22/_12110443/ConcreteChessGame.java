
import java.util.List;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard){
        for(int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                switch(chessboard.get(i).charAt(j)){
                    case 'R':
                        ChessboardPoint chessboardPoint1 = new ChessboardPoint(i,j);
                        ChessComponent chessComponent1 =new RookChessComponent(chessboardPoint1,ChessColor.BLACK);
                        chessComponents[i][j]= chessComponent1;
                        break;
                    case 'N':
                        ChessboardPoint chessboardPoint2 = new ChessboardPoint(i,j);
                        ChessComponent chessComponent2 =new KnightChessComponent(chessboardPoint2,ChessColor.BLACK);
                        chessComponents[i][j]= chessComponent2;
                        break;
                    case 'B':
                        ChessboardPoint chessboardPoint3 = new ChessboardPoint(i,j);
                        ChessComponent chessComponent3 =new BishopChessComponent(chessboardPoint3,ChessColor.BLACK);
                        chessComponents[i][j]= chessComponent3;
                        break;
                    case 'Q':
                        ChessboardPoint chessboardPoint4 = new ChessboardPoint(i,j);
                        ChessComponent chessComponent4 =new QueenChessComponent(chessboardPoint4,ChessColor.BLACK);
                        chessComponents[i][j]= chessComponent4;
                        break;
                    case 'K':
                        ChessboardPoint chessboardPoint5 = new ChessboardPoint(i,j);
                        ChessComponent chessComponent5 =new KingChessComponent(chessboardPoint5,ChessColor.BLACK);
                        chessComponents[i][j]= chessComponent5;
                        break;
                    case 'r':
                        ChessboardPoint chessboardPoint6 = new ChessboardPoint(i,j);
                        ChessComponent chessComponent6 =new RookChessComponent(chessboardPoint6,ChessColor.WHITE);
                        chessComponents[i][j]= chessComponent6;
                        break;
                    case 'n':
                        ChessboardPoint chessboardPoint7 = new ChessboardPoint(i,j);
                        ChessComponent chessComponent7 =new KnightChessComponent(chessboardPoint7,ChessColor.WHITE);
                        chessComponents[i][j]= chessComponent7;
                        break;
                    case 'b':
                        ChessboardPoint chessboardPoint8 = new ChessboardPoint(i,j);
                        ChessComponent chessComponent8 =new BishopChessComponent(chessboardPoint8,ChessColor.WHITE);
                        chessComponents[i][j]= chessComponent8;
                        break;
                    case 'q':
                        ChessboardPoint chessboardPoint9 = new ChessboardPoint(i,j);
                        ChessComponent chessComponent9 =new QueenChessComponent(chessboardPoint9,ChessColor.WHITE);
                        chessComponents[i][j]= chessComponent9;
                        break;
                    case 'k':
                        ChessboardPoint chessboardPoint10 = new ChessboardPoint(i,j);
                        ChessComponent chessComponent10 =new KingChessComponent(chessboardPoint10,ChessColor.WHITE);
                        chessComponents[i][j]= chessComponent10;
                        break;
                    case 'P':
                        ChessboardPoint chessboardPoint11 = new ChessboardPoint(i,j);
                        ChessComponent chessComponent11 =new PawnChessComponent(chessboardPoint11,ChessColor.BLACK);
                        chessComponents[i][j]= chessComponent11;
                        break;
                    case 'p':
                        ChessboardPoint chessboardPoint12 = new ChessboardPoint(i,j);
                        ChessComponent chessComponent12 =new PawnChessComponent(chessboardPoint12,ChessColor.WHITE);
                        chessComponents[i][j]= chessComponent12;
                        break;
                    case '_':
                        ChessboardPoint chessboardPoint13 = new ChessboardPoint(i,j);
                        ChessComponent chessComponent13 =new EmptyChessComponent(chessboardPoint13);
                        chessComponents[i][j]= chessComponent13;
                        break;
                }

            }
        }
        for (ChessComponent[] item :chessComponents){
            for (ChessComponent item1 :item){
                item1.setChessComponents(chessComponents);
            }
        }
        switch (chessboard.get(8).charAt(0)){
            case 'w':
                setCurrentPlayer(ChessColor.WHITE);
                break;
            case 'b':
                setCurrentPlayer(ChessColor.BLACK);
                break;
            default:
                setCurrentPlayer(ChessColor.NONE);
                break;
        }

    }

    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    public void setCurrentPlayer(ChessColor currentPlayer){
        this.currentPlayer=currentPlayer;
    }
    public String getCapturedChess(ChessColor Player) {
        StringBuilder sc = new StringBuilder();
        if (Player == ChessColor.BLACK) {
            int[] i = eatenChess(chessComponents,Player);
            if (i[0] != 1) {
                sc.append("K " +(1- i[0]) + "\n");
            }
            if (i[1] != 1) {
                sc.append("Q " +(1- i[1]) + "\n");
            }
            if (i[2] != 2) {
                sc.append("R " + (2-i[2]) + "\n");
            }
            if (i[3] != 2) {
                sc.append("B " + (2-i[3]) + "\n");
            }
            if (i[4] != 2) {
                sc.append("N " +(2- i[4] )+ "\n");
            }
            if (i[5] != 8) {
                sc.append("P " + (8-i[5]) + "\n");
            }
        }else if(Player == ChessColor.WHITE){
            int[] j = eatenChess(chessComponents,Player);
            if (j[0] != 1) {
                sc.append("k " +(1-j[0]) + "\n");
            }
            if (j[1] != 1) {
                sc.append("q " +(1-j[1]) + "\n");
            }
            if (j[2] != 2) {
                sc.append("r " + (2-j[2]) + "\n");
            }
            if (j[3] != 2) {
                sc.append("b " + (2-j[3]) + "\n");
            }
            if (j[4] != 2) {
                sc.append("n " + (2-j[4]) + "\n");
            }
            if (j[5] != 8) {
                sc.append("p " + (8-j[5]) + "\n");
            }

        }

        return sc.toString();
    }

    public int[] eatenChess(ChessComponent[][] chessComponents,ChessColor chessColor) {
        int[] b = new int[6];
        int[] w = new int[6];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[i][j].getName()) {
                    case 'K' :
                        b[0]++;
                        break;
                    case 'Q' :
                        b[1]++;
                        break;
                    case 'R' :
                        b[2]++;
                        break;
                    case 'B' :
                        b[3]++;
                        break;
                    case 'N' :
                        b[4]++;
                        break;
                    case 'P' :
                        b[5]++;
                        break;
                    case 'k' :
                        w[0]++;
                        break;
                    case 'q' :
                        w[1]++;
                        break;
                    case 'r' :
                        w[2]++;
                        break;
                    case 'b' :
                        w[3]++;
                        break;
                    case 'n' :
                        w[4]++;
                        break;
                    case 'p' :
                        w[5]++;
                        break;
                }
            }
        }
        if(chessColor==ChessColor.BLACK){return b;}
        else{return w;}
    }

    public String getChessboardGraph(){
    StringBuilder sc = new StringBuilder();
    for (int i =0;i<8;i++){
        for (int j=0;j<8;j++){
            sc.append(chessComponents[i][j].getName());
        }
        sc.append("\n");
    }
        return sc.toString();
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> canMove=chessComponents[sourceX][sourceY].canMoveTo();
        boolean b1 =chessComponents[sourceX][sourceY].getChessColor()==getCurrentPlayer();
        boolean b2=false;
        for (int i=0;i<canMove.size();i++){
            if (canMove.get(i).getX()==targetX&&canMove.get(i).getY()==targetY){
                b2=true;
                break;
            }
        }
        if (b1&&b2) {
//            chessComponents[sourceX][sourceY].step += 1;
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].source.setX(targetX);
            chessComponents[targetX][targetY].source.setY(targetY);
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));

            saveGame(this.chessComponents);
            if (this.currentPlayer == ChessColor.WHITE) {
                this.currentPlayer = ChessColor.BLACK;
            } else {
                this.currentPlayer = ChessColor.WHITE;
            }
        }
        return b1&&b2;

    }


    public static void saveGame(ChessComponent[][] chessComponents){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                chessComponents[i][j].chessComponents=chessComponents;
            }
        }
    }

    public ChessComponent getChess(int x,int y){
return chessComponents[x][y];
    }
}
