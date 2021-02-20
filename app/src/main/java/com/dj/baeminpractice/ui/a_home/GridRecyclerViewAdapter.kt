package com.dj.baeminpractice.ui.a_home

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.dj.baeminpractice.MainActivity
import com.dj.baeminpractice.R
import com.dj.baeminpractice.model.GridItem
import com.dj.baeminpractice.ui.a_home.CategoryTab.CategoryActivity
import kotlinx.android.synthetic.main.item_layout_grid.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class GridRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var gridItemList: List<GridItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GridItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_grid, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return gridItemList?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        gridItemList?.let {
            (holder as GridItemViewHolder).bind(it[position])

            holder.itemView.setOnClickListener {

                //MainActivity.onFragmentChange();
                val intent = Intent(holder.itemView?.context, CategoryActivity::class.java)
                //intent.putExtra("img", whatToEatItem.imageUrl);
               // intent.putExtra("title", whatToEatItem.title)
                ContextCompat.startActivity(holder.itemView.context, intent, null)
            }
        }
    }

    //functions
    fun submitList(list: List<GridItem>?) {
        gridItemList = list
        notifyDataSetChanged()
    }


    class GridItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(gridItem: GridItem) {
            itemView.iv_grid_image.setImageResource(gridItem.image)
            itemView.tv_grid_title.text = gridItem.title

            if(gridItem.image == R.drawable.b){
                animateView(itemView.iv_grid_image)
            }
        }

        private fun animateView(ivGridImage: ImageView?) {
            var count=0
            ObjectAnimator.ofFloat(ivGridImage, "translationY", 7f).apply {
                duration = 100
                repeatCount = 2
                addListener(object : Animator.AnimatorListener {
                    override fun onAnimationRepeat(animation: Animator?) {
                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        count++
                        CoroutineScope(Main).launch {
                            if (count % 2 == 0) {
                                delay(1000)
                            } else {
                                delay(100)
                            }
                            start()
                        }
                    }

                    override fun onAnimationCancel(animation: Animator?) {
                    }

                    override fun onAnimationStart(animation: Animator?) {
                    }

                })
                start()
            }
        }

    }
}