-keepnames class com.example.github.data.dto.UserDto
-if class com.example.github.data.dto.UserDto
-keep class com.example.github.data.dto.UserDtoJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
