
public class Session {
	
	private String prof;
	private String dates;
	private String time;
	
	public Session(String prof, String dates, String time) {
		this.prof = prof;
		this.dates = dates;
		this.time = time;
	}
	
	public String getProf() {
		return prof;
	}
	public String getDates() {
		return dates;
	}
	public String getTime() {
		return time;
	}
	
}
