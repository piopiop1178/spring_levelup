package K3.levelup.repository.user;

import K3.levelup.domain.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface H2UserRepository extends JpaRepository<User, Long>, UserRepository {

}
