package controllers

import play.api.mvc.{Action, Controller}

object DevNull extends Controller {
  def index = Action {
    Ok
  }
}
