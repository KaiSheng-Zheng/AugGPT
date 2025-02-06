import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    private ChessColor chessColor;
    private ChessComponent[][] chessComponents;

    public QueenChessComponent() {
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
        int m11=X;int m22=X;int m33=X;int m44=X; int n11=Y;int n22=Y;int n33=Y;int n44=Y;
        int m1=X;int m2=X;int m3=X;int m4=X; int n1=Y;int n2=Y;int n3=Y;int n4=Y;
        int k1=0;int k2=0;int k3=0;int k4=0;
        int k45=0;int k135=0;int k225=0;int k315=0;
        ChessboardPoint byPass;
        int leftXNum = X; int rightXNum=7-X;       int leftFarReach = 0; int rightFarReach = 0;
        int upYNum = Y;  int downYNum = 7-Y;       int upFarReach = 0;    int downFarReach = 0;
        //for  X;
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

        if(X*Y==0||X==7||Y==7){
            if(X==0){
                k1=-1;k2=-1;
                k45=-1;k135=-1;
                while (m33 < 7 && n33 > 0) {
                    m33 += 1;
                    n33 -= 1;
                    k3++;
                }
                while (m44 < 7 && n44 < 7) {
                    m44 += 1;
                    n44 += 1;
                    k4++;
                }
            }

            if(Y==0){
                k2=-1;k3=-1;
                k135=-1;k225=-1;
                if(k1>=0) {
                    while (m11 > 0 && n11 < 7) {
                        m11 -= 1;
                        n11 += 1;
                        k1++;
                    }
                }
                if(k4>=0) {
                    while (m44 < 7 && n44 < 7) {
                        m44 += 1;
                        n44 += 1;
                        k4++;
                    }
                }
            }

            if(Y==7){
                k1=-1;k4=-1;
                k45=-1;k315=-1;
                if(k2>=0) {
                    while (m22 > 0 && n22 > 0) {
                        m22 -= 1;
                        n22 -= 1;
                        k2++;
                    }
                }
                if(k3>=0) {
                    while (m33 < 7 && n33 > 0) {
                        m33 += 1;
                        n33 -= 1;
                        k3++;
                    }
                }
            }
            if(X==7){
                k3=-1;k4=-1;
                k225=-1;k315=-1;
                if(k2>=0) {
                    while (m22 > 0 && n22 > 0) {
                        m22 -= 1;
                        n22 -= 1;
                        k2++;
                    }
                }
                if(k1>=0) {
                    while (m11 > 0 && n11 < 7) {
                        m11 -= 1;
                        n11 += 1;
                        k1++;
                    }
                }
            }
        }
        else {
            while (m1 * n1 > 0 && m1 > 0 && n1 < 7) {
                m1 -= 1;
                n1 += 1;
                k1++;
            }
            while (m2 * n2 > 0 && m2 > 0 && n2 > 0) {
                m2 -= 1;
                n2 -= 1;
                k2++;
            }
            while (m3 * n3 > 0 && m3 < 7 && n3 > 0) {
                m3 += 1;
                n3 -= 1;
                k3++;
            }
            while (m4 * n4 > 0 && m4 < 7 && n4 < 7) {
                m4 += 1;
                n4 += 1;
                k4++;
            }
        }

        int count45 = 0;
        if(k1>=1) {
            for (int i = 1; i <= k1; i++) {
                if (situation[X - i][Y + i] instanceof EmptySlotComponent) {
                    count45++;
                }
                if (!(situation[X - i][Y + i] instanceof EmptySlotComponent) && !(situation[X - i][Y + i].getChessColor().equals(color))) {
                    k45 = i;
                    break;
                }
                if (!(situation[X - i][Y + i] instanceof EmptySlotComponent) && color.equals(situation[X - i][Y + i].getChessColor())) {
                    k45 = i - 1;
                    if (k45 == 0) {
                        k45 = -1;
                    }
                    break;
                }
            }
        }
        if (count45 == k1) {
            k45 = k1;
        }

        int count135 = 0;
        if(k2>=1) {
            for (int i = 1; i <= k2; i++) {
                if (situation[X - i][Y - i] instanceof EmptySlotComponent) {
                    count135++;
                }
                if (!(situation[X - i][Y - i] instanceof EmptySlotComponent) && !(color.equals(situation[X - i][Y - i].getChessColor()))) {
                    k135 = i;
                    break;
                }
                if (!(situation[X - i][Y - i] instanceof EmptySlotComponent) && color.equals(situation[X - i][Y - i].getChessColor())) {
                    k135 = i - 1;
                    if (k135 == 0) {
                        k135 = -1;
                    }
                    break;
                }
            }
            if (count135 == k2) {
                k135 = k2;
            }
        }

        int count225 = 0;
        if(k3>=1) {
            for (int i = 1; i <= k3; i++) {
                if (situation[X + i][Y - i] instanceof EmptySlotComponent) {
                    count225++;
                }
                if (!(situation[X + i][Y - i] instanceof EmptySlotComponent) && !(color.equals(situation[X + i][Y - i].getChessColor()))) {
                    k225 = i;
                    break;
                }
                if (!(situation[X + i][Y - i] instanceof EmptySlotComponent) && color.equals(situation[X + i][Y - i].getChessColor())) {
                    k225 = i - 1;
                    if (k225 == 0) {
                        k225 = -1;
                    }
                    break;
                }
            }
            if (count225 == k3) {
                k225 = k3;
            }
        }

        int count315 = 0;
        if(k4>=1) {
            for (int i = 1; i <= k4; i++) {
                if (situation[X + i][Y + i] instanceof EmptySlotComponent) {
                    count315++;
                }
                if (!(situation[X + i][Y + i] instanceof EmptySlotComponent) && !(color.equals(situation[X + i][Y + i].getChessColor()))) {
                    k315 = i;
                    break;
                }
                if (!(situation[X + i][Y + i] instanceof EmptySlotComponent) && color.equals(situation[X + i][Y + i].getChessColor())) {
                    k315 = i - 1;
                    if (k315 == 0) {
                        k315 = -1;
                    }
                    break;
                }
            }
            if (count315 == k4) {
                k315 = k4;
            }
        }


        if(X==0 && rightFarReach>=1) {
            for (int i=1;i<=rightFarReach;i++){
                byPass=new ChessboardPoint(i,Y);
                a.add(byPass);
            }
        }
        if(X==7 && leftFarReach<=6){
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
        if(Y==7 && upFarReach<=6){
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
        if(k45>=1){
            for(int i=1;i<=k45;i++){
                byPass=new ChessboardPoint(X-i,Y+i);
                a.add(byPass);
            }
        }
        if(k135>=1){
            for(int i=1;i<=k135;i++){
                byPass=new ChessboardPoint(X-i,Y-i);
                a.add(byPass);
            }
        }
        if(k225>=1){
            for(int i=1;i<=k225;i++){
                byPass=new ChessboardPoint(X+i,Y-i);
                a.add(byPass);
            }
        }
        if(k315>=1){
            for(int i=1;i<=k315;i++){
                byPass=new ChessboardPoint(X+i,Y+i);
                a.add(byPass);
            }
        }
        return a;
    }
}

