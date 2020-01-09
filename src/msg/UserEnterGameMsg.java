package msg;

import user.User;

public class UserEnterGameMsg extends Msg
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public int getRoom()
	{
		Integer Room = 0;
		Object[] msg = (Object[])this.getMsg();
		if(msg[1] instanceof Integer)
		{
			Room = (Integer) msg[1];
		}
		return Room;
	}
	public UserEnterGameMsg(Object msg)
	{
		this.setMsg(msg);
		this.setMsgType("EnterGameMsg");
	}
	@Override
	public String toString() {
		return this.getMsgType()+":"+this.getUser().getNickName()+" has entered game room "+this.getRoom();
	}
}
