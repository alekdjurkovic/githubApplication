package com.example.github.data.repository;

import com.example.github.data.api.GitHubApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class RepoRepositoryImpl_Factory implements Factory<RepoRepositoryImpl> {
  private final Provider<GitHubApiService> apiProvider;

  public RepoRepositoryImpl_Factory(Provider<GitHubApiService> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public RepoRepositoryImpl get() {
    return newInstance(apiProvider.get());
  }

  public static RepoRepositoryImpl_Factory create(Provider<GitHubApiService> apiProvider) {
    return new RepoRepositoryImpl_Factory(apiProvider);
  }

  public static RepoRepositoryImpl newInstance(GitHubApiService api) {
    return new RepoRepositoryImpl(api);
  }
}
