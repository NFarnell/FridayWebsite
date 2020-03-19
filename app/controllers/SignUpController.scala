package controllers
import javax.inject.Inject
import models.SignUpDetails
import play.api.mvc._


class SignUpController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport {
  def signUp(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.signup(SignUpDetails.SignUpForm))
  }

  def signUpSubmit(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    SignUpDetails.SignUpForm.bindFromRequest.fold({ formWithErrors =>
      BadRequest(views.html.signup(formWithErrors))
    }, { signUpDetails =>
        SignUpDetails.addUser(signUpDetails)
        Redirect(routes.HomeController.subscribe()).withSession(request.session + ("username" -> signUpDetails.username))
    })
  }

}
