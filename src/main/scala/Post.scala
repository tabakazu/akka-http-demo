import slick.driver.PostgresDriver.api._

case class Post(title: String, body: String)

class Posts(tag: Tag) extends Table[(Int, String, String)](tag, "posts") {
  def id = column[Int]("id", O.PrimaryKey)
  def title = column[String]("title")
  def body = column[String]("body")
  def * = (id, title, body)
}
