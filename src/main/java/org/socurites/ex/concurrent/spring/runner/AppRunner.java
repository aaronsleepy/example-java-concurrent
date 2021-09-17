package org.socurites.ex.concurrent.spring.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.socurites.ex.concurrent.spring.domain.User;
import org.socurites.ex.concurrent.spring.domain.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
@Slf4j
public class AppRunner implements CommandLineRunner {
    private final UserService userService;


    @Override
    public void run(String... args) throws Exception {
        // Call asnyc
        CompletableFuture<User> future1 = userService.findUser("socurites");
        CompletableFuture<User> future2 = userService.findUser("martin");
        CompletableFuture<User> future3 = userService.findUser("fowler");

        // Wait until
        CompletableFuture.allOf(future1, future2, future3).join();

        log.info(future1.get().toString());
        log.info(future2.get().toString());
        log.info(future3.get().toString());
    }
}
