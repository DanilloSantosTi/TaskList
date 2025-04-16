package data

import java.time.LocalDateTime
import java.util.*

data class Task(
    private val id: UUID = createUniqueId(),
    val title: String,
    val description: String?,
    val isCompleted: Boolean,
    private val createdAt: LocalDateTime = getLocalDateTime(),
) {
    fun getId(): UUID {
        return id
    }

    fun getCreatedAt(): LocalDateTime {
        return createdAt
    }

    companion object {
        private fun createUniqueId(): UUID = UUID.randomUUID()
        private fun getLocalDateTime(): LocalDateTime = LocalDateTime.now()
    }
}
