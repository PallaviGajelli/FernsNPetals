package fernsNPetals.pages;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import fernsNPetals.base.TestBase;

public class Accounts extends TestBase {

	@FindBy(xpath = "//*[@id=\'name-input\']")
	public WebElement regnameacc;
	@FindBy(xpath = "//*[@id=\'mobile-input\']")
	public WebElement regmobileacc;
	@FindBy(xpath = "//*[@id=\'createpassword-input\']")
	public WebElement regPasswordacc;
	@FindBy(xpath = "//*[@id=\"remember-check\"]/i[1]")
	public WebElement remembercheckacc;
	@FindBy(xpath = "//*[@id=\"forget-pass\"]")
	public WebElement forgetpassacc;
	@FindBy(xpath = "//*[@id=\"login-section\"]/div[3]/div[1]/p")
	public WebElement forgotpassMsgacc;
	@FindBy(xpath = "//*[@id=\"forgot-ok\"]")
	public WebElement forgotokacc;

	@FindBy(xpath = "//span[text()='Name is required']")
	public WebElement Nameisrequiredacc;
	@FindBy(xpath = "//span[text()='Mobile number is required']")
	public WebElement Mobilenumberisrequiredacc;
	@FindBy(xpath = "//span[text()='Password is required']")
	public WebElement Passwordisrequiredacc;

	@FindBy(xpath = "//*[@id=\'email-input\']")
	public WebElement emailboxinaccounts;
	@FindBy(xpath = "//*[@id=\'continue\']/span[1]")
	public WebElement continuebtninAccounts;
	@FindBy(xpath = "//*[@id=\"login-withopt\"]/span[1]")
	public WebElement loginwithoptacc;
	@FindBy(xpath = "//div[@class='resend-otp resent']")
	public WebElement ResendOTPacc;
	@FindBy(xpath = "//*[@id=\"otpsent\"]/span[1]") // Enter the OTP sent to:
	public WebElement EntertheOTPsenttoacc;
	@FindBy(xpath = "//*[@id=\'email-box\']/span")
	public WebElement EmailIDisrequired;
	@FindBy(xpath = "//*[@id=\'password-input\']")
	public WebElement passboxinAccounts;
	@FindBy(xpath = "//*[@id=\'password-box\']/span[2]")
	public WebElement invalidEmailIDorPass;

	@FindBy(xpath = "//a[text()='My Profile']")
	public WebElement MyProfile;
	@FindBy(xpath = "//*[@id=\"myaccountlink\"]/ul[1]/li[1]/a")
	public WebElement EditProfileinMyPro ;
	
	@FindBy(xpath = "//*[@id=\"myaccountlink\"]/ul[1]/li[2]/a")
	public WebElement ChangePasswordinMyPro;
	@FindBy(xpath = "//*[@id=\"currentpassword\"]")
	public WebElement currentpassword;
	@FindBy(xpath = "//*[@id=\"newpassword\"]")
	public WebElement newpassword;
	@FindBy(xpath = "//*[@id=\"verifypassword\"]")
	public WebElement verifypassword;
	@FindBy(xpath = "//*[@id=\"passwordfrm\"]/div[4]/div[2]/input")
	public WebElement savebtn;
	@FindBy(xpath = "//*[@id=\"passwordfrm\"]/div[4]/div[2]/a")
	public WebElement Cancelbtn;
	@FindBy(xpath = "//*[@id=\"passwordfrm\"]/span")//Done!  From now on, you can start signing in with your new password.
	public WebElement successfulChangeOfPassmsg;
	@FindBy(xpath = "//*[@id=\"passwordfrm\"]/div[2]/div")//Current password and New password did not match.
	public WebElement samePassErrorMsg;
	@FindBy(xpath = "//*[@id=\"passwordfrm\"]/div[3]/div")//New Password and Verify Password not match.
	public WebElement errorPassMissmatch;
	@FindBy(xpath = "//*[@id=\"passwordfrm\"]/div[1]/div")// Current Password is required.
	public WebElement errorCpassIsReq;
	@FindBy(xpath = "//*[@id=\"passwordfrm\"]/div[2]/div")//Password should be at least 6 characters.
	public WebElement errorPass;
	
