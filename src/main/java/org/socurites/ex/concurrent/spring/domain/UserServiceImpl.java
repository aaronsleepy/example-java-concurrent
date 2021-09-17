package org.socurites.ex.concurrent.spring.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final RestTemplate restTemplate;

    @Override
    @Async
    public CompletableFuture<User> findUser(String userName) {
        log.info(String.format("Looking for %s", userName));
        final String url = String.format("https://api.github.com/users/%s", userName);
        User user = restTemplate.getForObject(url, User.class);

        return CompletableFuture.completedFuture(user);
    }
}
