package msg;

public class ExitMsg extends Msg
{
	public ExitMsg(Object msg)
	{
		this.setMsg(msg);
		this.setMsgType(this.getMsg().getClass().toString());
	}
}
