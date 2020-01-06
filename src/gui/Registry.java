package gui;

import javax.swing.*;

import connection.UserDaoJdbcImpl;
import user.User;

import java.awt.*;
import java.awt.event.*;

	public class Registry implements ActionListener {
	
		JFrame mainJFrame;
		Container con;
		JLabel labName,labPass,labRPass,labTitle,labEmpty1,labEmpty;
		JTextField txtName,txtID;
		JPasswordField txtPass,txtRPass;
		JButton resetBtn,regBtn,cancel;
	//	JRadioButton mRadio,fRadio;
		ButtonGroup sexBtnGroup;
		
		public Registry(){
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
		
		mainJFrame=new JFrame("用户注册");
		con=mainJFrame.getContentPane();
		con.setLayout(new FlowLayout());
		
		labTitle=new JLabel("<html><body><h1>用户注册     </h1> </body>  </html> ");
		con.add(labTitle);
		con.add(Box.createHorizontalStrut(30000));
		
		labName=new JLabel("用户名:    ");
		txtName=new JTextField();
		txtName.setColumns(20);
		con.add(labName);
		con.add(txtName);
		con.add(Box.createHorizontalStrut(30000));
		
		labPass=new JLabel("密码:        ");
		txtPass=new JPasswordField();
		txtPass.setColumns(20);
		con.add(labPass);
		con.add(txtPass);
		con.add(Box.createHorizontalStrut(30000));
		
		labRPass=new JLabel("确认密码:");
		txtRPass=new JPasswordField();
		txtRPass.setColumns(20);
		con.add(labRPass);
		con.add(txtRPass);
		con.add(Box.createHorizontalStrut(30000));
		
		 
	//	labSex=new JLabel("性别:");
	//	mRadio=new JRadioButton("男",true);
	//	mRadio.addActionListener(this);
	//	fRadio=new JRadioButton("女",false);
	//	fRadio.addActionListener(this);
		sexBtnGroup=new ButtonGroup();
	//	sexBtnGroup.add(mRadio);
	//	sexBtnGroup.add(fRadio);
	//	con.add(labSex);
	//	con.add(mRadio);
	//	con.add(fRadio);
		
	//	labAge=new JLabel("年龄:");
	//	txtAge=new JTextField();
	//	txtAge.setColumns(5);
	//	con.add(labAge);
	//	con.add(txtAge);
		con.add(Box.createHorizontalStrut(30000));
		
		regBtn=new JButton("注册");
		regBtn.addActionListener(new ActionListener() {
			
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
		con.add(regBtn);
		
		resetBtn=new JButton("重置");
		resetBtn.addActionListener(this);
		con.add(resetBtn);
		
		cancel=new JButton("取消");
		cancel.addActionListener(this);
		con.add(cancel);
		
		mainJFrame.setSize(400,400);
		mainJFrame.setVisible(true);
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==regBtn){
			
		}
		if(e.getSource()==resetBtn){
			txtName.setText(null);
			txtPass.setText(null);
			txtRPass.setText(null);
	//		mRadio.setSelected(true);
	//		txtAge.setText(null);
			}
		if(e.getSource()==cancel){
			mainJFrame.setVisible(false);
			Login login=new Login();
			login.mainJFrame.setVisible(true);
		}
	}
}

