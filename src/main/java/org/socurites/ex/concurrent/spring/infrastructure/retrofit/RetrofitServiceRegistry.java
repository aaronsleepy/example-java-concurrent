package org.socurites.ex.concurrent.spring.infrastructure.retrofit;

import org.socurites.ex.concurrent.spring.infrastructure.RetrofitUserApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetrofitServiceRegistry {
    @Bean
    public RetrofitUserApi retrofitOrderApi() {
        var retrofit = RetrofitUtils.initRetrofit("https://api.github.com/");
        return retrofit.create(RetrofitUserApi.class);
    }
}
