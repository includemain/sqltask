package vo;

public class Auser {

	private String Aname;

	public Auser() {

	}
	
	public Auser(String Aname) {
		this.Aname = Aname;		
	}

	public String getAname() {
		return Aname;
	}


	public void setAname(String aname) {
		Aname = aname;
	}


	public String toString() {
		return "Record [Aname=" + Aname + "]";
	}
}
