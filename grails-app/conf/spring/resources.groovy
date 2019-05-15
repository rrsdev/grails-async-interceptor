import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.core.Ordered
import secured.async.LogContextFilter
import secured.async.UserPasswordEncoderListener

// Place your Spring DSL code here
beans = {

    //userPasswordEncoderListener(UserPasswordEncoderListener)

    logContextFilter(FilterRegistrationBean) {
        filter = bean(LogContextFilter)
        urlPatterns = ['/*']
        order = Ordered.HIGHEST_PRECEDENCE + 25
    }
}
