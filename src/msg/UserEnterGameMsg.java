package msg;

import user.User;

public class UserEnterGameMsg extends Msg
{
	public User getUser()
	{
		User user = null;
		Object[] msg = (Object[])this.getMsg();
		if(msg[0] instanceof User)
		{
			user = (User) msg[0];
		}
		return user;
	}
	public int getGameRoom()
	{
		Integer gameRoom = 0;
		Object[] msg = (Object[])this.getMsg();
		if(msg[1] instanceof Integer)
		{
			gameRoom = (Integer) msg[1];
		}
		return gameRoom;
	}
	public UserEnterGameMsg(Object msg)
	{
		this.setMsg(msg);
		this.setMsgType("EnterGameMsg");
	}
	@Override
	public String toString() {
		return this.getMsgType()+":"+this.getUser().getNickName()+" has entered game room "+this.getGameRoom();
	}
}
