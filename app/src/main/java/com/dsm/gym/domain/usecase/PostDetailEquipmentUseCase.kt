
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.base.UseCase
import com.dsm.gym.domain.entity.EquipmentEntity
import com.dsm.gym.domain.service.EquipmentService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class PostDetailEquipmentUseCase(private val equipmentService: EquipmentService, composite: CompositeDisposable):
    UseCase<EquipmentEntity, Result<Unit>>(composite) {

    override fun create(data: EquipmentEntity): Single<Result<Unit>> =
        equipmentService.postDetailEquipment(data)
}