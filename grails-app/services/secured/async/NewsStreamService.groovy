package secured.async

import grails.gorm.transactions.Transactional

@Transactional
class NewsStreamService {

    News getNews(boolean isAdmin) {

        if (isAdmin) {
            return getAdminNews();
        } else {
            return getPublicNews();
        }

    }

    private News getAdminNews() {

        // grab data from internal web-service
        sleep(5000)

        return new News(
            items: [
                new NewsItem(
                    title: 'abc',
                    authors: [1],
                    body: '<div>abc-abc-abc</div>'
                ),
                new NewsItem(
                    title: 'def',
                    authors: [3],
                    body: '<div>def-def-def</div>'
                ),
                new NewsItem(
                    title: 'ghi',
                    authors: [1,2],
                    body: '<div>ghi-ghi-ghi</div>'
                )
            ]
        );
    }

    private News getPublicNews() {

        // grab data from internal web-service
        sleep(2000)

        return new News(
            items: [
                new NewsItem(
                    title: 'abc',
                    body: '<div>abc-abc-abc</div>'
                ),
                new NewsItem(
                    title: 'def',
                    body: '<div>def-def-def</div>'
                ),
                new NewsItem(
                    title: 'ghi',
                    body: '<div>ghi-ghi-ghi</div>'
                )
            ]
        );
    }
}
