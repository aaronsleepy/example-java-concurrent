package org.socurites.ex.concurrent.spring.infrastructure;

import org.socurites.ex.concurrent.spring.domain.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitUserApi {
    @GET("users/{userName}")
    Call<User> findUser(@Path("userName") String userName);
}
