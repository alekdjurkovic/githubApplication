# README.md

## Architecture

Three-module Clean Architecture with MVI on the presentation layer:

- **`:app`** — Jetpack Compose UI, ViewModels, Navigation, Hilt DI for use cases
- **`:domain`** — Pure Kotlin/JVM. Use cases, repository interfaces, domain models (`User`, `Repo`, `Tag`, `DataResult<T>`)
- **`:data`** — Android library. Retrofit API client, DTOs, mappers, repository implementations, Hilt DI for network + repositories

Dependencies flow inward: `app → domain ← data`. The `domain` module has no Android dependencies.

### MVI Pattern (Presentation Layer)

Each screen has a `*Contract.kt` defining three sealed types:
- **State** — immutable UI state data class
- **Intent** — user actions (e.g. `LoadRepos`, `RepoClicked`)
- **SideEffect** — one-shot events like navigation (sent via `Channel`, collected as `Flow`)

ViewModels expose `state: StateFlow<*State>` and `sideEffects: Flow<*SideEffect>`, and receive intents via `processIntent()`.

### Key Patterns

- `DataResult<T>` (domain) wraps success/error across layers; `NetworkResult<T>` (data) is the network-specific equivalent before mapping
- `safeApiCall {}` in `data/api/ApiExtensions.kt` wraps all Retrofit calls with error handling
- Mappers are extension functions: `RepoDto.toDomain()`, `UserDto.toDomain()`, etc.
- `GetRepoDetailsUseCase` runs three API calls in parallel using `coroutineScope { async {} }`
- Hardcoded GitHub username: `AppConfig.GITHUB_USER = "octocat"` in `domain/config/AppConfig.kt`

### Dependency Injection (Hilt)

- `NetworkModule` (Singleton) — provides Retrofit, OkHttp, Moshi
- `RepositoryModule` (Singleton) — binds repository implementations to interfaces
- `UseCaseModule` (ViewModelScoped, in `:app`) — provides use case instances
