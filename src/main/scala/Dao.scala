import scala.concurrent._
import scala.concurrent.duration.Duration
import slick.driver.PostgresDriver.api._

trait Dao {
  val db = Database.forConfig("mydb")
  val posts = TableQuery[Posts]

  def createPost(post: Post) = {
    val query = posts.map(p => (p.title, p.body))
    db.run(query += (post.title, post.body))
  }

  def getPosts(o: Option[String]) = {
    val query = o match {
      case Some(title) => posts.filter{ _.title === title}.result
      case None => posts.sortBy(_.id.desc).result
    }
    val result = Await.result(db.run(query), Duration.Inf)
    if(result.size != 0) Some(result) else None
  }

  def getPost(id: Int) = {
    val query = posts.filter{_.id === id}.result
    val result = Await.result(db.run(query), Duration.Inf)
    if(result.size != 0) Some(result) else None
  }

  def updatePost(id: Int, post: Post) = {
    val query = posts.filter(_.id === id).map(p => (p.title, p.body))
    db.run(query.update((post.title, post.body)))
  }

  def deletePost(id: Int) = {
    val query = posts.filter(_.id === id).delete
    db.run(query)
  }
}
