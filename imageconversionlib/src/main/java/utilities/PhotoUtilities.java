package utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import java.io.ByteArrayOutputStream;

public class PhotoUtilities {

    private static final String TAG = "PhotoUtilities";

    public static Bitmap getBitmapFromResourceID(Context context, int resourceId) {
        //decodes the photo provided
        if (context == null) {
            throw new NullPointerException("Context was null in getBitmapFromResourceID");
        }
        Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), resourceId);
        if (bmp == null) {
            throw new NullPointerException("Couldn't decode the image resource in getBitmapFromResourceID");
        } else {
            return bmp;
        }
    }

    public static Bitmap getScaledBitmap(Bitmap bitmap, int scalePercentage) {
        if (bitmap==null) {
            throw new NullPointerException("The bitmap was null in getScaledBitmap!");
        }
        double scalePerc = scalePercentage / 100;
        Bitmap bmp = Bitmap.createScaledBitmap(bitmap, (int)(bitmap.getWidth() * scalePerc), (int)(bitmap.getHeight() * scalePerc), true);
        if (bmp == null) {
            throw new NullPointerException("Couldn't create a scaled bitmap in getScaledBitmap");
        } else {
            return bmp;
        }
    }

    public static Bitmap getBitmapFromByteArray(byte[] imgBytes) {
        if (imgBytes == null || imgBytes.length == 0) {
            throw new NullPointerException("The byte array was empty or null in getBitmapFromByteArray!");
        }
        Bitmap bmp = BitmapFactory.decodeByteArray(imgBytes, 0, imgBytes.length);
        if (bmp == null) {
            throw new NullPointerException("Couldn't decode the byte array in getBitmapFromBase64");
        } else {
            return bmp;
        }
    }

    public static Bitmap getBitmapFromBase64(String base64String) {
        if (base64String == null || base64String.isEmpty()) {
            throw new NullPointerException("The base64 String was empty or null in getBitmapFromBase64!");
        }
        byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
        Bitmap bmp = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        if (bmp == null) {
            throw new NullPointerException("Couldn't decode the byte array in getBitmapFromBase64");
        } else {
            return bmp;
        }
    }

    public static byte[] getByteArrayFromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("The bitmap was null in getByteArrayFromBitmap!");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        if (bytes == null || bytes.length == 0) {
            throw new NullPointerException("Couldn't decode the bitmap into bytes in getByteArrayFromBitmap");
        } else {
            return bytes;
        }
    }

    public static String getBase64FromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("The bitmap was null in getBase64FromBitmap!");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream .toByteArray();
        String base = Base64.encodeToString(byteArray, Base64.DEFAULT);
        if (base == null || base.isEmpty()) {
            throw new NullPointerException("Couldn't encode the byte array in getBase64FromBitmap!");
        } else {
            return base;
        }
    }

    public static byte[] getImageBytesFromBase64(String base64String) {
        if (base64String == null || base64String.isEmpty()) {
            throw new NullPointerException("The base64 String was empty or null in getImageBytesFromBase64!");
        }
        byte[] bytes = Base64.decode(base64String, Base64.DEFAULT);
        if (bytes == null || bytes.length == 0) {
            throw new NullPointerException("Couldn't decode the base 64 String in getImageBytesFromBase64") ;
        } else {
            return bytes;
        }

    }

    public static String getBase64FromByteArray(byte[] imgBytes) {
        if (imgBytes == null || imgBytes.length == 0) {
            throw new NullPointerException("The byte array was empty or null in getBase64FromByteArray!");
        }
        String base = Base64.encodeToString(imgBytes, Base64.DEFAULT);
        if (base == null || base.isEmpty()) {
            throw new NullPointerException("Couldn't encode the byte array in getBase64FromByteArray!");

        } else {
            return base;
        }
    }


}
