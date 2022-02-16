package com.example.sharesheet_tutorial

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var field: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        field = findViewById(R.id.field)

        //Text 공유
        button.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, field.text)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, "Text 공유")
            startActivity(shareIntent)
        }

        /*바이너리 콘텐츠 공유
        button.setOnClickListener{
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, field.text)
                type = "image/jpeg"
            }

            val shareIntent = Intent.createChooser(sendIntent, "제목")
            startActivity(shareIntent)
        }*/

        /*MIME 종류
        text/plain, text/rtf, text/html, text/json
        image/jpg, image/png, image/gif
        video/mp4, video/3gp
        application/pdf
        */

        /*여러 콘텐츠 공유
        val imageUris: ArrayList<Uri> = arrayListOf(
        // Add your image URIs here
        imageUri1,
        imageUri2
        )

        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND_MULTIPLE
            putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris)
            type = "image/jpeg"
        }
        startActivity(Intent.createChooser(shareIntent, "Share images to.."))*/

        /*미리보기 추가
        val share = Intent.createChooser(Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "https://developer.android.com/training/sharing/")

            // (Optional) Here we're setting the title of the content
            putExtra(Intent.EXTRA_TITLE, "Introducing content previews")

            // (Optional) Here we're passing a content URI to an image to be displayed
            data = contentUri
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        }, null)
        startActivity(share)*/

        /*맞춤 타겟 추가
        val share = Intent.createChooser(myShareIntent, null).apply {
            putExtra(Intent.EXTRA_CHOOSER_TARGETS, myChooserTargetArray)
            putExtra(Intent.EXTRA_INITIAL_INTENTS, myInitialIntentArray)
        }
         */

        /*구성요소별 타겟 제거
        val share = Intent.createChooser(myShareIntent, null).apply {
            // Only use components you have control over
            share.putExtra(Intent.EXTRA_EXCLUDE_COMPONENTS, myComponentArray)
        }
         */

        /*공유 정보 가져오기
        var share = new Intent(Intent.ACTION_SEND);
        ...
        val pi = PendingIntent.getBroadcast(myContext, requestCode, Intent(myContext, MyBroadcastReceiver.class),
        Intent.FLAG_UPDATE_CURRENT)
        share = Intent.createChooser(share, null, pi.intentSender);
         */
        /*콜백 수신
        override fun onReceive(context: Context, intent: Intent) {
            ...
            val clickedComponent : ComponentName = intent.getParcelableExtra(EXTRA_CHOSEN_COMPONENT);
        }
         */
        /*인텐트 리졸버 사용
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/plain"
        }
        startActivity(sendIntent)
         */
    }
}