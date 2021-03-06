/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.awt.Toolkit;
import java.awt.event.*;
import connection.*;
import msg.*;
import tool.StaticTool;
import user.User;

/**
 *
 * @author 12892
 */
public class RoomFrame extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form RoomFrame
     */
    public RoomFrame() {
        initComponents();
    }
    
    public RoomFrame(User user, ConnectClient connectClient){
		super();
		this.user = user;
		this.connectClient = connectClient;
		initComponents();
	}

	public User getUser() {
		return user;
	}
    public ConnectClient getConnectClient() {
			return connectClient;
	}    
    public static void setRoomMsg(GameRoomMsg roomMsg) {
    	
		RoomFrame.roomMsg = roomMsg;
		String num2=String.valueOf(RoomFrame.roomMsg.getOnline());
		String Unum1=String.valueOf(RoomFrame.roomMsg.getRoomOnline(1))+"/4";
		String Unum2=String.valueOf(RoomFrame.roomMsg.getRoomOnline(2))+"/4";
		String Unum3=String.valueOf(RoomFrame.roomMsg.getRoomOnline(3))+"/4";
		String Unum4=String.valueOf(RoomFrame.roomMsg.getRoomOnline(4))+"/4";				
		if(j==0) {
			String Nickname=RoomFrame.roomMsg.getUser().getNickName();
			getName.setText(Nickname);
			String Score=String.valueOf(RoomFrame.roomMsg.getUser().getScore());
			getScore.setText(Score);
			j++;
		}
        getNum.setText(num2);
        Rnum1.setText(Unum1);
        Rnum2.setText(Unum2);
        Rnum3.setText(Unum3);
        Rnum4.setText(Unum4);        
	}
                      
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
//        jScrollBar1 = new javax.swing.JScrollBar();
        icon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        num = new javax.swing.JPanel();
        getNum = new javax.swing.JLabel();
        playername = new javax.swing.JPanel();
        getName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        grade = new javax.swing.JPanel();
        getScore = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        winrate = new javax.swing.JPanel();
        infSet = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        room1 = new javax.swing.JPanel();
        Rnum1 = new javax.swing.JLabel();
        enter1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        enter2 = new javax.swing.JButton();
        room2 = new javax.swing.JPanel();
        Rnum2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        room3 = new javax.swing.JPanel();
        Rnum3 = new javax.swing.JLabel();
        enter3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        room4 = new javax.swing.JPanel();
        Rnum4 = new javax.swing.JLabel();
        enter4 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        helper = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        maingame = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        
        RoomFrame.this.setIconImage(StaticTool.imageIcon.getImage());
        RoomFrame.this.setTitle("多人扫雷对战");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		RoomFrame.this.setLocation(width / 2 - 500, height / 2 - 350);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        icon.setBackground(new java.awt.Color(204, 204, 204));
        icon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout iconLayout = new javax.swing.GroupLayout(icon);
        icon.setLayout(iconLayout);
        iconLayout.setHorizontalGroup(
            iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        iconLayout.setVerticalGroup(
            iconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("宋体", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("多人扫雷对战");

        jLabel2.setText("在线人数");

        num.setBackground(new java.awt.Color(153, 153, 153));
        

        getNum.setText("0");

        javax.swing.GroupLayout numLayout = new javax.swing.GroupLayout(num);
        num.setLayout(numLayout);
        numLayout.setHorizontalGroup(
                numLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, numLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(getNum)
                    .addContainerGap())
            );
            numLayout.setVerticalGroup(
                numLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, numLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(getNum))
            );

        playername.setBackground(new java.awt.Color(153, 153, 153));
        
        getName.setText("用户名");

        javax.swing.GroupLayout playernameLayout = new javax.swing.GroupLayout(playername);
        playername.setLayout(playernameLayout);
        playernameLayout.setHorizontalGroup(
            playernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playernameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(getName, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        playernameLayout.setVerticalGroup(
            playernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playernameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(getName))
        );

        jLabel3.setText("积分");

        grade.setBackground(new java.awt.Color(153, 153, 153));
        
        getScore.setText("0");

        javax.swing.GroupLayout gradeLayout = new javax.swing.GroupLayout(grade);
        gradeLayout.setHorizontalGroup(
                gradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(getScore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
            );
            gradeLayout.setVerticalGroup(
                gradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradeLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(getScore))
            );

        jLabel4.setText("胜");

        winrate.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout winrateLayout = new javax.swing.GroupLayout(winrate);
        winrate.setLayout(winrateLayout);
        winrateLayout.setHorizontalGroup(
            winrateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        winrateLayout.setVerticalGroup(
            winrateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        infSet.setFont(new java.awt.Font("宋体", 0, 20)); // NOI18N
        infSet.setText("信息设置");
        infSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infSetActionPerformed(evt);
                RoomFrame.this.setVisible(true);
				//new GameFrame(RoomFrame.this.user,RoomFrame.this.connectClient).runGame();
                new InfSetting(RoomFrame.this.user,RoomFrame.this.connectClient).runSet();
            
            }
        });

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 51));
        jLabel5.setText("欢迎来到扫雷");

        jLabel7.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabel7.setText("房间1");

        room1.setBackground(new java.awt.Color(153, 153, 153));

        Rnum1.setText("0/4");

        javax.swing.GroupLayout room1Layout = new javax.swing.GroupLayout(room1);
        room1.setLayout(room1Layout);
        room1Layout.setHorizontalGroup(
            room1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(room1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Rnum1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
        room1Layout.setVerticalGroup(
            room1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Rnum1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        enter1.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        enter1.setText("进入");
        enter1.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				RoomFrame.this.setVisible(false);
				Object[] room1Msg = new Object[] {user,1};
				GameFrame gameFrame = new GameFrame(RoomFrame.this.user,RoomFrame.this.connectClient);
				gameFrame.setBackMsg(new UserBackToRoomMsg(room1Msg));	
				gameFrame.setEnterMsg(new UserEnterGameMsg(room1Msg));
				GameFrame.setIsRoom(1);
				gameFrame.runGame();
				RoomFrame.this.connectClient.sendMsg(new UserEnterGameMsg(room1Msg));
				RoomFrame.this.setVisible(false);
			}
		});

        jLabel8.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabel8.setText("房间2");

        enter2.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        enter2.setText("进入");
        enter2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RoomFrame.this.setVisible(false);
				Object[] room2Msg = new Object[] {user,2};
				GameFrame gameFrame = new GameFrame(RoomFrame.this.user,RoomFrame.this.connectClient);
				gameFrame.setBackMsg(new UserBackToRoomMsg(room2Msg));	
				gameFrame.setEnterMsg(new UserEnterGameMsg(room2Msg));
				GameFrame.setIsRoom(1);
				gameFrame.runGame();
				RoomFrame.this.connectClient.sendMsg(new UserEnterGameMsg(room2Msg));
				RoomFrame.this.setVisible(false);
			}
		});

        room2.setBackground(new java.awt.Color(153, 153, 153));

        Rnum2.setText("0/4");

        javax.swing.GroupLayout room2Layout = new javax.swing.GroupLayout(room2);
        room2.setLayout(room2Layout);
        room2Layout.setHorizontalGroup(
            room2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(room2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Rnum2)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        room2Layout.setVerticalGroup(
            room2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Rnum2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabel9.setText("房间3");

        room3.setBackground(new java.awt.Color(153, 153, 153));

        Rnum3.setText("0/4");

        javax.swing.GroupLayout room3Layout = new javax.swing.GroupLayout(room3);
        room3.setLayout(room3Layout);
        room3Layout.setHorizontalGroup(
            room3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(room3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Rnum3)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        room3Layout.setVerticalGroup(
            room3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Rnum3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        enter3.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        enter3.setText("进入");
        enter3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RoomFrame.this.setVisible(false);
				Object[] room3Msg = new Object[] {user,3};
				GameFrame gameFrame = new GameFrame(RoomFrame.this.user,RoomFrame.this.connectClient);
				gameFrame.setBackMsg(new UserBackToRoomMsg(room3Msg));	
				gameFrame.setEnterMsg(new UserEnterGameMsg(room3Msg));
				GameFrame.setIsRoom(1);
				gameFrame.runGame();
				RoomFrame.this.connectClient.sendMsg(new UserEnterGameMsg(room3Msg));
				RoomFrame.this.setVisible(false);
			}
		});

        jLabel10.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabel10.setText("房间4");

        room4.setBackground(new java.awt.Color(153, 153, 153));

        Rnum4.setText("0/4");

        javax.swing.GroupLayout room4Layout = new javax.swing.GroupLayout(room4);
        room4.setLayout(room4Layout);
        room4Layout.setHorizontalGroup(
            room4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(room4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Rnum4)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        room4Layout.setVerticalGroup(
            room4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Rnum4, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        enter4.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        enter4.setText("进入");
        enter4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RoomFrame.this.setVisible(false);
				Object[] room4Msg = new Object[] {user,4};
				GameFrame gameFrame = new GameFrame(RoomFrame.this.user,RoomFrame.this.connectClient);
				gameFrame.setBackMsg(new UserBackToRoomMsg(room4Msg));	
				gameFrame.setEnterMsg(new UserEnterGameMsg(room4Msg));
				GameFrame.setIsRoom(1);
				gameFrame.runGame();
				RoomFrame.this.connectClient.sendMsg(new UserEnterGameMsg(room4Msg));
				RoomFrame.this.setVisible(false);
			}
		});

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(room1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enter1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(room2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(enter2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(room3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(enter3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(room4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(enter4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(29, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enter1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(room2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enter2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enter3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(room4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enter4)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(254, Short.MAX_VALUE))
        );

        helper.setText("帮助中心");

        jLabel6.setText("游戏界面");

        maingame.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout maingameLayout = new javax.swing.GroupLayout(maingame);
        maingame.setLayout(maingameLayout);
        maingameLayout.setHorizontalGroup(
            maingameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        maingameLayout.setVerticalGroup(
            maingameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        exit.setFont(new java.awt.Font("宋体", 0, 20)); // NOI18N
        exit.setText("退出");
        exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ConnectionManager.releaseAll(null, null, RoomFrame.this.getUser().getConn());
				System.out.println(RoomFrame.this.user.getNickName()+"退出成功");
				RoomFrame.this.connectClient.sendMsg(new UserExitMsg(RoomFrame.this.user));
				UserDaoJdbcImpl.exit(user);
				RoomFrame.this.setVisible(false);
				System.exit(0);
			}
		});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(playername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(winrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(infSet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(72, 72, 72))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(helper)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(maingame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                //.addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                )
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(infSet))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(num, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(exit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(playername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(grade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(winrate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(helper)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maingame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(51, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1003, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>                        

    private void infSetActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RoomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton enter1;
    private javax.swing.JButton enter2;
    private javax.swing.JButton enter3;
    private javax.swing.JButton enter4;
    private javax.swing.JButton exit;
    private static javax.swing.JLabel getName;
    private static javax.swing.JLabel getNum;
    private static javax.swing.JLabel getScore;
    private javax.swing.JPanel grade;
    
    private javax.swing.JButton helper;
    private javax.swing.JPanel icon;
    private javax.swing.JButton infSet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private static javax.swing.JLabel Rnum1;
    private static javax.swing.JLabel Rnum2;
    private static javax.swing.JLabel Rnum3;
    private static javax.swing.JLabel Rnum4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
//    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel maingame;
    private javax.swing.JPanel num;
    private javax.swing.JPanel playername;
    private javax.swing.JPanel room1;
    private javax.swing.JPanel room2;
    private javax.swing.JPanel room3;
    private javax.swing.JPanel room4;
    private javax.swing.JPanel winrate;
    private User user = null;
    private ConnectClient connectClient = null;
    private static GameRoomMsg roomMsg = null;
    private static int j=0;
    //private static String num2=null;
    // End of variables declaration                   
}
