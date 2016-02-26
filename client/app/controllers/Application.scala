package controllers

import play.api.Logger
import play.api.mvc.{Action, Controller}
import scalaj.http._

object Application extends Controller {
  private[this] val logger = Logger(this.getClass)

  def index = Action {
    Ok(views.html.index())
  }

  def post = Action { request =>
    val text = request.body.asFormUrlEncoded.get("text")(0)
    try {
      val responseCode = Http("http://dev-null:9000/").postForm(Seq("text" -> text)).asString.code

      // yeah, I know it's not RESTful...
      if (responseCode != 200) {
        InternalServerError(responseCode.toString)
      } else {
        Ok
      }
    } catch {
      case e: Throwable =>
        logger.error("error while making request to dev-null", e)
        InternalServerError("DOCKER_FAIL")
    }
  }
}
