
import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
       int Oc=0;int Ic=0;
       for (Oc=0;Oc<8;Oc++){
           for (Ic=0;Ic<8;Ic++){
               if (chessboard.get(Oc).charAt(Ic)=='k')
               {this.chessComponents[Oc][Ic]=new KingChessComponent();
               this.chessComponents[Oc][Ic].setChessColor(ChessColor.WHITE);
                   this.chessComponents[Oc][Ic].setName('k');}
              else if (chessboard.get(Oc).charAt(Ic)=='K')
               {this.chessComponents[Oc][Ic]=new KingChessComponent();
                   this.chessComponents[Oc][Ic].setChessColor(ChessColor.BLACK);
                   this.chessComponents[Oc][Ic].setName('K');}
               else if (chessboard.get(Oc).charAt(Ic)=='b')
               {this.chessComponents[Oc][Ic]=new BishopChessComponent();
                   this.chessComponents[Oc][Ic].setChessColor(ChessColor.WHITE);
                   this.chessComponents[Oc][Ic].setName('b');}
               else if (chessboard.get(Oc).charAt(Ic)=='B')
               {this.chessComponents[Oc][Ic]=new BishopChessComponent();
                   this.chessComponents[Oc][Ic].setChessColor(ChessColor.BLACK);
                   this.chessComponents[Oc][Ic].setName('B');}
               else if (chessboard.get(Oc).charAt(Ic)=='r')
               {this.chessComponents[Oc][Ic]=new RookChessComponent();
                   this.chessComponents[Oc][Ic].setChessColor(ChessColor.WHITE);
                   this.chessComponents[Oc][Ic].setName('r');}
               else if (chessboard.get(Oc).charAt(Ic)=='R')
               {this.chessComponents[Oc][Ic]=new RookChessComponent();
                   this.chessComponents[Oc][Ic].setChessColor(ChessColor.BLACK);
                   this.chessComponents[Oc][Ic].setName('R');}
               else if (chessboard.get(Oc).charAt(Ic)=='n')
               {this.chessComponents[Oc][Ic]=new KnightChessComponent();
                   this.chessComponents[Oc][Ic].setChessColor(ChessColor.WHITE);
                   this.chessComponents[Oc][Ic].setName('n');}
               else  if (chessboard.get(Oc).charAt(Ic)=='N')
               {this.chessComponents[Oc][Ic]=new KnightChessComponent();
                   this.chessComponents[Oc][Ic].setChessColor(ChessColor.BLACK);
                   this.chessComponents[Oc][Ic].setName('N');}
               else  if (chessboard.get(Oc).charAt(Ic)=='p')
               {this.chessComponents[Oc][Ic]=new PawnChessComponent();
                   this.chessComponents[Oc][Ic].setChessColor(ChessColor.WHITE);
                   this.chessComponents[Oc][Ic].setName('p');}
               else  if (chessboard.get(Oc).charAt(Ic)=='P')
               {this.chessComponents[Oc][Ic]=new PawnChessComponent();
                   this.chessComponents[Oc][Ic].setChessColor(ChessColor.BLACK);
                   this.chessComponents[Oc][Ic].setName('P');}
               else  if (chessboard.get(Oc).charAt(Ic)=='q')
               {this.chessComponents[Oc][Ic]=new QueenChessComponent();
                   this.chessComponents[Oc][Ic].setChessColor(ChessColor.WHITE);
                   this.chessComponents[Oc][Ic].setName('q');}
               else if (chessboard.get(Oc).charAt(Ic)=='Q')
               {this.chessComponents[Oc][Ic]=new QueenChessComponent();
                   this.chessComponents[Oc][Ic].setChessColor(ChessColor.BLACK);
                   this.chessComponents[Oc][Ic].setName('Q');}
               else if (chessboard.get(Oc).charAt(Ic)=='_')
               {this.chessComponents[Oc][Ic]=new EmptySlotComponent();
                   this.chessComponents[Oc][Ic].setChessColor(ChessColor.NONE);
                   this.chessComponents[Oc][Ic].setName('_');}

               chessComponents[Oc][Ic].setSource(new ChessboardPoint(Oc,Ic));
              this.chessComponents[Oc][Ic].setChessboard(this.chessComponents);

           }
       }
           if (chessboard.get(8).charAt(0)=='w'){this.currentPlayer=ChessColor.WHITE;}
           else if (chessboard.get(8).charAt(0)=='b'){this.currentPlayer=ChessColor.BLACK;}



    }


    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    @Override
    public ChessComponent getChess(int x, int y) {
       return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String Chessboard="";
        int Oc=0;int Ic=0;
        for (Oc=0;Oc<8;Oc++) {
            for (Ic = 0; Ic < 8; Ic++) {
                String stm=String.valueOf(this.chessComponents[Oc][Ic].getName());
                Chessboard=Chessboard.concat(stm);
            }
            Chessboard=Chessboard.concat("\n");
        }
        return Chessboard;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String str="";
        int numK=1;int numQ=1;int numR=2;int numB=2;int numN=2;int numP=8;
        int numk=1;int numq=1;int numr=2;int numb=2;int numn=2;int nump=8;
        int Oc=0;int Ic=0;
        for (Oc=0;Oc<8;Oc++) {
            for (Ic = 0; Ic < 8; Ic++) {
                if (chessComponents[Oc][Ic].getName()=='K'){numK--;}
                if (chessComponents[Oc][Ic].getName()=='Q'){numQ--;}
                if (chessComponents[Oc][Ic].getName()=='R'){numR--;}
                if (chessComponents[Oc][Ic].getName()=='B'){numB--;}
                if (chessComponents[Oc][Ic].getName()=='N'){numN--;}
                if (chessComponents[Oc][Ic].getName()=='P'){numP--;}
                if (chessComponents[Oc][Ic].getName()=='k'){numk--;}
                if (chessComponents[Oc][Ic].getName()=='q'){numq--;}
                if (chessComponents[Oc][Ic].getName()=='r'){numr--;}
                if (chessComponents[Oc][Ic].getName()=='b'){numb--;}
                if (chessComponents[Oc][Ic].getName()=='n'){numn--;}
                if (chessComponents[Oc][Ic].getName()=='p'){nump--;}
            }
        }
        if (player==ChessColor.BLACK){
            if (numK>0){str=str+"K "+numK+"\n";}
            if (numQ>0){str=str+"Q "+numQ+"\n";}
            if (numR>0){str=str+"R "+numR+"\n";}
            if (numB>0){str=str+"B "+numB+"\n";}
            if (numN>0){str=str+"N "+numN+"\n";}
            if (numP>0){str=str+"P "+numP+"\n";}
        }
        if (player==ChessColor.WHITE){
            if (numk>0){str=str+"k "+numk+"\n";}
            if (numq>0){str=str+"q "+numq+"\n";}
            if (numr>0){str=str+"r "+numr+"\n";}
            if (numb>0){str=str+"b "+numb+"\n";}
            if (numn>0){str=str+"n "+numn+"\n";}
            if (nump>0){str=str+"p "+nump+"\n";}
        }


        return str;
    }


    //sort
    public List<ChessboardPoint> chessSort(List<ChessboardPoint> input){
        List<ChessboardPoint> source=input;
        for (int i=0;i<source.size();i++){
            for (int j=0;j<source.size()-1;j++){
                if (source.get(j).getX()*10+source.get(j).getY()>source.get(j+1).getX()*10+source.get(j+1).getY()){
                    ChessboardPoint A=source.get(j+1);
                    source.set(j+1,source.get(j));
                    source.set(j,A);
                }
            }
        }
        return source;
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess=getChess(source.getX(),source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints=chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        List<ChessboardPoint> ans=chessSort(canMovePoints);
        return ans;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean ans=false;

     for (int i=0;i<chessComponents[sourceX][sourceY].canMoveTo().size();i++){
         if (this.currentPlayer!=chessComponents[sourceX][sourceY].getChessColor()){ans=false;}
         else
         if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==chessComponents[targetX][targetY].getSource().getX()&&chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==chessComponents[targetX][targetY].getSource().getY()){
            
             this.chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
            this.chessComponents[sourceX][sourceY]=new EmptySlotComponent();
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
            chessComponents[targetX][targetY].setChessboard(this.chessComponents);
            chessComponents[sourceX][sourceY].setChessboard(this.chessComponents);
             if (this.currentPlayer==ChessColor.WHITE){this.currentPlayer=ChessColor.BLACK;}
           else if (this.currentPlayer==ChessColor.BLACK){this.currentPlayer=ChessColor.WHITE;}
           
            ans=true;
            break;
            }
    }
     return ans;
  }
}
