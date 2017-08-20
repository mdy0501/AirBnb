package com.android.airbnb.util.Remote;

import com.android.airbnb.domain.airbnb.Host;
import com.android.airbnb.domain.airbnb.House;
import com.android.airbnb.domain.airbnb.LoginResult;
import com.android.airbnb.domain.airbnb.SignUpData;
import com.android.airbnb.domain.reservation.Reservation;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by JunHee on 2017. 8. 3..
 */

public interface IServerApi {

    public static final String BASE_URL = "http://crusia.xyz/";

    @GET("apis/house/")
    Call<List<House>> readAllHouses();

    @GET("apis/house/{pk}")
    Call<House> readOneHouse(@Path("pk") String pk);

    @GET("apis/user/")
    Call<List<Host>> readAllHosts();

    @GET("apis/house/{pk}")
    Call<Host> readOneHost(@Path("pk") String pk);

    @GET("apis/reservations/")
    Call<List<Reservation>> readReservation(@Query("house") String housePk);

    // 회원가입 POST
    @Multipart
    @POST("apis/user/")
    Call<SignUpData> postSignUpData(@Part("email")RequestBody email,
                                    @Part("password1") RequestBody password1,
                                    @Part("password2")RequestBody password2,
                                    @Part("first_name")RequestBody firstName,
                                    @Part("last_name") RequestBody lastName,
                                    @Part("birthday") RequestBody birthday,
                                    @Part("agreement")RequestBody agreement);

    // 로그인 POST
    @Multipart
    @POST("apis/user/login/")
    Call<LoginResult> postLoginData(@Part("email") RequestBody email,
                                    @Part("password") RequestBody password);


    // 페이스북 로그인 POST
    @Multipart
    @POST("facebook-login/")
    Call<LoginResult> postFacebookLoginData(@Part("token") RequestBody token);


    // 로그아웃 GET
    // Key : Authorization  ,  Value : Token xxxxxxxxxxxxxxx
    @GET("apis/user/logout/")
    Call<ResponseBody> getLogout(@Header("Authorization") String token);

    @GET("apis/like/")
    Call<List<House>> getWishList(@Header("Authorization") String token);

    @POST("apis/like/")
    Call<String> postWishList(@Header("Authorization") String token, @Query("house") String housePk);

    @Multipart
    @POST("apis/reservations/{pk}")
    /*restful 방식에 어긋난 쿼리형태로 인해 retrofit 2.0 을 custom 해야하는 상황임.. ㅜㅜ*/
    Call<Reservation> postReservation(@Header("Authorization") String token,
                                      @Path(value = "pk", encoded = true) String pk,
                                      @Part("checkin_date") RequestBody checkin,
                                      @Part("checkout_date") RequestBody checkout);
}
