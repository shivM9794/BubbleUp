package app.bubbleup.SideNavigationSection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import java.util.Calendar;

import app.bubbleup.R;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About_UsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Element adsElement = new Element();
        adsElement.setTitle("Join Us");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.splash_icon)
                .addItem(new Element().setTitle("Version 1.1"))
                .addItem(adsElement)
                .setDescription("Bubble Up is an online laundry service having variety of cleaning options at an affordable price. ")
                .addGroup("Connect with us")
                .addEmail("bubbleup@gmail.com")
                .addWebsite("https://www.bubbleup.in/")
                .addFacebook("https://www.facebook.com/BubbleUp/")
                .addTwitter("Second_Warranty")
//                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addPlayStore("com.secondwarranty.app")
                .addInstagram("bubble_up")

                .addItem(getCopyRightsElement())
                .create();

        setContentView(aboutPage);
    }


    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = String.format(getString(R.string.copy_right), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.about_icon_copy_right);
        copyRightsElement.setAutoApplyIconTint(true);
        copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);
//        copyRightsElement.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), copyrights, Toast.LENGTH_SHORT).show();
//            }
//        });
        return copyRightsElement;
    }
}