package com.ezored.sample.ui.fragment

import android.text.TextUtils
import android.view.MenuItem
import android.view.View

import androidx.recyclerview.widget.RecyclerView
import com.ezored.dataservices.TodoDataService
import com.ezored.domain.Todo
import com.ezored.sample.R
import com.ezored.sample.adapter.TodoAdapter
import com.ezored.sample.enums.LoadStateEnum
import com.ezored.sample.ui.fragment.base.BaseListFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoListFragment : BaseListFragment<Todo>(), TodoAdapter.TodoAdapterListener {

    private var searchText: String? = null

    override var adapter: RecyclerView.Adapter<*>
        get() {
            val adapter = TodoAdapter(context!!, listData)
            adapter.setListener(this)

            return adapter
        }
        set(value) {
            super.adapter = value
        }

    override val fragmentLayout: Int
        get() = R.layout.fragment_todo_list

    override val screenNameForAnalytics: String?
        get() = "ToDo List"

    override fun createAll(view: View) {
        super.createAll(view)

        setupToolbar(R.string.title_todo_list)
        showToolbarBackButton(true)

        validateLoadData()
    }

    override fun onLoadNewData() {
        super.onLoadNewData()

        GlobalScope.launch {
            listData = if (TextUtils.isEmpty(searchText)) {
                TodoDataService.findAllOrderByCreatedAtDesc()
            } else {
                TodoDataService.findByTitle(searchText)
            }

            withContext(context = Dispatchers.Main) {
                updateAdapter()

                remoteDataLoadState = LoadStateEnum.LOADED
            }
        }
    }

    override fun needLoadNewData(): Boolean {
        return isAdded
    }

    override fun onTodoItemClick(view: View, position: Int) {
        listData?.let { listData ->
            val todo = listData[position]
            TodoDataService.setDoneById(todo.id, !todo.done)

            listData[position] = TodoDataService.findById(todo.id)

            rvList.adapter?.notifyDataSetChanged()
        }
    }

    fun search(typedText: String) {
        if (remoteDataLoadState != LoadStateEnum.LOADING) {
            remoteDataLoadState = LoadStateEnum.NOT_LOADED
            searchText = typedText
            validateLoadData()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            if (it.itemId == R.id.menu_search) {
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun newInstance(): TodoListFragment {
            return TodoListFragment()
        }
    }

}
