package antoni.nawrocki.restapi.task;

import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import antoni.nawrocki.restapi.fragments.chuck_norris;

public class ChuckNorrisRunnable implements Runnable {
    chuck_norris chuck_norris;
    TextView textView;

    public ChuckNorrisRunnable(chuck_norris chuck_norris, TextView textView) {
        this.chuck_norris = chuck_norris;
        this.textView = textView;
    }

    @Override
    public void run() {
        try {
            URL url = new URL("https://api.chucknorris.io/jokes/random");
            InputStream inputStream = url.openStream();

            byte[] buffer = new byte[4096];
            StringBuilder builder = new StringBuilder("");
            while (true) {
                try {
                    if (!(inputStream.read(buffer) > 0)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                builder.append(new String(buffer));
            }

            JSONObject jsonObject = new JSONObject(builder.toString());

            String value = jsonObject.getString("value");

            if (chuck_norris.getActivity() != null) {
                chuck_norris.getActivity().runOnUiThread(() -> textView.setText(value));
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }
}
