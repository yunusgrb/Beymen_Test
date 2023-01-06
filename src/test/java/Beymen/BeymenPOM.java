package Beymen;

import Utilities.GenelWebDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeymenPOM extends GenelWebDriver {

    @Test
    public void Test() throws IOException, InterruptedException {

        BeymenElements elements=new BeymenElements(GenelWebDriver.driver);
        Actions actions= new Actions(GenelWebDriver.driver);

        driver.get("https://www.beymen.com/");
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals("Is mainpage true?",expectedUrl,"https://www.beymen.com/");

//        elements.searchBox.sendKeys(excellGetData(0,0));
//        elements.searchBox.clear();
        elements.searchBox.sendKeys(excellGetData(0,1));
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        elements.cookies.click();

        String randomGenNum= RandomStringUtils.randomNumeric(1);
        System.out.println("random="+randomGenNum);
        List<WebElement> list=new ArrayList<>(elements.productList);


        for (int i = 0; i<list.size(); i++) {
            if (String.valueOf(i).equals(randomGenNum)){
                list.get(i).click();
            }
        }
        String product=elements.productInf.getText();
        String productPrice= elements.productPrice.getText();
        long productPriceInt=getNum(productPrice);
        System.out.println(productPrice);
        FileWriter fw=new FileWriter("src/test/java/TXT/Beymen_product.txt");
        fw.write(product);
        fw.write(productPrice);
        fw.close();

        elements.selectSize.click();
        elements.addBasket.click();
        Thread.sleep(5000);
        elements.basket.click();
        Thread.sleep(2500);
        String basketPrice=elements.basketPrice.getText();
        System.out.println(basketPrice);
        Assert.assertEquals("prices is equals",basketPrice,productPrice);
        Thread.sleep(2000);
        Select select =new Select(elements.quantity);
        select.selectByValue("2");
        Thread.sleep(3000);
        String newbasketPrice=elements.newBasketPrice.getText();
        long basketPriceInt=getNum(newbasketPrice);

        System.out.println("productPriceInt = " + basketPriceInt);
        Assert.assertEquals(basketPriceInt, (2 * productPriceInt));






    }

    public static String excellGetData(int rowNum, int columnNum) throws IOException {
        String word="";
        String path="src/test/java/Excell/searchText.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet= workbook.getSheet("sayfa1");
        Row row=sheet.getRow(rowNum);
        word+= row.getCell(columnNum);

        return word;
    }
    public static Long getNum(String str){
        String strNum=str.replaceAll("[^0-9-]", "");
        long num=Long.parseLong(strNum.substring(0,strNum.length()-2));


        return num;
    }

}
