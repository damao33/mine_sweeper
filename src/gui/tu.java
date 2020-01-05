package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import connection.ConnectionManager;
import connection.UserDaoJdbcImpl;
import user.User;

public class tu {
	private JFrame frame = new JFrame("登录");
	private Container c = frame.getContentPane();
	private JTextField username = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JButton ok = new JButton("确定");
	private JButton cancel = new JButton("取消");
	public tu(){
	frame.setSize(300,200);
	c.setLayout(new BorderLayout());
	initFrame();
	frame.setVisible(true);
	}
	private void initFrame() {
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(new JLabel("扫雷登录"));
		c.add(titlePanel,"North");
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(null);
		JLabel l1 = new JLabel("用户名:");
		l1.setBounds(50, 20, 50, 20);
		JLabel l2 = new JLabel("密 码:");
		l2.setBounds(50, 60, 50, 20);
		fieldPanel.add(l1);
		fieldPanel.add(l2);
		username.setBounds(110,20,120,20);
		password.setBounds(110,60,120,20);
		fieldPanel.add(username);
		fieldPanel.add(password);
		c.add(fieldPanel,"Center");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		ok.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ac=username.getText();
				String pwd=String.valueOf(password.getPassword());
				User user=new User(ac,pwd);
				if(UserDaoJdbcImpl.Login(user))
				{
					System.out.println("登陆成功");
				}else System.out.println("登陆失败");
			}
		});
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		buttonPanel.add(ok);
		buttonPanel.add(cancel);
		c.add(buttonPanel,"South");
}
    public static void main(String[] args){
    	new tu();
    	//ConnectionManager.getConnection();
	}
}