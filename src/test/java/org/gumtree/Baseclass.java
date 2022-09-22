package org.gumtree;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Baseclass {
	
	// instance variable
		public static WebDriver driver;
		// Actions Declaration	
		public static Actions act;
		//Robot declaration
		public static Robot r;
		//select declaration
		public static Select s;
		
		// 0 browser launch
		public static void launchUrl() {
			WebDriverManager.chromedriver().setup();
		     driver = new ChromeDriver();
				}
		
		//1 maximize
		public static void max() {
			driver.manage().window().maximize();
				}

		//2 Load URL
		public static void loadUrl(String title) {
		driver.get(title);
		}
		
		//3 Print url title
		public static void printTitle() {
			System.out.println("Title: "+driver.getTitle());
		}
		
		//4 print current url
		public static void ctUrl(){
			System.out.println("Current URL: "+driver.getCurrentUrl());
		}
		
		//5  text pass by sendkeys
		public static void textPass(WebElement ref , String value) {
	        ref.sendKeys(value);		
		}
		
		//6  text pass by sendkeys with getAttribute
		public static void textPass1(WebElement ref , String value) {
		        ref.sendKeys(value);
		        System.out.println("Text Entered: "+ref.getAttribute("value"));
			}
			
		//7 get text present in the website
		public static void webText(WebElement ref) {
			System.out.println("\nText in the site: "+(ref.getText()));
		}
			
		//8 click 
		public static void clickbtn(WebElement ref) {
			ref.click();
		}
		
		//9 static wait 
		public static void waitTime(int sec) throws InterruptedException {
			Thread.sleep(sec);
		}
		
		//10 Actions - move to webelement 
		public static void cursorMove(WebElement ref) {
			act =new Actions(driver);
		    act.moveToElement(ref).perform();
		}
		
		//11 Actions class - right click
		public static void rightClick(WebElement ref) {
			act =new Actions(driver);
			act.contextClick().perform();
		}
		
		//12 actions -double click
		public static void doubleClk(WebElement ref) {
			act = new Actions(driver);
			act.doubleClick().perform();
	  	}
		
		//13 actions -drag and drop
		public void dragDrop(WebElement src, WebElement des) {
			act = new Actions(driver);
	        act.dragAndDrop(src,des).perform();
		}
		
		//14 actions- key down and key up
		public static void pressKey() {
			act=new Actions(driver);	
		}
		
		//15 alert - simple
		public static void alertSimple() {
			Alert alt=driver.switchTo().alert();
			alt.accept();
		}
		
		//16 alert - confirm
		public static void alertConfirm() {
			Alert alt = driver.switchTo().alert();
			alt.dismiss();
		}

		//16 alert - prompt
		public static void alertPrompt(String value) {
			Alert alt = driver.switchTo().alert();
			String text = alt.getText();
			alt.sendKeys(value);
			}
			
		//17 Screenshot 
		public static void screenShot(String name, int no) throws IOException {
			TakesScreenshot take= (TakesScreenshot)driver;
			File src = take.getScreenshotAs(OutputType.FILE);
			File des= new File("D:\\javaSelenium\\eclipse-workspace\\FrameworkPrograms\\src\\test\\resources\\TestOutput\\"+name+no+".jpg");
		    FileUtils.copyFile(src, des);
		}
		
		//18 Java Script executor-click
		public static void javaScriptClick(WebElement ref) {
			JavascriptExecutor j= (JavascriptExecutor)driver;
			j.executeScript("arguments[0].click()", ref);
		}
		
		//19 Java Script executor- send keys
		public static void javaScriptTextPass(WebElement ref, String s) {
			JavascriptExecutor j= (JavascriptExecutor)driver;
			j.executeScript("arguments[0].setAttribute('value','"+s+"')", ref);
				}

		//20 Java Script executor-get value
		public static void javaScriptGetText(WebElement ref, String s) {
			JavascriptExecutor j= (JavascriptExecutor)driver;
			Object text=j.executeScript("arguments[0].getAttribute('"+s+"')", ref);
			String t= String.valueOf(text);
		    System.out.println(t);
				}
				

		//21 Java Script executor-scroll
		public static void javaScrollTrue(WebElement ref) {
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].scrollIntoView(true)", ref);
		}

		//22 Java Script executor-scroll
		public static void javaScrollFalse(WebElement ref) {
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].scrollIntoView(false)", ref);
		}
		
		//23 frames- into frame
		public static void frameInt(String name) {
			driver.switchTo().frame(name);	
		}
		
		//24 frames- out of frame
			public static void frameOut() {
				driver.switchTo().parentFrame();	
			}
			
		//25 frames-out of all frames
			public static void frameDefault() {
				driver.switchTo().defaultContent();
			}
		
	    //26 Robot class
			public static void keyBoard(int x, int y) throws AWTException {
				 r=new Robot();
				 r.mouseMove(x, y);
			}
			
		//27 close
			public static void closeWindow() {
				driver.close();
			}
			
		//28 quit
			public static void quitWindow() {
				driver.quit();
			}
			
		//29 Windows handling- windows ID
			public static void windowId() {
				String windowId=driver.getWindowHandle();
				System.out.println(windowId);
			}
			
		//30 Windows handling- switch to child window
			public static void windowNavigate() {
				String winId=driver.getWindowHandle();
				System.out.println(winId);
				Set<String> windowsId = driver.getWindowHandles();
				for (String id : windowsId) {
					if(!winId.equals(id)) {
						driver.switchTo().window(id);
					}
				}
			}
			
		//31 Select class - multiple or not
			public static void dropDown(WebElement sel) {
			Select s=new Select(sel);
			boolean a= s.isMultiple();
			System.out.println(a);
			}
		
		//32 Select class - select by value
			public static void dropDownValue(WebElement sel, String val) {
				Select s=new Select(sel);
				s.selectByValue(val);
				System.out.println();
				}

		//33 Select class- select by index
			public static void dropDownInt(WebElement sel, int indexNo) {
				Select s=new Select(sel);
				s.selectByIndex(indexNo);
				System.out.println();
				}
			
		//34 Select class- select by text
			public static void dropDownText(WebElement sel, String text) {
				Select s = new Select(sel);
				s.selectByVisibleText(text);
				System.out.println();
			}
			
		//35  Select class- getOptions()
			public static void optionsInSelect(WebElement selOptions) {
				Select s = new Select(selOptions);
				List<WebElement> opt = s.getOptions();
			    int size = opt.size();
			    System.out.println(size);
			   
			    for(int i=0; i< opt.size(); i++) {
		        	WebElement l = opt.get(i);
		        	String text=l.getText();
		        	System.out.println(text);
		        	        }
			}
		
		//36  Select class- getAllOptions()
			public static void allselectedOpt(WebElement selAllOpt) {
				Select s = new Select(selAllOpt);
				  List<WebElement> allopt = s.getAllSelectedOptions();
			        for(WebElement x:allopt) {
			        	String all=x.getText();
			        	System.out.println(all);
			        }
			}
			
		//37 Select class- getFirstSelectedOptions()
		public static void firstSelectedOpt(WebElement selFirst) {
			Select s = new Select(selFirst);
			WebElement firstSelOpt = s.getFirstSelectedOption();
			String firstopt = firstSelOpt.getText();
			System.out.println("\n" + firstopt);
		}
			       
		//38 Select class- deselect by value
			public static void dropDownDelValue(WebElement deselV, String value) {
				Select s = new Select(deselV);
				s.deselectByValue(value);
				
			}
			
		//39 Select class- deselect by Text
			public static void dropDownDelText(WebElement deselT, String text) {
				Select s = new Select(deselT);
				s.deselectByVisibleText(text);
			}
			
		//40 Select class- deselect by index
		    public static void dropDownDelIndex(WebElement deselI, int indexNo) {
			Select s = new Select(deselI);
			s.deselectByIndex(indexNo);
		    }
			
		 //41 Select class- deselect all
		    public static void dropDownDel(WebElement deselAll) {
			Select s = new Select(deselAll);
			s.deselectAll();  
			}
		    
		 //42 dynamicwait - implicit 
		    public static void dynamicImplicitWait(int sec)
		    {
		    driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		    }
		   
		 //43 dynamic wait-fluent wait
		    public static void fluentWait() {
			Wait<WebDriver> waitTime = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

			}
		    
		 //44 webtable - table heading
		    public static void webTableHeading(String xpath) {
		    	WebElement table=driver.findElement(By.xpath(xpath));
		    	List<WebElement> heading = table.findElements(By.tagName("th"));
		    	System.out.println(heading.size());
		    }
		    
		 //45 webtable - table rows
		    public static void webTableRow(String xpath) { 
		    	WebElement table=driver.findElement(By.xpath(xpath));
		   
		        List <WebElement> rows=table.findElements(By.tagName("tr"));
			    System.out.println(rows.size());
			
			for(int i=0;i < rows.size(); i++) {
				WebElement tablerow=rows.get(i);
				System.out.println("Row number: "+i);
			    String text = tablerow.getText();
			    System.out.println(text);
			}
		    }
		    
		//46 webtable - table data
			public static void webTableData(String xpath) { 
		    	WebElement table=driver.findElement(By.xpath(xpath));
		   
		    	List <WebElement> rows=table.findElements(By.tagName("tr"));
		    	System.out.println(rows.size());
		    	
		    	for(int i=0;i < rows.size(); i++) {
		    		WebElement tablerow=rows.get(i);
		    		System.out.println("Row number: "+i);
		    	
		    	List <WebElement> data=tablerow.findElements(By.tagName("td"));
		    	
		    	for(int j=0; j < data.size(); j++) {
		    		WebElement tabledata=data.get(j);
		    		System.out.println(tabledata.getText());
		    	}
		    	}
			}
			
	     //47 dynamic explicit wait
		    public static void dynamicexplicitwait() {
		    	WebDriverWait w=new WebDriverWait(driver,10); 	
		    	
	        }
		 
		    
		//50 wait- alertIsPresent()
			public static void fluentAlert(long sec,long pollSec) {
			FluentWait<WebDriver> f=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(Duration.ofSeconds(pollSec)).ignoring(Throwable.class);
			f.until(ExpectedConditions.alertIsPresent());
			}
			
		//51 wait- invisibilityOf()
			public static void fluentMilliSec(long mSec,long pollSec,WebElement ref) {
			FluentWait<WebDriver> f=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(mSec)).pollingEvery(Duration.ofMillis(pollSec)).ignoring(Throwable.class);
			f.until(ExpectedConditions.invisibilityOf(ref));
			}
			
		//52 BootStrap method for distance drop down
			public static void bootStrapDistance(WebElement distance, String opt) {
			distance.click();
		    List<WebElement> dropdown = driver.findElements(By.xpath("(//ul[@class='j-selectbox__ul'])[2]/li/div"));
			System.out.println("Size of the DropDown: " +dropdown.size());
			 for (int i = 0; i < dropdown.size(); i++) {
					if(dropdown.get(i).getText().contains(opt))
					{
						System.out.println("\nselected distance: "+dropdown.get(i).getText());
			    		dropdown.get(i).click();
					}
					}
			}
			
		
		//53 BootStrap method for distance drop down
			public static void bootStrapAllCat(WebElement allCat, String option) {
				allCat.click();
				List<WebElement> list = driver.findElements(By.xpath("(//ul[@class='j-selectbox__ul'])[1]/li/div"));
				System.out.println("Size of the DropDown: " +list.size());
				for (int i = 0; i < list.size(); i++) {
					String s = list.get(i).getText();
					if(list.get(i).getText().contains(option)) {
						list.get(i).click();
					}
				}
			}
			
	     //53 Excel read
			public static String getData(int rowNo, int cellNo) throws IOException {
				// file location
				File f= new File("D:\\javaSelenium\\eclipse-workspace\\FrameworkPrograms\\src\\test\\resources\\TestData\\testdata.xlsx");
				// read the file from excel
				FileInputStream fin= new FileInputStream(f);
				// workbook type
				Workbook w= new XSSFWorkbook(fin);
				// get the sheet
				Sheet s= w.getSheet("carDetails");
				// get the row
				Row r= s.getRow(rowNo);	
				// get the cell
				Cell c=r.getCell(cellNo);	
				@SuppressWarnings("deprecation")
				int celltype= c.getCellType();
				String value="";
				 if(celltype==1) {
							value= c.getStringCellValue();
							} else if(DateUtil.isCellDateFormatted(c)) {
							Date d= c.getDateCellValue();
							SimpleDateFormat sdf=new SimpleDateFormat("dd,MMMM,YYYY");
							value = sdf.format(d);
							}else {
								
							double db = c.getNumericCellValue();
							long l=(long)db;
							value=String.valueOf(l);
							}
				return value;
				}
			
			
		// 54 Excel write
			
			public static void excelWrite(String filename, String sheetname, String cellvalue) throws IOException {
				// file location 
				File f=new File("C:\\Users\\iamni\\eclipse-workspace\\myProject\\src\\test\\resources\\testdata\\"+filename+".xlsx");
					
				// create new file
				boolean a = f.createNewFile();
				System.out.println(a);
				
				// workbook
				Workbook w= new XSSFWorkbook();
				
				// create sheet 
				Sheet s= w.createSheet(sheetname);
				
				// create row
				Row r= s.createRow(1);
				
				// create cell
				Cell c= r.createCell(1);
				
				// set cell value
				c.setCellValue(cellvalue);
				
				//update the file 
				FileOutputStream fout=new FileOutputStream(f);
				
				// write the changes
				w.write(fout);
				
				}

}
