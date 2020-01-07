package msg;

import user.User;

public class LoginMsg extends Msg
{
	public LoginMsg(Object msg)
	{
		this.setMsg(msg);
		this.setMsgType("LoginMsg");
	}

	@Override
	public String toString() {
		return this.getMsgType()+":"+((User)this.getMsg()).getNickName()+" has logined";
	}
	
}
