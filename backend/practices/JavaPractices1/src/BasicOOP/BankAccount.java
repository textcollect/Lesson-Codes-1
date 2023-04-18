package BasicOOP;

public class BankAccount {
	private int bankAccountId;
	private String ownerName;
	private double balance;
	private char type;

	public BankAccount(int bankAccountId, String ownerName, double balance, char type) {
		this.bankAccountId = bankAccountId;
		this.ownerName = ownerName;
		this.balance = balance;
		this.type = type;
	}

	public BankAccount(int bankAccountId, String ownerName, char type) {
		// users are able to deposit a default value of $100
		this.bankAccountId = bankAccountId;
		this.ownerName = ownerName;
		this.balance = 100;
		this.type = type;
	}

	public void setBankAccountId(int bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setType(char type) {
		this.type = type;
	}

	public int getBankAccountId() {
		return bankAccountId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}

	public char getType() {
		return type;
	}

	// method to allow user to perform a deposit
	public void deposit (double amount) {
		this.balance += amount;
	}

	// method to allow user to perform withdrawal
	public boolean withdraw (double amount) {
		if (this.balance - amount >= 0) {
			this.balance -= amount;
			return true;
		}
		return false;
	}

	// pass in amt to be transferred and account to transfer to
	// check if account has the balance to withdraw or not
	// if have balance, return true, if not return false (cannot withdraw/deposit)
//	public boolean transfer (double amount, int bankAccountId) {
//		if ()
//	}

	// toString method
	public String toString() {
		return String.format("Account Name: %s, Balance: %.2f, Account Type: %c",
				this.getOwnerName(), this.getBalance(), this.getType());
	}
}
