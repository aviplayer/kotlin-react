package utils

import dto.UserDto
import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

suspend fun fetchUsers(): Array<UserDto> {
    val response = window
        .fetch("http://localhost:8085/users").await()
        .text()
        .await()
    val format = Json { ignoreUnknownKeys = true }
    val users = format.decodeFromString<Array<UserDto>>(response)
    console.log("response is ", users)
    return users
}


suspend fun fetchUser(id: Int): UserDto {
    val response = window
        .fetch("http://localhost:8085/users/$id").await()
        .text()
        .await()
    val format = Json { ignoreUnknownKeys = true }
    val user = format.decodeFromString<UserDto>(response)
    return user
}
