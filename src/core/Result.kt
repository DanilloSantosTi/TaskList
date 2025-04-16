package core

sealed class Result {
    data class Success(val success: String) : Result()
    data class Failure(val exception: Exception) : Result()
}