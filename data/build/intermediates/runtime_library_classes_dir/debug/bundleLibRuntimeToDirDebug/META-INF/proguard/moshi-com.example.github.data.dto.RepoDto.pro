-keepnames class com.example.github.data.dto.RepoDto
-if class com.example.github.data.dto.RepoDto
-keep class com.example.github.data.dto.RepoDtoJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
