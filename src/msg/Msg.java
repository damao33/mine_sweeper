package msg;

import java.io.Serializable;

public class Msg implements Serializable
{
	private String msg = null;

	public Msg(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Msg [msg=" + msg + "]";
	}
	
}