	public static String RandomString()
	{
		int length = 6;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		// System.out.println(generatedString);
		return generatedString;
	}
	
	
	public void ChangePassUIverification() {
//		*Current Password
		Assert.assertEquals((currentpassword.isDisplayed()), true);
		System.out.println("currentpassword is displayed");
//		*New Password
		Assert.assertEquals((newpassword.isDisplayed()), true);
		System.out.println("newpassword is displayed");
//		*Verify New Password
		Assert.assertEquals((verifypassword.isDisplayed()), true);
		System.out.println("verifypassword is displayed");
//		cancel and save button
		Assert.assertEquals((Cancelbtn.isDisplayed()), true);
		System.out.println("Cancelbtn is displayed");
		Assert.assertEquals((savebtn.isDisplayed()), true);
		System.out.println("savebtn is displayed");
	}
	
	
	@FindBy(xpath = "//a[text()='Track Order']")
	public WebElement TrackOrder;
	@FindBy(xpath = "//*[@id=\"myaccountlink\"]/ul[2]/li/a")
	public WebElement MyOrders;
	@FindBy(xpath = "//*[@id=\'my-orders\']/table/tbody/tr/td")
	public WebElement ordersinMyOrders;
//	@FindBy(xpath = "")
//	public WebElement ;

	
	
	public WebElement AddressBook;
	@FindBy(xpath = "//a[text()='Gift Vouchers']")
	public WebElement GiftVouchers;
	@FindBy(xpath = "//*[@id=\"myaccountlink\"]/ul[3]/li[1]/a")
	public WebElement used;
	@FindBy(xpath = "//*[@id=\"myaccountlink\"]/ul[3]/li[2]/a")
	public WebElement unused;
	@FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/div[2]")
	public WebElement usedGiftCoupanCodes;
	@FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/div[2]")
	public WebElement unusedGiftCoupanCodes;
	
	
	@FindBy(xpath = "//a[text()='Tickets']")
	public WebElement Tickets;
	@FindBy(xpath = "//span[text()='Hi Guest']")
	public WebElement HiGuest;
	@FindBy(xpath = "//span[text()='Facebook']")
	public WebElement Facebook;
	@FindBy(xpath = "//span[text()='Google']")
	public WebElement Google;
	@FindBy(xpath = "//*[@id='email']")
	public WebElement emailOrPhone;
	@FindBy(xpath = "//*[@id=\'pass\']")
	public WebElement pass;
	@FindBy(xpath = "//*[@id='loginbutton']")
	public WebElement loginbutton;
	@FindBy(xpath = "//*[@id='identifierId']")
	public WebElement gmailEmailIdTextbox;
	@FindBy(xpath = "//*[@id='identifierNext']/content/span")
	public WebElement emailnextbtningoogle;
	@FindBy(xpath = "//*[@id='password']/div[1]/div/div[1]/input")
	public WebElement passGoogle;
	@FindBy(xpath = "//*[@id=\'passwordNext\']/content/span")
	public WebElement passGooglenextbtn;

	@FindBy(xpath = "//h4[text()='My Account']")
	public WebElement MyAccountHeading;
	@FindBy(xpath = "//h6[text()='My Profile']")
	public WebElement MyProfilemyacc;
	@FindBy(xpath = "//h6[text()='Orders']")
	public WebElement Ordersmyacc;
	@FindBy(xpath = "//h6[text()='Gift Coupons']")
	public WebElement GiftCouponsmyacc;
	@FindBy(xpath = "//h6[text()='Ticket History']")
	public WebElement TicketHistorymyacc;
	
	@FindBy(xpath = "//h6[text()='Saved Address(s)']")
	public WebElement SavedAddressmyacc;
	@FindBy(xpath = "//*[@id=\"myaccountlink\"]/ul[5]/li/a")
	public WebElement  AllAddress;
	@FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/div/div")
	public WebElement  SavedAddinsideAllAdd;
	
