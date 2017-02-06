package utilities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLUtilities {

    private static final String TAG = "URLUtilities";

    public static Bitmap getPhotoFromURL(String strUrl) throws Exception {
        Bitmap photo = null;
        InputStream in = null;
        URL url = new URL(strUrl);
        URLConnection conn = null;
        try {
            conn = url.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
            photo = BitmapFactory.decodeStream(in);

        } catch (Exception ex) {
            Log.e(TAG, "Error generating photo from URL: " + ex.getMessage());
            Log.e(TAG, "Couldn't parse for a photo!");
            return null;
        } finally {
            try {
                in.close();
            } catch (Exception ex) {
                throw new Exception("Couldn't close the input Stream!");
            }
        }
        return photo;
    }
}
