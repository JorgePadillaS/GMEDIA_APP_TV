package com.files.codes.model.api;


import com.files.codes.model.CountryModel;
import com.files.codes.model.FavoriteModel;
import com.files.codes.model.Genre;
import com.files.codes.model.HomeContent;
import com.files.codes.model.LiveTv;
import com.files.codes.model.Movie;
import com.files.codes.model.SearchModel;
import com.files.codes.model.config.Configuration;
import com.files.codes.model.movieDetails.MovieSingleDetails;
import com.files.codes.model.subscription.ActiveStatus;
import com.files.codes.model.subscription.User;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("config")
    Call<Configuration> getConfiguration(@Header("API-KEY") String apiKey);

    @GET("home_content")
    Call<List<HomeContent>> getHomeContent(@Header("API-KEY") String apiKey);

    @GET("check_user_subscription_status")
    Call<ActiveStatus> getActiveStatus(@Header("API-KEY") String apiKey,
                                       @Query("user_id") String userId);

    @GET("movies")
    Call<List<Movie>> getMovies(@Header("API-KEY") String apiKey,
                                @Query("page") int page);

    @GET("tvseries")
    Call<List<Movie>> getTvSeries(@Header("API-KEY") String apiKey,
                                  @Query("page") int page);

    @GET("all_tv_channel_by_category")
    Call<List<LiveTv>> getLiveTvCategories(@Header("API-KEY") String apiKey);

    @GET("all_genre")
    Call<List<Genre>> getGenres(@Header("API-KEY") String apiKey,
                                @Query("page") int page);

    @GET("all_country")
    Call<List<CountryModel>> getAllCountry(@Header("API-KEY") String apiKey);

    @GET("favorite")
    Call<List<Movie>> getFavoriteList(@Header("API-KEY") String apiKey,
                                      @Query("user_id") String userId,
                                      @Query("page") int page);

    @GET("movies")
    Single<List<Movie>> getMoviesSingle(@Header("API-KEY") String apiKey,
                                        @Query("page") int page);

    @GET("content_by_genre_id")
    Call<List<Movie>> getMovieByGenre(@Header("API-KEY") String apiKey,
                                      @Query("id") String id,
                                      @Query("page") int page_num);


    @GET("content_by_country_id")
    Call<List<Movie>> getMovieByCountry(@Header("API-KEY") String apiKey,
                                        @Query("id") String id,
                                        @Query("page") int page_number);

    @GET("single_details")
    Call<MovieSingleDetails> getSingleDetail(@Header("API-KEY") String apiKey,
                                             @Query("type") String videoType,
                                             @Query("id") String videoId);

    @GET("add_favorite")
    Call<FavoriteModel> addToFavorite(@Header("API-KEY") String apiKey,
                                      @Query("user_id") String userId,
                                      @Query("videos_id") String videoId);

    @GET("remove_favorite")
    Call<FavoriteModel> removeFromFavorite(@Header("API-KEY") String apiKey,
                                           @Query("user_id") String userId,
                                           @Query("videos_id") String videoId);

    @GET("verify_favorite_list")
    Call<FavoriteModel> verifyFavoriteList(@Header("API-KEY") String apiKey,
                                           @Query("user_id") String userId,
                                           @Query("videos_id") String videoId);

    @FormUrlEncoded
    @POST("firebase_auth")
    Call<User> getPhoneAuthStatus(@Header("API-KEY") String apiKey,
                                  @Field("uid") String uid,
                                  @Field("phone") String phoneNo);

    @FormUrlEncoded
    @POST("firebase_auth")
    Call<User> getGoogleAuthStatus(@Header("API-KEY") String apiKey,
                                   @Field("uid") String uid,
                                   @Field("email") String phoneNo,
                                   @Field("name") String name);


    @FormUrlEncoded
    @POST("firebase_auth")
    Call<User> getFacebookAuthStatus(@Header("API-KEY") String apiKey,
                                     @Field("uid") String uid,
                                     @Field("name") String name,
                                     @Field("email") String email,
                                     @Field("photo_url") String photoUrl);

    @FormUrlEncoded
    @POST("signup")
    Call<User> signUp(@Header("API-KEY") String apiKey,
                      @Field("email") String email,
                      @Field("password") String password,
                      @Field("name") String name);

    @FormUrlEncoded
    @POST("login")
    Call<User> postLoginStatus(@Header("API-KEY") String apiKey,
                               @Field("email") String email,
                               @Field("password") String password);

    @GET("search")
    Call<SearchModel> getSearchData(@Header("API-KEY") String key,
                                    @Query("q") String query,
                                    @Query("page") int page,
                                    @Query("type") String type);

}
