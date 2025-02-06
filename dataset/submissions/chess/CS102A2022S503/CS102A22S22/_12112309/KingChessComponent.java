import javax.net.ssl.SSLContext;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {


    public KingChessComponent(char name,ChessColor color,ChessboardPoint source ){
        super(name,color,source);

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints=new ArrayList<>();
        List<String> chessComponents=this.concreteChessGame.getChessBoard();
        int y= getSource().getX();
        int x= getSource().getY();
        char a=chessComponents.get(y).charAt(x);
if(x+1<8&&x-1>0&&y+1<8&&y-1>0){

    char a1=chessComponents.get(y).charAt(x+1);
    char a2=chessComponents.get(y).charAt(x-1);
    char a3=chessComponents.get(y-1).charAt(x);
    char a4=chessComponents.get(y+1).charAt(x);
    char b1=chessComponents.get(y+1).charAt(x+1);
    char b2=chessComponents.get(y-1).charAt(x+1);
    char b3=chessComponents.get(y+1).charAt(x-1);
    char b4=chessComponents.get(y-1).charAt(x-1);
    if(a>'a'&&a<'z'){
        if(a1=='_'||(a1>'A'&&a1<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x+1);chessboardPoints.add(chessboardPoint);}
        if(a2=='_'||(a2>'A'&&a2<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x-1);chessboardPoints.add(chessboardPoint);}
        if(a3=='_'||(a3>'A'&&a3<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x);chessboardPoints.add(chessboardPoint);}
        if(a4=='_'||(a4>'A'&&a4<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x);chessboardPoints.add(chessboardPoint);}
        if(b1=='_'||(b1>'A'&&b1<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x+1);chessboardPoints.add(chessboardPoint);}
        if(b2=='_'||(b2>'A'&&b2<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x+1);chessboardPoints.add(chessboardPoint);}
        if(b3=='_'||(b3>'A'&&b3<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x-1);chessboardPoints.add(chessboardPoint);}
        if(b4=='_'||(b4>'A'&&b4<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x-1);chessboardPoints.add(chessboardPoint);}
    }
    if(a>'A'&&a<'Z'){
        if(a1=='_'||(a1>'a'&&a1<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x+1);chessboardPoints.add(chessboardPoint);}
        if(a2=='_'||(a2>'a'&&a2<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x-1);chessboardPoints.add(chessboardPoint);}
        if(a3=='_'||(a3>'a'&&a3<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x);chessboardPoints.add(chessboardPoint);}
        if(a4=='_'||(a4>'a'&&a4<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x);chessboardPoints.add(chessboardPoint);}
        if(b1=='_'||(b1>'a'&&b1<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x+1);chessboardPoints.add(chessboardPoint);}
        if(b2=='_'||(b2>'a'&&b2<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x+1);chessboardPoints.add(chessboardPoint);}
        if(b3=='_'||(b3>'a'&&b3<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x-1);chessboardPoints.add(chessboardPoint);}
        if(b4=='_'||(b4>'a'&&b4<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x-1);chessboardPoints.add(chessboardPoint);}
    }
}
if(x==0){
    if(y==0){
        char a1=chessComponents.get(y).charAt(x+1);
        char a4=chessComponents.get(y+1).charAt(x);
        char b1=chessComponents.get(y+1).charAt(x+1);
        if(a>'a'&&a<'z'){
            if(a1=='_'||(a1>'A'&&a1<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x+1);chessboardPoints.add(chessboardPoint);}
            if(a4=='_'||(a4>'A'&&a4<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x);chessboardPoints.add(chessboardPoint);}
            if(b1=='_'||(b1>'A'&&b1<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x+1);chessboardPoints.add(chessboardPoint);}
        }
        if(a>'A'&&a<'Z'){
            if(a1=='_'||(a1>'a'&&a1<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x+1);chessboardPoints.add(chessboardPoint);}
            if(a4=='_'||(a4>'a'&&a4<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x);chessboardPoints.add(chessboardPoint);}
            if(b1=='_'||(b1>'a'&&b1<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x+1);chessboardPoints.add(chessboardPoint);}

        }
    }
    else if(y==7){

        char a3=chessComponents.get(y-1).charAt(x);
        char a1=chessComponents.get(y).charAt(x+1);
        char b2=chessComponents.get(y-1).charAt(x+1);
        if(a>'a'&&a<'z'){
            if(a1=='_'||(a1>'A'&&a1<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x+1);chessboardPoints.add(chessboardPoint);}
            if(a3=='_'||(a3>'A'&&a3<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x);chessboardPoints.add(chessboardPoint);}
            if(b2=='_'||(b2>'A'&&b2<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x+1);chessboardPoints.add(chessboardPoint);}
        }
        if(a>'A'&&a<'Z'){
            if(a1=='_'||(a1>'a'&&a1<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x+1);chessboardPoints.add(chessboardPoint);}
            if(a3=='_'||(a3>'a'&&a3<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x);chessboardPoints.add(chessboardPoint);}
            if(b2=='_'||(b2>'a'&&b2<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x+1);chessboardPoints.add(chessboardPoint);}
        }

    }
    else{

        char a1=chessComponents.get(y).charAt(x+1);
        char a3=chessComponents.get(y-1).charAt(x);
        char a4=chessComponents.get(y+1).charAt(x);
        char b1=chessComponents.get(y+1).charAt(x+1);
        char b2=chessComponents.get(y-1).charAt(x+1);
        if(a>'a'&&a<'z'){
            if(a1=='_'||(a1>'A'&&a1<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x+1);chessboardPoints.add(chessboardPoint);}
            if(a4=='_'||(a4>'A'&&a4<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x);chessboardPoints.add(chessboardPoint);}
            if(b1=='_'||(b1>'A'&&b1<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x+1);chessboardPoints.add(chessboardPoint);}
            if(a3=='_'||(a3>'A'&&a3<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x);chessboardPoints.add(chessboardPoint);}
            if(b2=='_'||(b2>'A'&&b2<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x+1);chessboardPoints.add(chessboardPoint);}
        }
        if(a>'A'&&a<'Z'){
            if(a1=='_'||(a1>'a'&&a1<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x+1);chessboardPoints.add(chessboardPoint);}
            if(a4=='_'||(a4>'a'&&a4<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x);chessboardPoints.add(chessboardPoint);}
            if(b1=='_'||(b1>'a'&&b1<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x+1);chessboardPoints.add(chessboardPoint);}
            if(a3=='_'||(a3>'a'&&a3<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x);chessboardPoints.add(chessboardPoint);}
            if(b2=='_'||(b2>'a'&&b2<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x+1);chessboardPoints.add(chessboardPoint);}

        }
    }

}
if(x==7){
    if(y==0){

        char a2=chessComponents.get(y).charAt(x-1);
        char a4=chessComponents.get(y+1).charAt(x);
        char b3=chessComponents.get(y+1).charAt(x-1);
        if(a>'a'&&a<'z'){
            if(a2=='_'||(a2>'A'&&a2<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x-1);chessboardPoints.add(chessboardPoint);}
            if(a4=='_'||(a4>'A'&&a4<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x);chessboardPoints.add(chessboardPoint);}
            if(b3=='_'||(b3>'A'&&b3<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x-1);chessboardPoints.add(chessboardPoint);}
        }
        if(a>'A'&&a<'Z'){
            if(a2=='_'||(a2>'a'&&a2<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x-1);chessboardPoints.add(chessboardPoint);}
            if(a4=='_'||(a4>'a'&&a4<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x);chessboardPoints.add(chessboardPoint);}
            if(b3=='_'||(b3>'a'&&b3<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x-1);chessboardPoints.add(chessboardPoint);}

        }
    }
    else if(y==7){
        char a2=chessComponents.get(y).charAt(x-1);
        char a3=chessComponents.get(y-1).charAt(x);
        char b4=chessComponents.get(y-1).charAt(x-1);
        if(a>'a'&&a<'z'){
            if(a2=='_'||(a2>'A'&&a2<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x-1);chessboardPoints.add(chessboardPoint);}
            if(a3=='_'||(a3>'A'&&a3<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x);chessboardPoints.add(chessboardPoint);}
            if(b4=='_'||(b4>'A'&&b4<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x-1);chessboardPoints.add(chessboardPoint);}
        }
        if(a>'A'&&a<'Z'){
            if(a2=='_'||(a2>'a'&&a2<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x-1);chessboardPoints.add(chessboardPoint);}
            if(a3=='_'||(a3>'a'&&a3<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x);chessboardPoints.add(chessboardPoint);}
            if(b4=='_'||(b4>'a'&&b4<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x-1);chessboardPoints.add(chessboardPoint);}
        }
    }
    else{
        char a2=chessComponents.get(y).charAt(x-1);
        char a3=chessComponents.get(y-1).charAt(x);
        char a4=chessComponents.get(y+1).charAt(x);
        char b3=chessComponents.get(y+1).charAt(x-1);
        char b4=chessComponents.get(y-1).charAt(x-1);
        if(a>'a'&&a<'z'){
            if(a2=='_'||(a2>'A'&&a2<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x-1);chessboardPoints.add(chessboardPoint);}
            if(a3=='_'||(a3>'A'&&a3<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x);chessboardPoints.add(chessboardPoint);}
            if(a4=='_'||(a4>'A'&&a4<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x);chessboardPoints.add(chessboardPoint);}
            if(b3=='_'||(b3>'A'&&b3<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x-1);chessboardPoints.add(chessboardPoint);}
            if(b4=='_'||(b4>'A'&&b4<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x-1);chessboardPoints.add(chessboardPoint);}
        }
        if(a>'A'&&a<'Z'){
            if(a2=='_'||(a2>'a'&&a2<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x-1);chessboardPoints.add(chessboardPoint);}
            if(a3=='_'||(a3>'a'&&a3<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x);chessboardPoints.add(chessboardPoint);}
            if(a4=='_'||(a4>'a'&&a4<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x);chessboardPoints.add(chessboardPoint);}
            if(b3=='_'||(b3>'a'&&b3<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x-1);chessboardPoints.add(chessboardPoint);}
            if(b4=='_'||(b4>'a'&&b4<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x-1);chessboardPoints.add(chessboardPoint);}
        }
    }

}
if(x>0&&x<7&&y==0){
    char a1=chessComponents.get(y).charAt(x+1);
    char a2=chessComponents.get(y).charAt(x-1);
    char a4=chessComponents.get(y+1).charAt(x);
    char b1=chessComponents.get(y+1).charAt(x+1);
    char b3=chessComponents.get(y+1).charAt(x-1);
    if(a>'a'&&a<'z'){
        if(a1=='_'||(a1>'A'&&a1<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x+1);chessboardPoints.add(chessboardPoint);}
        if(a2=='_'||(a2>'A'&&a2<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x-1);chessboardPoints.add(chessboardPoint);}
        if(a4=='_'||(a4>'A'&&a4<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x);chessboardPoints.add(chessboardPoint);}
        if(b1=='_'||(b1>'A'&&b1<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x+1);chessboardPoints.add(chessboardPoint);}
        if(b3=='_'||(b3>'A'&&b3<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x-1);chessboardPoints.add(chessboardPoint);}
    }
    if(a>'A'&&a<'Z'){
        if(a1=='_'||(a1>'a'&&a1<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x+1);chessboardPoints.add(chessboardPoint);}
        if(a2=='_'||(a2>'a'&&a2<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x-1);chessboardPoints.add(chessboardPoint);}
        if(a4=='_'||(a4>'a'&&a4<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x);chessboardPoints.add(chessboardPoint);}
        if(b1=='_'||(b1>'a'&&b1<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x+1);chessboardPoints.add(chessboardPoint);}
        if(b3=='_'||(b3>'a'&&b3<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y+1,x-1);chessboardPoints.add(chessboardPoint);}
    }

}
if(x>0&&x<7&&y==7){
    char a1=chessComponents.get(y).charAt(x+1);
    char a2=chessComponents.get(y).charAt(x-1);
    char a3=chessComponents.get(y-1).charAt(x);
    char b2=chessComponents.get(y-1).charAt(x+1);
    char b4=chessComponents.get(y-1).charAt(x-1);
    if(a>'a'&&a<'z'){
        if(a1=='_'||(a1>'A'&&a1<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x+1);chessboardPoints.add(chessboardPoint);}
        if(a2=='_'||(a2>'A'&&a2<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x-1);chessboardPoints.add(chessboardPoint);}
        if(a3=='_'||(a3>'A'&&a3<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x);chessboardPoints.add(chessboardPoint);}
        if(b2=='_'||(b2>'A'&&b2<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x+1);chessboardPoints.add(chessboardPoint);}
        if(b4=='_'||(b4>'A'&&b4<'Z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x-1);chessboardPoints.add(chessboardPoint);}
    }
    if(a>'A'&&a<'Z'){
        if(a1=='_'||(a1>'a'&&a1<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x+1);chessboardPoints.add(chessboardPoint);}
        if(a2=='_'||(a2>'a'&&a2<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y,x-1);chessboardPoints.add(chessboardPoint);}
        if(a3=='_'||(a3>'a'&&a3<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x);chessboardPoints.add(chessboardPoint);}
        if(b2=='_'||(b2>'a'&&b2<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x+1);chessboardPoints.add(chessboardPoint);}
        if(b4=='_'||(b4>'a'&&b4<'z')){ChessboardPoint chessboardPoint=new ChessboardPoint(y-1,x-1);chessboardPoints.add(chessboardPoint);}

    }

}
return chessboardPoints;
    }
}
