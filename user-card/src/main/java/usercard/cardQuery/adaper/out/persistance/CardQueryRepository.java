package usercard.cardQuery.adaper.out.persistance;

import usercard.cardQuery.domain.Card;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CardQueryRepository extends Neo4jRepository<Card, Long> {

}
