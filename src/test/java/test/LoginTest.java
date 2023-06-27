package test;



import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import POs.LoginFormPO;
import POs.LoginSuccessPO;


public class LoginTest extends DriverLifeCycleSetting {
	
  private LoginFormPO login;
  private LoginSuccessPO loginSuccess;
  
  @Test
  public void testLoginOK() {
	 login = new LoginFormPO(driver);
	 loginSuccess = (LoginSuccessPO) 
	 login.with("user", "user"); 
	 assertTrue(loginSuccess.successBoxIsPresent());
  }
  
  @Test
  public void testLoginNoOK() {
	 login = new LoginFormPO(driver);
	 login.with("user", "error"); 
	 assertTrue(login.invalidBoxIsPresent());
  }
}