	@FindBy(xpath = "//h6[text()='Reminders']")
	public WebElement Remindersmyacc;
	@FindBy(xpath = "//*[@id=\"myaccountlink\"]/ul[6]/li[1]")
	public WebElement MyReminders;
	@FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/div[2]")
	public WebElement AllremindersinMyRem;
	@FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/div[3]/div[1]/h4")
	public WebElement AddNewReminderHin_AddnewRem;
	@FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/div[1]/h4")
	public WebElement MyReminderHin_AddNewRem;
	@FindBy(xpath = "//*[@id=\"myaccountlink\"]/ul[6]/li[2]")
	public WebElement AddNewReminders;
	@FindBy(xpath = "//*[@id=\"remindername\"]")
	public WebElement Remname;
	@FindBy(xpath = "//*[@id=\"occasiontext\"]")
	public WebElement RemSelectoccasion ;
	@FindBy(xpath = "//*[@id=\"newreminderfrm\"]/table/tbody/tr[3]/td/span")
	public WebElement RemSelectdate;
	@FindBy(xpath = "//*[@id=\"input_0\"]")
	public WebElement RemNotes;
	@FindBy(xpath = "//*[@id=\"newreminderfrm\"]/div/div/div/a")
	public WebElement Remcancel;
	@FindBy(xpath = "//*[@id=\"newreminderfrm\"]/div/div/div/input")
	public WebElement Remsave;
//	@FindBy(xpath = "")
//	public WebElement ;
	
	public void AddNewReminderUIverification() {
//		My Reminders
		Assert.assertEquals((MyReminderHin_AddNewRem.isDisplayed()), true);
		System.out.println(" MyReminderHin_AddNewRem displayed");
//		Add New Reminders
		Assert.assertEquals((AddNewReminderHin_AddnewRem.isDisplayed()), true);
		System.out.println("AddNewReminderHin_AddnewRem is displayed");
//		Name
		Assert.assertEquals((Remname.isDisplayed()), true);
		System.out.println(" Remname is displayed");
//		Select occasion
		Assert.assertEquals((RemSelectoccasion.isDisplayed()), true);
		System.out.println("RemSelectoccasion is displayed");
//		Select date
		Assert.assertEquals((RemSelectdate.isDisplayed()), true);
		System.out.println("RemSelectdate is displayed");
//		Notes
		Assert.assertEquals((RemNotes.isDisplayed()), true);
		System.out.println("RemNotes is displayed");
//		cancel and save button
		Assert.assertEquals((Remcancel.isDisplayed()), true);
		System.out.println(" Remcancel is displayed");
		Assert.assertEquals((Remsave.isDisplayed()), true);
		System.out.println("Reminder save btn is displayed");
	}
	
	@FindBy(xpath = "//*[@id=\"myaccountlink\"]/ul[7]/li/a")
	public WebElement Logoutmyacc;

	@FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/form/div/div/div/table/thead/tr/th[1]/span")
	public WebElement namemyacc;
	@FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/form/div/div/div/table/tbody/tr[1]/td[3]")
	public WebElement mobilenomyacc;
	@FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/form/div/div/div/table/tbody/tr[2]/td[3]")
	public WebElement emailIdmyacc;
	@FindBy(xpath = "//*[@id=\"myaccountlink\"]/div/span/a")
	public WebElement homemyacc;
	@FindBy(xpath = "//*[@id=\"myaccountlink\"]/div/span")
	public WebElement home_myaccount;

	@FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/form/div/div/div/table/thead/tr/th[1]/a[1]")
	public WebElement dotEditmyaccD;
	@FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/form/div/div/div/table/thead/tr/th[1]/a[2]")
	public WebElement EditmyaccD;
	@FindBy(xpath = "//*[@id=\"input_0\"]")
	public WebElement NameEMA;
	@FindBy(xpath = "//*[@id=\"input_1\"]")
	public WebElement MobilenumberEMA;
	@FindBy(xpath = "//*[@id=\"input_2\"]")
	public WebElement EmailidEMA;
	@FindBy(xpath = "//span[text()='* Gender']")
	public WebElement GenderEMA;
	@FindBy(xpath = "//*[@id=\"editProfile\"]/div/div[4]/label[1]/input")
	public WebElement GenderM_EMA;
	@FindBy(xpath = "//*[@id=\"editProfile\"]/div/div[4]/label[2]/input")
	public WebElement GenderF_EMA;
	@FindBy(xpath = "//span[text()='Date of birth']")
	public WebElement DateofBirthEMA;
	@FindBy(xpath = "//span[text()='Date of anniversary ']")
	public WebElement DateofanniversaryEMA;
	@FindBy(xpath = "//*[@id=\"input_3\"]")
	public WebElement AddressEMA;
	@FindBy(xpath = "//*[@id=\"input_4\"]")
	public WebElement cityEMA;
	@FindBy(xpath = "//*[@id=\"editProfile_countryGeoId\"]") // can use select
	public WebElement countryEMA;
	@FindBy(xpath = "//*[@id=\"input_5\"]")
	public WebElement PincodeEMA;
	@FindBy(xpath = "//*[@id=\"submit\"]")
	public WebElement SaveandContinuebuttonEMA;

