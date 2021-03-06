package com.oobest.study.zxingdemo.model.api;

import com.oobest.study.zxingdemo.model.entity.CreateResult;
import com.oobest.study.zxingdemo.model.entity.GetResults;
import com.oobest.study.zxingdemo.model.entity.Parcel;
import com.oobest.study.zxingdemo.model.entity.Timestamp;
import com.oobest.study.zxingdemo.model.entity.UpdateResult;

import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Albert.Ou on 2017/6/2.
 */

public interface ApiService {
    @GET("1/classes/Parcel")
    Call<GetResults> getParcelList(@Query("where") String where);

    @GET("1/classes/Parcel")
    Call<GetResults> getParcelList(@Query("where") String where, @Query("limit") int limit, @Query("skip") int skip, @Query("order") String order);

    @GET("1/classes/Parcel/{objectId}")
    Call<Parcel> getParcel(@Path("objectId") String objectId);

    @POST("1/classes/Parcel")
    @Headers("Content-Type:application/json")
    Call<CreateResult> createParcel(@Body RequestBody requestBody);

    @PUT("1/classes/Parcel/{objectId}")
    @Headers("Content-Type:application/json")
    Call<UpdateResult> updateParcel(@Path("objectId") String objectId,
                                    @Body RequestBody requestBody);

    @GET("1/timestamp")
    Call<Timestamp> getTimestamp();
}
