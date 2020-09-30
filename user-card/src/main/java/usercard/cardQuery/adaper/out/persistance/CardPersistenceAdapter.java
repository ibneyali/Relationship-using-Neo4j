package usercard.cardQuery.adaper.out.persistance;

import usercard.cardQuery.application.port.out.CardPort;
import usercard.cardQuery.domain.Card;
import usercard.cardQuery.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardPersistenceAdapter implements CardPort {

    @Autowired
    UserQueryRepository userQueryRepository;

    @Autowired
    CardQueryRepository cardQueryRepository;

    @Override
    public User saveUsers(User user) {
        System.out.println("inside save users "+user);
        User u = userQueryRepository.save(user);
        System.out.println("after save user "+u);
        return u;
    }

    @Override
    public Card saveCardDetails(Card card) {
        return cardQueryRepository.save(card);
    }

    @Override
    public User findUserById(Long userId) {
        return userQueryRepository.findById(userId).orElse(null);
    }

    @Override
    public Iterable<Card> getAllCards() {
        return cardQueryRepository.findAll();
    }

    @Override
    public String createRelation(Long cardId, Long userId) {
        userQueryRepository.createRelation(cardId, userId);
        return "Card shared with "+ userId + " id";
    }

}
