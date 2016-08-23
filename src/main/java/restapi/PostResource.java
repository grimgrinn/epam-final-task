package restapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.WallPost;
import model.WallPostModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    final Logger MEGALOG = LogManager.getLogger(PostResource.class);


    @GET
    @Path("/test")
    public Response getTest(){

        String test = "just get test";

        try{
            String json = toJson(test);
            return Response.ok(json).build();
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deletePostById(@PathParam("id") int id){
        WallPostModel model = new WallPostModel();

        try {
            MEGALOG.info("trying to DELETE post with postId={}", id);
            model.delete(id);
            MEGALOG.info("post with postId={} was deleted", id);
            return Response.ok().build();
        } catch (RuntimeException e) {
            return Response.serverError().entity("Error deleting post").build();
        }
    }

    @PUT
    @Path("/update/{id}")
    public Response updatePostById(@PathParam("id") int id, @FormParam("post") String post) {
        WallPostModel model = new WallPostModel();

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
