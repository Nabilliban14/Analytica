package nibbles.analytica;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    //TODO: Change some POST methods into GET methods

    @FormUrlEncoded
    @POST("create_user")
    Call<ResponseBody> create_user(
            @Field("public_token") String public_token,
            @Field("username") String username,
            @Field("password") String password,
            @Field("account_id") String account_id,
            @Field("account_name") String account_name,
            @Field("institution_name") String institution_name
    );

    @FormUrlEncoded
    @POST("username_exists")
    Call<ResponseBody> username_exists(
            @Field("username") String username
    );

    @FormUrlEncoded
    @POST("login_exists")
    Call<ResponseBody> login_exists(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("transactions")
    Call<ResponseBody> transactions(
            @Field("username") String username,
            @Field("password") String password
    );
}
