package msg;

import user.User;

public class BackRoomMsg extends Msg
{
	public BackRoomMsg(Object msg)
	{
		this.setMsg(msg);
		this.setMsgType("BackRoomMsg");
	}
	public User getUser()
	{
		User user = null;
		if(this.getMsg() instanceof User)user = (User)this.getMsg();
		return user;
	}
	@Override
	public String toString() {
		return this.getMsgType()+":"+((User)this.getMsg()).getNickName()+" back to room";
	}
	
}