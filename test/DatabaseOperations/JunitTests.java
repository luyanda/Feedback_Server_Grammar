/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseOperations;

import ava.DbAccess;
import ava.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author epsilon
 */
public class JunitTests {
    DbAccess driver;
    @Before
    public void opener(){
        driver = new DbAccess();
    }
    
    @After
    public void closer(){
        driver = null;
    }
    
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testLogin() throws Exception{
        int stu = 131313;
        String pas = "one";
        User user=new User();
        user.setUserId(stu);
        user.setPassword(pas);
        user = driver.UserLogin(user);
        Assert.assertNotNull(user);
    }
}
