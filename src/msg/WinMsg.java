package msg;

import user.User;

public class WinMsg extends Msg
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6597163720088996065L;
	public WinMsg(Object msg)
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
		return this.getMsgType()+":"+this.getUser().getNickName()+" win !";
	}
}
