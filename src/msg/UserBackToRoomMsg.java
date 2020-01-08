package msg;

import user.User;

public class UserBackToRoomMsg extends Msg
{
	public UserBackToRoomMsg(Object msg)
	{
		this.setMsg(msg);
		this.setMsgType("BackRoomMsg");
	}
	public User getUser()
	{
		User user = null;
		Object[] msg = (Object[])this.getMsg();
		if(msg[0] instanceof User)user = (User)msg[0];
		return user;
	}
	public Integer getRoom()
	{
		Integer room = 0;
		Object[] msg = (Object[])this.getMsg();
		if(msg[1] instanceof Integer)room = (Integer)msg[1];
		return room;
	}
	@Override
	public String toString() {
		return this.getMsgType()+":"+((User)this.getMsg()).getNickName()+" back to room";
	}
	
}