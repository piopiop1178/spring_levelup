package K3.levelup.repository;

import K3.levelup.domain.User;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();

}
