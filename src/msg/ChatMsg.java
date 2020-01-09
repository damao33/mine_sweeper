package msg;

import user.User;

public class ChatMsg extends Msg
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ChatMsg(Object msg)
	{
		this.setMsg(msg);
		this.setMsgType("ChatMsg");
	}
	public User getSender()
	{
		User user = null;
		Object[] msg =(Object[])this.getMsg();
		if(msg[0] instanceof User)user = (User)msg[0];
		return user;
	}
	public String getChat()
	{
		Object[] msg=(Object[])this.getMsg();
		String chat = null;
		if(msg[1] instanceof String)chat = (String) msg[1];
		return chat;
	}
	@Override
	public String toString() {
		if(this.getSender()==null)return this.getChat();
		else return this.getSender().getNickName()+":"+this.getChat();
	}
}
