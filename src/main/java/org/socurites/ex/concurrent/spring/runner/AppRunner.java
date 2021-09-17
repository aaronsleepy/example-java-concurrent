package org.socurites.ex.concurrent.spring.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.socurites.ex.concurrent.spring.domain.User;
import org.socurites.ex.concurrent.spring.domain.UserService;
import org.socurites.ex.concurrent.spring.infrastructure.RetrofitUserApi;
import org.socurites.ex.concurrent.spring.infrastructure.retrofit.RetrofitUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import retrofit2.Call;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
@Slf4j
public class AppRunner implements CommandLineRunner {
    private final UserService userService;

    private final RetrofitUtils retrofitUtils;
    private final RetrofitUserApi retrofitUserApi;


    @Override
    public void run(String... args) throws Exception {
        restTemplateAsnycCall();

        retrofitSyncCall();
    }

    private void retrofitSyncCall() {
        Call<User> call1 = retrofitUserApi.findUser("socurites");

        User user1 = retrofitUtils.responseSync(call1).orElseThrow(RuntimeException::new);

        log.info(user1.toString());
    }

    private void restTemplateAsnycCall() throws InterruptedException, ExecutionException {
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
