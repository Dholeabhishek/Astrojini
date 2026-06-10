package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Baseclass;
import utils.WaitUtils;
import java.io.File;
import java.nio.file.Paths;

public class EditProfilePage extends Baseclass {
	
	WebDriver driver;
	
	public EditProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class,'nav-link') and contains(@href,'profile')]/span[contains(text(),'Edit Profile')]")
	WebElement edit;
	
	@FindBy(id = "photo")   WebElement userPic;
	@FindBy(name="name") WebElement userName;
	@FindBy(name="email") WebElement userEmail;
	@FindBy(name="phone") WebElement userPhone;
	@FindBy(name="address") WebElement userAddress;
	@FindBy(name="gender") WebElement userGender;
	@FindBy(name="dob" ) WebElement  userDob;
	@FindBy(css=".as_btn.btn_bnr[type='submit']") WebElement userUpdate;
	
	public void clickeditprofile() { 
		WaitUtils.waitForVisibility(driver, edit,10);
		edit.click();}
	
	public void uploadProfilePicture(String filePath) {
		// Skip if file path is empty or null
		if (filePath == null || filePath.trim().isEmpty()) {
			System.out.println("Skipping file upload - empty file path provided");
			return;
		}
		
		WaitUtils.waitForVisibility(driver, userPic, 10);
		
		// Convert Windows paths to cross-platform paths
		String normalizedPath = normalizeFilePath(filePath);
		
		// Validate file exists
		File file = new File(normalizedPath);
		if (!file.exists()) {
			System.out.println("WARNING: Test file not found at: " + normalizedPath);
			System.out.println("Original path: " + filePath);
			// Continue anyway - may be handled by test data setup
			return;
		}
		
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('hidden')", userPic);
			userPic.sendKeys(normalizedPath);
		} catch (Exception e) {
			System.out.println("File upload failed: " + e.getMessage());
			throw e;
		}
	}
	
	/**
	 * Converts Windows paths (D:\pic.jpg) to cross-platform paths
	 * Supports both absolute and relative paths
	 */
	private String normalizeFilePath(String filePath) {
		// If it's a Windows absolute path (D:\, C:\, etc.), convert to relative
		if (filePath.matches("^[A-Z]:\\\\.*")) {
			// Extract filename from Windows path
			String filename = filePath.substring(filePath.lastIndexOf("\\") + 1);
			// Return path relative to project root
			return Paths.get(System.getProperty("user.dir"), "src", "test", "resources", filename).toString();
		}
		return filePath;
	}
	
	public void selectGender(String gender) {
		// Skip if gender is empty
		if (gender == null || gender.trim().isEmpty()) {
			System.out.println("Skipping gender selection - empty value provided");
			return;
		}
		
		Select dropdown = new Select(userGender);
		dropdown.selectByVisibleText(gender);
	}
	
	public void Editprofile(String profilepic, String name, String email, String phone, String address, String gender, String dob) {
		uploadProfilePicture(profilepic);
		
		// Only update fields if they have values
		if (name != null && !name.trim().isEmpty()) {
			userName.clear();
			userName.sendKeys(name);
		}
		
		if (email != null && !email.trim().isEmpty()) {
			userEmail.clear();
			userEmail.sendKeys(email);
		}
		
		if (phone != null && !phone.trim().isEmpty()) {
			userPhone.clear();
			userPhone.sendKeys(phone);
		}
		
		if (address != null && !address.trim().isEmpty()) {
			userAddress.clear();
			userAddress.sendKeys(address);
		}
		
		if (gender != null && !gender.trim().isEmpty()) {
			selectGender(gender);
		}
		
		if (dob != null && !dob.trim().isEmpty()) {
			userDob.clear();
			userDob.sendKeys(dob);
		}

		userUpdate.click();
	}
}
