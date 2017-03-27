package camt.se234.unittest.dao;
import camt.se234.unittest.entity.User;
import camt.se234.unittest.exception.OldDateException;
import camt.se234.unittest.service.UserServiceImpl;

import org.junit.Rule;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;


public class UserServiceImplTest2 {
    @Test
    public void testisAbleToGoToPub(){
        //
        UserServiceImpl userService = new UserServiceImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        userService.setUserDao(userDao);
        //
        thrown.expect(OldDateException.class);
        assertThat(userService.isAbleToGoToPub(userService.login("Prayuth","1234"), LocalDate.of(2017,3,20)), is(true));
        assertThat(userService.isAbleToGoToPub(userService.login("Tucky","5675"), LocalDate.of(2017,3,20)), is(false));
        assertThat(userService.isAbleToGoToPub(userService.login("Honey","aabbcc"), LocalDate.of(2017,3,20)), is(false));
        assertThat(userService.isAbleToGoToPub(userService.login("None","none"), LocalDate.of(2017,3,20)), is(false));
        thrown.expect(OldDateException.class);
        thrown.expectMessage("User is not Born Yet");

    }
    @Test
    public void testgetPubAllowanceUser(){

        //
        UserServiceImpl userService = new UserServiceImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        userService.setUserDao(userDao);
        //

//        assertThat(userService.getPubAllowanceUser( LocalDate.of(2017,3,20)), hasItems(new User("Prayuth","1234","Tu",
//                LocalDate.of(1979,2,14),"08612345678")));
    }
    @Rule
    public ExpectedException thrown = ExpectedException.none();







}
