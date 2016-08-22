package restapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.WallPost;
import model.WallPostModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static tools.RestTools.toJson;

@Path("/posts")
public class PostResource {

    @GET
    @Path("/test")
    @Produces(APPLICATION_JSON)
    public Response test(){

        String jopa = "test";
        String json = null;
        try {
            json = toJson(jopa);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return Response.ok(json).build();
    }

    @PUT
    @Path("/update/{id}")
//    public Response updatePostById(@PathParam("id") int id, @QueryParam("post") String post) {
    public Response updatePostById(@PathParam("id") int id, @FormParam("post") String post) {
        final Logger MEGALOG = LogManager.getLogger(WallPostModel.class);

        System.out.println("this is post ->" + post);
        System.out.println("this is postId ->" + id);
        WallPostModel model = new WallPostModel();

      //  if (!getSessionUserOpt(request.getSession()).isPresent()) {
      //      log.warn("No user session found. Cannot add like");
        //    return Response.status(Response.Status.FORBIDDEN)
        //            .entity("User is not signedup").build();
        //}

        try {
            MEGALOG.info("trying to UPDATE post with postId={}", id);
            model.update(id, post);
            MEGALOG.info("post with postId={} was updated", id);
            return Response.ok().build();
        } catch (RuntimeException e) {
            return Response.serverError().entity("Error updating post").build();
        }
    }

}
