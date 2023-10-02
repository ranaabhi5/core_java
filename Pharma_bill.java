import java.sql.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.*;


class Pharma_bill implements ActionListener
{
    JFrame jf = new JFrame("Lal Labs");
    JPanel jp = new JPanel();
    JButton jb1 = new JButton("Register");
    JButton jb2 = new JButton("Login");
    JLabel jl = new JLabel();
    JTextField jt = new JTextField();

public void actionPerformed(ActionEvent e)
{

    if(e.getSource()==jb1)
    {
        jf.setVisible(false);
        new Register();
    }

    if(e.getSource()==jb2)
    {
        jf.setVisible(false);
        new Login();
    }


}

    Pharma_bill()
    {
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setSize(500, 500);
        
        jf.add(jp);
        jp.setLayout(null);
        jp.setVisible(true);
        jp.setSize(500, 500);
        
        jp.setBackground(Color.BLACK);
        jp.add(jb1);
        jp.add(jb2);

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jb1.setBounds(100, 300, 100, 30);
        jb2.setBounds(250, 300, 100, 30);

        jb1.setBackground(Color.green);
        jb1.setForeground(Color.WHITE);

        jb2.setBackground(Color.green);
        jb2.setForeground(Color.WHITE);



    }




    public static void main(String[] args){
        new Pharma_bill();
    }
}


class Register implements ActionListener {
    JFrame jf = new JFrame("Lal Labs");
    JPanel jp = new JPanel();
    JButton jb1 = new JButton("Register");
    // JButton jb2 = new JButton("Login");
    JLabel jl = new JLabel();
     JLabel jl1= new JLabel("Enter email");
    JLabel jl2 = new JLabel("Enter mobile");
    JLabel jl3= new JLabel("Enter dob");
    JLabel jl4 = new JLabel("Enter name");
    JLabel jl5= new JLabel("Enter password");

    JTextField jt = new JTextField();
    JTextField jt1 = new JTextField();
    JTextField jt2 = new JTextField();
    JTextField jt3 = new JTextField();
    JTextField jt4 = new JTextField();
    JTextField jt5 = new JTextField();

    Register() {
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setSize(500, 500);

        jf.add(jp);
        jp.setLayout(null);
        jp.setVisible(true);
        jp.setSize(500, 500);

        jp.setBackground(Color.DARK_GRAY);
        jp.add(jb1);
        jb1.addActionListener(this);
        // jp.add(jb2);

        jp.add(jl1);
        jp.add(jl2);
        jp.add(jl3);
        jp.add(jl4);
        jp.add(jl5);

         jp.add(jt1);
        jp.add(jt2);
        jp.add(jt3);
        jp.add(jt4);
        jp.add(jt5);

        // jb1.setBounds(100, 300, 100, 30);
        // jb2.setBounds(250, 300, 100, 30);

        jb1.setBackground(Color.green);
        jb1.setForeground(Color.WHITE);
        
        jb1.setBounds(120, 280, 100, 30);
        jl1.setBounds(20, 50, 120, 20);
        jl2.setBounds(20, 90, 120, 20);
        jl3.setBounds(20, 130, 120, 20);
        jl4.setBounds(20, 170, 120, 20);
        jl5.setBounds(20, 210, 120, 20);

        
        jt1.setBounds(140, 50, 120, 20);
        jt2.setBounds(140, 90, 120, 20);
        jt3.setBounds(140, 130, 120, 20);
        jt4.setBounds(140, 170, 120, 20);

        jt5.setBounds(140, 210, 120, 20);

        jl1.setForeground(Color.WHITE);
        jl2.setForeground(Color.WHITE);
        jl3.setForeground(Color.WHITE);
        jl4.setForeground(Color.WHITE);
        jl5.setForeground(Color.WHITE);
        

        // jb2.setBackground(Color.green);
        // jb2.setForeground(Color.WHITE);

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb1) {
		
		String s1 = jt1.getText();
		String s2 = jt2.getText();
		String s3 = jt3.getText();
		String s4 = jt4.getText();
		String s5 = jt5.getText();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmausers", "root", "root");
			PreparedStatement pst=con.prepareStatement("insert into user values(?,?,?,?,?) ");
			
			pst.setString(1,s1);
			pst.setString(2,s2);
			pst.setString(3,s3);
			pst.setString(4,s4);
			pst.setString(5,s5);
			
			int c=pst.executeUpdate();
			
			new Login();
				jf.setVisible(false);
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		}
	}

}



