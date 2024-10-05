package VoterException;

public class VotersException extends RuntimeException

{
	String msg;

	public VotersException(String msg) 
	{
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
