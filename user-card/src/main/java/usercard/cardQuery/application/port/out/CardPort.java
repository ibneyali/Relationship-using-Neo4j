package usercard.cardQuery.application.port.out;

import usercard.cardQuery.domain.Card;
import usercard.cardQuery.domain.User;

public interface CardPort {

    User saveUsers(User user);
    Card saveCardDetails(Card card);
    User findUserById(Long userId);
    Iterable<Card> getAllCards();
    String createRelation(Long cardId, Long userId);
}
