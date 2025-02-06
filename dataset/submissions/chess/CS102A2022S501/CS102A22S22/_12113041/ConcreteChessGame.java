import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

//    private BishopChessComponent bishopChessComponentB=new BishopChessComponent();
//    private BishopChessComponent bishopChessComponentb=new BishopChessComponent();

    //initialize
    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;

    }

    public void loadChessGame(List<String> chessboard) {
        String string = chessboard.get(8);
        if (string.equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else {
            this.currentPlayer = ChessColor.BLACK;
        }
        //System.out.println(string);
        //this.chessComponents = new ChessComponent[chessboard.size()-1][chessboard.get(0).length()];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                } else if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                } else if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                }
                //System.out.println(chessboard.get(i).charAt(j));
//                    System.out.println(chessComponents[i][j].getName());
                this.chessComponents[i][j].setChessboard(chessComponents);
            }
        }

    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

//    public String getChessboardGraph(){
//        char[][] chessboard=new char[8][8];
//        StringBuilder chessdata = new StringBuilder();
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
//                    chessboard[i][j] = 'B';
//                } else if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
//                    chessboard[i][j] = 'b';
//                } else if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
//                    chessboard[i][j] = 'K';
//                } else if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
//                    chessboard[i][j] = 'k';
//                } else if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
//                    chessboard[i][j] = 'N';
//                } else if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
//                    chessboard[i][j] = 'n';
//                } else if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
//                    chessboard[i][j] = 'P';
//                } else if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
//                    chessboard[i][j] = 'p';
//                } else if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
//                    chessboard[i][j] = 'Q';
//                } else if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
//                    chessboard[i][j] = 'q';
//                } else if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
//                    chessboard[i][j] = 'R';
//                } else if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
//                    chessboard[i][j] = 'r';
//                } else if (chessComponents[i][j] instanceof EmptySlotComponent) {
//                    chessboard[i][j] = '_';
//                }
////                System.out.println(chessboard[i][j]);
//            }
//        }
//
//        for (int r = 0; r < 8; r++) {
//            for (int c = 0; c < 8; c++) {
//                chessdata.append(chessboard[r][c]);
//            }
//            chessdata.append('\n');
//        }
////        System.out.println(chessdata);
//        String string=chessdata.toString();
//        return string;
//    }

    public String getChessboardGraph() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                s.append(chessComponents[i][j].toString());
            }
            s.append("\n");
        }
        return s.toString();
    }

    public String getCapturedChess(ChessColor player) {
        int a = 2, b = 1, c = 2, d = 8, e = 1, f = 2;
        String s = "";
//        int a=0,b=0,c=0,d=0,e=0,f=0;String s="";
//        if (player==ChessColor.WHITE){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == player) {
                    a--;
                } else if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == player) {
                    b--;
                } else if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == player) {
                    c--;
                } else if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == player) {
                    d--;
                } else if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == player) {
                    e--;
                } else if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == player) {
                    f--;
                }
            }
        }
        //a=2-a;b=1-b;c=2-c;d=8-d;e=1-e;f=2-f;
        if (player == ChessColor.WHITE) {
            if (b != 0) {
                s = s + "k " + b + "\n";
            }
            if (e != 0) {
                s = s + "q " + e + "\n";
            }
            if (f != 0) {
                s = s + "r " + f + "\n";
            }
            if (a != 0) {
                s = s + "b " + a + "\n";
            }
            if (c != 0) {
                s = s + "n " + c + "\n";
            }
            if (d != 0) {
                s = s + "p " + d + "\n";
            }
        } else if (player == ChessColor.BLACK) {
            if (b != 0) {
                s = s + "K " + b + "\n";
            }
            if (e != 0) {
                s = s + "Q " + e + "\n";
            }
            if (f != 0) {
                s = s + "R " + f + "\n";
            }
            if (a != 0) {
                s = s + "B " + a + "\n";
            }
            if (c != 0) {
                s = s + "N " + c + "\n";
            }
            if (d != 0) {
                s = s + "P " + d + "\n";
            }
        }
        return s;
    }
//        else{
//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    if((chessComponents[i][j] instanceof BishopChessComponent)&&(chessComponents[i][j].getChessColor()== ChessColor.BLACK)){
//                        a++;
//                    }else if(chessComponents[i][j] instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
//                        b++;
//                    }else if(chessComponents[i][j] instanceof KnightChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
//                        c++;
//                    }else if(chessComponents[i][j] instanceof PawnChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
//                        d++;
//                    }else if(chessComponents[i][j] instanceof QueenChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
//                        e++;
//                    }else if(chessComponents[i][j] instanceof RookChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
//                        f++;
//                    }
////                    System.out.println(chessComponents[i][j]);
//                }
//            }
//            //System.out.println(a);System.out.println(b);System.out.println(c);System.out.println(d);System.out.println(e);
//            int A=2-a;int B=1-b;int C=2-c;int D=8-d;int E=1-e;int F=2-f;
//            if(B!=0){
//                s=s+"K "+B+"\n";
//            }if(E!=0){
//                s=s+"Q "+E+"\n";
//            }if(F!=0){
//                s=s+"R "+F+"\n";
//            }if(A!=0){
//                s=s+"B "+A+"\n";
//            }if(C!=0){
//                s=s+"N "+C+"\n";
//            }if(D!=0){
//                s=s+"P "+D+"\n";
//            }
//       }
//        return s;


    //    @Override
//    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
//        ChessComponent source = chessComponents[sourceX][sourceY];
//        ChessComponent target = chessComponents[targetX][targetY];
//        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer) {
//            if (chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
//                int x = sourceX, y = sourceY;
////                sourceX = targetX;
////                sourceY = targetY;
////                targetX = x;
////                targetY = y;
//                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
//                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
//                return true;
//            }
//        }
//        return false;
//    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
//        System.out.println(getCanMovePoints(chessComponents[sourceX][sourceY].getSource()));
        if (currentPlayer == chessComponents[sourceX][sourceY].getChessColor()) {
            for (int i =0; i < getCanMovePoints(chessComponents[sourceX][sourceY].getSource()).size();i++){
                if (targetX == getCanMovePoints(chessComponents[sourceX][sourceY].getSource()).get(i).getX() &&
                        targetY == getCanMovePoints(chessComponents[sourceX][sourceY].getSource()).get(i).getY()){
//                    if (chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {

                    ChessComponent source = getChess(sourceX, sourceY);
                    ChessComponent target = getChess(targetX, targetY);

                    source.setSource(new ChessboardPoint(targetX,targetY));
                    source.setName(source.name);
                    this.chessComponents[targetX][targetY] = source;

                    target = new EmptySlotComponent();
                    target.setSource(new ChessboardPoint(sourceX, sourceY));
                    target.setName('_');
                    this.chessComponents[sourceX][sourceY] = target;
//                    chessComponents[targetX][targetY]=new EmptySlotComponent();
//                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
//                    ChessComponent chessComponent=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY) , ChessColor.NONE,  '_');
//                    chessComponent.setSource(new ChessboardPoint(sourceX,sourceY));
//       //             chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY) , ChessColor.NONE,  '_');
//                    chessComponents[sourceX][sourceY]=chessComponent;
//                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
//                    chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
//                    this.chessComponents[targetX][targetY].setChessboard(chessComponents);
//                    this.chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                    if (currentPlayer == ChessColor.BLACK) {
                        currentPlayer = ChessColor.WHITE;
                    } else {
                        currentPlayer = ChessColor.BLACK;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=this.getChess(source.getX(),source.getY());
        // 1. find chess according to source
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        return canMovePoints;
    }
}
