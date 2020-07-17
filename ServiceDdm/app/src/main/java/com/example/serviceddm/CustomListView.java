package com.example.serviceddm;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.InputStream;

public class CustomListView extends ArrayAdapter<String> {

    private String[] profilename;
    private String[] des;
    private String[] imagepath;
    private String[] mobile_no;
    private String[] category;
    private String[] address;
    private Activity context;
    Bitmap bitmap;

    public CustomListView(Activity context,String[] name, String[] des, String[] imagepath, String[] mobile_no, String[] category, String[] address) {
        super(context, R.layout.layout, name);
        this.context=context;
        this.profilename=name;
        this.des=des;
        this.imagepath=imagepath;
        this.mobile_no=mobile_no;
        this.category=category;
        this.address=address;
    }


    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layout,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)r.getTag();

        }

        viewHolder.tvw1.setText(profilename[position]);
        viewHolder.tvw2.setText(des[position]);
        viewHolder.tvw3.setText(mobile_no[position]);
        viewHolder.tvw4.setText(category[position]);
        viewHolder.tvw5.setText(address[position]);
        new GetImageFromURL(viewHolder.ivw).execute(imagepath[position]);

        return r;
    }

    class ViewHolder{

        TextView tvw3;
        TextView tvw4;
        TextView tvw1;
        TextView tvw2;
        TextView tvw5;
        ImageView ivw;

        ViewHolder(View v){
            tvw1=(TextView)v.findViewById(R.id.tvprofilename);
            tvw2=(TextView)v.findViewById(R.id.tvdes);
            tvw3=(TextView)v.findViewById(R.id.tvmobile_no);
            tvw4=(TextView)v.findViewById(R.id.tvcategory);
            tvw5=(TextView)v.findViewById(R.id.tvaddress);
            ivw=(ImageView)v.findViewById(R.id.imageView);
        }

    }

    public class GetImageFromURL extends AsyncTask<String,Void,Bitmap>
    {

        ImageView imgView;
        public GetImageFromURL(ImageView imgv)
        {
            this.imgView=imgv;
        }
        @Override
        protected Bitmap doInBackground(String... url) {
            String urldisplay=url[0];
            bitmap=null;

            try{

                InputStream ist=new java.net.URL(urldisplay).openStream();
                bitmap= BitmapFactory.decodeStream(ist);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap){

            super.onPostExecute(bitmap);
            imgView.setImageBitmap(bitmap);
        }
    }



}

