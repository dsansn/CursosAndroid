package es.davidsans.myapprecycler;

import es.davidsans.myapprecycler.models.ListAnimals;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by android on 26/03/2018.
 */

public interface Api {

    /**
     * Llamada a Personas
     */

    @GET("/listado")
    Call<ListAnimals> getListAnimals();



}
