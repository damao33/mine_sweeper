package msg;

import java.io.Serializable;

public class Msg implements Serializable
{
	private String msgType = null;
	private Object msg = null;

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public Object getMsg() {
		/*if(this.msgType.equals("LoginMsg"))
		{
			return (LoginMsg)this.msg;
		}else if(this.msgType.equals("ExitMsg"))
		{
			return (ExitMsg)this.msg;
		}else if(this.msgType.equals("EnterGameMsg"))
		{
			return (EnterGameMsg)this.msg;
		}else */return msg;
		
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}
	
}
