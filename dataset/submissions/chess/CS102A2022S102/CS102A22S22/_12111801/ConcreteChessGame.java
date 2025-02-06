import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];

    private ChessColor currentPlayer=ChessColor.WHITE;

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                char c =  chessboard.get(i).charAt(j);
                if (c=='k'){chessComponents[i][j]=new KingChessComponent();chessComponents[i][j].setChessColor(ChessColor.WHITE);chessComponents[i][j].name='k';}
                if (c=='K'){chessComponents[i][j]=new KingChessComponent();chessComponents[i][j].setChessColor(ChessColor.BLACK);chessComponents[i][j].name='K';}
                if (c=='q'){chessComponents[i][j]=new QueenChessComponent();chessComponents[i][j].setChessColor(ChessColor.WHITE);chessComponents[i][j].name='q';}
                if (c=='Q'){chessComponents[i][j]=new QueenChessComponent();chessComponents[i][j].setChessColor(ChessColor.BLACK);chessComponents[i][j].name='Q';}
                if (c=='p'){chessComponents[i][j]=new PawnChessComponent();chessComponents[i][j].setChessColor(ChessColor.WHITE);chessComponents[i][j].name='p';}
                if (c=='P'){chessComponents[i][j]=new PawnChessComponent();chessComponents[i][j].setChessColor(ChessColor.BLACK);chessComponents[i][j].name='P';}
                if (c=='n'){chessComponents[i][j]=new KnightChessComponent();chessComponents[i][j].setChessColor(ChessColor.WHITE);chessComponents[i][j].name='n';}
                if (c=='N'){chessComponents[i][j]=new KnightChessComponent();chessComponents[i][j].setChessColor(ChessColor.BLACK);chessComponents[i][j].name='N';}
                if (c=='b'){chessComponents[i][j]=new BishopChessComponent();chessComponents[i][j].setChessColor(ChessColor.WHITE);chessComponents[i][j].name='b';}
                if (c=='B'){chessComponents[i][j]=new BishopChessComponent();chessComponents[i][j].setChessColor(ChessColor.BLACK);chessComponents[i][j].name='B';}
                if (c=='r'){chessComponents[i][j]=new RookChessComponent();chessComponents[i][j].setChessColor(ChessColor.WHITE);chessComponents[i][j].name='r';}
                if (c=='R'){chessComponents[i][j]=new RookChessComponent();chessComponents[i][j].setChessColor(ChessColor.BLACK);chessComponents[i][j].name='R';}
                if (c=='_'){chessComponents[i][j]=new EmptySlotComponent();chessComponents[i][j].setChessColor(ChessColor.NONE);chessComponents[i][j].name='_';}
            }
        }
        if(chessboard.get(8).equals("w")) currentPlayer=ChessColor.WHITE;
        else currentPlayer=ChessColor.BLACK;
    }

    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder line = new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                ChessComponent chess = chessComponents[i][j];
                ChessColor color = chessComponents[i][j].getChessColor();
                if(chess instanceof KingChessComponent && color==ChessColor.WHITE) line.append('k');
                if(chess instanceof KingChessComponent && color==ChessColor.BLACK) line.append('K');
                if(chess instanceof RookChessComponent && color==ChessColor.WHITE) line.append('r');
                if(chess instanceof RookChessComponent && color==ChessColor.BLACK) line.append('R');
                if(chess instanceof KnightChessComponent && color==ChessColor.WHITE) line.append('n');
                if(chess instanceof KnightChessComponent && color==ChessColor.BLACK) line.append('N');
                if(chess instanceof QueenChessComponent && color==ChessColor.WHITE) line.append('q');
                if(chess instanceof QueenChessComponent && color==ChessColor.BLACK) line.append('Q');
                if(chess instanceof BishopChessComponent && color==ChessColor.WHITE) line.append('b');
                if(chess instanceof BishopChessComponent && color==ChessColor.BLACK) line.append('B');
                if(chess instanceof PawnChessComponent && color==ChessColor.WHITE) line.append('p');
                if(chess instanceof PawnChessComponent && color==ChessColor.BLACK) line.append('P');
                if(chess instanceof EmptySlotComponent && color==ChessColor.NONE) line.append('_');
            }
            if(i!=7) line.append("\n");
        }
        return line.toString();
    }

    public String getCapturedChess(ChessColor player){
        int iK = 1, iQ = 1, iR = 2, iB = 2, iN = 2, iP = 8;
        String str = getChessboardGraph();
        StringBuilder stringBuilder = new StringBuilder();
        if(player==ChessColor.WHITE){
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='k') iK--;
                if(str.charAt(i)=='q') iQ--;
                if(str.charAt(i)=='r') iR--;
                if(str.charAt(i)=='b') iB--;
                if(str.charAt(i)=='n') iN--;
                if(str.charAt(i)=='p') iP--;
            }
            if(iK!=0) {stringBuilder.append("k ");stringBuilder.append(iK);stringBuilder.append("\n");}
            if(iQ!=0) {stringBuilder.append("q ");stringBuilder.append(iQ);stringBuilder.append("\n");}
            if(iR!=0) {stringBuilder.append("r ");stringBuilder.append(iR);stringBuilder.append("\n");}
            if(iB!=0) {stringBuilder.append("b ");stringBuilder.append(iB);stringBuilder.append("\n");}
            if(iN!=0) {stringBuilder.append("n ");stringBuilder.append(iN);stringBuilder.append("\n");}
            if(iP!=0) {stringBuilder.append("p ");stringBuilder.append(iP);stringBuilder.append("\n");}
            return stringBuilder.toString();
        }
        if (player==ChessColor.BLACK){
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='K') iK--;
                if(str.charAt(i)=='Q') iQ--;
                if(str.charAt(i)=='R') iR--;
                if(str.charAt(i)=='B') iB--;
                if(str.charAt(i)=='N') iN--;
                if(str.charAt(i)=='P') iP--;
            }
            if(iK!=0) {stringBuilder.append("K ");stringBuilder.append(iK);stringBuilder.append("\n");}
            if(iQ!=0) {stringBuilder.append("Q ");stringBuilder.append(iQ);stringBuilder.append("\n");}
            if(iR!=0) {stringBuilder.append("R ");stringBuilder.append(iR);stringBuilder.append("\n");}
            if(iB!=0) {stringBuilder.append("B ");stringBuilder.append(iB);stringBuilder.append("\n");}
            if(iN!=0) {stringBuilder.append("N ");stringBuilder.append(iN);stringBuilder.append("\n");}
            if(iP!=0) {stringBuilder.append("P ");stringBuilder.append(iP);stringBuilder.append("\n");}
            return stringBuilder.toString();
        }
        return null;
    }

    public ChessComponent getChess(int x,int y){
        return chessComponents[x][y];
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint chessboardPoint){
        
        return null;
    }
    public boolean moveChess(int ix,int iy,int fx,int fy){
        return true;
    }
}

