package gsi.reyst.rx.step.by.step.DI.modules;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gsi.reyst.rx.step.by.step.ApiInterface;
import gsi.reyst.rx.step.by.step.model.Model;
import gsi.reyst.rx.step.by.step.model.ModelImpl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ModelModule {

    private static final boolean ENABLE_AUTH = false;
    private static final String AUTH_64 = SecretData.getKey(); //your code here

    @Singleton
    @Provides
    public ApiInterface getApiInterface(OkHttpClient client) {

        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client);

        return builder.build().create(ApiInterface.class);
    }

    @Singleton
    @Provides
    public OkHttpClient getHttpClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        if (ENABLE_AUTH) {
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("Authorization", "Basic " + AUTH_64)
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }
            });
        }

        httpClient.addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("LOGGER_Retrofit", message);
            }
        }));

        return httpClient.build();
    }

    @Singleton
    @Provides
    public Model getDataRepository() {
        return new ModelImpl();
    }

}
