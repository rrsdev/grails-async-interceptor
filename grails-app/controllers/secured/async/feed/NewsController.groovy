package secured.async.feed

import grails.async.web.WebPromises
import secured.async.NewsStreamService

class NewsController {

	static responseFormats = ['json']

    static namespace = "feed"

    NewsStreamService newsStreamService
	
    def index() {
        WebPromises.task({

            def news = newsStreamService.getNews(false);

            render(view:'/news/news', model: [news: news]);

        });
    }

}
