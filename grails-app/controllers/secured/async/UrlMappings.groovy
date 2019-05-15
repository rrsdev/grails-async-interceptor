package secured.async

class UrlMappings {

    static mappings = {

        "500"(view:'/error')
        "500"(view:'/error', exception: Exception)
        "500"(view:'/error', exception: Throwable)
        "404"(view:'/notFound')
        "/error"(view:'/error')

        get "/application(.$format)?"(controller: 'application', action:"index")

        get "/$namespace/$controller(.$format)?"(action:"index")
        get "/$namespace/$controller/$id(.$format)?"(action:"show")
        post "/$namespace/$controller(.$format)?"(action:"save")
        put "/$namespace/$controller/$id(.$format)?"(action:"update")
        patch "/$namespace/$controller/$id(.$format)?"(action:"patch")
        delete "/$namespace/$controller/$id(.$format)?"(action:"delete")
    }
}
