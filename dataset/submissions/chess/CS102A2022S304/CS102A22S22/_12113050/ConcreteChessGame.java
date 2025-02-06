import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint N =new ChessboardPoint(i,j);
                switch (chessboard.get(i).charAt(j)){
                    case 'k':
                        KingChessComponent M1 = new KingChessComponent(N,ChessColor.WHITE);
                        chessComponents[i][j]=M1;
                        break;
                    case 'K':
                        KingChessComponent M2 = new KingChessComponent(N,ChessColor.BLACK);
                        chessComponents[i][j]=M2;
                        break;
                    case '_':
                        EmptySlotComponent M3 = new EmptySlotComponent(N,ChessColor.NONE);
                        chessComponents[i][j]=M3;
                        break;
                    case 'N':
                        KnightChessComponent M4 = new KnightChessComponent(N,ChessColor.BLACK);
                        chessComponents[i][j]=M4;
                        break;
                    case 'n' :
                        KnightChessComponent M5 = new KnightChessComponent(N,ChessColor.WHITE);
                        chessComponents[i][j]=M5;
                        break;
                    case 'p':
                        PawnChessComponent M6 = new PawnChessComponent(N,ChessColor.WHITE);
                        chessComponents[i][j]=M6;
                        break;
                    case 'P':
                        PawnChessComponent M7 = new PawnChessComponent(N,ChessColor.BLACK);
                        chessComponents[i][j]=M7;
                        break;
                    case 'q':
                        QueenChessComponent M8 = new QueenChessComponent(N,ChessColor.WHITE);
                        chessComponents[i][j]=M8;
                        break;
                    case 'Q':
                        QueenChessComponent M9 = new QueenChessComponent(N,ChessColor.BLACK);
                        chessComponents[i][j]=M9;
                        break;
                    case 'r':
                        RookChessComponent M10 =new RookChessComponent(N,ChessColor.WHITE);
                        chessComponents[i][j]=M10;
                        break;
                    case 'R':
                        RookChessComponent M11 =new RookChessComponent(N,ChessColor.BLACK);
                        chessComponents[i][j]=M11;
                        break;
                    case 'b':
                        BishopChessComponent M12 = new BishopChessComponent(N,ChessColor.WHITE);
                        chessComponents[i][j]=M12;
                        break;
                    case 'B':
                        BishopChessComponent M13 = new BishopChessComponent(N,ChessColor.BLACK);
                        chessComponents[i][j]=M13;
                        break;
                }
            }
        }
        if (chessboard.get(chessboard.size() - 1).equals("w")){
            setCurrentPlayer(ChessColor.WHITE);
        }else if((chessboard.get(chessboard.size() - 1).equals("b"))){
            setCurrentPlayer(ChessColor.BLACK);
        }else {
            setCurrentPlayer(ChessColor.WHITE);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }

    }


    public int countString(String str,String s) {
        String str1 = str.replaceAll(s, "");
        int len1 = str.length(),len2 = str1.length(),len3 = s.length();
        int count = (len1 - len2) / len3;
        return count;

    }

    @Override

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].name);
            }
            if (i<7){
                sb.append('\n');}
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder capture = new StringBuilder();
        if (player == ChessColor.WHITE) {
            if (countString(getChessboardGraph(), "k") != 1) {
                capture.append("k 1\n");
            }
            if (countString(getChessboardGraph(), "q") != 1) {
                capture.append("q 1\n");
            }
            if (countString(getChessboardGraph(), "r") != 2) {
                capture.append("r ");
                capture.append(2-countString(getChessboardGraph(), "r"));
                capture.append("\n");
            }
            if (countString(getChessboardGraph(), "b") != 2) {
                capture.append("b ");
                capture.append(2-countString(getChessboardGraph(), "b"));
                capture.append("\n");
            }
            if (countString(getChessboardGraph(), "n") != 2) {
                capture.append("n ");
                capture.append(2-countString(getChessboardGraph(), "n"));
                capture.append("\n");
            }
            if (countString(getChessboardGraph(), "p") != 8) {
                capture.append("p ");
                capture.append(8-countString(getChessboardGraph(), "p"));
                capture.append("\n");
            }
        }
        if (player == ChessColor.BLACK) {
            if (countString(getChessboardGraph(), "K") != 1) {
                capture.append("K 1\n");
            }
            if (countString(getChessboardGraph(), "Q") != 1) {
                capture.append("Q 1\n");
            }
            if (countString(getChessboardGraph(), "R") != 2) {
                capture.append("R ");
                capture.append(2-countString(getChessboardGraph(), "R"));
                capture.append("\n");
            }
            if (countString(getChessboardGraph(), "B") != 2) {
                capture.append("B ");
                capture.append(2-countString(getChessboardGraph(), "B"));
                capture.append("\n");
            }
            if (countString(getChessboardGraph(), "N") != 2) {
                capture.append("N ");
                capture.append(2-countString(getChessboardGraph(), "N"));
                capture.append("\n");
            }
            if (countString(getChessboardGraph(), "P") != 8) {
                capture.append("P ");
                capture.append(8-countString(getChessboardGraph(), "P"));
                capture.append("\n");
            }
        }
        return capture.toString();
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x= source.getX();
        int y=source.getY();
        ChessComponent a=chessComponents[x][y];
        ArrayList<ChessboardPoint> n=new ArrayList<>();
        for (int i = 0; i < a.canMoveTo().size(); i++) {
            n.add(a.canMoveTo().get(i));
        }
        for (int i = 0; i < n.size()-1; i++) {
            for (int j = 0; j < n.size()-1-i; j++) {
                if (n.get(j).getX()>n.get(j+1).getX()){
                    ChessboardPoint d = new ChessboardPoint(n.get(j).getX(),n.get(j).getY());
                    n.set(j,n.get(j+1));
                    n.set(j+1,d);
                    continue;
                }
                if (n.get(j).getX()==n.get(j+1).getX()){
                    if (n.get(j).getY()>n.get(j+1).getY()){
                        ChessboardPoint d = new ChessboardPoint(n.get(j).getX(),n.get(j).getY());
                        n.set(j,n.get(j+1));
                        n.set(j+1,d);
                    }
                }
            }
        }
        //List<ChessboardPoint> canMovePoints = a.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        return n;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
