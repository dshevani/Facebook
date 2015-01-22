package facebookCoding;
/*
 * Given N credits cards, determine if more than half of them belong to the same
person/owner.
All you have is an array of the credit card numbers, and an api call like
isSamePerson(num1, num2).
 */
public class CreditCards {
	
	public boolean isMajority(String[] creditCards) {
		if (creditCards == null)
			throw new NullPointerException("Null array!");
		if (creditCards.length == 0)
			return false;
		String majority = creditCards[0];
		int count = 1;
		for (String s : creditCards) {
			if (isSamePerson(s, majority))
				count++;
			else
				count--;
			if (count == 0) {
				majority = s;
				count = 1;
			}
		}
		count = 0;
		for (String s :creditCards) {
			if (isSamePerson(s, majority))
				count++;
		}
		return count >= creditCards.length;
	}
	//random isSamePerson method
	private boolean isSamePerson(String num1, String num2) {
		if (num1.substring(0, 4).equals(num2.substring(0, 4)))
			return true;
		return false;
	}

}
