// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'secured.async.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'secured.async.UserRole'
grails.plugin.springsecurity.authority.className = 'secured.async.Role'

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
    [pattern: '/api/login',          access: ['permitAll']],
    [pattern: '/oauth/access_token',          access: ['permitAll']],
    [pattern: '/error',          access: ['permitAll']],
    [pattern: '/error/**',          access: ['permitAll']],
    [pattern: '/shutdown',       access: ['permitAll']],
    [pattern: '/application',          access: ['permitAll']],
    [pattern: '/application/**',          access: ['permitAll']],
    [pattern: '/data/**',       access: ['permitAll']],
    [pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [

    [pattern: '/application/**',      filters: 'none'],
    [pattern: '/error',      filters: 'none'],
    [pattern: '/error/**',      filters: 'none'],
    [pattern: '/data/**',      filters: 'none'],
    [pattern: '/**/favicon.ico', filters: 'none'],

    //Stateless chain
    [
        pattern: '/**',
        filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
    ],

    //Traditional, stateful chain
    [
                pattern: '/stateful/**',
                filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'
    ]
]

grails.plugin.springsecurity.rest.login.endpointUrl = '/api/login'
grails.plugin.springsecurity.rest.token.generation.jwt.issuer = 'MyWebApp'
grails.plugin.springsecurity.rest.token.storage.jwt.secret = 'rKLnj^!`*7qhtINi.|mmTU|wpkz7ELSK+rNd'
grails.plugin.springsecurity.rest.token.storage.jwt.expiration = 7200	// should be 2 hours