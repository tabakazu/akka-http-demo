import spray.json.DefaultJsonProtocol
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._

trait Routes extends DefaultJsonProtocol with SprayJsonSupport with Dao {

  implicit val postFormats = jsonFormat2(Post)

  val routes =
    pathPrefix("posts") {
      pathEnd {
        get {
          parameter('title.?) { title =>
            getPosts(title) match {
              case Some(post) => complete(post)
              case None => complete("not post")
            }
          }
        } ~
        post {
          entity(as[Post]) { post =>
            createPost(post)
            complete("blog_top post")
          }
        }
      } ~
      path(IntNumber) { id =>
        get {
          getPost(id) match {
            case Some(post) => complete(post)
            case None => complete("not post")
          }
        } ~
        put {
          entity(as[Post]) { post =>
            updatePost(id, post)
            complete(s"blog_$id update")
          }
        } ~
        delete {
          deletePost(id)
          complete(s"blog_$id delete")
        }
      }
    }
  //<-- routes -->
}
