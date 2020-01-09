package msg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import gameRule.*;
import tool.StaticTool;
import user.User;

public class RestButton extends Msg
{
	public RestButton (Object msg)
	{
		this.setMsg(msg);
		this.setMsgType("RestButton");
	}
	public User getUser()
	{
		User user = null;
		Object[] msg = (Object[])this.getMsg();
		if(msg[0] instanceof User)user = (User)msg[0];
		return user;
	}
	public Integer getRest()
	{
		Integer rest = -1;
		Object[] msg = (Object[])this.getMsg();
		if(msg[1] instanceof Integer)rest = (Integer)msg[1];
		return rest;
	}
	public String toString()
	{
		return this.getMsgType()+":"+this.getUser().getAcount()+" rest "+this.getRest();
	}

}
