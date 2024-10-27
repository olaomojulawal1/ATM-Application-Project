package bptn.ATMAPPLICATION;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



 class AtmServiceTest {
	 
	 private AtmService atmService;
	 
	 @BeforeEach
	 public void setUp() {
		 atmService = new AtmService();
		 atmService.user.setBalance(1000.00); //user balance is initialized for test
	 }
	 
	 
	 
	 @Test
	    public void testWithdrawValidAmount() {
	        // Test a valid withdrawal
	       
		 atmService.withdrawAmount(200.00);
	        assertEquals(800.00, atmService.user.getBalance(), "Balance should be 800.00 after withdrawing 200.00");
	                
	    }
	 
	 @Test
	    public void testDeposit() {
	        // Test a deposit
	        
		 atmService.depositAmount(500.00);
	        assertEquals(1500.00, atmService.user.getBalance(), "Balance should be 1500.00 after depositing 500.00");	 

}

 }