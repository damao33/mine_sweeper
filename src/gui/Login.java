package gui;

import javax.swing.*;

import connection.UserDaoJdbcImpl;
import user.User;

import java.awt.*;
import java.awt.event.*;

public class Login implements ActionListener{

	JFrame mainJFrame;
	Container con;
	JLabel labName,labPass,labTitle,labEmpty;
	JTextField txtName;
	JPasswordField txtPass;
	JButton login1,register;
	

public Login(){
	try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    }catch(Exception e) {
    	System.out.println(e);
    }
	
	mainJFrame=new JFrame("用户登录");
	con=mainJFrame.getContentPane();
	con.setLayout(new FlowLayout());
	labTitle=new JLabel("<html><body><h1> 欢迎使用扫雷 \n <br> </h1> </body>  </html>");
	
	
	labName=new JLabel("  用户名: ");
	txtName=new JTextField();
	txtName.setColumns(20);
	
	labPass=new JLabel("    密码:  ");
	txtPass=new JPasswordField();
	txtPass.setColumns(20);
	
	login1=new JButton("登录");
    login1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String ac=txtName.getText();
			String pwd=String.valueOf(txtPass.getPassword());
			User user=new User(ac,pwd);
			if(UserDaoJdbcImpl.login(user))
			{
				System.out.println("登陆成功");
				GameFrame.runGame(user);
			}else System.out.println("登陆失败");
		}
	});

	
	
	login1.addActionListener(new ActionListener() {
		
		@Override
		
		public void actionPerformed(ActionEvent e) {
			String ac=txtName.getText();
			String pwd=String.valueOf(txtPass.getPassword());
			User user=new User(ac,pwd);
			if(UserDaoJdbcImpl.login(user))
			{
				System.out.println("登陆成功");
			}else System.out.println("登陆失败");
		}
	});
	
	register=new JButton("注册");
	register.addActionListener(this);
    register.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String acount=txtName.getText();
			String pwd=String.valueOf(txtPass.getPassword());
			User user=new User(acount,pwd);
			if(!UserDaoJdbcImpl.register(user))
			{
				System.out.println("注册失败");
			}else
			{
				System.out.println("注册成功");
			}
		}
	});

	
	
//	cancel=new JButton("取消");
//	cancel.addActionListener(this);
	
	
	con.add(labTitle);
	con.add(Box.createHorizontalStrut(30000));
	
	con.add(Box.createHorizontalStrut(30000));
	
	con.add(labName);
	con.add(txtName);
	con.add(Box.createHorizontalStrut(30000));
	
	con.add(labPass);
	con.add(txtPass);
	con.add(Box.createHorizontalStrut(30000));
	
	con.add(login1);
	con.add(register);
//	con.add(cancel);
	
	mainJFrame.setSize(350, 350);
	mainJFrame.setVisible(true);
	mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e){
	if(e.getSource()==login1){
		
	}
	if(e.getSource()==register){
		mainJFrame.setVisible(false);
		Registry reg=new Registry();
		reg.mainJFrame.setVisible(true);
	}
//	if(e.getSource()==cancel){
//		txtName.setText(null);
//		txtPass.setText(null);
//		
//	}
}
public static void main(String[] args){
	new Login();
  }
}