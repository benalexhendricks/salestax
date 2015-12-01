package socks;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class organic {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://jungle-socks.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  

  @Test
  public void testSocksbase() throws Exception {
    driver.get(baseUrl + "/");
    String zp = driver.findElement(By.xpath("html/body/form/table[1]/tbody/tr[2]/td[2]")).getText();
    float value1 = Integer.parseInt(zp.trim());
    String lp = driver.findElement(By.xpath("html/body/form/table[1]/tbody/tr[3]/td[2]")).getText();
    float lvalue1 = Integer.parseInt(lp.trim());
    String ep = driver.findElement(By.xpath("html/body/form/table[1]/tbody/tr[4]/td[2]")).getText();
    float evalue1 = Integer.parseInt(ep.trim());
    String gp = driver.findElement(By.xpath("html/body/form/table[1]/tbody/tr[5]/td[2]")).getText();
    float gvalue1 = Integer.parseInt(gp.trim());
    driver.findElement(By.id("line_item_quantity_zebra")).clear();
    driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("1");
    driver.findElement(By.id("line_item_quantity_lion")).clear();
    driver.findElement(By.id("line_item_quantity_lion")).sendKeys("1");
    driver.findElement(By.id("line_item_quantity_elephant")).clear();
    driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("1");
    driver.findElement(By.id("line_item_quantity_giraffe")).clear();
    driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("1");
    int o = 1;
    int i;
    for (i = 0; i < 50; i++){
    //	System.out.println("Loop #" + i);
    Select dd = new Select (driver.findElement(By.name("state")));
    dd.selectByIndex(o++);
    o = new Integer(o++);
   // System.out.println("New Integer o =" + o);
    String selectedValue = dd.getFirstSelectedOption().getText();
   // System.out.println(selectedValue);
    driver.findElement(By.name("commit")).click();
    String subtotal = driver.findElement(By.id("subtotal")).getText();
   // System.out.println(subtotal);
    subtotal = subtotal.replace("$", "");
    float subtotal2 = Float.valueOf(subtotal.trim());
   // System.out.println("subtotal2 = " + subtotal2);
    String reportedtax = driver.findElement(By.id("taxes")).getText();
    reportedtax = reportedtax.replace("$", "");
    float reportedtax2 = Float.valueOf(reportedtax.trim());
   // System.out.println("reportedtax2 = " + reportedtax2);
    String reportedtotal = driver.findElement(By.id("total")).getText();
    reportedtotal = reportedtotal.replace("$", "");
    float reportedtotal2 = Float.valueOf(reportedtotal.trim());
   // System.out.println("reportedtotal2 = " + reportedtotal2);
   // System.out.println("value1 = " + value1);
    String zq = driver.findElement(By.xpath("//td[3]")).getText();
    float value2 = Integer.parseInt(zq.trim());
   // System.out.println("value2 = " + value2);
    float ztotal = value1 * value2;
   // System.out.println("ztotal = " + ztotal);
   // System.out.println("lvalue1 = " + lvalue1);
    String lq = driver.findElement(By.xpath("html/body/table[2]/tbody/tr[3]/td[3]")).getText();
    float lvalue2 = Integer.parseInt(lq.trim());
   // System.out.println("lvalue2 = " + lvalue2);
    float ltotal = lvalue1 * lvalue2;
   // System.out.println("ltotal = " + ltotal);
  //  System.out.println("evalue1 = " + evalue1);
    String eq = driver.findElement(By.xpath("html/body/table[2]/tbody/tr[4]/td[3]")).getText();
    float evalue2 = Integer.parseInt(eq.trim());
  //  System.out.println("evalue2 = " + evalue2);
    float etotal = evalue1 * evalue2;
  //  System.out.println("etotal = " + etotal);
  //  System.out.println("gvalue1 = " + gvalue1);
    String gq = driver.findElement(By.xpath("html/body/table[2]/tbody/tr[5]/td[3]")).getText();
    float gvalue2 = Integer.parseInt(gq.trim());
  //  System.out.println("gvalue2 = " + gvalue2);
    float gtotal = gvalue1 * gvalue2;
 //   System.out.println("gtotal = " + gtotal);
    float atotal=ztotal+ltotal+etotal+gtotal;
 //   System.out.println("atotal = " + atotal);
    if (selectedValue.contains("California"))
    {
    double tax = 0.08;
    double otax = (tax * atotal);
   // System.out.println("Tax Rate: " + tax);
  //  System.out.println("otax = " + otax);
    }
    if (selectedValue.contains("New York"))
    {
    	double tax = 0.06;
        double otax = (tax * atotal);
    //    System.out.println("Tax Rate: " + tax);
    //    System.out.println("otax = " + otax);
    }
    if (selectedValue.contains("Minnesota"))
    {
        double otax = 0;
     //   System.out.println("Tax Rate: " + otax);
     //   System.out.println("otax = " + otax);
    }
    if (!selectedValue.contains("Minnesota") &&  !selectedValue.contains("California") &&  !selectedValue.contains("New York"))
    {
    	double tax = 0.05;
    	double otax = (tax * atotal);
    //	System.out.println("Tax Rate: " + tax);
    //	System.out.println("otax = " + otax);
    double ftotal = otax + atotal;
    //  System.out.println("ftotal = " + ftotal);
    try{
    Assert.assertEquals(atotal, subtotal2, 0.001);
        }catch(AssertionError e)
        {
            System.out.println("Assertion error. " + selectedValue + (" Calculated Subtotal ") + atotal + (" Reported Subtotal ") + subtotal2);
        }

    //    System.out.println("Test Completed.");
       try{  
    Assert.assertEquals(otax, reportedtax2, 0.001);
          }catch(AssertionError e)
           {
               System.out.println("Assertion error. "  + selectedValue + (" Calculated Tax ") + otax + (" Reported Tax ") + reportedtax2);
           }

   //        System.out.println("Test Completed.");
       try{  
    Assert.assertEquals(ftotal, reportedtotal2, 0.001);
           }catch(AssertionError e)
           {
              System.out.println("Assertion error. "  + selectedValue + (" Calculated Total ") + ftotal + (" Reported Total ") + reportedtotal2);
           }

   //        System.out.println("Test Completed.");
    }
//    }
 //   Thread.sleep(2000);
   driver.navigate().back();
    }
    }

    



  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
