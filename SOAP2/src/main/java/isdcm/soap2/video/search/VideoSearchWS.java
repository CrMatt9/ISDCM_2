/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webservice.video.search;

import isdcm.webservice.models.Video;
import java.sql.SQLException;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CristianMatas
 */
@WebService(serviceName = "VideoSearchWS")
public class VideoSearchWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "BusquedaPorTitulo")
    public List<Video> BusquedaPorTitulo(@WebParam(name = "Titulo") final String Titulo, @WebParam(name = "Id") final int Id) throws SQLException {
        try{
            return Video.getVideosByTitle(Id, Titulo);
        } catch (SQLException e) {
            System.err.println("SQL EXCEPTION: " + e.getMessage());
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "BusquedaPorAutor")
    public List<Video> BusquedaPorAutor(@WebParam(name = "Autor") final String Autor, @WebParam(name = "Id") final int Id) {
        try{
            return Video.getVideosByAuthor(Id, Autor);
        } catch (SQLException e) {
            System.err.println("SQL EXCEPTION: " + e.getMessage());
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "BusquedaPorFecha")
    public List<Video> BusquedaPorFecha(@WebParam(name = "Fecha") final String Fecha, @WebParam(name = "Id") final int Id) {
        try{
            return Video.getVideosByDate(Id, Fecha);
        } catch (SQLException e) {
            System.err.println("SQL EXCEPTION: " + e.getMessage());
            return null;
        }
    }
}
