package msg;

import user.User;

public class ChatMsg extends Msg
{
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
		return this.getMsgType()+":"+((User)this.getMsg()).getNickName()+" has exited";
	}
}