	public void fillRegistrationForm() throws InterruptedException {

		Thread.sleep(1000);
		regnameacc.sendKeys("leena");
		Thread.sleep(1000);
		regmobileacc.sendKeys("9876543210");
		Thread.sleep(1000);
		regPasswordacc.sendKeys("fnptest88");
		Thread.sleep(1000);
		continuebtninAccounts.click();
		Thread.sleep(1000);
	}

	public void AccountLoginwithValidID() throws InterruptedException {

		emailboxinaccounts.sendKeys("testmeapp1@gmail.com");
		Thread.sleep(1000);
		continuebtninAccounts.click();
		Thread.sleep(1000);
		passboxinAccounts.sendKeys("test@2018");
		Thread.sleep(1000);
		continuebtninAccounts.click();
		Thread.sleep(1000);
	}

	public void AccountsDetailsPage() {
		Assert.assertEquals((driver.getCurrentUrl().contains("https://www.fnp.com/account/my-account")), true);
		System.out.println("Browser is navigating to the Account details page");
	}

	public void Accountverification() {

//		Hi Guest
		Assert.assertEquals((HiGuest.isDisplayed()), true);
		System.out.println("HiGuest is displayed");
//		My Profile
		Assert.assertEquals((MyProfile.isDisplayed()), true);
		System.out.println("MyProfile is displayed");
//		Track Order
		Assert.assertEquals((TrackOrder.isDisplayed()), true);
		System.out.println("TrackOrder is displayed");
//		My Orders
		Assert.assertEquals((MyOrders.isDisplayed()), true);
		System.out.println("MyOrders is displayed");
//		Address Book
		Assert.assertEquals((AddressBook.isDisplayed()), true);
		System.out.println("AddressBook is displayed");
//		Gift Vouchers
		Assert.assertEquals((GiftVouchers.isDisplayed()), true);
		System.out.println("GiftVouchers is displayed");
//		Tickets
		Assert.assertEquals((Tickets.isDisplayed()), true);
		System.out.println("Tickets is displayed");
	}

	public void AccountsUrlVerification() {
		Assert.assertEquals((driver.getCurrentUrl().contentEquals("https://www.fnp.com/account/my-account")), true);
		System.out.println("Browser is navigating to Login /Sign Up page");
	}

	public void AccountPageVerification() {
//		1) Social network login with Facebook and Gmail 
		Assert.assertEquals((Facebook.isDisplayed()), true);
		System.out.println("Facebook is displayed");
//		2) Guest login Email and continue buttons
		Assert.assertEquals((Google.isDisplayed()), true);
		System.out.println("Google is displayed");
	}

	public void registrationPageVerification() {
//		name, 
		Assert.assertEquals((regnameacc.isDisplayed()), true);
		System.out.println("regname is displayed");
//		mobile number
		Assert.assertEquals((regmobileacc.isDisplayed()), true);
		System.out.println("regmobile is displayed");
//		create password and 
		Assert.assertEquals((regPasswordacc.isDisplayed()), true);
		System.out.println("regPassword is displayed");
//		continue button 
		Assert.assertEquals((continuebtninAccounts.isDisplayed()), true);
		System.out.println("continue btn on regisPage is displayed");
	}

	public void registrationPageErrorVerification() {
//		name, 
		Assert.assertEquals((Nameisrequiredacc.isDisplayed()), true);
		System.out.println("Name is required in acc is displayed");
//		mobile number
		Assert.assertEquals((Mobilenumberisrequiredacc.isDisplayed()), true);
		System.out.println("Mobile number is required in acc is displayed");
//		create password 
		Assert.assertEquals((Passwordisrequiredacc.isDisplayed()), true);
		System.out.println("Password is required in acc is displayed");
	}

