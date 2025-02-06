import java.util.ArrayList;
import java.util.List;
public abstract class ChessComponent {
      ChessboardPoint source;
      ChessColor chessColor;
    protected char name;
    public ChessComponent(){

    }

    public abstract List<ChessboardPoint> canMoveTo();
    ChessColor bianshi(char positon)
    {

        if (positon=='_')
            return ChessColor.NONE;
        else if (positon>='A'&&positon<='Z')
            return ChessColor.BLACK;
        else
            return ChessColor.WHITE;
    }

    public String toString()
    {
        return String.valueOf(this.name);
    }

    public ChessComponent(ChessboardPoint source,ChessColor chessColor)
    {
        this.chessColor=chessColor;
        this.source=source;

    }

    ChessComponent[][] qipan;
    void xiazai(ChessComponent[][] qipan){
        this.qipan=qipan;
    }

    final int[][] zou=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
}
class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint yuan,ChessColor se){
        super(yuan,se);

        if(se==ChessColor.BLACK)
            this.name='K';
        else
            this.name='k';
    }


    public List<ChessboardPoint> canMoveTo()
    {
        ArrayList<ChessboardPoint> yidong=new ArrayList<>();
        for(int one=0;8>one;one++)
        {
            ChessboardPoint destination=source.offset(zou[one][0],zou[one][1]);


            if(destination != null && bianshi(qipan[destination.getX()][destination.getY()].toString().charAt(0)) != chessColor)
                yidong.add(destination);

        }
        return yidong;
    }

}

class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint yuan,ChessColor se)
    {
        super(yuan,se);

        if(se==ChessColor.BLACK)
            this.name='Q';
        else
            this.name='q';
    }

    public List<ChessboardPoint> canMoveTo()
    {
        ArrayList<ChessboardPoint> yidong=new ArrayList<>();
        for(int two=0,n=source.getY(),m=source.getX(); two<8;n=source.getY(),two++,m=source.getX())
        {
            n+=zou[two][1];

            m+=zou[two][0];

            while(n>=0&&n<8&&m>=0&&m<8)
            {
                if(bianshi(qipan[m][n].toString().charAt(0))==chessColor)
                {
                    break;
                }
                yidong.add(new ChessboardPoint(m,n));
                if(bianshi(qipan[m][n].toString().charAt(0))!=ChessColor.NONE)
                    break;

                n+=zou[two][1];
                m+=zou[two][0];

            }
        }
        return yidong;

}

}

class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint yuan,ChessColor se){
        super(yuan,se);

        if(se==ChessColor.BLACK)
            this.name='R';
        else
            this.name='r';
    }

    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> yidong=new ArrayList<>();

        for(int yassuo=1,n=source.getY(),m=source.getX();  8>yassuo ;n=source.getY(), m=source.getX(),yassuo+=2)
        {
            n+=zou[yassuo][1];
            m+=zou[yassuo][0];
           ;
            while(n<8&&m>=0&&n>=0&&m<8)
            {
                if(bianshi(qipan[m][n].toString().charAt(0))==chessColor)

                    break;

                yidong.add(new ChessboardPoint(m,n));

                if(bianshi(qipan[m][n].toString().charAt(0))!=ChessColor.NONE)
                    break;

                n+=zou[yassuo][1];

                m+=zou[yassuo][0];

            }
        }
        return yidong;

        }

}



class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint yuan,ChessColor se){

        super(yuan,se);

        if(se==ChessColor.BLACK)
            this.name='B';
        else
            this.name='b';
    }

    public List<ChessboardPoint> canMoveTo() {

        ArrayList<ChessboardPoint> yidong=new ArrayList<>();

        for(int ten=0,m=source.getX(),n=source.getY();8>ten;ten+=2,n=source.getY(),m=source.getX())
        {
            m+=zou[ten][0];
            n+=zou[ten][1];

            while(n>=0&&n<8&&m>=0&&m<8){
                if(bianshi(qipan[m][n].toString().charAt(0))==chessColor)
                    break;

                yidong.add(new ChessboardPoint(m,n));
                if(bianshi(qipan[m][n].toString().charAt(0))!=ChessColor.NONE)
                    break;

                n+=zou[ten][1];

                m+=zou[ten][0];

                ;
            }
        }
        return yidong;
    }


        }

class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(ChessboardPoint yuan,ChessColor se){
        super(yuan,se);

        if(se==ChessColor.BLACK)
            this.name='N';
        else
            this.name='n';
    }

    public List<ChessboardPoint> canMoveTo() {


        ArrayList<ChessboardPoint> yidong=new ArrayList<>();

        int[][] KM=new int[][]{{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
        for(int nine=0;nine<8;nine++)
        {
            ChessboardPoint destination=source.offset(KM[nine][0],KM[nine][1]);

            if(destination!=null&&bianshi(qipan[destination.getX()][destination.getY()].toString().charAt(0))!=chessColor)
                yidong.add(destination);

        }
        return yidong;
        }

}



class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint yuan,ChessColor se)
    {
        super(yuan,se);

        if(se==ChessColor.BLACK)
            this.name='P';
        else
            this.name='p';
    }

    public List<ChessboardPoint> canMoveTo()
    {
       return null;
    }

}




class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint YUAN,ChessColor SE){

        super(YUAN,SE);

        this.name='_';
    }
    ;


    public List<ChessboardPoint> canMoveTo()
    {

        return new ArrayList<>();

        }



}
