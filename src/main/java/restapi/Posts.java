package restapi;

/**
 * Created by Например Андрей on 21.08.2016.
 */
public class Posts {

    @PUT
    @Path("/update")
    @Consumes(APPLICATION_JSON)
    public Response updatePostById(Post post) {

        if (!getSessionUserOpt(request.getSession()).isPresent()) {
            log.warn("No user session found. Cannot add like");
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("User is not signedup").build();
        }

        try {
            log.info("trying to UPDATE post with postId={}", post.getId());
            postDAO.update(post);
            log.info("post with postId={} was updated", post.getId());
            return Response.ok().build();
        } catch (RuntimeException e) {
            return Response.serverError().entity("Error updating post").build();
        }
    }

}
