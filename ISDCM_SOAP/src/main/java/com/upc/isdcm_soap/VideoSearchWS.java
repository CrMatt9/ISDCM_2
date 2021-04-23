package com.upc.isdcm_soap;

import com.upc.isdcm_soap.models.Video;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "VideoSearchWS")
public class VideoSearchWS {
    @WebMethod(operationName = "busquedaPorTitulo")
    public List<Video> busquedaPorTitulo(@WebParam(name = "titulo") final String titulo, @WebParam(name = "user_id") final int user_id) {
        try{
            return Video.getVideosByTitle(user_id, titulo);
        } catch (SQLException e) {
            System.err.println("SQL EXCEPTION: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @WebMethod(operationName = "busquedaPorAutor")
    public List<Video> busquedaPorAutor(@WebParam(name = "autor") final String autor, @WebParam(name = "user_id") final int user_id) {
        try{
            return Video.getVideosByAuthor(user_id, autor);
        } catch (SQLException e) {
            System.err.println("SQL EXCEPTION: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @WebMethod(operationName = "busquedaPorFecha")
    public List<Video> busquedaPorFecha(@WebParam(name = "dia") final String dia,
                                        @WebParam(name = "mes") final String mes,
                                        @WebParam(name = "año") final String año,
                                        @WebParam(name = "user_id") final int user_id) {
        try{
            return Video.getVideosByDate(user_id, dia, mes, año);
        } catch (SQLException e) {
            System.err.println("SQL EXCEPTION: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @WebMethod(operationName = "busquedaTodos")
    public List<Video> busquedaTodos(@WebParam(name = "user_id") final int user_id) {
        try{
            return Video.getUserVideos(user_id);
        } catch (SQLException e) {
            System.err.println("SQL EXCEPTION: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
