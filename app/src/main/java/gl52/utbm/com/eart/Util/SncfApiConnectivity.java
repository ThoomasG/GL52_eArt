package gl52.utbm.com.eart.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.util.Base64;

/**
 * Created by Thomas on 12/06/2017.
 */

public class SncfApiConnectivity extends AsyncTask{

    private final String USER_AGENT = "Mozilla/5.0";
    private final String KEY = "60363df2-c1f6-42c5-92d3-5433869dbbcb";
    private String requestUrl;

    public SncfApiConnectivity() {

    }

    @Override
    protected Object doInBackground(Object[] params) {
        try {
            List<String> ids = getIdFromResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getIdFromResponse() throws Exception{

        String urlToUse = "https://api.sncf.com/v1/coverage/sncf/places?q=Belfort";

        ///coverage/{region_id}/{resource_path}/departures
        String response = sendGet(urlToUse);

        String [] splitResponse = new String(response).split(",");

        List<String> allIds = new ArrayList<String>();

        for(int i = 0; i < splitResponse.length; i++){
            if(splitResponse[i].split(":")[0].equals("\"id\"")){
                String [] id = splitResponse[i].split(":");
                if(id[1].equals("\"admin")){
                    String gareId = id[1] + ":" + id[2] + ":" + id[3];
                    if(!allIds.contains(gareId)){
                        allIds.add(gareId);
                        System.out.println(gareId);
                    }
                }
            }
        }
        return allIds;

    }

    // HTTP GET request
    private String sendGet(String url) throws Exception {

        String url_toGet = url;

        byte[] encoding = (this.KEY + ":").getBytes();
        String strEncoding = Base64.encodeToString(encoding, Base64.DEFAULT);

        URL obj = new URL(url_toGet);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty  ("Authorization", "Basic " + strEncoding);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url_toGet);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();

    }

}
