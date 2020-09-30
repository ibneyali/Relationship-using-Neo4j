package usercard.cardQuery.adaper.in.web;

import usercard.cardQuery.application.port.in.CardQueryUsecase;
import usercard.cardQuery.command.CreateCardCommand;
import usercard.cardQuery.command.CreateUserCommand;
import usercard.cardQuery.domain.Card;
import usercard.cardQuery.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardQueryController {

    @Autowired
    CardQueryUsecase cardQueryUsecase;

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public User saveUser(@RequestBody CreateUserCommand createUserCommand){
        return cardQueryUsecase.saveUserDetails(createUserCommand);
    }

    @RequestMapping(value = "saveCard/{id}", method = RequestMethod.POST)
    public Card saveCards(@PathVariable Long id, @RequestBody CreateCardCommand card){
        Card cardData = cardQueryUsecase.saveCardDetails(id, card);
        return cardData;
    }

    @RequestMapping(value = "getAllCards", method = RequestMethod.GET)
    public Iterable<Card> getAllCards(){
        Iterable<Card> card = cardQueryUsecase.getAllCardsDetails();
        return card;
    }

    @RequestMapping(value = "shareCard/{cardId}/{userId}", method = RequestMethod.POST)
    public String shareCard(@PathVariable Long cardId, @PathVariable Long userId){
        return cardQueryUsecase.shareCardToUser(cardId, userId);
    }

}
