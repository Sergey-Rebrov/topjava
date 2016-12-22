package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.NamedEntity;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * GKislin
 * 15.06.2015.
 */
@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {
    private static final Logger LOG = LoggerFactory.getLogger(InMemoryUserRepositoryImpl.class);

    private Map<Integer, User> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public boolean delete(int id) {
        LOG.info("delete " + id);
        return repository.remove(id) != null;
    }

    @Override
    public User save(User user) {
        LOG.info("save " + user);
        if (user.isNew()) {
            user.setId(counter.incrementAndGet());
        }
        repository.put(user.getId(), user);
        return user;
    }

    @Override
    public User get(int id) {
        LOG.info("get " + id);
        return repository.get(id) != null ? repository.get(id) : null;
    }

    @Override
    public List<User> getAll() {
        LOG.info("getAll");
        List<User> userList = new ArrayList<User>(repository.values());
        userList.sort(Comparator.comparing(NamedEntity::getName));
        return userList;
    }

    @Override
    public User getByEmail(String email) {
        LOG.info("getByEmail " + email);

        return getAll().stream()
                .filter(user -> user.getEmail().contains(email))
                .findFirst().orElse(null);
    }

    public static void main(String[] args) {
        InMemoryUserRepositoryImpl inMemoryUserRepository = new InMemoryUserRepositoryImpl();
        inMemoryUserRepository.save(new User(null, "V", "132@1321", "123456", Role.ROLE_ADMIN));
        inMemoryUserRepository.save(new User(null, "T", "132@132", "123456", Role.ROLE_ADMIN));
        inMemoryUserRepository.save(new User(null, "C", "132@132", "123456", Role.ROLE_ADMIN));
        inMemoryUserRepository.save(new User(null, "A", "132@132", "123456", Role.ROLE_ADMIN));
        inMemoryUserRepository.save(new User(null, "B", "132@132", "123456", Role.ROLE_ADMIN));
        inMemoryUserRepository.save(new User(null, "Y", "132@132", "123456", Role.ROLE_ADMIN));
        inMemoryUserRepository.save(new User(null, "R", "132@132", "123456", Role.ROLE_ADMIN));



        List<User> users = inMemoryUserRepository.getAll();
        for (User user : users)
            System.out.println(user.getName() + " " + user.getId());

        System.out.println(inMemoryUserRepository.getByEmail("132@1321").getName());
    }
}
