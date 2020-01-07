package msg;

public class LoginMsg extends Msg
{
	public LoginMsg(Object msg)
	{
		this.setMsg(msg);
		this.setMsgType(this.getMsg().getClass().toString());
	}
}
