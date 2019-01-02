package com.techmashinani.contexualactionbarsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var actionMode: ActionMode? = null

    private val actionModelCallback = object: ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            mode?.menuInflater?.inflate(R.menu.context, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            actionMode = null
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            when(item?.itemId) {
                R.id.action_delete -> {
                    Toast.makeText(this@MainActivity, "Delete", Toast.LENGTH_LONG).show()
                    mode?.finish()
                    return true
                }
                R.id.action_edit -> {
                    Toast.makeText(this@MainActivity, "Edit", Toast.LENGTH_LONG).show()
                    mode?.finish()
                    return true
                }
                R.id.action_share -> {
                    Toast.makeText(this@MainActivity, "Share", Toast.LENGTH_LONG).show()
                    mode?.finish()
                    return true
                } else -> return false
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.setup()
    }

    private fun setup() {
        text_action.setOnLongClickListener {
            if(actionMode != null) return@setOnLongClickListener false

            this.actionMode =  startSupportActionMode(actionModelCallback) as ActionMode
            it.isSelected = true
            return@setOnLongClickListener true
        }
    }
}