//        ChessboardPoint m = new ChessboardPoint(targetX,targetY);
        boolean can=false;
        if (sourceX<0||sourceX>7||targetX<0||targetX>7||sourceY<0||sourceY>7||targetY<0||targetY>7){
            return false;
        }
        if (chessComponents[sourceX][sourceY].canMoveTo().size()==0){
            return false;
        }else {
            List a=chessComponents[sourceX][sourceY].canMoveTo();
            for (int i = 0; i < a.size(); i++) {
                if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==targetX&&chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==targetY&&
                        currentPlayer==chessComponents[sourceX][sourceY].getChessColor()){
                    can=true;
                }
            }
        }

        if (can){
            ChessboardPoint o = new ChessboardPoint(sourceX,sourceY);
            chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY]= new EmptySlotComponent(o,ChessColor.NONE);
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));

//            ChessComponent old=chessComponents[sourceX][sourceY];
//            old.setSource(m);
//            ChessComponent empty=new EmptySlotComponent(o,ChessColor.NONE);
//            chessComponents[sourceX][sourceY]=empty;
//            chessComponents[targetX][targetY]=old;
            if (getCurrentPlayer()== ChessColor.WHITE){
                currentPlayer=ChessColor.BLACK;
            }else if (getCurrentPlayer()==ChessColor.BLACK){
                currentPlayer=ChessColor.WHITE;
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
            }

            return true;
        }
        else {
            return false;
        }
    }
}
