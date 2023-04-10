package antoni.nawrocki.restapi.task;

import android.icu.text.SimpleDateFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;

import antoni.nawrocki.restapi.MainActivity;
import antoni.nawrocki.restapi.adapter.DocumentAdapter;
import antoni.nawrocki.restapi.model.DocumentModelBuilder;

public class NewPersonRunnable implements Runnable {
    String link;
    MainActivity mainActivity;
    private DocumentAdapter documentAdapter;

    public NewPersonRunnable(MainActivity mainActivity, String link, DocumentAdapter documentAdapter) {
        this.link = link;
        this.mainActivity = mainActivity;
        this.documentAdapter = documentAdapter;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(link);
            InputStream inputStream = url.openStream();

            byte [] buffer = new byte[4096];
            StringBuilder builder = new StringBuilder("");
            while (true){
                try {
                    if (!(inputStream.read(buffer)>0)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                builder.append(new String(buffer));
            }

            JSONObject jsonObject = new JSONObject(builder.toString());

            JSONArray jsonArray = jsonObject.getJSONArray("results");
            JSONObject person = jsonArray.getJSONObject(0);

            JSONObject name = person.getJSONObject("name");
            String title = name.getString("title");
            String firstName = name.getString("first");
            String lastName = name.getString("last");

            JSONObject dob = person.getJSONObject("dob");

            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(dob.getString("date"));
            String birthDate = new SimpleDateFormat("dd-MM-yyyy").format(date);

            JSONObject picture = person.getJSONObject("picture");
            String pictureURL = picture.getString("thumbnail");
            String bigPictureURL = picture.getString("medium");

            JSONObject location = person.getJSONObject("location");
            JSONObject street = location.getJSONObject("street");
            String address =
                    street.getString("number") + " " +
                    street.getString("name");

            String phoneNumber = person.getString("phone");
            String email = person.getString("email");

            String nationality = person.getString("nat");

            mainActivity.documentArray.add(
                    new DocumentModelBuilder()
                            .setTitle(title)
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setBirthDate(birthDate)
                            .setPictureURL(pictureURL)
                            .setBigPictureURL(bigPictureURL)
                            .setPhoneNumber(phoneNumber)
                            .setEmail(email)
                            .setAddress(address)
                            .setNationality(nationality)
                            .build()
            );

            mainActivity.runOnUiThread(
                    new Runnable() {
                        @Override
                        public void run() {
                            documentAdapter.notifyDataSetChanged();
                        }
                    }
            );

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
