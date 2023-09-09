package br.com.fakebookmvp.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.fakebookmvp.databinding.FakebookListItemBinding
import br.com.fakebookmvp.domain.model.FakeBookDataDTO
import br.com.fakebookmvp.extensions.others.reducedDate

class FakeBookAdapter(
    private val books: List<FakeBookDataDTO>
) : RecyclerView.Adapter<FakeBookAdapter.FakeBookViewHolder>() {

    inner class FakeBookViewHolder(private val binding: FakebookListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: FakeBookDataDTO) = with(binding) {
            actvTitle.text = data.title
            actvAuthor.text = data.author
            actvPublished.text = data.published.reducedDate()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FakeBookViewHolder {
        return FakeBookViewHolder(
            FakebookListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FakeBookAdapter.FakeBookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount() = books.size

    private companion object : DiffUtil.ItemCallback<FakeBookDataDTO>() {

        override fun areItemsTheSame(oldItem: FakeBookDataDTO, newItem: FakeBookDataDTO): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: FakeBookDataDTO,
            newItem: FakeBookDataDTO
        ): Boolean {
            return oldItem == newItem
        }
    }
}