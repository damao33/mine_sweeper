package gui;

import javax.swing.*;

import connection.UserDaoJdbcImpl;
import user.User;

import java.awt.*;
import java.awt.event.*;

public class Registry implements ActionListener {

	JFrame mainJFrame;
	Container con;
	JLabel labName, labPass, labRPass, labTitle, labEmpty1, labEmpty;
	JTextField txtName, txtID;
	JPasswordField txtPass, txtRPass;
	JButton resetBtn, regBtn, cancel;
	// JRadioButton mRadio,fRadio;
	ButtonGroup sexBtnGroup;
	
	private void loginPerformance() {
		try {

			String acount = txtName.getText();
			// 注册时2次输入的密码相同时才把密码设置到user信息中
			String pwd1 = String.valueOf(txtPass.getPassword());
			String pwd2 = String.valueOf(txtRPass.getPassword());
			boolean isWrong = true;
			if (isWrong) {
				if ((pwd1.equals(pwd2))) {
					User user = new User(acount, pwd1);
					isWrong = false;
					int registerState = UserDaoJdbcImpl.register(user);
					if (registerState == -1) {
						JOptionPane.showMessageDialog(null, "已存在该用户，注册失败");
						txtName.setText(null);
						txtPass.setText(null);
						txtRPass.setText(null);
						System.out.println("注册失败");
					} else if (registerState == 0) {
						JOptionPane.showMessageDialog(null, "密码不符合要求，注册失败");
						txtPass.setText(null);
						txtRPass.setText(null);
						System.out.println("注册失败");
					} else if (registerState == 1) {
						JOptionPane.showMessageDialog(null, "注册成功");
						mainJFrame.setVisible(false);
						Login login = new Login();
						login.mainJFrame.setVisible(true);
						System.out.println("注册成功");
					} else {
						JOptionPane.showMessageDialog(null, "注册失败");
						txtName.setText(null);
						txtPass.setText(null);
						txtRPass.setText(null);
						System.out.println("注册失败");
					}
				} else {
					txtPass.setText(null);
					txtRPass.setText(null);
					JOptionPane.showMessageDialog(null, "密码不一致,请再次输入密码");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		};
	}
	private ActionListener loginListener=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Registry.this.loginPerformance();
		}
	};

	public Registry() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		mainJFrame = new JFrame("用户注册");
		con = mainJFrame.getContentPane();
		con.setLayout(new FlowLayout());

		labTitle = new JLabel("<html><body><h1>用户注册     </h1> </body>  </html> ");
		con.add(labTitle);
		con.add(Box.createHorizontalStrut(30000));

		labName = new JLabel("用户名:    ");
		txtName = new JTextField();
		txtName.setColumns(20);
		con.add(labName);
		con.add(txtName);
		con.add(Box.createHorizontalStrut(30000));

		labPass = new JLabel("密码:        ");
		txtPass = new JPasswordField();
		txtPass.setColumns(20);
		con.add(labPass);
		con.add(txtPass);
		con.add(Box.createHorizontalStrut(30000));

		labRPass = new JLabel("确认密码:");
		txtRPass = new JPasswordField();
		txtRPass.setColumns(20);
		con.add(labRPass);
		con.add(txtRPass);
		con.add(Box.createHorizontalStrut(30000));

		// labSex=new JLabel("性别:");
		// mRadio=new JRadioButton("男",true);
		// mRadio.addActionListener(this);
		// fRadio=new JRadioButton("女",false);
		// fRadio.addActionListener(this);
		sexBtnGroup = new ButtonGroup();
		// sexBtnGroup.add(mRadio);
		// sexBtnGroup.add(fRadio);
		// con.add(labSex);
		// con.add(mRadio);
		// con.add(fRadio);

		// labAge=new JLabel("年龄:");
		// txtAge=new JTextField();
		// txtAge.setColumns(5);
		// con.add(labAge);
		// con.add(txtAge);
		con.add(Box.createHorizontalStrut(30000));

		regBtn = new JButton("注册");

		regBtn.addActionListener(this.loginListener);
		txtRPass.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if (key == '\n') {
					Registry.this.loginPerformance();
			}
		}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
				
			});
		con.add(regBtn);

		resetBtn = new JButton("重置");
		resetBtn.addActionListener(this);
		con.add(resetBtn);

		cancel = new JButton("取消");
		cancel.addActionListener(this);
		con.add(cancel);

		mainJFrame.setSize(400, 400);
		mainJFrame.setVisible(true);
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == regBtn) {

		}
		if (e.getSource() == resetBtn) {
			txtName.setText(null);
			txtPass.setText(null);
			txtRPass.setText(null);
			// mRadio.setSelected(true);
			// txtAge.setText(null);
		}
		if (e.getSource() == cancel) {
			mainJFrame.setVisible(false);
			Login login = new Login();
			login.mainJFrame.setVisible(true);
		}
	}

}
