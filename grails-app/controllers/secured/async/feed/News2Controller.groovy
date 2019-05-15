package secured.async.feed


import secured.async.NewsStreamService

class News2Controller
{

	static responseFormats = ['json']

    static namespace = "feed"

    NewsStreamService newsStreamService

    def index() {

        def news = newsStreamService.getNews(false);

        render(view:'/news/news', model: [news: news]);

    }

}
