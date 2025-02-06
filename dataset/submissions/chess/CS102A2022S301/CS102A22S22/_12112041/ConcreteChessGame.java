import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        chessComponents=new ChessComponent[8][8];
        for(int i=0;i<8;i++){
            String Line=chessboard.get(i);
            for(int j=0;j<8;j++) {
                ChessColor color = ChessColor.BLACK;
                ChessboardPoint source = new ChessboardPoint(i, j);
                if (Line.charAt(j) >= 97) {
                    color = ChessColor.WHITE;
                } else if (Line.charAt(j) == 95) {
                    color = ChessColor.NONE;
                }

                if (Line.charAt(j) == 95) {
                    chessComponents[i][j] = new EmptySlotComponent(source, color, Line.charAt(j),chessComponents);
                } else if (Line.charAt(j) == 'R' | Line.charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(source, color, Line.charAt(j),chessComponents);
                } else if (Line.charAt(j) == 'N' | Line.charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(source, color, Line.charAt(j),chessComponents);
                } else if (Line.charAt(j) == 'Q' | Line.charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(source, color, Line.charAt(j),chessComponents);
                } else if (Line.charAt(j) == 'K' | Line.charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(source, color, Line.charAt(j),chessComponents);
                } else if (Line.charAt(j) == 'P' | Line.charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(source, color, Line.charAt(j),chessComponents);
                } else if (Line.charAt(j) == 'B' | Line.charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(source, color, Line.charAt(j),chessComponents);
                }
            }
        }
        if(chessboard.get(8).charAt(0)=='w'){currentPlayer=ChessColor.WHITE;}
        else{currentPlayer=ChessColor.BLACK;}
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String s = "";
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                s=s.concat(String.valueOf(this.chessComponents[i][j].getName()));
            }
            s=s.concat("\n");
        }
        return s;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
//        int K,k,Q,q,R,r,B,b,N,n,P,p=2;
        int[] capturedChesses={1,1,1,1,2,2,2,2,2,2,8,8};
        char[] chessName={'K','k','Q','q','R','r','B','b','N','n','P','p'};
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j].getName()=='K'){capturedChesses[0]-=1;}
                if(chessComponents[i][j].getName()=='k'){capturedChesses[1]-=1;}
                if(chessComponents[i][j].getName()=='Q'){capturedChesses[2]-=1;}
                if(chessComponents[i][j].getName()=='q'){capturedChesses[3]-=1;}
                if(chessComponents[i][j].getName()=='R'){capturedChesses[4]-=1;}
                if(chessComponents[i][j].getName()=='r'){capturedChesses[5]-=1;}
                if(chessComponents[i][j].getName()=='B'){capturedChesses[6]-=1;}
                if(chessComponents[i][j].getName()=='b'){capturedChesses[7]-=1;}
                if(chessComponents[i][j].getName()=='N'){capturedChesses[8]-=1;}
                if(chessComponents[i][j].getName()=='n'){capturedChesses[9]-=1;}
                if(chessComponents[i][j].getName()=='P'){capturedChesses[10]-=1;}
                if(chessComponents[i][j].getName()=='p'){capturedChesses[11]-=1;}
            }
        }
        String s="";
        if(player==ChessColor.BLACK){
            for(int i=0;i<6;i++){
                if(capturedChesses[2*i]!=0){
                    s=s.concat(String.format("%c %d\n",chessName[2*i],capturedChesses[2*i]));
                }
                else{;}
            }
        }
        else{
            for(int i=0;i<6;i++){
                if(capturedChesses[2*i+1]!=0){
                    s=s.concat(String.format("%c %d\n",chessName[2*i+1],capturedChesses[2*i+1]));
                }
                else{;}
            }
        }
        return s;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent theChess=chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints=theChess.canMoveTo();
        if(canMovePoints.isEmpty()){
            return canMovePoints;
        }
        else{
            canMovePoints.sort(new Comparator<ChessboardPoint>() {
                @Override
                public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                    if(o1.getX() < o2.getX()) {
                        return -1;
                    }
                    else if(o1.getX() > o2.getX()){
                        return 1;
                    }
                    else{
                        if(o1.getY() < o2.getY()){return -1;}
                        else{return 1;}
                    }
                }
            });
            return canMovePoints;
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent theChess=chessComponents[sourceX][sourceY];
        if(theChess.getChessColor()==currentPlayer&&targetX>=0&&targetX<8&&targetY>=0&&targetY<8) {
            if ((!theChess.canMoveTo().isEmpty()) && theChess.canMoveTo().contains(chessComponents[targetX][targetY].getSource())) {
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(theChess.getSource(), ChessColor.NONE, '_', chessComponents);
                theChess.getSource().setX(targetX);
                theChess.getSource().setY(targetY);
                chessComponents[targetX][targetY] = theChess;
                if (this.currentPlayer == ChessColor.BLACK) {
                    this.currentPlayer = ChessColor.WHITE;
                } else {
                    this.currentPlayer = ChessColor.BLACK;
                }
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}