package com.example.gmailcloneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var emails: List<Email>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = findViewById<RecyclerView>(R.id.emailsRv)
        emails = EmailFetcher.getEmails()
        val adapter = EmailAdapter(emails)
        layout.adapter = adapter
        layout.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.loadMoreBtn).setOnClickListner {

            val newEmails = EmailFetcher.getNext5Emails()
            emails.addAll(newEmails)
            adapter.notify
            adapter.notifyDataSetChanged()


        }

    }
}