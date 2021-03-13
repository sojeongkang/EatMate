package com.dj.baeminpractice.ui.d_community

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ExifInterface
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dj.baeminpractice.MainActivity
import com.dj.baeminpractice.R
import kotlinx.android.synthetic.main.fragment_contents_upload.*

class ContentsUploadFragment: Fragment(R.layout.fragment_contents_upload){
    private lateinit var mContext : Context
    private val GET_GALLERY_IMAGE = 200
    // MediaStore.Images.Thumbnails
    val MINI_KIND = 1 // 512 x 384
    val MICRO_KIND = 3 // 96 x 96

    fun newInstance():ContentsUploadFragment {
        return ContentsUploadFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (getActivity() as MainActivity).fab_upload.hide()

        iv_img_upload.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK)
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
            startActivityForResult(intent, GET_GALLERY_IMAGE)
        }

        bt_upload.setOnClickListener {
            Toast.makeText(this.context, "업로드 완료", Toast.LENGTH_SHORT).show()
            (getActivity() as MainActivity).replaceFragment(CommunityFragment().newInstance())
            //서버에 콘텐츠 업로드하는 코드 작성

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.data != null) {
            val selectedImageUri: Uri? = data.data

            iv_showImage.setImageURI(selectedImageUri)
        }
    }

}