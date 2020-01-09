package msg;



import user.User;

public class ExpandButton extends Msg
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ExpandButton (Object msg)
	{
		this.setMsg(msg);
		this.setMsgType("ExpandButton");
	}
	public User getUser()
	{
		User user = null;
		Object[] msg = (Object[])this.getMsg();
		if(msg[0] instanceof User)user = (User)msg[0];
		return user;
	}
	public Integer getExpand()
	{
		Integer rest = -1;
		Object[] msg = (Object[])this.getMsg();
		if(msg[1] instanceof Integer)rest = (Integer)msg[1];
		return rest;
	}
	public String toString()
	{
		return this.getMsgType()+":"+this.getUser().getAcount()+" has expanded "+this.getExpand();
	}

}
