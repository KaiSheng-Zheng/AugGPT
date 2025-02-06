import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;
    private List<String> chessboard;

    public ConcreteChessGame(){}

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        this.chessboard=chessboard;
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 'R':chessComponents[i][j]=new RookChessComponent(ChessColor.BLACK);break;
                    case 'N':chessComponents[i][j]=new KnightChessComponent(ChessColor.BLACK);break;
                    case 'B':chessComponents[i][j]=new BishopChessComponent(ChessColor.BLACK);break;
                    case 'Q':chessComponents[i][j]=new QueenChessComponent(ChessColor.BLACK);break;
                    case 'K':chessComponents[i][j]=new KingChessComponent(ChessColor.BLACK);break;
                    case 'P':chessComponents[i][j]=new PawnChessComponent(ChessColor.BLACK);break;
                    case '_':chessComponents[i][j]=new EmptySlotComponent();break;
                    case 'r':chessComponents[i][j]=new RookChessComponent(ChessColor.WHITE);break;
                    case 'n':chessComponents[i][j]=new KnightChessComponent(ChessColor.WHITE);break;
                    case 'b':chessComponents[i][j]=new BishopChessComponent(ChessColor.WHITE);break;
                    case 'q':chessComponents[i][j]=new QueenChessComponent(ChessColor.WHITE);break;
                    case 'k':chessComponents[i][j]=new KingChessComponent(ChessColor.WHITE);break;
                    case 'p':chessComponents[i][j]=new PawnChessComponent(ChessColor.WHITE);
                    }
                }
        }for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {chessComponents[i][j].setChessboard(chessComponents);
            chessComponents[i][j].setSource(new ChessboardPoint(i,j));}}
        if (chessboard.get(8).equals("w")){this.currentPlayer=ChessColor.WHITE;
        }else {this.currentPlayer=ChessColor.BLACK;}
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
       StringBuilder str=new StringBuilder();
        for (int i = 0; i <8 ; i++) {
            str.append(this.chessboard.get(i));str.append("\n");
        }
        String ss=str.toString();
        return ss;
        }

        @Override
    public String getCapturedChess(ChessColor player) {
        int a=0;int b=0;int c=0;int d=0;int e=0;int f=0;
        int A=0;int B=0;int C=0;int D=0;int E=0;int F=0;int g=0;
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 'R':A++;break;
                    case 'N':B++;break;
                    case 'B':C++;break;
                    case 'Q':D++;break;
                    case 'K':E++;break;
                    case 'P':F++;break;
                    case 'r':a++;break;
                    case 'n':b++;break;
                    case 'b':c++;break;
                    case 'q':d++;break;
                    case 'k':e++;break;
                    case 'p':f++;break;
                    default:g=0;
                }
        }}
        if (player==ChessColor.WHITE){
            StringBuilder str=new StringBuilder();
            if (e<1){str.append("k 1\n");}
            if (d<1){str.append("q 1\n");}
            if (a<2){str.append("r ");str.append(2-a);str.append("\n");}
            if (c<2){str.append("b ");str.append(2-c);str.append("\n");}
            if (b<2){str.append("n ");str.append(2-b);str.append("\n");}
            if (f<8){str.append("p ");str.append(8-f);str.append("\n");}
        String ss=str.toString();
            return ss;
        }
        else {StringBuilder str=new StringBuilder();
            if (E<1){str.append("K 1\n");}
            if (D<1){str.append("Q 1\n");}
            if (A<2){str.append("R ");str.append(2-A);str.append("\n");}
            if (C<2){str.append("B ");str.append(2-C);str.append("\n");}
            if (B<2){str.append("N ");str.append(2-B);str.append("\n");}
            if (F<8){str.append("P ");str.append(8-F);str.append("\n");}
            String ss=str.toString();
            return ss;
        }}

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=this.getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints=chess.canMoveTo();
        Comparator<ChessboardPoint> xpaixu=new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                return o1.getX()-o2.getX();
            }
        };
        Comparator<ChessboardPoint> ypaixu=new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                return o1.getY()-o2.getY();
            }
        };
        Collections.sort(canMovePoints,ypaixu);
        Collections.sort(canMovePoints,xpaixu);
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer){
            return false;
        }
        else{
            if (chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX,targetY))){
                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                if (currentPlayer==ChessColor.WHITE){this.currentPlayer=ChessColor.BLACK;}
                else {this.currentPlayer=ChessColor.WHITE;}
                for (int i = 0; i <8 ; i++) {
                    for (int j = 0; j <8 ; j++) {chessComponents[i][j].setChessboard(chessComponents);
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));}}
               StringBuilder sub1=new StringBuilder(chessboard.get(sourceX));
                StringBuilder sub2=new StringBuilder(chessboard.get(targetX));
                sub2.setCharAt(targetY,chessboard.get(sourceX).charAt(sourceY));
                sub1.setCharAt(sourceY,'_');
                chessboard.remove(sourceX);
                chessboard.add(sourceX,sub1.toString());
                chessboard.remove(targetX);
                chessboard.add(targetX,sub2.toString());
                return true;
            }
            else {return false;
        }

    }}
}