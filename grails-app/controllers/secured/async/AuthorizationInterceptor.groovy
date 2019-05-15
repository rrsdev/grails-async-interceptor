package secured.async

class AuthorizationInterceptor
{
    AuthorizationInterceptor()
    {
        match(namespace:'data')
    }

    boolean before()
    {
        // Use some simple logic to vet the proces, including ensuring reCAPTCHA on certain paths
        log.debug('AuthorizationInterceptor before(), [{}]', request?.requestURL);
        return true;
    }

    boolean after() {
        log.debug('AuthorizationInterceptor after(), [{}]', request?.requestURL);
        return true;
    }

    void afterView() {
        // no-op
    }

}
