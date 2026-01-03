package SeleniumSessions;

public class VerifyText {
	
	static public Boolean verifyText(String ExpectedText,String ActualText)
	
	{
		Boolean Flag;
		if (ActualText.equalsIgnoreCase(ExpectedText))
		{
			Flag=true;
		}
		else
		{
			Flag=false;
		}
		return Flag;
	}
	

}
