import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    private ChessColor chessColor;
    private ChessComponent[][] chessComponents;

    public RookChessComponent() {
        super();
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }



    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint location = getSource();
        ChessComponent[][] situation = chessComponents;
        ChessColor color = chessColor;
        int Y = location.getX(); int X = location.getY();
        List<ChessboardPoint> a = new ArrayList<>();
        int leftXNum = X; int rightXNum=7-X;       int leftFarReach = 0; int rightFarReach = 0;
        int upYNum = Y;  int downYNum = 7-Y;       int upFarReach = 0;    int downFarReach = 0;

        if (X == 0) {
            leftFarReach = -1;
            int count = 0;
            for (int i = X + 1; i <= 7; i++) {
                if (situation[i][Y] instanceof EmptySlotComponent) {
                    count++;
                }
                if ((!(situation[i][Y] instanceof EmptySlotComponent)) && !(situation[i][Y].getChessColor().equals(color)) ) {
                    rightFarReach = i;
                    break;
                }
                if ((!(situation[i][Y] instanceof EmptySlotComponent)) && situation[i][Y].getChessColor().equals(color) ) {
                    rightFarReach=i-1;
                    if(X==rightFarReach){
                        rightFarReach=-1;
                    }
                    break;
                }
            }
            if (count == rightXNum) {
                rightFarReach = 7;
            }
        }

        else {
            if (X < 7) {
                int countLeft = 0;
                for (int i = X - 1; i >= 0; i--) {
                    if (situation[i][Y] instanceof EmptySlotComponent) {
                        countLeft++;
                    }
                    if (!(situation[i][Y] instanceof EmptySlotComponent) && !(situation[i][Y].getChessColor().equals(color)) ){
                        leftFarReach = i;
                        break;
                    }
                    if ((!(situation[i][Y] instanceof EmptySlotComponent)) && situation[i][Y].getChessColor().equals(color) ){
                        leftFarReach=i+1;
                        if(X==leftFarReach){
                            leftFarReach=-1;
                        }
                        break;
                    }
                }
                if (countLeft == leftXNum) {
                    leftFarReach = 0;
                }
                int countRight = 0;
                for (int i = X + 1; i <= 7; i++) {
                    if (situation[i][Y] instanceof EmptySlotComponent) {
                        countRight++;
                    }
                    if (!(situation[i][Y] instanceof EmptySlotComponent) && situation[i][Y].getChessColor()!=color) {
                        rightFarReach = i;
                        break;
                    }
                    if ((!(situation[i][Y] instanceof EmptySlotComponent)) && situation[i][Y].getChessColor().equals(color) ){
                        rightFarReach=i-1;
                        if(X==rightFarReach){
                            rightFarReach=-1;
                        }
                        break;
                    }
                }
                if (countRight == rightXNum) {
                    rightFarReach = 7;
                }
            }

            else if (X == 7) {
                rightFarReach = -1;
                int count = 0;
                for (int i = X - 1; i >=0; i--) {
                    if (situation[i][Y] instanceof EmptySlotComponent) {
                        count++;
                    }
                    if (!(situation[i][Y] instanceof EmptySlotComponent) && situation[i][Y].getChessColor()!=color) {
                        leftFarReach = i;
                        break;
                    }
                    if ((!(situation[i][Y] instanceof EmptySlotComponent)) && situation[i][Y].getChessColor().equals(color) ){
                        leftFarReach=i+1;
                        if(X==leftFarReach){
                            leftFarReach=-1;
                        }
                        break;
                    }
                }
                if (count == leftXNum) {
                    leftFarReach = 0;
                }
            }
        }


        if (Y == 0) {
            upFarReach = -1;
            int count = 0;
            for (int i = Y + 1; i <= 7; i++) {
                if (situation[X][i] instanceof EmptySlotComponent) {
                    count++;
                }
                if (!(situation[X][i] instanceof EmptySlotComponent) && situation[X][i].getChessColor()!=color) {
                    downFarReach = i;
                    break;
                }
                if ((!(situation[X][i] instanceof EmptySlotComponent)) && situation[X][i].getChessColor().equals(color) ){
                    downFarReach=i-1;
                    if(Y==downFarReach){
                        downFarReach=-1;
                    }
                    break;
                }
            }
            if (count == downYNum) {
                downFarReach = 7;
            }
        }

        else {
            if (Y < 7) {
                int countUp = 0;
                for (int i = Y - 1; i >= 0; i--) {
                    if (situation[X][i] instanceof EmptySlotComponent) {
                        countUp++;
                    }
                    if (!(situation[X][i]instanceof EmptySlotComponent) && situation[X][i].getChessColor()!=color) {
                        upFarReach = i;
                        break;
                    }
                    if ((!(situation[X][i] instanceof EmptySlotComponent)) && situation[X][i].getChessColor().equals(color) ){
                        upFarReach=i+1;
                        if(Y==upFarReach){
                            upFarReach=-1;
                        }
                        break;
                    }
                }
                if (countUp == upYNum) {
                    upFarReach = 0;
                }
                int countDown = 0;
                for (int i = Y + 1; i <= 7; i++) {
                    if (situation[X][i] instanceof EmptySlotComponent) {
                        countDown++;
                    }
                    if (!(situation[X][i] instanceof EmptySlotComponent) && situation[X][i].getChessColor()!=color) {
                        downFarReach = i;
                        break;
                    }
                    if ((!(situation[X][i] instanceof EmptySlotComponent)) && situation[X][i].getChessColor().equals(color) ){
                        downFarReach=i-1;
                        if(Y==downFarReach){
                            downFarReach=-1;
                        }
                        break;
                    }
                }
                if (countDown == downYNum) {
                    downFarReach= 7;
                }
            }

            else if (Y == 7) {
                downFarReach = -1;
                int count = 0;
                for (int i = Y - 1; i >=0; i--) {
                    if (situation[X][i] instanceof EmptySlotComponent) {
                        count++;
                    }
                    if (!(situation[X][i] instanceof EmptySlotComponent) && situation[X][i].getChessColor()!=color) {
                        upFarReach = i;
                        break;
                    }
                    if ((!(situation[X][i] instanceof EmptySlotComponent)) && situation[X][i].getChessColor().equals(color) ){
                        upFarReach=i+1;
                        if(Y==upFarReach){
                            upFarReach=-1;
                        }
                        break;
                    }
                }
                if (count == upYNum) {
                    upFarReach = 0;
                }
            }
        }

        ChessboardPoint byPass;
        if(X==0 && rightFarReach>=1) {
            for (int i=1;i<=rightFarReach;i++){
                byPass=new ChessboardPoint(i,Y);
                a.add(byPass);
            }
        }
        if(X==7 && leftFarReach<=6 && leftFarReach>=0){
            for (int i=6;i>=leftFarReach;i--){
                byPass=new ChessboardPoint(i,Y);
                a.add(byPass);
            }
        }
        if(X>0&&X<7 && rightFarReach>=X){
            for (int i=X+1;i<=rightFarReach;i++){
                byPass=new ChessboardPoint(i,Y);
                a.add(byPass);
            }
        }
        if(X>0&&X<7 && leftFarReach<=X &&leftFarReach>=0){
            for (int i=X-1;i>=leftFarReach;i--){
                byPass=new ChessboardPoint(i,Y);
                a.add(byPass);
            }
        }


        if(Y==0 && downFarReach>=1) {
            for (int i=1;i<=downFarReach;i++){
                byPass=new ChessboardPoint(X,i);
                a.add(byPass);
            }
        }
        if(Y==7 && upFarReach<=6 && upFarReach>=0){
            for (int i=6;i>=upFarReach;i--){
                byPass=new ChessboardPoint(X,i);
                a.add(byPass);
            }
        }
        if(Y>0&&Y<7 && upFarReach<=Y && upFarReach>=0){
            for (int i=Y-1;i>=upFarReach;i--){
                byPass=new ChessboardPoint(X,i);
                a.add(byPass);
            }
        }
        if (Y>0&&Y<7 && downFarReach>=Y){
            for (int i=Y+1;i<=downFarReach;i++){
                byPass=new ChessboardPoint(X,i);
                a.add(byPass);
            }
        }

        return a;
    }
}

