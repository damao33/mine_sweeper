package msg;

import java.io.Serializable;

public class Msg implements Serializable
{
	private String msgType = null;
	private Object msg = null;

	@Override
	public String toString() {
		return this.msgType+":"+this.msg.toString();
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}
	
}
