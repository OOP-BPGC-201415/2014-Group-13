import javax.swing.JFrame;


public class User extends JFrame
{
	String name,id,phone,email,accountNumber,passkey;
	float balance;
	static String details;
	
	public User()
	{
		String[] words=details.split("\t");
		this.name=words[0];
		this.id=words[1];
		this.phone=words[2];
		this.email=words[3];
		this.accountNumber=words[4];
		this.passkey=words[5];
		this.balance=Float.parseFloat(words[6]);		
	}
	public User(String title)
	{
		super(title);
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getPasskey() {
		return passkey;
	}
	public float getBalance() {
		return balance;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setPasskey(String passkey) {
		this.passkey = passkey;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	
}
