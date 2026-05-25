-keepnames class com.example.github.data.dto.CommitRefDto
-if class com.example.github.data.dto.CommitRefDto
-keep class com.example.github.data.dto.CommitRefDtoJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
