package msg;

import java.io.Serializable;

public class Msg implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msgType = null;
	private Object msg = null;

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
