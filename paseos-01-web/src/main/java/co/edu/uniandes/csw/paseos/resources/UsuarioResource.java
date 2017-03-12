/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.paseos.resources;


import javax.ws.rs.Path;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import co.edu.uniandes.csw.paseos.dtos.UsuarioDetailDTO;
import co.edu.uniandes.csw.paseos.ejbs.UsuarioLogic;
import co.edu.uniandes.csw.paseos.entities.UsuarioEntity;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;


/**
 * URI: usuarios/
 * @generated
 */
@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    
    @Inject 
    private UsuarioLogic usuarioLogic;
    
    /**
     * Convierte una lista de EmployeeEntity a una lista de EmployeeDetailDTO.
     *
     * @param entityList Lista de EmployeeEntity a convertir.
     * @return Lista de EmployeeDetailDTO convertida.
     * @generated
     */
    private List<UsuarioDetailDTO> listEntity2DTO(List<UsuarioEntity> entityList){
        List<UsuarioDetailDTO> list = new ArrayList<>();
        for (UsuarioEntity entity : entityList) {
            list.add(new UsuarioDetailDTO(entity));
        }
        return list;
    }
    
  /**
     * Obtiene la lista de los registros de Usuario
     *
     * @return Colección de objetos de UsuarioDetailDTO
     * @generated
     */
    @GET
    public List<UsuarioDetailDTO> getEmployees() {
        
        return listEntity2DTO(usuarioLogic.getUsuarios());
    }  
     /**
     * Obtiene los datos de una instancia de Usuario a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de UsuarioDetailDto con los datos del Usuario consultado
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public UsuarioDetailDTO getUsuario(@PathParam("id") Long id) {
        return new UsuarioDetailDTO(usuarioLogic.getUsuario(id));
    }

    /**
     * Se encarga de crear un Usuario en la base de datos
     *
     * @param dto Objeto de UsuarioDetailDTO con los datos nuevos
     * @return Objeto de UsuarioDetailDto con los datos nuevos y su ID
     * @generated
     */
    @POST
    public UsuarioDetailDTO createUsuario(UsuarioDetailDTO dto) {
        return new UsuarioDetailDTO(usuarioLogic.createUsuario(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de Usuario
     *
     * @param id Identificador de la instancia de Usuario a modificar
     * @param dto Instancia de UsuarioDetailDTO con los nuevos datos
     * @return Instancia de UsuarioDetailDTO con los datos actualizados
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public UsuarioDetailDTO updateUsuario(@PathParam("id") Long id, UsuarioDetailDTO dto) {
        UsuarioEntity entity = dto.toEntity();
        entity.setId(id);
        return new UsuarioDetailDTO(usuarioLogic.updateUsuario(entity));
    }

    /**
     * Elimina una instancia de Usuario de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteUsuario(@PathParam("id") Long id) {
        usuarioLogic.deleteUsuario(id);
    }
    
} 