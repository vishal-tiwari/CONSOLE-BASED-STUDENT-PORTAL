import java.io.Serializable;

class StudentProfile implements Serializable{
	private String username;
	private int password;
	private String name;
	private String branch;
	private long regnumber;
	private String mname;
	private String fname;
	private String gender;
	private int year;
	private String dob;

    public String getUsername() {
        return username;
    }

    public int getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setRegnumber(long regnumber) {
        this.regnumber = regnumber;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public long getRegnumber() {
        return regnumber;
    }

    public String getMname() {
        return mname;
    }

    public String getFname() {
        return fname;
    }

    public String getGender() {
        return gender;
    }

    public int getYear() {
        return year;
    }

    public String getDob() {
        return dob;
    }
        
}