import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
   private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;

    public void loadChessGame(List<String> chessboard){
        for(int l=0;l<8;l++){
            for(int p=0;p<8;p++){
                if(chessboard.get(l).charAt(p)=='K'){chessComponents[l][p]=new KingChessComponent('K',ChessColor.BLACK,l,p,this);}
                    else if(chessboard.get(l).charAt(p)=='k'){chessComponents[l][p]=new KingChessComponent('k',ChessColor.WHITE,l,p,this);}
                       else if(chessboard.get(l).charAt(p)=='Q'){chessComponents[l][p]=new QueenChessComponent('Q',ChessColor.BLACK,l,p,this);}
                          else if(chessboard.get(l).charAt(p)=='q'){chessComponents[l][p]=new QueenChessComponent('q',ChessColor. WHITE,l,p,this);}
                else if(chessboard.get(l).charAt(p)=='B'){chessComponents[l][p]=new BishopChessComponent('B',ChessColor.BLACK,l,p,this);}
                else if(chessboard.get(l).charAt(p)=='b'){chessComponents[l][p]=new BishopChessComponent('b',ChessColor.WHITE,l,p,this);}
                else if(chessboard.get(l).charAt(p)=='N'){chessComponents[l][p]=new KnightChessComponent('N',ChessColor.BLACK,l,p,this);}
                else if(chessboard.get(l).charAt(p)=='n'){chessComponents[l][p]=new KnightChessComponent('n',ChessColor.WHITE,l,p,this);}
                else if(chessboard.get(l).charAt(p)=='R'){chessComponents[l][p]=new RookChessComponent('R',ChessColor.BLACK,l,p,this);}
                else if(chessboard.get(l).charAt(p)=='r'){chessComponents[l][p]=new RookChessComponent('r',ChessColor.WHITE,l,p,this);}
                else if(chessboard.get(l).charAt(p)=='P'){chessComponents[l][p]=new PawnChessComponent('P',ChessColor.BLACK,l,p,this);}
                else if(chessboard.get(l).charAt(p)=='p'){chessComponents[l][p]=new PawnChessComponent('p',ChessColor.WHITE,l,p,this);}
                else if(chessboard.get(l).charAt(p)=='_'){chessComponents[l][p]=new EmptySlotComponent('_',l,p,this);}
            }

        }
        if(chessboard.get(8).equals("b")){
            currentPlayer=ChessColor.BLACK;
        }

    }
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph() {
        StringBuilder s = new StringBuilder();
        for (int l = 0; l < 8; l++) {
            for (int m = 0; m < 8; m++) {
                s.append(chessComponents[l][m].toString());
            }

            s.append("\n");
        }
        return String.valueOf(s);
    }
    public String getCapturedChess(ChessColor player) {
        StringBuilder s = new StringBuilder();
        int ll = 0;
        for (int l = 0; l < 8; l++) {

            if (l == 0) {
                ll = 0;
            }


            for (int m = 0; m < 8; m++) {
                if (chessComponents[l][m].getChessColor() == player && (chessComponents[l][m].name == 'K' || chessComponents[l][m].name == 'k')) {
                    ll++;
                }

            }
        }
        if (ll < 1 && player == ChessColor.BLACK) {
            s.append(String.format("K %d\n", 1 - ll));

        } else if (ll < 1 && player == ChessColor.WHITE) {
            s.append(String.format("k %d\n", 1 - ll));

        }
        for (int l = 0; l < 8; l++) {

            if (l == 0) {
                ll = 0;
            }


            for (int m = 0; m < 8; m++) {
                if (chessComponents[l][m].getChessColor() == player && (chessComponents[l][m].name == 'Q' || chessComponents[l][m].name == 'q')) {
                    ll++;
                }

            }
        }
        if (ll < 1 && player == ChessColor.BLACK) {
            s.append(String.format("Q %d\n", 1 - ll));

        } else if (ll < 1 && player == ChessColor.WHITE) {
            s.append(String.format("q %d\n", 1 - ll));

        }
        for (int l = 0; l < 8; l++) {

            if (l == 0) {
                ll = 0;
            }


            for (int m = 0; m < 8; m++) {
                if (chessComponents[l][m].getChessColor() == player && (chessComponents[l][m].name == 'R' || chessComponents[l][m].name == 'r')) {
                    ll++;
                }

            }
        }
        if (ll < 2 && player == ChessColor.BLACK) {
            s.append(String.format("R %d\n", 2 - ll));

        } else if (ll < 2 && player == ChessColor.WHITE) {
            s.append(String.format("r %d\n", 2 - ll));

        }
        for (int l = 0; l < 8; l++) {

            if (l == 0) {
                ll = 0;
            }


            for (int m = 0; m < 8; m++) {
                if (chessComponents[l][m].getChessColor() == player && (chessComponents[l][m].name == 'B' || chessComponents[l][m].name == 'b')) {
                    ll++;
                }

            }
        }
        if (ll < 2 && player == ChessColor.BLACK) {
            s.append(String.format("B %d\n", 2 - ll));

        } else if (ll < 2 && player == ChessColor.WHITE) {
            s.append(String.format("b %d\n", 2 - ll));

        }
        for (int l = 0; l < 8; l++) {

            if (l == 0) {
                ll = 0;
            }


            for (int m = 0; m < 8; m++) {
                if (chessComponents[l][m].getChessColor() == player && (chessComponents[l][m].name == 'N' || chessComponents[l][m].name == 'n')) {
                    ll++;
                }

            }
        }
        if (ll < 2 && player == ChessColor.BLACK) {
            s.append(String.format("N %d\n", 2 - ll));

        } else if (ll < 2 && player == ChessColor.WHITE) {
            s.append(String.format("n %d\n", 2 - ll));

        }
        for (int l = 0; l < 8; l++) {

            if (l == 0) {
                ll = 0;
            }


            for (int m = 0; m < 8; m++) {
                if (chessComponents[l][m].getChessColor() == player && (chessComponents[l][m].name == 'P' || chessComponents[l][m].name == 'p')) {
                    ll++;
                }

            }
        }
        if (ll < 8 && player == ChessColor.BLACK) {
            s.append(String.format("P %d\n", 8 - ll));

        } else if (ll < 8 && player == ChessColor.WHITE) {
            s.append(String.format("p %d\n", 8 - ll));

        }
        return s.toString();
    }
    public ChessComponent getChess(int x, int y){


       return chessComponents[x][y];

    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent c=getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints = c.canMoveTo();
        List<String> ssss=new ArrayList<>();
        for(int m=0;m<canMovePoints.size();m++){
            ssss.add(canMovePoints.get(m).toString());
        }
        Collections.sort(ssss);
        List<ChessboardPoint> canMovePoints1 = new ArrayList<>();
        for(int m=0;m<canMovePoints.size();m++){
            String l=String.valueOf( ssss.get(m).charAt(1));
            String ll=String.valueOf( ssss.get(m).charAt(3));
            canMovePoints1.add(new ChessboardPoint(Integer.parseInt(l),Integer.parseInt(ll)));
        }

        return canMovePoints1;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        List<ChessboardPoint> a=getChess(sourceX,sourceY).canMoveTo();
        boolean aa=false;
        for(int l=0;l<a.size();l++){
            if(a.get(l).getX()==targetX&&a.get(l).getY()==targetY){
                aa=true;
                break;
            }
        }
        if(currentPlayer!=getChess(sourceX,sourceY).getChessColor()){
            aa=false;
        }
        if(aa){
            ChessboardPoint cc=new ChessboardPoint(targetX,targetY);
            getChess(sourceX,sourceY).setSource(cc);

            chessComponents[targetX][targetY]=getChess(sourceX,sourceY);
            chessComponents[sourceX][sourceY]=new EmptySlotComponent('_',sourceX,sourceY,this);
            if(currentPlayer==ChessColor.BLACK){currentPlayer=ChessColor.WHITE;}
            else {currentPlayer=ChessColor.BLACK;}

        }
        return aa;
    }

}

