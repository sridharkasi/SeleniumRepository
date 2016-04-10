package week3;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//mport java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.base.CaseFormat;



public class WrapperClass {
	
	RemoteWebDriver Driver;
	
	//username
	//password
	//class decorativeSubmit
	//*************************************************************************************************************************
	// Method Name: EnterTextbyID
	// Enter Text input
		public void EnterbyID(String id) throws IOException
	{
			
			String Arr[] = SearchRepostry(id);
			
		try {
			
			
			Driver.findElement(By.id(Arr[0])).clear();
			Driver.findElement(By.id(Arr[0])).sendKeys(Arr[1]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No Such Element "+id+" Found");
		}
	}
		
//*************************************************************************************************************************
// Method Name: EnterTextbyName
// Enter Text input
//*************************************************************************************************************************
public void EnterbyName(String name) throws IOException
{
		
		String Arr[] = SearchRepostry(name);
		
	try {
		
		
		Driver.findElement(By.name(Arr[0])).clear();
		Driver.findElement(By.name(Arr[0])).sendKeys(Arr[1]);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("No Such Element "+Arr[0]+" Found");
	}
}
//*************************************************************************************************************************
// Method Name: EnterTextbyClass
// Enter Text input
//*************************************************************************************************************************		
public void EnterbyClass(String classname) throws IOException
{
		
String Arr[] = SearchRepostry(classname);
	
try {
	
	
	Driver.findElement(By.className(Arr[0])).clear();
	Driver.findElement(By.className(Arr[0])).sendKeys(Arr[1]);
} catch (Exception e) {
	// TODO Auto-generated catch block
System.out.println("No Such Element "+Arr[0]+" Found");
	}
}

//*************************************************************************************************************************	
public void EnterbyXpath(String classname) throws IOException
{
		
String Arr[] = SearchRepostry(classname);
	
try {
	
	
	Driver.findElement(By.xpath(Arr[0])).clear();
	Driver.findElement(By.xpath(Arr[0])).sendKeys(Arr[1]);
} catch (Exception e) {
	// TODO Auto-generated catch block
System.out.println("No Such Element "+Arr[0]+" Found");
	}
}
			
//*************************************************************************************************************************
// Method Name: clickbyXpath
// Find element by xpath and click
//*************************************************************************************************************************				
public void clickbyXpath(String xpath) throws IOException
{
	String Arr[] = SearchRepostry(xpath);
	try {
	Driver.findElement(By.xpath(Arr[0])).click();
} catch (Exception e) {
	// TODO Auto-generated catch block
	System.out.println("No Such Element "+Arr[0]+" Found");
}
}

//*************************************************************************************************************************
// Method Name: clickbyXpath
// Find element by xpath and click
//*************************************************************************************************************************		
public void clickbyclass(String clsname)
{

try {
	Driver.findElement(By.className(clsname)).click();
} catch (Exception e) {
	// TODO Auto-generated catch block
	System.out.println("No Such Element "+clsname+" Found");
}
}

//*****************************************************************
public void clickbyLinkText(String LinkText)
{

try {
	By.tagName("a");
	Driver.findElement(By.linkText(LinkText)).click();
} catch (Exception e) {
	// TODO Auto-generated catch block
	System.out.println("No Such Element "+LinkText+" Found");
}
}
//************************************************************************************************************************
public void clickbyname(String clsname)
{

try {
	Driver.findElement(By.name(clsname)).click();
} catch (Exception e) {
	// TODO Auto-generated catch block
	System.out.println("No Such Element "+clsname+" Found");
}
}
//*************************************************************************************************************************
	public void Launch(String Browser, String url)
	{
		try {
			if(Browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				Driver = new ChromeDriver();	
				
			}
			else if (Browser.equalsIgnoreCase("firefox")){
				Driver = new FirefoxDriver();
				
				
			}
			Driver.get(url);
			Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Driver.manage().window().maximize();
		} catch(Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Browser Not launced");
		}
		
	}
	
	

//***********************************************************************************************************************

public void selectvaluebyindex(String String) throws IOException
{
		
String Arr[] = SearchRepostry(String);
	
try {
	
	Select dropdown = new Select(Driver.findElement(By.id(Arr[0])));
	int x = Integer.parseInt(Arr[1]);
	
	dropdown.selectByIndex(x);
	
	//Driver.findElement(By.(Arr[0])).sendKeys(Arr[1]);
} catch (Exception e) {
	// TODO Auto-generated catch block
System.out.println("No Such Element "+Arr[0]+" Found");
	}
}

//***********************************************************************************************************************
public void selectByValue(String String) throws IOException
{
		
String Arr[] = SearchRepostry(String);
	
try {
	
	Select dropdown = new Select(Driver.findElement(By.id(Arr[0])));
	//int x = Integer.parseInt(Arr[1]);
	
	dropdown.selectByValue(Arr[1]);
	
	//Driver.findElement(By.(Arr[0])).sendKeys(Arr[1]);
} catch (Exception e) {
	// TODO Auto-generated catch block
System.out.println("No Such Element "+Arr[0]+" Found");
	}
}
//***********************************************************************************************************************
public void selectByVisibleText(String String) throws IOException
{
		
String Arr[] = SearchRepostry(String);
	
try {
	
	Select dropdown = new Select(Driver.findElement(By.id(Arr[0])));
	//int x = Integer.parseInt(Arr[1]);
	
	dropdown.selectByVisibleText(Arr[1]);
	
	//Driver.findElement(By.(Arr[0])).sendKeys(Arr[1]);
} catch (Exception e) {
	// TODO Auto-generated catch block
System.out.println("No Such Element "+Arr[0]+" Found");
	}
}
//

public String getmainwindow() {
	String mainwindow;
	
	mainwindow = Driver.getWindowHandle();
	
	return mainwindow;


}

public void SwitchtoPrimaryWindow(String mainwindow) {


	Driver.switchTo().window(mainwindow);


}

public void SwitchtoLastWindow(String mainwindow) {

	
	//String lastwindow = null;
	//String CurrentWindow;
	//Driver.switchTo().window(lastwindow);
	//CurrentWindow = Driver.getWindowHandle();
	//System.out.println("Primary Window SessionID["+Driver.getSessionId()+"]");
	Set<String> windowobj = Driver.getWindowHandles();
	for (String string : windowobj) {
		
		if(!mainwindow.equals(string))
		
			Driver.switchTo().window(string);
			System.out.println(Driver.getSessionId());
	}
	
	//System.out.println("Parent Window "+ Driver.getTitle());
	System.out.println("Switch to Window SessionID["+ Driver.getSessionId()+"]");
	}
	
	


public void SwitchToFrameByElement(String String){
	
	
	Driver.switchTo().frame(Driver.findElement(By.name(String)));
	
}

public void SwitchToFirstFrame(String String){
	int getsize= Driver.findElements(By.name(String)).size();
	int firstframe = getsize-(getsize-1);
	
	Driver.switchTo().frame(firstframe);
	
}

public void acceptAlert(){
	try {
		//Driver.switchTo().
		Thread.sleep(200);
		
		Alert a = Driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("No Alert is Displayed");
	}
	
}

public void dismissAlert(){
	try {
		Thread.sleep(200);
		Driver.switchTo().alert();
		Alert a = Driver.switchTo().alert();
		System.out.println(a.getText());
		a.dismiss();
	} catch (Exception e) {
		
		// TODO Auto-generated catch block
		System.out.println("No Alert is Displayed");
	}
	
}


public void verifyurl(String url){
	
	try {
		//String Arr[] = SearchRepostry(url);
		
		String currenturl = Driver.getCurrentUrl();
		//Assert.assertEquals(currenturl, url);
		//currenturl.contains(url)
		if (currenturl.contains(url)) {
			System.out.println("Verify URL ::[URL info Mathes]");
		}
		else{
			System.out.println("Verify URL ::[URL info Not Mathes]");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Unable to verify the URL["+url+"]");
	}
	}

public void verifyText(String obj, String text) throws IOException{
	
	String Arr[] = SearchRepostry(obj);
	try {
		

	String Gettxt = null;
	if (Driver.findElementById(Arr[0]).isDisplayed()){
		Gettxt = Driver.findElementById(obj).getText();}
	else if (Driver.findElementByName(Arr[0]).isDisplayed()){
		Gettxt = Driver.findElementByName(obj).getText();}
	else if (Driver.findElementByClassName(Arr[0]).isDisplayed()){
		Gettxt = Driver.findElementByClassName(obj).getText();}
	else if (Driver.findElementByXPath(Arr[0]).isDisplayed()){
		Gettxt = Driver.findElementByXPath(obj).getText();}
	
	 if (Gettxt.equalsIgnoreCase(text)){
		 System.out.println("Given Text["+text+"] Matches with Actaul text["+Gettxt+"]");}
	 else {
		 System.out.println("Given Text["+text+"] Not Matches with Actaul text["+Gettxt+"]");
	 }
	} catch (Exception e) {
	
		// TODO Auto-generated catch block
		System.out.println("No Text obtained from Element["+ Arr[0] +"]");
	}
}



public void verifyTitle(String Title){
	String GetTtile = Driver.getTitle();
	
	if (GetTtile.equalsIgnoreCase(Title)){
		System.out.println("Given Title["+Title+"] Matches with Actaul text["+GetTtile+"]");}
	else{
		System.out.println("Given Title["+Title+"] Not Matches with Actaul text["+GetTtile+"]");}
	
		
	}


public void pagewait(int waittime){
	Driver.manage().timeouts().implicitlyWait(waittime, TimeUnit.SECONDS);
}



public void threadsleep(int waittime)
{
	try {
		Thread.sleep(waittime);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//*************************************************************************************************************************
//Public method SearchRepostry
//Search object property value from the excel file
//*************************************************************************************************************************
public String[] SearchRepostry(String Search) throws IOException{
	
	//String findrownum;
	String[] Arr = new String[2];
	
	String PropertyValue = null;
	FileInputStream fis = (new FileInputStream("./Data/ObjectRepository.xlsx"));
	//@SuppressWarnings("resource")
	XSSFWorkbook workbookobj = new XSSFWorkbook(fis);
	
	XSSFSheet Wsheet = workbookobj.getSheet("Objects");
	
	//XSSFRow currrow = Wsheet.getRow(1);
	//findrownum = FindRow(Wsheet, "OpenTaps_UserName");
	//int RowIndx=0;
	int i=0;
	for (Row row : Wsheet) {
		
		
		if (row.getCell(i).getStringCellValue().equalsIgnoreCase(Search)) {
		
			Arr[0] = row.getCell(2).getStringCellValue();
			//if(!row.getCell(3).getStringCellValue().isEmpty()){
			Arr[1] = row.getCell(3).getStringCellValue();//}
			break;
			
			
		}
		}
		//return PropertyValue;
	return Arr;
			
		
	}


}
