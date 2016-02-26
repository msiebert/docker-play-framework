package controllers

import play.api.mvc.{Action, Controller}
import scala.util.Random

object DevNull extends Controller {
  private[this] val rand = new Random
  private[this] val failures = Seq(BadRequest, Forbidden, InternalServerError)

  def index = Action {
    if (rand.nextInt(100) > 25) {
      Ok
    } else {
      rand.shuffle(failures).head
    }
  }
}
