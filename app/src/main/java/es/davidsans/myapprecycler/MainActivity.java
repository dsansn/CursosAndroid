package es.davidsans.myapprecycler;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import es.davidsans.myapprecycler.models.Animals;
import es.davidsans.myapprecycler.models.ListAnimals;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Animals> animalsList;
    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //2 Referenciar el recycler view
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        /*
        //2 Referenciar el recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);



        //3 Generar un adapter
        AnimalsAdapter animalsAdapter = new AnimalsAdapter(animalsList);

        recyclerView.setAdapter(animalsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://idiariosprocesosapi.wordplex.es:8186")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api apiService = retrofit.create(Api.class);

        apiService.getListAnimals().enqueue(new Callback<ListAnimals>() {
            @Override
            public void onResponse(Call<ListAnimals> call, Response<ListAnimals> response) {
Log.e("Exito","concectado"+response.body().getDetail().get(0).getNombre());

            }

            @Override
            public void onFailure(Call<ListAnimals> call, Throwable t) {

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class AsynAnimalsList extends AsyncTask<Void,Void,ArrayList<Animals>>{

        @Override
        protected ArrayList<Animals> doInBackground(Void... voids) {

            return makeAnimalsList();
        }


        @Override
        protected void onPostExecute(ArrayList<Animals> animals) {
            super.onPostExecute(animals);



            //3 Generar un adapter
            AnimalsAdapter animalsAdapter = new AnimalsAdapter(animals);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(animalsAdapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,false);

            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            //recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));



        }

        private ArrayList<Animals> makeAnimalsList() {
            ArrayList<Animals> prueba = new ArrayList<>();

            prueba.add(new Animals(R.drawable.img_gansos,"Gansos","Gansus blancus","Polonia"));
            prueba.add(new Animals(R.drawable.img_oso,"Oso","Osus blancus","Polo Norte"));
            prueba.add(new Animals(R.drawable.img_ardilla,"Ardilla","Ardillus blancus","America"));
            prueba.add(new Animals(R.drawable.img_elefante,"Elefente","Elephant blancus","Asia"));
            prueba.add(new Animals(R.drawable.img_leon,"León","Gansus blancus","Abrica"));
            prueba.add(new Animals(R.drawable.img_lobo,"Lobo","Lobus blancus","Spain"));
            prueba.add(new Animals(R.drawable.img_mariposa,"Mariposa","Gansus blancus","San Francisco"));
            prueba.add(new Animals(R.drawable.img_aguila,"Aguila","Aguilus blancus","California"));

            return prueba;

        }


    }



}
