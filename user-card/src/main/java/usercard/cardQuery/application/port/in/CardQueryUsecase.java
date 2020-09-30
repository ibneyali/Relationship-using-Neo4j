package usercard.cardQuery.application.port.in;

import usercard.cardQuery.command.CreateCardCommand;
import usercard.cardQuery.command.CreateUserCommand;
import usercard.cardQuery.domain.Card;
import usercard.cardQuery.domain.User;

public interface CardQueryUsecase {

    User saveUserDetails(CreateUserCommand createUserCommand);
    Card saveCardDetails(Long id, CreateCardCommand createCardCommand);
    Iterable<Card> getAllCardsDetails();
    String shareCardToUser(Long cardId, Long userId);
}
