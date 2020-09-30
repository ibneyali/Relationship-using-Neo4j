package usercard;

import usercard.cardQuery.adaper.out.persistance.CardPersistenceAdapter;
import usercard.cardQuery.application.CardQueryHandler;
import usercard.cardQuery.application.port.out.CardPort;
import usercard.cardQuery.command.CreateUserCommand;
import usercard.cardQuery.domain.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataNeo4jTest
public class CardQueryTest {

    @InjectMocks
    CardQueryHandler cardQueryHandler;

    @InjectMocks
    CardPersistenceAdapter cardPersistenceAdapter;

    @Mock
    CardPort cardPort;

    @Mock
    CreateUserCommand createUserCommand;

    @Test
    public void saveUser(){

        createUserCommand = new CreateUserCommand();
        createUserCommand.setFirstName("Imran");
        createUserCommand.setLastName("Ali");
        createUserCommand.setMobileNumber(9897137167L);
        //createUserCommand.setDob("2013-03-11T01:38:18.309Z");
        createUserCommand.setAddress("Moradabad");
        createUserCommand.setDesignation("Manager");
        createUserCommand.setEmail("ibneyali@gmail.com");

        User user = new User();
        user.setId(1L);
        user.setFirstName(createUserCommand.getFirstName());
        user.setLastName(createUserCommand.getLastName());
        user.setMobileNumber(createUserCommand.getMobileNumber());
        //user.setDob(createUserCommand.getDob());
        user.setAddress(createUserCommand.getAddress());
        user.setDesignation(createUserCommand.getDesignation());
        user.setEmail(createUserCommand.getEmail());

        Mockito.when(cardPort.saveUsers(user)).thenReturn(user);
        assertEquals(9897137167L, cardQueryHandler.saveUserDetails(createUserCommand).getMobileNumber());
    }

    /*@Test
    public void saveCardTest(){

        CreateCardCommand createCardCommand = new CreateCardCommand();

        createCardCommand.(1L);
        createCardCommand.setAddress("Noida");
        createCardCommand.setCompanyName("Liberin");
        createCardCommand.setEmail("testemail@gmail.com");
        createCardCommand.setMobileNumber(12345L);

        newCard.setCompanyName(createCardCommand.getCompanyName());
        newCard.setMobileNumber(createCardCommand.getMobileNumber());
        newCard.setEmail(createCardCommand.getEmail());
        newCard.setAddress(createCardCommand.getAddress());
        newCard.setFirstName(createCardCommand.getFirstName());
        newCard.setLastName(createCardCommand.getLastName());
        newCard.setUserCard(user);

        System.out.println(card);
        assertEquals(1, card.getId());
        Mockito.when(cardPersistenceAdapter.saveCardDetails(card)).thenReturn(card);
        assertEquals(12345L, cardQueryHandler.saveCardDetails(id, createCardCommand).getMobileNumber());
    }
*/
}