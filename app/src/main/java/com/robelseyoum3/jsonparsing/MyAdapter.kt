package com.robelseyoum3.jsonparsing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_layout.view.*

class MyAdapter(private var context: Context,
                private var personNames: ArrayList<String>,
                private var emailIds: ArrayList<String>,
                private var mobileNumber: ArrayList<String>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return personNames.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = personNames[position]
        holder.email.text = emailIds[position]
        holder.mobileNo.text = mobileNumber[position]
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        internal var name = itemView.tvname
        internal var email = itemView.tvemail
        internal var mobileNo = itemView.tvmobileNo
    }
}