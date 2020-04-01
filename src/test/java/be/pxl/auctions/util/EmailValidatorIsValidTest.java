package be.pxl.auctions.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailValidatorIsValidTest {

	@Test
	public void returnsTrueWhenValidEmail() {
		// TODO implement test
	}

	@Test
	public void returnsFalseWhenAtSignMissing() {
		String invalidEmail = "casper.schepers.pxl.be";
		Assertions.assertFalse(EmailValidator.isValid(invalidEmail));
	}

}
