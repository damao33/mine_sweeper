package msg;

import user.User;

public class UserExitMsg extends Msg
{
	public UserExitMsg(Object msg)
	{
		this.setMsg(msg);
		this.setMsgType("ExitMsg");
	}
	public User getUser()
	{
		User user = null;
		if(this.getMsg() instanceof User)user = (User)this.getMsg();
		return user;
	}
	@Override
	public String toString() {
		return this.getMsgType()+":"+((User)this.getMsg()).getNickName()+" has exited";
	}
}
