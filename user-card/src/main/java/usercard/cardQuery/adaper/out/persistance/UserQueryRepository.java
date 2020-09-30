package usercard.cardQuery.adaper.out.persistance;

import usercard.cardQuery.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserQueryRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (a:Card) WHERE id(a)= $0 match (b:User) WHERE id(b)= $1 MERGE (a)-[:SHARE_WITH]-> (b)")
    User createRelation(Long cardId, Long userId);
}
