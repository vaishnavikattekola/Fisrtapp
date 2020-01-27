package com.example.fisrtapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fisrtapp.Retrofit.NetworkService;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView programmingList;
    ModelClass modelClass;
    private List<ModelClass> dataClassList;


//    private Integer[] images = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
//            R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10, R.drawable.pic11};
    //  private String[] title = {"Knowledgelens", "vmware", "Infosys", "Wipro", "Amazon", "Flipkart", "Microsoft", "Google", "Dell", "Apple"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        programmingList = findViewById(R.id.programmingList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        programmingList.setLayoutManager(linearLayoutManager);

        JsonObject ip_data = new JsonObject();
        ip_data.addProperty("", "");


        Call<ModelClass> call = NetworkService.getApiService(SecondActivity.this).getModelclass(ip_data);
        call.enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {

                modelClass = response.body();

                Log.e("Response", "True");
                Log.e("Status", modelClass.getStatus().toString());

                if (modelClass.getStatus()) {
                    MyAdapter adapter = new MyAdapter(SecondActivity.this, modelClass.getData());
                    programmingList.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {
            }
        });


        //start


//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(WebRequest.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ApiInterface api = retrofit.create(ApiInterface.class);
//
//        ip_data.addProperty("","");
//        Call<ModelClass> call;
//        call = api.getModelclass(ip_data);
//        call.enqueue(new Callback<ModelClass>() {
//            @Override
//
//            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
//                Log.e("MSg","response getting");
//
//                modelClass = response.body();
//
//
//                Log.e("Status",response.body().getStatus().toString());
////                for (int i=0; i<dataClassList.size();i++) {
////
////                    MyAdapter adapter = new MyAdapter(SecondActivity.this, dataClassList);
////                    programmingList.setAdapter(adapter);
////
////                    programmingList.setAdapter(new MyAdapter(SecondActivity.this,dataClassList));
////                    adapter.notifyDataSetChanged();
////                }
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<ModelClass> call, Throwable t) {
//                Log.e("Failed",t.toString());
//
//
//            }
//        });
//

        //end

//        for (int i = 0; i < title.length; i++) {
//            modelClassList.add(new ModelClass(images[i], title[i], ""));


//
    }

/*** JSON PARSING THROUGH RAW FILES***/
//    private void addItemsFRomJSON(  List<ModelClass> modelClassList,Integer[] images) {
//        try {
//            String jsonDataString = readJSONDataFromFile();
//            JSONObject parentObject = new JSONObject(jsonDataString);
//            String status = parentObject.getString("status");
//            String message = parentObject.getString("message");
//               if(status.equals("true")) {
//            JSONArray parentArray = parentObject.getJSONArray("data");
//                    for (int i = 0; i < parentArray.length(); i++) {
//                        JSONObject finalObject = parentArray.getJSONObject(i);
//                        String name = finalObject.getString("Name");
//                        String description = finalObject.getString("Description");
//
//
//                        modelClassList.add(new ModelClass(images[i], name, description));
//                    }}
//               else{
//                    String msg_on_fail = parentObject.getString("messageOnFail_Status");
//                    Toast.makeText(this,message,Toast.LENGTH_LONG).show();
//                }
//
//        }catch (JSONException | IOException e){
//            e.printStackTrace();
//            Toast.makeText(this,"Failed to fetch Data", Toast.LENGTH_LONG).show();
//
//
//        }
//    }
//    private String readJSONDataFromFile() throws IOException {
//        InputStream inputStream = null;
//        StringBuilder builder = new StringBuilder();
//        try {
//            String jsonString = null;
//            inputStream = getResources().openRawResource(R.raw.data);
//            BufferedReader bufferedReader = new BufferedReader(
//                new InputStreamReader(inputStream,"UTF-8"));
//            while((jsonString = bufferedReader.readLine())!=null){
//                builder.append(jsonString);
//            }
//
//        }finally {
//                if (inputStream!=null){
//                    inputStream.close();
//                }
//        }
//        return new String(builder);
//    }
}
