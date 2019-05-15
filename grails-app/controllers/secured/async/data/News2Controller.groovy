package secured.async.data

import grails.async.web.WebPromises
import secured.async.NewsStreamService

class News2Controller
{

	static responseFormats = ['json']

    static namespace = "data"

    NewsStreamService newsStreamService

    def index() {

        def news = newsStreamService.getNews(false);

        render(view:'/news/news', model: [news: news]);

    }

}
