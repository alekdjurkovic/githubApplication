package com.example.github.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0007J(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/example/github/data/api/GitHubApiService;", "", "getRepo", "Lcom/example/github/data/dto/RepoDto;", "login", "", "repo", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepoTags", "", "Lcom/example/github/data/dto/TagDto;", "getUser", "Lcom/example/github/data/dto/UserDto;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserRepos", "data_debug"})
public abstract interface GitHubApiService {
    
    @retrofit2.http.GET(value = "users/{login}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUser(@retrofit2.http.Path(value = "login")
    @org.jetbrains.annotations.NotNull()
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.github.data.dto.UserDto> $completion);
    
    @retrofit2.http.GET(value = "users/{login}/repos")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserRepos(@retrofit2.http.Path(value = "login")
    @org.jetbrains.annotations.NotNull()
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.github.data.dto.RepoDto>> $completion);
    
    @retrofit2.http.GET(value = "repos/{login}/{repo}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRepo(@retrofit2.http.Path(value = "login")
    @org.jetbrains.annotations.NotNull()
    java.lang.String login, @retrofit2.http.Path(value = "repo")
    @org.jetbrains.annotations.NotNull()
    java.lang.String repo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.github.data.dto.RepoDto> $completion);
    
    @retrofit2.http.GET(value = "repos/{login}/{repo}/tags")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRepoTags(@retrofit2.http.Path(value = "login")
    @org.jetbrains.annotations.NotNull()
    java.lang.String login, @retrofit2.http.Path(value = "repo")
    @org.jetbrains.annotations.NotNull()
    java.lang.String repo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.github.data.dto.TagDto>> $completion);
}