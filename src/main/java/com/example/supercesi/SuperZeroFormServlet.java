package com.example.supercesi;

import com.example.bdd.GetConnection;
import com.example.bdd.SuperZConnection;
import com.example.beans.SuperZeroModel;
import com.example.forms.ConnectionForm;
import com.mapbox.api.geocoding.v5.GeocodingCriteria;
import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import com.mapbox.core.exceptions.ServicesException;
import com.mapbox.geojson.Point;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import static com.example.supercesi.MapServlet.GetAllIncidents;

@WebServlet(name = "SuperZeroFormServlet", value = "/SuperZeroFormServlet")
public class SuperZeroFormServlet extends HttpServlet {

    public SuperZeroFormServlet(){
        super();
    }

    private GetConnection _getConnection = new GetConnection();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HomeServlet.GetSuperZDisplaying(request, response);
        GetAllIncidents(request, response);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegisterNewSuperZInDB(request, response);
        HomeServlet.GetSuperZDisplaying(request, response);
        GetAllIncidents(request, response);
        response.sendRedirect(request.getContextPath() + "/Home");
    }

    private void RegisterNewSuperZInDB(HttpServletRequest request, HttpServletResponse response){
        ConnectionForm form = new ConnectionForm();
        SuperZeroModel superZ = form.newSuperZ(request);
        request.setAttribute("newSuperZ", superZ);
        SuperZConnection superZConnection = new SuperZConnection(_getConnection.getConnection());
        superZConnection.PostNewSuperZ(superZ);
    }

    private void test(){
        String testYallah ="";
        try{
            MapboxGeocoding test = MapboxGeocoding.builder()
                    .accessToken("pk.eyJ1Ijoia2Vtcm9kZSIsImEiOiJjbDAzbmkycjkwZXB6M25xZGkxNzFtNGFtIn0.H_y4SaibmfnmyxzT9VfOww")
                    .query("Rouen")
                    .geocodingTypes(GeocodingCriteria.TYPE_PLACE)
                    .mode(GeocodingCriteria.MODE_PLACES)
                    .build();
            test.enqueueCall(new Callback<GeocodingResponse>() {
                @Override
                public void onResponse(Call<GeocodingResponse> call, Response<GeocodingResponse> response) {
                    if(response.body() != null){
                        List<CarmenFeature> results = response.body().features();
                        if(results.size()> 0){
                            Point firstResutPoint = results.get(0).center();

//                    Log.d(TAG, "onResponse: " + firstResutPoint.toString());
                        } else {
//                    Log.d(TAG, "onResponse : No result found");
                        }
                    }
                }

                @Override
                public void onFailure(Call<GeocodingResponse> call, Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        } catch(ServicesException e){
            e.printStackTrace();
        }
    }
}
