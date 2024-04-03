package az.edu.bhos.l14todoapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoDao {
    @Query("SELECT * FROM todos ORDER BY weekday ASC")
    fun getAllTodos(): Flow<List<TodoLocalDto>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTodos(todos: List<TodoLocalDto>)
}