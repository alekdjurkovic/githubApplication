package com.example.github.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/github/data/repository/UserRepositoryImpl;", "Lcom/example/github/domain/repository/UserRepository;", "api", "Lcom/example/github/data/api/GitHubApiService;", "(Lcom/example/github/data/api/GitHubApiService;)V", "getUser", "Lcom/example/github/domain/model/DataResult;", "Lcom/example/github/domain/model/User;", "login", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class UserRepositoryImpl implements com.example.github.domain.repository.UserRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.github.data.api.GitHubApiService api = null;
    
    @javax.inject.Inject()
    public UserRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.github.data.api.GitHubApiService api) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getUser(@org.jetbrains.annotations.NotNull()
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.github.domain.model.DataResult<com.example.github.domain.model.User>> $completion) {
        return null;
    }
}