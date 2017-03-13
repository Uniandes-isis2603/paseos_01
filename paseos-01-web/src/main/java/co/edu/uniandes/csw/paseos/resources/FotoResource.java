
package co.edu.uniandes.csw.paseos.resources;

import co.edu.uniandes.csw.paseos.dtos.FotoDTO;
import co.edu.uniandes.csw.paseos.ejbs.FotoLogic;
import co.edu.uniandes.csw.paseos.ejbs.PaseoLogic;
import co.edu.uniandes.csw.paseos.ejbs.VisitaLogic;
import co.edu.uniandes.csw.paseos.entities.FotoEntity;
import co.edu.uniandes.csw.paseos.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FotoResource {
    
    @Inject
    private FotoLogic fotoLogic;
    
    @Inject
    private VisitaLogic visistaLogic;
    
    @Inject
    private PaseoLogic paseoLogic;
    
    /**
     * Convierte una lista de EmployeeEntity a una lista de EmployeeDetailDTO.
     *
     * @param entityList Lista de EmployeeEntity a convertir.
     * @return Lista de EmployeeDetailDTO convertida.
     * @generated
     */
    private List<FotoDTO> listEntity2DTO(List<FotoEntity> entityList){
        List<FotoDTO> list = new ArrayList<>();
        for (FotoEntity entity : entityList) {
            list.add(new FotoDTO(entity));
        }
        return list;
    }
    
    @GET
    @Path("/fotos")
    public List <FotoDTO> getFotos(){
        return listEntity2DTO(fotoLogic.getFotos());
    }
    
    @GET
    @Path("/fotos/{id: \\d+}")
    public FotoDTO getFoto(@PathParam("id") Long id, @PathParam("idVisita") Long idVisita){
        return new FotoDTO(fotoLogic.getFoto(id));
    }
    
    @GET
    @Path("/visitas/{idVisita: \\d+}/fotos/{id: \\d+}")
    public FotoDTO getFotoVisita(@PathParam("id") Long id, @PathParam("idVisita") Long idVisita){
        return new FotoDTO(fotoLogic.getFoto(id));
    }
    
    @GET
    @Path("/paseos/{idPaseo: \\d+}/fotos/{id: \\d+}")
    public FotoDTO getFotoPaseo(@PathParam("id") Long id, @PathParam("idPaseo") Long idPaseo){
        return new FotoDTO(fotoLogic.getFoto(id));
    }
    
    //POST /companies -- agrega una habitacion
    @POST
    @Path("/visitas/{idVisita: \\d+}/fotos")
    public FotoDTO addFotoVisita(@PathParam("idVisita") Long idVisita, FotoDTO fotoDTO)throws BusinessLogicException{
        return new FotoDTO(fotoLogic.createFoto(fotoDTO.toEntity()));
    }
    
    @POST
    @Path("/paseos/{idPaseo: \\d+}/fotos")
    public FotoDTO addFotoPaseo(@PathParam("idPaseo") Long idPaseo, FotoDTO fotoDTO)throws BusinessLogicException{
        return new FotoDTO(fotoLogic.createFoto(fotoDTO.toEntity()));
    }
    
    @DELETE
    @Path("/visitas/{idVisita: \\d+}/fotos/{id: \\d+}")
    public void deleteFotoVisita(@PathParam("id") Long id, @PathParam("idVisita") Long idVisita) {
        fotoLogic.deleteFoto(id);
    }
    
    @DELETE
    @Path("/paseos/{idPaseo: \\d+}/fotos/{id: \\d+}")
    public void deleteFotoPaseo(@PathParam("id") Long id, @PathParam("idPaseo") Long idPaseo) {
        fotoLogic.deleteFoto(id);
    }
 }
