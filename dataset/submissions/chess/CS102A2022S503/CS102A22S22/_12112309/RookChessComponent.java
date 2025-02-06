import javax.net.ssl.SSLContext;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(char name, ChessColor color, ChessboardPoint source){
        super(name,color,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints=new ArrayList<>();
        List<String> chessComponents=this.concreteChessGame.getChessBoard();
        int y= getSource().getX();
        int x= getSource().getY();
        char a=chessComponents.get(y).charAt(x);
        int num1=0;
        int num2=0;
        int num3=0;
        int num4=0;
        for (int i = y; i <8 ; i++) {
            if(num1==1){
                break;
            }
            if(y+1<8){
                if(a>'a'&&a<'z'){
                    if(chessComponents.get(i+1).charAt(x)>'a'&&chessComponents.get(i+1).charAt(x)<'z'){
                        break;
                    }
                    if(chessComponents.get(1+i).charAt(x)=='_'||chessComponents.get(1+i).charAt(x)>'A'&&chessComponents.get(1+i).charAt(x)<'Z'){
                        ChessboardPoint chessboardPoint=new ChessboardPoint(1+i,x);
                        chessboardPoints.add(chessboardPoint);
                        if(chessComponents.get(1+i).charAt(x)>'A'&&chessComponents.get(1+i).charAt(x)<'Z'){
                            num1++;
                        }
                    }}
                if(a>'A'&&a<'Z'){
                    if(chessComponents.get(1+i).charAt(x)>'A'&&chessComponents.get(1+i).charAt(x)<'Z'){
                        break;
                    }
                    if(chessComponents.get(1+i).charAt(x)=='_'||chessComponents.get(1+i).charAt(x)>'a'&&chessComponents.get(1+i).charAt(x)<'z'){
                        ChessboardPoint chessboardPoint=new ChessboardPoint(1+i,x);
                        chessboardPoints.add(chessboardPoint);
                        if(chessComponents.get(1+i).charAt(x)>'a'&&chessComponents.get(1+i).charAt(x)<'z'){
                            num1++;
                        }
                    }}
            }
            else{continue;}
        }
        for (int i = y; i>0 ; i--) {

                if(num2==1){break;}
                if(y-1>0){
                    if(a>'a'&&a<'z'){
                        if(chessComponents.get(i-1).charAt(x)>'a'&&chessComponents.get(i-1).charAt(x)<'z'){
                            break;
                        }
                        if(chessComponents.get(i-1).charAt(x)=='_'||chessComponents.get(i-1).charAt(x)>'A'&&chessComponents.get(i-1).charAt(x)<'Z'){
                            ChessboardPoint chessboardPoint=new ChessboardPoint(i-1,x);
                            chessboardPoints.add(chessboardPoint);
                            if(chessComponents.get(i-1).charAt(x)>'A'&&chessComponents.get(i-1).charAt(x)<'Z'){num2++;}
                        }}
                    if(a>'A'&&a<'Z'){
                        if(chessComponents.get(i-1).charAt(x)>'A'&&chessComponents.get(i-1).charAt(x)<'Z'){
                            break;
                        }
                        if(chessComponents.get(i-1).charAt(x)=='_'||chessComponents.get(i-1).charAt(x)>'a'&&chessComponents.get(i-1).charAt(x)<'z'){
                            ChessboardPoint chessboardPoint=new ChessboardPoint(i-1,x);
                            chessboardPoints.add(chessboardPoint);
                            if(chessComponents.get(i-1).charAt(x)>'a'&&chessComponents.get(i-1).charAt(x)<'z'){num2++;}
                        }}
                }
                else{continue;}
            }
        for (int i = x; i <8 ; i++) {

            if(num3==1){break;}
            if (x + 1 < 8) {
                if (a > 'a' && a < 'z') {
                    if(chessComponents.get(y).charAt(1 + i) > 'a' && chessComponents.get(y).charAt(1 + i) < 'z'){
                        break;
                    }
                    if (chessComponents.get(y).charAt(1 + i) == '_' || chessComponents.get(y).charAt(1 + i) > 'A' && chessComponents.get(y).charAt(1 + i) < 'Z') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(y, 1 + i);
                        chessboardPoints.add(chessboardPoint);
                        if(chessComponents.get(y).charAt(1+i)>'A'&&chessComponents.get(y).charAt(1+i)<'Z'){num3++;}
                    }
                }
                if (a > 'A' &&a < 'Z') {
                    if(chessComponents.get(y).charAt(1 + i) > 'A' && chessComponents.get(y).charAt(1 + i) < 'Z'){
                        break;
                    }
                    if (chessComponents.get(y).charAt(1 + i) == '_' || chessComponents.get(y).charAt(1 + i) > 'a' && chessComponents.get(y).charAt(1 + i) < 'z') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(y, 1 + i);
                        chessboardPoints.add(chessboardPoint);
                        if(chessComponents.get(y).charAt(1+i)>'a'&&chessComponents.get(y).charAt(1+i)<'z'){num3++;}
                    }
                }
            }
            else{continue;}
        }
        for (int i = x; i >0 ; i--) {
            if(num4==1){break;}
            if (x-1>0) {
                if (a > 'a' && a < 'z') {
                    if(chessComponents.get(y).charAt(i-1) > 'a' && chessComponents.get(y).charAt(i-1) < 'z'){
                        break;
                    }
                    if (chessComponents.get(y).charAt(i-1) == '_' || chessComponents.get(y).charAt(i-1) > 'A' && chessComponents.get(y).charAt(i-1) < 'Z') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(y, i-1);
                        chessboardPoints.add(chessboardPoint);
                        if(chessComponents.get(y).charAt(i-1)>'A'&&chessComponents.get(y).charAt(i-1)<'Z'){num4++;}
                    }
                }
                if (a > 'A' && a < 'Z') {
                    if(chessComponents.get(y).charAt(i-1) > 'A' && chessComponents.get(y).charAt(i-1) < 'Z'){
                        break;
                    }
                    if (chessComponents.get(y).charAt(i-1) == '_' || chessComponents.get(y).charAt(i-1) > 'a' && chessComponents.get(y).charAt(i-1) < 'z') {
                        ChessboardPoint chessboardPoint = new ChessboardPoint(y, i-1);
                        chessboardPoints.add(chessboardPoint);
                        if(chessComponents.get(y).charAt(i-1)>'a'&&chessComponents.get(y).charAt(i-1)<'z'){num4++;}
                    }
                }
            }
            else{continue;}
        }
        return chessboardPoints;
    }
}
