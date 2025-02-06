import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {


    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    /**
     * A 2-dimension array to store all the chess components
     * should be initialized in your construct method.
     * i.e. = new ChessComponent[8][8]
     */
    private ChessComponent[][] chessComponents;

    /**
     * What's the current player's color, black or white?
     * should be initialized in your construct method.
     * by default, set the color to white.
     */
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public static ChessComponent alphabet2Chess(String input){
        ChessComponent chess;
        ChessColor white = ChessColor.WHITE;
        ChessColor black = ChessColor.BLACK;
        ChessColor none = ChessColor.NONE;
        switch (input){

            case "R" : return chess = new RookChessComponent(black);
            case "r" : return chess = new RookChessComponent(white);

            case "N" : return chess = new KnightChessComponent(black);
            case "n" : return chess = new KnightChessComponent(white);

            case "B" : return chess = new BishopChessComponent(black);
            case "b" : return chess = new BishopChessComponent(white);

            case "Q" : return chess = new QueenChessComponent(black);
            case "q" : return chess = new QueenChessComponent(white);

            case "K" : return chess = new KingChessComponent(black);
            case "k" : return chess = new KingChessComponent(white);

            case "P" : return chess = new PawnChessComponent(black);
            case "p" : return chess = new PawnChessComponent(white);

            case "_" : return chess = new EmptySlotComponent();
            default:
        }
        return null;
    }

    public static String Chess2Alphabet(ChessComponent input){
        if(input instanceof EmptySlotComponent){
            return "_";
        }
        if(input instanceof BishopChessComponent){
            if(input.getChessColor()==ChessColor.WHITE){
                return "b";
            }else if(input.getChessColor()==ChessColor.BLACK){
                return "B";
            }
        }else if(input instanceof QueenChessComponent){
            if(input.getChessColor()==ChessColor.WHITE){
                return "q";
            }else if(input.getChessColor()==ChessColor.BLACK){
                return "Q";
            }
        }else if(input instanceof PawnChessComponent){
            if(input.getChessColor()==ChessColor.WHITE){
                return "p";
            }else if(input.getChessColor()==ChessColor.BLACK){
                return "P";
            }
        }else if (input instanceof KingChessComponent){
            if(input.getChessColor()==ChessColor.WHITE){
                return "k";
            }else if(input.getChessColor()==ChessColor.BLACK){
                return "K";
            }
        }else if(input instanceof KnightChessComponent){
            if(input.getChessColor()==ChessColor.WHITE){
                return "n";
            }else if(input.getChessColor()==ChessColor.BLACK){
                return "N";
            }
        }else if(input instanceof RookChessComponent){
            if(input.getChessColor()==ChessColor.WHITE){
                return "r";
            }else if(input.getChessColor()==ChessColor.BLACK){
                return "R";
            }
        }
        System.out.println("wtf, why run here?");
        return null;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessComponents.length; i++) {
            String[] row = chessboard.get(i).split("");
            for (int j = 0; j < chessComponents.length; j++) {
                chessComponents[i][j] = alphabet2Chess(row[j]);
                ChessboardPoint source = new ChessboardPoint(i,j);
                chessComponents[i][j].setSource(source);

                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
        switch (chessboard.get(8)){
            case "b" : currentPlayer = ChessColor.BLACK;break;
            case "w" : currentPlayer = ChessColor.WHITE;break;
            default:
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        if(x<0||x>7||y<0||y>7){
            return null;
        }
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[0].length; j++) {
                String temp = Chess2Alphabet(chessComponents[i][j]);
                output.append(temp);
            }
            output.append("\n");
        }
        return String.valueOf(output);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder temp1 = new StringBuilder();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[0].length; j++) {
                ChessComponent temp = chessComponents[i][j];
                if(! (temp instanceof EmptySlotComponent)){
                    if(temp.getChessColor()==player){
                        temp1.append(Chess2Alphabet(temp));
                    }
                }
            }
        }
        int kcnt = 0;
        int qcnt = 0;
        int bcnt = 0;
        int ncnt = 0;
        int rcnt = 0;
        int pcnt = 0;
        String temp2;
        for (int i = 0; i < temp1.length(); i++) {

            temp2 = String.valueOf(temp1.charAt(i));
            switch (temp2){
                case "k" :
                case "K" :
                    kcnt++;break;
                case "q":
                case "Q":
                    qcnt++;break;
                case "b":
                case "B":bcnt++;break;
                case "n":
                case"N": ncnt++;break;
                case "r":
                case"R":rcnt++;break;
                case"p":
                case"P":
                    pcnt++;break;
                default:
            }
        }

        StringBuilder output = new StringBuilder();
        //omg, fantastic.
        output.append(getdeadformat("k",player,1,kcnt));
        output.append(getdeadformat("q",player,1,qcnt));
        output.append(getdeadformat("r",player,2,rcnt));
        output.append(getdeadformat("b",player,2,bcnt));
        output.append(getdeadformat("n",player,2,ncnt));
        output.append(getdeadformat("p",player,8,pcnt));

        return String.valueOf(output);
    }

    public String getdeadformat(String alphatype,ChessColor currentPlayer,int maxnum,int thisnum){
        if(maxnum<=thisnum){
            return "";
        }else{
            int deadnum = maxnum-thisnum;
            String type = null;
            if(currentPlayer==ChessColor.BLACK){
                type = alphatype.toUpperCase();
            }else{
                type = alphatype.toLowerCase();
            }
            String output = String.format("%s %d\n",type,deadnum);
            return output;
        }
    }

    public static void sort(List<ChessboardPoint> input){

        if(input.size()<=1){
            return;
        }

        //x-sort
        for (int h = 0; h < input.size(); h++) {
            for (int i = 0; i < input.size(); i++) {
                for (int j = i+1; j < input.size(); j++) {
                    if(j>=input.size()){
                        break;
                    }
                    ChessboardPoint point1 = input.get(j-1);
                    ChessboardPoint point2 = input.get(j);
                    ChessboardPoint temp;
                    if(point1.getX()<=point2.getX()){
                        continue;
                    }else{
                        temp = new ChessboardPoint(point2.getX(),point2.getY());
                        point2 = new ChessboardPoint(point1.getX(),point1.getY());
                        point1 = new ChessboardPoint(temp.getX(), temp.getY());
                        input.set(j-1,point1);
                        input.set(j,point2);
                    }
                }
            }
        }

        //y-sort
        for (int h = 0; h < input.size(); h++) {
            for (int i = 0; i < input.size(); i++) {
                for (int j = 1; j < input.size(); j++) {
                    if(j>=input.size()){
                        break;
                    }
                    ChessboardPoint point1 = input.get(j-1);
                    ChessboardPoint point2 = input.get(j);
                    ChessboardPoint temp;
                    if(point1.getX()==point2.getX()&&point1.getY()>point2.getY()){
                        temp = new ChessboardPoint(point2.getX(),point2.getY());
                        point2 = new ChessboardPoint(point1.getX(),point1.getY());
                        point1 = new ChessboardPoint(temp.getX(), temp.getY());
                        input.set(j-1,point1);
                        input.set(j,point2);
                    }
                }
            }
        }


    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        // 1. find chess according to source
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        if(source.getX()<0||source.getX()>7||source.getY()<0||source.getY()>7){
            return null;
        }
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        sort(canMovePoints);

        return canMovePoints;
    }

    public void swapChessComponents(ChessComponent chess1,ChessComponent chess2){
        ChessboardPoint point1 = new ChessboardPoint(chess1.getSource().getX(),chess1.getSource().getY());
        ChessboardPoint point2 = new ChessboardPoint(chess2.getSource().getX(),chess2.getSource().getY());

        chess1.setSource(point2);
        chess2.setSource(point1);
        
        if(chess1.getChessColor()!=chess2.getChessColor()&&chess2.getChessColor()!=ChessColor.NONE){
            chess2 = new EmptySlotComponent(chess2.getSource());
        }
        
        chessComponents[point1.getX()][point1.getY()] = chess2;
        chessComponents[point2.getX()][point2.getY()] = chess1;

        
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(!(targetX>=0&&targetX<=8&&targetY>=0&&targetY<=8)){
            return false;
        }
        if(!(sourceX>=0&&sourceX<=8&&sourceY>=0&&sourceY<=8)){
            return false;
        }

        ChessComponent source = chessComponents[sourceX][sourceY];

        ChessComponent dest = chessComponents[targetX][targetY];
        if(dest.getChessColor()==source.getChessColor()||source.getChessColor()!=currentPlayer){
            return false;
        }
        ChessboardPoint destination = new ChessboardPoint(targetX,targetY);
        ArrayList<ChessboardPoint> legalpoints = (ArrayList<ChessboardPoint>) source.canMoveTo();
        for (int i = 0; i < legalpoints.size(); i++) {
            if(legalpoints.get(i).getX()==destination.getX()&&legalpoints.get(i).getY()==destination.getY()){
                currentPlayer= currentPlayer==ChessColor.WHITE?ChessColor.BLACK:ChessColor.WHITE;
                swapChessComponents(source,dest);
                return true;
            }
        }
        return false;
    }
}