	public void MyAccountVerification() {
//		Home>My Account
		Assert.assertEquals((home_myaccount.isDisplayed()), true);
		System.out.println("home_myaccount is displayed");
//		1.My Account
		Assert.assertEquals((MyAccountHeading.isDisplayed()), true);
		System.out.println("MyAccountHeading is displayed");
//		2.My Profile
		Assert.assertEquals((MyProfilemyacc.isDisplayed()), true);
		System.out.println("MyProfilemyacc is displayed");
//		3. Orders
		Assert.assertEquals((Ordersmyacc.isDisplayed()), true);
		System.out.println("Ordersmyacc is displayed");
//		4.Gift Coupons
		Assert.assertEquals((GiftCouponsmyacc.isDisplayed()), true);
		System.out.println("GiftCouponsmyacc is displayed");
//		5.Saved Address(s)
		Assert.assertEquals((SavedAddressmyacc.isDisplayed()), true);
		System.out.println("SavedAddressmyacc is displayed");
//		6.Reminders
		Assert.assertEquals((Remindersmyacc.isDisplayed()), true);
		System.out.println("Remindersmyacc is displayed");
//		7.Logout 
		Assert.assertEquals((Logoutmyacc.isDisplayed()), true);
		System.out.println("Logoutmyacc is displayed");
//		and right side of the page there is window which shows the deatils of the profile
//		Name
		Assert.assertEquals((namemyacc.isDisplayed()), true);
		System.out.println("namemyacc is displayed");
//		mobile number
		Assert.assertEquals((mobilenomyacc.isDisplayed()), true);
		System.out.println("mobilenomyacc is displayed");
//		mail id
		Assert.assertEquals((emailIdmyacc.isDisplayed()), true);
		System.out.println("emailIdmyacc is displayed");
	}

	public void EditMyAccountVerification() throws InterruptedException {

		dotEditmyaccD.click();
		Thread.sleep(1000);
		EditmyaccD.click();
		Thread.sleep(1000);

//		Name
		Assert.assertEquals((NameEMA.isDisplayed()), true);
		System.out.println("NameEMA is displayed");
//		Mobile number
		Assert.assertEquals((MobilenumberEMA.isDisplayed()), true);
		System.out.println("MobilenumberEMA is displayed");
//		Email id
		Assert.assertEquals((EmailidEMA.isDisplayed()), true);
		System.out.println("EmailidEMA is displayed");
//		Gender
		Assert.assertEquals((GenderEMA.isDisplayed()), true);
		System.out.println("GenderEMA is displayed");
//		Date of Birth
		Assert.assertEquals((DateofBirthEMA.isDisplayed()), true);
		System.out.println("DateofBirthEMA is displayed");
//		Date of anniversary
		Assert.assertEquals((DateofanniversaryEMA.isDisplayed()), true);
		System.out.println("DateofanniversaryEMA is displayed");
//		Address
		Assert.assertEquals((AddressEMA.isDisplayed()), true);
		System.out.println("AddressEMA is displayed");
//		city
		Assert.assertEquals((cityEMA.isDisplayed()), true);
		System.out.println("cityEMA is displayed");
//		country
		Assert.assertEquals((countryEMA.isDisplayed()), true);
		System.out.println("countryEMA is displayed");
//		Pincode
		Assert.assertEquals((PincodeEMA.isDisplayed()), true);
		System.out.println("PincodeEMA is displayed");
//		Save and Continue button
		Assert.assertEquals((SaveandContinuebuttonEMA.isDisplayed()), true);
		System.out.println("SaveandContinuebuttonEMA is displayed");
	}

	public void EditMyAccount(String name, String gender, String address, String city, String pincode)
			throws InterruptedException {
//		6.click on Edit profile link
		dotEditmyaccD.click();
		Thread.sleep(1000);
		EditmyaccD.click();
		Thread.sleep(1000);
//		7.change name
		NameEMA.clear();
		Thread.sleep(1000);
		NameEMA.sendKeys(name);
//		8.select gender
		if (gender == "F") {
			GenderF_EMA.click();
		} else {
			GenderM_EMA.click();
		}
//		9.Enter address in the textbox
		AddressEMA.sendKeys(address);
//		10.Enter city
		cityEMA.sendKeys(city);
//		11.Enter pincode
		PincodeEMA.sendKeys(pincode);
		Thread.sleep(1000);
//		12.click on Save button
		SaveandContinuebuttonEMA.click();
		System.out.println("Seccessfully edited My account");
	}
}
