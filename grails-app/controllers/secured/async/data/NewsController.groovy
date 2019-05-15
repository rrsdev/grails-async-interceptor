package secured.async.data

import grails.async.web.WebPromises
import secured.async.NewsStreamService

class NewsController {

	static responseFormats = ['json']

    static namespace = "data"

    NewsStreamService newsStreamService
	
    def index() {
        WebPromises.task({

            def news = newsStreamService.getNews(false);

            render(view:'/news/news', model: [news: news]);

        });
    }

}
