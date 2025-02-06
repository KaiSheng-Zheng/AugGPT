import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ConcreteChessGame(ChessColor color){
        chessComponents[0][0]=new RookChessComponent(new ChessboardPoint(0,0),ChessColor.BLACK);
        chessComponents[0][7]=new RookChessComponent(new ChessboardPoint(0,7),ChessColor.BLACK);
        chessComponents[0][1]=new KnightChessComponent(new ChessboardPoint(0,1),ChessColor.BLACK);
        chessComponents[0][6]=new KnightChessComponent(new ChessboardPoint(0,6),ChessColor.BLACK);
        chessComponents[0][2]=new BishopChessComponent(new ChessboardPoint(0,2),ChessColor.BLACK);
        chessComponents[0][5]=new BishopChessComponent(new ChessboardPoint(0,5),ChessColor.BLACK);
        chessComponents[0][3]=new QueenChessComponent(new ChessboardPoint(0,3),ChessColor.BLACK);
        chessComponents[0][4]=new KingChessComponent(new ChessboardPoint(0,4),ChessColor.BLACK);
        for (int y=0;y<8;y++){
            chessComponents[1][y]=new PawnChessComponent(new ChessboardPoint(1,y),ChessColor.BLACK);
        }
        for (int x=2;x<6;x++){
            for (int y=0;y<8;y++){
                chessComponents[x][y]=new EmptySlotComponent(new ChessboardPoint(x,y),ChessColor.NONE);
            }
        }
        for (int y=0;y<8;y++){
            chessComponents[6][y]=new PawnChessComponent(new ChessboardPoint(6,y),ChessColor.WHITE);
        }
        chessComponents[7][0]=new RookChessComponent(new ChessboardPoint(7,0),ChessColor.WHITE);
        chessComponents[7][7]=new RookChessComponent(new ChessboardPoint(7,7),ChessColor.WHITE);
        chessComponents[7][1]=new KnightChessComponent(new ChessboardPoint(7,1),ChessColor.WHITE);
        chessComponents[7][6]=new KnightChessComponent(new ChessboardPoint(7,6),ChessColor.WHITE);
        chessComponents[7][2]=new BishopChessComponent(new ChessboardPoint(7,2),ChessColor.WHITE);
        chessComponents[7][5]=new BishopChessComponent(new ChessboardPoint(7,5),ChessColor.WHITE);
        chessComponents[7][3]=new QueenChessComponent(new ChessboardPoint(7,3),ChessColor.WHITE);
        chessComponents[7][4]=new KingChessComponent(new ChessboardPoint(7,4),ChessColor.WHITE);
        setCurrentPlayer(color);
    }

    public ConcreteChessGame(){
        chessComponents[0][0]=new RookChessComponent(new ChessboardPoint(0,0),ChessColor.BLACK);
        chessComponents[0][7]=new RookChessComponent(new ChessboardPoint(0,7),ChessColor.BLACK);
        chessComponents[0][1]=new KnightChessComponent(new ChessboardPoint(0,1),ChessColor.BLACK);
        chessComponents[0][6]=new KnightChessComponent(new ChessboardPoint(0,6),ChessColor.BLACK);
        chessComponents[0][2]=new BishopChessComponent(new ChessboardPoint(0,2),ChessColor.BLACK);
        chessComponents[0][5]=new BishopChessComponent(new ChessboardPoint(0,5),ChessColor.BLACK);
        chessComponents[0][3]=new QueenChessComponent(new ChessboardPoint(0,3),ChessColor.BLACK);
        chessComponents[0][4]=new KingChessComponent(new ChessboardPoint(0,4),ChessColor.BLACK);
        for (int y=0;y<8;y++){
            chessComponents[1][y]=new PawnChessComponent(new ChessboardPoint(1,y),ChessColor.BLACK);
        }
        for (int x=2;x<6;x++){
            for (int y=0;y<8;y++){
                chessComponents[x][y]=new EmptySlotComponent(new ChessboardPoint(x,y),ChessColor.NONE);
            }
        }
        for (int y=0;y<8;y++){
            chessComponents[6][y]=new PawnChessComponent(new ChessboardPoint(6,y),ChessColor.WHITE);
        }
        chessComponents[7][0]=new RookChessComponent(new ChessboardPoint(7,0),ChessColor.WHITE);
        chessComponents[7][7]=new RookChessComponent(new ChessboardPoint(7,7),ChessColor.WHITE);
        chessComponents[7][1]=new KnightChessComponent(new ChessboardPoint(7,1),ChessColor.WHITE);
        chessComponents[7][6]=new KnightChessComponent(new ChessboardPoint(7,6),ChessColor.WHITE);
        chessComponents[7][2]=new BishopChessComponent(new ChessboardPoint(7,2),ChessColor.WHITE);
        chessComponents[7][5]=new BishopChessComponent(new ChessboardPoint(7,5),ChessColor.WHITE);
        chessComponents[7][3]=new QueenChessComponent(new ChessboardPoint(7,3),ChessColor.WHITE);
        chessComponents[7][4]=new KingChessComponent(new ChessboardPoint(7,4),ChessColor.WHITE);
        setCurrentPlayer(ChessColor.WHITE);
    }

    public void loadChessGame(List<String> chessboard){
        for (int x=0;x<chessboard.size()-1;x++){
            for (int y=0;y<chessboard.get(x).length();y++){
                switch (chessboard.get(x).charAt(y)){
                    case (char)95:chessComponents[x][y]=new EmptySlotComponent(new ChessboardPoint(x,y),ChessColor.NONE);break;
                    case (char)75:chessComponents[x][y]=new KingChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK);break;
                    case (char)107:chessComponents[x][y]=new KingChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE);break;
                    case (char)81:chessComponents[x][y]=new QueenChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK);break;
                    case (char)113:chessComponents[x][y]=new QueenChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE);break;
                    case (char)82:chessComponents[x][y]=new RookChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK);break;
                    case (char)114:chessComponents[x][y]=new RookChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE);break;
                    case (char)66:chessComponents[x][y]=new BishopChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK);break;
                    case (char)98:chessComponents[x][y]=new BishopChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE);break;
                    case (char)78:chessComponents[x][y]=new KnightChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK);break;
                    case (char)110:chessComponents[x][y]=new KnightChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE);break;
                    case (char)80:chessComponents[x][y]=new PawnChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK);break;
                    case (char)112:chessComponents[x][y]=new PawnChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE);break;
                }
            }
        }
        if (chessboard.get(8).equals("w")){
           setCurrentPlayer(ChessColor.WHITE);
        }else if (chessboard.get(8).equals("b")){
            setCurrentPlayer(ChessColor.BLACK);
        }
        for (int x=0;x<chessboard.size()-1;x++){
            for (int y=0;y<chessboard.get(x).length();y++){
                chessComponents[x][y].chessComponents=chessComponents;
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder s =new StringBuilder();
        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                s.append(chessComponents[x][y]);
            }
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder stringBuilder=new StringBuilder();
        if (player.equals(ChessColor.BLACK)){
            int K=1;
            int Q=1;
            int B=2;
            int R=2;
            int N=2;
            int P=8;
            int K1=0;
            int Q1=0;
            int B1=0;
            int R1=0;
            int N1=0;
            int P1=0;
            for (int x=0;x<8;x++){
                for (int y=0;y<8;y++){
                    switch (chessComponents[x][y].getSort()) {
                        case -6: K1++;break;
                        case -5: Q1++;break;
                        case -4: R1++;break;
                        case -3: B1++;break;
                        case -2: N1++;break;
                        case -1: P1++;break;
                    }
                }
            }
           if (K-K1!=0){
               stringBuilder.append(String.format("K %d\n",K-K1));
           }
           if (Q-Q1!=0){
               stringBuilder.append(String.format("Q %d\n",Q-Q1));
            }
           if (R-R1!=0){
               stringBuilder.append(String.format("R %d\n",R-R1));
            }
           if (B-B1!=0){
               stringBuilder.append(String.format("B %d\n",B-B1));
            }
           if (N-N1!=0){
               stringBuilder.append(String.format("N %d\n",N-N1));
            }
           if (P-P1!=0){
               stringBuilder.append(String.format("P %d\n",P-P1));
            }
        }else if (player.equals(ChessColor.WHITE)){
            int k=1;
            int q=1;
            int b=2;
            int r=2;
            int n=2;
            int p=8;
            int k1=0;
            int q1=0;
            int b1=0;
            int r1=0;
            int n1=0;
            int p1=0;
            for (int x=0;x<8;x++){
                for (int y=0;y<8;y++){
                    switch (chessComponents[y][x].getSort()) {
                        case 6: k1++;break;
                        case 5: q1++;break;
                        case 4: r1++;break;
                        case 3: b1++;break;
                        case 2: n1++;break;
                        case 1: p1++;break;
                    }
                }
            }
            if (k-k1!=0){
                stringBuilder.append(String.format("k %d\n",k-k1));
            }
            if (q-q1!=0){
                stringBuilder.append(String.format("q %d\n",q-q1));
            }
            if (r-r1!=0){
                stringBuilder.append(String.format("r %d\n",r-r1));
            }
            if (b-b1!=0){
                stringBuilder.append(String.format("b %d\n",b-b1));
            }
            if (n-n1!=0){
                stringBuilder.append(String.format("n %d\n",n-n1));
            }
            if (p-p1!=0){
                stringBuilder.append(String.format("p %d\n",p-p1));
            }
        }
        return stringBuilder.toString();
    }

    public ChessComponent getChess(int x,int y){
        return chessComponents[x][y];
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        List<ChessboardPoint> list = new ArrayList<>(chessComponents[sourceX][sourceY].canMoveTo());
        boolean test=false;
        if (currentPlayer.equals(chessComponents[sourceX][sourceY].getChessColor())){
            for (ChessboardPoint c:list){
                if (c.getX()==targetX&&c.getY()==targetY){
                    test = true;
                }
            }
        }

        if (test){
            ChessboardPoint x=new ChessboardPoint(targetX,targetY);
            switch (chessComponents[sourceX][sourceY].getSort()){
                case 1:chessComponents[targetX][targetY]=new PawnChessComponent(x,ChessColor.WHITE);break;
                case -1:chessComponents[targetX][targetY]=new PawnChessComponent(x,ChessColor.BLACK);break;
                case 2:chessComponents[targetX][targetY]=new KnightChessComponent(x,ChessColor.WHITE);break;
                case -2:chessComponents[targetX][targetY]=new KnightChessComponent(x,ChessColor.BLACK);break;
                case 3:chessComponents[targetX][targetY]=new BishopChessComponent(x,ChessColor.WHITE);break;
                case -3:chessComponents[targetX][targetY]=new BishopChessComponent(x,ChessColor.BLACK);break;
                case 4:chessComponents[targetX][targetY]=new RookChessComponent(x,ChessColor.WHITE);break;
                case -4:chessComponents[targetX][targetY]=new RookChessComponent(x,ChessColor.BLACK);break;
                case 5:chessComponents[targetX][targetY]=new QueenChessComponent(x,ChessColor.WHITE);break;
                case -5:chessComponents[targetX][targetY]=new QueenChessComponent(x,ChessColor.BLACK);break;
                case 6:chessComponents[targetX][targetY]=new KingChessComponent(x,ChessColor.WHITE);break;
                case -6:chessComponents[targetX][targetY]=new KingChessComponent(x,ChessColor.BLACK);break;

            }
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
            chessComponents[targetX][targetY].chessComponents=chessComponents;
            chessComponents[sourceX][sourceY].chessComponents=chessComponents;
            if (currentPlayer.equals(ChessColor.WHITE)){
                setCurrentPlayer(ChessColor.BLACK);
            }else if (currentPlayer.equals(ChessColor.BLACK)){
                setCurrentPlayer(ChessColor.WHITE);
            }
        }
        return test;
        }


     public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
         List<ChessboardPoint> list = new ArrayList<>(chessComponents[source.getX()][source.getY()].canMoveTo());
         return list;
     }
    }
