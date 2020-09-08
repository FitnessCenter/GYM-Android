import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentApplyEquipmentDetailDialogBinding
import com.dsm.gym.presentation.base.DataBindingDialogFragment
import com.dsm.gym.presentation.viewmodel.equipment.EquipmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ApplyEquipmentDetailDialogFragment :
    DataBindingDialogFragment<FragmentApplyEquipmentDetailDialogBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_apply_equipment_detail_dialog

    private val viewModel: EquipmentViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        viewModel.goMainEquipmentPage.observe(this, Observer { dismiss() })
        viewModel.closeDialog.observe(this, Observer { dismiss() })

        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}