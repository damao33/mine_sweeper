package msg;

import user.User;

public class ExitMsg extends Msg
{
	public ExitMsg(Object msg)
	{
		this.setMsg(msg);
		this.setMsgType("ExitMsg");
	}
	@Override
	public String toString() {
		return this.getMsgType()+":"+((User)this.getMsg()).getNickName()+" has exited";
	}
}
