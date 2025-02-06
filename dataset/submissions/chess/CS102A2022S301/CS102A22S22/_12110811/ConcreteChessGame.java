
import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame extends ChessComponent implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;
    private List<String>graph;

    public String BackTransfer(ChessComponent toTrans){

        if(toTrans instanceof PawnChessComponent){
            if(toTrans.getChessColor().equals(ChessColor.BLACK)){
                return "P";
            }if(toTrans.getChessColor().equals(ChessColor.WHITE)){
                return "p";
            }
        }else if(toTrans instanceof BishopChessComponent){
            if(toTrans.getChessColor().equals(ChessColor.BLACK)){
                return "B";
            }if(toTrans.getChessColor().equals(ChessColor.WHITE)){
                return "b";
            }
        }
        if(toTrans instanceof KingChessComponent){
            if(toTrans.getChessColor().equals(ChessColor.BLACK)){
                return "K";
            }if(toTrans.getChessColor().equals(ChessColor.WHITE)){
                return "k";
            }
        }
        if(toTrans instanceof QueenChessComponent){
            if(toTrans.getChessColor().equals(ChessColor.BLACK)){
                return "Q";
            }if(toTrans.getChessColor().equals(ChessColor.WHITE)){
                return "q";
            }
        }
        if(toTrans instanceof RookChessComponent){
            if(toTrans.getChessColor().equals(ChessColor.BLACK)){
                return "R";
            }if(toTrans.getChessColor().equals(ChessColor.WHITE)){
                return "r";
            }
        }
        if(toTrans instanceof KnightChessComponent){
            if(toTrans.getChessColor().equals(ChessColor.BLACK)){
                return "N";
            }if(toTrans.getChessColor().equals(ChessColor.WHITE)){
                return "n";
            }
        }
        if(toTrans instanceof EmptySlotComponent){
            return "_";
        }



        return "_";
    }
    public ChessComponent transfer(Character Capital){
        switch (Capital){
            case'R':
                ChessComponent ToTranR=new RookChessComponent();
                ToTranR.setNowBoard(chessComponents);
                ToTranR.setChessColor(ChessColor.BLACK);
                ToTranR.setName('R');
                return ToTranR;
            case 'r':
                ChessComponent ToTranRr=new RookChessComponent();
                ToTranRr.setChessColor(ChessColor.WHITE);
                ToTranRr.setName('r');
                ToTranRr.setNowBoard(chessComponents);
                return ToTranRr;
            case 'N':
                ChessComponent ToTranN=new KnightChessComponent();
                ToTranN.setChessColor(ChessColor.BLACK);
                ToTranN.setName('N');
                ToTranN.setNowBoard(chessComponents);
                return ToTranN;
            case 'n':
                ChessComponent ToTranNn=new KnightChessComponent();
                ToTranNn.setChessColor(ChessColor.WHITE);
                ToTranNn.setName('n');
                ToTranNn.setNowBoard(chessComponents);
                return ToTranNn;
            case 'B':
                ChessComponent ToTranB=new BishopChessComponent();
                ToTranB.setChessColor(ChessColor.BLACK);
                ToTranB.setName('B');
                ToTranB.setNowBoard(chessComponents);
                return ToTranB;
            case 'b':
                ChessComponent ToTranBb=new BishopChessComponent();
                ToTranBb.setChessColor(ChessColor.WHITE);
                ToTranBb.setName('b');
                ToTranBb.setNowBoard(chessComponents);
                return ToTranBb;
            case'Q':
                ChessComponent ToTranQ=new QueenChessComponent();
                ToTranQ.setChessColor(ChessColor.BLACK);
                ToTranQ.setName('Q');
                ToTranQ.setNowBoard(chessComponents);
                return ToTranQ;
            case 'q':
                ChessComponent ToTranQq=new QueenChessComponent();
                ToTranQq.setChessColor(ChessColor.WHITE);
                ToTranQq.setName('q');
                ToTranQq.setNowBoard(chessComponents);
                return ToTranQq;
            case'K':
                ChessComponent ToTransfer=new KingChessComponent();
                ToTransfer.setChessColor(ChessColor.BLACK);
                ToTransfer.setName('K');
                ToTransfer.setNowBoard(chessComponents);
                return ToTransfer;
            case 'k':
                ChessComponent ToTranKk=new KingChessComponent();
                ToTranKk.setChessColor(ChessColor.WHITE);
                ToTranKk.setName('k');
                ToTranKk.setNowBoard(chessComponents);
                return ToTranKk;
            case 'P':
                ChessComponent ToTranP=new PawnChessComponent();
                ToTranP.setChessColor(ChessColor.BLACK);
                ToTranP.setName('P');
                ToTranP.setNowBoard(chessComponents);
                return ToTranP;
            case 'p':
                ChessComponent ToTranPp=new PawnChessComponent();
                ToTranPp.setChessColor(ChessColor.WHITE);
                ToTranPp.setName('p');
                ToTranPp.setNowBoard(chessComponents);
                return ToTranPp;
            case '_':
                ChessComponent back=new EmptySlotComponent();
                back.setChessColor(ChessColor.NONE);
                back.setName('_');

                return back;

        }


        return null;

    }
    public ChessColor transColor(Character a){
        if(a=='w'){
            return ChessColor.WHITE;
        }
        if(a=='b'){
            return ChessColor.BLACK;
        }
        return ChessColor.NONE;
    }
    public String transColor(ChessColor a){
        if(a==ChessColor.BLACK){
            return "b";
        }
        if(a==ChessColor.WHITE){
            return "w";
        }
        return null;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j]=transfer(chessboard.get(i).charAt(j)) ;
                chessComponents[i][j].setSource(new ChessboardPoint(i,j));
            }
        }
        this.currentPlayer=transColor(chessboard.get(8).charAt(0));
    }

    @Override
    public ChessColor getCurrentPlayer() {
//        if(currentPlayer==ChessColor.WHITE){
//            return ChessColor.BLACK;
//        }
//        if(currentPlayer==ChessColor.BLACK){
//        }
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder out=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                out.append(BackTransfer(chessComponents[i][j]));

            }
            out.append("\n");
        }
        return out.toString();

    }
    public static int toCount(String a,String b) {
        String str1 = a.replaceAll(b, "");
        int len1 = a.length(),len2 = str1.length(),len3 =b.length();
        int count = (len1 - len2) / len3;
        return count;
    }


    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder out= new StringBuilder();
        if(player==ChessColor.BLACK){
            String toTest=getChessboardGraph();
            int[] num=new int[6];
            String[] match=new String[6];
            match[0]="K";
            match[1]="Q";
            match[2]="R";
            match[3]="B";
            match[4]="N";
            match[5]="P";
            num[0]=1-toCount(toTest,"K");
            num[1]=1-toCount(toTest,"Q");
            num[2]=2-toCount(toTest,"R");
            num[3]=2-toCount(toTest,"B");
            num[4]=2-toCount(toTest,"N");
            num[5]=8-toCount(toTest,"P");

            for (int i = 0; i <6 ; i++) {
                if(num[i]!=0){
                    out.append(match[i]);
                    out.append(" ");
                    out.append(num[i]);
                    out.append("\n");
                }

            }
        }
        if(player==ChessColor.WHITE){
            String toTest=getChessboardGraph();
            int[] num=new int[6];
            String[] match=new String[6];
            match[0]="k";
            match[1]="q";
            match[2]="r";
            match[3]="b";
            match[4]="n";
            match[5]="p";
            num[0]=1-toCount(toTest,"k");
            num[1]=1-toCount(toTest,"q");
            num[2]=2-toCount(toTest,"r");
            num[3]=2-toCount(toTest,"b");
            num[4]=2-toCount(toTest,"n");
            num[5]=8-toCount(toTest,"p");

            for (int i = 0; i <6 ; i++) {
                if(num[i]!=0){
                    out.append(match[i]);
                    out.append(" ");
                    out.append(num[i]);
                    out.append("\n");
                }

            }
        }
        return out.toString();
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent toMove= getChess(source.getX(),source.getY());

        return toMove.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        
        boolean CanMove=false;
        if(!(sourceX >= 0 && sourceY >= 0 && targetX >= 0 && targetY >= 0 && sourceX < 8 && sourceY < 8 && targetX < 8 && targetY < 8)){
            return false;
        }
        if(currentPlayer!=chessComponents[sourceX][sourceY].getChessColor()){
            return false;
        }
        List<ChessboardPoint> toMove=chessComponents[sourceX][sourceY].canMoveTo();
        for (int i = 0; i < toMove.size(); i++) {
            if(toMove.get(i).getX()==targetX&&toMove.get(i).getY()==targetY){
                ChessComponent back=new EmptySlotComponent();
                back.setChessColor(ChessColor.NONE);
                back.setName('_');
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
                back.setSource(new ChessboardPoint(sourceX,sourceY));
                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY]=back;

                currentPlayer=((currentPlayer == ChessColor.WHITE) ? ChessColor.BLACK : ChessColor.WHITE);


                return true;

            }

        }
        return false;
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }


    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> KnightCanMove=new ArrayList<ChessboardPoint>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((((2*Math.abs(getSource().getX()-i)==Math.abs(getSource().getY()-j))&&Math.abs(getSource().getY()-j)==2)||(2*Math.abs(getSource().getY()-j)==Math.abs(getSource().getX()-i)&&Math.abs(getSource().getX()-i)==2))&&(getNowBoard()[i][j].getChessColor()!=this.getChessColor())){
                    KnightCanMove.add(new ChessboardPoint(i,j));
                }
            }
        }
        return KnightCanMove;

    }


}
