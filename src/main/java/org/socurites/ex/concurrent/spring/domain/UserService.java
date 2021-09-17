package org.socurites.ex.concurrent.spring.domain;

import java.util.concurrent.CompletableFuture;

public interface UserService {
    CompletableFuture<User> findUser(String username);
}
