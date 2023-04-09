package com.example.propertraion

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.propertraion.databinding.BabContainerBinding
import com.example.propertraion.databinding.SubbabContainerBinding

class CustomExpandableListAdapter internal constructor
    (private var context: Context,
     private val babList: List<String>,
     private val subBabList: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private lateinit var babBinding: BabContainerBinding
    private lateinit var subBabBinding: SubbabContainerBinding

    override fun getChild(listPosition: Int, expandedListPosition: Int): Any {
        return this.subBabList[this.babList[listPosition]]!![expandedListPosition]
    }
    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }
    override fun getChildView(
        listPosition: Int,
        expandedListPosition: Int,
        isLastChild: Boolean,
        view: View?,
        parent: ViewGroup
    ): View {
        var convertView = view
        val holder: SubBabViewHolder
        if (convertView == null) {
            subBabBinding = SubbabContainerBinding.inflate(inflater)
            convertView = subBabBinding.root
            holder = SubBabViewHolder()
            holder.label = subBabBinding.tvSubbab
            convertView.tag = holder
        } else {
            holder = convertView.tag as SubBabViewHolder
        }
        val expandedListText = getChild(listPosition, expandedListPosition) as String
        holder.label!!.text = expandedListText
        return convertView
    }

    override fun getChildrenCount(listPosition: Int): Int {
        return this.subBabList[this.babList[listPosition]]!!.size
    }

    override fun getGroup(listPosition: Int): Any {
        return this.babList[listPosition]
    }

    override fun getGroupCount(): Int {
        return this.babList.size
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun getGroupView(
        listPosition: Int,
        isExpanded: Boolean,
        view: View?,
        parent: ViewGroup
    ): View {
        var convertView = view
        val holder: BabViewHolder
        if (convertView == null) {
            babBinding = BabContainerBinding.inflate(inflater)
            convertView = babBinding.root
            holder = BabViewHolder()
            holder.label = babBinding.tvBab
            convertView.tag = holder
        } else {
            holder = convertView.tag as BabViewHolder
        }
        val listTitle = getGroup(listPosition) as String
        holder.label!!.text = listTitle
        return convertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }


    inner class SubBabViewHolder {
        internal var label: TextView? = null
    }

    inner class BabViewHolder {
        internal var label: TextView? = null
    }


}