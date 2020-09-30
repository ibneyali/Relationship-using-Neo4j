package usercard.cardQuery.application;

import usercard.cardQuery.application.port.in.CardQueryUsecase;
import usercard.cardQuery.application.port.out.CardPort;
import usercard.cardQuery.command.CreateCardCommand;
import usercard.cardQuery.command.CreateUserCommand;
import usercard.cardQuery.domain.Card;
import usercard.cardQuery.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardQueryHandler implements CardQueryUsecase {

    @Autowired
    CardPort cardPort;

    @Override
    public User saveUserDetails(CreateUserCommand createUserCommand) {
        System.out.println("inside save user");
        User user = new User();
        user.setFirstName(createUserCommand.getFirstName());
        user.setLastName(createUserCommand.getLastName());
        user.setMobileNumber(createUserCommand.getMobileNumber());
        //user.setDob(createUserCommand.getDob());
        user.setAddress(createUserCommand.getAddress());
        user.setDesignation(createUserCommand.getDesignation());
        user.setEmail(createUserCommand.getEmail());
        System.out.println("before call card port "+user);
        User result = cardPort.saveUsers(user);
        System.out.println("result " +result);
        return result;
    }

    @Override
    public Card saveCardDetails(Long id, CreateCardCommand createCardCommand) {
        User user = cardPort.findUserById(id);
        Card newCard = new Card();
        newCard.setCompanyName(createCardCommand.getCompanyName());
        newCard.setMobileNumber(createCardCommand.getMobileNumber());
        newCard.setEmail(createCardCommand.getEmail());
        newCard.setAddress(createCardCommand.getAddress());
        newCard.setFirstName(createCardCommand.getFirstName());
        newCard.setLastName(createCardCommand.getLastName());
        newCard.setUserCard(user);
        return cardPort.saveCardDetails(newCard);
    }

    @Override
    public Iterable<Card> getAllCardsDetails() {
        return cardPort.getAllCards();
    }

    @Override
    public String shareCardToUser(Long cardId, Long userId) {
        return cardPort.createRelation(cardId, userId);
    }

}
