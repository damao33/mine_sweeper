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
				if(UserDaoJdbcImpl.login(user)==1)
				{
					System.out.println("登陆成功");
					new GameFrame(user);
				}else System.out.println("登陆失败");
			}
		});
	
		
		
		login1.addActionListener(new ActionListener() {
			
			@Override
			
			public void actionPerformed(ActionEvent e) {
				String ac=txtName.getText();
				String pwd=String.valueOf(txtPass.getPassword());
				User user=new User(ac,pwd);
				if(UserDaoJdbcImpl.login(user)==1)
				{
					System.out.println("登陆成功");
					mainJFrame.setVisible(false);//登录成功登入界面消失
					new GameFrame(user).runGame();
					
					//new RoomFrame().setVisible(true);
				}else {
					if(UserDaoJdbcImpl.login(user)==-3) {
						JOptionPane.showMessageDialog(null, "密码错误");
						txtPass.setText(null);//密码错误清空密码
						System.out.println("登陆失败");
					}
					else if(UserDaoJdbcImpl.login(user)==0){
						JOptionPane.showMessageDialog(null, "不存在该账号");
						txtName.setText(null);//清空用户名
						txtPass.setText(null);//清空密码
						System.out.println("登陆失败");
					}
				}
			}
		});
		
		register=new JButton("注册");
		register.addActionListener(this);
	
		
		
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