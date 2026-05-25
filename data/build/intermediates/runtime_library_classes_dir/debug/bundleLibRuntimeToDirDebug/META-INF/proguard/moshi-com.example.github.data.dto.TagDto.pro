-keepnames class com.example.github.data.dto.TagDto
-if class com.example.github.data.dto.TagDto
-keep class com.example.github.data.dto.TagDtoJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
