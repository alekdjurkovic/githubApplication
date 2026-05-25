package com.example.github.data.di;

import com.example.github.data.api.GitHubApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class NetworkModule_ProvideGitHubApiServiceFactory implements Factory<GitHubApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideGitHubApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public GitHubApiService get() {
    return provideGitHubApiService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideGitHubApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideGitHubApiServiceFactory(retrofitProvider);
  }

  public static GitHubApiService provideGitHubApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideGitHubApiService(retrofit));
  }
}
