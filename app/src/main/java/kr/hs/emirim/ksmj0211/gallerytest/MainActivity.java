package kr.hs.emirim.ksmj0211.gallerytest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Gallery gallery;
    ImageView imgMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery = (Gallery)findViewById(R.id.gallery_1);
        imgMain = (ImageView)findViewById(R.id.imgv_main);
        MyGalleryAdapter adapter = new MyGalleryAdapter(this);
        gallery.setAdapter(adapter);

    }

    public class MyGalleryAdapter extends BaseAdapter{
        Context context;
        int[] posterIDs = {R.drawable.gyu1, R.drawable.ddong1, R.drawable.woohyun1,
                R.drawable.jjong2, R.drawable.yeol1, R.drawable.soo1,
                R.drawable.soo3, R.drawable.jjong1, R.drawable.jjong3,
                R.drawable.ifnt1};

        public MyGalleryAdapter(Context context){
            this.context=context;
        }
        public int getCount(){
            return posterIDs.length;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imgV = new ImageView(context);
            imgV.setLayoutParams(new Gallery.LayoutParams(200, 300));
            imgV.setScaleType(ImageView.ScaleType.FIT_CENTER);
            //imgV.setPadding(5, 5, 5, 5);
            imgV.setImageResource(posterIDs[position]);
            final int pos = position;
            imgV.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    imgMain.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imgMain.setImageResource(posterIDs[pos]);
                    return false;
                }
            });
            return imgV;
        }
        public Object getItem(int position){
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    }
}
