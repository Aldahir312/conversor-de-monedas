import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversiones {
    HttpClient client = HttpClient.newHttpClient();
    double cambio;

    public void tasaConversion(String valorBase,String valorSalida,double cantidad){
        String direccion = "https://v6.exchangerate-api.com/v6/93ee651f4c35e3d687f8d14c/pair/"+valorBase+"/"+valorSalida+"/"+cantidad;

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            FactorConversion recuperacionExchangerate = gson.fromJson(json,FactorConversion.class);
            //System.out.println(recuperacionExchangerate);

            cambio = recuperacionExchangerate.conversion_result();
            System.out.println("El valor $"+cantidad+" ["+valorBase.toUpperCase()+"] corresponde al valor final de $"+cambio+" ["+valorSalida.toUpperCase()+"]");

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }}
