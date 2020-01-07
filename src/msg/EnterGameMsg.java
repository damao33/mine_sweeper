package msg;

import user.User;

public class EnterGameMsg extends Msg
{
	public EnterGameMsg(Object msg)
	{
		this.setMsg(msg);
		this.setMsgType("EnterGameMsg");
	}
	@Override
	public String toString() {
		return this.getMsgType()+":"+((User)this.getMsg()).getNickName()+" has entered game";
	}
}
