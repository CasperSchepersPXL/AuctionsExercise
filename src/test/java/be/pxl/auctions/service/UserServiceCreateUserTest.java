package be.pxl.auctions.service;

import be.pxl.auctions.dao.UserDao;
import be.pxl.auctions.model.User;
import be.pxl.auctions.util.exception.DuplicateEmailException;
import be.pxl.auctions.util.exception.InvalidDateException;
import be.pxl.auctions.util.exception.InvalidEmailException;
import be.pxl.auctions.util.exception.RequiredFieldException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceCreateUserTest {

	// TODO add unit tests for all possible scenario's of the createUser method

    private static final String EMAIL = "mark@facebook.com";

    @Mock
    private UserDao userDao;
    @InjectMocks
    private UserService userService;
    private User user;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setFirstName("Mark");
        user.setLastName("Zuckerberg");
        user.setDateOfBirth(LocalDate.of(1989,5,3));
        user.setEmail(EMAIL);
    }

    @Test
    public void testValidUserIsSaved() throws InvalidDateException, RequiredFieldException, InvalidEmailException, DuplicateEmailException {
        when(userDao.findUserByEmail(EMAIL)).thenReturn(null); // user met EMAIL zit nog niet in db

        userService.createUser(user);

        verify(userDao).saveUser(user);
    }

    @Test
    public void returnRequiredFieldExceptionWhenLastNameEmpty() throws InvalidDateException, RequiredFieldException, InvalidEmailException, DuplicateEmailException {
        user.setLastName(null);

        // de rest moet nog
    }
}