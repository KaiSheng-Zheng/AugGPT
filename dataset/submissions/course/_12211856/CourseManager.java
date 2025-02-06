import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JTeacher extends JFrame {
    JLabel JLmessage1,JLmessage2,JLmessage3,JLmessage4,JLmessage5;
    String name = Login.JTname.getText();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    //    JPanel panel2_1 = new JPanel();
//    JPanel panel2_2 = new JPanel();
    ImageIcon image = new ImageIcon("out/production/学生选课系统/学生选课/Image/img.png");
    private JLabel background;
    private JButton JBsure1,JBsure2,JBsure3,JBsure4,JBsure5;
    private JTextArea JTarea;

    public JTeacher() {
        this.setTitle("教师界面");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        background =new JLabel(image);
        panel1.setPreferredSize(new Dimension(800,100));    
        panel1.add(background);
//        JBsure1 = new JButton("个人信息");
        JBsure2 = new JButton("录入成绩");
        JBsure3 = new JButton("成绩单");
        JBsure4 = new JButton("修改密码");
        JBsure5 = new JButton("返回");
        JTarea = new JTextArea(27,45);
        panel3.setPreferredSize(new Dimension(500,500));   
//        panel2.setLayout(new GridLayout(4,1));
        panel2.setLayout(null);
        panel2.setPreferredSize(new Dimension(200,500)); 
//        JBsure1.setBounds(1,40,170,25);
        JBsure2.setBounds(1,80,170,25);
        JBsure3.setBounds(1,120,170,25);
        JBsure4.setBounds(1,160,170,25);
        JBsure5.setBounds(1,200,170,25);
//        background.add(JBsure1);
//        background.add(JBsure2);
//        background.add(JBsure3);
//        background.add(JBsure4);
//        panel2.add(JBsure1);
        panel2.add(JBsure2);
        panel2.add(JBsure3);
        panel2.add(JBsure4);
        panel2.add(JBsure5);
//        panel3.add(JTarea);

//        panel2.setPreferredSize(new Dimension(200,450));  
//        this.add(panel1,BorderLayout.PAGE_START);
        this.add(panel1,BorderLayout.WEST);
        this.add(panel2,BorderLayout.LINE_END);
        this.add(panel3,BorderLayout.LINE_END);
//        this.add(panel2,BorderLayout.PAGE_END);
        this.setVisible(true);

        try {
            new My_Connection(); 
            Connection con = My_Connection.getConnection();
            Statement stmt = con.createStatement();   
            String sql = "select TNO,TNAME,SEX,TITLE from t where TNO = '" + name + "' "; 
            ResultSet rs = stmt.executeQuery(sql);    
            while (rs.next()) {

                JLmessage1 = new JLabel("工号："+rs.getString("TNO"));
//        JLmessage1 = new JLabel("学号："+"19408010113");
                JLmessage1.setFont(new java.awt.Font("宋体", 3, 30));
                JLmessage1.setForeground(Color.black);
                JLmessage2 = new JLabel("姓名:"+rs.getString("TNAME"));
//        JLmessage2 = new JLabel("姓名:"+"翟明飞");
                JLmessage2.setFont(new java.awt.Font("宋体", 3, 30));
                JLmessage2.setForeground(Color.black);
                JLmessage3 = new JLabel("性别:"+rs.getString("SEX"));
//        JLmessage3 = new JLabel("性别:"+"男");
                JLmessage3.setFont(new java.awt.Font("宋体", 3, 30));
                JLmessage3.setForeground(Color.black);
                JLmessage4 = new JLabel("职称:"+rs.getString("TITLE"));
//        JLmessage4 = new JLabel("年龄:"+"20");
                JLmessage4.setFont(new java.awt.Font("宋体", 3, 30));
                JLmessage4.setForeground(Color.black);


                JLmessage1.setBounds(150,40,300,50);
                JLmessage2.setBounds(150,100,250,50);
                JLmessage3.setBounds(150,160,200,50);
                JLmessage4.setBounds(150,220,200,50);
//                JLmessage5.setBounds(150,280,250,50);
                panel3.setLayout(null);
                panel3.add(JLmessage1);
                panel3.add(JLmessage2);
                panel3.add(JLmessage3);
                panel3.add(JLmessage4);
//                panel3.add(JLmessage5);

            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("出错");
        }

//        JBsure1.addActionListener(e -> {
//            //
//        });
    
        JBsure2.addActionListener(e -> {
            //
            new add_Grade();
        });
        
        JBsure3.addActionListener(e -> {
            //
            new list_Grade();
        });
       
        JBsure4.addActionListener(e -> {
            //
            new update_pswd();
        });
      
        JBsure5.addActionListener(e -> {
            //
            this.dispose();
            new Login();
        });
    }

//    public static void main(String[] args) {
//        new JTeacher();
//    }
}


class add_Grade extends JFrame {

    public add_Grade() {

    }
}

class list_Grade extends JFrame {

    public list_Grade() {

    }
}

class update_pswd extends JFrame {
    String name = Login.JTname.getText();
    //    String pwd = String.valueOf(Login.JTpwd.getPassword());
    private JButton Jbu1;
    //    static JTextField JTname;
    private JPasswordField JTpwd1,JTpwd2;
    private JLabel JLname1,JLname2;
    ImageIcon image = new ImageIcon("out/production/学生选课系统/学生选课/Image/xuanke.png");
    public update_pswd() {
        this.setTitle("更改密码");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds((width - 600) / 2, (height - 600) / 2 - 20, 400, 250);
        this.setResizable(false);
        JLabel background =new JLabel(image);  
//        JTname = new JTextField(20);
        JTpwd1 = new JPasswordField(20);
        JTpwd2 = new JPasswordField(20);
        JLname1 = new JLabel("旧密码：");
        JLname1.setFont(new java.awt.Font("宋体", 4, 15));
        JLname1.setForeground(new Color(19, 79, 50));
        JLname2 = new JLabel("新密码：");
        JLname2.setFont(new java.awt.Font("宋体", 4, 15));
        JLname2.setForeground(new Color(19, 79, 50));
        Jbu1 = new JButton("确认！");
        Jbu1.setFont(new java.awt.Font("宋体", 3, 15));
        Jbu1.setForeground(new Color(208, 16, 16));
        JTpwd1.setBounds(175,50,110,25);
        JLname1.setBounds(115,50,60,25);
        JTpwd2.setBounds(175,90,110,25);
        JLname2.setBounds(115,90,60,25);
        Jbu1.setBounds(115,130,170,25);
        background.setLayout(null);
        background.add(JTpwd1);
        background.add(JLname1);
        background.add(JTpwd2);
        background.add(JLname2);
        background.add(Jbu1);
        this.add(background);
        this.setVisible(true);

        Jbu1.addActionListener(e -> {
            String old_pwd = String.valueOf(JTpwd1.getPassword()); 
            String pwd = null;
            try {
                new My_Connection(); 
                Connection con = My_Connection.getConnection();
                Statement stmt = con.createStatement();  
                String sql = "select PSWD from t where TNO = '" + name + "' "; 
                ResultSet rs = stmt.executeQuery(sql);    
                while (rs.next()) {
                    pwd = rs.getString("PSWD");
                    System.out.println(pwd);
                }

                if (old_pwd.equals(pwd)) {      
                    String new_pwd = String.valueOf(JTpwd2.getPassword());
//                            Statement stmt=null;
//                            Connection con=null;
                   
                    try{
                        new My_Connection(); 
                        Connection con1 = My_Connection.getConnection();
                        Statement stmt1 =con1.createStatement();   
                        String sql1 = "update T set PSWD ='" +new_pwd+ "' where TNO = '" +name+ "'";
                        stmt1.execute(sql1);    
                        JOptionPane.showMessageDialog(null,"改密成功！","恭喜~",JOptionPane.ERROR_MESSAGE);
                        this.dispose();
//                    JStudent.dispose();
//                    new Login();   

                    }catch(Exception e1){
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null,"改密失败！","很遗憾~",JOptionPane.ERROR_MESSAGE);
                    }

                    
                }
                else {
                   
                    JOptionPane.showMessageDialog(null,"旧密码填写错误！","警告⚠",JOptionPane.ERROR_MESSAGE);
                    JTpwd1.requestFocus();
                }
            }catch(Exception e2) {
                System.out.println("查旧密码出错");
            }
        });
    }
}
————————————————
