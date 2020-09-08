import com.dsm.gym.domain.entity.AuthEntity
import com.dsm.gym.domain.entity.TokenEntity
import com.dsm.gym.domain.entity.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

interface AuthRepository {
    fun signIn(auth: AuthEntity): Single<TokenEntity>
    fun signUp(user: UserEntity): Completable
    fun saveToken(token: String, isAccess: Boolean)
    fun getToken(isAccess: Boolean): String
}