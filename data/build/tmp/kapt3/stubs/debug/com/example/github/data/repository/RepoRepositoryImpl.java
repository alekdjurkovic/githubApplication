package com.example.github.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\u000bJ*\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r0\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/github/data/repository/RepoRepositoryImpl;", "Lcom/example/github/domain/repository/RepoRepository;", "api", "Lcom/example/github/data/api/GitHubApiService;", "(Lcom/example/github/data/api/GitHubApiService;)V", "getRepo", "Lcom/example/github/domain/model/DataResult;", "Lcom/example/github/domain/model/Repo;", "login", "", "repoName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepoTags", "", "Lcom/example/github/domain/model/Tag;", "getUserRepos", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class RepoRepositoryImpl implements com.example.github.domain.repository.RepoRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.github.data.api.GitHubApiService api = null;
    
    @javax.inject.Inject()
    public RepoRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.github.data.api.GitHubApiService api) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getUserRepos(@org.jetbrains.annotations.NotNull()
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.github.domain.model.DataResult<? extends java.util.List<com.example.github.domain.model.Repo>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getRepo(@org.jetbrains.annotations.NotNull()
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    java.lang.String repoName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.github.domain.model.DataResult<com.example.github.domain.model.Repo>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getRepoTags(@org.jetbrains.annotations.NotNull()
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    java.lang.String repoName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.github.domain.model.DataResult<? extends java.util.List<com.example.github.domain.model.Tag>>> $completion) {
        return null;
    }
}