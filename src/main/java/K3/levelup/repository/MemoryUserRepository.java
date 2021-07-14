package K3.levelup.repository;

import K3.levelup.domain.User;

import java.util.*;

public class MemoryUserRepository implements MemberRepository{
    //동시성 고려하지 않은 임시 메모리 db
    private static Map<Long, User> repo = new HashMap<>();
    //id 수동으로 설정
    private static long sequence = 0L;

    @Override
    public User save(User user) {
        user.setId(++sequence);
        repo.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(repo.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(repo.values());
    }

    public void clearRepo() {
        repo.clear();
    }
}
