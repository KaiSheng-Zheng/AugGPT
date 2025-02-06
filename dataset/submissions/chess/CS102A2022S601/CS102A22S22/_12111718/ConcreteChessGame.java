import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    private ChessColor currentPlayer= ChessColor.WHITE;
    List<String> chessboard=new ArrayList<>();
    public void loadChessGame(List<String> chessboard){
        this.chessboard=chessboard;
        for (int i=0;i<=7;i++){
            for (int n=0;n<=7;n++){
                if (chessboard.get(i).charAt(n) == 'K' || chessboard.get(i).charAt(n) == 'k') chessComponents[i][n]=new KingChessComponent(chessboard.get(i).charAt(n)=='K'?ChessColor.BLACK:ChessColor.WHITE,chessComponents,new ChessboardPoint(i,n));
                else if (chessboard.get(i).charAt(n) == 'Q' || chessboard.get(i).charAt(n) == 'q') chessComponents[i][n]=new QueenChessComponent(chessboard.get(i).charAt(n)=='Q'?ChessColor.BLACK:ChessColor.WHITE,chessComponents,new ChessboardPoint(i,n));
                else if (chessboard.get(i).charAt(n) == 'R' || chessboard.get(i).charAt(n) == 'r') chessComponents[i][n]=new RookChessComponent(chessboard.get(i).charAt(n)=='R'?ChessColor.BLACK:ChessColor.WHITE,chessComponents,new ChessboardPoint(i,n));
                else if (chessboard.get(i).charAt(n) == 'N' || chessboard.get(i).charAt(n) == 'n') chessComponents[i][n]=new KnightChessComponent(chessboard.get(i).charAt(n)=='N'?ChessColor.BLACK:ChessColor.WHITE,chessComponents,new ChessboardPoint(i,n));
                else if (chessboard.get(i).charAt(n) == 'B' || chessboard.get(i).charAt(n) == 'b') chessComponents[i][n]=new BishopChessComponent(chessboard.get(i).charAt(n)=='B'?ChessColor.BLACK:ChessColor.WHITE,chessComponents,new ChessboardPoint(i,n));
                else if (chessboard.get(i).charAt(n) == 'P' || chessboard.get(i).charAt(n) == 'p') chessComponents[i][n]=new PawnChessComponent(chessboard.get(i).charAt(n)=='P'?ChessColor.BLACK:ChessColor.WHITE,chessComponents,new ChessboardPoint(i,n));
                else if (chessboard.get(i).charAt(n) == '_') chessComponents[i][n]=new EmptySlotComponent();
            }}
        if (chessboard.get(8).equals("w")) currentPlayer=ChessColor.WHITE;
        else if (chessboard.get(8).equals("b")) currentPlayer=ChessColor.BLACK;
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
        StringBuffer re=new StringBuffer();
        for (int i=0;i<=7;i++){
            re.append(chessboard.get(i));
            re.append('\n');
            }
        return String.valueOf(re);
    }


    public String getCapturedChess(ChessColor player){
        int Kc=0;int kc=0;int Qc=0;int qc=0;int Rc=0;int rc=0;int Nc=0;int nc=0;int Bc=0;int bc=0;int Pc=0;int pc=0;
        StringBuffer ans=new StringBuffer();
        for (int i=0;i<=7;i++){
            for (int n=0;n<=7;n++){
                        if (chessComponents[i][n] instanceof KingChessComponent && chessComponents[i][n].getChessColor()==player) kc++;
                        else if (chessComponents[i][n] instanceof QueenChessComponent&&chessComponents[i][n].getChessColor()==player) qc++;
                        else if (chessComponents[i][n] instanceof RookChessComponent&&chessComponents[i][n].getChessColor()==player) rc++;
                        else if (chessComponents[i][n] instanceof KnightChessComponent&&chessComponents[i][n].getChessColor()==player) nc++;
                        else if (chessComponents[i][n] instanceof BishopChessComponent&&chessComponents[i][n].getChessColor()==player) bc++;
                        else if (chessComponents[i][n] instanceof PawnChessComponent&&chessComponents[i][n].getChessColor()==player) pc++;
                        if (chessComponents[i][n] instanceof KingChessComponent&&chessComponents[i][n].getChessColor()==player) Kc++;
                        else if (chessComponents[i][n] instanceof QueenChessComponent&&chessComponents[i][n].getChessColor()==player) Qc++;
                        else if (chessComponents[i][n] instanceof RookChessComponent&&chessComponents[i][n].getChessColor()==player) Rc++;
                        else if (chessComponents[i][n] instanceof KnightChessComponent&&chessComponents[i][n].getChessColor()==player) Nc++;
                        else if (chessComponents[i][n] instanceof BishopChessComponent&&chessComponents[i][n].getChessColor()==player) Bc++;
                        else if (chessComponents[i][n] instanceof PawnChessComponent&&chessComponents[i][n].getChessColor()==player) Pc++;
            }
//                if (chessComponents[i][n].equals("K")) Kc++;
//                else if (chessComponents[i][n].equals("k")) kc++;
//                else if (chessComponents[i][n].equals("Q")) Qc++;
//                else if (chessComponents[i][n].equals("q")) qc++;
//                else if (chessComponents[i][n].equals("R")) Rc++;
//                else if (chessComponents[i][n].equals("r")) rc++;
//                else if (chessComponents[i][n].equals("N")) Nc++;
//                else if (chessComponents[i][n].equals("n")) nc++;
//                else if (chessComponents[i][n].equals("B")) Bc++;
//                else if (chessComponents[i][n].equals("b")) bc++;
//                else if (chessComponents[i][n].equals("P")) Pc++;
//                else if (chessComponents[i][n].equals("p")) pc+
            }

        switch (player){
            case BLACK:
                if ((1-Kc)!=0) ans.append("K ").append(1-Kc).append("\n");
                if ((1-Qc)!=0) ans.append("Q ").append(1-Qc).append("\n");
                if ((2-Rc)!=0) ans.append("R ").append(2 - Rc).append("\n");
                if ((2-Bc)!=0) ans.append("B ").append(2 - Bc).append("\n");
                if ((2-Nc)!=0) ans.append("N ").append(2 - Nc).append("\n");
                if ((8-Pc)!=0) ans.append("P ").append(8 - Pc).append("\n");
                break;
            case WHITE:
                if (1-kc!=0) ans.append("k ").append(1 - kc).append("\n");
                if (1-qc!=0) ans.append("q ").append(1 - qc).append("\n");
                if (2-rc!=0) ans.append("r ").append(2 - rc).append("\n");
                if (2-bc!=0) ans.append("b ").append(2 - bc).append("\n");
                if (2-nc!=0) ans.append("n ").append(2 - nc).append("\n");
                if (8-pc!=0) ans.append("p ").append(8 - pc).append("\n");
                break;
        }
        return String.valueOf(ans);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint chessboardPoint) {
        List<ChessboardPoint> canMovePoints = chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].canMoveTo();
        for(int i = canMovePoints.size() - 1; i >= 0; i--){
                ChessboardPoint item = canMovePoints.get(i);
                if(item == null){
                    canMovePoints.remove(item);
                }
            }
        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>()
        {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2)
           {
                if(o1.getX()>o2.getX()) return 1;
                else if(o1.getX()<o2.getX()) return -1;
                else if(o1.getY()>o2.getY()) return 1;
                else if(o1.getY()<o2.getY()) return -1;
                return 0;
            }
        });
        return canMovePoints;
    }
    public boolean moveChess(int a, int b, int c, int d){
        ChessboardPoint fir=new ChessboardPoint(a,b);
        ChessboardPoint sec=new ChessboardPoint(c,d);
        if(a==c && b==d) return false;
        if(currentPlayer!=chessComponents[a][b].getChessColor()) return false;
        for(int i=getCanMovePoints(fir).size()-1;i>=0;i--)
        {
            if(getCanMovePoints(fir).get(i).getX()==c && getCanMovePoints(fir).get(i).getY()==d)
            {
                break;
            }
            if(i==0) return false;
        }
        chessComponents[a][b].setSource(sec);
        ChessComponent aaa=chessComponents[a][b];
        chessComponents[a][b]=new EmptySlotComponent();
        chessComponents[c][d]=aaa;
        chessComponents[c][d].setMovetime(chessComponents[c][d].getMovetime()+1);
        currentPlayer=(currentPlayer==ChessColor.WHITE)?ChessColor.BLACK:ChessColor.WHITE;
        return true;
    }
}
