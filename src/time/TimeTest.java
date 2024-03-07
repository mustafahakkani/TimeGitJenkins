package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@Test
	public void testGetTotalSecondsGood() {
		int seconds=Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly",seconds==18305);
	}
	
	@Test
	public void testGetTotalSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()->{Time.getTotalSeconds("10:00");});
	}
	
	@Test
	public void testGetTotalSecondsBoundary() {
		int seconds=Time.getTotalSeconds("23:59:59");
		assertTrue("The seconds were not calculated properly",seconds==86399);
	}

	@Test
	public void testGetSecondsGood() {
		int seconds=Time.getTotalSeconds("00:00:59");
		assertTrue("The seconds were not calculated properly",seconds==59);
	}
	
	@Test
	public void testGetSecondsGoodBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()->{Time.getSeconds("00:00:6");});
	}
	
	@Test
	public void testGetSecondsBoundary() {
		int seconds=Time.getTotalSeconds("00:00:59");
		assertTrue("The seconds were not calculated properly",seconds==59);
	}
	
	@Test
	public void testGetTotalMinutesGood() {
		int minutes=Time.getTotalMinutes("00:10:00");
		assertTrue("The minutes were not calculated properly",minutes==10);
	}
	@Test
	public void testGetTotalMinutesBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()->{Time.getTotalMinutes("00:6");});
	}
	@Test
	public void testGetTotalMinutesBoundary() {
		int minutes=Time.getTotalMinutes("00:59:00");
		assertTrue("The minutes were not calculated properly",minutes==59);
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15","05:59:59" })
	void testGetTotalHours(String candidate) {
	int hours = Time.getTotalHours(candidate);
	assertTrue("The hours were not calculated properly",hours ==5);}
	


}
