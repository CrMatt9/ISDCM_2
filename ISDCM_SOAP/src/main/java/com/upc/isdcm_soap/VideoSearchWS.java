package com.upc.isdcm_soap;

import java.sql.SQLException;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "VideoSearchWS")
public class VideoSearchWS {
    @WebMethod(operationName = "BusquedaPorTitulo")
    public List<Video> BusquedaPorTitulo(@WebParam(name = "Titulo") final String Titulo, @WebParam(name = "Id") final int Id) {
        try{
            return Video.getVideosByTitle(Id, Titulo);
        } catch (SQLException e) {
            System.err.println("SQL EXCEPTION: " + e.getMessage());
            return null;
        }
    }

    @WebMethod(operationName = "BusquedaPorAutor")
    public List<Video> BusquedaPorAutor(@WebParam(name = "Autor") final String Autor, @WebParam(name = "Id") final int Id) {
        try{
            return Video.getVideosByAuthor(Id, Autor);
        } catch (SQLException e) {
            System.err.println("SQL EXCEPTION: " + e.getMessage());
            return null;
        }
    }

    @WebMethod(operationName = "BusquedaPorFecha")
    public List<Video> BusquedaPorFecha(@WebParam(name = "dia") final String dia,
                                        @WebParam(name = "mes") final String mes,
                                        @WebParam(name = "año") final String año,
                                        @WebParam(name = "Id") final int Id) {
        try{
            return Video.getVideosByDate(Id, dia, mes, año);
        } catch (SQLException e) {
            System.err.println("SQL EXCEPTION: " + e.getMessage());
            return null;
        }
    }
}
