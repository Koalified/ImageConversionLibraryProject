package ca.useful.imageconversionlibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import utilities.PhotoUtilities;
import utilities.URLUtilities;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    public Context context = null;
    @Before
    public void setUp() {
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        context = appContext;

        assertEquals("ca.useful.imageconversionlibrary", appContext.getPackageName());
    }

    @Test
    public void usePhotoUtilitiesMethods() {
        if (context == null) {
            retrieveContext();
        }
        byte[] imgBytes = PhotoUtilities.getImageBytesFromBase64(SampleData.base64Image);
        if (imgBytes == null || imgBytes.length == 0) {
            Assert.fail("The byte Array Did not process properly getImageBytesFromBase64");
        }
        Bitmap bmp = PhotoUtilities.getBitmapFromByteArray(imgBytes);
        if (bmp == null){
            Assert.fail("The bitmap returned null in getBitmapFromByteArray");
        }
        imgBytes = PhotoUtilities.getByteArrayFromBitmap(bmp);
        if (imgBytes== null || imgBytes.length == 0) {
            Assert.fail("Byte array returned null in getByteArrayFromBitmap");
        }
        String base64 = PhotoUtilities.getBase64FromByteArray(imgBytes);
        if (base64 == null && base64.isEmpty()) {
            Assert.fail("Base64 did not return properly in getBase64FromByteArray");
        }

    }

    @Test
    public void useURLUtilities() throws Exception {
        if (context == null) {
            retrieveContext();
        }

        Bitmap bmp = URLUtilities.getPhotoFromURL(SampleData.urlImage);
        if (bmp == null) {
            Assert.fail("Could not retrieve the photo from the URL");
        }
    }

    private void retrieveContext() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        context = appContext;
    }
}
