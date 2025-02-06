import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;


public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];


    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        } else {
            this.currentPlayer = ChessColor.BLACK;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Objects.equals(chessboard.get(i).charAt(j), 'r') || Objects.equals(chessboard.get(i).charAt(j), 'R')) {
                    this.chessComponents[i][j] =new RookChessComponent();
                } else if (chessboard.get(i).charAt(j) == '_') {
                    this.chessComponents[i][j] =new EmptySlotComponent();
                } else if (chessboard.get(i).charAt(j) == 'N' || chessboard.get(i).charAt(j) == 'n') {
                    this.chessComponents[i][j] = new  KnightChessComponent();
                } else if (chessboard.get(i).charAt(j) == 'K' || chessboard.get(i).charAt(j) == 'k') {
                    this.chessComponents[i][j] = new KingChessComponent();
                } else if (chessboard.get(i).charAt(j) == 'B' || chessboard.get(i).charAt(j) == 'b') {
                    this.chessComponents[i][j] =new  BishopChessComponent();
                } else if (chessboard.get(i).charAt(j) == 'Q' || chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new  QueenChessComponent();
                } else if (chessboard.get(i).charAt(j) == 'P' || chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new  PawnChessComponent();
                }
                this.chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                if (chessboard.get(i).charAt(j) == '_') {
                    this.chessComponents[i][j].setChessColor(ChessColor.NONE);
                }

                if (chessboard.get(i).charAt(j) >= 'A' && chessboard.get(i).charAt(j) <= 'Z') {
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                }
                if (chessboard.get(i).charAt(j) >= 'a' && chessboard.get(i).charAt(j) <= 'z') {
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                }
            }
        }       ChessComponent.setChessComponents(chessComponents.clone());


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
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
              s.append(chessComponents[i][j].getName());
                }
            }
        String b = s.toString();

        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", b.substring(0, 8), b.substring(8, 16),
                b.substring(16, 24), b.substring(24, 32), b.substring(32, 40), b.substring(40, 48), b.substring(48, 56),
                b.substring(56)
        );

    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int r=0,n = 0,k = 0,b = 0,q = 0,p = 0;
        String s = "";
        if (player.getColor()== Color.WHITE){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName()=='k'){
                        k+=1;
                    }
                    if (chessComponents[i][j].getName()=='r'){
                        r+=1;
                    }
                    if (chessComponents[i][j].getName()=='n'){
                        n+=1;
                    }
                    if (chessComponents[i][j].getName()=='b'){
                        b+=1;
                    }
                    if (chessComponents[i][j].getName()=='q'){
                        q+=1;
                    }
                    if (chessComponents[i][j].getName()=='p'){
                        p+=1;
                    }
                }
            }
            k=1-k; q=1-q; r=2-r; b=2-b; n = 2-n; p=8-p;
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                arrayList.add(String.format("k %d\n",k));
                arrayList.add(String.format("q %d\n",q));
                arrayList.add(String.format("r %d\n",r));
                arrayList.add(String.format("b %d\n",b));
                arrayList.add(String.format("n %d\n",n));
                arrayList.add(String.format("p %d",p));
            }StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                if (Integer.parseInt(String.valueOf(arrayList.get(i).charAt(2)))>0) {
                    builder.append(arrayList.get(i));
                }
            } s = builder.toString();
            return String.format(s);
        }else if (player.getColor()== Color.BLACK){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName()=='K'){
                        k+=1;
                    }
                    if (chessComponents[i][j].getName()=='R'){
                        r+=1;
                    }
                    if (chessComponents[i][j].getName()=='N'){
                        n+=1;
                    }
                    if (chessComponents[i][j].getName()=='B'){
                        b+=1;
                    }
                    if (chessComponents[i][j].getName()=='Q'){
                        q+=1;
                    }
                    if (chessComponents[i][j].getName()=='P'){
                        p+=1;
                    }
                }
            }
            k=1-k; q=1-q; r=2-r; b=2-b; n = 2-n; p=8-p;
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                arrayList.add(String.format("K %d\n",k));
                arrayList.add(String.format("Q %d\n",q));
                arrayList.add(String.format("R %d\n",r));
                arrayList.add(String.format("B %d\n",b));
                arrayList.add(String.format("N %d\n",n));
                arrayList.add(String.format("P %d",p));
            }StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                if (Integer.parseInt(String.valueOf(arrayList.get(i).charAt(2)))>0) {
                    builder.append(arrayList.get(i));
                }
            } s = builder.toString();
            return String.format(s);
        }


        return String.format(s);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        // 2. as below statement:
        String s;
        String k;
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        for (int j= 0; j< canMovePoints.size()-1; j++) {
            for (int i = 0; i < canMovePoints.size()-1; i++) {
                    if (canMovePoints.get(i).toString().charAt(1)>canMovePoints.get(i+1).toString().charAt(1)){
                         s = canMovePoints.get(i).toString();
                        canMovePoints.set(i,canMovePoints.get(i+1));
                        canMovePoints.set(i+1, new ChessboardPoint(Integer.parseInt(String.valueOf(s.charAt(1)))
                                ,Integer.parseInt(String.valueOf(s.charAt(3)))));
                    }
            }
        }

        for (int j= 0; j< canMovePoints.size()-1; j++) {
            for (int i = 0; i < canMovePoints.size()-1; i++) {
                if (canMovePoints.get(i).toString().charAt(1)==canMovePoints.get(i+1).toString().charAt(1)){
                    if (canMovePoints.get(i).toString().charAt(3)>canMovePoints.get(i+1).toString().charAt(3)){
                         k = canMovePoints.get(i).toString();
                        canMovePoints.set(i,canMovePoints.get(i+1));
                        canMovePoints.set(i+1, new ChessboardPoint(Integer.parseInt(String.valueOf(k.charAt(1)))
                                ,Integer.parseInt(String.valueOf(k.charAt(3)))));
                    }
                }
            }
        }


        return canMovePoints;


    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor()!=this.currentPlayer){
            return false;
        }
        boolean move = false;
        for (ChessboardPoint chessboardPoint :chessComponents[sourceX][sourceY].canMoveTo()) {
            if (chessboardPoint.getX()==targetX && chessboardPoint.getY()==targetY){
                move = true;
            }
        }
        if (move==true){
            chessComponents[targetX][targetY]=this.chessComponents[sourceX][sourceY];
            this.chessComponents[sourceX][sourceY] = new EmptySlotComponent();
            chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
            chessComponents[sourceX][sourceY].setName('_');
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            if (this.currentPlayer==ChessColor.WHITE){
                this.currentPlayer = ChessColor.BLACK;
            }else if (this.currentPlayer==ChessColor.BLACK){
                this.currentPlayer = ChessColor.WHITE;
            }
            ChessComponent.setChessComponents(this.chessComponents);
            
        }
        return move;
    }



    }

