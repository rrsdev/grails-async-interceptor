package secured.async

import org.slf4j.MDC

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

class LogContextFilter implements Filter
{
    void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
        try {

            MDC.put('request-id', UUID.randomUUID().toString());
            HttpSession httpSession = ((HttpServletRequest)req).getSession(false);
            if (httpSession) {
                MDC.put('session-id', httpSession.id);
            }

            fc.doFilter(req, res);

        } finally {

            MDC.clear();

        }

    }

    void init(FilterConfig fc) {/*nothing to do*/}

    void destroy() {/*nothing to do*/}
}
