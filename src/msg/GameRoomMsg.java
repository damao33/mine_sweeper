package msg;

import java.util.*;

import user.User;

public class GameRoomMsg extends Msg
{	
	public GameRoomMsg(Object msg)
	{
		this.setMsg(msg);
		this.setMsgType("GameRoomMsg");
	}
	public Integer getOnline()
	{
		Integer online = -1;
		Object[] msg = (Object[])this.getMsg();
		if(msg[0] instanceof Integer)online = (Integer)msg[0];
		return online;		
	}
	public Integer getRoomOnline(int room)
	{
		Integer roomOnline = 0;
		Object[] msg = (Object[])this.getMsg();
		if(msg[room] instanceof Integer)roomOnline = (Integer)msg[room];
		return roomOnline;
	}
//	public Set getUserSet()
//	{
//		Set<User> userSet = new HashSet<>();
//		Object[] msg = (Object[])this.getMsg();
//		if(msg[5] instanceof GameRoomMsg)userSet = (HashSet)msg[5];
//		return userSet;
//	}
	public User getUser()
	{
		User user = null;
		Object[] msg = (Object[])this.getMsg();
		if(msg[5] instanceof User)user = (User)msg[5];
		return user;		
	}
	public Integer getScore()
	{
		Integer score = 0;
		Object[] msg = (Object[])this.getMsg();
		if(msg[5] instanceof User)score = this.getUser().getScore();
		return score;		
	}
	@Override
	public String toString() {
		return this.getMsgType()+":Online-"+this.getOnline()+"\nroom1-"+this.getRoomOnline(1)+" room2-"+this.getRoomOnline(2)
				+" room3-"+this.getRoomOnline(3)+" room4-"+this.getRoomOnline(4)+"\nUser "+this.getUser().getNickName()
				+" score-"+this.getScore()+" has logined";
	}
	
}
