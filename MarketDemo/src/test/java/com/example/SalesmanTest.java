
package test.com.example;

import com.example.Fruit;
import com.example.FruitFactory;
import com.example.Salesman;
import com.example.impl.Apple;
import com.example.impl.Mongo;
import com.example.impl.Strawberry;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.Scanner;


/**
* Salesman Tester.
* 
* @author James Loo
* @since <pre>03/28/2022</pre> 
* @version 1.0 
*/

public class SalesmanTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 


/**
* 
* Method: isOverdue(String datetime)
* 
*/

@Test
public void testIsOverdue() throws Exception {
    //given
    //when
    //then
    Assert.assertEquals(true, Salesman.isOverdue("2022-03-27 08:25:12"));
    Assert.assertEquals(false, Salesman.isOverdue("2022-04-27 08:25:12"));
}


/**
* 
* Method: getAmount(Scanner sc)
* 
*/

@Test
public void testGetAmount() throws Exception {
    //given
    System.setIn(new ByteArrayInputStream("1\n2\n3\n".getBytes()));
    Scanner sc = new Scanner(System.in);

    //when 购买苹果
    Salesman salesman = new Salesman(FruitFactory.getApple());
    //then
    Assert.assertEquals(new BigDecimal("8.00"), salesman.getAmount(sc));

    //when 购买草莓
    Strawberry strawberry = (Strawberry)FruitFactory.getStrawberry();
    strawberry.setEndDateTime("2022-03-27 08:25:12");
    salesman.setFruit(strawberry);
    //then
    Assert.assertEquals(new BigDecimal("26.00"), salesman.getAmount(sc));

    //when 购买芒果
    salesman.setFruit(FruitFactory.getMongo());
    //then
    Assert.assertEquals(new BigDecimal("60.00"), salesman.getAmount(sc));

    //given
    System.setIn(new ByteArrayInputStream("1.221\n-234\n9\n".getBytes()));
    sc = new Scanner(System.in);
    //when
    //then
    Assert.assertEquals(new BigDecimal("180.00"), salesman.getAmount(sc));
} 


/**
* 
* Method: getTotalAmount(BigDecimal appleAmount, BigDecimal strawberryAmount, BigDecimal mongoAmount, String datetime)
* 
*/

@Test
public void testGetTotalAmount() throws Exception {
    //given
    //when
    //then
    Assert.assertEquals(new BigDecimal("94.00"), Salesman.getTotalAmount(new BigDecimal("8.00"), new BigDecimal("26.00"), new BigDecimal("60.00"), "2022-03-27 08:25:12"));
    Assert.assertEquals(new BigDecimal("110.00"), Salesman.getTotalAmount(new BigDecimal("24.00"), new BigDecimal("26.00"), new BigDecimal("60.00"), "2022-03-27 08:25:12"));
    Assert.assertEquals(new BigDecimal("100.00"), Salesman.getTotalAmount(new BigDecimal("24.00"), new BigDecimal("26.00"), new BigDecimal("60.00"), "2022-04-27 08:25:12"));
} 

} 

