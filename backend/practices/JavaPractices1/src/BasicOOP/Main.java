package BasicOOP;

public class Main {
	public static void main(String[] args) {
		BankAccount jean0 = new BankAccount(111, "Jean", 1000, 'O');
		BankAccount jean1 = new BankAccount(112, "Jean", 2000, 'I');

		BankAccount tim0 = new BankAccount(113, "Tim", 'O');

		//String str1 = String.format("Account Name: %s, Balance: %.2f, Account Type: %c", jean0.getOwnerName(), jean0.getBalance(), jean0.getType());
		String str1 = jean0.toString();
		System.out.println(str1);

		// Alternative - invokes `toString` indirectly by invoking `print` or `println`
		System.out.println(jean0);

		jean0.deposit(200);
		System.out.println(jean0);

		if (tim0.withdraw(500)) {
			System.out.println("Successful withdraw from the account.");
		}
		else {
			System.out.println("Insufficient balance, unable to withdraw");
		}
	}
}
