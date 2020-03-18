package controllers

import authentication.AuthenticationAction
import javax.inject._
import play.api.mvc._


class HomeController @Inject()(cc: ControllerComponents, authAction: AuthenticationAction) extends AbstractController(cc) {

  def index: Action[AnyContent] = authAction {
    Ok(views.html.index("Your new application is ready."))
  }
  def home()  = Action   {
    Ok(views.html.home("something"))
  }
  def subscribe()  = Action   {
    Ok(views.html.subscribe("something"))
  }

}