class Login implements ActionListener {
    JFrame jf = new JFrame("Lal Labs");
    JPanel jp = new JPanel();
    JButton jb1 = new JButton("Login");
    // JButton jb2 = new JButton("Login");
    JLabel jl1= new JLabel("Enter User name");
    JLabel jl2 = new JLabel("Enter Password");
    JTextField jt = new JTextField();
    JPasswordField jpw = new JPasswordField();

    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==jb1)
    {
        jf.setVisible(false);
        String u=jt.getText();
        String p=jpw.getText();
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmausers", "root", "root");
			PreparedStatement pst=con.prepareStatement("select username,password from user");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				if (rs.getString(1).equalsIgnoreCase(u)&&rs.getString(2).equalsIgnoreCase(p))
				{
					jf.setVisible(false);
					new GenerateBill();
					break;
				}
				else
				{
//					new Pharma_bill();
				}
				
			}
        	
        }
        catch(Exception e2)
        {
        	e2.printStackTrace();
        }
        
        
       
    }
}

    Login() {
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setSize(350, 350);

        jf.add(jp);
        jp.setLayout(null);
        jp.setVisible(true);
        jp.setSize(350, 350);

        jp.setBackground(Color.magenta);
        jp.add(jb1);
        jb1.addActionListener(this);
        jp.add(jl1);
        jp.add(jl2);

        jp.add(jt);
        jp.add(jpw);
        
        // jp.add(jb2);

        jb1.setBounds(120, 200, 100, 30);
        jl1.setBounds(20, 50, 120, 20);
        jl2.setBounds(20, 90, 120, 20);

        jt.setBounds(140, 50, 120, 20);
        jpw.setBounds(140, 90, 120, 20);

        // jb2.setBounds(250, 300, 100, 30);

        jb1.setBackground(Color.PINK);
        jb1.setForeground(Color.WHITE);

        // jb2.setBackground(Color.green);
        // jb2.setForeground(Color.WHITE);
        
        

    }

}

class GenerateBill implements ActionListener {
    JFrame jf = new JFrame("Lal Labs");
    JPanel jp = new JPanel();
    JButton jb1 = new JButton("Generate Bill");
    // JButton jb2 = new JButton("Login");
    JLabel jl1= new JLabel("Enter Medicine1");
    JLabel jl2 = new JLabel("Enter Medicine2");
    JLabel jl3= new JLabel("Enter Medicine3");
    JLabel jl4 = new JLabel("Enter Medicine4");
    JLabel jl5= new JLabel("Enter Quantity");
    JLabel jl6 = new JLabel("Enter Price");
//    JLabel jl7= new JLabel("Enter Address");
    JLabel jl8 = new JLabel("Enter Date");
    JTextField jt1 = new JTextField();
    JTextField jt2 = new JTextField();
    JTextField jt3 = new JTextField();
    JTextField jt4 = new JTextField();
    JTextField jt5 = new JTextField();
    JTextField jt6 = new JTextField();
//    JTextField jt7 = new JTextField();
    JTextField jt8 = new JTextField();



    // JPasswordField jpw = new JPasswordField();

    GenerateBill() {
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setSize(350, 450);

        jf.add(jp);
        jp.setLayout(null);
        jp.setVisible(true);
        jp.setSize(350, 700);

        jp.setBackground(Color.DARK_GRAY);
        jp.setForeground(Color.WHITE);
        jp.add(jb1);
        jb1.addActionListener(this);
        jp.add(jl1);
        jp.add(jl2);
        jp.add(jl3);
        jp.add(jl4);
        jp.add(jl5);
        jp.add(jl6);
//        jp.add(jl7);
        jp.add(jl8);

        jl1.setForeground(Color.WHITE);
        jl2.setForeground(Color.WHITE);
        jl3.setForeground(Color.WHITE);
        jl4.setForeground(Color.WHITE);
        jl5.setForeground(Color.WHITE);
        jl6.setForeground(Color.WHITE);
//        jl7.setForeground(Color.WHITE);
        jl8.setForeground(Color.WHITE);

        jp.add(jt1);
        jp.add(jt2);
        jp.add(jt3);
        jp.add(jt4);
        jp.add(jt5);
        jp.add(jt6);
//        jp.add(jt7);
        jp.add(jt8);
        // jp.add(jl2);

        
        // jp.add(jb2);

        jb1.setBounds(120, 380, 100, 30);
        jl1.setBounds(20, 50, 120, 20);
        jl2.setBounds(20, 90, 120, 20);
        jl3.setBounds(20, 130, 120, 20);
        jl4.setBounds(20, 170, 120, 20);
        jl5.setBounds(20, 210, 120, 20);
        jl6.setBounds(20, 250, 120, 20);
//        jl7.setBounds(20, 290, 120, 20);
        jl8.setBounds(20, 330, 120, 20);









        jt1.setBounds(140, 50, 120, 20);
        jt2.setBounds(140, 90, 120, 20);
        jt3.setBounds(140, 130, 120, 20);
        jt4.setBounds(140, 170, 120, 20);

        jt5.setBounds(140, 210, 120, 20);
        jt6.setBounds(140, 250, 120, 20);
//        jt7.setBounds(140, 290, 120, 20);
        jt8.setBounds(140, 330, 120, 20);



        // jb2.setBounds(250, 300, 100, 30);

        jb1.setBackground(Color.PINK);
        jb1.setForeground(Color.WHITE);

        // jb2.setBackground(Color.green);
        // jb2.setForeground(Color.WHITE);

        
        
    }
    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb1) {
		
		String s1 = jt1.getText();
		String s2 = jt2.getText();
		String s3 = jt3.getText();
		String s4 = jt4.getText();
		String s5 = jt5.getText();
		String s6 = jt6.getText();
		String s7 = jt8.getText();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmausers", "root", "root");
			PreparedStatement pst=con.prepareStatement("insert into bill values(?,?,?,?,?,?,?) ");
			
			pst.setString(1,s1);
			pst.setString(2,s2);
			pst.setString(3,s3);
			pst.setString(4,s4);
			pst.setString(5,s5);
			pst.setString(6,s6);
			pst.setString(7,s7);
			
			int c=pst.executeUpdate();
						
					
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		}

    
    

}
}