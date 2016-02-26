package controllers

import play.api.mvc.{Action, Controller}
import scalaj.http._

object Application extends Controller {
  def index = Action {
    Ok(views.html.index())
  }

  def post = Action { request =>
    val text = request.body.asFormUrlEncoded.get("text")(0)
    try {
      val responseCode = Http("dev-null:9000/").postForm(Seq("text" -> text)).asString.code

      // yeah, I know it's not RESTful...
      if (responseCode != 200) {
        InternalServerError(responseCode.toString)
      } else {
        Ok
      }
    } catch {
      case _ : Throwable => InternalServerError("DOCKER_FAIL")
    }
  }
}
